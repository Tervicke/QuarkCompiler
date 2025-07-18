import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Scope {
    Map<String,VarInfo> variables = new HashMap<String, VarInfo>();
    Map<String , StructInfo> structs = new HashMap<>(); //structname -> last , type of struct
    private int lastSlot = 0;

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
        updateSlot(info);
    }
    public void putStruct(String name , StructInfo info){
        structs.put(name , info);
        lastSlot += 1; // + 1 for structs since they are refrence to class
    }

    public boolean containsStruct(String strutName) {
        return structs.containsKey(strutName);
    }

    public StructInfo getStructInfo(String name){
        return structs.get(name);
    }
    public void putConstant(String name , VarInfo info){
        variables.put(name , info);
        updateSlot(info);
    }
    public boolean isConstant(String name){
        VarInfo info = variables.get(name);
        return info.isConstant;
    }
    private void updateSlot(VarInfo info){
        if(info.type == TypedValue.Type.DOUBLE){ //if the value if double increase the slot by 2
            lastSlot+=2;
        }else{
            lastSlot+=1;
        }
    }
    public int getLastSlot(){
        return lastSlot;
    }
    public List<String> pushScopeVars(Map<String , VarInfo> localVars) {
        List<String> addedKeys = new ArrayList<>();
        for (Map.Entry<String, VarInfo> entry : localVars.entrySet()) {
            String key = entry.getKey();
            if (!variables.containsKey(key)) {
                addedKeys.add(key); // only track new keys
            }
            variables.put(key, entry.getValue());
        }
        return addedKeys;

    }
    public void removeScopeVars(List<String> localVars){

        for (String key : localVars) {
            variables.remove(key);
        }

    }

}
