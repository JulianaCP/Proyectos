package generated;

/**
 * Created by Juliana on 21/03/2017.
 */
import generated.ParserGrammar;
import generated.ParserGrammarBaseVisitor;

/**
 * Created by oviquez on 8/9/2016.
 */
public class PrettyPrint extends ParserGrammarBaseVisitor<Object>{

    private int cont=0;

    private void printtab(int n)
    {
        for(int num=n; num != 0; num--)
            System.out.print("+++");
        System.out.print(">");
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitCondecls(ParserGrammar.CondeclsContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.declarations());
        visit(ctx.statements());
        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitSindecls(ParserGrammar.SindeclsContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.statements());
        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitDecls(ParserGrammar.DeclsContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.declaration(0));
        for (int i=1; i <= ctx. declaration().size()-1; i++)
        {
            visit(ctx.declaration(i));
        }
        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIntdecl(ParserGrammar.IntdeclContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());
        cont++;
        visit(ctx.idlist());
        //System.out.println("");
        cont--;
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStrdecl(ParserGrammar.StrdeclContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.idlist());
        //System.out.println("");
        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStats(ParserGrammar.StatsContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        for (ParserGrammar.StatementContext i : ctx.statement())
            visit(i);

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAsignstat(ParserGrammar.AsignstatContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExprstat(ParserGrammar.ExprstatContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitEpsstat(ParserGrammar.EpsstatContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpr(ParserGrammar.ExprContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitTerm1(ParserGrammar.Term1Context ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitGroupfact(ParserGrammar.GroupfactContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIdfact(ParserGrammar.IdfactContext ctx) {
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitNumfact(ParserGrammar.NumfactContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStrfact(ParserGrammar.StrfactContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        printtab(cont + 1);
        System.out.println(" TokenSTRING --> " + ctx.STR().getSymbol().getText());
        cont--;
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIdlist1(ParserGrammar.Idlist1Context ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        for (int i = 0; i <= ctx.ID().size() - 1; i++)
        {
            printtab(cont + 1);
            System.out.println(" TokenID --> " + ctx.ID(i).getSymbol().getText());
        }
        cont--;
        return null;
    }

}
/*
public class PrettyPrint extends ParserGrammarBaseVisitor {

    @Override public Object visitStats(ParserGrammar.StatsContext ctx){
        //printTab(cont);
      //  cont++;
        for(ParserGrammar.StatementContext i : ctx.statement()){
            visit(i);
        }
       // cont--;
        return null;
    }
}
*/