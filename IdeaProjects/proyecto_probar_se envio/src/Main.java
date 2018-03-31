import generated.GParser;
import generated.Scanner;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import javax.swing.text.html.parser.Parser;
import java.io.FileReader;
import java.util.List;

/**
 * Created by Pruebas on 14/03/2017.
 */
public class Main {
    public static void main(String[] args) {
/*

        Scanner scanner = null;
        GParser parser =  null;
        try{
            ANTLRInputStream input = new ANTLRInputStream(new FileReader("prueba.txt"));
            scanner = new Scanner(input);
            List<Token> lista = (List<Token>) scanner.getAllTokens();
            for (Token t : lista)
                System.out.println(t.getType() + " : '" + t.getText()+"'");
            scanner.reset();
            ANTLRInputStream input2 = new ANTLRInputStream(new FileReader("prueba.txt"));
            scanner = new Scanner(input2);

            CommonTokenStream tokens = new CommonTokenStream(scanner);
            parser = new GParser(tokens);

            parser.program();
            System.out.println("Compilacion Exitosa");


            //A contextual
            System.out.println("\n\nAnalisis Contextual\n\n");
            scanner.reset();
            ANTLRInputStream input3 = new ANTLRInputStream(new FileReader("prueba.txt"));
            scanner = new Scanner(input3);
            tokens = new CommonTokenStream(scanner);
            parser = new GParser(tokens);
            ParseTree raizContextual = parser.program();
            AContextual checker = new AContextual();
            checker.visit(raizContextual);

        }catch (Exception e){
            System.out.println("No hay archivo");
        }

*/
        new editor();
    }
}
