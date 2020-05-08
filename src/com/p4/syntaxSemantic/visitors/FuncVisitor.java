package com.p4.syntaxSemantic.visitors;

import com.p4.errors.ErrorBag;
import com.p4.syntaxSemantic.nodes.*;
import com.p4.symbols.SymbolTable;

//Goes through the program and adds all functions declared and called to the symbol table
public class FuncVisitor implements INodeVisitor {
    SymbolTable symbolTable;
    ErrorBag errors;

    public FuncVisitor(SymbolTable symbolTable, ErrorBag errors) {
        this.symbolTable = symbolTable;
        this.errors = errors;

        //Adds the arduino function "delay()" to the symbol table
        symbolTable.declaredFunctions.add("sleep");
    }

    @Override
    public void visitChildren(AstNode node) {
        for (AstNode child : node.children) {
            child.accept(this);
        }
    }

    //Adds the called function to the list of called functions in the symbol table
    //If the function is a pin read or write, it is also added to the list of declared functions
    @Override
    public void visit(FuncCallNode node) {
        String funcId = ((IdNode)node.children.get(0)).getId();
        symbolTable.calledFunctions.add(funcId);

        //Splits the func ID to check if read or write is part of the ID
        String[] funcIDSplit = (funcId.split("\\."));

        //Enters if the func ID is a pin and adds its ID to the symbol table
        if (funcIDSplit.length > 1 && (funcIDSplit[1].equals("read") || funcIDSplit[1].equals("write"))) {
            symbolTable.declaredFunctions.add(funcId);
        }

        this.visitChildren(node);
    }

    //Adds the declared function to the list of declared functions in the symbol table
    @Override
    public void visit(FuncDclNode node) {
        symbolTable.declaredFunctions.add(node.getId());
        this.visitChildren(node);
    }

    @Override
    public void visit(IdNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(NumberNode node) {
        this.visitChildren(node);
    }

    @Override public void visit(BooleanNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(FloatNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ConstantNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(CommentNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IncludeNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IntervalNode node) {
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
    public void visit(BooleanDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(MultNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ModNode node) {
        this.visitChildren(node);
    }

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
