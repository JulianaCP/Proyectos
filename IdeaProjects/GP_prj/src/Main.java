/**
 * Created by oviquez on 2/3/2017.
 */

import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = null;
        GPParser parser = null;
        try {
            ANTLRInputStream input = new ANTLRInputStream(new FileReader("prueba.txt"));
            scanner = new Scanner(input);

            /*
            List<Token> lista = (List<Token>) scanner.getAllTokens();
            for (Token t : lista)
                System.out.println(t.getType() + " : '" + t.getText()+"'");
            scanner.reset();
            */


            scanner = new Scanner(input);
            CommonTokenStream tokens = new CommonTokenStream(scanner);
            parser = new GPParser(tokens);

            ParseTree raiz = parser.program();

       //     System.out.println(raiz.toStringTree(parser));
       //     PrettyPrint print = new PrettyPrint();

        //    print.visit(raiz);

           // AContextual checker = new AContextual();
          //  checker.visit(raiz);

            CodeGen coder = new CodeGen();
            coder.visit(raiz);

        }
        catch(Exception e){
            System.out.println("No hay archivo");
        }
    }
}
