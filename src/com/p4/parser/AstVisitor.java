package com.p4.parser;

import com.p4.parser.nodes.*;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;

public class AstVisitor<T> extends CStarBaseVisitor<AstNode> {

    @Override public AstNode visitProg(CStarParser.ProgContext ctx){
        ProgNode node = new ProgNode();

        int numChildren = ctx.getChildCount();

        for (int i = 0; i < numChildren; i++){
            ParseTree child = ctx.getChild(i);
            if(child.getPayload() instanceof CommonToken)
                continue;
            AstNode childResult = visit(child);
            node.children.add(childResult);
        }

        return node;
    }

    @Override public AstNode visitDcl(CStarParser.DclContext ctx) {
        // All nodes will be returned to the blkNode visitor, where the children will be saved
        // Test for type
        CStarParser.AssignContext assign = ctx.assign();
        CStarParser.Array_dclContext array_dcl = ctx.array_dcl();

        if(assign != null){
            //Make assign node
            return visit(assign);
        } else if(array_dcl != null){
            //Visit array_dcl
            return visit(array_dcl);
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


        ParserRuleContext parent = ctx.getParent();
        String classes = parent.getClass().toString();

        if (classes.equals("class com.p4.parser.CStarParser$DclContext")) {
            String id = ctx.ID().toString();
            CStarParser.ExprContext exprCtx = ctx.expr();
            AstNode exprNode = visit(exprCtx);

            var child = parent.getChild(0);
            String type = child.toString();

            switch (type) {
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
        else if (ctx.getChild(0).getClass().toString().equals("class com.p4.parser.CStarParser$Array_assignContext")) {
            AstNode node = visit(ctx.array_assign());
            return node;
        }
        else{
            String id = ctx.ID().toString();
            CStarParser.ExprContext exprCtx = ctx.expr();
            AstNode exprNode = visit(exprCtx);

            AssignNode assignNode = new AssignNode();
            IdNode idNode = new IdNode(id, false);
            assignNode.children.add(idNode);
            assignNode.children.add(exprNode);
            return assignNode;
        }
    }

    @Override public AstNode visitVal(CStarParser.ValContext ctx) {
        boolean isNegative = false;
        ParseTree parent = ctx.getParent();
        if(parent.getChild(0).getClass().toString().equals("class org.antlr.v4.runtime.tree.TerminalNodeImpl")){
            isNegative = true;
        }

        if(ctx.INT_LITERAL() != null) {
            return new IntegerNode(Integer.parseInt(ctx.INT_LITERAL().getText()), isNegative);
        } // use equals
        else if(ctx.FLOAT_LITERAL() != null) {
           return new FloatNode(Float.parseFloat(ctx.FLOAT_LITERAL().getText()), isNegative);
        }
        else if(ctx.PIN_LITERAL() != null) {
            return new PinNode(Integer.parseInt(ctx.CHAR_LITERAL().getText()), isNegative);
        }
        else if(ctx.LONG_LITERAL() != null) {
            return new LongNode(Long.parseLong(ctx.LONG_LITERAL().getText()), isNegative);
        }
        else if(ctx.CHAR_LITERAL() != null) {
            String temp = ctx.CHAR_LITERAL().getText();
            return new CharNode(temp.charAt(0), isNegative);
        }
        else {
            return null;
        }
    }

    @Override public AstNode visitArray_dcl(CStarParser.Array_dclContext ctx) {
        //We get the ID from current node and the type from the parent (dclnode) by converting the child to a string
        String id = ctx.ID().toString();
        ParserRuleContext parent = ctx.getParent();
        var child = parent.getChild(0);
        String type = child.toString();
        ArrayNode arrayNode = new ArrayNode(id, type);
        AstNode arrayExprNode = (ArrayExprNode) visit(ctx.array_expr());
        ArrayDclNode arrayDclNode = new ArrayDclNode(id);
        arrayDclNode.children.add(arrayNode);
        arrayDclNode.children.add(arrayExprNode);

        return arrayDclNode;
    }

    @Override public AstNode visitArray_expr(CStarParser.Array_exprContext ctx) {
        ArrayExprNode arrayExprNode = new ArrayExprNode();
        int childCount = ctx.getChildCount();

        for(int i = 0; i < childCount; i++){
            var child = ctx.getChild(i);
            String classes = child.getClass().toString();
            //checks if child is a value node
            if(classes.equals("class com.p4.parser.CStarParser$ExprContext")) {
                AstNode literal = visit(child);
                arrayExprNode.children.add(literal);
            }
        }
        return arrayExprNode;
    }

    @Override public AstNode visitFunc_call(CStarParser.Func_callContext ctx) {
        //index 0 is ID, Everything that follows is parameter values
        boolean isNegative = false;
        ParseTree parent = ctx.getParent();
        if(parent.getChild(0).getClass().toString().equals("class org.antlr.v4.runtime.tree.TerminalNodeImpl")){
            isNegative = true;
        }

        FuncCallNode funcCallNode = new FuncCallNode(isNegative);

        int numChildren = ctx.getChildCount();

        for (int childIndex = 0; childIndex < numChildren; childIndex++){
            ParseTree child = ctx.getChild(childIndex);
            String classes = child.getClass().toString();
            String id = child.getText();

            //checks if child is a value node
            //TODO lave funktioner til classes.equals da det bliver brugt mange steder
            if(classes.equals("class com.p4.parser.CStarParser$ExprContext")){
                funcCallNode.children.add(visit(child));
            }
            else if(isID(id)){
                IdNode idNode = new IdNode(id, false);
                funcCallNode.children.add(idNode);
            }
        }
        return funcCallNode;
    }

    private boolean isID(String id){
        return !id.equals("(") && !id.equals(")") && !id.equals(",");
    }

    @Override public AstNode visitArithm_expr(CStarParser.Arithm_exprContext ctx){
        //ArrayExprNode arrayExprNode = new ArrayExprNode();
        int childCount = ctx.getChildCount();
        int termCount = 0;

        //If there are no operations with plus and minus
        if(childCount == 1){
            return visit(ctx.term(0));
        }
        else {
            return visitArithm_exprChild(ctx.getChild(1), ctx, 1);
        }
    }

    //Todo evt lav den general ved at lave en generisk metode
    public AstNode visitArithm_exprChild(ParseTree child, CStarParser.Arithm_exprContext parent, int operatorIndex){
        int termIndex = (operatorIndex - 1) / 2;
        AstNode node;

        switch (child.getText()) {
            case "+":
                node = new AddNode();
                break;
            case "-":
                node = new SubNode();
                break;
            default:
                //todo error handling
                return null;
        }

        //Enters if there are more operators in the tree
        if(parent.getChild(operatorIndex + 2) != null) {
            operatorIndex += 2;

            //Add left child (term)
            node.children.add(visitTerm(parent.term(termIndex)));
            //Add right child (operator)
            node.children.add(visitArithm_exprChild(parent.getChild(operatorIndex), parent, operatorIndex));
        }
        //Enters if there is only a term child left
        else{
            // Add left and right child (terms)
            node.children.add(visitTerm(parent.term(termIndex)));
            node.children.add(visitTerm(parent.term(termIndex + 1)));
        }

        return node;
    }

    @Override public AstNode visitTerm(CStarParser.TermContext ctx) {
        int childCount = ctx.getChildCount();

        //If there are no operations with mult or div
        if(childCount == 1){
            //TODO Husk at visit skal return noget
            return visit(ctx.factor(0));
        }
        else {
            return visitTermChild(ctx.getChild(1), ctx, 1);
        }
    }

    //Todo evt lav den general ved at lave en generisk metode
    public AstNode visitTermChild(ParseTree child, CStarParser.TermContext parent, int operatorIndex) {
        int factorIndex = (operatorIndex - 1) / 2;
        AstNode node;

        //Enters if there are more operators in the tree
        switch (child.getText()) {
            case "*":
                node = new MultNode();
                break;
            case "/":
                node = new DivNode();
                break;
            default:
                //todo error handling
                return null;
        }

        //Enters if there are more operators in the tree
        if (parent.getChild(operatorIndex + 2) != null) {
            operatorIndex += 2;

            //Add left child (term)
            node.children.add(visit(parent.factor(factorIndex)));
            //Add right child (operator)
            node.children.add(visitTermChild(parent.getChild(operatorIndex), parent, operatorIndex));
        }
        //Enters if there is only a term child left
        else {
            // Add left and right child (terms)
            node.children.add(visit(parent.factor(factorIndex)));
            node.children.add(visit(parent.factor(factorIndex + 1)));
        }

        return node;
    }
    

    @Override public AstNode visitFactor(CStarParser.FactorContext ctx) {
        var child = ctx.getChild(0);
        String classes = child.getClass().toString();
        boolean isNegative = false;

        if (child.getText().equals("-")) { //checks if negative factor
            child = ctx.getChild(1);
            classes = child.getClass().toString();
            isNegative = true;
        }

        switch (classes){
            case "class com.p4.parser.CStarParser$ValContext": //if value
                return visit(ctx.val());
            case "class org.antlr.v4.runtime.tree.TerminalNodeImpl": //if paren or id
                if (child.getText().equals("(")) {
                    return visit(ctx.expr());
                }
                else {
                    return new IdNode(child.getText(), isNegative);
                }
            case "class com.p4.parser.CStarParser$Func_callContext": // if func call
                return visit(ctx.func_call());
            default:
                //todo error handling
                return null;
        }
    }

    @Override public AstNode visitReturn_exp(CStarParser.Return_expContext ctx) {
        ReturnExpNode node = new ReturnExpNode();
        node.children.add(visit(ctx.expr()));

        return node;
    }

    @Override public AstNode visitCond_expr(CStarParser.Cond_exprContext ctx) {
        CondNode node = new CondNode();

        int numChildren = ctx.getChildCount();

        //If there is one child, then its not a condExpr
        if(numChildren == 1){
            return visit(ctx.arithm_expr(0));
        }

        for(int i = 0; i < numChildren; i++){
            ParseTree child = ctx.getChild(i);
            Object object = child.getPayload();

            if(object instanceof CommonToken){
                CommonToken t = (CommonToken) object;

                if(t.getType() == CStarParser.COMP_OP){
                    node.setOperator(t.getText());
                }

                if(t.getType() == CStarParser.AND || t.getType() == CStarParser.OR){
                    node.children.add(visit(child));
                    CondNode newCondNode = new CondNode();

                    newCondNode.children.addAll(node.children);
                    node.children.clear();
                    node.children.add(newCondNode);
                }

                node.setOperator(t.getText());
            } else{
                node.children.add(visit(child));
            }
        }
        if(node.getOperator() == null){
            return node.getChildren().get(0);
        } else{
            return node;
        }
    }

    @Override public AstNode visitFunc(CStarParser.FuncContext ctx) {

        System.out.println(ctx.ID().toString());

        FuncNode node = new FuncNode();
        node.id = ctx.ID().toString();
        node.returnType = (ctx.return_type().TYPE() != null ? ctx.return_type().TYPE().toString() : "void");
        if(ctx.param() != null){
            node.children.add(visit(ctx.param()));
        }
        node.children.add(visit(ctx.blk()));
        System.out.println(ctx.toString());

        return node;
    }

    @Override public AstNode visitParam(CStarParser.ParamContext ctx) {
        ParamNode paramNode = new ParamNode();
        int numChild = ctx.getChildCount();
        for(int childIndex = 0; childIndex < numChild; childIndex++){ //Skips comma and jumps to type
            switch (ctx.getChild(childIndex).toString()){
                case "integer":
                    paramNode.children.add(new IdNode(ctx.getChild(++childIndex).toString(), "integer"));
                    break;
                case "decimal":
                    paramNode.children.add(new IdNode(ctx.getChild(++childIndex).toString(), "decimal"));
                    break;
                case "pin":
                    paramNode.children.add(new IdNode(ctx.getChild(++childIndex).toString(), "pin"));
                    break;
                case "big integer":
                    paramNode.children.add(new IdNode(ctx.getChild(++childIndex).toString(), "big integer"));
                    break;
                case "character":
                    paramNode.children.add(new IdNode(ctx.getChild(++childIndex).toString(), "character"));
                    break;
                default:
                    //todo error handling
                    return paramNode;
            }
        }
        return paramNode;
    }

    @Override public AstNode visitBlk(CStarParser.BlkContext ctx) {

        BlkNode node = new BlkNode();
        // linje 435 findes duplikatet
        int numChildren = ctx.getChildCount();

        for (int i = 0; i < numChildren; i++){
            ParseTree child = ctx.getChild(i);
            if(child.getPayload() instanceof CommonToken)
                continue;
            AstNode childResult = visit(child);
            node.children.add(childResult);
        }
        return node;
    }

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
    //@Override public T visitArray_call(CStarParser.Array_callContext ctx) { return visitChildren(ctx); }

    @Override public AstNode visitArray_assign(CStarParser.Array_assignContext ctx) {
        //Id is index 0, the Index is at index 1, and the assigned value is at 2
        ArrayAssignNode arrayAssignNode = new ArrayAssignNode();

        //First add ID at index 0
        IdNode id = new IdNode(ctx.getChild(0).getText(), false);
        arrayAssignNode.children.add(id);

        int numChildren = ctx.getChildCount();

        for (int i = 0; i < numChildren; i++){
            ParseTree child = ctx.getChild(i);
            if(child.getPayload() instanceof CommonToken)
                continue;
            AstNode childResult = visit(child);
            arrayAssignNode.children.add(childResult);
        }

        return arrayAssignNode;
    }
    @Override public AstNode visitStmt(CStarParser.StmtContext ctx) {
        
        ParseTree child = ctx.getChild(0);
        String classes = child.getClass().toString();
        switch (classes) {
            case "class com.p4.parser.CStarParser$AssignContext":
                return visit(ctx.assign());
            case "class com.p4.parser.CStarParser$ExprContext":
                return visit(ctx.expr());
            case "class com.p4.parser.CStarParser$SelectiveContext":
                return visit(ctx.selection());
            case "class com.p4.parser.CStarParser$IterativeContext":
                return visit(ctx.iterative());
            default:
                return null;
        }
    }
}
