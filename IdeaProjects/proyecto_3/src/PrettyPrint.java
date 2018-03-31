
import generated.GParserBaseVisitor;
import generated.GParser;
import generated.Global;
import org.antlr.v4.runtime.Parser;

public class PrettyPrint extends GParserBaseVisitor<Object> {

    private int cont=0;
    String total="";

    private String printtab(int n)
    {
        total="";
        for(int num=n; num != 0; num--){
            total=total+"+++";
            System.out.print("+++");
        }
        total=total+">";
        System.out.print(">");
        return total;
    }


    //numero 1
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    String reg = "";
    @Override public Object visitStamentprogram (GParser.StamentprogramContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.statement(0));
        for (int i=1; i <= ctx.statement().size()-1; i++)
        {
            visit(ctx.statement(i));
        }
        cont--;
        return null;
    }


    //numero 2


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitDefstamentcall (GParser.DefstamentcallContext ctx) {
        printtab(cont);
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);

        cont++;
        visit(ctx.defStatement());
        cont--;
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIfstamentcall (GParser.IfstamentcallContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();

        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);
        cont++;
        visit(ctx.ifStatement());
        cont--;
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitReturnstamentcall (GParser.ReturnstamentcallContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);
        cont++;
        visit(ctx.returnStatement());
        cont--;
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrintstamentcall (GParser.PrintstamentcallContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);
        cont++;
        visit(ctx.printStatement());
        cont--;
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitWhilestamentcall (GParser.WhilestamentcallContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);
        cont++;
        visit(ctx.whileStatement());
        cont--;
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAssigstamentcall (GParser.AssigstamentcallContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);
        cont++;
        visit(ctx.assignStatement());
        cont--;
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitFunctioncallstamentcall (GParser.FunctioncallstamentcallContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);
        cont++;
        visit(ctx.functionCallStatement());
        cont--;
        return null;
    }



    //numero 3



    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitDefstamentfun (GParser.DefstamentfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);

        reg = printtab(cont + 1);
        reg = reg + " TokenID --> " + ctx.ID().getSymbol().getText();
        System.out.println(" TokenID --> " + ctx.ID().getSymbol().getText());
        Global.modeloG.addElement(reg);

        cont++;
        visit(ctx.argList());
        visit(ctx.sequence());
        cont--;
        return null;
    }


    //numero 4

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIdarglist (GParser.IdarglistContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);

        reg = printtab(cont + 1);
        reg = reg + " TokenID --> " + ctx.ID().getSymbol().getText();
        System.out.println(" TokenID --> " + ctx.ID().getSymbol().getText());
        Global.modeloG.addElement(reg);

        cont++;
        visit(ctx.moreArgs());
        cont--;
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitEspacarglist (GParser.EspacarglistContext ctx) {  //corregir
        return null;
    }


    //numero 5

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMoreargsfun (GParser.MoreargsfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);

        cont++;
        for (int i = 0; i <= ctx.ID().size() - 1; i++)
        {
            reg = printtab(cont + 1);
            reg = reg + " TokenID --> " + ctx.ID(i).getSymbol().getText();
            System.out.println(" TokenID --> " + ctx.ID(i).getSymbol().getText());
            Global.modeloG.addElement(reg);
        }
        cont--;
        return null;
    }



    //numero 6
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIfstamentfun (GParser.IfstamentfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);
        cont++;
        visit(ctx.expression());
        for (int i = 0; i <= ctx.sequence().size() - 1; i++)
        {
            visit(ctx.sequence(i));
        }
        cont--;
        return null;
    }



    //numero 7

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitWhilestamentfun (GParser.WhilestamentfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);
        cont++;
        visit(ctx.expression());
        visit(ctx.sequence());
        cont--;
        return null;
    }

    //numero 8

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitReturnstamentfun (GParser.ReturnstamentfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);
        cont++;
        visit(ctx.expression());
        cont--;
        return null;
    }


    //numero 9

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrintstamentfun (GParser.PrintstamentfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);
        cont++;
        visit(ctx.expression());
        cont--;
        return null;
    }



    //numero 10

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAssigstamentfun (GParser.AssigstamentfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);

        reg = printtab(cont + 1);
        reg = reg + " TokenID --> " + ctx.ID().getSymbol().getText();
        System.out.println(" TokenID --> " + ctx.ID().getSymbol().getText());
        Global.modeloG.addElement(reg);

        cont++;
        visit(ctx.expression());
        cont--;
        return null;
    }
    //////        11 FunctionCallStatement

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    public Object visitFunctcallstamentfun(GParser.FunctcallstamentfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.primitiveExpression());
        visit(ctx.expressionList());
        cont--;

        return null;
    }


    //////   12 sequencefun
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitSequencefun(GParser.SequencefunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.moreStatement());
        cont--;

        return null;
    }




    //////        13 morestamentfun
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMorestamentfun(GParser.MorestamentfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.statement(0));
        for (int i=1; i <= ctx. statement().size()-1; i++)
        {
            visit(ctx.statement(i));
        }
        cont--;
        return null;
    }



    ///        14 expressinfun

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override public Object visitExpressinfun(GParser.ExpressinfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.additionExpression());
        visit(ctx.comparison());
        cont--;

        return null;
    }



    /////      15 comparisonfun

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitComparisonfun(GParser.ComparisonfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        for (int i=0; i <= ctx. additionExpression().size()-1; i++)
        {
            visit(ctx.comparisonValores(i));
            visit(ctx.additionExpression(i));
        }
        cont--;
        return null;
    }


    ///     15 comparison medio


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitMenorfun(GParser.MenorfunContext ctx) {
        reg = printtab(cont);
        reg = reg + " Token Comparacion --> " + ctx.MENOR().getSymbol().getText();
        Global.modeloG.addElement(reg);

        System.out.println(" Token Comparacion --> " + ctx.MENOR().getSymbol().getText());
        return null;
    }



    ///     15 comparison medio


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitMayorfun(GParser.MayorfunContext ctx) {
        reg = printtab(cont);
        reg = reg + " Token Comparación --> " + ctx.MAYOR().getSymbol().getText();
        Global.modeloG.addElement(reg);

        System.out.println(" Token Comparacion --> " + ctx.MAYOR().getSymbol().getText());
        return null;
    }



    ///     15 comparison medio


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitMenorIgualfun(GParser.MenorIgualfunContext ctx) {
        reg = printtab(cont);
        reg = reg + " Token Comparacion --> " + ctx.MenorIGUAL().getSymbol().getText();
        Global.modeloG.addElement(reg);

        System.out.println(" Token Comparacion --> " + ctx.MenorIGUAL().getSymbol().getText());
        return null;
    }



    ///     15 comparison medio


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitMayorigualfun(GParser.MayorigualfunContext ctx) {
        reg = printtab(cont);
        reg = reg + " Token Comparacion --> " + ctx.MayorIGUAL().getSymbol().getText();
        Global.modeloG.addElement(reg);

        System.out.println(" Token Comparacion --> " + ctx.MayorIGUAL().getSymbol().getText());
        return null;
    }



    ///     15 comparison medio


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitIgualigualfun(GParser.IgualigualfunContext ctx) {
        reg = printtab(cont);
        reg = reg + " Token Comparacion --> " + ctx.IgualIGUAL().getSymbol().getText();
        Global.modeloG.addElement(reg);

        System.out.println(" Token Comparacion --> " + ctx.IgualIGUAL().getSymbol().getText());
        return null;
    }

    ////     16 addiexpressifun

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitAddiexpressifun(GParser.AddiexpressifunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.multiplicationExpression());
        visit(ctx.additionFactor());
        cont--;

        return null;
    }



    ///     17  addifactfun
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override public Object visitAddifactfun(GParser.AddifactfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        for (int i=0; i <= ctx. multiplicationExpression().size()-1; i++)
        {
            visit(ctx.factoresSumaResta(i));
            visit(ctx.multiplicationExpression(i));
        }
        cont--;
        return null;
    }


    ///     17  medio

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitSumafunc(GParser.SumafuncContext ctx)  {
        reg = printtab(cont);
        reg = reg + " Token Operador --> " + ctx.SUMA().getSymbol().getText();
        Global.modeloG.addElement(reg);

        System.out.println(" Token Operador --> " + ctx.SUMA().getSymbol().getText());
        return null;
    }


    ///     17  medio


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitRestafunc(GParser.RestafuncContext ctx) {
        reg = printtab(cont);
        reg = reg + " Token Operador --> " + ctx.RESTA().getSymbol().getText();
        Global.modeloG.addElement(reg);

        System.out.println(" Token Operador --> " + ctx.RESTA().getSymbol().getText());
        return null;
    }




    ///     18 multexpressifun

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override public Object visitMultexpressifun(GParser.MultexpressifunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.elementExpression());
        visit(ctx.multiplicationFactor());
        cont--;

        return null;
    }


    /////      19 multfactfun

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override public Object visitMultfactfun(GParser.MultfactfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        for (int i=0; i <= ctx. elementExpression().size()-1; i++)
        {
            visit(ctx.factoresMultDiv(i));
            visit(ctx.elementExpression(i));
        }
        cont--;
        return null;
    }


    //19 y medio
    ///     17  medio


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitMultfunc(GParser.MultfuncContext ctx) {
        reg = printtab(cont);
        reg = reg + " Token Operador --> " + ctx.MULT().getSymbol().getText();
        Global.modeloG.addElement(reg);

        System.out.println(" Token Operador --> " + ctx.MULT().getSymbol().getText());
        return null;
    }

    ///     19  medio

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitDivfunc(GParser.DivfuncContext ctx) {
        reg = printtab(cont);
        reg = reg + " Token Operador --> " + ctx.DIV().getSymbol().getText();
        Global.modeloG.addElement(reg);

        System.out.println(" Token Operador --> " + ctx.DIV().getSymbol().getText());
        return null;
    }


    //////     20 elementexpressifun

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitElementexpressifun(GParser.ElementexpressifunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        System.out.println(ctx.getClass().getSimpleName());
        cont++;
        visit(ctx.primitiveExpression());
        visit(ctx.elementAccess());
        cont--;

        return null;
    }

    //numero 21

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitElementaccessfun (GParser.ElementaccessfunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);
        cont++;

        for (int i = 0; i <= ctx.expression().size() - 1; i++)
        {
            visit(ctx.expression(i));
        }
        cont--;
        return null;
    }


    //numero 22

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitFunctcallexpressifun (GParser.FunctcallexpressifunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);

        reg = printtab(cont + 1);
        reg = reg + " TokenID --> " + ctx.ID().getSymbol().getText();
        System.out.println(" TokenID --> " + ctx.ID().getSymbol().getText());
        Global.modeloG.addElement(reg);

        cont++;
        visit(ctx.expressionList());
        cont--;
        return null;
    }

    //numero 22

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpressiexpressilist (GParser.ExpressiexpressilistContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        System.out.println(ctx.getClass().getSimpleName());
        Global.modeloG.addElement(reg);
        cont++;
        visit(ctx.expression());
        visit(ctx.moreExpressions());
        cont--;
        return null;
    }


    //numero 23

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitEspacexpressilist (GParser.EspacexpressilistContext ctx) {
        return null;
    }


    //       24 moreexpressifun

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitMoreexpressifun(GParser.MoreexpressifunContext ctx) {
        reg = printtab(cont);
        reg = reg + ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        for (int i=0; i <= ctx. expression().size()-1; i++)
        {
            visit(ctx.expression(i));
        }
        cont--;
        return null;
    }




    ///     25 intprimatiespresi


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitIntprimatiespresi(GParser.IntprimatiespresiContext ctx) {
        reg = printtab(cont);
        reg = reg + " Token INT --> " + ctx.INT().getSymbol().getText();
        Global.modeloG.addElement(reg);

        System.out.println(" Token INT --> " + ctx.INT().getSymbol().getText());
        return null;
    }


    /////        25 stringprimatiexpresi

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override public Object visitStringprimatiexpresi(GParser.StringprimatiexpresiContext ctx) {
        reg = printtab(cont);
        reg = reg + " Token STRING--> " + ctx.STRING().getSymbol().getText();
        Global.modeloG.addElement(reg);

        System.out.println(" Token STRING--> " + ctx.STRING().getSymbol().getText());
        return null;
    }



    /////     25 idprimatiexpresi
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitIdprimatiexpresi(GParser.IdprimatiexpresiContext ctx) {
        reg = printtab(cont);
        reg = reg + " Token ID --> " + ctx.ID().getSymbol().getText();
        Global.modeloG.addElement(reg);
        System.out.println(" Token ID --> " + ctx.ID().getSymbol().getText());
        return null;
    }



    /////// 25 charprimatiexpresi

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override public Object visitCharprimatiexpresi(GParser.CharprimatiexpresiContext ctx) {
        reg = printtab(cont);
        reg = reg + " Token CHAR --> " + ctx.CHAR().getSymbol().getText();
        Global.modeloG.addElement(reg);
        System.out.println(" Token CHAR --> " + ctx.CHAR().getSymbol().getText());
        return null;
    }





    /////    25 expresiprimatiexpresi
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitExpresiprimatiexpresi(GParser.ExpresiprimatiexpresiContext ctx) {
        reg = printtab(cont);
        reg = reg  +  ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);
        System.out.println(ctx.getClass().getSimpleName());
        cont++;
        visit(ctx.expression());
        cont--;

        return null;
    }


    //////          25 Listexpresiprimatiexpresi

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitListexpresiprimatiexpresi(GParser.ListexpresiprimatiexpresiContext ctx) {
        reg = printtab(cont);
        reg = reg  +  ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        cont++;
        visit(ctx.listExpression());
        cont--;

        return null;
    }


    ///// 25 lenprimatiexpresi LEN ParenIZQ expression ParenDER

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitLenprimatiexpresi(GParser.LenprimatiexpresiContext ctx) {
        reg = printtab(cont);
        reg = reg  +  ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        cont++;
        System.out.println(" Token LEN --> " + ctx.LEN().getSymbol().getText());
        visit(ctx.expression());
        cont--;

        return null;
    }


    ////             25 functcallexpresiprimatiexpresi
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override public Object visitFunctcallexpresiprimatiexpresi(GParser.FunctcallexpresiprimatiexpresiContext ctx) {
        reg = printtab(cont);
        reg = reg  +  ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);
        System.out.println(ctx.getClass().getSimpleName());
        cont++;
        visit(ctx.functionCallExpression());
        cont--;

        return null;
    }

    ///          26 listexpresifun
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitListexpresifun(GParser.ListexpresifunContext ctx) {
        reg = printtab(cont);
        reg = reg  +  ctx.getClass().getSimpleName();
        Global.modeloG.addElement(reg);

        cont++;
        visit(ctx.expressionList());
        cont--;

        return null;
    }
}