package com.p4.parser;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.parser.nodes.*;
import com.p4.symbols.Attributes;
import com.p4.symbols.CStarScope;
import com.p4.symbols.FunctionAttributes;
import com.p4.symbols.SymbolTable;

import java.util.ArrayList;

public class SymbolTableVisitor implements INodeVisitor {

    SymbolTable symbolTable;
    ErrorBag errors;

    public SymbolTableVisitor(SymbolTable symbolTable, ErrorBag errors){
        this.symbolTable = symbolTable;
        this.errors = errors;
    }

    @Override
    public void visitChildren(AstNode node) {
        for(AstNode child : node.children){
            child.accept(this);
        }
    }

    @Override
    public void visit(IdNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IntegerNode node) {
        node.type = "integer";
    }

    @Override
    public void visit(FloatNode node) {
        node.type = "decimal";
    }

    @Override
    public void visit(PinNode node) {
        node.type = "pin";
    }

    @Override
    public void visit(LongNode node) {
        node.type = "long integer";
    }

    @Override
    public void visit(CharNode node) {
        node.type = "character";
    }

    @Override
    public void visit(AssignNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(CondNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayAccessNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayExprNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ReturnExpNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(AddNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayDclNode<?> node) {
        this.visitChildren(node);
        var arrayNode = node.children.get(0);
        var arrayExprNode = node.children.get(1);
        castArrayElements((ArrayExprNode) arrayExprNode, arrayNode.type);

        if(!arrayNode.type.equals(arrayExprNode.type)){
            //Todo: float, char, and int should be decimal, character, and integer
            //Todo: handle integer array being assigned to decimal array
            errors.addEntry(ErrorType.TYPE_ERROR,  arrayExprNode.type.substring(0, 1).toUpperCase() + arrayExprNode.type.substring(1) + " array assigned to " + arrayNode.type + " array", node.lineNumber);
        }

        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = arrayNode.type;
            attr.kind = "dcl";
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
        }
    }
    private void castArrayElements(ArrayExprNode node, String type){
        node.type = type;
        boolean nodeTypeChecked = false;
        while(!nodeTypeChecked){
            nodeTypeChecked = true;
            for(AstNode child : node.children){
                if(!child.type.equals(node.type)){
                    String dominantType = this.dominantTypeOfArrayElements(child.type, node.type);
                    if(node.type.equals(dominantType)){
                        child.type = node.type;
                    } else{
                        node.type = dominantType;
                        nodeTypeChecked = false;
                        break;
                    }
                }
            }
        }
    }
    private String dominantTypeOfArrayElements(String leftType, String rightType) {
        if (leftType == null || rightType == null){
            return "error";
        }

        if(leftType.equals("decimal") || rightType.equals("decimal")){
            return "decimal";
        } else if(leftType.equals("pin") || rightType.equals("pin")){
            return "pin";
        } else if(leftType.equals("long integer") || rightType.equals("long integer")){
            return "long integer";
        } else if(leftType.equals("integer") || rightType.equals("integer")){
            return "integer";
        } else if(leftType.equals("char") || rightType.equals("char")){
            return "character";
        } else {
            //Should never occur
            return "error";
        }
    }

    @Override
    public void visit(BlkNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(CharDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        }else {
            Attributes attr = new Attributes();
            attr.variableType = "character";
            attr.kind = "dcl";
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
        }
    }

    @Override
    public void visit(DivNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(FloatDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = "decimal";
            attr.kind = "dcl";
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
        }
    }

    @Override
    public void visit(FuncCallNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(FuncNode node) {
        FunctionAttributes attributes = new FunctionAttributes();
        attributes.kind = "function";
        attributes.variableType = node.returnType;

        symbolTable.insert(node.id, attributes);
        symbolTable.addScope("FuncNode-" + node.id);

        this.visitChildren(node);

        symbolTable.leaveScope();
    }

    @Override
    public void visit(IntegerDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = "integer";
            attr.kind = "dcl";
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
        }
    }

    @Override
    public void visit(IterativeNode node) {
        symbolTable.addScope("IterativeNode-"+System.currentTimeMillis()); //Todo: handle different more unique way
        this.visitChildren(node);
        symbolTable.leaveScope();
    }

    @Override
    public void visit(LongDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = "long integer";
            attr.kind = "dcl";
            symbolTable.insert(node.id, attr);
            node.type = attr.variableType;
        }
    }

    @Override
    public void visit(MultNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ParamNode node) {
        ArrayList<String> params = new ArrayList<>();
        CStarScope currentScope = symbolTable.getCurrentScope();
        //finds the name of the function (the scope is called funcNode-NAME)
        String scopeName = currentScope.getScopeName().split("-", 2)[1];

        for(AstNode child : node.getChildren()){
            IdNode param = (IdNode)child;

            Attributes attributes = new Attributes();
            attributes.variableType = param.type;
            attributes.kind = "param";
            attributes.scope = currentScope.getScopeName();

            symbolTable.insert(param.id, attributes);
            params.add(param.type);
        }

        FunctionAttributes functionAttributes = (FunctionAttributes)symbolTable.lookup(scopeName);
        functionAttributes.parameters = params;

        this.visitChildren(node);
    }

    @Override
    public void visit(PinDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(SelectionNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(StmtNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(SubNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(LogicalNode node) {
        this.visitChildren(node);
    }
}
