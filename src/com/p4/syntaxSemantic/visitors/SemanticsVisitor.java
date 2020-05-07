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
        for(AstNode child : node.children){
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
                resultType = assignOperationResultType(leftType, rightType);

                if (resultType.equals("error")) {
                    errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("assignment", leftType, rightType), node.lineNumber);
                }
                else {
                    node.type = resultType;
                }
            }
            else {
                errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("nulltype"), node.lineNumber);
            }
        }
    }

    //Checks if the return type of the function call is the compatible with the type on the left hand side of the assignment
    private String assignFuncCall(AssignNode assignNode, String leftType){
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
        //Returns the result type found in assignOperationResultType
        else {
            String resultType = assignOperationResultType(leftType, rightType);

            if (resultType.equals("error")) {
                errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("assignment", leftType, rightType), assignNode.lineNumber);
            }
            return resultType;
        }
    }

    //Checks if the left and right hand side of the assignment are compatible
    private String assignOperationResultType(String leftType, String rightType){
        //First Semantic rule
        if (leftType.equals(rightType)) {
            return leftType;
        }
        //Second rule
        else if ((leftType.equals("decimal") || leftType.equals("long integer")) &&
                (rightType.equals("integer") || rightType.equals("long integer") ||
                        rightType.equals("small integer"))) {
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
        checkBooleanType(node, false);
    }

    private void checkBooleanType(AstNode node, boolean isLogical) {
        boolean isValidType;
        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;

        //Checks if the types of the children are valid
        if (isLogical) {
            isValidType = logicalOperationValid(leftType, rightType);
        }
        else {
            isValidType = compareOperationValid(((CondNode)node).getToken(), leftType, rightType);
        }

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
    }

    public void visit(SubNode node) {
        visitTermChildren(node);
    }

    private void visitTermChildren(AstNode node) {
        this.visitChildren(node);
        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;
        String resultType = arithOperationResultType(leftType, rightType);

        //Enters if the conversion is illegal and both types are numbers
        if (resultType.equals("error") && (isNumber(leftType) || isNumber(rightType))){
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
        else {
            return "error";
        }
    }

    public void visit(MultNode node) {
        this.visitChildren(node);
        visitFactorChildren(node);
    }

    public void visit(ModNode node) {
        this.visitChildren(node);

        visitFactorChildren(node);

        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;

        //Checks if either type is decimal (illegal for mod operator)
        if (leftType.equals("decimal") || rightType.equals("decimal")){
            node.type = null;
            errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("non-decimal"), node.lineNumber);
        }
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
                    if (!isLegalType(dclReturnType, blockChild.type)) {
                        errors.addEntry(ErrorType.TYPE_ERROR, errorMessage("return", blockChild.type, dclReturnType), node.lineNumber);
                    }
                }
            }
        }
        this.symbolTable.leaveScope();
    }

    public void visit(ReturnExpNode node) {
        this.visitChildren(node);
        node.type = node.children.get(0).type;
    }

    //If no errors occur, then the function call will be seen as well typed
    public void visit(FuncCallNode node) {
        this.visitChildren(node);

        String functionName = ((IdNode)node.children.get(0)).getId();
        CStarScope functionScope;

        node.type = ((IdNode) node.children.get(0)).type;


        //Enters if the function is declared
        if (symbolTable.declaredFunctions.contains(functionName)) {
            functionScope = this.symbolTable.lookupScope("FuncNode-" + functionName);

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
        //Enters if the function has not been declared
        else {
            errors.addEntry(ErrorType.UNDECLARED_FUNCTION_WARNING, errorMessage("no func dcl", functionName), node.lineNumber);
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
                //Checks if types are the same or if type widening is possible
                String resultType = assignOperationResultType(formalParamType, actualParamType);

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
                node.type = "Not declared";
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
        else if (node.getValue() < Long.MAX_VALUE && node.getValue() > Long.MIN_VALUE){
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

    //Finds and returns the correct error message
    private String errorMessage(String errorType, String ... type) {
        switch (errorType) {
            //Error messages with two types
            case "combination":
                return "Illegal type conversion: cannot combine " + type[0] + " with " + type[1];
            case "assignment":
                return "Illegal type conversion: cannot assign " + type[1] + " to " + type[0];
            case "comparison":
                return "Illegal type conversion: cannot compare " + type[0] + " with " + type[1];
            case "conversion":
                return "Illegal type conversion: cannot convert " + type[1] + " to " + type[0];
            case "return":
                return "Illegal return type: cannot return " + type[0] + " since the function is " + type[1];
            case "parameter":
                return "Illegal parameter type: The actual parameter should be of type " + type[0] + " but is type " + type[1];
            case "func assignment":
                return "Cannot assign function '" + type[1] + "' to " + type[0] + " because it returns void";

            //Error messages with one type
            case "non-number":
                return "Illegal type: the operands must be of a number type, but was of type " + type[0];
            case "non-boolean":
                return "Illegal type: the condition must be of type boolean, but was of type " + type[0];
            case "no id dcl":
                return "ID not declared: '" + type[0] + "' has not been declared in any accessible scope. The type of '" + type[0] + "' will be null";
            case "indexing":
                return "Illegal indexing type: the index can not be of type " + type[0];
            case "actual parameter":
                return "Illegal parameter type: The actual parameter '"+ type[0] +"' is not a legal type";
            case "number of param":
                return "The number of actual parameters does not correspond with the number of formal parameters in call to function '" + type[0] + "'";
            case "no func dcl":
                return "'" + type[0] + "' is not declared in your project. Please make sure that the function is an accepted Arduino C function.";

            //Error messages with no type   
            case "non-decimal":
                return "Illegal type: One or both of the operands are of type decimal";
            case "nulltype":
                return "Illegal type: One or both of the operands are null";
            case "invalid":
                return "Invalid type: Could not find a compatible type";
            case "div by zero":
                return "Cannot divide by zero";
            default:
                return null;
        }
    }
}
