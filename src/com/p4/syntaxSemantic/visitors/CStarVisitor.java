// Generated from C:/Users/ichris18/Documents/GitHub/P4/src/com/p4/syntaxSemantic\CStar.g4 by ANTLR 4.8
package com.p4.syntaxSemantic.visitors;
import com.p4.syntaxSemantic.CStarParser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link com.p4.syntaxSemantic.CStarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CStarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(com.p4.syntaxSemantic.CStarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(com.p4.syntaxSemantic.CStarParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(com.p4.syntaxSemantic.CStarParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(com.p4.syntaxSemantic.CStarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_expr(com.p4.syntaxSemantic.CStarParser.Logical_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#cond_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_expr(com.p4.syntaxSemantic.CStarParser.Cond_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithm_expr(com.p4.syntaxSemantic.CStarParser.Arithm_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(com.p4.syntaxSemantic.CStarParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(com.p4.syntaxSemantic.CStarParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#array_dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_dcl(com.p4.syntaxSemantic.CStarParser.Array_dclContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#array_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_expr(com.p4.syntaxSemantic.CStarParser.Array_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#array_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_access(com.p4.syntaxSemantic.CStarParser.Array_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(com.p4.syntaxSemantic.CStarParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#iterative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterative(com.p4.syntaxSemantic.CStarParser.IterativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(com.p4.syntaxSemantic.CStarParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#blk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlk(com.p4.syntaxSemantic.CStarParser.BlkContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(com.p4.syntaxSemantic.CStarParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(com.p4.syntaxSemantic.CStarParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#return_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_type(com.p4.syntaxSemantic.CStarParser.Return_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(com.p4.syntaxSemantic.CStarParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#return_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_exp(com.p4.syntaxSemantic.CStarParser.Return_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#func_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call(com.p4.syntaxSemantic.CStarParser.Func_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#array_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_func(com.p4.syntaxSemantic.CStarParser.Array_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(com.p4.syntaxSemantic.CStarParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(com.p4.syntaxSemantic.CStarParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.p4.syntaxSemantic.CStarParser#include}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude(CStarParser.IncludeContext ctx);
}