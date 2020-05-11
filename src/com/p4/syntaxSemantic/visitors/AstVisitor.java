package com.p4.syntaxSemantic.visitors;

import com.p4.syntaxSemantic.CStarParser;
import com.p4.syntaxSemantic.CStarTypes;
import com.p4.syntaxSemantic.nodes.*;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

//Creates the AST by visiting all nodes in the parse tree
public class AstVisitor<T> extends CStarBaseVisitor<AstNode> {
    @Override
    public AstNode visitProg(CStarParser.ProgContext ctx) {
        ProgNode progNode = new ProgNode();

        return childVisitor(progNode, ctx.children.toArray(ParseTree[]::new));
    }

    private AstNode childVisitor(AstNode node, ParseTree[] children) {
        //Iterates through all the node's children
        for (ParseTree child : children) {
            //Skips leaves (terminal nodes), since they have no children
            if (child.getPayload() instanceof CommonToken) {
                continue;
            }
            node.children.add(visit(child));
        }

        return node;
    }

    @Override
    public AstNode visitDcl(CStarParser.DclContext ctx) {
        CStarParser.AssignContext assign = ctx.assign();
        CStarParser.Array_dclContext array_dcl = ctx.array_dcl();

        if (assign != null) {
            //Visits assign node
            return visit(assign);
        }
        else if (array_dcl != null) {
            //Visits array_dcl node
            return visit(array_dcl);
        }
        else {
            //Creates normal dclNode
            AstNode dclNode;

            switch (ctx.TYPE().toString()) {
                case "integer":
                    dclNode = new IntegerDclNode(ctx.ID().toString());
                    break;
                case "decimal":
                    dclNode = new FloatDclNode(ctx.ID().toString());
                    break;
                case "pin":
                    dclNode = new PinDclNode(ctx.ID().toString());
                    break;
                case "long integer":
                    dclNode = new LongDclNode(ctx.ID().toString());
                    break;
                case "character":
                    dclNode = new CharDclNode(ctx.ID().toString());
                    break;
                case "boolean":
                    dclNode = new BooleanDclNode(ctx.ID().toString());
                    break;
                case "small integer":
                    dclNode = new SmallDclNode(ctx.ID().toString());
                    break;
                default:
                    return null;
            }

            dclNode.lineNumber = ctx.start.getLine();

            return dclNode;
        }
    }

    @Override
    public AstNode visitAssign(CStarParser.AssignContext ctx) {
        ParserRuleContext parent = ctx.getParent();
        AssignNode assignNode = new AssignNode();

        //Runs if the parent is a declaration
        if (parent instanceof CStarParser.DclContext) {
            return assignDeclaration(ctx, parent);
        }
        //Enters if parent is an array
        else if (ctx.getChild(0) instanceof CStarParser.Array_accessContext) {
            assignNode.lineNumber = ctx.start.getLine();
            assignNode.children.add(visit(ctx.array_access()));
            assignNode.children.add(visit(ctx.expr()));

            return assignNode;
        }
        //Enters if it is a normal assign
        else {
            String id = ctx.ID().toString();
            AstNode exprNode = visit(ctx.expr());

            IdNode idNode = new IdNode(id, false);
            idNode.lineNumber = ctx.start.getLine();
            assignNode.children.add(idNode);
            assignNode.children.add(exprNode);

            return assignNode;
        }
    }

    //Creates a declaration node when a value is declared and assigned
    private AstNode assignDeclaration(CStarParser.AssignContext ctx, ParserRuleContext parent) {
        AssignNode assignNode = new AssignNode();

        String id = ctx.ID().toString();
        CStarParser.ExprContext exprCtx = ctx.expr();
        AstNode exprNode = visit(exprCtx);

        //Gets the type of the declaration
        ParseTree child = parent.getChild(0);
        String type = child.toString();

        DclNode<?> dclNode;

        //Creates the declaration node depending on the type
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
    }

