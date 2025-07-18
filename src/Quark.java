import org.objectweb.asm.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiFunction;


//used to store the fields for the structs
class FieldInfo {
    String name;
    String descriptor;
    FieldInfo(String name, String descriptor) {
        this.name = name;
        this.descriptor = descriptor;
    }
}

public class Quark extends QuarkBaseVisitor<TypedValue> {
    private static Set<String> STANDARDLIBRARY = Set.of();
    //function Id is a special and unique type of Id that is generated in the following way
    //moduleName:functionName:descriptorWithoutReturnType
    //the map stores the functionReturnTypes stores the functionId -> return Type where Type is a ASM type
    Map<String , Type> functionReturnTypes = new HashMap<>();
    private Scope scope;
    Map<MethodVisitor , Scope> scopes = new HashMap<>();

    //store all the imports
    private final Set<String> imports = new HashSet<>();

    private final ClassWriter cw;
    private final MethodVisitor mainVisitor;
    private MethodVisitor currentMethodVisitor;
    private Scope global;
    private final String className;
    final ErrorCollector errorCollector = new ErrorCollector();
    private final DynamicLoader classLoader = new DynamicLoader();
    private final Map<String,Class<?>> structMap = new HashMap<>(); //stores the class name and class which is loaded dynamically
    private final Map<String,String> structVarMap = new HashMap<>();
    private final Map<String,ArrayList<FieldInfo>> structFieldOrder = new HashMap<>(); // this stores the fields in order according to the class name fieldinfo itself stores the name and its descriptor

    private final String path;
    private final Deque<Label> startOfLoops = new ArrayDeque<>(); //store all the start of the loops
    private final Deque<Label> endOfLoops = new ArrayDeque<>(); //store all the ends of the loop

    //used to distinguish between a pattern matching Id visit vs a normal id visit , ispattermmatch will be true if the expression is visited for a pattern match and will toggle the matched boolean to true or false
    private boolean  isPatternMatchMode = false;
    private boolean patternMatchedExitingVar = false;
    private boolean isPatternMatchModeVariable = false;
    private String patternMatchedVariableName = "default";


