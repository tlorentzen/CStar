package com.p4.parser;

import jdk.jshell.spi.ExecutionControl;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Optional;

public class AstVisitor<T> extends CStarBaseVisitor<AstNode> {

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public AstNode visitDcl(CStarParser.DclContext ctx) {
//        System.out.println(ctx.ID().toString());

        // Test for type
        CStarParser.AssignContext assign = ctx.assign();
        CStarParser.Array_assignContext array_assign = ctx.array_assign();

        switch (ctx.TYPE().toString()){
            case "integer":
                if(assign != null){
                    //Make assign node
                    visit(assign);
                }else if(array_assign != null){
                    //Visit array_assign
                    visit(array_assign);
                }
                else{
                    return new IntegerDclNode(ctx.ID().toString());
                }
            case "decimal":
                if(assign != null){
                    //Make assign node
                    visit(assign);
                }else if(array_assign != null){
                    //Visit array_assign
                    visit(array_assign);
                }
                else{
                    return new FloatDclNode(ctx.ID().toString());
                }
            case "pin":
                if(assign != null){
                    //Make assign node
                    visit(assign);
                }else if(array_assign != null){
                    //Visit array_assign
                    visit(array_assign);
                }
                else{
                    return new PinDclNode(ctx.ID().toString());
                }
            case "big integer":
                if(assign != null){
                //Make assign node
                    visit(assign);
                }else if(array_assign != null){
                    //Visit array_assign
                    visit(array_assign);
                }
                else{
                    return new LongDclNode(ctx.ID().toString());
                }
            case "character":
                if(assign != null){
                    //Make assign node
                    visit(assign);
                }else if(array_assign != null){
                    //Visit array_assign
                    visit(array_assign);
                }
                else{
                    return new CharDclNode(ctx.ID().toString());
                }
            default:
                return null;
        }
    }

    @Override public AstNode visitAssign(CStarParser.AssignContext ctx) {

        String id = ctx.ID().toString();
        CStarParser.ExprContext exprCtx = ctx.expr();
        AstNode expr = visit(exprCtx);

        ParserRuleContext parent = ctx.getParent();
        String classes = parent.getClass().toString();
        

        if(classes.equals("class com.p4.parser.CStarParser$DclContext")){
            var child = parent.getChild(0);

            switch (child.toString()){
                case "integer":
                    IntegerDclNode intDclNode = new IntegerDclNode(id);
                    return new AssignNode(intDclNode, expr);
                case "decimal":
                    FloatDclNode floatDclNode = new FloatDclNode(id);
                    return new AssignNode(floatDclNode, expr);
                case "pin":
                    PinDclNode pinDclNode = new PinDclNode(id);
                    return new AssignNode(pinDclNode, expr);
                case "long integer":
                    LongDclNode longDclNode = new LongDclNode(id);
                    return new AssignNode(longDclNode, expr);
                case "character":
                    CharDclNode charDclNode = new CharDclNode(id);
                    return new AssignNode(charDclNode, expr);
                default:
                    return null;
            }
        }

        return new AssignNode(id, expr);

    }

    @Override public AstNode visitVal(CStarParser.ValContext ctx) {
        var child = ctx.getChild(0);
        String type = "INT_LITERAL";
        if(type == "INT_LITERAL") {
            //System.out.println("test");
            return new IntegerNode();
        } // bruge equals
        else if(type == "FLOAT_LITERAL") {
           return new IntegerNode();
        }
        else if(type == "PIN_LITERAL") {
            //return new PinNode(value);
            return new IntegerNode();
        }
        else if(type == "LONG_LITERAL") {
            // return new LongNode(value);
            return new IntegerNode();
        }
        else if(type == "CHAR_LITERAL") {
            //return new CharNode(value);
            return new IntegerNode();
        }
        else {
            return null;
        }
    }
    //@Override public AstNode visitExpr(CStarParser.ExprContext ctx) {

      //  return visitChildren(ctx);
    //}


    //@Override public T visitReturn_exp(CStarParser.Return_expContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    //@Override public T visitCond_expr(CStarParser.Cond_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public T visitArithm_expr(CStarParser.Arithm_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
   // @Override public T visitTerm(CStarParser.TermContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
   // @Override public T visitFactor(CStarParser.FactorContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
   // @Override public T visitArray_assign(CStarParser.Array_assignContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
  //  @Override public T visitArray_expr(CStarParser.Array_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public T visitFunc(CStarParser.FuncContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public T visitParam(CStarParser.ParamContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
   // @Override public T visitFunc_call(CStarParser.Func_callContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public T visitBlk(CStarParser.BlkContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public T visitStmt(CStarParser.StmtContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public T visitSelection(CStarParser.SelectionContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public T visitIterative(CStarParser.IterativeContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public T visitVal(CStarParser.ValContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public T visitArray_call(CStarParser.Array_callContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public T visitReturn_type(CStarParser.Return_typeContext ctx) { return visitChildren(ctx); }

}
