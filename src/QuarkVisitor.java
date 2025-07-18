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
	 * Visit a parse tree produced by {@link QuarkParser#funcdefn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdefn(QuarkParser.FuncdefnContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamlist(QuarkParser.ParamlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(QuarkParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#funccall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunccall(QuarkParser.FunccallContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(QuarkParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#returnstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnstat(QuarkParser.ReturnstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#importstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportstat(QuarkParser.ImportstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#definestructstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinestructstat(QuarkParser.DefinestructstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#structstats}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructstats(QuarkParser.StructstatsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#structfield}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructfield(QuarkParser.StructfieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#declarestruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarestruct(QuarkParser.DeclarestructContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#destructstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDestructstat(QuarkParser.DestructstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#idlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdlist(QuarkParser.IdlistContext ctx);
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
	 * Visit a parse tree produced by {@link QuarkParser#continuestatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinuestatement(QuarkParser.ContinuestatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#breakstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakstatement(QuarkParser.BreakstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#whilestat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestat(QuarkParser.WhilestatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#patternmatchstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternmatchstat(QuarkParser.PatternmatchstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#matcharms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatcharms(QuarkParser.MatcharmsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#matchbody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchbody(QuarkParser.MatchbodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(QuarkParser.PatternContext ctx);
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
	 * Visit a parse tree produced by {@link QuarkParser#relationalexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalexpr(QuarkParser.RelationalexprContext ctx);
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
	 * Visit a parse tree produced by {@link QuarkParser#fieldaccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldaccess(QuarkParser.FieldaccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess(QuarkParser.AccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(QuarkParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuarkParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(QuarkParser.AtomContext ctx);
}