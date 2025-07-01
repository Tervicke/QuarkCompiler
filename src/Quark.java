import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Quark extends QuarkBaseVisitor<String>{
    Map<String,Integer> memory = new HashMap<>(); //this will store the id to the slot
    Map<String,String> types = new HashMap<>();

    int lastSlot = 0;
    private final ClassWriter cw;
    private final MethodVisitor mv;

    public Quark(ClassWriter cw, MethodVisitor mv) {
        this.cw = cw;
        this.mv = mv;
    }

    @Override
    public String visitStat(QuarkParser.StatContext ctx) {
        if (ctx.assigstat() != null) {
            return visit(ctx.assigstat());
        } else if (ctx.printstat() != null) {
            return visit(ctx.printstat());
        }
        throw new RuntimeException("Incorrect syntax " + ctx.getText());
    }

    @Override
    public String visitAssigstat(QuarkParser.AssigstatContext ctx) {
        String id = ctx.ID().getText();
        String type = visit(ctx.expr());
        //convert this to java bytecode
        lastSlot++; //use the next slot
        if(type.equals("int")){
            mv.visitVarInsn(Opcodes.ISTORE,lastSlot);
        }else if(type.equals("string")){
            mv.visitVarInsn(Opcodes.ASTORE,lastSlot);
        }
        memory.put(id , lastSlot);
        types.put(id , ctx.TYPE().getText());
        return type;
    }

    @Override
    public String visitExpr(QuarkParser.ExprContext ctx) {
        return visit(ctx.addexpr());
    }

    @Override
    public String visitAddexpr(QuarkParser.AddexprContext ctx) {
        if(ctx.getChildCount() == 1){
            return visit(ctx.mulexpr());
        }
        String type1 = visit(ctx.addexpr());
        String type2 = visit(ctx.mulexpr());
        String op = ctx.getChild(1).getText();
        if(type1.equals(type2) && type1.equals("int")){
            if(op.equals("+")){
                mv.visitInsn(Opcodes.IADD);
            }if(op.equals("-")){
                mv.visitInsn(Opcodes.ISUB);
            }
            return "int";
        }
        throw new RuntimeException("cannot " + type1 + " " + op + " " + type2);
    }

    @Override
    public String visitMulexpr(QuarkParser.MulexprContext ctx) {
        if(ctx.getChildCount() == 1){
            return visit(ctx.atom());
        }
        String type1 = visit(ctx.mulexpr());
        String type2 = visit(ctx.atom());
        String op = ctx.getChild(1).getText();
        if(op.equals("*")){
            mv.visitInsn(Opcodes.IMUL);
        }else{
            mv.visitInsn(Opcodes.IDIV);
        }
        if(type1.equals(type2)) {
            return type1;
        }
        throw new RuntimeException("cannot " + type1 + " " + op + " " + type2);
    }

    @Override
    public String visitAtom(QuarkParser.AtomContext ctx) {
        if(ctx.INT() != null){
            int value = Integer.parseInt(ctx.INT().getText());
            mv.visitLdcInsn(value);
            return "int";
        }
        if(ctx.STRING() != null){
            String str = ctx.STRING().getText();
            str = str.substring(1,str.length() - 1);
            mv.visitLdcInsn(str);
            return "string";
        }
        else if(ctx.ID() != null){
            String id = ctx.ID().getText();
            if( memory.containsKey(id)){
                if(types.get(id).equals("int")){
                    mv.visitVarInsn(Opcodes.ILOAD,memory.get(id));
                }else if(types.get(id).equals("string")){
                    mv.visitVarInsn(Opcodes.ALOAD,memory.get(id));
                }
                return types.get(id);
            }
            throw new RuntimeException("Not recognized: " + ctx.ID());
        }else{
            return visit(ctx.expr());
        }
    }

    @Override
    public String visitPrintstat(QuarkParser.PrintstatContext ctx) {
        if(ctx.expr() == null){
            throw new RuntimeException("expr in ctx null");
        }
        //replace with the jvm instruction to load the print class
        mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
        String type = visit(ctx.expr());
        if(type.equals("int")){
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/io/PrintStream","println","(I)V");
        }else if(type.equals("string")){
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/io/PrintStream","println","(Ljava/lang/Object;)V");
        }
        //System.out.println(value);
        return type;
    }

    public static void main(String[]args) throws IOException {
        CharStream input;
        String filename = "";
        if(args.length >= 1){
            filename = args[0];
            Path filepath = Paths.get(filename);
            input = CharStreams.fromPath(filepath);
        }else{
            input = CharStreams.fromStream(System.in);
        }
        QuarkLexer lexer = new QuarkLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuarkParser parser = new QuarkParser(tokens);
        ParseTree tree = parser.prog();

        //generate the classWriter cw
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(Opcodes.V1_7 ,Opcodes.ACC_PUBLIC, "test" , null , "java/lang/Object" , null);

        //MethoVisitor //defines the public static void main
        MethodVisitor mv = cw.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, // access flags
                "main",                                  // method name
                "([Ljava/lang/String;)V",                // descriptor (args + return)
                null,                                    // signature (null = not generic)
                null                                     // exceptions (null = none declared)
        );
        mv.visitCode();

        //walk over the parse tree
        Quark visitor = new Quark(cw,mv);
        visitor.visit(tree);

        //return from the main method
        mv.visitInsn(Opcodes.RETURN);

        //finish up the MethodVisitor and ClassWriter
        mv.visitMaxs(0,0);
        mv.visitEnd();
        cw.visitEnd();
        byte[] bytecode = cw.toByteArray();
        if(args.length >= 1){
            String inputFile = args[0];
            String classFile = inputFile.replace(".quark",".class");
            System.out.println("generated the " + classFile + " file");
            Files.write(Paths.get(classFile),bytecode);
        }
    }
}

