public class VarInfo {
    Integer slot;
    TypedValue.Type type;
    public boolean isConstant = false;
    public Object constValue = null;

    public static VarInfo constant(Object value, TypedValue.Type type) {
        VarInfo vi = new VarInfo();
        vi.isConstant = true;
        vi.constValue = value;
        vi.type = type;
        return vi;
    }

    public static VarInfo variable(int slot, TypedValue.Type type) {
        VarInfo vi = new VarInfo();
        vi.slot = slot;
        vi.type = type;
        return vi;
    }

}
