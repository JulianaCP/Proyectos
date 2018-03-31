/**
 * Created by Pruebas on 09/03/2017.
 */

import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileReader;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = null;
        ParserGrammar parser = null;

        try {
            //ANTLRInputStream para declarar archivo
            ANTLRInputStream input = new ANTLRInputStream(new FileReader("prueba.txt"));
            scanner = new Scanner(input);


            CommonTokenStream tokens = new CommonTokenStream(scanner);
            parser = new ParserGrammar(tokens);

/*

            List<Token> lista = (List<Token>) scanner.getAllTokens();
            //scanner.getAllTokens(); todos los tokens en una lista// pero deja el puntero al final

            //uno por uno es
            //scanner.nextToken()

            for (Token t : lista)
                System.out.println(t.getType() + " : '" + t.getText()+"'");
            //type = num ...... getType
            // lexema = cadena
            //fila    getCharPositionInLine
            //column

            scanner.reset(); // lo hace para q lo coloque al inicio y no al final
*/
            //cada uno de los metodos me devuelve un nodo de arbol
            ParseTree raiz = parser.program();

          //  System.out.println(raiz.toStringTree(parser));

            PrettyPrint print = new PrettyPrint();

            print.visit(raiz);
        }
        catch(Exception e){
            System.out.println("No hay archivo");
        }
    }
}
