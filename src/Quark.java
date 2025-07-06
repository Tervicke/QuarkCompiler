import org.objectweb.asm.*;

import java.util.*;
import java.util.function.BiFunction;

public class Quark extends QuarkBaseVisitor<TypedValue> {
//    Map<String, Integer> memory = new HashMap<>(); //this will store the id to the slot
 //   Map<String, TypedValue.Type> types = new HashMap<>();
    Set<String> functionData = new HashSet<String>(); //this stores the function data and the descriptor in the format funcName:Descriptor
    Map<String , Type> functionReturnTypes = new HashMap<>(); //this stores the functionId (which is name : descriptor without the return type ) and the return Type associated with the function
    private Scope scope;
    Map<MethodVisitor , Scope> scopes = new HashMap<>();

  //  int lastSlot = 0;
    private final ClassWriter cw;
    private final MethodVisitor mainVisitor;
    private MethodVisitor currentMethodVisitor;
    private Scope global;
    private final String className;
    final ErrorCollector errorCollector = new ErrorCollector();

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
            "void" , Type.VOID_TYPE
    );
    private final Map<Type , String> stringType = Map.of(
            Type.INT_TYPE, "int" ,
             Type.BOOLEAN_TYPE, "bool" ,
             Type.getType(String.class), "String",
             Type.VOID_TYPE , "void"
    );

    public Quark(ClassWriter cw, MethodVisitor mainVisitor, MethodVisitor currentMethodVisitor , String className) {
        this.cw = cw;
        this.mainVisitor = mainVisitor;
        this.currentMethodVisitor = currentMethodVisitor;
        this.className = className;
        //scopes.put();
        scope = new Scope();
        scopes.put(mainVisitor , scope);
    }
    /*
    @Override
    public TypedValue visitStat(QuarkParser.StatContext ctx) {
        if (ctx.assigstat() != null) {
            return visit(ctx.assigstat());
        } else if (ctx.printstat() != null) {
            return visit(ctx.printstat());
        } else if (ctx.ifstatement() != null) {
            return visit(ctx.ifstatement());
        }else if(ctx.whilestat() != null){
            return visit(ctx.whilestat());
        }else if()
        return new TypedValue(TypedValue.Type.UNKNOWN, null);
    }
    */
    public void pushStoreIns(TypedValue.Type type , int slot){
        if (type == TypedValue.Type.INT) {
            currentMethodVisitor.visitVarInsn(Opcodes.ISTORE, slot);
        } else if (type == TypedValue.Type.STRING) {
            currentMethodVisitor.visitVarInsn(Opcodes.ASTORE, slot);
        } else if (type == TypedValue.Type.BOOL) { //the value will already be loaded for bull
            currentMethodVisitor.visitVarInsn(Opcodes.ISTORE, slot);
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
            VarInfo info = scope.get(name);
            int slot = info.slot;
            type = visit(ctx.expr()); //this loads the value onto the stack
            //now just store it in the alrady given slot basically
            pushStoreIns(type.type , slot);
        }else{ //declaration
            String id = ctx.ID().getText();
            String definedType = ctx.TYPE().getText();
            type = visit(ctx.expr());
            pushStoreIns(type.type , scope.lastSlot);
            //convert this to java bytecode
            if (!TypedValue.typeString(type.type).equals(definedType)) {
                errorCollector.addError(ctx , "cannot assign " + TypedValue.typeString(type.type) + " to an " + definedType);
                return TypedValue.unknowntype();
            }

            TypedValue.Type varType = TypedValue.stringType(ctx.TYPE().getText());
            VarInfo info = new VarInfo(
                    scope.lastSlot,
                    varType
            );

            scope.put(id,info);
            // memory.put(id, lastSlot);
            scope.lastSlot++; //use the next slot
            // types.put(id, varType);
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
            return visit(ctx.atom());
        }
        TypedValue type1 = visit(ctx.mulexpr());
        TypedValue type2 = visit(ctx.atom());
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
            String id = ctx.ID().getText();
            if (scope.containsKey(id)) {
                VarInfo info = scope.get(id);
                TypedValue.Type type = info.type;
                if (type == TypedValue.Type.INT) { //int
                    currentMethodVisitor.visitVarInsn(Opcodes.ILOAD, info.slot);
                } else if (type == TypedValue.Type.STRING) { //string
                    currentMethodVisitor.visitVarInsn(Opcodes.ALOAD, info.slot);
                } else if (type == TypedValue.Type.BOOL) { //its a bool but it should work just like an int under the hood
                    currentMethodVisitor.visitVarInsn(Opcodes.ILOAD, info.slot);
                }
                //it returns a null because the value is in the jvm slot and cannot be retrieved , one way to solve that problem is obv to maintain another hashmap with its values , seems unreasonable just yet
                return new TypedValue(type, null);
            }
            errorCollector.addError( ctx , "Not recognized '" + ctx.ID() + "'");
            return TypedValue.unknowntype();
        } else if (ctx.TRUE() != null) {
            currentMethodVisitor.visitInsn(Opcodes.ICONST_1);
            return new TypedValue(TypedValue.Type.BOOL,true);
        } else if (ctx.FALSE() != null) {
            currentMethodVisitor.visitInsn(Opcodes.ICONST_0);
            return new TypedValue(TypedValue.Type.BOOL,false);
        }else if(ctx.funccall() != null){
            return visitFunccall(ctx.funccall());
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
        return type;
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
    public String makeFunctionId(String name, String descriptor) {
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
        String functionId = makeFunctionId(ctx.ID().getText() , descriptor);
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
                VarInfo info = new VarInfo(
                        scope.lastSlot,
                        TypedValue.stringType(typeStr)
                );
                scope.put(name , info);
                scope.lastSlot++;
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

    @Override
    public TypedValue visitFunccall(QuarkParser.FunccallContext ctx) {
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

        String name = ctx.ID().getText();

        //get the temporary descriptor with a temporary return value since it wont be used regardless when generating the function ID
        String descriptor = Type.getMethodDescriptor(
                javaType.get("void"),
                args
        );

        //generate the functionId
        String functionId = makeFunctionId(name , descriptor);
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
}