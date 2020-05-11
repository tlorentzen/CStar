package com.p4.syntaxSemantic.visitors;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.syntaxSemantic.CStarParser;
import com.p4.syntaxSemantic.nodes.*;
import com.p4.symbols.Attributes;
import com.p4.symbols.CStarScope;
import com.p4.symbols.SymbolTable;

import java.util.List;
import java.util.Map;

public class SemanticsVisitor implements INodeVisitor {
    SymbolTable symbolTable;
    ErrorBag errors;

    public SemanticsVisitor(SymbolTable symbolTable, ErrorBag errors) {
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    public void visitChildren(AstNode node) {
        for (AstNode child : node.children) {
            child.accept(this);
        }
    }

    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    public void visit(IntegerDclNode node) {
        this.visitChildren(node);
    }

    public void visit(LongDclNode node) {
        this.visitChildren(node);
    }

    public void visit(SmallDclNode node) {
        this.visitChildren(node);
    }

    public void visit(FloatDclNode node) {
        this.visitChildren(node);
    }

    public void visit(CharDclNode node) {
        this.visitChildren(node);
    }

    public void visit(PinDclNode node) {
        this.visitChildren(node);
    }

    public void visit(BooleanDclNode node) {
        this.visitChildren(node);
    }

    public void visit(ArrayExprNode node) {
        this.visitChildren(node);
    }

    public void visit(ArrayNode node) {
        this.visitChildren(node);
    }

    public void visit(BlkNode node) {
        this.visitChildren(node);
    }

    public void visit(ParamNode node) {
        this.visitChildren(node);
    }

    public void visit(PrintNode node) {

    }

    public void visit(AssignNode node) {
        this.visitChildren(node);

        String leftType = node.children.get(0).type;
        String resultType;

        //Enters if the right hand side is a function call
        if (node.children.get(1) instanceof FuncCallNode) {
            resultType = assignFuncCall(node, leftType);

            if (!resultType.equals("error")) {
                node.type = resultType;
            }
        }
        //Enters if the right hand side is an expression
        else {
            String rightType = node.children.get(1).type;

            if (leftType != null && rightType != null) {
                resultType = operationResultType(leftType, rightType);

                if (resultType.equals("error")) {
                    errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("assignment", leftType, rightType), node.lineNumber);
                }
                else {
                    node.type = resultType;
                }
            }
            else {
                errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("null type"), node.lineNumber);
            }
        }
    }

    //Checks if the return type of the function call is the compatible with the type on the left hand side of the assignment
    private String assignFuncCall(AssignNode assignNode, String leftType) {
        FuncCallNode funcCallNode = (FuncCallNode) assignNode.children.get(1);
        String rightType = ((IdNode)funcCallNode.children.get(0)).type;

        //Returns error if any of the types are null
        if (leftType  == null || rightType == null) {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("null"), assignNode.lineNumber);
            return "error";
        }
        //Returns error if the function id is of the void type
        else if (rightType.equals("void")) {
            String funcId = ((IdNode) funcCallNode.children.get(0)).getId();

            errors.addEntry(ErrorType.VOID_ASSIGN, errorMessage("func assign", funcId, leftType), assignNode.lineNumber);
            return "error";
        }
        //Returns the leftType if the function has type "ArduinoC"
        else if (rightType.equals("ArduinoC")) {
            return leftType;
        }
        //Returns the result type found in operationResultType
        else {
            String resultType = operationResultType(leftType, rightType);

            if (resultType.equals("error")) {
                errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("assignment", leftType, rightType), assignNode.lineNumber);
            }
            return resultType;
        }
    }

    //Checks if the left and right hand side of the assignment are compatible
    private String operationResultType(String leftType, String rightType) {
        //First Semantic rule
        if (leftType.equals(rightType)) {
            return leftType;
        }
        //Second rule
        else if ((leftType.equals("decimal") || leftType.equals("long integer")) &&
                (rightType.equals("integer") || rightType.equals("small integer"))) {
            return leftType;
        }
        //Third rule
        else if ((leftType.equals("integer") || leftType.equals("pin")) && rightType.equals("small integer")) {
            return leftType;
        }
        else {
            return "error";
        }
    }

    public void visit(LogicalNode node) {
        this.visitChildren(node);
        checkBooleanType(node, true);
    }

    public void visit(CondNode node) {
        this.visitChildren(node);

        checkIfArrayIsOperand(node, "compare");
        checkBooleanType(node, false);
    }


    private void checkIfArray(AstNode node, String errorMessage) {
        //Displays error if an array is one of the operands
        if (tryCastId(node)) {
            IdNode idNode = (IdNode)node;
            Attributes leftAttribute = symbolTable.lookupSymbol(idNode.getId());

            if (leftAttribute == null) {
                errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("no id dcl", idNode.getId()), node.lineNumber);
            }
            else if (leftAttribute.getKind().equals("array")) {
                errors.addEntry(ErrorType.TYPE_ERROR, errorMessage(errorMessage), node.lineNumber);
            }
        }
    }

    private void checkIfArrayIsOperand(AstNode node, String errorMessage) {
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);

        //Displays error if an array is one of the operands
        if (tryCastId(leftChild)) {
            checkIfArray(leftChild, node, errorMessage);
        }
        if (tryCastId(rightChild)) {
            checkIfArray(rightChild, node, errorMessage);
        }
    }

    //Returns true if it is possible to cast the node to an idNode
    private boolean tryCastId(AstNode id) {
        IdNode idNode;

        try {
            idNode = (IdNode)id;
            return true;
        }
        catch (ClassCastException e) {
            return false;
        }
    }

    //Displays error if the id is an array
    private void checkIfArray(AstNode id, AstNode parent, String message) {
        IdNode leftId = (IdNode)id;
        Attributes leftAttribute = symbolTable.lookupSymbol(leftId.getId());

        if (leftAttribute.getKind().equals("array")) {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("array", message), parent.lineNumber);
        }
    }

    @Override
    public void visit(InNode node) {
        visitChildren(node);

        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;

        //Enters if one or both of operands has no type
        if (leftType == null || rightType == null) {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("null type"), node.lineNumber);
        }
        else {
            checkInNode(leftType, rightType, node);
        }
    }

    //Checks if the inNode operands are valid
    private void checkInNode(String leftType, String rightType, AstNode node) {
        //Parameters below are switched, since widening is only possible for the left side instead of right side
        String resultType = operationResultType(rightType, leftType);
        //Gets right side and checks if it is an array
        IdNode idNode = (IdNode) node.children.get(1);
        Attributes rightAttribute = symbolTable.lookupSymbol(idNode.getId());

        //Enters if the id h node has not been declared
        if (rightAttribute != null) {
            //Enters if the id is not an array
            if (!rightAttribute.getKind().equals("array")) {
                errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("not array"), node.lineNumber);
            }
            //Enters if the types were not compatible
            else if (resultType.equals("error") && !leftType.equals("ArduinoC")) {
                errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("comparison", leftType, rightType), node.lineNumber);
            }
            //Enters if the types were compatible and the id was an array
            else {
                node.type = "boolean";
            }
        }
    }

    private void checkBooleanType(AstNode node, boolean isLogical) {
        boolean isValidType;
        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;

        //Checks if the types of the children are valid
        if (isLogical) {
            isValidType = logicalOperationValid(leftType, rightType);
        }
        //TODO tjek om dette er 100% korrekt
        else if (node instanceof IntervalNode){
            isValidType = intervalOperationValid((IntervalNode) node);
        }
        else {
            boolean areTypesArduino = leftType.equals("ArduinoC") || rightType.equals("ArduinoC");
            boolean isCompareLegal = compareOperationValid(((CondNode)node).getToken(), leftType, rightType);
            isValidType = isCompareLegal || areTypesArduino;
        }

        //Enters if the type is valid
        if (!isValidType) {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage(isLogical ? "combination" : "comparison", leftType, rightType), node.lineNumber);
        }
        else {
            //The result type will always be boolean
            node.type = "boolean";
        }
    }

    //Checks whether the operands in the logical expression are boolean
    private boolean logicalOperationValid(String leftType, String rightType) {
        if (leftType == null || rightType == null) {
            return false;
        }
        return leftType.equals("boolean") && rightType.equals("boolean");
    }

    //Checks whether the operands in the interval are a number type
    private boolean intervalOperationValid(IntervalNode node) {
        String leftType = node.children.get(0).type;
        String firstNumType = node.children.get(1).type;
        String secondNumType = node.children.get(2).type;

        if (leftType == null || firstNumType == null || secondNumType == null) {
            return false;
        }
        //Return true if all types are a number type
        if ((isNumber(leftType) && isNumber(firstNumType) && isNumber(secondNumType))) {
            return true;
        }
        else if (leftType.equals("ArduinoC")) {
            errors.addEntry(ErrorType.ARDUINO_FUNCTION_IN_INTERVAL, errorMessage("arduino c in interval"), node.lineNumber);
            return false;
        }
        else {
            return false;
        }
    }

    private boolean compareOperationValid(int operator, String leftType, String rightType) {
        //Checks if either type is null
        if (leftType == null || rightType == null) {
            return false;
        }

        //Checks if the operator is IS or ISNOT
        if (operator == CStarParser.IS || operator == CStarParser.ISNOT) {
            if (leftType.equals(rightType)) {
                return true;
            }
            //Returns true if left and right types are both numbers
            else {
                return isNumber(leftType) && isNumber(rightType);
            }
        }
        //Checks if the operator is '<', '>', '<=', or '>='
        else if (operator == CStarParser.LESS_THAN || operator == CStarParser.GREATER_THAN ||
                operator == CStarParser.LESS_THAN_EQ || operator == CStarParser.GREATER_THAN_EQ) {
            //Returns true if left and right types are both numbers or
            //Returns true if left and right types are of the same type and not booleans
            return (isNumber(leftType) && isNumber(rightType)) ||
                    (leftType.equals(rightType) && !leftType.equals("boolean"));
        }
        else {
            return false;
        }
    }

    //Checks if the type is of the number types
    private boolean isNumber(String type) {
        return (type.equals("decimal") || type.equals("long integer") ||
                type.equals("integer") || type.equals("small integer"));
    }

    public void visit(AddNode node) {
        visitTermChildren(node);
        checkIfArrayIsOperand(node, "add");
    }

    public void visit(SubNode node) {
        visitTermChildren(node);
        checkIfArrayIsOperand(node, "subtract");
    }

    private void visitTermChildren(AstNode node) {
        this.visitChildren(node);
        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;
        String resultType = arithOperationResultType(leftType, rightType);

        //Enters if the conversion is illegal and both types are numbers
        if (resultType.equals("error") && (isNumber(leftType) || isNumber(rightType))) {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("conversion", leftType, rightType), node.lineNumber);
        }
        //Enters if one of the operand types is illegal (e.g. char or bool)
        else if(resultType.equals("error")) {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("non-number", leftType, rightType), node.lineNumber);
        }
        else {
            node.type = resultType;
        }
    }

    private String arithOperationResultType(String leftType, String rightType) {
        //Checks if either type is null
        if (leftType == null || rightType == null) {
            return "error";
        }
        //First semantic rule
        if(leftType.equals(rightType) && isNumber(leftType)) {
            return leftType;
        }
        //Second semantic rule
        else if (((leftType.equals("integer") || leftType.equals("small integer")) && rightType.equals("decimal")) ||
                (leftType.equals("decimal") && (rightType.equals("integer") || rightType.equals("small integer")))) {
            return "decimal";
        }
        //Third semantic rule
        else if (((leftType.equals("integer") || leftType.equals("small integer")) && rightType.equals("long integer")) ||
                ((rightType.equals("integer") || rightType.equals("small integer")) && leftType.equals("long integer"))) {
            return "long integer";
        }
        //Fourth semantic rule
        else if ((leftType.equals("integer") && rightType.equals("small integer")) ||
                (leftType.equals("small integer") && rightType.equals("integer"))) {
            return "integer";
        }
        else if (leftType.equals("ArduinoC")) {
            return rightType;
        } 
        else if (rightType.equals("ArduinoC")) {
            return leftType;
        }
        else {
            return "error";
        }
    }

    public void visit(MultNode node) {
        this.visitChildren(node);
        visitFactorChildren(node);
        checkIfArrayIsOperand(node, "multiply");
    }

    public void visit(ModNode node) {
        this.visitChildren(node);

        visitFactorChildren(node);

        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;

        //Checks if either type is decimal (illegal for mod operator)
        if (leftType.equals("decimal") || rightType.equals("decimal")) {
            node.type = null;
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("non-decimal"), node.lineNumber);
        }
        checkIfArrayIsOperand(node, "modulo");
    }

    public void visit(DivNode node) {
        this.visitChildren(node);

        AstNode rightChild = node.children.get(1);

        //Enters if the denominator is 0
        if (isNumber(rightChild.type) && isDivByZero(rightChild)) {
            errors.addEntry(ErrorType.ZERO_DIVISION, errorMessage("div by zero"), node.lineNumber);
        }
        else {
            //Checks if the types are legal and compatible
            visitFactorChildren(node);
        }
        checkIfArrayIsOperand(node, "divide");
    }

    //Checks if the denominator is zero
    private boolean isDivByZero(AstNode denominator) {
        boolean isZero = (((NumberNode)denominator).getValue() == 0);

        return (denominator.type.equals("small integer") && isZero) ||
                (denominator.type.equals("integer") && isZero) ||
                (denominator.type.equals("long integer") && isZero);
    }

    //Finds the result type for the operation
    private void visitFactorChildren(AstNode node) {
        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;
        String resultType = arithOperationResultType(leftType, rightType);

        //Enters if the conversion is illegal and both types are numbers
        if (resultType.equals("error") && (isNumber(leftType) || isNumber(rightType))) {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("combination", leftType, rightType), node.lineNumber);
        }
        //Enters if one of the operand types is illegal (e.g. char or bool)
        else if (resultType.equals("error")) {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("non-number", leftType, rightType), node.lineNumber);
        }
        else {
            node.type = resultType;
        }
    }

    public void visit(ArrayDclNode<?> node) {
        this.visitChildren(node);

        String leftType = node.children.get(0).type;
        List<AstNode> arrayElements = node.children.get(1).children;
        boolean errorOccurred = false;

        for (AstNode exprChild : arrayElements) {
            String elementType = exprChild.type;

            //Enters if left type and element type are not compatible
            if (!isLegalType(leftType, elementType)) {
                errorOccurred = true;
                errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("conversion", leftType, elementType), node.lineNumber);
            }
        }
        if (!errorOccurred) {
            node.type = leftType;
        }
    }

    //Checks if the types are compatible
    private boolean isLegalType(String firstType, String secondType) {
        //Enters if first rule
        if (secondType.equals(firstType)) {
            return true;
        }
        //Enters if second or third rule
        else if ((firstType.equals("decimal") || firstType.equals("long integer")) &&
                (secondType.equals("integer") || secondType.equals("small integer"))) {
            return true;
        }
        //Enters if fourth or fifth rule
        else if ((firstType.equals("integer") || firstType.equals("pin")) &&
                secondType.equals("small integer")) {
            return true;
        }
        else {
            return false;
        }
    }

    public void visit(ArrayAccessNode node) {
        this.visitChildren(node);

        String idType = node.children.get(0).type;
        String indexType = node.children.get(1).type;

        //Checks if the index is an integer type
        if(isNumber(indexType) && !indexType.equals("decimal")) {
            node.type = idType;
        }
        else {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("indexing", indexType), node.lineNumber);
        }
    }

    public void visit(IterativeNode node) {
        this.symbolTable.enterScope(node.getNodeHash());
        this.visitChildren(node);
        this.symbolTable.leaveScope();

        String conditionType = node.children.get(0).type;

        if (!isCondOkType(conditionType)) {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("non-boolean", conditionType), node.lineNumber);
        }
    }

    public void visit(SelectionNode node) {
        this.symbolTable.enterScope(node.getNodeHash());
        this.visitChildren(node);
        this.symbolTable.leaveScope();

        String conditionType = node.children.get(0).type;

        //Enters if the type of the condition was not legal
        if (!(isCondOkType(conditionType))) {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("non-boolean", conditionType), node.lineNumber);
        }
    }

    //Checks if the condition is of type boolean
    private boolean isCondOkType(String condType) {
        if (condType == null) {
            return false;
        }
        return condType.equals("boolean");
    }

    public void visit(FuncDclNode node) {
        this.symbolTable.enterScope(node.getNodeHash());
        this.visitChildren(node);

        String dclReturnType = symbolTable.lookupSymbol(node.getId()).getVariableType();

        if (node.children.size() > 1) {
            //Checks if all children of the function's block are well typed
            for (AstNode blockChild : node.children.get(1).children) {

                //Enters if a return expression is found
                if (blockChild instanceof ReturnExpNode) {
                    //Enters if return type is different and widening cannot be performed
                    if (!isLegalType(dclReturnType, blockChild.type) && !(blockChild.type.equals("ArduinoC"))) {
                        errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("return", blockChild.type, dclReturnType), node.lineNumber);
                    }
                }
            }
        }
        this.symbolTable.leaveScope();
    }

    public void visit(ReturnExpNode node) {
        this.visitChildren(node);
        checkIfArray(node.children.get(0), "array return");
        node.type = node.children.get(0).type;
    }

    //If no errors occur, then the function call will be seen as well typed
    public void visit(FuncCallNode node) {
        this.visitChildren(node);

        String functionName = ((IdNode)node.children.get(0)).getId();

        node.type = ((IdNode) node.children.get(0)).type;

        //Enters if the function is declared
        if (symbolTable.declaredFunctions.contains(functionName)) {
            //Enters if the function includes a dot operator
            if (functionName.contains(".")) {
                String idName = functionName.split("\\.")[0];

                //Enters if the pin has not been declared
                if (symbolTable.lookupSymbol(idName) == null) {
                    //Enters if the left side is an array access
                    if (!idName.contains("[")) {
                        errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("no id dcl",idName), node.lineNumber);
                    }
                }
                else {
                    checkFunction(node, functionName);
                }
            }
        }
        //Enters if the function has not been declared
        else {
            errors.addEntry(ErrorType.UNDECLARED_FUNCTION_WARNING, errorMessage("no func dcl", functionName), node.lineNumber);
        }
    }

    //Checks if the function scope and parameters are valid
    private void checkFunction(FuncCallNode node, String functionName) {
        CStarScope functionScope = this.symbolTable.lookupScope("FuncNode-" + functionName);

        //Enters if the function scope was found in the symbol table
        if (functionScope != null) {
            //Checks if the number of actual parameters corresponds to the number of formal parameters
            if (node.children.size() - 1 != functionScope.getParams().size()) {
                errors.addEntry(ErrorType.PARAMETER_ERROR, errorMessage("number of param", functionName), node.lineNumber);
            }
            else {
                //Checks if the types of the actual parameters are legal
                checkParameterTypes(node, functionScope);
            }
        }
    }

    //Checks if the actual and formal parameter types are compatible
    private void checkParameterTypes(FuncCallNode node, CStarScope functionScope) {
        String actualParamType;
        String formalParamType;
        int currentChild = 1;

        //Goes through all parameters and compares each formal and actual parameter
        for (Map.Entry<String, Attributes> formalParam : functionScope.getParams().entrySet()) {
            actualParamType = node.children.get(currentChild).type;
            formalParamType = formalParam.getValue().getVariableType();

            //Enters if actual param type has no type or has an illegal type
            if (actualParamType == null || actualParamType.equals("error")) {
                errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("actual parameter type", actualParamType), node.lineNumber);
            }
            //Enters if the formal parameter has a type
            else if (formalParamType != null) {
                checkIfArray(node.children.get(currentChild), "array parameter");

                //Checks if types are the same or if type widening is possible
                String resultType = operationResultType(formalParamType, actualParamType);

                //Enters if an error has occurred and either parameter is not of the arduino type
                if (resultType.equals("error") && !actualParamType.equals("ArduinoC") && !formalParamType.equals("ArduinoC")) {
                    errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("parameter", formalParamType, actualParamType), node.lineNumber);
                }
            }
            currentChild++;
        }
    }

    public void visit(IdNode node) {
        //Checks if the IdNode can be an Arduino C function
        if (symbolTable.calledFunctions.contains(node.getId()) && !symbolTable.declaredFunctions.contains(node.getId())) {
            node.type = "ArduinoC";
        }
        else {
            Attributes attributes = symbolTable.lookupSymbol(node.getId());

            //Adds error if id was not found in an accessible scope
            if (attributes == null) {
                // errorMessage("not declared ID");
                errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("no id dcl", node.getId()), node.lineNumber);
            }
            else {
                node.type = attributes.getVariableType();
            }
        }
    }

    public void visit(NumberNode node) {
        String type = checkNumberSize(node);

        if (type.equals("error")) {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("invalid"), node.lineNumber);
        }
        else {
            node.type = type;
        }
    }

    //Finds the smallest number type that can fit the number
    public String checkNumberSize(NumberNode node) {
        if (node.getValue() < Byte.MAX_VALUE && node.getValue() > Byte.MIN_VALUE) {
            return "small integer";
        }
        else if (node.getValue() < Integer.MAX_VALUE && node.getValue() > Integer.MIN_VALUE) {
            return "integer";
        }
        else if (node.getValue() < Long.MAX_VALUE && node.getValue() > Long.MIN_VALUE) {
            return "long integer";
        }
        else {
            return "error";
        }
    }

    public void visit(FloatNode node) {
        node.type = "decimal";
    }

    public void visit(CharNode node) {
        node.type = "character";
    }

    public void visit(PinNode node) {
        node.type = "pin";
    }

    public void visit(BooleanNode node) {
        node.type = "boolean";
    }

    public void visit(ConstantNode node) {
        node.type = "constant";
    }

    public void visit(StringNode node) {
        node.type = "string";
    }

    @Override
    public void visit(CommentNode node) {

    }

    @Override
    public void visit(IncludeNode node) {

    }

    @Override
    public void visit(IntervalNode node) {
        visitChildren(node);
        String leftType = null;

        if (node.children.get(0) instanceof IdNode) {
            leftType = ((IdNode)node.children.get(0)).type;
        }
        else if (node.children.get(0) instanceof NumberNode) {
            leftType = ((NumberNode)node.children.get(0)).type;
        }
        //Enters if the left type is a character, pin, or boolean
        if (leftType != null && (leftType.equals("character") || leftType.equals("pin") || leftType.equals("boolean"))) {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("interval not ID", leftType), node.lineNumber);
        }

        checkBooleanType(node, false);
    }

    @Override
    public void visit(MultValNode node) {
        this.visitChildren(node);
        boolean isValid = multValOperationValid(node);

        if (isValid) {
            node.type = "boolean";
        }
    }

    //Checks whether the elements in the MultVal expression are numbers
    private boolean multValOperationValid(MultValNode node) {
        boolean valid = false;
        String leftType = node.children.get(0).type;

        if (!(leftType.equals("pin") || leftType.equals("boolean"))) {
            for (AstNode child : node.children.subList(1, node.children.size() - 1)) {
                if (multValTypeCheck(leftType, child)) {
                    valid = true;
                }
                else {
                    valid = false;
                    errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("combination", leftType, child.type), node.lineNumber);
                }
            }
        }
        else {
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("MultValNodeTypeError"), node.lineNumber);
        }

        return valid;
    }

    private boolean multValTypeCheck(String leftType, AstNode child){
        String rightType = child.type;
        //Returns true if left and right types are both numbers
        if(isNumber(leftType) && isNumber(rightType)){
            return true;
        }
        //Returns true if left and right types are both characters
        else return leftType.equals("character") && rightType.equals("character");
    }

    //Finds and returns the correct error message
    private String errorMessage(String errorType, String ... type) {
        switch (errorType) {
            //Error messages with two types
            case "combination":
                return "Illegal type conversion: Cannot combine " + type[0] + " with " + type[1];
            case "assignment":
                return "Illegal type conversion: Cannot assign " + type[1] + " to " + type[0];
            case "comparison":
                return "Illegal type conversion: Cannot compare " + type[0] + " with " + type[1];
            case "conversion":
                return "Illegal type conversion: Cannot convert " + type[1] + " to " + type[0];
            case "return":
                return "Illegal return type: Cannot return " + type[0] + " since the function is " + type[1];
            case "parameter":
                return "Illegal parameter type: The actual parameter should be of type " + type[0] + " but is type " + type[1];
            case "func assignment":
                return "Cannot assign function '" + type[1] + "' to " + type[0] + " because it returns void";

            //Error messages with one type
            case "non-number":
                return "Illegal type: The operands must be of a number type, but was of type " + type[0];
            case "non-boolean":
                return "Illegal type: The condition must be of type boolean, but was of type " + type[0];
            case "no id dcl":
                return "ID not declared: '" + type[0] + "' has not been declared in any accessible scope. The type of '" + type[0] + "' will be null";
            case "indexing":
                return "Illegal indexing type: The index can not be of type " + type[0];
            case "actual parameter":
                return "Illegal parameter type: The actual parameter '"+ type[0] +"' is not a legal type";
            case "number of param":
                return "The number of actual parameters does not correspond with the number of formal parameters in call to function '" + type[0] + "'";
            case "no func dcl":
                return "'" + type[0] + "' is not declared in your project. Please make sure that the function is an accepted Arduino C function.";
            case "array":
                return "Illegal type conversion: Cannot " + type[0] + "with an entire array";
            case "interval not ID":
                return "Cannot compare the interval because type is '" + type[0] + "'. " +
                        "Intervals can only be of type 'integer', 'small integer', 'long integer', or 'decimal'";

            //Error messages with no type
            case "array parameter":
                return "Illegal type: Cannot use an entire array as a parameter";
            case "array return":
                return "Illegal type: Cannot return an entire array";
            case "non-decimal":
                return "Illegal type: One or both of the operands are of type decimal";
            case "null type":
                return "Illegal type: One or both of the operands are null";
            case "invalid":
                return "Invalid type: Could not find a compatible type";
            case "div by zero":
                return "Cannot divide by zero";
            case "arduino c in interval":
                return "Arduino C functions are not compatible with intervals.";
            case "not array":
                return "Illegal type: the right operand must be an array";
            case "MultValNodeTypeError":
                return "Cannot test the variable because it is of boolean or pin type. Make sure all elements are a number or a character";
            default:
                return null;
        }
    }
}
