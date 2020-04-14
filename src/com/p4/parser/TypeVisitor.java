package com.p4.parser;

import com.p4.symbols.SymbolTable;

public class TypeVisitor extends SemanticsVisitor {

    private SymbolTable symbolTable;

    public TypeVisitor(SymbolTable symbolTable){
        this.symbolTable = symbolTable;
    }

    public void visit(IdNode node){
        var attr = symbolTable.lookup(node.Id);
        if (attr != null && attr.kind.equals(node.getClass().getName())){
            attr.variableType = node.type;
        } else{
            //Todo: "identifier is not a type name" error
        }
    }
}
