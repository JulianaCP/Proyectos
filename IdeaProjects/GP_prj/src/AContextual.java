import generated.GPParser;
import generated.GPParserBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * Created by oviquez on 30/3/2017.
 */
public class AContextual extends GPParserBaseVisitor {

    private TablaSimbolos tablaSimbolos;

    public AContextual(){
        tablaSimbolos = new TablaSimbolos();
    }

    @Override
    public Object visitCondecls(GPParser.CondeclsContext ctx) {

        visit(ctx.declarations());
        visit(ctx.statements());
        return null;
    }

    @Override
    public Object visitSindecls(GPParser.SindeclsContext ctx) {
        visit(ctx.statements());
        return null;
    }

    @Override
    public Object visitDecls(GPParser.DeclsContext ctx) {
        visit(ctx.declaration(0));
        for (int i=1; i <= ctx. declaration().size()-1; i++)
        {
            visit(ctx.declaration(i));
        }
        tablaSimbolos.imprimir();
        return null;
    }

    @Override
    public Object visitIntdecl(GPParser.IntdeclContext ctx) {

        List<TerminalNode> listaIDs = (List<TerminalNode>) visit(ctx.idlist());
        for (TerminalNode id : listaIDs){
            tablaSimbolos.insertar(id.getSymbol().getText(),0,ctx);
        }

        return null;
    }

    @Override
    public Object visitStrdecl(GPParser.StrdeclContext ctx) {

        List<TerminalNode> listaIDs = (List<TerminalNode>) visit(ctx.idlist());
        for (TerminalNode id : listaIDs){
            tablaSimbolos.insertar(id.getSymbol().getText(),1,ctx);
        }

        return null;
    }

    @Override
    public Object visitStats(GPParser.StatsContext ctx) {

        for (GPParser.StatementContext i : ctx.statement())
            visit(i);

        return null;
    }

    @Override
    public Object visitAsignstat(GPParser.AsignstatContext ctx) {

        TablaSimbolos.Ident i = tablaSimbolos.buscar(ctx.ID().getSymbol().getText());

        if (i != null) {
            int t1,t2;
            t1 = i.tok.getType();
            t2 = (int) visit(ctx.expression());

            if (t1 != t2)
                System.out.println("Tipos incompatibles en fila:  "+ctx.ASIGN().getSymbol().getLine()
                        + " columna: " + ctx.ASIGN().getSymbol().getCharPositionInLine());
        }
        else
            System.out.println("Identificador desconocido en "+ctx.ID().getSymbol().getLine() + ":"
                    +ctx.ID().getSymbol().getCharPositionInLine());

        return null;

    }

    @Override
    public Object visitExprstat(GPParser.ExprstatContext ctx) {
        return super.visitExprstat(ctx);
    }

    @Override
    public Object visitEpsstat(GPParser.EpsstatContext ctx) {
        return super.visitEpsstat(ctx);
    }

    @Override
    public Object visitExpr(GPParser.ExprContext ctx) {
        return visit(ctx.term(0));
    }

    @Override
    public Object visitTerm1(GPParser.Term1Context ctx) {
        return visit(ctx.factor(0));
    }

    @Override
    public Object visitGroupfact(GPParser.GroupfactContext ctx) {
        return super.visitGroupfact(ctx);
    }

    @Override
    public Object visitIdfact(GPParser.IdfactContext ctx) {
        return super.visitIdfact(ctx);
    }

    @Override
    public Object visitNumfact(GPParser.NumfactContext ctx) {
        return 0; //devuelve un objeto integer
    }

    @Override
    public Object visitStrfact(GPParser.StrfactContext ctx) {
        return 1;
    }

    @Override
    public Object visitIdlist1(GPParser.Idlist1Context ctx) {
        return ctx.ID();
    }
}
