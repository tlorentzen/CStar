// Generated from C:/Users/Jakob/OneDrive - Aalborg Universitet/P4/src/com/p4/parser\CStar.g4 by ANTLR 4.8
package com.p4.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CStarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CStarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CStarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(CStarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(CStarParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(CStarParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(CStarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_expr(CStarParser.Logical_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#cond_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_expr(CStarParser.Cond_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithm_expr(CStarParser.Arithm_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(CStarParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(CStarParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#array_dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_dcl(CStarParser.Array_dclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#array_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_expr(CStarParser.Array_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#array_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_assign(CStarParser.Array_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#array_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_access(CStarParser.Array_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(CStarParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#return_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_type(CStarParser.Return_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(CStarParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#blk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlk(CStarParser.BlkContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#return_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_exp(CStarParser.Return_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#func_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call(CStarParser.Func_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(CStarParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#iterative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterative(CStarParser.IterativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(CStarParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CStarParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(CStarParser.ValContext ctx);
}