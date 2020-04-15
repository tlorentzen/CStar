package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.symbols.Attributes;
import com.p4.symbols.SymbolTable;

public class SemanticsVisitor extends NodeVisitor {

    SymbolTable symbolTable;
    ErrorBag errors;

    public SemanticsVisitor(SymbolTable symbolTable, ErrorBag errors){
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    public void visit(IdNode node){
        if(!this.symbolTable.declaredInAccessibleScope(node.id)){
            errors.addEntry("E10", node.id + " has not been declared in any accessible scope", ErrorType.TYPE_ERROR);
        }
    }

    public void visit(IntegerNode node){
        node.type = "integer";
    }

    public void visit(FloatNode node){
        node.type = "decimal";
    }

    public void visit(PinNode node){
        node.type = "pin";
    }

    public void visit(LongNode node){
        node.type = "long";
    }

    public void visit(CharNode node){
        node.type = "character";
    }

    public void visit(AssignNode node){
        if(node.children.size() != 2) {
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

    public void visit(CondNode node){
        if(node.children.size() == 2){
            System.out.println(node.children.get(0).type);
            System.out.println(node.children.get(1).type);
            if(!node.children.get(0).type.equals(node.children.get(1).type)){
                //Todo: Handle type casting
                System.out.println("Casting");
            }
        } else{

        }
    }

    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    //Exprs
    //Refs
}
