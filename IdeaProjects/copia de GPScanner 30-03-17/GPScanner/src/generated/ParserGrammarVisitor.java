// Generated from C:/Users/Pruebas/IdeaProjects/GPScanner\ParserGrammar.g4 by ANTLR 4.6
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ParserGrammar}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ParserGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code condecls}
	 * labeled alternative in {@link ParserGrammar#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondecls(ParserGrammar.CondeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sindecls}
	 * labeled alternative in {@link ParserGrammar#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSindecls(ParserGrammar.SindeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decls}
	 * labeled alternative in {@link ParserGrammar#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecls(ParserGrammar.DeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intdecl}
	 * labeled alternative in {@link ParserGrammar#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntdecl(ParserGrammar.IntdeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strdecl}
	 * labeled alternative in {@link ParserGrammar#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrdecl(ParserGrammar.StrdeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stats}
	 * labeled alternative in {@link ParserGrammar#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStats(ParserGrammar.StatsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asignstat}
	 * labeled alternative in {@link ParserGrammar#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignstat(ParserGrammar.AsignstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprstat}
	 * labeled alternative in {@link ParserGrammar#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprstat(ParserGrammar.ExprstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code epsstat}
	 * labeled alternative in {@link ParserGrammar#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEpsstat(ParserGrammar.EpsstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr}
	 * labeled alternative in {@link ParserGrammar#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ParserGrammar.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code term1}
	 * labeled alternative in {@link ParserGrammar#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm1(ParserGrammar.Term1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code groupfact}
	 * labeled alternative in {@link ParserGrammar#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupfact(ParserGrammar.GroupfactContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idfact}
	 * labeled alternative in {@link ParserGrammar#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdfact(ParserGrammar.IdfactContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numfact}
	 * labeled alternative in {@link ParserGrammar#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumfact(ParserGrammar.NumfactContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strfact}
	 * labeled alternative in {@link ParserGrammar#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrfact(ParserGrammar.StrfactContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idlist1}
	 * labeled alternative in {@link ParserGrammar#idlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdlist1(ParserGrammar.Idlist1Context ctx);
}