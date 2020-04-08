package com.p4.parser;

import jdk.jshell.spi.ExecutionControl;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AstVisitor<T> extends CStarBaseVisitor<AstNode> {

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public AstNode visitDcl(CStarParser.DclContext ctx) {

        // Test for type
        CStarParser.AssignContext assign = ctx.assign();
        CStarParser.Array_assignContext array_assign = ctx.array_assign();

        switch (ctx.TYPE().toString()){
            case "integer":
                if(assign != null){
                    //Make assign node
                    AssignNode node = (AssignNode) visit(assign);
                    return node;

                }else if(array_assign != null){
                    //Visit array_assign
                    ArrayAssignNode node = (ArrayAssignNode) visit(array_assign);
                    return node;
                }
                else{
                    return new IntegerDclNode(ctx.ID().toString());
                }
            case "decimal":
                if(assign != null){
                    //Make assign node
                    AssignNode node = (AssignNode) visit(assign);
                    return node;

                }else if(array_assign != null){
                    //Visit array_assign
                  //  visit(array_assign)
                    ArrayAssignNode node = (ArrayAssignNode) visit(array_assign);
                    return node;
                }
                else{
                    return new FloatDclNode(ctx.ID().toString());
                }
            case "pin":
                if(assign != null){
                    //Make assign node
                    AssignNode node = (AssignNode) visit(assign);
                    return node;

                }else if(array_assign != null){
                    //Visit array_assign
                    ArrayAssignNode node = (ArrayAssignNode) visit(array_assign);
                    return node;
                }
                else{
                    return new PinDclNode(ctx.ID().toString());
                }
            case "big integer":
                if(assign != null){
                //Make assign node
                    AssignNode node = (AssignNode) visit(assign);

                    return node;

                }else if(array_assign != null){
                    //Visit array_assign
                    ArrayAssignNode node = (ArrayAssignNode) visit(array_assign);
                    return node;
                }
                else{
                    return new LongDclNode(ctx.ID().toString());
                }
            case "character":
                if(assign != null){
                    //Make assign node
                    AstNode tempNode = visit(assign);
                    AssignNode node = (AssignNode) tempNode;
                    return node;

                }else if(array_assign != null){
                    //Visit array_assign
                    ArrayAssignNode node = (ArrayAssignNode) visit(array_assign);
                    return node;
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
        AstNode exprNode = visit(exprCtx);

        ParserRuleContext parent = ctx.getParent();
        String classes = parent.getClass().toString();

        if(classes.equals("class com.p4.parser.CStarParser$DclContext")){
            var child = parent.getChild(0);
            String type = child.toString();

            switch (type){
                case "integer":
                    AssignNode integerAssign = new AssignNode();
                    IntegerDclNode intDclNode = new IntegerDclNode(id);
                    integerAssign.children.add(intDclNode);
                    integerAssign.children.add(new IdNode(id, type));
                    integerAssign.children.add(exprNode);
                    return integerAssign;
                case "decimal":
                    AssignNode floatAssign = new AssignNode();
                    FloatDclNode floatDclNode = new FloatDclNode(id);
                    floatAssign.children.add(floatDclNode);
                    floatAssign.children.add(new IdNode(id, type));
                    floatAssign.children.add(exprNode);
                    return new AssignNode();
                case "pin":
                    AssignNode pinAssign = new AssignNode();
                    PinDclNode pinDclNode = new PinDclNode(id);
                    pinAssign.children.add(pinDclNode);
                    pinAssign.children.add(new IdNode(id, type));
                    pinAssign.children.add(exprNode);
                    return new AssignNode();
                case "long integer":
                    AssignNode longAssign = new AssignNode();
                    LongDclNode longDclNode = new LongDclNode(id);
                    longAssign.children.add(longDclNode);
                    longAssign.children.add(new IdNode(id, type));
                    longAssign.children.add(exprNode);
                    return new AssignNode();
                case "character":
                    AssignNode charAssign = new AssignNode();
                    CharDclNode charDclNode = new CharDclNode(id);
                    charAssign.children.add(charDclNode);
                    charAssign.children.add(new IdNode(id, type));
                    charAssign.children.add(exprNode);
                    return new AssignNode();
                default:
                    return null;
            }
        }

        return new AssignNode();

    }

    @Override public AstNode visitVal(CStarParser.ValContext ctx) {

        if(ctx.INT_LITERAL() != null) {
            return new IntegerNode(Integer.parseInt(ctx.INT_LITERAL().getText()));
        } // use equals
        else if(ctx.FLOAT_LITERAL() != null) {
           return new FloatNode(Float.parseFloat(ctx.FLOAT_LITERAL().getText()));
        }
        else if(ctx.PIN_LITERAL() != null) {
            return new PinNode(Integer.parseInt(ctx.CHAR_LITERAL().getText()));
        }
        else if(ctx.LONG_LITERAL() != null) {
            return new LongNode(Long.parseLong(ctx.LONG_LITERAL().getText()));
        }

        else if(ctx.CHAR_LITERAL() != null) {
            String temp = ctx.CHAR_LITERAL().getText();
            char c = temp.charAt(0);
            return new CharNode(c);
        }
        else {
            return null;
        }
    }
    @Override public AstNode visitArray_assign(CStarParser.Array_assignContext ctx) {
        //We get the ID from current node and the type from the parent (dclnode) by converting the child to a string
        String id = ctx.ID().toString();
        ParserRuleContext parent = ctx.getParent();
        var child = parent.getChild(0);
        String type = child.toString();
        ArrayNode arrayNode = new ArrayNode(id, type);
        AstNode tempArrayExprNode = visit(ctx.array_expr());
        ArrayExprNode arrayExprNode= (ArrayExprNode) tempArrayExprNode;

        return new ArrayAssignNode(arrayNode, arrayExprNode);
    }
    @Override public AstNode visitArray_expr(CStarParser.Array_exprContext ctx) {
        ArrayExprNode arrayExprNode = new ArrayExprNode();
        int childCount = ctx.getChildCount();

        for(int i = 0; i < childCount; i++){
            var child = ctx.getChild(i);
            String classes = child.getClass().toString();
            //checks if child is a value node
            if(classes.equals("class com.p4.parser.CStarParser$ValContext")) {
                AstNode literal = visit(child);
                arrayExprNode.Literals.add(literal);
            }
        }

        return arrayExprNode;
    }

    @Override public AstNode visitArithm_expr(CStarParser.Arithm_exprContext ctx){
        //ArrayExprNode arrayExprNode = new ArrayExprNode();
        int childCount = ctx.getChildCount();
        int termCount = 0;


        if(childCount == 1){
            //TODO Husk at visit skal return noget
            visit(ctx.term(0));
        }
        else{
            for(int i = 0; i < (childCount-1)/2; i++){
                //lav plus/minus-node som barn til et forrige
                //lav venstre barn til minus/plus-node
                visit(ctx.term(0));

                var child = ctx.getChild(i);
                String classes = child.getClass().toString();
                //checks if child is a value node
                if(classes.equals("class com.p4.parser.CStarParser$TermContext")) {
                    AstNode literal = visit(child);
                    //arrayExprNode.Literals.add(literal);
                }
                //lav sidste højre side
        }


        }

        return null;
    }


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


    @Override public AstNode visitFunc(CStarParser.FuncContext ctx) {

        System.out.println(ctx.ID().toString());

        FuncNode node = new FuncNode();
        node.id = ctx.ID().toString();
        node.returnType = (ctx.return_type().TYPE() != null ? ctx.return_type().TYPE().toString() : "void");
        node.paramNode = (ParamNode)visit(ctx.param());
        node.blkNode = (BlkNode)visit(ctx.blk());

        System.out.println(ctx.toString());

        return node;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public AstNode visitParam(CStarParser.ParamContext ctx) {
        ParamNode node = new ParamNode();

        for(CStarParser.ParamContext param : ctx.param()){

            System.out.println(param.ID());

            switch (param.TYPE().toString()){
               /*case "Integer":
                    node.params.add(new IntegerNode(Integer.parseInt(param.ID(0).toString())));
                    break;
                case "Decimal":
                    node.params.add(new FloatNode(Float.parseFloat(param.ID(0).toString())));
                    break;
                case "Pin":
                    node.params.add(new PinNode(Integer.parseInt(param.ID(0).toString())));
                    break;
                case "Long":
                    node.params.add(new LongNode(Long.parseLong(param.ID(0).toString())));
                    break;
                case "Char":
                    node.params.add(new CharNode(param.ID(0).toString().charAt(0)));
                    break;*/
            }
        }

        return node;
    }
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
    @Override public AstNode visitBlk(CStarParser.BlkContext ctx) {

        BlkNode node = new BlkNode();

        for(CStarParser.DclsContext dcl : ctx.dcls()){
            node.dclNodes.add((DclNode<?>) visit(dcl));
        }

        for(CStarParser.StmtContext stmt : ctx.stmt()) {
            node.stmtNodes.add((StmtNode) visit(stmt));
        }

        for(CStarParser.Return_expContext rexp : ctx.return_exp()){
            node.returnExpNodes.add((ReturnExpNode) visit(rexp));
        }

        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public AstNode visitStmt(CStarParser.StmtContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public AstNode visitSelection(CStarParser.SelectionContext ctx) {
        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public AstNode visitIterative(CStarParser.IterativeContext ctx) { return visitChildren(ctx); }
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

}

