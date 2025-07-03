import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.stringtemplate.v4.misc.TypeRegistry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Quark extends QuarkBaseVisitor<TypedValue>{
    Map<String,Integer> memory = new HashMap<>(); //this will store the id to the slot
    Map<String, TypedValue.Type> types = new HashMap<>();

    int lastSlot = 0;
    private final ClassWriter cw;
    private final MethodVisitor mv;
    private final Map<String,Integer> intOpcodes = Map.of(
            "+",Opcodes.IADD,
            "-", Opcodes.ISUB,
            "*", Opcodes.IMUL,
            "/", Opcodes.IDIV
    );
    private final Map<String, BiFunction<Integer, Integer, Integer>> intOps = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b
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
        }else if(ctx.ifstatement() != null){
            return visit(ctx.ifstatement());
        }
        return new TypedValue(TypedValue.Type.UNKNOWN,null);
    }

    @Override
    public TypedValue visitAssigstat(QuarkParser.AssigstatContext ctx) {
        String id = ctx.ID().getText();
        String definedType = ctx.TYPE().getText();
        TypedValue type = visit(ctx.expr());
        //convert this to java bytecode
        if( !TypedValue.typeString(type.type).equals(definedType)){
            throw new RuntimeException("cannot assign " + TypedValue.typeString(type.type) + " to an " + definedType);
        }
        System.out.println(type.type);
        if(type.type == TypedValue.Type.INT){
            mv.visitVarInsn(Opcodes.ISTORE,lastSlot);
        }else if(type.type == TypedValue.Type.STRING){
            mv.visitVarInsn(Opcodes.ASTORE,lastSlot);
        }else if(type.type == TypedValue.Type.BOOL){ //the value will already be loaded for bull
            mv.visitVarInsn(Opcodes.ISTORE,lastSlot);
        }
        memory.put(id , lastSlot);
        lastSlot++; //use the next slot
        TypedValue.Type varType = TypedValue.stringType(ctx.TYPE().getText());
        types.put(id ,varType );
        return type;
    }

    @Override
    public TypedValue visitEqualityexpr(QuarkParser.EqualityexprContext ctx) {
        if(ctx.getChildCount() == 1){
            return visit(ctx.addexpr(0));
        }
        TypedValue left = visit(ctx.addexpr(0));
        TypedValue right = visit(ctx.addexpr(1));
        if(left.type != right.type){
            throw new RuntimeException("Cannot equate" + TypedValue.typeString(left.type) + " to " + TypedValue.typeString(right.type));
        }
        String op = ctx.getChild(1).getText();
        Label truelabel = new Label();
        Label endlabel = new Label();
        if(op.equals("==")){
            mv.visitJumpInsn(Opcodes.IF_ICMPEQ,truelabel); //equal
        }else if(op.equals("!=")){
            mv.visitJumpInsn(Opcodes.IF_ICMPNE,truelabel); //noequal
        }else{
            throw new RuntimeException("unknown operation");
        }
        mv.visitInsn(Opcodes.ICONST_0);
        mv.visitJumpInsn(Opcodes.GOTO,endlabel);
        mv.visitLabel(truelabel);
        mv.visitInsn(Opcodes.ICONST_1);
        mv.visitLabel(endlabel);
        return new TypedValue(TypedValue.Type.BOOL,null);
    }

    @Override
    public TypedValue visitAddexpr(QuarkParser.AddexprContext ctx) {
        if(ctx.getChildCount() == 1){
            return visit(ctx.mulexpr());
        }
        TypedValue type1 = visit(ctx.addexpr());
        TypedValue type2 = visit(ctx.mulexpr());
        String op = ctx.getChild(1).getText();

        if(type1.type != type2.type && type1.type == TypedValue.Type.INT){
            throw new RuntimeException("cannot " + type1 + " " + op + " " + type2);
        }
        //push the operation onto the stack
        //possible notifies whether we can calculate the values of type1 and type2 (none of them are returned as null
        if(intOpcodes.containsKey(op))
            mv.visitInsn(intOpcodes.get(op));
        else
            throw new RuntimeException("Unknown operation");
        boolean valueKnown = type1.value != null && type2.value != null;
        if(valueKnown){
            BiFunction<Integer , Integer , Integer> operation = intOps.get(op);
            int value = operation.apply((Integer)type1.value , (Integer)type2.value);
            return new TypedValue(TypedValue.Type.INT,value);
        }
        return new TypedValue(TypedValue.Type.INT,null);
    }

    @Override
    public TypedValue visitMulexpr(QuarkParser.MulexprContext ctx) {
        if(ctx.getChildCount() == 1){
            return visit(ctx.atom());
        }
        TypedValue type1 = visit(ctx.mulexpr());
        TypedValue type2 = visit(ctx.atom());
        String op = ctx.getChild(1).getText();

        if(type1.type != type2.type && type1.type == TypedValue.Type.INT){
            throw new RuntimeException("cannot " + type1 + " " + op + " " + type2);
        }
        //push the operation onto the stack
        //possible notifies whether we can calculate the values of type1 and type2 (none of them are returned as null
        if(intOpcodes.containsKey(op))
            mv.visitInsn(intOpcodes.get(op));
        else
            throw new RuntimeException("Unknown operation");
        boolean valueKnown = type1.value != null && type2.value != null;
        if(valueKnown){
            BiFunction<Integer , Integer , Integer> operation = intOps.get(op);
            int value = operation.apply((Integer)type1.value , (Integer)type2.value);
            return new TypedValue(TypedValue.Type.INT,value);
        }
        return new TypedValue(TypedValue.Type.INT,null);
    }

    @Override
    public TypedValue visitAtom(QuarkParser.AtomContext ctx) {
        if(ctx.INT() != null){
            int value = Integer.parseInt(ctx.INT().getText());
            mv.visitLdcInsn(value);
            return new TypedValue( TypedValue.Type.INT, value);
        }
        if(ctx.STRING() != null){
            String str = ctx.STRING().getText();
            str = str.substring(1,str.length() - 1);
            mv.visitLdcInsn(str);
            return new TypedValue( TypedValue.Type.STRING , str);
        }
        else if(ctx.ID() != null){
            String id = ctx.ID().getText();
            if( memory.containsKey(id)){
                TypedValue.Type type = types.get(id);
                if(type == TypedValue.Type.INT){ //int
                    mv.visitVarInsn(Opcodes.ILOAD,memory.get(id));
                }else if(type == TypedValue.Type.STRING){ //string
                    mv.visitVarInsn(Opcodes.ALOAD,memory.get(id));
                }else if(type == TypedValue.Type.BOOL){ //its a bool but it should work just like an int under the hood
                    mv.visitVarInsn(Opcodes.ILOAD,memory.get(id));
                }
                //it returns a null because the value is in the jvm slot and cannot be retrieved , one way to solve that problem is obv to maintain another hashmap with its values , seems unreasonable just yet
                return new TypedValue(types.get(id) , null);
            }
            throw new RuntimeException("Not recognized: " + ctx.ID());
        }else{
            return visit(ctx.expr());
        }
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
        //System.out.println(value);
        return type;
    }

    @Override
    public TypedValue visitIfstatement(QuarkParser.IfstatementContext ctx) {
        // left == / != right
        System.out.println("inside the if statement");
        for(int i = 0 ; i < ctx.equalityexpr().size() ; i++){
            System.out.println(ctx.equalityexpr().get(i).getText());
        }

        TypedValue right = visit(ctx.equalityexpr().get(2));
        String op = ctx.equalityexpr().get(1).getText() ;
        System.out.println( TypedValue.typeString(right.type));
        System.out.println( op );
        return new TypedValue(TypedValue.Type.UNKNOWN,null);
    }
}