// Generated from C:/Users/Pruebas/IdeaProjects/GP_prj\GPParser.g4 by ANTLR 4.6
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GPParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GPParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code condecls}
	 * labeled alternative in {@link GPParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondecls(GPParser.CondeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sindecls}
	 * labeled alternative in {@link GPParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSindecls(GPParser.SindeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decls}
	 * labeled alternative in {@link GPParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecls(GPParser.DeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intdecl}
	 * labeled alternative in {@link GPParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntdecl(GPParser.IntdeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strdecl}
	 * labeled alternative in {@link GPParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrdecl(GPParser.StrdeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stats}
	 * labeled alternative in {@link GPParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStats(GPParser.StatsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asignstat}
	 * labeled alternative in {@link GPParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignstat(GPParser.AsignstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprstat}
	 * labeled alternative in {@link GPParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprstat(GPParser.ExprstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code epsstat}
	 * labeled alternative in {@link GPParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEpsstat(GPParser.EpsstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr}
	 * labeled alternative in {@link GPParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GPParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code term1}
	 * labeled alternative in {@link GPParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm1(GPParser.Term1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code groupfact}
	 * labeled alternative in {@link GPParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupfact(GPParser.GroupfactContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idfact}
	 * labeled alternative in {@link GPParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdfact(GPParser.IdfactContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numfact}
	 * labeled alternative in {@link GPParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumfact(GPParser.NumfactContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strfact}
	 * labeled alternative in {@link GPParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrfact(GPParser.StrfactContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idlist1}
	 * labeled alternative in {@link GPParser#idlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdlist1(GPParser.Idlist1Context ctx);
}