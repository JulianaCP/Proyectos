package generated;


import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * Created by Pruebas on 30/03/2017.
 */
public class AContextual extends ParserGrammarBaseVisitor {
    private TablaSimbolos tablaSimbolos;
    @Override
    public Object visitCondecls(ParserGrammar.CondeclsContext ctx) {
        visit(ctx.declarations());
        visit(ctx.statements());
        return null;
    }

    @Override
    public Object visitSindecls(ParserGrammar.SindeclsContext ctx) {
        visit(ctx.statements());
        return null;
    }

    @Override
    public Object visitDecls(ParserGrammar.DeclsContext ctx) {
        visit(ctx.declaration(0));
        for (int i=1; i <= ctx. declaration().size()-1; i++)
        {
            visit(ctx.declaration(i));
        }
        return null;
    }

    @Override
    public Object visitIntdecl(ParserGrammar.IntdeclContext ctx) {
        //se obtiene la lista de identificadores (hay que hacer casting xq devuelve object)
        List<TerminalNode> listaIDa = (List<TerminalNode>)visit(ctx.idlist());
        for(TerminalNode id : listaIDa){
            tablaSimbolos.insertar(id.getSymbol().getText(),0,ctx);
        }
        return null;
    }

    @Override
    public Object visitStrdecl(ParserGrammar.StrdeclContext ctx) {
        return super.visitStrdecl(ctx);
    }

    @Override
    public Object visitStats(ParserGrammar.StatsContext ctx) {
        for (ParserGrammar.StatementContext i : ctx.statement())
            visit(i);
        return null;
    }

    @Override
    public Object visitAsignstat(ParserGrammar.AsignstatContext ctx) {
        TablaSimbolos.Ident i = tablaSimbolos.buscar(ctx.ID().getSymbol().getText());
        if(i != null){
            int t1,t2;
            t1 = i.tok.getType();
            t2 = (int) visit(ctx.expression());
            if(t1 != t2){
                System.out.println("Tipos Incompatibles");
            }
        }
        else{
            System.out.println("Identificador desconocido");
        }
        return null;
    }

    @Override
    public Object visitExprstat(ParserGrammar.ExprstatContext ctx) {
        return super.visitExprstat(ctx);
    }

    @Override
    public Object visitEpsstat(ParserGrammar.EpsstatContext ctx) {
        return super.visitEpsstat(ctx);
    }

    @Override
    public Object visitExpr(ParserGrammar.ExprContext ctx) {
        return super.visitExpr(ctx);
    }

    @Override
    public Object visitTerm1(ParserGrammar.Term1Context ctx) {
        return super.visitTerm1(ctx);
    }

    @Override
    public Object visitGroupfact(ParserGrammar.GroupfactContext ctx) {
        return super.visitGroupfact(ctx);
    }

    @Override
    public Object visitIdfact(ParserGrammar.IdfactContext ctx) {
        return super.visitIdfact(ctx);
    }

    @Override
    public Object visitNumfact(ParserGrammar.NumfactContext ctx) {
        return super.visitNumfact(ctx);
    }

    @Override
    public Object visitStrfact(ParserGrammar.StrfactContext ctx) {
        return super.visitStrfact(ctx);
    }

    @Override
    public Object visitIdlist1(ParserGrammar.Idlist1Context ctx) {
        return ctx.ID();
    }
}
