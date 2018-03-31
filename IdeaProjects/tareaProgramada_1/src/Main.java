import generated.ParserGrammar;
import generated.Scanner;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.FileReader;
import java.util.List;

/**
 * Created by Pruebas on 14/03/2017.
 */
public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = null;
        ParserGrammar parser = null;
        try{
            ANTLRInputStream input = new ANTLRInputStream(new FileReader("texto.txt"));
            scanner = new Scanner(input);
            System.out.println("************SCANNER************\n");
            System.out.println("Lista de tokens");
            List<Token> lista = (List<Token>) scanner.getAllTokens();
            for (Token t : lista)
                System.out.println(t.getType() + " : '" + t.getText()+"'");

            ANTLRInputStream input2 = new ANTLRInputStream(new FileReader("texto.txt"));
            scanner = new Scanner(input2);
            System.out.println("\n\n************PARSER************\n");
            parser = new ParserGrammar(lista,scanner);
            parser.program();
            System.out.println("Sintaxis Correcta");

        }catch (Exception e){
            System.out.println("No hay archivo");
        }

    }
}
