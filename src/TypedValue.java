import org.objectweb.asm.Type;

public class TypedValue {
    public enum Type{
        INT , STRING , BOOL , UNKNOWN , VOID , STRUCT , DOUBLE
    };

    public final Type type;
    public final Object value;
    public String id = "not specified"; //id is used by structs to return the type of struct

    public TypedValue(Type type , Object value) {
        this.type = type;
        this.value = value;
    }
    public TypedValue(Type type , Object value , String id) {
        this.type = type;
        this.value = value;
        this.id = id;
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
            case DOUBLE:
                return "double";
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
            case "double":
                return Type.DOUBLE;
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
                break;
            case STRING:
                str = "Ljava/lang/String";
                break;
            case BOOL:
                str = "Z";
                break;
            case VOID:
                str = "V";
                break;
            default:
                str = "Ljava/lang/Object";
        };
        return str;
    }

    public static String getDescriptorFromString(String str){
        String res;
        switch(str){
            case "int":
                res = "I";
                break;
            case "string":
                res = "Ljava/lang/String;";
                break;
            case "bool":
                res = "Z";
                break;
            case "void":
                res = "V";
                break;
            default:
                res = "Ljava/lang/Object";
        };
        return res;
    }
    public static Type getTypeFromDescriptor(String desc) {
        switch (desc) {
            case "I":
                return Type.INT;
            case "Z":
                return Type.BOOL;
            case "V":
                return Type.VOID;
            case "D":
                return Type.DOUBLE;
            case "Ljava/lang/String;":
                return Type.STRING;
            default:
                if (desc.startsWith("L") && desc.endsWith(";")) {
                    return Type.STRUCT;
                }
                return Type.UNKNOWN;
        }
    }


}
