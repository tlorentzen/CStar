package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.parser.nodes.*;
import com.p4.symbols.Attributes;
import com.p4.symbols.FunctionAttributes;
import com.p4.symbols.PinAttributes;
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
    public void visit(PrintNode node) { this.visitChildren(node); }

    @Override
    public void visit(ModNode node) { this.visitChildren(node); }

    @Override
    public void visit(FloatNode node) { this.visitChildren(node); }

    @Override
    public void visit(ConstantNode node) { this.visitChildren(node); }

    @Override
    public void visit(CommentNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(BooleanNode node) { this.visitChildren(node); }

    @Override
    public void visit(NumberNode node) { this.visitChildren(node); }

    /**
     * Adds the declared boolean to the symbol table for future referencing
     * @param node the BooleanDclNode to add to the symbolTable
     */
    @Override
    public void visit(BooleanDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        }else {
            Attributes attr = new Attributes();
            attr.variableType = "boolean";
            attr.kind = "dcl";
            symbolTable.insertSymbol(node.id, attr);
            node.type = attr.variableType;
        }
    }

    /**
     * Adds the declared small integer to the symbol table for future referencing
     * @param node the SmallDclNode to add to the symbolTable
     */
    @Override
    public void visit(SmallDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        }else {
            Attributes attr = new Attributes();
            attr.variableType = "small integer";
            attr.kind = "dcl";
            symbolTable.insertSymbol(node.id, attr);
            node.type = attr.variableType;
        }
    }

    @Override
    public void visit(StringNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IdNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PinNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(CharNode node) {
        this.visitChildren(node);
    }

    /**
     * If the assignment is to a pin, whether the pin is analog or digital is set
     * @param node the assignNode to handle
     */
    @Override
    public void visit(AssignNode node) {
        this.visitChildren(node);
        AstNode firstChild = node.children.get(0);
        AstNode secondChild = node.children.get(1);
        if(firstChild instanceof PinDclNode){
            ((PinAttributes)symbolTable.lookup(((PinDclNode) firstChild).id)).analog = secondChild instanceof PinNode;
        } else if(firstChild instanceof IdNode && firstChild.type != null && firstChild.type.equals("pin")){
            ((PinAttributes)symbolTable.lookup(((IdNode) firstChild).id)).analog = secondChild instanceof PinNode;
        }
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

    /**
     * Adds the declared array to the symbol table for future referencing
     * @param node the ArrayDclNode to add to the symbolTable
     */
    @Override
    public void visit(ArrayDclNode<?> node) {
        this.visitChildren(node);
        var arrayNode = node.children.get(0);

        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            if(arrayNode.type.equals("pin")){
                PinAttributes attr = new PinAttributes();
                attr.variableType = arrayNode.type;
                attr.kind = "dcl";
                symbolTable.insertSymbol(node.id, attr);
            }else{
                Attributes attr = new Attributes();
                attr.variableType = arrayNode.type;
                attr.kind = "dcl";
                symbolTable.insertSymbol(node.id, attr);
            }
            node.type = arrayNode.type;
        }
    }

    @Override
    public void visit(BlkNode node) {
        this.visitChildren(node);
    }

    /**
     * Adds the declared character to the symbol table for future referencing
     * @param node the CharDclNode to add to the symbolTable
     */
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

    /**
     * Adds the declared decimal/float to the symbol table for future referencing
     * @param node the FloatDclNode to add to the symbolTable
     */
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

    /**
     * Adds the called function to the symbol table only if it is a pin read or write. This is to avoid getting errors about undeclared function of this type
     * @param node the FuncCallNode to add to the symbolTable
     */
    @Override
    public void visit(FuncCallNode node) {
        String[] funcIDSplit = ((IdNode)node.children.get(0)).id.split("\\.");

        if(funcIDSplit.length > 1 && (funcIDSplit[1].equals("read") || funcIDSplit[1].equals("write"))){
            Attributes attr = new Attributes();
            attr.variableType = "integer";
            attr.kind = "function";
            symbolTable.insertSymbol(((IdNode)node.children.get(0)).id, attr);
            node.type = attr.variableType;
        }
        if(((IdNode)node.children.get(0)).id.equals("sleep")){
            Attributes attr = new Attributes();
            attr.variableType = "void";
            attr.kind = "function";
            symbolTable.insertSymbol(((IdNode)node.children.get(0)).id, attr);
            node.type = attr.variableType;
        }
        this.visitChildren(node);
    }

    /**
     * Adds the declared function to the symbol table for future referencing
     * @param node the FuncDclNode to add to the symbolTable
     */
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

    /**
     * Adds the declared integer to the symbol table for future referencing
     * @param node the IntDclNode to add to the symbolTable
     */
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

    /**
     * Adds the scope of the iteration, visit the children of the node, hence adding them to this scope, and then leaves it again. character to the symbol table for future referencing
     * @param node the IterativeNode that demands the new scope
     */
    @Override
    public void visit(IterativeNode node) {
        symbolTable.addScope(node.getNodeHash());
        this.visitChildren(node);
        symbolTable.leaveScope(node.getNodeHash());
    }

    /**
     * Adds the declared long integer to the symbol table for future referencing
     * @param node the LongDclNode to add to the symbolTable
     */
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

    /**
     * Adds the ids of the parameter to the symbol table for future referencing
     * @param node the ParamNode containing the ids to add to the symbolTable
     */
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

    /**
     * Adds the declared pin to the symbol table for future referencing
     * @param node the PinDclNode to add to the symbolTable
     */
    @Override
    public void visit(PinDclNode node) {
        if(symbolTable.lookup(node.id) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookup(node.id).variableType;
        } else {
            PinAttributes attr = new PinAttributes();
            attr.variableType = "pin";
            attr.kind = "dcl";
            symbolTable.insertSymbol(node.id, attr);
            node.type = attr.variableType;
        }
    }

    /**
     * Adds the scope of the selection, visit the children of the node, hence adding them to this scope, and then leaves it again. character to the symbol table for future referencing
     * @param node the IterativeNode that demands the new scope
     */
    @Override
    public void visit(SelectionNode node) {
        symbolTable.addScope(node.getNodeHash());
        this.visitChildren(node);
        symbolTable.leaveScope(node.getNodeHash());
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
