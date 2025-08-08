import org.antlr.v4.runtime.*;

public class MyErrorListener extends BaseErrorListener {
    public int errorCount;
    MyErrorListener(){
       errorCount = 0;
    }
    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer,
            Object offendingSymbol,
            int line,
            int charPositionInLine,
            String msg,
            RecognitionException e) {
        errorCount++;
        System.err.println("[ERROR] Line " + line + ":" + (charPositionInLine + 1) + " " + msg);
    }

    public boolean hasErrors() {
        return errorCount > 0;
    }
}