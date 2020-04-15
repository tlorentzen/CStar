package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.symbols.Attributes;
import com.p4.symbols.SymbolTable;

public class TopDeclVisitor extends SemanticsVisitor {

    private SymbolTable symbolTable;
    private ErrorBag errors;

    public TopDeclVisitor(SymbolTable symbolTable, ErrorBag errors){
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    @Override
    public void visitChildren(AstNode node) {
        for(AstNode child : node.children){
            child.accept(this);
        }
    }

    @Override
    public void visit(AstNode node) {
        if(node instanceof ProgNode){
            this.visit((ProgNode) node);
        } else if(node instanceof AssignNode){
            this.visit((AssignNode) node);
        } else if(node instanceof DclNode<?>){
            this.visit((DclNode<?>) node);
        } else {
            //TODO: error
            System.out.println("Not a good type");
        }
    }

    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    public void visit(AssignNode node) {
        TypeVisitor typeVisitor = new TypeVisitor(this.symbolTable, this.errors);
        node.accept(typeVisitor);
        this.visitChildren(node);
    }

    public void visit(DclNode<?> node){
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry("E2","Already declared", ErrorType.TYPE_ERROR);
            symbolTable.lookup(node.id).variableType = "Already declared error";
        } else {
            var attr = new Attributes();
            attr.variableType = node.type;

            attr.kind = node.getClass().getName();
            symbolTable.insert(node.id, attr);
        }
    }
}
