package com.p4.parser.visitors;

import com.p4.parser.CStarParser;
import com.p4.parser.nodes.*;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;

public class AstVisitor<T> extends CStarBaseVisitor<AstNode> {

    @Override
    public AstNode visitProg(CStarParser.ProgContext ctx) {
        ProgNode node = new ProgNode();

        int numChildren = ctx.getChildCount();

        for (int i = 0; i < numChildren; i++) {
            ParseTree child = ctx.getChild(i);
            if (child.getPayload() instanceof CommonToken)
                continue;
            AstNode childResult = visit(child);
            node.children.add(childResult);
        }

        return node;
    }

    @Override
    public AstNode visitDcl(CStarParser.DclContext ctx) {
        // All nodes will be returned to the blkNode visitor, where the children will be saved
        // Test for type
        CStarParser.AssignContext assign = ctx.assign();
        CStarParser.Array_dclContext array_dcl = ctx.array_dcl();

        if (assign != null) {
            //Make assign node
            return visit(assign);
        } else if (array_dcl != null) {
            //Visit array_dcl
            return visit(array_dcl);
        } else {
            //Make normal dlcNode
            AstNode node;

            switch (ctx.TYPE().toString()) {
                case "integer":
                    node = new IntegerDclNode(ctx.ID().toString());
                    break;
                case "decimal":
                    node = new FloatDclNode(ctx.ID().toString());
                    break;
                case "pin":
                    node = new PinDclNode(ctx.ID().toString());
                    break;
                case "long integer":
                    node = new LongDclNode(ctx.ID().toString());
                    break;
                case "character":
                    node = new CharDclNode(ctx.ID().toString());
                    break;
                case "boolean":
                    node = new BooleanDclNode(ctx.ID().toString());
                    break;
                case "small integer":
                    node = new SmallDclNode(ctx.ID().toString());
                    break;
                default:
                    return null;
            }

            node.lineNumber = ctx.start.getLine();
            return node;
        }
    }

    @Override
    public AstNode visitAssign(CStarParser.AssignContext ctx) {

        ParserRuleContext parent = ctx.getParent();
        String classes = parent.getClass().toString();
        AssignNode assignNode = new AssignNode();

        if (classes.equals("class com.p4.parser.CStarParser$DclContext")) {
            String id = ctx.ID().toString();
            CStarParser.ExprContext exprCtx = ctx.expr();
            AstNode exprNode = visit(exprCtx);

            var child = parent.getChild(0);
            String type = child.toString();

            DclNode<?> dclNode;

            switch (type) {
                case "integer":
                    dclNode = new IntegerDclNode(id);
                    break;
                case "decimal":
                    dclNode = new FloatDclNode(id);
                    break;
                case "pin":
                    dclNode = new PinDclNode(id);
                    break;
                case "long integer":
                    dclNode = new LongDclNode(id);
                    break;
                case "character":
                    dclNode = new CharDclNode(id);
                    break;
                case "boolean":
                    dclNode = new BooleanDclNode(id);
                    break;
                case "small integer":
                    dclNode = new SmallDclNode(id);
                    break;
                default:
                    return null;
            }

            assignNode.lineNumber = ctx.start.getLine();
            dclNode.lineNumber = ctx.start.getLine();
            assignNode.children.add(dclNode);
            assignNode.children.add(exprNode);

            return assignNode;
        } else if (ctx.getChild(0).getClass().toString().equals("class com.p4.parser.CStarParser$Array_accessContext")) {
            assignNode.children.add(visit(ctx.array_access()));
            assignNode.children.add(visit(ctx.expr()));
            assignNode.lineNumber = ctx.start.getLine();
            return assignNode;
        } else {
            String id = ctx.ID().toString();
            CStarParser.ExprContext exprCtx = ctx.expr();
            AstNode exprNode = visit(exprCtx);


            IdNode idNode = new IdNode(id, false);
            idNode.lineNumber = ctx.start.getLine();
            assignNode.children.add(idNode);
            assignNode.children.add(exprNode);
            return assignNode;
        }
    }

