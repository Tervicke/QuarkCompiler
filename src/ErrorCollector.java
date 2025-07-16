import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

public class ErrorCollector {
    private final List<String> errors = new ArrayList<String>();
    private final List<String> warnings = new ArrayList<>();
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
        for (String errorLog : errors) {
            printError(errorLog);
        }
        for (String warningLog : warnings) {
            printWarning(warningLog);
        }
    }
    public boolean hasErrors(){
        return !errors.isEmpty();
    }
    public static void showError(ParserRuleContext ctx , String error){
        int line  = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine() + 1;
        String errorLog = "[ERROR] Line " + line + ":" + col + " " + error;
        System.out.println("\u001B[31m" + errorLog + "\u001B[0m");
    }
    public void addWarning(ParserRuleContext ctx , String warning){
        int line  = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine() + 1;
        String errorLog = "[Warning] Line " + line + ":" + col + " " + warning;
        warnings.add(errorLog);
    }

    public void printWarning(String message) {
        System.out.println("\u001B[33m" + message + "\u001B[0m"); // Yellow
    }

    public boolean hasWarnings() {
        return !warnings.isEmpty();
    }
}
