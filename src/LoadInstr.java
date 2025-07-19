import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class LoadInstr {

    //get the variable info and then loads it onto the stack by using its value if its a constant or its slot
    public static void LoadVariable(MethodVisitor visitor , VarInfo varInfo) {
        switch (varInfo.type){
            case INT:
            case BOOL:
                visitor.visitVarInsn(Opcodes.ILOAD, varInfo.slot);
                break;
            case STRING:
            case SYMBOL:
                visitor.visitVarInsn(Opcodes.ALOAD, varInfo.slot);
                break;
            case DOUBLE:
                visitor.visitVarInsn(Opcodes.DLOAD, varInfo.slot);
        }
    }
    public static void LoadStruct(MethodVisitor visitor , StructInfo structInfo){
        visitor.visitVarInsn(Opcodes.ALOAD,structInfo.slot); //load the instance of the object onto the stack
    }

    public static void storeVariable(MethodVisitor visitor , VarInfo varInfo){
        switch (varInfo.type){
            case INT:
            case BOOL:
                visitor.visitVarInsn(Opcodes.ISTORE, varInfo.slot);
                break;
            case STRING:
            case SYMBOL:
                visitor.visitVarInsn(Opcodes.ASTORE, varInfo.slot);
                break;
            case DOUBLE:
                visitor.visitVarInsn(Opcodes.DSTORE, varInfo.slot);
                break;
        }
    }
}
