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

    //Explicit declaration scope rule
    public void visit(IdNode node){
        if(!symbolTable.calledFunctions.contains(node.id) || (symbolTable.declaredFunctions.contains(node.id))){
            Attributes attributes = symbolTable.lookup(node.id);

            if(attributes == null){
                errors.addEntry(ErrorType.TYPE_ERROR, node.id + " has not been declared in any accessible scope. " +
                                                                "The type of " + node.id + " will be null", node.lineNumber);
                //Todo: set the node.type to something to avoid null pointer exception
            } else {
                node.type = attributes.variableType;
            }
        } else {
            node.type = "ArduinoC";
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
                errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot combine " + leftType + " with " + rightType, node.lineNumber);
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

    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    //todo fix med det nye semantik
    public void visit(ArrayAccessNode node) {
        this.visitChildren(node);
        node.type = node.children.get(0).type;
    }

    public void visit(ArrayExprNode node) {
        this.visitChildren(node);
        castArrayElements(node, node.children.get(0).type);
    }

    private void castArrayElements(ArrayExprNode node, String type){
        node.type = type;
        boolean nodeTypeChecked = false;
        while(!nodeTypeChecked){
            nodeTypeChecked = true;
            for(AstNode child : node.children){
                if(!child.type.equals(node.type)){
                    String dominantType = this.dominantTypeOfArrayElements(child.type, node.type);
                    if(node.type.equals(dominantType)){
                        child.type = node.type;
                    } else{
                        node.type = dominantType;
                        nodeTypeChecked = false;
                        break;
                    }
                }
            }
        }
    }

    public void visit(ArrayNode node) {
        this.visitChildren(node);
    }

    public void visit(ReturnExpNode node) {
        //Todo: implement - check if the node type is the same as return type of the function
    }

    public void visit(ArrayDclNode<?> node) {
        this.visitChildren(node);
    }

    public void visit(BlkNode node) {
        this.visitChildren(node);
    }

    public void visit(CharDclNode node) {
        this.visitChildren(node);
    }



    public void visit(FloatDclNode node) {
        this.visitChildren(node);
    }

    //todo widening virker ikke helt endnu. fix det.
    //If no errors occur, then the function call will be seen as well typed
    public void visit(FuncCallNode node) {
        // Gets the function declaration
        this.visitChildren(node);
        node.type = ((IdNode) node.children.get(0)).type;
        String functionName = ((IdNode)node.children.get(0)).id;
        CStarScope functionScope;
        if(symbolTable.declaredFunctions.contains(functionName)){
            if((functionScope = this.symbolTable.lookupScope("FuncNode-" + functionName)) != null){
                //Goes through all parameters and compare each formal and actual parameter
                if(node.children.size()-1 != functionScope.params.size()){
                    errors.addEntry(ErrorType.PARAMETER_ERROR, "The number of actual parameters does not correspond with the number of formal parameters in call to function '" + functionName + "'", node.lineNumber);
                } else{
                    int currentChild = 1;
                    String actualParamType;
                    String formalParamType;

                    for (Map.Entry<String, Attributes> formalParam : functionScope.params.entrySet()) {
                        actualParamType = node.children.get(currentChild).type;

                        if (actualParamType.equals("error")) {
                            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal parameter type: The actual parameter is not a legal type", node.lineNumber);
                        }
                        // Checks if types are the same or if type widening is possible
                        else if(!(formalParamType = formalParam.getValue().variableType).equals("")){
                            String resultType = assignOperationResultType(formalParamType, actualParamType);

                            if (resultType.equals("error")) {
                                errors.addEntry(ErrorType.TYPE_ERROR, "Illegal parameter type: The actual parameter should be of type "
                                        + formalParamType + ", but is of type " + actualParamType, node.lineNumber);
                            } else if(resultType.equals(formalParamType)) {
                                node.children.get(currentChild).type = formalParamType; //Todo: might need fix
                            } else{
                                //Todo: handled casting not possible
                            }
                        }
                        currentChild++;
                    }
                }
                symbolTable.leaveScope();
            }
        } else{
            errors.addEntry(ErrorType.UNDECLARED_FUNCTION_WARNING, "'" + functionName + "' is not declared in your project. Please make sure that the function is an accepted Arduino C function.", node.lineNumber);
        }
    }

    private String findActualParamType(AstNode actualParam){
        String[] nodeType = actualParam.toString().split("@", 3);

        //Checks if either type is null
        if (nodeType[0] == null){
            return "error";
        }

        switch (nodeType[0]){
            case "com.p4.parser.nodes.IdNode":
                return symbolTable.lookup(((IdNode)actualParam).id).variableType;
            case "com.p4.parser.nodes.PinNode":
                return "pin";
            case "com.p4.parser.nodes.CharNode":
                return "character";
            default:
                return "error";
        }
    }

    public void visit(FuncDclNode node) {
        this.symbolTable.enterScope(node.getNodeHash());
        this.visitChildren(node);
        this.symbolTable.leaveScope();
    }

    public void visit(IntegerDclNode node) {
        this.visitChildren(node);
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

    public void visit(DivNode node){
        this.visitChildren(node);
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);
        String resultType = arithOperationResultType(leftChild.type, rightChild.type);

        if(resultType.equals("error")){
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot combine " + leftChild.type + " with " + rightChild.type, node.lineNumber);
        }
        else{
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

    public void visit(ParamNode node) {
        this.visitChildren(node);
    }

    public void visit(PinDclNode node) {
        this.visitChildren(node);
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

    public void visit(StmtNode node) { }

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
        //Todo: handle casting
        //Checks if either type is null
        if (leftType == null || rightType == null){
            return "error";
        }
        //First semantic rule
        if(leftType.equals(rightType) && (leftType.equals("integer") ||
           leftType.equals("decimal") || leftType.equals("long integer") ||
           leftType.equals("small integer"))) {
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

    private String dominantTypeOfArrayElements(String leftType, String rightType) {
        if (leftType == null || rightType == null){
            return "error";
        }
        if(leftType.equals("decimal") || rightType.equals("decimal")){
            return "decimal";
        } else if(leftType.equals("pin") || rightType.equals("pin")){
            return "pin";
        } else if(leftType.equals("long integer") || rightType.equals("long integer")){
            return "long integer";
        } else if(leftType.equals("integer") || rightType.equals("integer")){
            return "integer";
        } else if(leftType.equals("small integer") || rightType.equals("small integer")){
            return "small integer";
        } else if(leftType.equals("char") || rightType.equals("char")){
            return "character";
        } else {
            //Should never occur
            return "error";
        }
    }
    public void visit(PrintNode node) { };
}