    @Override
    public AstNode visitLogical_expr(CStarParser.Logical_exprContext ctx) {
        int childCount = ctx.getChildCount();

        //Enters if there are no operations with AND or OR
        if (childCount == 1 && ctx.getChild(0) instanceof CStarParser.Cond_exprContext) {
            return visit(ctx.cond_expr(0));
        }
        else if (childCount == 1 && ctx.getChild(0) instanceof CStarParser.IntervalContext) {
            return visit(ctx.interval(0));
        }
        else if (childCount == 1 && ctx.getChild(0) instanceof CStarParser.Test_mult_valContext) {
            return visit(ctx.test_mult_val(0));
        }

        //Enters if there are operations with AND OR OR
        else {
            return visitLogicalChild(ctx.getChild(1), ctx, 1);
        }
    }

    //Creates all factor children and their operators
    //Adds these to the AST in levels
    public AstNode visitLogicalChild(ParseTree child, CStarParser.Logical_exprContext parent, int operatorIndex) {
        LogicalNode node = new LogicalNode();

        //Finds the index of the first operand
        int condIndex = (operatorIndex - 1) / 2;
        //Finds the next operator index
        int nextOperator = operatorIndex + 2;

        //Creates a node depending on the operator
        switch (child.getText()) {
            case "OR":
                node.setToken(6);
                break;
            case "AND":
                node.setToken(7);
                break;
            default:
                return null;
        }

        //Enters if there are more operators in the tree
        if (parent.getChild(nextOperator) != null) {

            if(parent.cond_expr(condIndex) != null){
                //Adds left child (cond_expr)
                node.children.add(visit(parent.cond_expr(condIndex)));
            } else if(parent.interval(condIndex) != null){
                //Adds left child (interval)
                node.children.add(visit(parent.interval(condIndex)));
            } else if(parent.test_mult_val(condIndex) != null){
                //Adds left child (interval)
                node.children.add(visit(parent.test_mult_val(condIndex)));
            }

            //Adds right child (operator) by calling the method recursively
            node.children.add(visitLogicalChild(parent.getChild(nextOperator), parent, nextOperator));
        }
        //Enters if there is only a cond_expr child left
        else {
            if(parent.cond_expr(condIndex) != null){
                // Adds left and right child (cond_expr)
                node.children.add(visit(parent.cond_expr(condIndex)));
                node.children.add(visit(parent.cond_expr(condIndex + 1)));
            } else if(parent.interval(condIndex) != null){
                // Adds left and right child (interval)
                node.children.add(visit(parent.interval(condIndex)));
                node.children.add(visit(parent.interval(condIndex + 1)));
            } else if(parent.test_mult_val(condIndex) != null){
                // Adds left and right child (testMultVal)
                node.children.add(visit(parent.test_mult_val(condIndex)));
                node.children.add(visit(parent.test_mult_val(condIndex + 1)));
            }

        }

        node.lineNumber = parent.start.getLine();

        return node;
    }

    @Override
    public AstNode visitCond_expr(CStarParser.Cond_exprContext ctx) {
        int childCount = ctx.getChildCount();

        //If there is only an operator
        if (childCount == 1) {
            return visit(ctx.arithm_expr(0));
        }
        //Enters if there are operations with conditional operator
        else {
            return visitCondChild(ctx.getChild(1), ctx, 1);
        }
    }

