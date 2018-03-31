// Generated from C:/Users/Pruebas/IdeaProjects/proyecto_1\GParser.g4 by ANTLR 4.6
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code stamentprogram}
	 * labeled alternative in {@link GParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStamentprogram(GParser.StamentprogramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defstamentcall}
	 * labeled alternative in {@link GParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefstamentcall(GParser.DefstamentcallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifstamentcall}
	 * labeled alternative in {@link GParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstamentcall(GParser.IfstamentcallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnstamentcall}
	 * labeled alternative in {@link GParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnstamentcall(GParser.ReturnstamentcallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printstamentcall}
	 * labeled alternative in {@link GParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintstamentcall(GParser.PrintstamentcallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whilestamentcall}
	 * labeled alternative in {@link GParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestamentcall(GParser.WhilestamentcallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assigstamentcall}
	 * labeled alternative in {@link GParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigstamentcall(GParser.AssigstamentcallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functioncallstamentcall}
	 * labeled alternative in {@link GParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncallstamentcall(GParser.FunctioncallstamentcallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defstamentfun}
	 * labeled alternative in {@link GParser#defStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefstamentfun(GParser.DefstamentfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idarglist}
	 * labeled alternative in {@link GParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdarglist(GParser.IdarglistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code espacarglist}
	 * labeled alternative in {@link GParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEspacarglist(GParser.EspacarglistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moreargsfun}
	 * labeled alternative in {@link GParser#moreArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreargsfun(GParser.MoreargsfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifstamentfun}
	 * labeled alternative in {@link GParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstamentfun(GParser.IfstamentfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whilestamentfun}
	 * labeled alternative in {@link GParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestamentfun(GParser.WhilestamentfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnstamentfun}
	 * labeled alternative in {@link GParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnstamentfun(GParser.ReturnstamentfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printstamentfun}
	 * labeled alternative in {@link GParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintstamentfun(GParser.PrintstamentfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assigstamentfun}
	 * labeled alternative in {@link GParser#assignStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigstamentfun(GParser.AssigstamentfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functcallstamentfun}
	 * labeled alternative in {@link GParser#functionCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctcallstamentfun(GParser.FunctcallstamentfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sequencefun}
	 * labeled alternative in {@link GParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequencefun(GParser.SequencefunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code morestamentfun}
	 * labeled alternative in {@link GParser#moreStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMorestamentfun(GParser.MorestamentfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressinfun}
	 * labeled alternative in {@link GParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressinfun(GParser.ExpressinfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonfun}
	 * labeled alternative in {@link GParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonfun(GParser.ComparisonfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code menorfun}
	 * labeled alternative in {@link GParser#comparisonValores}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenorfun(GParser.MenorfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mayorfun}
	 * labeled alternative in {@link GParser#comparisonValores}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMayorfun(GParser.MayorfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code menorIgualfun}
	 * labeled alternative in {@link GParser#comparisonValores}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenorIgualfun(GParser.MenorIgualfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mayorigualfun}
	 * labeled alternative in {@link GParser#comparisonValores}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMayorigualfun(GParser.MayorigualfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code igualigualfun}
	 * labeled alternative in {@link GParser#comparisonValores}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgualigualfun(GParser.IgualigualfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addiexpressifun}
	 * labeled alternative in {@link GParser#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddiexpressifun(GParser.AddiexpressifunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addifactfun}
	 * labeled alternative in {@link GParser#additionFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddifactfun(GParser.AddifactfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sumafunc}
	 * labeled alternative in {@link GParser#factoresSumaResta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumafunc(GParser.SumafuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code restafunc}
	 * labeled alternative in {@link GParser#factoresSumaResta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestafunc(GParser.RestafuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multexpressifun}
	 * labeled alternative in {@link GParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultexpressifun(GParser.MultexpressifunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multfactfun}
	 * labeled alternative in {@link GParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultfactfun(GParser.MultfactfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multfunc}
	 * labeled alternative in {@link GParser#factoresMultDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultfunc(GParser.MultfuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divfunc}
	 * labeled alternative in {@link GParser#factoresMultDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivfunc(GParser.DivfuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elementexpressifun}
	 * labeled alternative in {@link GParser#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementexpressifun(GParser.ElementexpressifunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elementaccessfun}
	 * labeled alternative in {@link GParser#elementAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementaccessfun(GParser.ElementaccessfunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functcallexpressifun}
	 * labeled alternative in {@link GParser#functionCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctcallexpressifun(GParser.FunctcallexpressifunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressiexpressilist}
	 * labeled alternative in {@link GParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressiexpressilist(GParser.ExpressiexpressilistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code espacexpressilist}
	 * labeled alternative in {@link GParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEspacexpressilist(GParser.EspacexpressilistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moreexpressifun}
	 * labeled alternative in {@link GParser#moreExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreexpressifun(GParser.MoreexpressifunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intprimatiespresi}
	 * labeled alternative in {@link GParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntprimatiespresi(GParser.IntprimatiespresiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringprimatiexpresi}
	 * labeled alternative in {@link GParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringprimatiexpresi(GParser.StringprimatiexpresiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idprimatiexpresi}
	 * labeled alternative in {@link GParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdprimatiexpresi(GParser.IdprimatiexpresiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charprimatiexpresi}
	 * labeled alternative in {@link GParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharprimatiexpresi(GParser.CharprimatiexpresiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresiprimatiexpresi}
	 * labeled alternative in {@link GParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresiprimatiexpresi(GParser.ExpresiprimatiexpresiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listexpresiprimatiexpresi}
	 * labeled alternative in {@link GParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListexpresiprimatiexpresi(GParser.ListexpresiprimatiexpresiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lenprimatiexpresi}
	 * labeled alternative in {@link GParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLenprimatiexpresi(GParser.LenprimatiexpresiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functcallexpresiprimatiexpresi}
	 * labeled alternative in {@link GParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctcallexpresiprimatiexpresi(GParser.FunctcallexpresiprimatiexpresiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listexpresifun}
	 * labeled alternative in {@link GParser#listExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListexpresifun(GParser.ListexpresifunContext ctx);
}