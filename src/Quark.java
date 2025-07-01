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

public class Quark extends QuarkBaseVisitor<Integer>{
    Map<String,Integer> memory = new HashMap<>(); //this will store the id to the slot
    int lastSlot = 0;
    private final ClassWriter cw;
    private final MethodVisitor mv;

    public Quark(ClassWriter cw, MethodVisitor mv) {
        this.cw = cw;
        this.mv = mv;
    }

    @Override
    public Integer visitProg(QuarkParser.ProgContext ctx) {
        return super.visitProg(ctx);
    }

    @Override
    public Integer visitStat(QuarkParser.StatContext ctx) {
        if (ctx.assigstat() != null) {
            return visit(ctx.assigstat());
        } else if (ctx.printstat() != null) {
            return visit(ctx.printstat());
        }
        throw new RuntimeException("Incorrect syntax " + ctx.getText());
    }

    @Override
    public Integer visitAssigstat(QuarkParser.AssigstatContext ctx) {
        String id = ctx.ID().getText();
        visit(ctx.expr());
        //convert this to java bytecode
        lastSlot++; //use the next slot
        mv.visitVarInsn(Opcodes.ISTORE,lastSlot);
        memory.put(id , lastSlot);
        return 0;
    }

    @Override
    public Integer visitExpr(QuarkParser.ExprContext ctx) {
        return visit(ctx.addexpr());
    }

    @Override
    public Integer visitAddexpr(QuarkParser.AddexprContext ctx) {
        if(ctx.getChildCount() == 1){
            return visit(ctx.mulexpr());
        }
        int left;
        if (ctx.addexpr() == null) left = 0;
        else left = visit(ctx.addexpr());

        int right = visit(ctx.mulexpr());
        String op = ctx.getChild(1).getText();
        if(op.equals("+")){
            return left + right;
        }
        return left - right;
    }

    @Override
    public Integer visitMulexpr(QuarkParser.MulexprContext ctx) {
        if(ctx.getChildCount() == 1){
            return visit(ctx.atom());
        }
        int left = visit(ctx.mulexpr());
        int right = visit(ctx.atom());
        String op = ctx.getChild(1).getText();
        if(op.equals("*")){
            return left * right;
        }
        return left / right;
    }

    @Override
    public Integer visitAtom(QuarkParser.AtomContext ctx) {
        if(ctx.INT() != null){
            int value = Integer.parseInt(ctx.INT().getText());
            mv.visitLdcInsn(value);
            return 0;
        }else if(ctx.ID() != null){
            String id = ctx.ID().getText();
            if( memory.containsKey(id)){
                mv.visitVarInsn(Opcodes.ILOAD,memory.get(id));
                return memory.get(id);
            }
            throw new RuntimeException("Not recognized: " + ctx.ID());
        }else{
            return visit(ctx.expr());
        }
    }

    @Override
    public Integer visitPrintstat(QuarkParser.PrintstatContext ctx) {
        if(ctx.expr() == null){
            throw new RuntimeException("expr in ctx null");
        }
        //replace with the jvm instruction to load the print class
        mv.visitFieldInsn(Opcodes.GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
        visit(ctx.expr());
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/io/PrintStream","println","(I)V");
        //System.out.println(value);
        return 0;
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