    @Override
    public AstNode visitVal(CStarParser.ValContext ctx) {
        boolean isNegative = false;
        ParseTree parent = ctx.getParent();

        if (parent.getChild(0).getClass().toString().equals("class org.antlr.v4.runtime.tree.TerminalNodeImpl")) {
            isNegative = true;
        }
        if (ctx.PIN_LITERAL() != null) {
            String pinValue = ((TerminalNodeImpl) ctx.children.get(0)).symbol.getText();
            int value;

            if (pinValue.startsWith("A") || pinValue.startsWith("a")) {
                value = -1 - Integer.parseInt(pinValue.substring(1));
            } else {
                value = Integer.parseInt(ctx.CHAR_LITERAL().getText());
            }
            PinNode node = new PinNode(value, isNegative);
            node.lineNumber = ctx.start.getLine();
            return node;
        }
        else if (ctx.CHAR_LITERAL() != null) {
            String temp = ctx.CHAR_LITERAL().getText();
            CharNode node = new CharNode(temp.charAt(0), isNegative);
            node.lineNumber = ctx.start.getLine();
            return node;
        }
        else if (ctx.BOOLEAN_LITERAL() != null){
            String value = ctx.BOOLEAN_LITERAL().getText();
            if(value.equals("true")){
                return new BooleanNode(true, false);
            }
            else if (value.equals("false")){
                return new BooleanNode(false, false);
            }
            else{
                //error
                return null;
            }
        }
        //Check if the value is a float (not a whole number)
        else if (ctx.NUMBER() != null) {
            if(ctx.NUMBER().getText().contains(".")){
                return new FloatNode(Float.parseFloat(ctx.getText()), isNegative);
            }
            else{
                return new NumberNode(Long.parseLong(ctx.getText()), isNegative);
            }
        } else if(ctx.HIGH() != null || ctx.LOW() != null){
                return new ConstantNode(ctx.HIGH() != null ? "HIGH" : "LOW", false);
        } else {
            return null;
        }
    }

    @Override
    public AstNode visitArray_dcl(CStarParser.Array_dclContext ctx) {
        //We get the ID from current node and the type from the parent (dclnode) by converting the child to a string
        String id = ctx.ID().toString();
        ParserRuleContext parent = ctx.getParent();
        var child = parent.getChild(0);
        String type = child.toString();
        ArrayNode arrayNode = new ArrayNode(id, type);
        arrayNode.lineNumber = ctx.start.getLine();
        AstNode arrayExprNode = (ArrayExprNode) visit(ctx.array_expr());
        var arrayDclNode = new ArrayDclNode(id);
        arrayDclNode.lineNumber = ctx.start.getLine();
        arrayDclNode.children.add(arrayNode);
        arrayDclNode.children.add(arrayExprNode);

        return arrayDclNode;
    }

    @Override
    public AstNode visitArray_expr(CStarParser.Array_exprContext ctx) {
        ArrayExprNode arrayExprNode = new ArrayExprNode();
        arrayExprNode.lineNumber = ctx.start.getLine();
        int childCount = ctx.getChildCount();

        for (int i = 0; i < childCount; i++) {
            var child = ctx.getChild(i);
            String classes = child.getClass().toString();
            //checks if child is a value node
            if (classes.equals("class com.p4.parser.CStarParser$ExprContext")) {
                AstNode literal = visit(child);
                arrayExprNode.children.add(literal);
            }
        }
        return arrayExprNode;
    }

