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

    public void visit(IdNode node){
        System.out.println("Visit");
        if(!this.symbolTable.declaredInAccessibleScope(node.id)){
            errors.addEntry("E10", node.id + " has not been declared in any accessible scope", ErrorType.TYPE_ERROR, node.lineNumber);
        } else{
            node.type = symbolTable.lookup(node.id).variableType;
            System.out.println(node.type);
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
            var leftChild = node.children.get(0);
            var rightChild = node.children.get(1);
            System.out.println(leftChild);
            System.out.println(rightChild);
            leftChild.accept(this);
            rightChild.accept(this);
            System.out.println(leftChild.type);
            System.out.println(rightChild.type);
            if(!node.children.get(0).type.equals(node.children.get(1).type)){
                //Todo: Handle type casting
                System.out.println("Casting");
            } else{
                System.out.println("Not casting");
            }
        }
    }

    public void visit(CondNode node){
        if(node.children.size() == 2){
            System.out.println(node.children.get(0).type);
            System.out.println(node.children.get(1).type);
            if(!node.children.get(0).type.equals(node.children.get(1).type)){
                //Todo: Handle type casting
                System.out.println("Casting");
            }
        } else{

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
        node.type = binaryOperationResultType('+', leftChild.type, rightChild.type);
    }

    public void visit(ArrayDclNode<?> node) {
        //Todo: implement

    }

    public void visit(BlkNode node) {
        symbolTable.addScope("blkNode-"+System.currentTimeMillis());

        // TODO: Stuff...

        symbolTable.leaveScope();
    }

    public void visit(CharDclNode node) {
        Attributes attr = new Attributes();
        attr.variableType = "char";
        attr.kind = node.getType();
        symbolTable.insert(node.id, attr);
    }

    public void visit(DivNode node) {
        //Todo: implement
    }

    public void visit(FloatDclNode node) {
        Attributes attr = new Attributes();
        attr.variableType = "decimal";
        attr.kind = node.getType();
        symbolTable.insert(node.id, attr);
    }

    public void visit(FuncCallNode node) {
        //Todo: implement
    }

    public void visit(FuncNode node) {
        //Todo: implement
    }

    public void visit(IntegerDclNode node) {
        Attributes attr = new Attributes();
        attr.variableType = "integer";
        attr.kind = node.getType();
        symbolTable.insert(node.id, attr);
    }

    public void visit(IterativeNode iterativeNode) {
        //Todo: implement
    }

    public void visit(LongDclNode longDclNode) {
        Attributes attr = new Attributes();
        attr.variableType = "long";
        attr.kind = longDclNode.getType();
        symbolTable.insert(longDclNode.id, attr);
    }

    public void visit(MultNode multNode) {
        //Todo: implement
    }

    public void visit(ParamNode paramNode) {
        //Todo: implement
    }

    public void visit(PinDclNode pinDclNode) {
        Attributes attr = new Attributes();
        attr.variableType = "pin";
        attr.kind = pinDclNode.getType();
        symbolTable.insert(pinDclNode.id, attr);
    }

    public void visit(SelectionNode selectionNode) {
        //Todo: implement
    }

    public void visit(StmtNode stmtNode) {
        //Todo: implement
    }

    public void visit(SubNode subNode) {
        //Todo: implement
    }

    private String binaryOperationResultType(char operator, String leftChild, String rightChild) {
        return "";
    }
}
