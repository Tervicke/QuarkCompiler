import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main{
    private static final Map<String , List<String>> graph = new HashMap<>();
    private static final Set<String> modules  = new HashSet<>();
    private static final List<String> order = new ArrayList<>();

    private static final Set<String> STANDARDLIBARY = Set.of(
            "io",
            "math"
    );

    public static void main(String[]args) throws IOException {
        String inputFile = args[0];

        File file = new File(inputFile);
        String path = file.getParent();
        if (path == null) {
            path = "."; // current directory
        }


        generateGraph( inputFile ); // this should reorder the input files according to topology graph

        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();

        if (detectCycle(stripExtension(inputFile) , visited , recStack)){
            ErrorCollector ec = new ErrorCollector();
            ec.printError("Compilation Failed Circular dependency detected");
            System.exit(1);
        }


        //topologically sort graph
        topSortGraph();

        for (String s : order) {
            //get the path
            Path inputPath = Paths.get(s + ".quark");
            String fileName = inputPath.getFileName().toString();                  // "fib.quark"
            String className = fileName.replaceFirst("\\.quark$", "");             // "fib"
            Path outputPath = inputPath.resolveSibling(className + ".class");      // "examples/fib.class"


            //setup antlr parser
            CharStream input = CharStreams.fromPath(inputPath);
            QuarkLexer lexer = new QuarkLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QuarkParser parser = new QuarkParser(tokens);
            ParseTree tree = parser.prog();

            //generate the classWriter cw
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
            cw.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, className, null, "java/lang/Object", null);


            MethodVisitor mv = cw.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, // access flags
                    "main",                                  // method name
                    "([Ljava/lang/String;)V",                // descriptor (args + return)
                    null,                                    // signature (null = not generic)
                    null                                     // exceptions (null = none declared)
            );
            mv.visitCode();

            Quark visitor = new Quark(cw, mv, mv, s , path , STANDARDLIBARY);
            visitor.visit(tree);

            //end the main method
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(-1, -1);
            mv.visitEnd();
            cw.visitEnd();

            //if there are errors report them and exit
            if (visitor.errorCollector.hasErrors()) {
                visitor.errorCollector.reportAll();
                System.out.println("Error occured when compiling " + inputPath.toString());
                System.exit(1);
            }

            //assuming no errors , report warninging if any
            if(visitor.errorCollector.hasWarnings()){
                visitor.errorCollector.reportAll();
            }

            //finish up the MethodVisitor and ClassWriter
            byte[] bytecode = cw.toByteArray();
            System.out.println("compiled " + s + ".quark" + " and generated " + outputPath);
            Files.write(Paths.get(outputPath.toString()), bytecode);
        }

    }
    private static void dfs(String currentNode ,  Set<String> visited ){
        //make the current node
        visited.add(currentNode);
        for(String node : graph.getOrDefault(currentNode,List.of())){
            if(visited.contains(node)) continue;
            dfs(node , visited);
        }
        order.add(currentNode);
    }
    private static void topSortGraph() {
        //to store the visited node
        Set<String> visited = new HashSet<>();
        List<String> order = new ArrayList<>();

        for(String module : modules){
            if(visited.contains(module)) continue;
            dfs(module , visited );
        }
    }
    public static boolean detectCycle(String node , Set<String> visited , Set<String> recStack){
        visited.add(node);
        recStack.add(node);
        for(String neighbour : graph.getOrDefault(node,List.of())){
            if(!visited.contains(neighbour)){
                if(detectCycle(neighbour , visited , recStack)){
                    return true;
                }
            }else if(recStack.contains(neighbour)){
                return true;
            }
        }
        recStack.remove(node);
        return false;
    }
    public static void generateGraph(String inputfileName) throws IOException {
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push(stripExtension(inputfileName)); //push the initial file

        while(!stack.isEmpty()){

            String module = stack.pop();
            if (visited.contains(module)) continue;
            visited.add(module);


            Path filePath = Path.of(module + ".quark");
            CharStream input = CharStreams.fromPath(filePath);
            QuarkLexer lexer = new QuarkLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QuarkParser parser = new QuarkParser(tokens);
            ParseTree tree = parser.prog();
            ImportCollector collector = new ImportCollector();

            collector.visit(tree);
            List<String> imports = collector.imports;
            graph.put(module, imports);
            for(String imp : imports){
                stack.push(imp);
            }
        }

        //add the visited to the modules indicating the total modules
        modules.addAll(visited);
    }
    static String stripExtension(String filename){
        return filename.endsWith(".quark")
                ? filename.substring(0, filename.length() - 6)
                : filename;
    }

    static class ImportCollector extends QuarkBaseVisitor<Void>{
        List<String> imports = new ArrayList<>();
        @Override
        public Void visitImportstat(QuarkParser.ImportstatContext ctx) {
            String moduleName = ctx.ID().getText();

            Path filePath = Path.of(moduleName + ".quark");
            //check if either the class path (io.class) or (io.quark) file exists if none of them exists throw error
            if(!Files.exists(filePath) && !STANDARDLIBARY.contains(moduleName)){
                ErrorCollector.showError(ctx,"Module '"+ moduleName + "' not found");
                System.exit(1);
            }else if(Files.exists(filePath)){ //only add the filepath i.e .quark files to the imports list to compile them later on
                imports.add(moduleName);
            }
            return null;
        }
    }

}