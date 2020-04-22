package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.parser.nodes.*;
import com.p4.symbols.Attributes;
import com.p4.symbols.SymbolTable;

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
        if(!this.symbolTable.declaredInAccessibleScope(node.id)){
            errors.addEntry(ErrorType.TYPE_ERROR, node.id + " has not been declared in any accessible scope", node.lineNumber);
        } else {
            node.type = symbolTable.lookup(node.id).variableType;
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
    
    private String assignOperationResultType(String leftType, String rightType){
        if (leftType.equals(rightType)){
            return leftType;
        }
        else if (leftType.equals("decimal") && (rightType.equals("integer") || rightType.equals("long integer"))){
            return leftType;             
        }
        else if ((leftType.equals("long integer") || leftType.equals("pin")) && rightType.equals("integer")){
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
        if (leftType.equals("integer") && rightType.equals("integer")){
            return true;
        }
        else{
            return false;
        }
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
        //Todo: handle casting
        //forskellig for: (is isnot), (or, and), (greater, less)

        //Checks if the operator is IS or ISNOT
        if(operator == 4 || operator == 5){
            if(leftType.equals(rightType)){
                return true;
            }
            else if(leftType.equals("character") || rightType.equals("character")){
                return false;
            }
            else {
                return true;
            }
        }
        //Checks if the operator is '>' or '<'
        else if(operator == 2 || operator == 3) {
            if(leftType.equals("character") || rightType.equals("character")){
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    public void visit(ArrayAssignNode node) {
        //Todo: implement
    }

    public void visit(ArrayExprNode node) {
        this.visitChildren(node);
        node.type = node.children.get(0).type;
        boolean nodeTypeChecked = false;
        //Todo: reflect in report?
        while(!nodeTypeChecked){
            nodeTypeChecked = true;
            for(AstNode child : node.children){
                if(!child.type.equals(node.type)){
                    node.type = this.dominantTypeConversion(child.type, node.type);
                    child.type = node.type;
                    nodeTypeChecked = false;
                    break;
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
        var ArrayNode = node.children.get(0);
        var ArrayExprNode = node.children.get(1);

        if(!ArrayNode.type.equals(ArrayExprNode.type)){
            //Todo: float, char, and int should be decimal, character, and integer
            errors.addEntry(ErrorType.TYPE_ERROR,  ArrayExprNode.type.substring(0, 1).toUpperCase() + ArrayExprNode.type.substring(1) + " array assigned to " + ArrayNode.type + " array", node.lineNumber);
        }

        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = ArrayNode.type;
            attr.kind = node.getType();
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
        }
    }

    public void visit(BlkNode node) {
        this.visitChildren(node);
    }

    public void visit(CharDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = "character";
            attr.kind = node.getType();
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
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
    
    public boolean isDivByZero(AstNode denominator){
        return (denominator.type.equals("integer") && ((IntegerNode)denominator).getValue() == 0) ||
               (denominator.type.equals("long integer") && ((FloatNode)denominator).getValue() == 0);
    }

    public void visit(FloatDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = "decimal";
            attr.kind = node.getType();
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
        }
    }

    public void visit(FuncCallNode node) {
        //Todo: implement
    }

    public void visit(FuncNode node) {
        symbolTable.addScope("FuncNode-"+System.currentTimeMillis());

        this.visitChildren(node);
        symbolTable.outputAvailableSymbols();
        symbolTable.leaveScope();
    }

    public void visit(IntegerDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = "integer";
            attr.kind = node.getType();
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
        }
    }

    public void visit(IterativeNode node) {
        symbolTable.addScope("IterativeNode-"+System.currentTimeMillis());
        this.visitChildren(node);
        symbolTable.outputAvailableSymbols();
        symbolTable.leaveScope();
    }

    public void visit(LongDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = "long integer";
            attr.kind = node.getType();
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
        }
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

        for(AstNode n : node.getChildren()){
            IdNode param = (IdNode)n;

            Attributes attr = new Attributes();
            attr.variableType = param.type;
            attr.kind = "param";

            symbolTable.insert(param.id, attr);
        }

        this.visitChildren(node);
    }

    public void visit(PinDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = "pin";
            attr.kind = node.getType();
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
        }
    }

    public void visit(SelectionNode node) {
        symbolTable.addScope("SelectionNode-"+System.currentTimeMillis());
        this.visitChildren(node);

        symbolTable.outputAvailableSymbols();
        symbolTable.leaveScope();
    }

    public void visit(StmtNode node) {
        //Todo: implement
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
        //First semantic rule
        if(leftType.equals(rightType)){
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

    private String dominantTypeConversion(String lhs, String rhs) {
        //Todo: handling casting to dominant type
        if(lhs.equals("decimal")){
            return "decimal";
        } else if(rhs.equals("decimal")){
            return "decimal";
        } else{
            return "decimal";
        }
    }
}
