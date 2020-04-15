package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.symbols.SymbolTable;

public class TypeVisitor extends SemanticsVisitor {

    public TypeVisitor(SymbolTable symbolTable, ErrorBag errors){
        super(symbolTable, errors);
    }

    @Override
    public void visit(AstNode node) {

    }

    public void visit(IdNode node){
        var attr = symbolTable.lookup(node.id);
        if (attr != null && attr.kind.equals(node.getClass().getName())){
            attr.variableType = node.type;
        } else{
            //Todo: "identifier is not a type name" error
            errors.addEntry("E1", "Identifier is not a type name", ErrorType.TYPE_ERROR);
        }
    }

    public void visit(AssignNode node){
        if(node.children.size() != 2){
            errors.addEntry("E1", "Assign should always have two operands", ErrorType.TYPE_ERROR);
        } else{
            System.out.println(node.children.get(0).type);
            System.out.println(node.children.get(1).type);
            if(!node.children.get(0).type.equals(node.children.get(1).type)){
                //Todo: Handle type casting
                System.out.println("Casting");
            }
        }
    }
}
