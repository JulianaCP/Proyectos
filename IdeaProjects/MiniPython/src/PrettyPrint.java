import generated.*;
/**
 * Created by oviquez on 8/9/2016.
 */
public class PrettyPrint extends miniPythonBaseVisitor<Object> {

    private int cont = 0;

    private void printtab(int n) {
        for (int num = n; num != 0; num--)
            System.out.print("+++");
        System.out.print(">");
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitProgram_AST(miniPythonParser.Program_ASTContext ctx) {
        printtab(cont);
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
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_DefStatement_AST(miniPythonParser.Statement_DefStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_IfStatement_AST(miniPythonParser.Statement_IfStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_ReturnStatement_AST(miniPythonParser.Statement_ReturnStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_PrintStatement_AST(miniPythonParser.Statement_PrintStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_WhileStatement_AST(miniPythonParser.Statement_WhileStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_AssignStatement_AST(miniPythonParser.Statement_AssignStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement_FunctionCallStatement_AST(miniPythonParser.Statement_FunctionCallStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitDefStatement_AST(miniPythonParser.DefStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitArgList_MoreArgs_AST(miniPythonParser.ArgList_MoreArgs_ASTContext ctx) {         printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitArgList_Epsilon_AST(miniPythonParser.ArgList_Epsilon_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMoreArgs_AST(miniPythonParser.MoreArgs_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIfStatement_AST(miniPythonParser.IfStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitWhileStatement_AST(miniPythonParser.WhileStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitReturnStatement_AST(miniPythonParser.ReturnStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrintStatement_AST(miniPythonParser.PrintStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAssignStatement_AST(miniPythonParser.AssignStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitFunctionCallStatement_AST(miniPythonParser.FunctionCallStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitFceEnding(miniPythonParser.FceEndingContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitSequence_AST(miniPythonParser.Sequence_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMoreStatement_AST(miniPythonParser.MoreStatement_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpression_AST(miniPythonParser.Expression_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitComparison_AST(miniPythonParser.Comparison_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAdditionExpression_AST(miniPythonParser.AdditionExpression_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAdditionFactor_AST(miniPythonParser.AdditionFactor_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMultiplicationExpression_AST(miniPythonParser.MultiplicationExpression_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMultiplicationFactor_AST(miniPythonParser.MultiplicationFactor_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitElementExpression_AST(miniPythonParser.ElementExpression_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitElementAccess_AST(miniPythonParser.ElementAccess_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitFunctionCallExpression_AST(miniPythonParser.FunctionCallExpression_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpressionList_AST(miniPythonParser.ExpressionList_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpressionList_EPSILON_AST(miniPythonParser.ExpressionList_EPSILON_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMoreExpressions_AST(miniPythonParser.MoreExpressions_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_NUM_AST(miniPythonParser.PrimitiveExpression_NUM_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_STR_AST(miniPythonParser.PrimitiveExpression_STR_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_IDENTIFIER_AST(miniPythonParser.PrimitiveExpression_IDENTIFIER_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_CHAR_AST(miniPythonParser.PrimitiveExpression_CHAR_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_Expression_AST(miniPythonParser.PrimitiveExpression_Expression_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_ListExpression_AST(miniPythonParser.PrimitiveExpression_ListExpression_ASTContext ctx) {         printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_Len_Expression_AST(miniPythonParser.PrimitiveExpression_Len_Expression_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitiveExpression_FunctionCallExpression_AST(miniPythonParser.PrimitiveExpression_FunctionCallExpression_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitListExpression_AST(miniPythonParser.ListExpression_ASTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;

        //visitas

        cont--;

        return null;
    }
    
}