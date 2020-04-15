package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.symbols.Attributes;
import com.p4.symbols.SymbolTable;

public class TopDeclVisitor extends SemanticsVisitor {

    private SymbolTable symbolTable;
    private ErrorBag errors;

    public TopDeclVisitor(SymbolTable symbolTable, ErrorBag errors){
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    public void visit(DclNode<?> node){
        TypeVisitor typeVisitor = new TypeVisitor(this.symbolTable, this.errors);
        node.accept(typeVisitor);
        if(symbolTable.lookup(node.id) != null){
            //Todo: Handle 'Already declared' error
            symbolTable.lookup(node.id).variableType = "Already declared error";
        } else {
            var attr = new Attributes();
            attr.variableType = node.type;
            attr.kind = node.getClass().getName();

            symbolTable.insert(node.id, attr);
        }
    }
}
