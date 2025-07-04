import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main{
    public static void main(String[]args) throws IOException {
        if(args.length < 1){
            throw new RuntimeException("No input file provided");
        }
        String filename = args[0];
        String output = "output";
        if (args.length >= 3 && args[1].equals("-o")) {
            output = args[2];
        }
        Path filepath = Paths.get(filename);
        CharStream input = CharStreams.fromPath(filepath);
        QuarkLexer lexer = new QuarkLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuarkParser parser = new QuarkParser(tokens);
        ParseTree tree = parser.prog();

        //generate the classWriter cw
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(Opcodes.V1_7 ,Opcodes.ACC_PUBLIC, output , null , "java/lang/Object" , null);

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
        mv.visitMaxs(-1,-1);
        mv.visitEnd();
        cw.visitEnd();
        byte[] bytecode = cw.toByteArray();
        String inputFile = args[0];
        String classFile = output + ".class";
        System.out.println("generated the " + classFile + " file");
        Files.write(Paths.get(classFile),bytecode);
    }
}