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
        } else{
            node.type = symbolTable.lookup(node.id).variableType;
        }
    }

    public void visit(IntegerNode node){
        node.type = "int";
    }

    public void visit(FloatNode node){
        node.type = "float";
    }

    public void visit(PinNode node){
        node.type = "pin";
    }

    public void visit(LongNode node){
        node.type = "long";
    }

    public void visit(CharNode node){
        node.type = "char";
    }

    public void visit(AssignNode node){
        //todo det er en SYNTAX ERROR, flyt til scanner/parser
        if(node.children.size() != 2) {
            errors.addEntry(ErrorType.TYPE_ERROR, "Assign should always have two operands", node.lineNumber);
        } else{
            this.visitChildren(node);
            var leftChild = node.children.get(0);
            var rightChild = node.children.get(1);

            //node.type = binaryOperationResultType(CStarParser.ASSIGN_OP, leftChild.type, rightChild.type);
        }
    }


    public void visit(CondNode node){
        this.visitChildren(node);
        if(node.children.size() == 2){
            String leftChild = node.children.get(0).type;
            String rightChild = node.children.get(1).type;
            //node.type = binaryOperationResultType(node.getOperator(), leftChild, rightChild);
        } else if(node.children.size() == 1){
            node.type = node.children.get(0).type;
        } else {
            errors.addEntry(ErrorType.TYPE_ERROR, "Unexpected number of operands in conditional expression", node.lineNumber);
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
        AstNode leftChild = node.children.get(0);
        AstNode rightChild = node.children.get(1);
        var resultType = arithOperationResultType(leftChild.type, rightChild.type);
        
        if (resultType.equals("error")){ 
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot combine " + leftChild.type + " with " + rightChild.type, node.lineNumber);
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
            attr.variableType = "char";
            attr.kind = node.getType();
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
        }
    }

    public void visit(DivNode node){
        this.visitChildren(node);
        var leftChild = node.children.get(0);
        var rightChild = node.children.get(1);
        var resultType = arithOperationResultType(leftChild.type, rightChild.type);

        if(resultType.equals("error")){
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot combine " + leftChild.type + " with " + rightChild.type, node.lineNumber);
        }
        else{
            if(isDivByZero(rightChild)){
                errors.addEntry(ErrorType.ZERO_DIVISION, "Cannot divide by zero", node.lineNumber);
            }

            node.type = resultType;
        }
    }
    
    public boolean isDivByZero(AstNode denominator){

        return (denominator.type.equals("int") && ((IntegerNode)denominator).getValue() == 0) ||
               (denominator.type.equals("float") && ((FloatNode)denominator).getValue() == 0);
    }

    public void visit(FloatDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = "float";
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
            attr.variableType = "int";
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
            attr.variableType = "long";
            attr.kind = node.getType();
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
        }
    }

    public void visit(MultNode node) {
        this.visitChildren(node);
        var leftChild = node.children.get(0);
        var rightChild = node.children.get(1);
        var resultType = arithOperationResultType(leftChild.type, rightChild.type);

        if (resultType.equals("error")){
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot combine " + leftChild.type + " with " + rightChild.type, node.lineNumber);
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
        var leftChild = node.children.get(0);
        var rightChild = node.children.get(1);
        var resultType = arithOperationResultType(leftChild.type, rightChild.type);

        if (resultType.equals("error")){
            errors.addEntry(ErrorType.TYPE_ERROR, "Illegal type conversion: cannot combine " + leftChild.type + " with " + rightChild.type, node.lineNumber);
        }
        else {
            node.type = resultType;
        }
    }

    private String arithOperationResultType(String leftType, String rightType) {
        //Todo: handle casting
        //first semantic rule
        if(leftType.equals(rightType)){
            return leftType;
        }
        //second semantic rule
        else if((leftType.equals("int") || leftType.equals("long")) && rightType.equals("float") ||
                leftType.equals("float") && (rightType.equals("long") || rightType.equals("int"))) {
            return "float";
        }
        //third semantic rule
        else if((leftType.equals("int") && rightType.equals("long")) ||
                (leftType.equals("long") && rightType.equals("int"))) {
            return "long";
        }
        //wrong semantic!
        else{
            return "error";
        }
    }

    private boolean compareOperationResultType(int operator, String leftType, String rightType) {
        //Todo: handle casting

        if(leftType.equals(rightType)){
            return true;
        }

        return false;
    }

    private String unaryOperationResultType(int operator, String type) {
        //Todo: handle casting
        return type;
        //Skal bruges, hvis vi implementerer negation som en node (lige som i bogen)
    }

    private String dominantTypeConversion(String lhs, String rhs) {
        //Todo: handling casting to dominant type
        if(lhs.equals("float")){
            return "float";
        } else if(rhs.equals("float")){
            return "float";
        } else{
            return "float";
        }
    }
}
