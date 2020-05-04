package com.p4.syntaxSemantic.visitors;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.syntaxSemantic.nodes.IdNode;
import com.p4.symbols.SymbolTable;

public class TypeVisitor extends SemanticsVisitor {

    public TypeVisitor(SymbolTable symbolTable, ErrorBag errors){
        super(symbolTable, errors);
    }

    public void visit(IdNode node){
        var attr = symbolTable.lookup(node.getId());
        if (attr != null && attr.kind.equals(node.getClass().getName())){
            attr.variableType = node.type;
        } else{
            errors.addEntry(ErrorType.TYPE_ERROR, "Identifier is not a type name", node.lineNumber);
        }
    }
}
