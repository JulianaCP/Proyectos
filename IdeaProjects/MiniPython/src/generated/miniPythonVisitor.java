// Generated from C:/Users/Pruebas/IdeaProjects/MiniPython\miniPython.g4 by ANTLR 4.6
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link miniPythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface miniPythonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program_AST}
	 * labeled alternative in {@link miniPythonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_AST(miniPythonParser.Program_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Statement_DefStatement_AST}
	 * labeled alternative in {@link miniPythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_DefStatement_AST(miniPythonParser.Statement_DefStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Statement_IfStatement_AST}
	 * labeled alternative in {@link miniPythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_IfStatement_AST(miniPythonParser.Statement_IfStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Statement_ReturnStatement_AST}
	 * labeled alternative in {@link miniPythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_ReturnStatement_AST(miniPythonParser.Statement_ReturnStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Statement_PrintStatement_AST}
	 * labeled alternative in {@link miniPythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_PrintStatement_AST(miniPythonParser.Statement_PrintStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Statement_WhileStatement_AST}
	 * labeled alternative in {@link miniPythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_WhileStatement_AST(miniPythonParser.Statement_WhileStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Statement_AssignStatement_AST}
	 * labeled alternative in {@link miniPythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_AssignStatement_AST(miniPythonParser.Statement_AssignStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Statement_FunctionCallStatement_AST}
	 * labeled alternative in {@link miniPythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_FunctionCallStatement_AST(miniPythonParser.Statement_FunctionCallStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefStatement_AST}
	 * labeled alternative in {@link miniPythonParser#defStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefStatement_AST(miniPythonParser.DefStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgList_MoreArgs_AST}
	 * labeled alternative in {@link miniPythonParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList_MoreArgs_AST(miniPythonParser.ArgList_MoreArgs_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgList_Epsilon_AST}
	 * labeled alternative in {@link miniPythonParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList_Epsilon_AST(miniPythonParser.ArgList_Epsilon_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MoreArgs_AST}
	 * labeled alternative in {@link miniPythonParser#moreArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreArgs_AST(miniPythonParser.MoreArgs_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement_AST}
	 * labeled alternative in {@link miniPythonParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement_AST(miniPythonParser.IfStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStatement_AST}
	 * labeled alternative in {@link miniPythonParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement_AST(miniPythonParser.WhileStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStatement_AST}
	 * labeled alternative in {@link miniPythonParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement_AST(miniPythonParser.ReturnStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStatement_AST}
	 * labeled alternative in {@link miniPythonParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement_AST(miniPythonParser.PrintStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStatement_AST}
	 * labeled alternative in {@link miniPythonParser#assignStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatement_AST(miniPythonParser.AssignStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallStatement_AST}
	 * labeled alternative in {@link miniPythonParser#functionCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStatement_AST(miniPythonParser.FunctionCallStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniPythonParser#fceEnding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFceEnding(miniPythonParser.FceEndingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sequence_AST}
	 * labeled alternative in {@link miniPythonParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence_AST(miniPythonParser.Sequence_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MoreStatement_AST}
	 * labeled alternative in {@link miniPythonParser#moreStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreStatement_AST(miniPythonParser.MoreStatement_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expression_AST}
	 * labeled alternative in {@link miniPythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_AST(miniPythonParser.Expression_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison_AST}
	 * labeled alternative in {@link miniPythonParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_AST(miniPythonParser.Comparison_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditionExpression_AST}
	 * labeled alternative in {@link miniPythonParser#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpression_AST(miniPythonParser.AdditionExpression_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditionFactor_AST}
	 * labeled alternative in {@link miniPythonParser#additionFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionFactor_AST(miniPythonParser.AdditionFactor_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicationExpression_AST}
	 * labeled alternative in {@link miniPythonParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression_AST(miniPythonParser.MultiplicationExpression_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicationFactor_AST}
	 * labeled alternative in {@link miniPythonParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationFactor_AST(miniPythonParser.MultiplicationFactor_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElementExpression_AST}
	 * labeled alternative in {@link miniPythonParser#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementExpression_AST(miniPythonParser.ElementExpression_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElementAccess_AST}
	 * labeled alternative in {@link miniPythonParser#elementAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementAccess_AST(miniPythonParser.ElementAccess_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpression_AST}
	 * labeled alternative in {@link miniPythonParser#functionCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression_AST(miniPythonParser.FunctionCallExpression_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionList_AST}
	 * labeled alternative in {@link miniPythonParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList_AST(miniPythonParser.ExpressionList_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionList_EPSILON_AST}
	 * labeled alternative in {@link miniPythonParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList_EPSILON_AST(miniPythonParser.ExpressionList_EPSILON_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MoreExpressions_AST}
	 * labeled alternative in {@link miniPythonParser#moreExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreExpressions_AST(miniPythonParser.MoreExpressions_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveExpression_NUM_AST}
	 * labeled alternative in {@link miniPythonParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveExpression_NUM_AST(miniPythonParser.PrimitiveExpression_NUM_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveExpression_STR_AST}
	 * labeled alternative in {@link miniPythonParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveExpression_STR_AST(miniPythonParser.PrimitiveExpression_STR_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveExpression_IDENTIFIER_AST}
	 * labeled alternative in {@link miniPythonParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveExpression_IDENTIFIER_AST(miniPythonParser.PrimitiveExpression_IDENTIFIER_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveExpression_CHAR_AST}
	 * labeled alternative in {@link miniPythonParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveExpression_CHAR_AST(miniPythonParser.PrimitiveExpression_CHAR_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveExpression_Expression_AST}
	 * labeled alternative in {@link miniPythonParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveExpression_Expression_AST(miniPythonParser.PrimitiveExpression_Expression_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveExpression_ListExpression_AST}
	 * labeled alternative in {@link miniPythonParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveExpression_ListExpression_AST(miniPythonParser.PrimitiveExpression_ListExpression_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveExpression_Len_Expression_AST}
	 * labeled alternative in {@link miniPythonParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveExpression_Len_Expression_AST(miniPythonParser.PrimitiveExpression_Len_Expression_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveExpression_FunctionCallExpression_AST}
	 * labeled alternative in {@link miniPythonParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveExpression_FunctionCallExpression_AST(miniPythonParser.PrimitiveExpression_FunctionCallExpression_ASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListExpression_AST}
	 * labeled alternative in {@link miniPythonParser#listExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpression_AST(miniPythonParser.ListExpression_ASTContext ctx);
}