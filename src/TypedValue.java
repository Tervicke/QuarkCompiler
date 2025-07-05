public class TypedValue {
    public enum Type{
        INT , STRING , BOOL , UNKNOWN ,
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
            default:
                return Type.UNKNOWN;

        }
    }
    public static TypedValue voidtype() {
        return new TypedValue(Type.UNKNOWN, null);
    }
}
