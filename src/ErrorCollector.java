import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

public class ErrorCollector {
    private final List<String> errors = new ArrayList<String>();
    public void addError(ParserRuleContext ctx , String error ){
        int line  = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine() + 1;
        String errorLog = "[ERROR] Line " + line + ":" + col + " " + error;
        errors.add(errorLog);
    }
    public void printError(String message) {
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }
    public void reportAll(){
        for(var errorLog : errors){
            printError(errorLog);
        }
    }
    public boolean hasErrors(){
        return !errors.isEmpty();
    }
}