    //Creates all factor children and their operators
    //Adds these to the AST in levels
    public AstNode visitCondChild(ParseTree child, CStarParser.Cond_exprContext parent, int operatorIndex) {
        CondNode node = new CondNode();

        //Finds the index of the first operand
        int arithIndex = (operatorIndex - 1) / 2;
        //Finds the next operator index
        int nextOperator = operatorIndex + 2;

        //Creates a node depending on the operator
        switch (child.getText()) {
            case "<":
                node.setToken(2);
                break;
            case ">":
                node.setToken(3);
                break;
            case "<=":
                node.setToken(13);
                break;
            case ">=":
                node.setToken(14);
                break;
            case "IS":
                node.setToken(4);
                break;
            case "ISNOT":
                node.setToken(5);
                break;
            default:
                return null;
        }

        //Enters if there are more operators in the tree
        if (parent.getChild(nextOperator) != null) {

            //Adds left child (arith_expr)
            node.children.add(visit(parent.arithm_expr(arithIndex)));
            //Adds right child (operator)
            node.children.add(visitCondChild(parent.getChild(nextOperator), parent, nextOperator));
        }
        //Enters if there is only a arith_expr child left
        else {
            //Adds left and right child (arith_expr)
            node.children.add(visit(parent.arithm_expr(arithIndex)));
            node.children.add(visit(parent.arithm_expr(arithIndex + 1)));
        }

        node.lineNumber = parent.start.getLine();

        return node;
    }

    @Override
    public AstNode visitArithm_expr(CStarParser.Arithm_exprContext ctx) {
        int childCount = ctx.getChildCount();

        //Enters if there is only one child
        //Entails that there are no operations with plus and minus
        if (childCount == 1) {
            return visit(ctx.term(0));
        }
        //Enters if there are operations with plus and minus
        else {
            return visitArithm_exprChild(ctx.getChild(1), ctx, 1);
        }
    }

    //Creates the all term children and their operators
    //Adds these to the AST in levels
    private AstNode visitArithm_exprChild(ParseTree child, CStarParser.Arithm_exprContext parent, int operatorIndex) {
        AstNode node;
        //Finds the index of the first term
        int termIndex = (operatorIndex - 1) / 2;
        //Finds the index of the next operator in the tree
        int nextOperator = operatorIndex + 2;

        //Creates a node depending on the operator
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

        //Enters if there are more operators left in the tree
        if (parent.getChild(nextOperator) != null) {
            //Adds left child (term)
            node.children.add(visitTerm(parent.term(termIndex)));
            //Adds right child (operator) by calling this function recursively to get the child
            node.children.add(visitArithm_exprChild(parent.getChild(nextOperator), parent, nextOperator));
        }
        //Enters if there is only term children left
        else {
            //Adds left and right child (terms)
            node.children.add(visitTerm(parent.term(termIndex)));
            node.children.add(visitTerm(parent.term(termIndex + 1)));
        }

        node.lineNumber = parent.start.getLine();

        return node;
    }

    @Override
    public AstNode visitTerm(CStarParser.TermContext ctx) {
        int childCount = ctx.getChildCount();

        //Enters if there is only one child
        //Entails that there are no operations with multiplication, division or modulo
        if (childCount == 1) {
            return visit(ctx.factor(0));
        }
        //Enters if there are operations with multiplication, division or modulo
        else {
            return visitTermChild(ctx.getChild(1), ctx, 1);
        }
    }

    //Creates all factor children and their operators
    //Adds these to the AST in levels
    public AstNode visitTermChild(ParseTree child, CStarParser.TermContext parent, int operatorIndex) {
        AstNode node;
        //Finds the index of the first factor
        int factorIndex = (operatorIndex - 1) / 2;
        //Finds the index of the next operator
        int nextOperator = operatorIndex + 2;

        //Creates a node depending on the operator
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

        //Enters if there are more operators in the tree
        if (parent.getChild(nextOperator) != null) {
            //Adds left child (factor)
            node.children.add(visit(parent.factor(factorIndex)));
            //Adds right child (operator) by calling this function recursively to get the child
            node.children.add(visitTermChild(parent.getChild(nextOperator), parent, nextOperator));
        }
        //Enters if there is only a factor child left
        else {
            // Adds left and right child (factors)
            node.children.add(visit(parent.factor(factorIndex)));
            node.children.add(visit(parent.factor(factorIndex + 1)));
        }

        node.lineNumber = parent.start.getLine();

        return node;
    }

