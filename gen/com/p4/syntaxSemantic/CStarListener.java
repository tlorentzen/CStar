// Generated from /Users/lenasaid/floobits/share/ichris18/src/com/p4/syntaxSemantic/CStar.g4 by ANTLR 4.8
package com.p4.syntaxSemantic;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CStarParser}.
 */
public interface CStarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CStarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CStarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CStarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(CStarParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(CStarParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(CStarParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(CStarParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CStarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CStarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogical_expr(CStarParser.Logical_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogical_expr(CStarParser.Logical_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#interval}.
	 * @param ctx the parse tree
	 */
	void enterInterval(CStarParser.IntervalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#interval}.
	 * @param ctx the parse tree
	 */
	void exitInterval(CStarParser.IntervalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#in_array}.
	 * @param ctx the parse tree
	 */
	void enterIn_array(CStarParser.In_arrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#in_array}.
	 * @param ctx the parse tree
	 */
	void exitIn_array(CStarParser.In_arrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#cond_expr}.
	 * @param ctx the parse tree
	 */
	void enterCond_expr(CStarParser.Cond_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#cond_expr}.
	 * @param ctx the parse tree
	 */
	void exitCond_expr(CStarParser.Cond_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithm_expr(CStarParser.Arithm_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithm_expr(CStarParser.Arithm_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(CStarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(CStarParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(CStarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(CStarParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#value_expr}.
	 * @param ctx the parse tree
	 */
	void enterValue_expr(CStarParser.Value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#value_expr}.
	 * @param ctx the parse tree
	 */
	void exitValue_expr(CStarParser.Value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#array_dcl}.
	 * @param ctx the parse tree
	 */
	void enterArray_dcl(CStarParser.Array_dclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#array_dcl}.
	 * @param ctx the parse tree
	 */
	void exitArray_dcl(CStarParser.Array_dclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#array_expr}.
	 * @param ctx the parse tree
	 */
	void enterArray_expr(CStarParser.Array_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#array_expr}.
	 * @param ctx the parse tree
	 */
	void exitArray_expr(CStarParser.Array_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#array_access}.
	 * @param ctx the parse tree
	 */
	void enterArray_access(CStarParser.Array_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#array_access}.
	 * @param ctx the parse tree
	 */
	void exitArray_access(CStarParser.Array_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(CStarParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(CStarParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#iterative}.
	 * @param ctx the parse tree
	 */
	void enterIterative(CStarParser.IterativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#iterative}.
	 * @param ctx the parse tree
	 */
	void exitIterative(CStarParser.IterativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(CStarParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(CStarParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#blk}.
	 * @param ctx the parse tree
	 */
	void enterBlk(CStarParser.BlkContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#blk}.
	 * @param ctx the parse tree
	 */
	void exitBlk(CStarParser.BlkContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(CStarParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(CStarParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(CStarParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(CStarParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#return_type}.
	 * @param ctx the parse tree
	 */
	void enterReturn_type(CStarParser.Return_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#return_type}.
	 * @param ctx the parse tree
	 */
	void exitReturn_type(CStarParser.Return_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(CStarParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(CStarParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#return_exp}.
	 * @param ctx the parse tree
	 */
	void enterReturn_exp(CStarParser.Return_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#return_exp}.
	 * @param ctx the parse tree
	 */
	void exitReturn_exp(CStarParser.Return_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#func_call}.
	 * @param ctx the parse tree
	 */
	void enterFunc_call(CStarParser.Func_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#func_call}.
	 * @param ctx the parse tree
	 */
	void exitFunc_call(CStarParser.Func_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#array_func}.
	 * @param ctx the parse tree
	 */
	void enterArray_func(CStarParser.Array_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#array_func}.
	 * @param ctx the parse tree
	 */
	void exitArray_func(CStarParser.Array_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(CStarParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(CStarParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(CStarParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(CStarParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CStarParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(CStarParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CStarParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(CStarParser.IncludeContext ctx);
}