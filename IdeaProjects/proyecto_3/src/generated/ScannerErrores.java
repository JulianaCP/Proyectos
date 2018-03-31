package generated;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * Created by Joha on 30/3/2017.
 */
public class ScannerErrores extends BaseErrorListener {

    public static final ScannerErrores ERRORIDENTIFICADO = new ScannerErrores();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
            throws ParseCancellationException {
        System.out.println("\n\nline " + line + ":" + charPositionInLine + " " + msg);
        String errorToken="\n\nlinea " + line + " Columna: " + charPositionInLine + " " + "Error de reconocimiento: <"+msg+">";

        Global.modeloG.addElement(errorToken);
        System.out.println("................ MODELO............"+Global.modeloG.size());
    }
}