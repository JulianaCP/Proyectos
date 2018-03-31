
import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main{

    public static void main(String args[]){
        miniPythonLexer scanner = null;
        miniPythonParser parser = null;
        try {
            ANTLRInputStream input = new ANTLRInputStream(new FileReader("prueba.txt"));
            scanner = new miniPythonLexer(input);

            /*List<Token> lista = (List<Token>) scanner.getAllTokens();

            for (Token t : lista)
                System.out.println(t.getType() + " : '" + t.getText()+"'");

            scanner. reset();*/

            scanner = new miniPythonLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(scanner);
            parser = new miniPythonParser(tokens);

            ParseTree tree = parser.program();

            if (parser.getNumberOfSyntaxErrors() == 0) {

                CodeGen gen = new CodeGen();
                gen.visit(tree);

                System.out.println("Compilación Exitosa!!\n");
                System.out.println(tree.toStringTree(parser));
            }
            else
                System.out.println("Compilación Fallida!!\n");


        }
        catch(Exception e){
            System.out.println("No hay archivo");
            e.printStackTrace();
        }
    }
}