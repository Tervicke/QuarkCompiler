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
import java.util.ArrayList;
import java.util.List;

public class Main{
    private static List<String> inputFiles = new ArrayList<>();
    private static List<String> outputFiles = new ArrayList<>();

    public static void parseArgs(String[] args){
        boolean isInput = true;
        for(String argument : args){

            if(argument.equals("-i")){
                isInput = true;
                continue;
            }
            if(argument.equals("-o")){
                isInput = false;
                continue;
            }

            if(isInput){
                inputFiles.add(argument);
            }else{
                outputFiles.add(argument);
            }
        }
    }
    public static void main(String[]args) throws IOException {
        if(args.length < 1){
            throw new RuntimeException("No input file provided");
        }

        if(inputFiles.size() != outputFiles.size()){
            throw new RuntimeException("input files and output file number does not match");
        }

        //parse the arguments
        parseArgs(args);

        for(int i = 0 ; i < inputFiles.size() ; i++){
            String filename = inputFiles.get(i);
            String output = outputFiles.get(i);
            //get the path
            Path filepath = Paths.get(filename);

            //setup antlr parser
            CharStream input = CharStreams.fromPath(filepath);
            QuarkLexer lexer = new QuarkLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QuarkParser parser = new QuarkParser(tokens);
            ParseTree tree = parser.prog();

            //generate the classWriter cw
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
            cw.visit(Opcodes.V1_7 ,Opcodes.ACC_PUBLIC, output , null , "java/lang/Object" , null);


            MethodVisitor mv = cw.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, // access flags
                    "main",                                  // method name
                    "([Ljava/lang/String;)V",                // descriptor (args + return)
                    null,                                    // signature (null = not generic)
                    null                                     // exceptions (null = none declared)
            );
            mv.visitCode();

            Quark visitor = new Quark(cw , mv , mv , output);
            visitor.visit(tree);

            //end the main method
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(-1,-1);
            mv.visitEnd();
            cw.visitEnd();

            if(visitor.errorCollector.hasErrors()){
                System.out.println("Error occured when compiling " + filename);
                visitor.errorCollector.reportAll();
                continue;
            }

            //finish up the MethodVisitor and ClassWriter
            byte[] bytecode = cw.toByteArray();
            String inputFile = args[0];
            String classFile = output + ".class";
            System.out.println("generated " + classFile);
            Files.write(Paths.get(classFile),bytecode);
        }

    }
}