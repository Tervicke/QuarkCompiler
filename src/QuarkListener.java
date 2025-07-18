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
	 * Enter a parse tree produced by {@link QuarkParser#funcdefn}.
	 * @param ctx the parse tree
	 */
	void enterFuncdefn(QuarkParser.FuncdefnContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#funcdefn}.
	 * @param ctx the parse tree
	 */
	void exitFuncdefn(QuarkParser.FuncdefnContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#paramlist}.
	 * @param ctx the parse tree
	 */
	void enterParamlist(QuarkParser.ParamlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#paramlist}.
	 * @param ctx the parse tree
	 */
	void exitParamlist(QuarkParser.ParamlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(QuarkParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(QuarkParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#funccall}.
	 * @param ctx the parse tree
	 */
	void enterFunccall(QuarkParser.FunccallContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#funccall}.
	 * @param ctx the parse tree
	 */
	void exitFunccall(QuarkParser.FunccallContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(QuarkParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(QuarkParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#returnstat}.
	 * @param ctx the parse tree
	 */
	void enterReturnstat(QuarkParser.ReturnstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#returnstat}.
	 * @param ctx the parse tree
	 */
	void exitReturnstat(QuarkParser.ReturnstatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#importstat}.
	 * @param ctx the parse tree
	 */
	void enterImportstat(QuarkParser.ImportstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#importstat}.
	 * @param ctx the parse tree
	 */
	void exitImportstat(QuarkParser.ImportstatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#definestructstat}.
	 * @param ctx the parse tree
	 */
	void enterDefinestructstat(QuarkParser.DefinestructstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#definestructstat}.
	 * @param ctx the parse tree
	 */
	void exitDefinestructstat(QuarkParser.DefinestructstatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#structstats}.
	 * @param ctx the parse tree
	 */
	void enterStructstats(QuarkParser.StructstatsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#structstats}.
	 * @param ctx the parse tree
	 */
	void exitStructstats(QuarkParser.StructstatsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#structfield}.
	 * @param ctx the parse tree
	 */
	void enterStructfield(QuarkParser.StructfieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#structfield}.
	 * @param ctx the parse tree
	 */
	void exitStructfield(QuarkParser.StructfieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#declarestruct}.
	 * @param ctx the parse tree
	 */
	void enterDeclarestruct(QuarkParser.DeclarestructContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#declarestruct}.
	 * @param ctx the parse tree
	 */
	void exitDeclarestruct(QuarkParser.DeclarestructContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#destructstat}.
	 * @param ctx the parse tree
	 */
	void enterDestructstat(QuarkParser.DestructstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#destructstat}.
	 * @param ctx the parse tree
	 */
	void exitDestructstat(QuarkParser.DestructstatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#idlist}.
	 * @param ctx the parse tree
	 */
	void enterIdlist(QuarkParser.IdlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#idlist}.
	 * @param ctx the parse tree
	 */
	void exitIdlist(QuarkParser.IdlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#destructfield}.
	 * @param ctx the parse tree
	 */
	void enterDestructfield(QuarkParser.DestructfieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#destructfield}.
	 * @param ctx the parse tree
	 */
	void exitDestructfield(QuarkParser.DestructfieldContext ctx);
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
	 * Enter a parse tree produced by {@link QuarkParser#continuestatement}.
	 * @param ctx the parse tree
	 */
	void enterContinuestatement(QuarkParser.ContinuestatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#continuestatement}.
	 * @param ctx the parse tree
	 */
	void exitContinuestatement(QuarkParser.ContinuestatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#breakstatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakstatement(QuarkParser.BreakstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#breakstatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakstatement(QuarkParser.BreakstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#whilestat}.
	 * @param ctx the parse tree
	 */
	void enterWhilestat(QuarkParser.WhilestatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#whilestat}.
	 * @param ctx the parse tree
	 */
	void exitWhilestat(QuarkParser.WhilestatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#patternmatchstat}.
	 * @param ctx the parse tree
	 */
	void enterPatternmatchstat(QuarkParser.PatternmatchstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#patternmatchstat}.
	 * @param ctx the parse tree
	 */
	void exitPatternmatchstat(QuarkParser.PatternmatchstatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#matcharms}.
	 * @param ctx the parse tree
	 */
	void enterMatcharms(QuarkParser.MatcharmsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#matcharms}.
	 * @param ctx the parse tree
	 */
	void exitMatcharms(QuarkParser.MatcharmsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#matchbody}.
	 * @param ctx the parse tree
	 */
	void enterMatchbody(QuarkParser.MatchbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#matchbody}.
	 * @param ctx the parse tree
	 */
	void exitMatchbody(QuarkParser.MatchbodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(QuarkParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(QuarkParser.PatternContext ctx);
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
	 * Enter a parse tree produced by {@link QuarkParser#relationalexpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalexpr(QuarkParser.RelationalexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#relationalexpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalexpr(QuarkParser.RelationalexprContext ctx);
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
	 * Enter a parse tree produced by {@link QuarkParser#fieldaccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldaccess(QuarkParser.FieldaccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#fieldaccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldaccess(QuarkParser.FieldaccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#access}.
	 * @param ctx the parse tree
	 */
	void enterAccess(QuarkParser.AccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#access}.
	 * @param ctx the parse tree
	 */
	void exitAccess(QuarkParser.AccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuarkParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(QuarkParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuarkParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(QuarkParser.UnaryExprContext ctx);
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