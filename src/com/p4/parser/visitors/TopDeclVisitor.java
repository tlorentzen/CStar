package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.parser.nodes.DclNode;
import com.p4.symbols.Attributes;
import com.p4.symbols.SymbolTable;

public class TopDeclVisitor extends SemanticsVisitor {

    public TopDeclVisitor(SymbolTable symbolTable, ErrorBag errors){
        super(symbolTable, errors);
    }

    public void visit(DclNode<?> node){
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.TYPE_ERROR,"Already declared", node.lineNumber);
            symbolTable.lookup(node.id).variableType = "Already declared error";
        } else {
            var attr = new Attributes();
            attr.variableType = node.type;
            attr.kind = node.getClass().getName();
            symbolTable.insertSymbol(node.id, attr);
        }
    }
}
