import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ComparisonInstr {

    public static void compareNotEqual(MethodVisitor visitor , TypedValue.Type type , Label gotoLabel){
        switch (type){
            case INT:
            case BOOL:
                visitor.visitJumpInsn(Opcodes.IF_ICMPNE , gotoLabel);
                break;
            case DOUBLE:
                visitor.visitJumpInsn(Opcodes.IFNE,gotoLabel);
                break;
            case STRING:
                visitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false );
                visitor.visitJumpInsn(Opcodes.IFEQ, gotoLabel);
                break;
            default:
                break;
        }
    }
}