    @Override
    public AstNode visitFactor(CStarParser.FactorContext ctx) {
        ParseTree child = ctx.getChild(0);

        //Checks if the child is a value expression
        if (child instanceof CStarParser.Value_exprContext) {
            return visit(ctx.value_expr());
        }
        //Checks if the child is a terminal node
        else if (child instanceof TerminalNodeImpl) {
            //Checks if the child is a parentheses
            if (child.getText().equals("(")) {
                AstNode node = visit(ctx.expr());

                return addParentheses(node);
            }
        }
        return null;
    }

    @Override
    public AstNode visitValue_expr(CStarParser.Value_exprContext ctx) {
        boolean isNegative = false;
        ParseTree child = ctx.getChild(0);

        //Checks if negative factor
        if (child.getText().equals("-")) {
            child = ctx.getChild(1);
            isNegative = true;
        }

        //Checks if the child is a value
        if (child instanceof CStarParser.ValContext) {
            return visit(ctx.val());
        }
        //Checks if the child is a function call
        else if (child instanceof CStarParser.Func_callContext) {
            return visit(ctx.func_call());
        }
        //Checks if the child is an array access
        else if (child instanceof CStarParser.Array_accessContext) {
            return visit(ctx.array_access());
        }
        //Enters if the child is a variable
        else if (child instanceof TerminalNodeImpl) {
            IdNode idNode = new IdNode(child.getText(), isNegative);
            idNode.lineNumber = ctx.start.getLine();

            return idNode;
        }
        return null;
    }

    //Sets parentheses to true for the related operator
    private AstNode addParentheses(AstNode node) {
         String nodeClass = node.getClass().getName();
         String[] splitClass = nodeClass.split("\\.");

        switch (splitClass[splitClass.length - 1]) {
            case "AddNode":
                AddNode addNode = (AddNode) node;
                addNode.setParentheses(true);
                return addNode;
            case "DivNode":
                DivNode divNode = (DivNode) node;
                divNode.setParentheses(true);
                return divNode;
            case "ModNode":
                ModNode modNode = (ModNode) node;
                modNode.setParentheses(true);
                return modNode;
            case "MultNode":
                MultNode multNode = (MultNode) node;
                multNode.setParentheses(true);
                return multNode;
            case "SubNode":
                SubNode subNode = (SubNode) node;
                subNode.setParentheses(true);
                return subNode;
            case "NumberNode":
                NumberNode numberNode = (NumberNode) node;
                numberNode.setParentheses(true);
                return numberNode;
            case "CondNode":
                CondNode condNode = (CondNode) node;
                condNode.setParentheses(true);
                return condNode;
            case "LogicalNode":
                LogicalNode logicalNode = (LogicalNode) node;
                logicalNode.setParentheses(true);
                return logicalNode;
            default:
                return node;
        }
    }

    @Override
    public AstNode visitArray_dcl(CStarParser.Array_dclContext ctx) {
        //Gets the ID from current node
        String id = ctx.ID().toString();

        //Gets the type from the parent (dclNode)
        ParserRuleContext parent = ctx.getParent();
        ParseTree child = parent.getChild(0);
        String type = child.toString();

        //Creates the left side of the declaration
        ArrayNode arrayNode = new ArrayNode(id, type);
        //Creates the right side of the declaration
        AstNode arrayExprNode = visit(ctx.array_expr());
        //Creates the array declaration by adding the left and right side as children
        AstNode arrayDclNode = new ArrayDclNode<>(id);
        arrayDclNode.children.add(arrayNode);
        arrayDclNode.children.add(arrayExprNode);

        arrayDclNode.lineNumber = ctx.start.getLine();
        arrayNode.lineNumber = ctx.start.getLine();

        return arrayDclNode;
    }

