package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.parser.nodes.*;
import com.p4.symbols.Attributes;
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
        Attributes attributes = symbolTable.lookup(node.id);

        if(attributes == null){
            errors.addEntry(ErrorType.TYPE_ERROR, node.id + " has not been declared in any accessible scope. The type of " + node.id + " will be null", node.lineNumber);
            //Todo: set the node.type to something to avoid null pointer exception
        } else {
            node.type = attributes.variableType;
        }
    }

    public void visit(IntegerNode node){
        node.type = "integer";
    }

    public void visit(FloatNode node){
        node.type = "decimal";
    }

    public void visit(PinNode node){
        node.type = "pin";
    }

    public void visit(LongNode node){
        node.type = "long integer";
    }

    public void visit(CharNode node){
        node.type = "character";
    }

    public void visit(AssignNode node){
        this.visitChildren(node);

        String leftType = node.children.get(0).type;
        String rightType= node.children.get(1).type;
        String resultType = assignOperationResultType(leftType, rightType);

        if (resultType.equals("error")){
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot assign " + rightType + " to " + leftType, node.lineNumber);
        }
        else{
            node.type = resultType;
        }
    }
    //todo bedre navn, så den også dækker over FuncCall's parameter type checking. Men er det ikke kinda en assign også?
    private String assignOperationResultType(String leftType, String rightType){
        //Checks if either type is null
        if (leftType == null || rightType == null){
            return "error";
        }
        if (leftType.equals(rightType)){
            return leftType;
        }
        else if (leftType.equals("decimal") && (rightType.equals("integer") || rightType.equals("long integer"))){
            return leftType;
        }
        else if ((leftType.equals("long integer") || leftType.equals("pin")) && rightType.equals("integer")){
            return leftType;
        }
        else if ((leftType.equals("long integer") || leftType.equals("integer")) && rightType.equals("pin")){
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
            node.type = "integer";
        }
    }

    private boolean logicalOperationValid(String leftType, String rightType){
        if(leftType == null || rightType == null){
            return false;
        }

        return leftType.equals("integer") && rightType.equals("integer");
    }

    public void visit(CondNode node){
        boolean isValidType;

        this.visitChildren(node);

        String leftType = node.children.get(0).type;
        String rightType = node.children.get(1).type;

        //Checks if the types of the children are valid
        isValidType = compareOperationValid(node.getOperator(), leftType, rightType);

        if (!isValidType) {
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot combine " + leftType + " with " + rightType, node.lineNumber);
        }
        else{
            //the result type will always be boolean
            node.type = "integer";
        }
    }

    private boolean compareOperationValid(int operator, String leftType, String rightType) {

        //forskellig for: (is isnot), (or, and), (greater, less)

        //Checks if either type is null
        if (leftType == null || rightType == null){
            return false;
        }
        //Checks if the operator is IS or ISNOT
        if(operator == CStarParser.IS || operator == CStarParser.ISNOT){
            if(leftType.equals(rightType)){
                return true;
            }
            else return !leftType.equals("character") && !rightType.equals("character");
        }
        //Checks if the operator is '<' or '>'
        else if(operator == CStarParser.LESS_THAN || operator == CStarParser.GREATER_THAN) {
            return !leftType.equals("character") && !rightType.equals("character");
        }
        else {
            return false;
        }
    }

    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    public void visit(ArrayAccessNode node) {
        String nodeType = node.children.get(1).getClass().getName();
        Attributes arrayAttr = symbolTable.lookup(node.children.get(0).getClass().getName());

        switch (nodeType) {
            case "com.p4.parser.nodes.IntegerNode":
                node.type = "integer";
                break;
            case "com.p4.parser.nodes.FloatNode":
                node.type = "decimal";
                break;
            case "com.p4.parser.nodes.PinNode":
                node.type = "pin";
                break;
            case "com.p4.parser.nodes.CharNode":
                node.type = "character";
                break;
            default:
                node.type = "error";
                break;

        }
    }

    public void visit(ArrayExprNode node) {
        this.visitChildren(node);

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
        //Todo: implement
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

    public void visit(ArrayDclNode<?> node) {
        this.visitChildren(node);
    }

    public void visit(BlkNode node) {
        this.visitChildren(node);
    }

    public void visit(CharDclNode node) {
        this.visitChildren(node);
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
        return (denominator.type.equals("integer") && ((IntegerNode)denominator).getValue() == 0) ||
                (denominator.type.equals("long integer") && ((FloatNode)denominator).getValue() == 0);
    }

    public void visit(FloatDclNode node) {
        this.visitChildren(node);
    }

    //todo widening virker ikke helt endnu. fix det.
    //If no errors occur, then the function call will be seen as well typed
    public void visit(FuncCallNode node) {
        // Gets the function declaration
        String functionName = ((IdNode)node.children.get(0)).id;
        if(symbolTable.enterScope("FuncNode-" + functionName)){
            this.visitChildren(node);
            //Goes through all parameters and compare each formal and actual parameter
            if(node.children.size()-1 != this.symbolTable.getCurrentScope().params.size()){
                errors.addEntry(ErrorType.PARAMETER_ERROR, "The number of actual parameters does not correspond with the number of formal parameters in call to function '" + functionName + "'", node.lineNumber);
            } else{
                int currentChild = 1;
                String actualParamType;
                String formalParamType;
                for (Map.Entry<String, Attributes> formalParam : this.symbolTable.getCurrentScope().params.entrySet()) {
                    actualParamType = findActualParamType(node.children.get(currentChild));

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
        }else{
            errors.addEntry(ErrorType.UNDECLARED_FUNCTION_WARNING, "'" + functionName + "' is not declared in your project. Please make sure that the function is an accepted Arduino C function.", node.lineNumber);
        }
    }

    private String findActualParamType(AstNode actualParam){
        System.out.println(actualParam.toString());
        String[] nodeType = actualParam.toString().split("@", 3);

        //Checks if either type is null
        if (nodeType[0] == null){
            return "error";
        }



        switch (nodeType[0]){
            case "com.p4.parser.nodes.IdNode":
                return symbolTable.lookup(((IdNode)actualParam).id).variableType;
            case "com.p4.parser.nodes.IntegerNode":
                return "integer";
            case "com.p4.parser.nodes.FloatNode":
                return "decimal";
            case "com.p4.parser.nodes.PinNode":
                return "pin";
            case "com.p4.parser.nodes.CharNode":
                return "character";
            default:
                return "error";
        }
    }

    public void visit(FuncNode node) {
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
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type: the condition must be of type boolean or integer, but was of type " + conditionType, node.lineNumber);
        }
    }

    public void visit(LongDclNode node) {
        this.visitChildren(node);
    }

    public void visit(MultNode node) {
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

    public void visit(ParamNode node) {

        this.visitChildren(node);
    }

    public void visit(PinDclNode node) { this.visitChildren(node); }

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
        return condType.equals("integer") || condType.equals("boolean");
    }

    public void visit(StmtNode node) {
        //Todo: implement. Behøver den det?
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

    private String arithOperationResultType(String leftType, String rightType) {
        //Todo: handle casting
        //Checks if either type is null
        if (leftType == null || rightType == null){
            return "error";
        }
        //First semantic rule
        if(leftType.equals(rightType) && (leftType.equals("integer") ||
                leftType.equals("decimal") || leftType.equals("long integer"))) {
            return leftType;
        }
        //Second semantic rule
        else if((leftType.equals("integer") || leftType.equals("long integer")) && rightType.equals("decimal") ||
                leftType.equals("decimal") && (rightType.equals("long integer") || rightType.equals("integer"))) {
            return "decimal";
        }
        //Third semantic rule
        else if((leftType.equals("integer") && rightType.equals("long integer")) ||
                (leftType.equals("long integer") && rightType.equals("integer"))) {
            return "long integer";
        }
        //Wrong semantic!
        else{
            return "error";
        }
    }


    private String unaryOperationResultType(int operator, String type) {
        //Todo: handle casting
        return type;
        //Skal bruges, hvis vi implementerer negation som en node (lige som i bogen)
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
        } else if(leftType.equals("char") || rightType.equals("char")){
            return "character";
        } else {
            //Should never occur
            return "error";
        }
    }
}
