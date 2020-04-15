package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.symbols.SymbolTable;

public class SemanticsVisitor extends NodeVisitor {

    SymbolTable symbolTable;
    ErrorBag errors;

    public SemanticsVisitor(SymbolTable symbolTable, ErrorBag errors){
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    public void visit(IdNode node){
        if(this.symbolTable.lookup(node.id) == null){
            errors.addEntry("E10", node.id + " has not been declared", ErrorType.TYPE_ERROR);
        }
    }

    @Override
    void visit(AstNode node) {

    }
}