    @Override
    public AstNode visitArray_expr(CStarParser.Array_exprContext ctx) {
        ArrayExprNode arrayExprNode = new ArrayExprNode();
        int childCount = ctx.getChildCount();

        //Iterates through all children of the node
        for (int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            //Checks if child is an expression
            //Nothing should be done if element is ',' or brackets
            if (child instanceof CStarParser.ExprContext) {
                AstNode literal = visit(child);
                arrayExprNode.children.add(literal);
            }
        }
        arrayExprNode.lineNumber = ctx.start.getLine();

        return arrayExprNode;
    }

    @Override
    public AstNode visitArray_access(CStarParser.Array_accessContext ctx) {
        ArrayAccessNode arrayAccessNode = new ArrayAccessNode(false);

        //Adds ID (found in index 0)
        IdNode id = new IdNode(ctx.getChild(0).getText(), false);
        arrayAccessNode.children.add(id);
        //Adds the index (found in index 2)
        arrayAccessNode.children.add(visit(ctx.children.get(2)));

        arrayAccessNode.lineNumber = ctx.start.getLine();

        return arrayAccessNode;
    }

    @Override
    public AstNode visitStmt(CStarParser.StmtContext ctx) {
        //Statement has only one child and should not be created
        return visit(ctx.getChild(0));
    }

    @Override
    public AstNode visitIterative(CStarParser.IterativeContext ctx) {
        IterativeNode iterativeNode = new IterativeNode();

        //Visits the condition and block
        iterativeNode.children.add(visit(ctx.logical_expr()));
        iterativeNode.children.add(visit(ctx.blk()));

        iterativeNode.lineNumber = ctx.start.getLine();

        return iterativeNode;
    }

    @Override
    public AstNode visitSelection(CStarParser.SelectionContext ctx) {
        SelectionNode selectionNode = new SelectionNode();

        //Visits the condition
        selectionNode.children.add(visit(ctx.logical_expr()));

        //Visits the blocks (two blocks if there is an else block)
        for (CStarParser.BlkContext blk : ctx.blk()) {
            selectionNode.children.add(visit(blk));
        }

        selectionNode.lineNumber = ctx.start.getLine();

        return selectionNode;
    }

    @Override
    public AstNode visitBlk(CStarParser.BlkContext ctx) {
        BlkNode blkNode = new BlkNode();
        blkNode.lineNumber = ctx.start.getLine();

        return childVisitor(blkNode, ctx.children.toArray(ParseTree[]::new));
    }

    public AstNode handleBlk(CStarParser.BlkContext ctx, String id) {
        BlkNode node = (BlkNode)visit(ctx);
        node.setParentID(id);
        return node;
    }


    @Override
    public AstNode visitPrint(CStarParser.PrintContext ctx) {
        PrintNode printNode = new PrintNode();

        //Goes through all print's children and adds them to the format string (except plus)
        for (int i = 2; i < ctx.children.size() - 1; i++) {
            ParseTree child = ctx.getChild(i);

            //Plus should not be included
            if (child.getText().equals("+")) {
                continue;
            }
            //Enters if the child is a string
            else if (child.getText().contains("\"")) {
                printNode.addToFormatString(new StringNode(child.getText()));
            }
            //Enters if the child is a value
            else if (child instanceof CStarParser.ValContext) {
                printNode.addToFormatString(visitVal((CStarParser.ValContext) child));
            }
            //Enters if the child is a variable
            else if (child instanceof TerminalNodeImpl) {
                printNode.addToFormatString(new IdNode(child.getText(), false));
            } else {
                return null;
            }
        }

        printNode.lineNumber = ctx.start.getLine();

        return printNode;
    }