    private final Map<String, Integer> intOpcodes = Map.of(
            "+", Opcodes.IADD,
            "-", Opcodes.ISUB,
            "*", Opcodes.IMUL,
            "/", Opcodes.IDIV,
            "%", Opcodes.IREM
    );
    private final Map<String, BiFunction<Integer, Integer, Integer>> intOps = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b,
            "%", (a, b) -> a % b
    );

    private final Map<String, Integer> invertedOps = Map.of(
            "==", Opcodes.IF_ICMPNE,
            "!=", Opcodes.IF_ICMPEQ,
            "<", Opcodes.IF_ICMPGE,
            "<=", Opcodes.IF_ICMPGT,
            ">", Opcodes.IF_ICMPLE,
            ">=", Opcodes.IF_ICMPLT
    );

    private final Map<String, Integer> relationalOps = Map.of(
            "<", Opcodes.IF_ICMPLT,
            "<=", Opcodes.IF_ICMPLE,
            ">", Opcodes.IF_ICMPGT,
            ">=", Opcodes.IF_ICMPGE,
            "==",Opcodes.IF_ICMPEQ,
            "!=",Opcodes.IF_ICMPNE
    );
    private final Map<String , Type> javaType = Map.of(
            "int" , Type.INT_TYPE,
            "bool" , Type.BOOLEAN_TYPE,
            "String", Type.getType(String.class),
            "string", Type.getType(String.class),
            "void" , Type.VOID_TYPE
    );
    private final Map<Type , String> stringType = Map.of(
            Type.INT_TYPE, "int" ,
             Type.BOOLEAN_TYPE, "bool" ,
             Type.getType(String.class), "string",
             Type.VOID_TYPE , "void",
            Type.DOUBLE_TYPE, "double"
    );


    public Quark(ClassWriter cw, MethodVisitor mainVisitor, MethodVisitor currentMethodVisitor , String className, String path , Set<String> STANDARDLIBRARY) {
        this.cw = cw;
        this.mainVisitor = mainVisitor;
        this.currentMethodVisitor = currentMethodVisitor;
        this.className = className;
        this.path = path;
        this.STANDARDLIBRARY = STANDARDLIBRARY;
        //scopes.put();
        scope = new Scope();
        scopes.put(mainVisitor , scope);
    }
    public void pushStoreInsAndUpdateSlot(TypedValue.Type type , int slot){
        if (type == TypedValue.Type.INT) {
            currentMethodVisitor.visitVarInsn(Opcodes.ISTORE, slot);
            slot++;
        } else if (type == TypedValue.Type.STRING) {
            currentMethodVisitor.visitVarInsn(Opcodes.ASTORE, slot);
            slot++;
        } else if (type == TypedValue.Type.BOOL) { //the value will already be loaded for bull
            currentMethodVisitor.visitVarInsn(Opcodes.ISTORE, slot);
            slot++;
        }else if (type == TypedValue.Type.DOUBLE){
            currentMethodVisitor.visitVarInsn(Opcodes.DSTORE, slot);
            slot+=2; //two for the slot
        }
    }
    public void updateStoreIns(TypedValue.Type type , int slot){
        if (type == TypedValue.Type.INT) {
            currentMethodVisitor.visitVarInsn(Opcodes.ISTORE, slot);
        } else if (type == TypedValue.Type.STRING) {
            currentMethodVisitor.visitVarInsn(Opcodes.ASTORE, slot);
        } else if (type == TypedValue.Type.BOOL) { //the value will already be loaded for bull
            currentMethodVisitor.visitVarInsn(Opcodes.ISTORE, slot);
        }else if (type == TypedValue.Type.DOUBLE){
            currentMethodVisitor.visitVarInsn(Opcodes.DSTORE, slot);
        }
    }
    @Override
    public TypedValue visitAssigstat(QuarkParser.AssigstatContext ctx) {
        //check if its assigment or decleration
        TypedValue type;
        if(ctx.TYPE() == null){ //assigment
            String name = ctx.ID().getText();
            if( !scope.containsKey(name)){
                errorCollector.addError( ctx , "Not recognized '" + name + "'");
                return TypedValue.voidtype();
            }
            if(scope.isConstant(name)){
                errorCollector.addError(ctx , "cannot update '"+ name +"' declared as a constant ");
                return TypedValue.voidtype();
            }
            VarInfo info = scope.getVariable(name);
            int slot = info.slot;
            type = visit(ctx.expr()); //this loads the value onto the stack
            //now just store it in the alrady given slot basically
            updateStoreIns(type.type , slot);
        }
        else{ //declaration
            String id = ctx.ID().getText();
            String definedType = ctx.TYPE().getText();
            if(definedType.equals("const")){ //constant declartion
                isPatternMatchMode = false; // throw an error since there is no matching to be done
                type = visit(ctx.expr());
                VarInfo constInfo = VarInfo.constant(type.value , type.type);

                //check if the id already exists in scope
                if(scope.containsKey(id)){
                    errorCollector.addError(ctx,"variable '"+ id +"' already declared");
                    return TypedValue.voidtype();
                }
                scope.putConstant(id , constInfo);
            }else{ //other types , verify the types and push add the value to scope
                type = visit(ctx.expr());
                pushStoreInsAndUpdateSlot(type.type , scope.getLastSlot());
                //convert this to java bytecode
                if (!TypedValue.typeString(type.type).equals(definedType)) {
                    errorCollector.addError(ctx , "cannot assign " + TypedValue.typeString(type.type) + " to an " + definedType);
                    return TypedValue.unknowntype();
                }
                TypedValue.Type varType = TypedValue.stringType(ctx.TYPE().getText());
                VarInfo variableInfo = VarInfo.variable(scope.getLastSlot() , varType);
                scope.putVariable(id,variableInfo);
            }
        }
        return type;
    }

    @Override
    public TypedValue visitEqualityexpr(QuarkParser.EqualityexprContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.relationalexpr(0));
        }
        TypedValue left = visit(ctx.relationalexpr(0));
        TypedValue right = visit(ctx.relationalexpr(1));
        if (left.type != right.type) {
            errorCollector.addError(ctx , "Cannot equate" + TypedValue.typeString(left.type) + " to " + TypedValue.typeString(right.type));
            return TypedValue.unknowntype();
        }
        String op = ctx.getChild(1).getText();
        Label truelabel = new Label();
        Label endlabel = new Label();
        if (op.equals("==")) {
            currentMethodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, truelabel); //equal
        } else if (op.equals("!=")) {
            currentMethodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, truelabel); //noequal
        } else {
            errorCollector.addError(ctx , "Unknown operation");
            return TypedValue.unknowntype();
        }
        currentMethodVisitor.visitInsn(Opcodes.ICONST_0);
        currentMethodVisitor.visitJumpInsn(Opcodes.GOTO, endlabel);
        currentMethodVisitor.visitLabel(truelabel);
        currentMethodVisitor.visitInsn(Opcodes.ICONST_1);
        currentMethodVisitor.visitLabel(endlabel);
        return new TypedValue(TypedValue.Type.BOOL, null);
    }

    @Override
    public TypedValue visitRelationalexpr(QuarkParser.RelationalexprContext ctx) {
        if (ctx.getChildCount() == 1) {//just an value
            return visit(ctx.addexpr(0));
        }
        TypedValue left = visit(ctx.addexpr(0));
        TypedValue right = visit(ctx.addexpr(1));
        String op = ctx.getChild(1).getText();
        Integer opcode = relationalOps.get(op);
        if (opcode == null) {
            errorCollector.addError(ctx , "Unknown relational operator");
            return TypedValue.unknowntype();
        }
        Label trueLabel = new Label();
        Label endLabel = new Label();

        currentMethodVisitor.visitJumpInsn(opcode, trueLabel);
        currentMethodVisitor.visitInsn(Opcodes.ICONST_0);
        currentMethodVisitor.visitJumpInsn(Opcodes.GOTO, endLabel);

        currentMethodVisitor.visitLabel(trueLabel);
        currentMethodVisitor.visitInsn(Opcodes.ICONST_1);

        currentMethodVisitor.visitLabel(endLabel);
        return new TypedValue(TypedValue.Type.BOOL, null);
    }

    public TypedValue visitEqualityexprForIf(QuarkParser.EqualityexprContext ctx, Label endLabel) { //endLabel is changed in the if visitor to point after the end of the if block
        // use asCondition to choose whether to emit a conditional jump or a push boolean


        if (ctx.getChildCount() == 1) {
            var relationalExprCtx = ctx.relationalexpr(0);
            TypedValue type = visitRelationalExprForIf(relationalExprCtx, endLabel);
            return type;
        }
        TypedValue left = visit(ctx.relationalexpr(0));
        TypedValue right = visit(ctx.relationalexpr(1));
        if (left.type != right.type) {
            errorCollector.addError(ctx , "Cannot equate" + TypedValue.typeString(left.type) + " to " + TypedValue.typeString(right.type));
            return TypedValue.unknowntype();
        }
        String op = ctx.getChild(1).getText();
        currentMethodVisitor.visitJumpInsn(invertedOps.get(op), endLabel);
        return new TypedValue(TypedValue.Type.UNKNOWN, null);
    }
    public TypedValue visitRelationalExprForIf(QuarkParser.RelationalexprContext ctx, Label endlabel) {
        if (ctx.getChildCount() == 1) {
            //TODO: Idk what to do to be honest
        }
        TypedValue left = visit(ctx.addexpr(0));
        TypedValue right = visit(ctx.addexpr(1));
        String op = ctx.getChild(1).getText();
        Integer opcode = invertedOps.get(op);
        if (left.type != right.type) {
            errorCollector.addError(ctx , "Cannot equate" + TypedValue.typeString(left.type) + " to " + TypedValue.typeString(right.type));
            return TypedValue.unknowntype();
        }
        currentMethodVisitor.visitJumpInsn(opcode, endlabel);
        return new TypedValue(TypedValue.Type.UNKNOWN, null);
    }

    @Override
    public TypedValue visitAddexpr(QuarkParser.AddexprContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.mulexpr());
        }
        TypedValue type1 = visit(ctx.addexpr());
        TypedValue type2 = visit(ctx.mulexpr());
        String op = ctx.getChild(1).getText();

        if (type1.type != type2.type && type1.type == TypedValue.Type.INT) {
            errorCollector.addError(ctx , "Cannot equate" + TypedValue.typeString(type1.type) + " to " + TypedValue.typeString(type2.type));
            return TypedValue.unknowntype();
        }
        //push the operation onto the stack
        //possible notifies whether we can calculate the values of type1 and type2 (none of them are returned as null
        if (intOpcodes.containsKey(op))
            currentMethodVisitor.visitInsn(intOpcodes.get(op));
        else{
            errorCollector.addError(ctx , "Unknown operation");
            return TypedValue.unknowntype();
        }
        boolean valueKnown = type1.value != null && type2.value != null;
        if (valueKnown) {
            BiFunction<Integer, Integer, Integer> operation = intOps.get(op);
            int value = operation.apply((Integer) type1.value, (Integer) type2.value);
            return new TypedValue(TypedValue.Type.INT, value);
        }
        return new TypedValue(TypedValue.Type.INT, null);
    }

    @Override
    public TypedValue visitMulexpr(QuarkParser.MulexprContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.fieldaccess(0));
        }
        TypedValue type1 = visit(ctx.fieldaccess(0));
        TypedValue type2 = visit(ctx.fieldaccess(1));
        String op = ctx.getChild(1).getText();

        if (type1.type != type2.type && type1.type == TypedValue.Type.INT) {
            errorCollector.addError(ctx , "Cannot perform " + TypedValue.typeString(type1.type) + " " + op + TypedValue.typeString(type2.type) );
            return TypedValue.unknowntype();
        }
        //push the operation onto the stack
        //possible notifies whether we can calculate the values of type1 and type2 (none of them are returned as null
        if (intOpcodes.containsKey(op))
            currentMethodVisitor.visitInsn(intOpcodes.get(op));
        else{
            errorCollector.addError(ctx , "Unknown operation");
            return TypedValue.unknowntype();
        }
        boolean valueKnown = type1.value != null && type2.value != null;
        if (valueKnown) {
            BiFunction<Integer, Integer, Integer> operation = intOps.get(op);
            int value = operation.apply((Integer) type1.value, (Integer) type2.value);
            return new TypedValue(TypedValue.Type.INT, value);
        }
        return new TypedValue(TypedValue.Type.INT, null);
    }

    @Override
    public TypedValue visitFieldaccess(QuarkParser.FieldaccessContext ctx) {
        if(ctx.access().ID().isEmpty()){ //check if the access is empty , meaning its an normal literal without involement of any structs
            return visit(ctx.unaryExpr());
        }
        return TypedValue.voidtype();
    }

    @Override
    public TypedValue visitUnaryExpr(QuarkParser.UnaryExprContext ctx) {
        if(ctx.neg != null || ctx.pos != null){
            var type = visit(ctx.unaryExpr());
            if(ctx.neg != null){
                if(type.type == TypedValue.Type.INT){
                    currentMethodVisitor.visitInsn(Opcodes.INEG);
                    return type;
                }
                if(type.type == TypedValue.Type.DOUBLE){
                    currentMethodVisitor.visitInsn(Opcodes.DNEG);
                    return type;
                }
                errorCollector.addError(ctx,"operation not defined");
                return TypedValue.voidtype();
            }
            return type;
        }else{
            return visit(ctx.atom());
        }
    }

    @Override
    public TypedValue visitAtom(QuarkParser.AtomContext ctx) {
        if (ctx.INT() != null) {
            int value = Integer.parseInt(ctx.INT().getText());
            currentMethodVisitor.visitLdcInsn(value);
            return new TypedValue(TypedValue.Type.INT, value);
        }
        if (ctx.STRING() != null) {
            String str = ctx.STRING().getText();
            str = str.substring(1, str.length() - 1);
            currentMethodVisitor.visitLdcInsn(str);
            return new TypedValue(TypedValue.Type.STRING, str);
        } else if (ctx.ID() != null) {
            isPatternMatchModeVariable = true;
            String id = ctx.ID().getText();
            //check for local variable
            if (scope.containsKey(id)) {
                VarInfo info = scope.getVariable(id);
                LoadInstr.LoadVariable(currentMethodVisitor , info);
                patternMatchedExitingVar = true;
                return new TypedValue(info.type, null , id);
            }
            //check for struct
            if(scope.containsStruct(id)){
                //if it exits , load the struct onto the stack , for either printing or using it further somewhere
                var info = scope.getStructInfo(id);
                LoadInstr.LoadStruct(currentMethodVisitor, info);
                patternMatchedExitingVar = true;
                return new TypedValue(TypedValue.Type.STRUCT, null , info.name); //return the struct name as id in the type
            }

            //dintinguish between pattern matching visits

            if(isPatternMatchMode){
                patternMatchedExitingVar = false; //doesnt exist also no need to throw error
                patternMatchedVariableName = id; // update the name since it will be used in the patterm matcher to bind
            }else{
                errorCollector.addError( ctx , "Not recognized '" + ctx.ID() + "'");
            }

            return TypedValue.unknowntype();

        } else if (ctx.TRUE() != null) {
            currentMethodVisitor.visitInsn(Opcodes.ICONST_1);
            return new TypedValue(TypedValue.Type.BOOL,true);
        } else if (ctx.FALSE() != null) {
            currentMethodVisitor.visitInsn(Opcodes.ICONST_0);
            return new TypedValue(TypedValue.Type.BOOL,false);
        }else if(ctx.funccall() != null){
            return visitFunccall(ctx.funccall());
        }else if(ctx.DOUBLE() != null){
            String text = ctx.DOUBLE().getText();
            double value = Double.parseDouble(text);
            currentMethodVisitor.visitLdcInsn(value);
            return new TypedValue(TypedValue.Type.DOUBLE , value);
        }
        return visit(ctx.expr());
    }

    @Override
    public TypedValue visitPrintstat(QuarkParser.PrintstatContext ctx) {
        //replace with the jvm instruction to load the print class
        currentMethodVisitor.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
        TypedValue type = visit(ctx.expr());
        if(type.type == TypedValue.Type.INT){
            currentMethodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/io/PrintStream","println","(I)V");
        }else if( type.type == TypedValue.Type.STRING){
            currentMethodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/io/PrintStream","println","(Ljava/lang/Object;)V");
        }else if(type.type == TypedValue.Type.BOOL){
            currentMethodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/io/PrintStream","println","(Z)V");
        }else if(type.type == TypedValue.Type.STRUCT){
            //invoke the tostring() on the object that is loaded after the visit
            currentMethodVisitor.visitMethodInsn(
                    Opcodes.INVOKEVIRTUAL,
                    type.id, // internal name like "point"
                    "toString",
                    "()Ljava/lang/String;"
            );

            currentMethodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        }else if(type.type == TypedValue.Type.DOUBLE){
            currentMethodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V");
        }
        return type;
    }
    @Override
    public TypedValue visitIfstatement(QuarkParser.IfstatementContext ctx) {
        //manually bruteforce till the expr context for now
        var eq = ctx.expr().equalityexpr();
        Label elseLabel =  new Label();
        Label endLabel = new Label();
        TypedValue type = visitEqualityexprForIf(eq , elseLabel);
        visit(ctx.block(0));
        currentMethodVisitor.visitJumpInsn(Opcodes.GOTO,endLabel);
        //check if else statement exists
        currentMethodVisitor.visitLabel(elseLabel);
        if(ctx.block().size() > 1){ //true it exists
            visit(ctx.block(1));
        }
        currentMethodVisitor.visitLabel(endLabel);
        //set the endlabel
        return type;
    }
    public TypedValue visitRelationalExprForWhile(QuarkParser.RelationalexprContext ctx , Label endLabel){
        if (ctx.getChildCount() == 1) {
            //TODO: Idk what to do to be honest
        }
        TypedValue left = visit(ctx.addexpr(0));
        TypedValue right = visit(ctx.addexpr(1));
        String op = ctx.getChild(1).getText();
        Integer opcode = invertedOps.get(op);
        if (left.type != right.type) {
            errorCollector.addError(ctx , "Cannot equate" + TypedValue.typeString(left.type) + " to " + TypedValue.typeString(right.type));
            return TypedValue.unknowntype();
        }
        currentMethodVisitor.visitJumpInsn(invertedOps.get(op),endLabel);
        return new TypedValue(TypedValue.Type.UNKNOWN, null);
    }

    public TypedValue visitEqualityExprForWhile(QuarkParser.EqualityexprContext ctx , Label endLabel){
        if(ctx.getChildCount() == 1) {
            var relationalExprCtx = ctx.relationalexpr(0);
            TypedValue type = visitRelationalExprForWhile(relationalExprCtx , endLabel);
            return type;
        }
        TypedValue left = visit(ctx.relationalexpr(0));
        TypedValue right = visit(ctx.relationalexpr(1));
        if (left.type != right.type) {
            errorCollector.addError(ctx , "Cannot equate" + TypedValue.typeString(left.type) + " to " + TypedValue.typeString(right.type));
            return TypedValue.unknowntype();
        }
        String op = ctx.getChild(1).getText();
        currentMethodVisitor.visitJumpInsn(invertedOps.get(op),endLabel);
        return new TypedValue(TypedValue.Type.UNKNOWN, null);
    }

    @Override
    public TypedValue visitWhilestat(QuarkParser.WhilestatContext ctx) {
        Label endLabel = new Label();
        Label startLabel = new Label();

        //push the start and the endlabels on the stack
        endOfLoops.push(endLabel);
        startOfLoops.push(startLabel);

        //set the start label
        currentMethodVisitor.visitLabel(startLabel);

        //add the comparsion opcodes
        var eq = ctx.expr().equalityexpr();
        TypedValue type =  visitEqualityExprForWhile(eq , endLabel);
        visit(ctx.block());

        //add the infinite goto
        currentMethodVisitor.visitJumpInsn(Opcodes.GOTO,startLabel);

        //add the infinite breaker endlabel
        currentMethodVisitor.visitLabel(endLabel);

        //pop them to indicate the end of the loop , if continue is triggered when the stack is empty it will return an error
        endOfLoops.pop();
        startOfLoops.pop();

        return type;
    }

    @Override
    public TypedValue visitContinuestatement(QuarkParser.ContinuestatementContext ctx) {
        if(startOfLoops.size() == 0){ //not in a loop
            errorCollector.addError(ctx,"Cannot continue outside a loop");
            return TypedValue.voidtype();
        }
        currentMethodVisitor.visitJumpInsn(Opcodes.GOTO,startOfLoops.peek());
        return TypedValue.voidtype();
    }

    @Override
    public TypedValue visitBreakstatement(QuarkParser.BreakstatementContext ctx) {
        if(endOfLoops.size() == 0){
            errorCollector.addError(ctx,"Cannot continue outside a loop");
            return TypedValue.voidtype();
        }
        currentMethodVisitor.visitJumpInsn(Opcodes.GOTO,endOfLoops.peek());
        return TypedValue.voidtype();
    }

    public void switchScope(MethodVisitor mv){ //this changes the scope according to a given method visitor
        if(scopes.containsKey(mv)){
            scope = scopes.get(mv);
        }else{
            Scope newScope =  new Scope();
            scopes.put(mv, newScope);
            scope = newScope;
        }
    }
    public String makeFunctionId(String moduleName, String name, String descriptor) {
        // Remove the return type from the descriptor
        int returnStart = descriptor.lastIndexOf(')') + 1;
        String withoutReturn = descriptor.substring(0, returnStart);
        return name + ":" + withoutReturn;
    }

    @Override
    public TypedValue visitFuncdefn(QuarkParser.FuncdefnContext ctx) {
        //collect the argumets defined in the function
        List<Type> paramList = new ArrayList<>();
        if(ctx.paramlist() != null){ //if there are parameters to the function
            var paramListCtx = ctx.paramlist();
            for(var param : paramListCtx.param()){
                String typeName = param.TYPE().getText();
                Type paramType = javaType.get(typeName);
                if (paramType == null) {
                    errorCollector.addError(ctx , "Unknown type " + typeName);
                    return TypedValue.unknowntype();
                }
                //paramList.add(javaType.get( param.TYPE().getText()) ); //add the parameter type to the paramList
                paramList.add(paramType);
            }
        }

        Type[] args = paramList.toArray(new Type[0]); //convert paramlist to the list of arguments

        //get the return type
        TypedValue.Type definedReturnType;
        if(ctx.TYPE() != null){
            definedReturnType = TypedValue.stringType(ctx.TYPE().getText());
        }else{
            definedReturnType = TypedValue.Type.VOID;
        }
        Type definedASMReturnType = TypedValue.TypeTOASMType(definedReturnType);
        String descriptor = Type.getMethodDescriptor(
                definedASMReturnType,
                args
        );

        //register the function before traversing the function since doing it later can cause errors in recursion
        //generate the function Id and also push it to the map of return types
        String functionId = makeFunctionId(className , ctx.ID().getText() , descriptor);
        functionReturnTypes.put(functionId , definedASMReturnType);


        MethodVisitor newMethodVisitor = cw.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, // access flags
                ctx.ID().getText(),                      // method name
                descriptor,                // descriptor (args + return)
                null,                                    // signature (null = not generic)
                null                                     // exceptions (null = none declared)
        );
        newMethodVisitor.visitCode();
        //change the current visitor
        currentMethodVisitor = newMethodVisitor;
        switchScope(currentMethodVisitor);

        //load the parameterised local variables ig
        if(ctx.paramlist() != null){ //if there are parameters to the function
            var paramListCtx = ctx.paramlist();
            for(var param : paramListCtx.param()){
                String name = param.ID().getText();
                String typeStr = param.TYPE().getText();
                VarInfo variableInfo = VarInfo.variable(scope.getLastSlot() , TypedValue.stringType(typeStr));
                scope.putVariable(name , variableInfo);
            }
        }

        //visit the block after changing currentMethodVisitor
        //visit(ctx.block());

        //visit every stat while checking if there exists a return statement and if it does then capture the return type to verify it later
        TypedValue actualReturnType = new TypedValue(TypedValue.Type.VOID , null);
        //try to get the return type
        for(var stat : ctx.block().stat()){
            if(stat.returnstat() != null){
                actualReturnType = visit(stat.returnstat());
            }else{
                visit(stat);
            }
        }

        if(actualReturnType.type != definedReturnType){
            errorCollector.addError(ctx , "Return types did not match for the function '" + ctx.ID().getText() + "()'");
            return TypedValue.unknowntype();
        }

        //reset currentMethodVisitor
        currentMethodVisitor = mainVisitor;
        switchScope(currentMethodVisitor);

        //visit the block
        newMethodVisitor.visitInsn(Opcodes.RETURN); //add the most minimal return

        newMethodVisitor.visitMaxs(0,0); //calculate the stack sizes

        newMethodVisitor.visitEnd();

        return TypedValue.voidtype();
    }

    //used to run the module function call
    public TypedValue visitModuleFuncCall(QuarkParser.FunccallContext ctx){
        String moduleName = ctx.modulename.getText();
        String functionName = ctx.functionname.getText();
        if(!imports.contains(moduleName)){
            errorCollector.addError(ctx , "could not find Module '" + moduleName + "'");
            return TypedValue.voidtype();
        }
        //u have to load the value onto the stack to call the function later on , and also extract it for generate the descriptor
        StringBuilder descriptorBuilder = new StringBuilder("(");
        List<Type> ASMTypeArgs = new ArrayList<>();
        if(ctx.arglist() != null){
            var argList = ctx.arglist();
            for(var argument :argList.expr()){
                TypedValue type = visit(argument);   //visit the argument and get the type
                ASMTypeArgs.add(TypedValue.TypeTOASMType(type.type));
                descriptorBuilder.append(type.getDescriptorFromType());
            }
        }
        descriptorBuilder.append(")");
        String descriptor = descriptorBuilder.toString();
        String functionId = moduleName + ":" +functionName + ":" + descriptor;
        if(!functionReturnTypes.containsKey(functionId)){
            errorCollector.addError(ctx,"No function found " + functionName + "() in Module " + moduleName);
            return TypedValue.voidtype();
        }
        Type returnType = functionReturnTypes.get(functionId);
        Type[] functionArguments = ASMTypeArgs.toArray(new Type[0]);

        //get the descriptor with the return value
        descriptor = Type.getMethodDescriptor(
                returnType,
                functionArguments
        );
        //invoke the method
        currentMethodVisitor.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                moduleName,
                functionName,
                descriptor
        );

        //converting it to string to convert it to TypedValue.Type org.asm.web -> string -> TypedValue.Type
        String strType = stringType.get(returnType);
        return new TypedValue(TypedValue.stringType(strType), null);
    }
    @Override
    public TypedValue visitFunccall(QuarkParser.FunccallContext ctx) {
        //differenitiate between a module function and a normal function
        if(ctx.modulename != null){
            return visitModuleFuncCall(ctx);
        }
        //LOCAL FUNCTION  CALL

        //try to load all the values on the stack before calling the invoke static
        List<Type> argsList= new ArrayList<>();
        if(ctx.arglist() != null){
            var argsCtx = ctx.arglist();
            //get all the expressions from the arglist
            for(var expr : argsCtx.expr()){
                TypedValue type = visit(expr); //laods and returns the type
                String typeString = TypedValue.typeString(type.type);
                argsList.add( javaType.get(typeString));
            }
        }
        //get the array
        Type[] args =  argsList.toArray(new Type[0]);

        String name = ctx.ID(0).getText();

        //get the temporary descriptor with a temporary return value since it wont be used regardless when generating the function ID
        String descriptor = Type.getMethodDescriptor(
                javaType.get("void"),
                args
        );

        //generate the functionId
        String functionId = makeFunctionId(className , name , descriptor);
        if(!functionReturnTypes.containsKey(functionId)){
            errorCollector.addError(ctx , "function not defined '" + name + "()'");
            return TypedValue.unknowntype();
        }
        Type returnType = functionReturnTypes.get(functionId);
        descriptor = Type.getMethodDescriptor(
                returnType,
                args
        );

        currentMethodVisitor.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                className,
                name,
                descriptor
        );
        //converting it to string to convert it to TypedValue.Type org.asm.web -> string -> TypedValue.Type
        String strType = stringType.get(returnType);
        return new TypedValue(TypedValue.stringType(strType), null);
    }

    @Override
    public TypedValue visitReturnstat(QuarkParser.ReturnstatContext ctx) {
        if(ctx.expr() != null){
            TypedValue type = visit(ctx.expr()); //value is now loaded
            if(type.type == TypedValue.Type.INT){
                currentMethodVisitor.visitInsn(Opcodes.IRETURN);
            }else if(type.type == TypedValue.Type.BOOL){
                currentMethodVisitor.visitInsn(Opcodes.IRETURN); //
            }else if(type.type == TypedValue.Type.STRING){
                currentMethodVisitor.visitInsn(Opcodes.ARETURN); //  ref return
            }else{
                errorCollector.addError(ctx , "Unknown value returned");
            }
            return type;
        }else{
            currentMethodVisitor.visitInsn(Opcodes.RETURN); //add the most minimal return
            return TypedValue.voidtype();
        }
    }

    @Override
    public TypedValue visitImportstat(QuarkParser.ImportstatContext ctx) {
        String moduleName = ctx.ID().getText();
        if(imports.contains(moduleName)){
            return TypedValue.voidtype();
        }
        imports.add(moduleName);

        //get the functionId map from the ModuleInfoExtractor
        try {
            Map<String, Type> result;
            if(STANDARDLIBRARY.contains(moduleName)){
                result = ModuleInfoExtractor.extractInfoFromClass(moduleName , true);
            }else{
                result = ModuleInfoExtractor.extractInfoFromClass(moduleName , false);
            }
            functionReturnTypes.putAll(result);
        }catch (Exception e){
            System.err.println("Failed to load class: " + moduleName);
            e.printStackTrace();  // 👈 THIS will print the exact root cause!
            throw new RuntimeException(e);
        }
        return TypedValue.voidtype();
    }

    @Override
    public TypedValue visitDefinestructstat(QuarkParser.DefinestructstatContext ctx) {
        String structName = ctx.ID().getText();
        var fields = ctx.structstats().structfield();
        Map<String , String> fieldTypeMap = new LinkedHashMap<>(); //will store the id and the type
        for(var field : fields){
            String fieldName = field.ID().getText();
            if(fieldTypeMap.containsKey(fieldName)){
                errorCollector.addError(ctx ,"Duplicate field '" + fieldName + "' ");
                continue;
            }
            fieldTypeMap.put(fieldName , field.TYPE().getText());
        }
        byte[] bytecode = generateClassBytecode(structName, fieldTypeMap);
        try {
            Path outputPath = Paths.get(path, structName + ".class");
            Files.write(outputPath, bytecode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Dynamically define it
        Class<?> structClass = classLoader.define(structName, bytecode);
        structMap.put(structName, structClass);

        return TypedValue.voidtype();
    }

    public byte[] generateClassBytecode(String name , Map<String , String> fields){
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, name , null, "java/lang/Object", null);

        //add fields
        List<Type> paramList= new ArrayList<>();
        for(Map.Entry<String , String> entry : fields.entrySet()){
            String signature = TypedValue.getDescriptorFromString(entry.getValue());
            cw.visitField(Opcodes.ACC_PUBLIC , entry.getKey() , signature , null , null).visitEnd();
            paramList.add(javaType.get(entry.getValue()));
        }
        Type[] parms = paramList.toArray(new Type[0]);
        String descriptor = Type.getMethodDescriptor(
                javaType.get("void"),
                parms
        );
        //make the constructor
        MethodVisitor mv = cw.visitMethod(
                Opcodes.ACC_PUBLIC,
                "<init>",
                descriptor,
                null,
                null
        );

        //super()
        mv.visitVarInsn(Opcodes.ALOAD,0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL,"java/lang/Object","<init>" ,"()V");

        int slot = 1;
        ArrayList<FieldInfo> fieldOrder = new ArrayList<>();
        for(Map.Entry<String , String> entry : fields.entrySet()){
            mv.visitVarInsn(Opcodes.ALOAD,0);
            Type type = javaType.get(entry.getValue());
            if (type == Type.INT_TYPE) {
                mv.visitVarInsn(Opcodes.ILOAD, slot);
            } else if (type.equals(Type.getType(String.class))) {
                mv.visitVarInsn(Opcodes.ALOAD, slot);
            } else if (type == Type.BOOLEAN_TYPE) {
                mv.visitVarInsn(Opcodes.ILOAD, slot);
            }else{
                System.out.println("failing silently");
            }
            slot++;
            mv.visitFieldInsn(Opcodes.PUTFIELD, name , entry.getKey(), TypedValue.getDescriptorFromString(entry.getValue()));
            fieldOrder.add( new FieldInfo(entry.getKey() , TypedValue.getDescriptorFromString(entry.getValue()))); //add the fieldinfo struct
        }

        //push the field order according to the struct
        structFieldOrder.put(name , fieldOrder);

        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(-1, -1);
        mv.visitEnd();
        // done with the constructor method

        //write the toString method
        mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "toString", "()Ljava/lang/String;", null, null);

        //StringBuilder sb = new StringBuilder()
        mv.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder");
        mv.visitInsn(Opcodes.DUP);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V");

        //append the struct / class name sb.append(name + "{")
        mv.visitLdcInsn(name + "{ ");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
        List<Map.Entry<String, String>> entries = new ArrayList<>(fields.entrySet());
        for(int i = 0; i < entries.size() ; i++){
            Map.Entry<String,String> entry = entries.get(i);
            String type = entry.getValue();
            String id = entry.getKey();
            String desc = TypedValue.getDescriptorFromString(type);
            //add the field sb.append(" " + id + "=")
            mv.visitLdcInsn(id + "=");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");

            if(type.equals("string")){ //check if its a string and add a "
                mv.visitLdcInsn("\"");
                mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            }
            //append this.id
            mv.visitVarInsn(Opcodes.ALOAD,0); //this
            mv.visitFieldInsn(Opcodes.GETFIELD , name , id , desc);
            String strBuilderDesc = "(" + desc + ")" + "Ljava/lang/StringBuilder;";
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", strBuilderDesc);

            if(type.equals("string")){ //check if its a string and add a "
                mv.visitLdcInsn("\"");
                mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            }

            if(i != entries.size() - 1){
                mv.visitLdcInsn(" , ");
                mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            }
        }
        //sb.append("}")
        mv.visitLdcInsn(" }");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(-1, -1);
        mv.visitEnd();

        cw.visitEnd();
        return cw.toByteArray();
    }

    @Override
    public TypedValue visitDeclarestruct(QuarkParser.DeclarestructContext ctx) {
        String structName = ctx.ID(0).getText();
        String structVarName = ctx.ID(1).getText();

        if(!structMap.containsKey(structName)){
            errorCollector.addError(ctx , "Struct '" + structName + "' not defined");
            return TypedValue.voidtype();
        }

        if(structVarMap.containsKey(structVarName) || scope.containsKey(structVarName)){
            errorCollector.addError(ctx , "Identifier already defined " + structName);
            return TypedValue.voidtype();
        }

        currentMethodVisitor.visitTypeInsn(Opcodes.NEW , structName);
        currentMethodVisitor.visitInsn(Opcodes.DUP);

        if(ctx.arglist() != null){
            var argsCtx = ctx.arglist();
            //get all the expressions from the arglist
            for(var expr : argsCtx.expr()){
                TypedValue type = visit(expr); //laods and returns the type
            }
        }
        Class<?> structclass = structMap.get(structName);
        Constructor<?> onlyctor = structclass.getDeclaredConstructors()[0];
        String descriptor  = Type.getConstructorDescriptor(onlyctor);

        currentMethodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL , structName, "<init>" , descriptor );
        currentMethodVisitor.visitVarInsn(Opcodes.ASTORE , scope.getLastSlot());
        StructInfo info = new StructInfo(scope.getLastSlot() , structName); //store it in the scope for later retrieval
        scope.putStruct(structVarName , info);
        structVarMap.put(structVarName,structName);
        return TypedValue.voidtype();
    }

    @Override
    public TypedValue visitPatternmatchstat(QuarkParser.PatternmatchstatContext ctx) {
        //first differentitate if u are trying to match a literal or a struct
        Label endLabel = new Label();
        String ID= ctx.ID().getText(); //the ID that is supposed to matched
        if(scope.containsStruct(ID)){
            matchStruct(ctx , endLabel);
        }else if(scope.containsKey(ID)){
            VarInfo info = scope.getVariable(ctx.ID().getText());
            matchLiteral(ctx,endLabel);
        }else{
            errorCollector.addError(ctx,"Not recognized '" + ID +"' " );
            return TypedValue.voidtype();
        }
        currentMethodVisitor.visitLabel(endLabel); //visit the endlabel whenever the pattern matches
        return TypedValue.voidtype();
    }

    private TypedValue matchLiteral( QuarkParser.PatternmatchstatContext ctx , Label endLabel) {
        String ID= ctx.ID().getText(); //the ID that is supposed to matched
        VarInfo idInfo = scope.getVariable(ID);
        boolean wildcardMatched = false;
        //pop of the value for easier maintaince , we only push it to the stack when we need it in the arms later on
        for(var arm : ctx.matcharms()){ //loop through each and every match arm and detect if they can be matched
            var pattern = arm.pattern();
            Label nextArmLabel = new Label();
            if(wildcardMatched){
                errorCollector.addWarning(pattern , "This pattern will never be matched because a wildcard '_' arm appears earlier and matches all values.");
                continue;
            }
            if(pattern.isatom != null){
                TypedValue match = visit(pattern.atom());
                if(match == null){
                    System.out.println("how are u null bro? ");
                }
                if(match.type != idInfo.type || match.type == TypedValue.Type.VOID){ //tying to match different data types or is an void data type
                    errorCollector.addWarning(pattern, "Pattern of type '" + TypedValue.typeString(match.type)+ "' will never match value of type '" + TypedValue.typeString(idInfo.type)+ "'.");
                    if(TypedValue.Type.DOUBLE == match.type){
                        currentMethodVisitor.visitInsn(Opcodes.POP2);
                    }else{
                        currentMethodVisitor.visitInsn(Opcodes.POP);
                    }
                    continue;
                }
                else{ //data types are same ,
                    //start by pushing the value to be matched onto the stack
                    LoadInstr.LoadVariable(currentMethodVisitor, idInfo );
                    //emit the comparison instruction and the end label
                    ComparisonInstr.compareNotEqual(currentMethodVisitor , match.type , nextArmLabel);
                    List<QuarkParser.StatContext> stats = arm.matchbody().stat();
                    if(stats.size() == 1){
                        visit(stats.get(0));
                    }else{
                        for(var stat: stats){
                            visit(stat);
                        }
                    }
                    //incase u have executed the above statements goto endlabel since only 1 pattern can be matched
                    currentMethodVisitor.visitJumpInsn(Opcodes.GOTO ,endLabel);
                    //incase u land up here move on to the next arm label
                    currentMethodVisitor.visitLabel(nextArmLabel);
                }
            }
            else if(pattern.istruct != null){
                errorCollector.addWarning(pattern, "Constructor pattern will never match a literal value of type '" + ID + "'.");
                continue;
            }
            else { //wildcard
                wildcardMatched = true;
                List<QuarkParser.StatContext> stats = arm.matchbody().stat();
                if(stats.size() == 1){
                    visit(stats.get(0));
                }else{
                    for(var stat: stats){
                        visit(stat);
                    }
                }
                currentMethodVisitor.visitJumpInsn(Opcodes.GOTO ,endLabel);
            }
        }
        return TypedValue.voidtype();
    }
    public TypedValue.Type mapClassToType(Class<?> clazz) {
        if (clazz == int.class || clazz == Integer.class) {
            return TypedValue.Type.INT;
        } else if (clazz == double.class || clazz == Double.class) {
            return TypedValue.Type.DOUBLE;
        } else if (clazz == boolean.class || clazz == Boolean.class) {
            return TypedValue.Type.BOOL;
        } else if (clazz == String.class) {
            return TypedValue.Type.STRING;
        } else if (clazz == void.class || clazz == Void.class) {
            return TypedValue.Type.VOID;
        } else {
            return TypedValue.Type.STRUCT; // or STRUCT if it's a user-defined class
        }
    }
    public TypedValue matchStruct(QuarkParser.PatternmatchstatContext ctx , Label endLabel){
        String target = ctx.ID().getText();
        String targetStructName = structVarMap.get(target);
        int maxBindingsUsed = 0; //this keeps the track of the maxum bindings used in the arm , we assume the worst case and update the slot accordingly after the pattern matching
        boolean wildcardMatched = false;
        for(var arm : ctx.matcharms()){
            if(wildcardMatched){
                errorCollector.addWarning(arm , "shodowed by wildcard");
                continue;
            }

            Map<String,VarInfo> bindings = new HashMap<>(); //this binds the id name and the field which is to be binded , obv the field is of the classthat isbeing matched
            Label nextArmLabel = new Label();
            var pattern = arm.pattern();
            int localBindings = 0;

            int tempLocalSlot = scope.getLastSlot();

            if(pattern.isatom != null){
                errorCollector.addWarning(pattern, "literal value will never match a constructor");
                continue;
            }
            else if(pattern.istruct != null){
                var structName = pattern.ID().getText();

                if(!structMap.containsKey(structName)){
                    errorCollector.addError(pattern,"Not recoginzed `" + structName +"' ");
                    continue;
                }
                if(!structName.equals(targetStructName)){
                    errorCollector.addWarning(pattern,"struct of type '" + structName + "' will never match struct of type '" + targetStructName+ "'");

                    continue;
                }

                Constructor<?> constructor = structMap.get(targetStructName).getDeclaredConstructors()[0];
                Class<?>[] paramTypes = constructor.getParameterTypes();

                //return error if the size of the parameters of constructor the class i.e the struct and the parameters provided does not match
                if(paramTypes.length != pattern.arglist().expr().size()){
                    errorCollector.addError(pattern,"Error struct '" + structName + "' expects " + paramTypes.length + " no of arguments");
                    return TypedValue.voidtype();
                }
                //loop over all of them 1 by 1
                var args = pattern.arglist();
                var fieldOrder = structFieldOrder.get(targetStructName);
                for(int i = 0 ; i < args.expr().size() ; i++){
                    // will the load the date
                    isPatternMatchMode = true;
                    isPatternMatchModeVariable = false;

                    TypedValue type = visit( args.expr(i) );

                    if(patternMatchedExitingVar || !isPatternMatchModeVariable){ //either its a literal which is its not a variable and if its a variable then it needs to exist in the symbol table to make sure its type can be checked

                        if(!(type.type.equals(mapClassToType(paramTypes[i])))){
                            errorCollector.addError(args.expr(i),"expected '" + TypedValue.typeString(mapClassToType(paramTypes[i]))+ "' found '" + TypedValue.typeString(type.type)+ "' ");
                            return TypedValue.voidtype();
                        }
                        //the first value of the expr is already pushed on the stack
                        //start by pushing the local struct value onto the stack
                        var info  = scope.getStructInfo(target);
                        currentMethodVisitor.visitVarInsn(Opcodes.ALOAD, info.slot);
                        currentMethodVisitor.visitFieldInsn(Opcodes.GETFIELD , targetStructName , fieldOrder.get(i).name , fieldOrder.get(i).descriptor);
                        ComparisonInstr.compareNotEqual(currentMethodVisitor , type.type , nextArmLabel);
                    }
                    else{ //needs to be binded emit the bytecode
                        var info  = scope.getStructInfo(target);
                        currentMethodVisitor.visitVarInsn(Opcodes.ALOAD, info.slot);
                        currentMethodVisitor.visitFieldInsn(Opcodes.GETFIELD , targetStructName , fieldOrder.get(i).name , fieldOrder.get(i).descriptor);
                        var varInfo = VarInfo.variable(
                                tempLocalSlot, //value is null since we do not know it as compile time
                                TypedValue.getTypeFromDescriptor( fieldOrder.get(i).descriptor)
                        );
                        LoadInstr.storeVariable(currentMethodVisitor , varInfo);
                        //update the local slot
                        if(varInfo.type == TypedValue.Type.DOUBLE){ //if the value if double increase the slot by 2
                            tempLocalSlot+=2;
                        }else{
                            tempLocalSlot+=1;
                        }
                        bindings.put(patternMatchedVariableName , varInfo); //to be binded and keep a record
                    }

                }
                //once all the expressions are done , insert the binding variables to the new scope
                var added = scope.pushScopeVars(bindings);
                visit(arm.matchbody()); //visit the actual body with the update scope
                scope.removeScopeVars(added); //remove the added vars and return the scope to its default setting

            }else{ //wildcard matching
                visit(arm.matchbody());
                wildcardMatched = true;
                currentMethodVisitor.visitJumpInsn(Opcodes.GOTO,endLabel);
            }
            System.out.println(bindings);
            maxBindingsUsed = Math.max(maxBindingsUsed , bindings.size()); //update the max binding slot
            currentMethodVisitor.visitJumpInsn(Opcodes.GOTO , endLabel);
            currentMethodVisitor.visitLabel(nextArmLabel);
        }
        return TypedValue.voidtype();
    }
}