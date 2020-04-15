package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.symbols.SymbolTable;

public class TypeVisitor extends SemanticsVisitor {

    private SymbolTable symbolTable;
    private ErrorBag errors;

    public TypeVisitor(SymbolTable symbolTable, ErrorBag errors){
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    public void visit(IdNode node){
        var attr = symbolTable.lookup(node.Id);
        if (attr != null && attr.kind.equals(node.getClass().getName())){
            attr.variableType = node.type;
        } else{
            //Todo: "identifier is not a type name" error
            errors.addEntry("E1", "Identifier is not a type name", ErrorBag.errorType.TYPE);
        }
    }

    public void visit(AssignNode node){
        if(node.children.size() != 2){
            errors.addEntry("E1", "Assign should always have two operands", ErrorBag.errorType.TYPE);
        } else{
            if(!node.children.get(0).type.equals(node.children.get(1).type)){
                //Todo: Handle type casting
                System.out.println("Casting");
            }
        }
    }
}
