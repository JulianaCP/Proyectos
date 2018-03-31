package generated;

import jdk.nashorn.internal.parser.TokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ParserATNSimulator;

import javax.swing.text.html.parser.DTD;
import javax.swing.text.html.parser.Parser;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Pruebas on 14/03/2017.
 */
public class ParserGrammar {

    int cont = -1;
    Scanner scannerTemporal = null;
    List<Token> lista = null;
    Token tokenActual=null;
    Token tokenTemporal = null;
    public ParserGrammar(List<Token> listaVar,Scanner scannerTemporalVar) {
        lista = listaVar;
        tokenActual = nextToken();
        scannerTemporal = scannerTemporalVar;
        guardarEOF();
    }

    public void guardarEOF(){
        while(true){
            tokenTemporal = scannerTemporal.nextToken();
            if(tokenTemporal.getType() == Scanner.EOF){
                lista.add(tokenTemporal);
                lista.add(tokenTemporal);
                break;
            }
        }
    }
    public Token nextToken(){
        cont = cont + 1;
        return lista.get(cont);
    }
    public Token previusToken(){
        cont = cont - 1;
        return lista.get(cont);
    }

    public void program(){
        try{
            switch (tokenActual.getType()) {
                case Scanner.INT:
                case Scanner.STRING:
                    parseDeclarations();
                    parseStatements();
                    accept(Scanner.EOF);
                    break;
                case Scanner.PIZQ:
                case Scanner.STR:
                case Scanner.ID:
                case Scanner.NUM:
                    parseStatements();
                    accept(Scanner.EOF);
                    break;
                default:
                    error();
                    break;
            }
        }catch (Exception e){
            error();
        }
    }
    public void parseDeclarations(){

        parseDeclaration();
        accept(Scanner.PyCOMA);
        while(tokenActual.getType() == Scanner.INT || tokenActual.getType()==Scanner.STRING){
            parseDeclaration();
            accept(Scanner.PyCOMA);
        }
    }

    public void parseDeclaration(){
        acceptit();
        parseIdList();
    }

    public void parseStatements(){
        parseStatement();
        while(tokenActual.getType()==Scanner.PyCOMA){
            acceptit();
            parseStatement();
        }
    }
    public void parseStatement(){
        try{
            switch (tokenActual.getType()){
                case Scanner.ID:
                    tokenActual = nextToken();
                    if(tokenActual.getType() == Scanner.ASIGN){
                        acceptit();
                        parseExpression();
                        break;
                    }
                    else{
                        tokenActual = previusToken();
                        parseExpression();
                        break;
                    }
                case Scanner.PIZQ:
                case Scanner.STR:
                case Scanner.NUM:
                    acceptit();
                    parseExpression();
                    break;
            }
        }catch (Exception e){
            error();
        }
    }
    public void parseIdList(){
        if(tokenActual.getType()==Scanner.ID){
            acceptit();
            while(tokenActual.getType()==Scanner.COMA){
                acceptit();
                if(tokenActual.getType()==Scanner.ID){
                    acceptit();
                }
            }
        }
        else{
            error();
        }
    }
    public void parseExpression(){
        parseTerm();
        while(tokenActual.getType()==Scanner.SUMA){
            acceptit();
            parseTerm();
        }
    }
    public void parseTerm(){
        parseFactor();
        while(tokenActual.getType()==Scanner.MUL){
            acceptit();
            parseFactor();
        }
    }
    public void parseFactor(){
        try{
            switch (tokenActual.getType()){
                case Scanner.PIZQ:
                    acceptit();
                    parseExpression();
                    accept(Scanner.PDER);
                    break;
                case Scanner.ID:
                    acceptit();
                    break;
                case Scanner.NUM:
                    acceptit();
                    break;
                case Scanner.STR:
                    acceptit();
                    break;
                default:
                    error();
                    break;
            }
        }catch (Exception e){
            error();
        }
    }

    public void accept(int tokenEsperado){
        if(tokenEsperado!=tokenActual.getType()){
            error();
        }
        else{
            tokenActual = nextToken();
        }
    }
    public void acceptit(){
        tokenActual = nextToken();
    }
    public void error(){
        System.out.println("Error...token no esperado: " + tokenActual.getText() +
                "  Fila: " + tokenActual.getLine() + " columna: " + tokenActual.getCharPositionInLine());
        System.exit(0);
    }
}
