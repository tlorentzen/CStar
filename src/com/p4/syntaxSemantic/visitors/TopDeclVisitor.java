package com.p4.syntaxSemantic.visitors;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.syntaxSemantic.nodes.DclNode;
import com.p4.symbols.Attributes;
import com.p4.symbols.SymbolTable;

public class TopDeclVisitor extends SemanticsVisitor {

    public TopDeclVisitor(SymbolTable symbolTable, ErrorBag errors){
        super(symbolTable, errors);
    }

    public void visit(DclNode<?> node){
        if(symbolTable.lookup(node.getId()) != null){
            errors.addEntry(ErrorType.TYPE_ERROR,"Already declared", node.lineNumber);
            symbolTable.lookup(node.getId()).setVariableType("Already declared error");
        } else {
            Attributes attr = new Attributes(node.getClass().getName(), node.type);
            symbolTable.insertSymbol(node.getId(), attr);
        }
    }
}
