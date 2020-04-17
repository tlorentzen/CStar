package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.parser.nodes.*;
import com.p4.symbols.SymbolTable;

public class SemanticsVisitor {

    SymbolTable symbolTable;
    ErrorBag errors;

    public SemanticsVisitor(SymbolTable symbolTable, ErrorBag errors){
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    public void visitId(IdNode node){
        if(!this.symbolTable.declaredInAccessibleScope(node.id)){
            errors.addEntry("E10", node.id + " has not been declared in any accessible scope", ErrorType.TYPE_ERROR);
        }
    }

    public void visitInteger(IntegerNode node){
        node.type = "integer";
    }

    public void visitFloat(FloatNode node){
        node.type = "decimal";
    }

    public void visitPin(PinNode node){
        node.type = "pin";
    }

    public void visitLong(LongNode node){
        node.type = "long";
    }

    public void visitChar(CharNode node){
        node.type = "character";
    }

    public void visitAssign(AssignNode node){
        if(node.children.size() != 2) {
            errors.addEntry("E1", "Assign should always have two operands", ErrorType.TYPE_ERROR);
        } else{
            System.out.println(node.children.get(0));
            System.out.println(node.children.get(1));
            if(true){
                //Todo: Handle type casting
                System.out.println("Casting");
            }
        }
    }

    public void visitCond(CondNode node){
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

    public void visitProg(ProgNode node) {
        this.visitChildren(node);
    }

    public void visitChildren(AstNode node) {
        for(INode child : node.children){
            child.accept(this);
        }
    }

    public void visit(AstNode node) {
        this.visitChildren( node);
    }

    public void visitArrayAssign(ArrayAssignNode node) {
        //Todo: implement
    }

    public void visitArrayExpr(ArrayExprNode node) {
        //Todo: implement
    }

    public void visitArray(ArrayNode node) {
        //Todo: implement
    }

    public void visitReturnExpr(ReturnExpNode node) {
        //Todo: implement
    }


    //Exprs
    //Refs
}
