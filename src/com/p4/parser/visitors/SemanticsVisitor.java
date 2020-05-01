package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.parser.CStarParser;
import com.p4.parser.nodes.*;
import com.p4.symbols.Attributes;
import com.p4.symbols.CStarScope;
import com.p4.symbols.SymbolTable;

import java.util.Map;

public class SemanticsVisitor implements INodeVisitor {

    SymbolTable symbolTable;
    ErrorBag errors;

    public SemanticsVisitor(SymbolTable symbolTable, ErrorBag errors){
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

    //Explicit declaration scope rule
    public void visit(IdNode node){
        //Checks if the IdNode can be an Arduino C function
        if(symbolTable.calledFunctions.contains(node.id) && !symbolTable.declaredFunctions.contains(node.id)){
            node.type = "ArduinoC";
        }
        else {
            Attributes attributes = symbolTable.lookup(node.id);

            //Adds error if id was not found in an accessible scope
            if(attributes == null){
                errors.addEntry(ErrorType.TYPE_ERROR, "'" + node.id + "' has not been declared in any accessible scope. " +
                                                                "The type of '" + node.id + "' will be null", node.lineNumber);
                node.type = "Not declared";
            } else {
                node.type = attributes.variableType;
            }
        }
    }

    public void visit(NumberNode node) {
        String type = checkNumberSize(node);

        if(type.equals("error")){
            errors.addEntry(ErrorType.TYPE_ERROR, "Invalid type: Could not find a compatible type", node.lineNumber);
        }
        else{
            node.type = type;
        }
    }

    public String checkNumberSize(NumberNode node){
        //Finds the smallest number type that can fit the number
        if(node.value < Byte.MAX_VALUE && node.value > Byte.MIN_VALUE){
            return "small integer";
        }
        else if(node.value < Integer.MAX_VALUE && node.value > Integer.MIN_VALUE) {
            return "integer";
        }
        else if (node.value < Long.MAX_VALUE && node.value > Long.MIN_VALUE){
            return "long integer";
        }
        else {
            return "error";
        }
    }

    public void visit(FloatNode node) {
        node.type = "decimal";
    }

    public void visit(ConstantNode node) { node.type = "constant"; }

    public void visit(BooleanNode node) {
        node.type = "boolean";
    }

    public void visit(BooleanDclNode node) {
        this.visitChildren(node);
    }

    public void visit(SmallDclNode node) {
        this.visitChildren(node);
    }

    public void visit(StringNode node) {
        node.type = "string";
    }

    public void visit(PinNode node){
        node.type = "pin";
    }

    public void visit(CharNode node){
        node.type = "character";
    }

    public void visit(AssignNode node){
        this.visitChildren(node);

        String leftType = node.children.get(0).type;
        String resultType;

        if(node.children.get(1).getClass().getName().equals("com.p4.parser.nodes.FuncCallNode")){
            resultType = assignFuncCall(node, leftType);

            if (!resultType.equals("error")) {
                node.type = resultType;
            }
        }
        else{
            String rightType = node.children.get(1).type;

            if(leftType != null || rightType != null){
                resultType = assignOperationResultType(leftType, rightType);

                if (resultType.equals("error")){
                    errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot assign " + rightType + " to " + leftType, node.lineNumber);
                }
                else{
                    node.type = resultType;
                }
            }
            else{
                errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type: One or both of the operands are null", node.lineNumber);
            }
        }
    }

    private String assignFuncCall(AssignNode node, String leftType){
        FuncCallNode funcCallNode = (FuncCallNode) node.children.get(1);
        String rightType;
        rightType = ((IdNode)funcCallNode.children.get(0)).type;

        //Returns error if any of the types are null
        if(leftType  == null || rightType == null){
            errors.addEntry(ErrorType.TYPE_ERROR, "Operand(s) not declared: One or both of the operands are null", node.lineNumber);
            return "error";
        }
        //Returns error if the function id of the void type
        else if(((IdNode) funcCallNode.children.get(0)).type.equals("void")){
            errors.addEntry(ErrorType.VOID_ASSIGN, "Cannot assign function '" + ((IdNode) funcCallNode.children.get(0)).id + "' to "
                                                                   + node.children.get(0).type + " because it returns void", node.lineNumber);
            return "error";
        }
        //Returns the leftType if the function has type "ArduinoC"
        else if (rightType.equals("ArduinoC")) {
            return leftType;
        }
        //Returns the result type found in assignOperationResultType
        else {
            String resultType = assignOperationResultType(leftType, rightType);

            if (resultType.equals("error")){
                errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot assign " + rightType + " to " + leftType, node.lineNumber);
            }
            return resultType;
        }
    }

    private String assignOperationResultType(String leftType, String rightType){
        //First Semantic rule
        if (leftType.equals(rightType)){
            return leftType;
        }
        //Second rule
        else if ((leftType.equals("decimal") || leftType.equals("long integer")) &&
                (rightType.equals("integer") || rightType.equals("long integer") ||
                 rightType.equals("small integer"))){
            return leftType;
        }
        //Third rule
        else if ((leftType.equals("integer") || leftType.equals("pin")) && rightType.equals("small integer")) {
            return leftType;
        }
        else{
            return "error";
        }
    }

    public void visit(LogicalNode node){
        boolean isValidType;

        this.visitChildren(node);

        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;

        isValidType = logicalOperationValid(leftType, rightType);

        if (!isValidType) {
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot combine " + leftType + " with " + rightType, node.lineNumber);
        }
        else{
            node.type = "boolean";
        }
    }

    private boolean logicalOperationValid(String leftType, String rightType){
        if(leftType == null || rightType == null){
            return false;
        }
        return leftType.equals("boolean") && rightType.equals("boolean");
    }

    public void visit(CondNode node){
        boolean isValidType;

        this.visitChildren(node);

        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;

        //Checks if the types of the children are valid
        isValidType = compareOperationValid(node.getOperator(), leftType, rightType);

        if (!isValidType) {
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot compare " + leftType + " with " + rightType, node.lineNumber);
        }
        else{
            //the result type will always be boolean
            node.type = "boolean";
        }
    }

    private boolean compareOperationValid(int operator, String leftType, String rightType) {
        //Checks if either type is null
        if (leftType == null || rightType == null){
            return false;
        }

        //Checks if the operator is IS or ISNOT
        if(operator == CStarParser.IS || operator == CStarParser.ISNOT){
            if(leftType.equals(rightType)){
                return true;
            }
            else if(isNumber(leftType) && isNumber(rightType)) {
                return true;
            }
            else {
                return false;
            }
        }
        //Checks if the operator is '<' or '>' and '<=' and '>='
        else if(operator == CStarParser.LESS_THAN || operator == CStarParser.GREATER_THAN ||
                operator == CStarParser.LESS_THAN_EQ || operator == CStarParser.GREATER_THAN_EQ) {
            return (isNumber(leftType) && isNumber(rightType)) ||
                   (leftType.equals(rightType) && !leftType.equals("boolean"));
        }
        else {
            return false;
        }
    }

    //Checks if the type is of the number types
    private boolean isNumber(String type){
        return (type.equals("decimal") || type.equals("long integer") ||
                type.equals("integer") || type.equals("small integer"));
    }

    public void visit(ArrayAccessNode node) {
        this.visitChildren(node);

        String idType = node.children.get(0).type;
        String indexType = node.children.get(1).type;

        //Checks if the index is an integer type
        if(isNumber(indexType) && !indexType.equals("decimal")){
            node.type = idType;
        }
        else{
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal indexing type: the index can not be of type " + indexType, node.lineNumber);
        }
    }

    public void visit(ArrayExprNode node) {
        this.visitChildren(node);
    }

    public void visit(ArrayNode node) {
        this.visitChildren(node);
    }

    public void visit(ArrayDclNode<?> node) {
        this.visitChildren(node);

        String leftType = node.children.get(0).type;
        boolean errorOccured = false;

        for(AstNode exprChild : node.children.get(1).children) {
            String elementType = exprChild.type;
            if (!isLegalType(leftType, elementType)) {
                errorOccured = true;
                errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot convert " + elementType + " to " + leftType, node.lineNumber);
            }
        }
        if(!errorOccured){
            node.type = leftType;
        }
    }

    private boolean isLegalType(String firstType, String secondType){
        //Enters if first rule
        if(secondType.equals(firstType)){
            return true;
        }
        //Enters if second or third rule
        else if((firstType.equals("decimal") || firstType.equals("long integer")) &&
                (secondType.equals("integer") || secondType.equals("small integer"))){
            return true;
        }
        //Enters if fourth or fifth rule
        else if((firstType.equals("integer") || firstType.equals("pin")) &&
                secondType.equals("small integer")){
            return true;
        }
        else{
            return false;
        }
    }

    public void visit(ReturnExpNode node) {
        this.visitChildren(node);

        node.type = node.children.get(0).type;
    }

    public void visit(BlkNode node) {
        this.visitChildren(node);
    }

    public void visit(ParamNode node) {
        this.visitChildren(node);
    }

    public void visit(PinDclNode node) {
        this.visitChildren(node);
    }

    public void visit(IntegerDclNode node) {
        this.visitChildren(node);
    }

    public void visit(CharDclNode node) {
        this.visitChildren(node);
    }

    public void visit(FloatDclNode node) {
        this.visitChildren(node);
    }
    public void visit(LongDclNode node) {
        this.visitChildren(node);
    }

    public void visit(MultNode node) {
        visitFactorChildren(node);
    }

    public void visit(ModNode node) {
        visitFactorChildren(node);
    }

    private void visitFactorChildren(AstNode node){
        this.visitChildren(node);
        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;
        var resultType = arithOperationResultType(leftType, rightType);

        if (resultType.equals("error")){
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot combine " + leftType + " with " + rightType, node.lineNumber);
        }
        else {
            node.type = resultType;
        }
    }

    //todo widening virker ikke helt endnu. fix det.
    //If no errors occur, then the function call will be seen as well typed
    public void visit(FuncCallNode node) {
        this.visitChildren(node);

        node.type = ((IdNode) node.children.get(0)).type;
        String functionName = ((IdNode)node.children.get(0)).id;
        CStarScope functionScope;

        //Enters if the function is declared
        if(symbolTable.declaredFunctions.contains(functionName)){
            functionScope = this.symbolTable.lookupScope("FuncNode-" + functionName);

            //Enters if the function scope was found in the symbol table
            if(functionScope != null){
                //Checks if there is the correct number of parameters
                if(node.children.size() - 1 != functionScope.params.size()){
                    errors.addEntry(ErrorType.PARAMETER_ERROR, "The number of actual parameters does not correspond with the number of formal parameters in call to function '" + functionName + "'", node.lineNumber);
                }
                else {
                    checkParameterTypes(node, functionScope);
                }
            }
        } else{
            errors.addEntry(ErrorType.UNDECLARED_FUNCTION_WARNING, "'" + functionName
                    + "' is not declared in your project. Please make sure that the function is an accepted Arduino C function.", node.lineNumber);
        }
    }

    private void checkParameterTypes(FuncCallNode node, CStarScope functionScope){
        String actualParamType;
        String formalParamType;
        int currentChild = 1;

        //Goes through all parameters and compares each formal and actual parameter
        for (Map.Entry<String, Attributes> formalParam : functionScope.params.entrySet()) {
            actualParamType = node.children.get(currentChild).type;
            formalParamType = formalParam.getValue().variableType;

            if (actualParamType == null || actualParamType.equals("error")) {
                errors.addEntry(ErrorType.TYPE_ERROR, "Illegal parameter type: The actual parameter '"+ actualParamType +"' is not a legal type", node.lineNumber);
            }
            //Enters if the formal parameter has a type
            else if(formalParamType != null){
                //Checks if types are the same or if type widening is possible
                String resultType = assignOperationResultType(formalParamType, actualParamType);

                //Enters if an error has occurred and either parameter is not of the arduino type
                if (resultType.equals("error") && !actualParamType.equals("ArduinoC") && !formalParamType.equals("ArduinoC")) {
                    errors.addEntry(ErrorType.TYPE_ERROR, "Illegal parameter type: The actual parameter should be of type "
                            + formalParamType + " but is type " + actualParamType, node.lineNumber);
                }
            }
            currentChild++;
        }
    }

    public void visit(FuncDclNode node) {
        this.symbolTable.enterScope(node.getNodeHash());
        this.visitChildren(node);

        String dclReturnType = symbolTable.lookup(node.id).variableType;

        //Checks all children of the function's block
        if(node.children.size() > 1){
            for(AstNode blockChild : node.children.get(1).children){
                String blockClass = blockChild.getClass().toString();

                //Enters if a return expression is found
                if(blockClass.equals("com.p4.parser.nodes.ReturnExpNode")){
                    //Enters if return type is different and widening cannot be performed
                    if (!isLegalType(dclReturnType, blockChild.type)) {
                        errors.addEntry(ErrorType.TYPE_ERROR, "Illegal return type: cannot return " + blockChild.type +
                                " since the function is " + dclReturnType, node.lineNumber);
                    }
                }
            }
        }
        this.symbolTable.leaveScope();
    }

    public void visit(SelectionNode node) {
        this.symbolTable.enterScope(node.getNodeHash());
        this.visitChildren(node);
        this.symbolTable.leaveScope();

        String conditionType = node.children.get(0).type;
        if(!(isCondOkType(conditionType))){
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type: the condition must be of type boolean or integer, but was of type " + conditionType, node.lineNumber);
        }
    }

    private boolean isCondOkType(String condType){
        //Checks if either type is null
        if (condType == null){
            return false;
        }
        return condType.equals("boolean");
    }

    public void visit(IterativeNode node) {
        this.symbolTable.enterScope(node.getNodeHash());
        this.visitChildren(node);
        this.symbolTable.leaveScope();

        String conditionType = node.children.get(0).type;

        if (!isCondOkType(conditionType)){
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type: the condition must be of type boolean, but was of type " + conditionType, node.lineNumber);
        }
    }

    public void visit(DivNode node){
        this.visitChildren(node);

        AstNode rightChild = node.children.get(1);
        String leftType = node.children.get(0).type;
        String rightType = rightChild.type;
        String resultType = arithOperationResultType(leftType, rightType);

        if(resultType.equals("error")){
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot combine " + leftType + " with " + rightType, node.lineNumber);
        }
        else{
            //Checks if the denominator is zero
            if(isDivByZero(rightChild)){
                errors.addEntry(ErrorType.ZERO_DIVISION, "Cannot divide by zero", node.lineNumber);
            }
            else {
                node.type = resultType;
            }
        }
    }

    private boolean isDivByZero(AstNode denominator){
        boolean isZero = (((NumberNode)denominator).getValue() == 0);

        return (denominator.type.equals("small integer") && isZero) ||
                (denominator.type.equals("integer") && isZero) ||
                (denominator.type.equals("long integer") && isZero);
    }

    public void visit(SubNode node) {
        this.visitChildren(node);
        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;
        String resultType = arithOperationResultType(leftType, rightType);

        if (resultType.equals("error")){
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot combine " + leftType + " with " + rightType, node.lineNumber);
        }
        else {
            node.type = resultType;
        }
    }

    public void visit(AddNode node) {
        this.visitChildren(node);
        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;
        String resultType = arithOperationResultType(leftType, rightType);

        if (resultType.equals("error")){
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot combine " + leftType + " with " + rightType, node.lineNumber);
        }
        else {
            node.type = resultType;
        }
    }

    private String arithOperationResultType(String leftType, String rightType) {
        //Checks if either type is null
        if (leftType == null || rightType == null){
            return "error";
        }
        //First semantic rule
        if(leftType.equals(rightType) && isNumber(leftType)) {
            return leftType;
        }
        //Second semantic rule
        else if(((leftType.equals("integer") || leftType.equals("small integer")) && rightType.equals("decimal")) ||
                ((leftType.equals("decimal") && (rightType.equals("integer") || rightType.equals("small integer"))))) {
            return "decimal";
        }
        //Third semantic rule
        else if(((leftType.equals("integer") || leftType.equals("small integer")) && rightType.equals("long integer")) ||
                ((rightType.equals("integer") || rightType.equals("small integer")) && leftType.equals("long integer"))) {
            return "long integer";
        }
        //Fourth semantic rule
        else if ((leftType.equals("integer") && rightType.equals("small integer")) ||
                 (leftType.equals("small integer") && rightType.equals("integer"))){
            return "integer";
        }
        //Wrong semantic!
        else{
            return "error";
        }
    }

    public void visit(PrintNode node) { }
}
