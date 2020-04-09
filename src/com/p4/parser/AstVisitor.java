package com.p4.parser;

import jdk.jshell.spi.ExecutionControl;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AstVisitor<T> extends CStarBaseVisitor<AstNode> {

    @Override public AstNode visitProg(CStarParser.ProgContext ctx){
        ProgNode node = new ProgNode();

        int numChildren = ctx.getChildCount();

        for (int i = 0; i < numChildren; i++){
            ParseTree c = ctx.getChild(i);
            if(c.getPayload() instanceof CommonToken)
                continue;
            AstNode childResult = visit(c);
            node.children.add(childResult);
        }

        return node;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public AstNode visitDcl(CStarParser.DclContext ctx) {
        // All nodes will be returned to the blkNode visitor, where the children will be saved
        // Test for type
        CStarParser.AssignContext assign = ctx.assign();
        CStarParser.Array_assignContext array_assign = ctx.array_assign();

        if(assign != null){
            //Make assign node
            return visit(assign);
        } else if(array_assign != null){
            //Visit array_assign
            return visit(array_assign);
        } else{
            //Make normal dlcNode
            switch (ctx.TYPE().toString()){
                case "integer":
                    return new IntegerDclNode(ctx.ID().toString());
                case "decimal":
                    return new FloatDclNode(ctx.ID().toString());
                case "pin":
                    return new PinDclNode(ctx.ID().toString());
                case "big integer":
                    return new LongDclNode(ctx.ID().toString());
                case "character":
                    return new CharDclNode(ctx.ID().toString());
                default:
                    return null;
            }
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
                    integerAssign.children.add(exprNode);
                    return integerAssign;
                case "decimal":
                    AssignNode floatAssign = new AssignNode();
                    FloatDclNode floatDclNode = new FloatDclNode(id);
                    floatAssign.children.add(floatDclNode);
                    floatAssign.children.add(exprNode);
                    return floatAssign;
                case "pin":
                    AssignNode pinAssign = new AssignNode();
                    PinDclNode pinDclNode = new PinDclNode(id);
                    pinAssign.children.add(pinDclNode);
                    pinAssign.children.add(exprNode);
                    return pinAssign;
                case "long integer":
                    AssignNode longAssign = new AssignNode();
                    LongDclNode longDclNode = new LongDclNode(id);
                    longAssign.children.add(longDclNode);
                    longAssign.children.add(exprNode);
                    return longAssign;
                case "character":
                    AssignNode charAssign = new AssignNode();
                    CharDclNode charDclNode = new CharDclNode(id);
                    charAssign.children.add(charDclNode);
                    charAssign.children.add(exprNode);
                    return charAssign;
                default:
                    return null;
            }
        }
        else{
            AssignNode assignNode = new AssignNode();
            IdNode idNode = new IdNode(id);
            assignNode.children.add(idNode);
            assignNode.children.add(exprNode);
            return assignNode;
        }
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
        AstNode arrayExprNode = (ArrayExprNode) visit(ctx.array_expr());
        ArrayAssignNode arrayAssignNode = new ArrayAssignNode();
        arrayAssignNode.children.add(arrayNode);
        arrayAssignNode.children.add(arrayExprNode);

        return arrayAssignNode;
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
                arrayExprNode.children.add(literal);
            }
        }

        return arrayExprNode;
    }

    @Override public AstNode visitArithm_expr(CStarParser.Arithm_exprContext ctx){
        //ArrayExprNode arrayExprNode = new ArrayExprNode();
        int childCount = ctx.getChildCount();
        int termCount = 0;

        //If there are no operations with plus and minus
        if(childCount == 1){
            //TODO Husk at visit skal return noget
            visit(ctx.term(0));
        }
        else {
            visitArithm_exprChild(ctx.getChild(1), ctx, 1);
        }
        return null;
    }


    @Override public AstNode visitFunc_call(CStarParser.Func_callContext ctx) {
        //index 0 is ID, Everything that follows is parameter values

        FuncCallNode funcCallNode = new FuncCallNode();

        //TODO duplicate code fra visitBlkNode
        int numChildren = ctx.getChildCount();

        for (int i = 0; i < numChildren; i++){
            ParseTree c = ctx.getChild(i);
            String classes = c.getClass().toString();
            String id = c.getText();

            //checks if child is a value node
            //TODO find en mere elegant maade at sortere ID fra andre symboler
            if(classes.equals("class com.p4.parser.CStarParser$ValContext")) {
                AstNode childResult = visit(c);
                funcCallNode.children.add(childResult);
            }
            else if(!id.equals("(") && !id.equals(")") && !id.equals(",")){
                IdNode idNode = new IdNode(id);
                funcCallNode.children.add(idNode);
            }
        }
        return funcCallNode;
    }

    //Todo evt lav den general ved at lave en generisk metode
    public AstNode visitArithm_exprChild(ParseTree child, CStarParser.Arithm_exprContext parent, int operatorIndex){
        int termIndex = (operatorIndex - 1) / 2;

        if(child.getText().equals("+")) {
            AddNode addNode = new AddNode();

            //Enters if there are more operators in the tree
            if(parent.getChild(operatorIndex + 2) != null) {
                operatorIndex += 2;

                //Add left child (term)
                addNode.children.add(visitTerm(parent.term(termIndex)));
                //Add right child (operator)
                addNode.children.add(visitArithm_exprChild(parent.getChild(operatorIndex), parent, operatorIndex));
            }
            //Enters if there is only a term child left
            else{
                // Add left and right child (terms)
                addNode.children.add(visitTerm(parent.term(termIndex)));
                addNode.children.add(visitTerm(parent.term(termIndex + 1)));
            }

            return addNode;
        }
        else {
            SubNode subNode = new SubNode();

            //Enters if there are more operators in the tree
            if(parent.getChild(operatorIndex + 2) != null) {
                operatorIndex += 2;

                //Add left child (term)
                subNode.children.add(visitTerm(parent.term(termIndex)));
                //Add right child (operator)
                subNode.children.add(visitArithm_exprChild(parent.getChild(operatorIndex), parent, operatorIndex));
            }
            //Enters if there is only a term child left
            else{
                // Add left and right child (terms)
                subNode.children.add(visitTerm(parent.term(termIndex)));
                subNode.children.add(visitTerm(parent.term(termIndex + 1)));
            }

            return subNode;
        }
    }


    //@Override public T visitReturn_exp(CStarParser.Return_expContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public AstNode visitCond_expr(CStarParser.Cond_exprContext ctx) {
        CondNode node = new CondNode();

        int numChildren = ctx.getChildCount();

        for(int i = 0; i < numChildren; i++){
            ParseTree c = ctx.getChild(i);
            Object o = c.getPayload();

            if(o instanceof CommonToken){
                CommonToken t = (CommonToken) o;

                if(t.getType() == CStarParser.COMP_OP){
                    node.setOperator(t.getText());
                }

                if(t.getType() == CStarParser.AND || t.getType() == CStarParser.OR){
                    node.children.add(visit(c));
                    CondNode newCondNode = new CondNode();

                    newCondNode.children.addAll(node.children);
                    node.children.clear();
                    node.children.add(newCondNode);
                }
                node.setOperator(t.getText());
            } else{
                node.children.add(visit(c));
            }
        }
        if(node.getOperator() == null){
            return node.getChildren().get(0);
        } else{
            return node;
        }
    }
    
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
        node.children.add(visit(ctx.param()));
        node.children.add(visit(ctx.blk()));
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

        if(ctx.getChildCount() > 0)

        for(CStarParser.ParamContext param : ctx.param()){
            System.out.println(param.ID());
            node.children.add(visit(param));
        }

        return node;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public AstNode visitBlk(CStarParser.BlkContext ctx) {

        BlkNode node = new BlkNode();

        int numChildren = ctx.getChildCount();

        for (int i = 0; i < numChildren; i++){
            ParseTree c = ctx.getChild(i);
            if(c.getPayload() instanceof CommonToken)
                continue;
            AstNode childResult = visit(c);
            node.children.add(childResult);
            System.out.println();
        }

        return node;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public AstNode visitSelection(CStarParser.SelectionContext ctx) {
        SelectionNode node = new SelectionNode();

        node.children.add(visit(ctx.cond_expr()));

        for(CStarParser.BlkContext blk : ctx.blk()){
            node.children.add(visit(blk));
        }

        return node;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public AstNode visitIterative(CStarParser.IterativeContext ctx) {
        IterativeNode node = new IterativeNode();

        node.children.add(visit(ctx.cond_expr()));
        node.children.add(visit(ctx.blk()));

        return node;
    }
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

    @Override public AstNode visitArray_value(CStarParser.Array_valueContext ctx) {
        //Id is index 0, the Index is at index 1, and the assigned value is at 2
        ArrayAssignValueNode arrayAssignValueNode = new ArrayAssignValueNode();

        //First add ID at index 0
        IdNode id = new IdNode(ctx.getChild(0).getText());
        arrayAssignValueNode.children.add(id);

        int numChildren = ctx.getChildCount();

        for (int i = 0; i < numChildren; i++){
            ParseTree c = ctx.getChild(i);
            if(c.getPayload() instanceof CommonToken)
                continue;
            AstNode childResult = visit(c);
            arrayAssignValueNode.children.add(childResult);
        }

        return arrayAssignValueNode;
    }
}
