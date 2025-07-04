import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Quark extends QuarkBaseVisitor<TypedValue> {
    Map<String, Integer> memory = new HashMap<>(); //this will store the id to the slot
    Map<String, TypedValue.Type> types = new HashMap<>();

    int lastSlot = 0;
    private final ClassWriter cw;
    private final MethodVisitor mv;
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

    Map<String, Integer> relationalOps = Map.of(
            "<", Opcodes.IF_ICMPLT,
            "<=", Opcodes.IF_ICMPLE,
            ">", Opcodes.IF_ICMPGT,
            ">=", Opcodes.IF_ICMPGE,
            "==",Opcodes.IF_ICMPEQ,
            "!=",Opcodes.IF_ICMPNE
    );

    public Quark(ClassWriter cw, MethodVisitor mv) {
        this.cw = cw;
        this.mv = mv;
    }

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
        }
        return new TypedValue(TypedValue.Type.UNKNOWN, null);
    }
    public void pushStoreIns(TypedValue.Type type , int slot){
        if (type == TypedValue.Type.INT) {
            mv.visitVarInsn(Opcodes.ISTORE, slot);
        } else if (type == TypedValue.Type.STRING) {
            mv.visitVarInsn(Opcodes.ASTORE, slot);
        } else if (type == TypedValue.Type.BOOL) { //the value will already be loaded for bull
            mv.visitVarInsn(Opcodes.ISTORE, slot);
        }
    }
    @Override
    public TypedValue visitAssigstat(QuarkParser.AssigstatContext ctx) {
        //check if its assigment or decleration
        TypedValue type;
        if(ctx.TYPE() == null){ //assigment
            String name = ctx.ID().getText();
            if( !memory.containsKey(name)){
                throw new RuntimeException("Not recognized "+ name);
            }
            int slot = memory.get(name);
            type = visit(ctx.expr()); //this loads the value onto the stack
            //now just store it in the alrady given slot basically
            pushStoreIns(type.type , slot);
        }else{ //declaration
            String id = ctx.ID().getText();
            String definedType = ctx.TYPE().getText();
            type = visit(ctx.expr());
            pushStoreIns(type.type , lastSlot);
            //convert this to java bytecode
            if (!TypedValue.typeString(type.type).equals(definedType)) {
                throw new RuntimeException("cannot assign " + TypedValue.typeString(type.type) + " to an " + definedType);
            }
            memory.put(id, lastSlot);
            lastSlot++; //use the next slot
            TypedValue.Type varType = TypedValue.stringType(ctx.TYPE().getText());
            types.put(id, varType);
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
            throw new RuntimeException("Cannot equate" + TypedValue.typeString(left.type) + " to " + TypedValue.typeString(right.type));
        }
        String op = ctx.getChild(1).getText();
        Label truelabel = new Label();
        Label endlabel = new Label();
        if (op.equals("==")) {
            mv.visitJumpInsn(Opcodes.IF_ICMPEQ, truelabel); //equal
        } else if (op.equals("!=")) {
            mv.visitJumpInsn(Opcodes.IF_ICMPNE, truelabel); //noequal
        } else {
            throw new RuntimeException("unknown operation");
        }
        mv.visitInsn(Opcodes.ICONST_0);
        mv.visitJumpInsn(Opcodes.GOTO, endlabel);
        mv.visitLabel(truelabel);
        mv.visitInsn(Opcodes.ICONST_1);
        mv.visitLabel(endlabel);
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
            throw new RuntimeException("unknown relational operator");
        }
        Label trueLabel = new Label();
        Label endLabel = new Label();

        mv.visitJumpInsn(opcode, trueLabel);
        mv.visitInsn(Opcodes.ICONST_0);
        mv.visitJumpInsn(Opcodes.GOTO, endLabel);

        mv.visitLabel(trueLabel);
        mv.visitInsn(Opcodes.ICONST_1);

        mv.visitLabel(endLabel);
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
            throw new RuntimeException("Cannot equate" + TypedValue.typeString(left.type) + " to " + TypedValue.typeString(right.type));
        }
        String op = ctx.getChild(1).getText();
        mv.visitJumpInsn(invertedOps.get(op), endLabel);
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
            throw new RuntimeException("Cannot equate" + TypedValue.typeString(left.type) + " to " + TypedValue.typeString(right.type));
        }
        mv.visitJumpInsn(opcode, endlabel);
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
            throw new RuntimeException("cannot " + TypedValue.typeString(type1.type) + " " + op + " " + TypedValue.typeString(type2.type));
        }
        //push the operation onto the stack
        //possible notifies whether we can calculate the values of type1 and type2 (none of them are returned as null
        if (intOpcodes.containsKey(op))
            mv.visitInsn(intOpcodes.get(op));
        else
            throw new RuntimeException("Unknown operation");
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
            throw new RuntimeException("cannot " + type1 + " " + op + " " + type2);
        }
        //push the operation onto the stack
        //possible notifies whether we can calculate the values of type1 and type2 (none of them are returned as null
        if (intOpcodes.containsKey(op))
            mv.visitInsn(intOpcodes.get(op));
        else
            throw new RuntimeException("Unknown operation");
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
            mv.visitLdcInsn(value);
            return new TypedValue(TypedValue.Type.INT, value);
        }
        if (ctx.STRING() != null) {
            String str = ctx.STRING().getText();
            str = str.substring(1, str.length() - 1);
            mv.visitLdcInsn(str);
            return new TypedValue(TypedValue.Type.STRING, str);
        } else if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            if (memory.containsKey(id)) {
                TypedValue.Type type = types.get(id);
                if (type == TypedValue.Type.INT) { //int
                    mv.visitVarInsn(Opcodes.ILOAD, memory.get(id));
                } else if (type == TypedValue.Type.STRING) { //string
                    mv.visitVarInsn(Opcodes.ALOAD, memory.get(id));
                } else if (type == TypedValue.Type.BOOL) { //its a bool but it should work just like an int under the hood
                    mv.visitVarInsn(Opcodes.ILOAD, memory.get(id));
                }
                //it returns a null because the value is in the jvm slot and cannot be retrieved , one way to solve that problem is obv to maintain another hashmap with its values , seems unreasonable just yet
                return new TypedValue(types.get(id), null);
            }
            throw new RuntimeException("Not recognized: " + ctx.ID());
        } else if (ctx.TRUE() != null) {
            mv.visitInsn(Opcodes.ICONST_1);
            return new TypedValue(TypedValue.Type.BOOL,true);
        } else if (ctx.FALSE() != null) {
            mv.visitInsn(Opcodes.ICONST_0);
            return new TypedValue(TypedValue.Type.BOOL,false);
        }
        return visit(ctx.expr());
    }

    @Override
    public TypedValue visitPrintstat(QuarkParser.PrintstatContext ctx) {
        if(ctx.expr() == null){
            throw new RuntimeException("expr in ctx null");
        }
        //replace with the jvm instruction to load the print class
        mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
        TypedValue type = visit(ctx.expr());
        if(type.type == TypedValue.Type.INT){
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/io/PrintStream","println","(I)V");
        }else if( type.type == TypedValue.Type.STRING){
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/io/PrintStream","println","(Ljava/lang/Object;)V");
        }else if(type.type == TypedValue.Type.BOOL){
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/io/PrintStream","println","(Z)V");
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
        mv.visitJumpInsn(Opcodes.GOTO,endLabel);
        //check if else statement exists
        mv.visitLabel(elseLabel);
        if(ctx.block().size() > 1){ //true it exists
            visit(ctx.block(1));
        }
        mv.visitLabel(endLabel);
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
            throw new RuntimeException("Cannot equate" + TypedValue.typeString(left.type) + " to " + TypedValue.typeString(right.type));
        }
        mv.visitJumpInsn(invertedOps.get(op),endLabel);
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
            throw new RuntimeException("Cannot equate" + TypedValue.typeString(left.type) + " to " + TypedValue.typeString(right.type));
        }
        String op = ctx.getChild(1).getText();
        mv.visitJumpInsn(invertedOps.get(op),endLabel);
        return new TypedValue(TypedValue.Type.UNKNOWN, null);
    }

    @Override
    public TypedValue visitWhilestat(QuarkParser.WhilestatContext ctx) {
        Label endLabel = new Label();
        Label startLabel = new Label();

        //set the start label
        mv.visitLabel(startLabel);

        //add the comparsion opcodes
        var eq = ctx.expr().equalityexpr();
        TypedValue type =  visitEqualityExprForWhile(eq , endLabel);
        visit(ctx.block());

        //add the infinite goto
        mv.visitJumpInsn(Opcodes.GOTO,startLabel);

        //add the infinite breaker endlabel
        mv.visitLabel(endLabel);
        return type;
    }

}