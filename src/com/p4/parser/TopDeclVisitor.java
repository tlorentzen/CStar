package com.p4.parser;

import com.p4.symbols.SymbolTable;

public class TopDeclVisitor extends SemanticsVisitor {

    private SymbolTable symbolTable;

    public TopDeclVisitor(SymbolTable symbolTable){
        this.symbolTable = symbolTable;
    }

    public void visit(DclNode<?> node){
        TypeVisitor typeVisitor = new TypeVisitor(this.symbolTable);
        node.accept(typeVisitor);
        if(symbolTable.lookup(node.id) != null){
            //Todo: Handle 'Already declared' error
            symbolTable.lookup(node.id).variableType = "Already declared error";
        } else {

        }
    }
}
