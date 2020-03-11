// Generated from /Users/lenasaid/Desktop/Desktop/OneDrive/Uni/Semester 4/PSS/P4/ANTLR/parser/Lexer.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LexerParser}.
 */
public interface LexerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LexerParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LexerParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LexerParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#dcls}.
	 * @param ctx the parse tree
	 */
	void enterDcls(LexerParser.DclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#dcls}.
	 * @param ctx the parse tree
	 */
	void exitDcls(LexerParser.DclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(LexerParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(LexerParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(LexerParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(LexerParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LexerParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LexerParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#cond_expr}.
	 * @param ctx the parse tree
	 */
	void enterCond_expr(LexerParser.Cond_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#cond_expr}.
	 * @param ctx the parse tree
	 */
	void exitCond_expr(LexerParser.Cond_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithm_expr(LexerParser.Arithm_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithm_expr(LexerParser.Arithm_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(LexerParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(LexerParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(LexerParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(LexerParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#array_assign}.
	 * @param ctx the parse tree
	 */
	void enterArray_assign(LexerParser.Array_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#array_assign}.
	 * @param ctx the parse tree
	 */
	void exitArray_assign(LexerParser.Array_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#array_expr}.
	 * @param ctx the parse tree
	 */
	void enterArray_expr(LexerParser.Array_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#array_expr}.
	 * @param ctx the parse tree
	 */
	void exitArray_expr(LexerParser.Array_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(LexerParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(LexerParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(LexerParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(LexerParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#func_call}.
	 * @param ctx the parse tree
	 */
	void enterFunc_call(LexerParser.Func_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#func_call}.
	 * @param ctx the parse tree
	 */
	void exitFunc_call(LexerParser.Func_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#blk}.
	 * @param ctx the parse tree
	 */
	void enterBlk(LexerParser.BlkContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#blk}.
	 * @param ctx the parse tree
	 */
	void exitBlk(LexerParser.BlkContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(LexerParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(LexerParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(LexerParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(LexerParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#iterative}.
	 * @param ctx the parse tree
	 */
	void enterIterative(LexerParser.IterativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#iterative}.
	 * @param ctx the parse tree
	 */
	void exitIterative(LexerParser.IterativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(LexerParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(LexerParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#array_call}.
	 * @param ctx the parse tree
	 */
	void enterArray_call(LexerParser.Array_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#array_call}.
	 * @param ctx the parse tree
	 */
	void exitArray_call(LexerParser.Array_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link LexerParser#return_type}.
	 * @param ctx the parse tree
	 */
	void enterReturn_type(LexerParser.Return_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LexerParser#return_type}.
	 * @param ctx the parse tree
	 */
	void exitReturn_type(LexerParser.Return_typeContext ctx);
}