    @Override
    public AstNode visitFunc(CStarParser.FuncContext ctx) {
        FuncDclNode funcNode = new FuncDclNode();
        String returnType = ctx.return_type().TYPE() != null ? ctx.return_type().TYPE().toString() : "void";

        //Sets the id and the return type
        funcNode.setReturnType(returnType);
        funcNode.setId(ctx.ID().toString());

        //Adds the functional parameters as children if there are any
        if (ctx.param() != null) {
            funcNode.children.add(visit(ctx.param()));
        }

        funcNode.children.add( handleBlk(ctx.blk(), funcNode.getId()));
        funcNode.lineNumber = ctx.start.getLine();
        funcNode.lineNumber = ctx.start.getLine();

        return funcNode;
    }

    @Override
    public AstNode visitParam(CStarParser.ParamContext ctx) {
        ParamNode paramNode = new ParamNode();
        int numChild = ctx.getChildCount();

        //Skips comma and jumps to type
        for (int childIndex = 0; childIndex < numChild; childIndex++) {
            IdNode idNode;
            String type = ctx.getChild(childIndex).toString();

            //Creates a new variable depending on the type of parameter
            //childIndex is incremented to get the ID of the parameter
            switch (type) {
                case "integer":
                    idNode = new IdNode(ctx.getChild(++childIndex).toString(), "integer");
                    break;
                case "decimal":
                    idNode = new IdNode(ctx.getChild(++childIndex).toString(), "decimal");
                    break;
                case "pin":
                    idNode = new IdNode(ctx.getChild(++childIndex).toString(), "pin");
                    break;
                case "long integer":
                    idNode = new IdNode(ctx.getChild(++childIndex).toString(), "long integer");
                    break;
                case "character":
                    idNode = new IdNode(ctx.getChild(++childIndex).toString(), "character");
                    break;
                case "boolean":
                    idNode = new IdNode(ctx.getChild(++childIndex).toString(), "boolean");
                    break;
                case "small integer":
                    idNode = new IdNode(ctx.getChild(++childIndex).toString(), "small integer");
                    break;
                default:
                    idNode = null;
            }

            if (idNode != null) {
                paramNode.children.add(idNode);
                idNode.lineNumber = ctx.start.getLine();
            }
        }

        paramNode.lineNumber = ctx.start.getLine();

        return paramNode;
    }

    @Override
    public AstNode visitReturn_exp(CStarParser.Return_expContext ctx) {
        ReturnExpNode returnNode = new ReturnExpNode();
        returnNode.children.add(visit(ctx.expr()));
        returnNode.lineNumber = ctx.start.getLine();

        return returnNode;
    }

    @Override
    public AstNode visitFunc_call(CStarParser.Func_callContext ctx) {
        ParseTree parent = ctx.getParent();
        ParseTree child;
        String symbol;
        int numChildren = ctx.getChildCount();
        boolean isNegative = false;

        //Enters if first child is a terminal node (will contain '-' symbol)
        if (parent.getChild(0) instanceof TerminalNodeImpl) {
            isNegative = true;
        }

        FuncCallNode funcCallNode = new FuncCallNode(isNegative);

        for (int childIndex = 0; childIndex < numChildren; childIndex++) {
            child = ctx.getChild(childIndex);
            symbol = child.getText();

            //Checks if child is an actual parameter
            if (child instanceof CStarParser.ExprContext) {
                funcCallNode.children.add(visit(child));
            }
            //Enters if child is the ID for the function
            else if (isID(symbol)) {
                IdNode idNode = new IdNode(symbol, false);
                funcCallNode.children.add(idNode);
            }
        }

        funcCallNode.lineNumber = ctx.start.getLine();

        return funcCallNode;
    }

    //Returns true if the symbol is the ID of the function
    private boolean isID(String symbol) {
        return !symbol.equals("(") && !symbol.equals(")") && !symbol.equals(",");
    }

