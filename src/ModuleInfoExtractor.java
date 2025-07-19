import org.objectweb.asm.*;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class ModuleInfoExtractor {
    public static Map<String , TypedValue.Type> extractInfoFromClass(String className , boolean isStandardLibrary) throws IOException {
        ClassReader cr;
        Map<String , TypedValue.Type> result = new HashMap<>();
        if(isStandardLibrary){
             cr = new ClassReader(className);
        }else{
            File file = new File(className + ".class");
            if (!file.exists()) {
                throw new FileNotFoundException("Missing file: " + file.getAbsolutePath());
            }
            byte[] bytes = Files.readAllBytes(file.toPath());
            cr = new ClassReader(bytes);
        }
        ClassVisitor visitor = new ClassVisitor(Opcodes.ASM4) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                System.out.println("Found method: " + name + " " + desc);
                if ((access & Opcodes.ACC_STATIC) != 0 &&
                        (access & Opcodes.ACC_PUBLIC) != 0 &&
                        !name.equals("<clinit>") &&
                        !name.equals("<init>") &&
                        !(name.equals("main") && desc.equals("([Ljava/lang/String;)V")))
            {
                    String descWithoutReturn = stripReturn(desc);
                    String functionId = className  + ":" + name + ":" + descWithoutReturn;
                    result.put(functionId, TypedValue.getTypeFromDescriptor(extractReturn(desc)));
            }

                return super.visitMethod(access, name, desc, signature, exceptions);
            }
        };
        cr.accept(visitor , 0);
        System.out.println(result);
        return result;
    }

    private static String stripReturn(String descriptor) {
        int idx = descriptor.indexOf(')');
        return descriptor.substring(0, idx + 1);
    }

    private static String extractReturn(String descriptor) {
        int idx = descriptor.indexOf(')');
        return descriptor.substring(idx + 1);
    }
}
