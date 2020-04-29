package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.parser.nodes.*;
import com.p4.symbols.Attributes;
import com.p4.symbols.FunctionAttributes;
import com.p4.symbols.SymbolTable;

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
        symbolTable.outputSymbolTable(symbolTable.lookupScope("global"));
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

        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = arrayNode.type;
            attr.kind = "dcl";
            symbolTable.insertSymbol(node.id, attr);
            node.type = attr.variableType;
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
            symbolTable.insertSymbol(node.id, attr);
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
            symbolTable.insertSymbol(node.id, attr);
            node.type = attr.variableType;
        }
    }

    @Override
    public void visit(FuncCallNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(FuncDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Function '" + node.getId() + "' already exists", node.lineNumber);
        } else{
            FunctionAttributes attributes = new FunctionAttributes();
            attributes.kind = "function";
            attributes.variableType = node.returnType;

            symbolTable.insertSymbol(node.id, attributes);
            symbolTable.addScope(node.getNodeHash());

            this.visitChildren(node);

            symbolTable.leaveScope();
        }

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
            symbolTable.insertSymbol(node.id, attr);
            node.type = attr.variableType;
        }
    }

    @Override
    public void visit(IterativeNode node) {
        symbolTable.addScope(node.getNodeHash());
        this.visitChildren(node);
        symbolTable.leaveScope(node.getNodeHash());
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
            symbolTable.insertSymbol(node.id, attr);
            node.type = attr.variableType;
        }
    }

    @Override
    public void visit(MultNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ParamNode node) {
        String scopeName = symbolTable.getCurrentScope().getScopeName();

        for(AstNode child : node.getChildren()){
            IdNode param = (IdNode)child;

            Attributes attributes = new Attributes();
            attributes.variableType = param.type;
            attributes.scope = scopeName;

            symbolTable.insertParam(param.id, attributes);
        }
        this.visitChildren(node);
    }

    @Override
    public void visit(PinDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            Attributes attr = new Attributes();
            attr.variableType = "pin";
            attr.kind = "dcl";
            symbolTable.insertSymbol(node.id, attr);
            node.type = attr.variableType;
        }
    }

    @Override
    public void visit(SelectionNode node) {
        symbolTable.addScope(node.getNodeHash());
        this.visitChildren(node);
        symbolTable.leaveScope(node.getNodeHash());
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
