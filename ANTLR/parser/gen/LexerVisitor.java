// Generated from /Users/lenasaid/Desktop/Desktop/OneDrive/Uni/Semester 4/PSS/P4/ANTLR/parser/Lexer.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LexerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LexerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LexerParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LexerParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#dcls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcls(LexerParser.DclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(LexerParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(LexerParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LexerParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#cond_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_expr(LexerParser.Cond_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithm_expr(LexerParser.Arithm_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(LexerParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(LexerParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#array_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_assign(LexerParser.Array_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#array_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_expr(LexerParser.Array_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(LexerParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(LexerParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#func_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call(LexerParser.Func_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#blk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlk(LexerParser.BlkContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(LexerParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(LexerParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#iterative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterative(LexerParser.IterativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(LexerParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#array_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_call(LexerParser.Array_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link LexerParser#return_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_type(LexerParser.Return_typeContext ctx);
}