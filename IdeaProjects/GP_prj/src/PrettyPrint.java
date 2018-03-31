import generated.GPParser;
import generated.GPParserBaseVisitor;

/**
 * Created by oviquez on 8/9/2016.
 */
public class PrettyPrint extends GPParserBaseVisitor<Object>{

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
    @Override public Object visitCondecls(GPParser.CondeclsContext ctx) {
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
    @Override public Object visitSindecls(GPParser.SindeclsContext ctx) {
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
    @Override public Object visitDecls(GPParser.DeclsContext ctx) {
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
    @Override public Object visitIntdecl(GPParser.IntdeclContext ctx) {
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
    @Override public Object visitStrdecl(GPParser.StrdeclContext ctx) {
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
    @Override public Object visitStats(GPParser.StatsContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        for (GPParser.StatementContext i : ctx.statement())
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
    @Override public Object visitAsignstat(GPParser.AsignstatContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExprstat(GPParser.ExprstatContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitEpsstat(GPParser.EpsstatContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpr(GPParser.ExprContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitTerm1(GPParser.Term1Context ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitGroupfact(GPParser.GroupfactContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIdfact(GPParser.IdfactContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitNumfact(GPParser.NumfactContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStrfact(GPParser.StrfactContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIdlist1(GPParser.Idlist1Context ctx) {
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