    @Override
    public AstNode visitVal(CStarParser.ValContext ctx) {
        boolean isNegative = false;
        ParseTree parent = ctx.getParent();

        //Enters if first child is a terminal node (will contain '-' symbol)
        if (parent.getChild(0) instanceof TerminalNodeImpl) {
            isNegative = true;
        }
        //Enters if value is a pin
        if (ctx.PIN_LITERAL() != null) {
            return visitPin(ctx, isNegative);
        }
        //Enters if value is a character
        else if (ctx.CHAR_LITERAL() != null) {
            String charValue = ctx.CHAR_LITERAL().getText();
            CharNode charNode = new CharNode(charValue.charAt(1), isNegative);
            charNode.lineNumber = ctx.start.getLine();

            return charNode;
        }
        //Enters if value is a boolean
        else if (ctx.BOOLEAN_LITERAL() != null) {
            return visitBoolean(ctx);
        }
        //Enters if value is a number
        else if (ctx.NUMBER() != null) {
            //Checks if the value is a float
            if (ctx.NUMBER().getText().contains(".")) {
                return new FloatNode(Float.parseFloat(ctx.getText()), isNegative);
            }
            else {
                return new NumberNode(Long.parseLong(ctx.getText()), isNegative);
            }
        }
        //Enters if value is either the constant HIGH or the constant LOW
        else if (ctx.HIGH() != null || ctx.LOW() != null) {
            String constantValue = ctx.HIGH() != null ? "HIGH" : "LOW";
            return new ConstantNode(constantValue, false);
        }
        else {
            return null;
        }
    }

    private AstNode visitPin(CStarParser.ValContext ctx, boolean isNegative) {
        //Gets the value of the pin
        String pinValue = ((TerminalNodeImpl) ctx.getChild(0)).symbol.getText();
        int intValue;

        //Enters if value starts with 'a'
        if (pinValue.startsWith("A") || pinValue.startsWith("a")) {
            //Makes the number negative if analog
            intValue = (-1) * Integer.parseInt(pinValue.substring(1));
        }
        //Enters if the pin value does not start with 'a'
        else {
            intValue = Integer.parseInt(ctx.CHAR_LITERAL().getText());
        }

        PinNode pinNode = new PinNode(intValue, isNegative);
        pinNode.lineNumber = ctx.start.getLine();

        return pinNode;
    }

    private AstNode visitBoolean(CStarParser.ValContext ctx) {
        String booleanValue = ctx.BOOLEAN_LITERAL().getText();

        if (booleanValue.equals("true")) {
            return new BooleanNode(true, false);
        }
        else if (booleanValue.equals("false")) {
            return new BooleanNode(false, false);
        }
        else {
            return null;
        }
    }

    @Override
    public AstNode visitComment(CStarParser.CommentContext ctx) {
        return new CommentNode(ctx.getText());
    }
    @Override public AstNode visitInclude(CStarParser.IncludeContext ctx) {
        String header = ctx.INCLUDE().getText() + ' ' + ctx.HEADER().getText();
        return new IncludeNode(header);
    }

    @Override public AstNode visitInterval(CStarParser.IntervalContext ctx) {
        IntervalNode node = new IntervalNode();

        //Sets the brackets around the interval
        node.setLeftBracket(ctx.children.get(2).getText());
        node.setRightBracket(ctx.children.get(6).getText());

        //Sets the children of the interval
        //Child 0 is the variable to be compared
        //Child 1 is the lower bound
        //Child 2 is the upper bound
        node.children.add(visit(ctx.children.get(0)));
        node.children.add(visit(ctx.children.get(3)));
        node.children.add(visit(ctx.children.get(5)));

        node.lineNumber = ctx.start.getLine();
        return node;
    }

    @Override public AstNode visitTest_mult_val(CStarParser.Test_mult_valContext ctx) {
        MultValNode node = new MultValNode();

        for(ParseTree child : ctx.children){
            if(!(child instanceof TerminalNode)){
                node.children.add(visit(child));
            }
        }
        node.lineNumber = ctx.start.getLine();

        return node;
    }
}
