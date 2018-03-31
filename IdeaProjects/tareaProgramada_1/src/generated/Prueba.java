package generated;

import org.antlr.v4.runtime.Token;

/**
 * Created by Pruebas on 04/04/2017.
 */
public class Prueba {

    Token tokenActual;
    Scanner scanner;
    void Prueba(Scanner scannerV){
        scanner = scannerV;
        tokenActual = scanner.nextToken();
    }
    void accept(int tokenEsperado){
        if(tokenActual.getType() == tokenEsperado){
            tokenActual = scanner.nextToken();
        }
        else{
            //error
        }
    }
    void acceptit(){
        tokenActual = scanner.nextToken();
    }
    void program(){
        switch (tokenActual.getType()){
            case Scanner.INT:
            case Scanner.STRING:
                declarations();
                staments();
                break;
            case Scanner.ID:
            case Scanner.NUM:
                staments();
                break;
        }
    }
    void staments(){
        stament();
        while(tokenActual.getType() == Scanner.PyCOMA){
            acceptit();
            stament();
        }
    }
    void declarations(){
        declaration();
        accept(Scanner.PyCOMA);
        while(tokenActual.getType() == Scanner.INT || tokenActual.getType() == Scanner.STRING){
            declaration();
            accept(Scanner.PyCOMA);
        }
    }
    void declaration(){
        acceptit();
        idlist();
    }
    void stament(){

        switch (tokenActual.getType()){
            case Scanner.ID:
                acceptit();
                if(tokenActual.getType() == Scanner.ASIGN){
                    acceptit();
                    expression();
                    break;
                }
                else{
                    //tokenActual = tokenPrevius();
                    expression();
                    break;
                }

            case Scanner.PIZQ:
            case Scanner.NUM:
            case Scanner.STR:
                expression();
                break;
        }
    }
    void expression(){
        term();
        while (tokenActual.getType() == Scanner.SUMA){
            acceptit();
            term();
        }
    }
    void term(){
        factor();
        while (tokenActual.getType() == Scanner.MUL){
            acceptit();
            factor();
        }
    }
    void factor(){
        switch (tokenActual.getType()){
            case Scanner.PDER:
                expression();
                accept(Scanner.PIZQ);
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
                //error
        }
    }
    void idlist(){
        if(tokenActual.getType() == Scanner.ID){
            acceptit();
            while(tokenActual.getType()==Scanner.COMA){
                acceptit();
                if(tokenActual.getType() == Scanner.ID){
                    acceptit();
                }
            }
        }
    }
}
