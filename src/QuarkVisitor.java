// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuarkParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuarkVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuarkParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(QuarkParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(QuarkParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(QuarkParser.IfstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(QuarkParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#assigstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigstat(QuarkParser.AssigstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#printstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintstat(QuarkParser.PrintstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(QuarkParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#equalityexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityexpr(QuarkParser.EqualityexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#addexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddexpr(QuarkParser.AddexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#mulexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulexpr(QuarkParser.MulexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(QuarkParser.AtomContext ctx);
}