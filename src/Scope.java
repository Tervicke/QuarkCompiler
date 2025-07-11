import java.util.HashMap;
import java.util.Map;
public class Scope {
    Map<String,VarInfo> variables = new HashMap<String, VarInfo>();
    Map<String , StructInfo> structs = new HashMap<>(); //structname -> last , type of struct
    int lastSlot = 0;

    void declare(String name , VarInfo info){
        if( variables.containsKey(name) ){
            throw new RuntimeException("variable already declared " + name);
        }
    }

    public VarInfo getVariable(String name){
        return variables.get(name);
    }

    public boolean containsKey(String name){
        return variables.containsKey(name);
    }
    public void putVariable(String name , VarInfo info){
        variables.put(name , info);
    }
    public void putStruct(String name , StructInfo info){
        structs.put(name , info);
    }

    public boolean containsStruct(String strutName) {
        return structs.containsKey(strutName);
    }

    public StructInfo getStructInfo(String name){
        return structs.get(name);
    }
    public void putConstant(String name , VarInfo info){
        variables.put(name , info);
    }
    public boolean isConstant(String name){
        VarInfo info = variables.get(name);
        return info.isConstant;
    }
}
