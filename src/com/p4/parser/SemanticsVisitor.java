package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.parser.nodes.*;
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

    public void visit(IdNode node){
        System.out.println("Visit");
        if(!this.symbolTable.declaredInAccessibleScope(node.id)){
            errors.addEntry("E10", node.id + " has not been declared in any accessible scope", ErrorType.TYPE_ERROR, node.lineNumber);
        } else{
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
        node.type = "long";
    }

    public void visit(CharNode node){
        node.type = "character";
    }

    public void visit(AssignNode node){
        if(node.children.size() != 2) {
            errors.addEntry("E1", "Assign should always have two operands", ErrorType.TYPE_ERROR, node.lineNumber);
        } else{
            this.visitChildren(node);
            var leftChild = node.children.get(0);
            var rightChild = node.children.get(1);
            System.out.println(leftChild);
            System.out.println(rightChild);
            System.out.println(leftChild.type);
            System.out.println(rightChild.type);
            node.type = binaryOperationResultType(CStarParser.ASSIGN_OP, leftChild.type, rightChild.type);
        }
    }

    public void visit(CondNode node){
        this.visitChildren(node);
        if(node.children.size() == 2){
            String leftChild = node.children.get(0).type;
            String rightChild = node.children.get(1).type;
            node.type = binaryOperationResultType(node.getOperator(), leftChild, rightChild);
        } else if(node.children.size() == 1){
            node.type = node.children.get(0).type;
        } else {
            errors.addEntry("E1", "Unexpected number of operands in conditional expression", ErrorType.TYPE_ERROR, node.lineNumber);
        }
    }

    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    public void visit(ArrayAssignNode node) {
        //Todo: implement
    }

    public void visit(ArrayExprNode node) {
        //Todo: implement
    }

    public void visit(ArrayNode node) {
        //Todo: implement
    }

    public void visit(ReturnExpNode node) {
        //Todo: implement
    }

    public void visit(AddNode node) {
        this.visitChildren(node);
        var leftChild = node.children.get(0);
        var rightChild = node.children.get(1);
        node.type = binaryOperationResultType(CStarParser.PLUS, leftChild.type, rightChild.type);
    }

    public void visit(ArrayDclNode<?> node) {
        //Todo: implement
    }

    public void visit(BlkNode node) {
        //Todo: implement
    }

    public void visit(CharDclNode node) {
        //Todo: implement
    }

    public void visit(DivNode node) {
        this.visitChildren(node);
        var leftChild = node.children.get(0);
        var rightChild = node.children.get(1);
        node.type = binaryOperationResultType(CStarParser.DIVISION, leftChild.type, rightChild.type);
    }

    public void visit(FloatDclNode node) {
        //Todo: implement
    }

    public void visit(FuncCallNode node) {
        //Todo: implement
    }

    public void visit(FuncNode node) {
        //Todo: implement
    }

    public void visit(IntegerDclNode node) {
        //Todo: implement
    }

    public void visit(IterativeNode iterativeNode) {
        //Todo: implement
    }

    public void visit(LongDclNode longDclNode) {
        //Todo: implement
    }

    public void visit(MultNode node) {
        this.visitChildren(node);
        var leftChild = node.children.get(0);
        var rightChild = node.children.get(1);
        node.type = binaryOperationResultType(CStarParser.MULT, leftChild.type, rightChild.type);
    }

    public void visit(ParamNode paramNode) {
        //Todo: implement
    }

    public void visit(PinDclNode pinDclNode) {
        //Todo: implement
    }

    public void visit(SelectionNode selectionNode) {
        //Todo: implement
    }

    public void visit(StmtNode stmtNode) {
        //Todo: implement
    }

    public void visit(SubNode node) {
        this.visitChildren(node);
        var leftChild = node.children.get(0);
        var rightChild = node.children.get(1);
        node.type = binaryOperationResultType(CStarParser.MINUS, leftChild.type, rightChild.type);
    }

    private String binaryOperationResultType(int operator, String leftType, String rightType) {
        //Todo: handle casting
        return leftType;
    }

    private String unaryOperationResultType(int operator, String type) {
        //Todo: handle casting
        return type;
        //Skal bruges, hvis vi implementerer negation som en node (lige som i bogen)
    }
}
