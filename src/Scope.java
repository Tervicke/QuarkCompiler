import java.util.HashMap;
import java.util.Map;

public class Scope {
    Map<String,VarInfo> variables = new HashMap<String, VarInfo>();
    int lastSlot = 0;

    void declare(String name , VarInfo info){
        if( variables.containsKey(name) ){
            throw new RuntimeException("variable already declared " + name);
        }
    }

    public VarInfo get(String name){
        return variables.get(name);
    }

    public boolean containsKey(String name){
        return variables.containsKey(name);
    }
    public void put(String name , VarInfo info){
        variables.put(name , info);
    }

}
