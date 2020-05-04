package com.p4.syntaxSemantic.visitors;

import com.p4.errors.ErrorBag;
import com.p4.syntaxSemantic.nodes.*;
import com.p4.symbols.SymbolTable;

public class FuncVisitor implements INodeVisitor {

    SymbolTable symbolTable;
    ErrorBag errors;

    public FuncVisitor(SymbolTable symbolTable, ErrorBag errors){
        this.symbolTable = symbolTable;
        symbolTable.declaredFunctions.add("sleep");
        this.errors = errors;
    }

    @Override
    public void visitChildren(AstNode node) {
        for(AstNode child : node.children){
            child.accept(this);
        }
    }

    @Override
    public void visit(IdNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(NumberNode node) { this.visitChildren(node); }

    @Override public void visit(BooleanNode node) { this.visitChildren(node); }

    @Override
    public void visit(FloatNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ConstantNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PinNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(CharNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(AssignNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(CondNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayAccessNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayExprNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ReturnExpNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(AddNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayDclNode<?> node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(BlkNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(CharDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(DivNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(FloatDclNode node) {
        this.visitChildren(node);
    }

    /**
     * Adds the called function to the list of called functions on the symbolTable. If the function is a pin read or write, it is also added to the list of declared functions
     * @param node the funcCallNode to add to the called functions list
     */
    @Override
    public void visit(FuncCallNode node) {
        symbolTable.calledFunctions.add(((IdNode)node.children.get(0)).getId());

        String[] funcIDSplit = ((IdNode)node.children.get(0)).getId().split("\\.");

        if(funcIDSplit.length > 1 && (funcIDSplit[1].equals("read") || funcIDSplit[1].equals("write"))){
            symbolTable.declaredFunctions.add(((IdNode)node.children.get(0)).getId());
        }
        this.visitChildren(node);
    }

    /**
     * Adds the declared function to the list of declared functions on the symbolTable
     * @param node the FuncDclNode to add to the list
     */
    @Override
    public void visit(FuncDclNode node) {
        symbolTable.declaredFunctions.add(node.getId());
        this.visitChildren(node);
    }

    @Override
    public void visit(IntegerDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IterativeNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(LongDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(SmallDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(BooleanDclNode node) { this.visitChildren(node); }

    @Override
    public void visit(MultNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ModNode node) { this.visitChildren(node); }

    @Override
    public void visit(ParamNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PinDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(SelectionNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(SubNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(LogicalNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PrintNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(StringNode node) {
        this.visitChildren(node);
    }

}
