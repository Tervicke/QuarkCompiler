import org.objectweb.asm.Type;

public class TypedValue {
    public enum Type{
        INT , STRING , BOOL , UNKNOWN , VOID
    };

    public final Type type;
    public final Object value;

    public TypedValue(Type type , Object value) {
        this.type = type;
        this.value = value;
    }
    public static String typeString(Type type){
        switch(type){
            case INT:
                return "int";
            case STRING:
                return "string";
            case BOOL:
                return "bool";
            case VOID:
                return "void";
            default:
                return "unknown";
        }
    }
    public static Type stringType(String s){
        switch(s){
            case "int":
                return Type.INT;
            case "string":
                return Type.STRING;
            case "bool":
                return Type.BOOL;
            case "void":
                return Type.VOID;
            default:
                return Type.UNKNOWN;

        }
    }
    public static TypedValue voidtype() {
        return new TypedValue(Type.VOID, null);
    }

    public static TypedValue unknowntype() {
        return new TypedValue(Type.UNKNOWN, null);
    }

    public static org.objectweb.asm.Type TypeTOASMType(Type type){
        switch(type){
            case INT:
                return org.objectweb.asm.Type.INT_TYPE;
            case STRING:
                return org.objectweb.asm.Type.getType(String.class);
            case BOOL:
                return org.objectweb.asm.Type.BOOLEAN_TYPE;
            case VOID:
                return org.objectweb.asm.Type.VOID_TYPE;
            default:
                return org.objectweb.asm.Type.VOID_TYPE;
        }
    }
    public String getDescriptorFromType(){
        String str;
        switch(this.type){
            case INT:
                str = "I";
            case STRING:
                str = "Ljava/lang/String";
            case BOOL:
                str = "Z";
            case VOID:
                str = "V";
            default:
                str = "Ljava/lang/Object";
        };
        return str;
    }
}