    @Override
    public AstNode visitFunc_call(CStarParser.Func_callContext ctx) {
        //index 0 is ID, Everything that follows is parameter values
        boolean isNegative = false;
        ParseTree parent = ctx.getParent();
        if (parent.getChild(0).getClass().toString().equals("class org.antlr.v4.runtime.tree.TerminalNodeImpl")) {
            isNegative = true;
        }

        FuncCallNode funcCallNode = new FuncCallNode(isNegative);
        funcCallNode.lineNumber = ctx.start.getLine();

        int numChildren = ctx.getChildCount();

        for (int childIndex = 0; childIndex < numChildren; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);
            String classes = child.getClass().toString();
            String id = child.getText();

            //checks if child is a value node
            //TODO lave funktioner til classes.equals da det bliver brugt mange steder
            if (classes.equals("class com.p4.parser.CStarParser$ExprContext")) {
                funcCallNode.children.add(visit(child));
            } else if (isID(id)) {
                IdNode idNode = new IdNode(id, false);
                funcCallNode.children.add(idNode);
            }
        }
        return funcCallNode;
    }

    private boolean isID(String id) {
        return !id.equals("(") && !id.equals(")") && !id.equals(",");
    }

    @Override
    public AstNode visitArithm_expr(CStarParser.Arithm_exprContext ctx) {
        //ArrayExprNode arrayExprNode = new ArrayExprNode();
        int childCount = ctx.getChildCount();

        //If there are no operations with plus and minus
        if (childCount == 1) {
            return visit(ctx.term(0));
        } else {
            return visitArithm_exprChild(ctx.getChild(1), ctx, 1);
        }
    }

    public AstNode visitArithm_exprChild(ParseTree child, CStarParser.Arithm_exprContext parent, int operatorIndex) {
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
                return null;
        }

        node.lineNumber = parent.start.getLine();

        //Enters if there are more operators in the tree
        if (parent.getChild(operatorIndex + 2) != null) {
            operatorIndex += 2;

            //Add left child (term)
            node.children.add(visitTerm(parent.term(termIndex)));
            //Add right child (operator)
            node.children.add(visitArithm_exprChild(parent.getChild(operatorIndex), parent, operatorIndex));
        }
        //Enters if there is only a term child left
        else {
            // Add left and right child (terms)
            node.children.add(visitTerm(parent.term(termIndex)));
            node.children.add(visitTerm(parent.term(termIndex + 1)));
        }

        return node;
    }

    @Override
    public AstNode visitTerm(CStarParser.TermContext ctx) {
        int childCount = ctx.getChildCount();

        //If there are no operations with mult or div
        if (childCount == 1) {
            return visit(ctx.factor(0));
        } else {
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
            case "%":
                node = new ModNode();
                break;
            default:
                return null;
        }

        node.lineNumber = parent.start.getLine();

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

    @Override
    public AstNode visitFactor(CStarParser.FactorContext ctx) {
        var child = ctx.getChild(0);
        String classes = child.getClass().toString();
        boolean isNegative = false;

        //Checks if negative factor
        if (child.getText().equals("-")) {
            child = ctx.getChild(1);
            classes = child.getClass().toString();
            isNegative = true;
        }

        /*if (classes.equals("class org.antlr.v4.runtime.tree.TerminalNodeImpl")){
            if (child.getText().equals("(")) {
                return visit(ctx.expr());
            }
            else {
                return new IdNode(child.getText(), isNegative);
            }
        }
        else {
            visit(child);
        }*/

        switch (classes) {
            case "class com.p4.parser.CStarParser$ValContext": //if value
                return visit(ctx.val());
            case "class org.antlr.v4.runtime.tree.TerminalNodeImpl": //if paren or id
                if (child.getText().equals("(")) {
                    return visit(ctx.expr());
                }
                else {
                    IdNode node = new IdNode(child.getText(), isNegative);
                    node.lineNumber = ctx.start.getLine();
                    return node;
                }
            case "class com.p4.parser.CStarParser$Func_callContext": // if func call
                return visit(ctx.func_call());
            case "class com.p4.parser.CStarParser$Array_accessContext":
                return visit(ctx.array_access());
            default:
                //todo error handling
                return null;
        }
    }

    @Override
    public AstNode visitReturn_exp(CStarParser.Return_expContext ctx) {
        ReturnExpNode node = new ReturnExpNode();
        node.lineNumber = ctx.start.getLine();
        node.children.add(visit(ctx.expr()));

        return node;
    }

    @Override
    public AstNode visitLogical_expr(CStarParser.Logical_exprContext ctx) {
        int childCount = ctx.getChildCount();

        //If there are no operations with AND or OR
        if (childCount == 1) {
            //TODO Husk at visit skal return noget
            return visit(ctx.cond_expr(0));
        } else {
            return visitLogicalChild(ctx.getChild(1), ctx, 1);
        }
    }

    public AstNode visitLogicalChild(ParseTree child, CStarParser.Logical_exprContext parent, int operatorIndex) {
        int condIndex = (operatorIndex - 1) / 2;
        LogicalNode node = new LogicalNode();

        //Enters if there are more operators in the tree
        switch (child.getText()) {
            case "OR":
                node.setOperator(6);
                break;
            case "AND":
                node.setOperator(7);
                break;
            default:
                //todo error handling
                return null;
        }

        node.lineNumber = parent.start.getLine();

        //Enters if there are more operators in the tree
        if (parent.getChild(operatorIndex + 2) != null) {
            operatorIndex += 2;

            //Add left child (cond_expr)
            node.children.add(visit(parent.cond_expr(condIndex)));
            //Add right child (operator)
            node.children.add(visitLogicalChild(parent.getChild(operatorIndex), parent, operatorIndex));
        }
        //Enters if there is only a cond_expr child left
        else {
            // Add left and right child (cond_expr)
            node.children.add(visit(parent.cond_expr(condIndex)));
            node.children.add(visit(parent.cond_expr(condIndex + 1)));
        }
        return node;
    }

    @Override
    public AstNode visitCond_expr(CStarParser.Cond_exprContext ctx) {
        int childCount = ctx.getChildCount();

        //If there is only an operator
        if (childCount == 1) {
            //TODO Husk at visit skal return noget
            return visit(ctx.arithm_expr(0));
        } else {
            return visitCondChild(ctx.getChild(1), ctx, 1);
        }
    }

    public AstNode visitCondChild(ParseTree child, CStarParser.Cond_exprContext parent, int operatorIndex) {
        int arithIndex = (operatorIndex - 1) / 2;
        CondNode node = new CondNode();
        node.lineNumber = parent.start.getLine();

        //Enters if there are more operators in the tree
        switch (child.getText()) {
            case "<":
                node.setOperator(2);
                break;
            case ">":
                node.setOperator(3);
                break;
            case "<=":
                node.setOperator(13);
                break;
            case ">=":
                node.setOperator(14);
                break;
            case "IS":
                node.setOperator(4);
                break;
            case "ISNOT":
                node.setOperator(5);
                break;
            default:
                //todo error handling
                return null;
        }

        //Enters if there are more operators in the tree
        if (parent.getChild(operatorIndex + 2) != null) {
            operatorIndex += 2;

            //Add left child (arith_expr)
            node.children.add(visit(parent.arithm_expr(arithIndex)));
            //Add right child (operator)
            node.children.add(visitCondChild(parent.getChild(operatorIndex), parent, operatorIndex));
        }
        //Enters if there is only a arith_expr child left
        else {
            // Add left and right child (arith_expr)
            node.children.add(visit(parent.arithm_expr(arithIndex)));
            node.children.add(visit(parent.arithm_expr(arithIndex + 1)));
        }
        return node;
    }

    @Override public AstNode visitFunc(CStarParser.FuncContext ctx) {
        FuncDclNode node = new FuncDclNode();
        node.lineNumber = ctx.start.getLine();
        node.id = ctx.ID().toString();
        node.returnType = (ctx.return_type().TYPE() != null ? ctx.return_type().TYPE().toString() : "void");
        if (ctx.param() != null) {
            node.children.add(visit(ctx.param()));
        }
        node.children.add(visit(ctx.blk()));

        return node;
    }

    @Override
    public AstNode visitParam(CStarParser.ParamContext ctx) {
        ParamNode paramNode = new ParamNode();
        paramNode.lineNumber = ctx.start.getLine();
        int numChild = ctx.getChildCount();
        for (int childIndex = 0; childIndex < numChild; childIndex++) { //Skips comma and jumps to type
            IdNode node = null;

            switch (ctx.getChild(childIndex).toString()) {
                case "integer":
                    node = new IdNode(ctx.getChild(++childIndex).toString(), "integer");
                    break;
                case "decimal":
                    node = new IdNode(ctx.getChild(++childIndex).toString(), "decimal");
                    break;
                case "pin":
                    node = new IdNode(ctx.getChild(++childIndex).toString(), "pin");
                    break;
                case "long integer":
                    node = new IdNode(ctx.getChild(++childIndex).toString(), "long integer");
                    break;
                case "character":
                    node = new IdNode(ctx.getChild(++childIndex).toString(), "character");
                    break;
                case "boolean":
                    node = new IdNode(ctx.getChild(++childIndex).toString(), "boolean");
                    break;
                case "small integer":
                    node = new IdNode(ctx.getChild(++childIndex).toString(), "small integer");
                    break;
                default:
                    // TODO: Nothing
            }

            if(node != null){
                node.lineNumber = ctx.start.getLine();
                paramNode.children.add(node);
            }
        }
        return paramNode;
    }

    @Override
    public AstNode visitBlk(CStarParser.BlkContext ctx) {

        BlkNode node = new BlkNode();
        node.lineNumber = ctx.start.getLine();
        // linje 435 findes duplikatet
        int numChildren = ctx.getChildCount();

        for (int i = 0; i < numChildren; i++) {
            ParseTree child = ctx.getChild(i);
            if (child.getPayload() instanceof CommonToken)
                continue;
            AstNode childResult = visit(child);
            node.children.add(childResult);
        }
        return node;
    }

    @Override
    public AstNode visitSelection(CStarParser.SelectionContext ctx) {
        SelectionNode node = new SelectionNode();
        node.lineNumber = ctx.start.getLine();
        node.children.add(visit(ctx.logical_expr()));

        for (CStarParser.BlkContext blk : ctx.blk()) {
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
    @Override
    public AstNode visitIterative(CStarParser.IterativeContext ctx) {
        IterativeNode node = new IterativeNode();
        node.lineNumber = ctx.start.getLine();
        node.children.add(visit(ctx.logical_expr()));
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
    @Override
    public AstNode visitArray_access(CStarParser.Array_accessContext ctx) {
        //Id is index 0, the Index is at index 1, and the assigned value is at 2
        ArrayAccessNode arrayAccessNode = new ArrayAccessNode();
        arrayAccessNode.lineNumber = ctx.start.getLine();

        //First add ID at index 0
        IdNode id = new IdNode(ctx.getChild(0).getText(), false);
        arrayAccessNode.children.add(id);
        arrayAccessNode.children.add(visit(ctx.children.get(2)));

        return arrayAccessNode;
    }

    @Override
    public AstNode visitStmt(CStarParser.StmtContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public AstNode visitPrint(CStarParser.PrintContext ctx) {
        PrintNode printNode = new PrintNode();

        //Goes through all print's children and add them to formatstring (except plus)
        for(int i = 2; i < ctx.children.size() - 1; i++){
            ParseTree child = ctx.getChild(i);
            String classes = child.getClass().toString();

            if (child.getText().equals("+")){
                continue; //plus should not be included (not necessary information)
            }
            else if(child.getText().contains("\"")){
                printNode.addToFormatString(new StringNode(child.getText()));
            }
            else if(classes.equals("class com.p4.parser.CStarParser$ValContext")){
                printNode.addToFormatString(visitVal((CStarParser.ValContext) child));
            }
            else if (classes.equals("class org.antlr.v4.runtime.tree.TerminalNodeImpl")){
                printNode.addToFormatString(new IdNode(child.getText(), false));
            }
            else{
                //todo error handling
                return null;
            }
        }
        return printNode;
    }
}
