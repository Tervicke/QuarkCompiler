// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuarkParser}.
 */
public interface QuarkListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuarkParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(QuarkParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(QuarkParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void enterIfstatement(QuarkParser.IfstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#ifstatement}.
	 * @param ctx the parse tree
	 */
	void exitIfstatement(QuarkParser.IfstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(QuarkParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(QuarkParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(QuarkParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(QuarkParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#assigstat}.
	 * @param ctx the parse tree
	 */
	void enterAssigstat(QuarkParser.AssigstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#assigstat}.
	 * @param ctx the parse tree
	 */
	void exitAssigstat(QuarkParser.AssigstatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#printstat}.
	 * @param ctx the parse tree
	 */
	void enterPrintstat(QuarkParser.PrintstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#printstat}.
	 * @param ctx the parse tree
	 */
	void exitPrintstat(QuarkParser.PrintstatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(QuarkParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(QuarkParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#equalityexpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityexpr(QuarkParser.EqualityexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#equalityexpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityexpr(QuarkParser.EqualityexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#addexpr}.
	 * @param ctx the parse tree
	 */
	void enterAddexpr(QuarkParser.AddexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#addexpr}.
	 * @param ctx the parse tree
	 */
	void exitAddexpr(QuarkParser.AddexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#mulexpr}.
	 * @param ctx the parse tree
	 */
	void enterMulexpr(QuarkParser.MulexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#mulexpr}.
	 * @param ctx the parse tree
	 */
	void exitMulexpr(QuarkParser.MulexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(QuarkParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(QuarkParser.AtomContext ctx);
}