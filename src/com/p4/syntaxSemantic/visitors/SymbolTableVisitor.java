package com.p4.syntaxSemantic.visitors;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.syntaxSemantic.nodes.*;
import com.p4.symbols.Attributes;
import com.p4.symbols.FunctionAttributes;
import com.p4.symbols.PinAttributes;
import com.p4.symbols.SymbolTable;

//Visits and declares all variables and functions, as well as initializes scopes
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
    public void visit(IntegerDclNode node) {
        declareNode(node, "integer");
    }

    @Override
    public void visit(LongDclNode node) {
        declareNode(node, "long integer");
    }

    @Override
    public void visit(SmallDclNode node) {
        declareNode(node, "small integer");
    }

    @Override
    public void visit(FloatDclNode node) {
        declareNode(node, "decimal");
    }

    @Override
    public void visit(CharDclNode node) {
        declareNode(node, "character");
    }

    @Override
    public void visit(PinDclNode node) {
        if (!isDeclared(node)) {
            //Creates and adds the node to the symbol table
            PinAttributes attribute = new PinAttributes("dcl", "pin");
            attribute.setIsOutput(false);
            symbolTable.insertSymbol(node.getId(), attribute);
            node.type = attribute.getVariableType();
        }
    }

    @Override
    public void visit(BooleanDclNode node) {
        declareNode(node, "boolean");
    }

    private void declareNode(DclNode<?> node, String type) {
        //Enters if the node is not already in the symbol table
        if (!isDeclared(node)) {
            //Creates and adds the node to the symbol table
            Attributes attribute = new Attributes("dcl", type);
            symbolTable.insertSymbol(node.getId(), attribute);
            node.type = attribute.getVariableType();
        }
    }

    private boolean isDeclared(DclNode<?> node) {
        if (symbolTable.lookupSymbol(node.getId()) != null){
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Variable '" + node.getId() + "' already exists", node.lineNumber);
            node.type = symbolTable.lookupSymbol(node.getId()).getVariableType();

            return true;
        }
        return false;
    }
    
    @Override
    public void visit(AssignNode node) {
        this.visitChildren(node);

        AstNode firstChild = node.children.get(0);
        AstNode secondChild = node.children.get(1);

        //Checks if a pin is being assigned to
        if (firstChild instanceof PinDclNode) {
            String pinId = ((PinDclNode) firstChild).getId();
            PinAttributes pin = (PinAttributes)symbolTable.lookupSymbol(pinId);

            //Checks if the right hand side of the assignment is a pin
            //If it is a pin then "pin.analog" is set to "true"
            pin.setAnalog(secondChild instanceof PinNode);
        }
        //Checks if a variable is being assigned to
        else if (firstChild instanceof IdNode) {
            Attributes variable = symbolTable.lookupSymbol(((IdNode) firstChild).getId());

            //Enters if the variable is of type pin
            if (variable != null && variable.getVariableType().equals("pin")) {
                //Checks if the right hand side of the assignment is a pin
                //If it is a pin then "analog" is set to "true"
                ((PinAttributes)variable).setAnalog(secondChild instanceof PinNode);
            }
        }
    }

    @Override
    public void visit(ArrayDclNode<?> node) {
        this.visitChildren(node);
        AstNode arrayNode = node.children.get(0);

        //Enters if the node is not already in the symbol table
        if (!isDeclared(node)) {
            //Enters if the array type is pin
            if (arrayNode.type.equals("pin")) {
                PinAttributes attr = new PinAttributes("dcl", arrayNode.type);
                symbolTable.insertSymbol(node.getId(), attr);
            }
            else {
                Attributes attr = new Attributes("dcl", arrayNode.type);
                symbolTable.insertSymbol(node.getId(), attr);
            }
            node.type = arrayNode.type;
        }
    }

    @Override
    public void visit(IterativeNode node) {
        symbolTable.addScope(node.getNodeHash());
        this.visitChildren(node);
        symbolTable.leaveScope(node.getNodeHash());
    }

    @Override
    public void visit(SelectionNode node) {
        symbolTable.addScope(node.getNodeHash());
        this.visitChildren(node);
        symbolTable.leaveScope(node.getNodeHash());
    }

    @Override
    public void visit(FuncDclNode node) {
        //Enters if the function already declared in the symbol table
        if (symbolTable.lookupSymbol(node.getId()) != null) {
            errors.addEntry(ErrorType.DUPLICATE_VARS, "Function '" + node.getId() + "' already exists", node.lineNumber);
        }
        else {
            //Creates and adds the function to the symbol table
            FunctionAttributes attributes = new FunctionAttributes("function", node.getReturnType());
            symbolTable.insertSymbol(node.getId(), attributes);

            symbolTable.addScope(node.getNodeHash());
            this.visitChildren(node);
            symbolTable.leaveScope();
        }

    }

    @Override
    public void visit(ParamNode node) {
        String scopeName = symbolTable.getCurrentScope().getScopeName();

        //Adds each parameter of the function to the symbol table
        for (AstNode child : node.getChildren()) {
            IdNode param = (IdNode)child;
            Attributes attributes = new Attributes("param", param.type);
            attributes.setScope(scopeName);

            symbolTable.insertParam(param.getId(), attributes);
        }
        this.visitChildren(node);
    }

    @Override
    public void visit(FuncCallNode node) {
        String[] funcIDSplit = ((IdNode)node.children.get(0)).getId().split("\\.");
        String functionId = ((IdNode)node.children.get(0)).getId();

        //Enters if the Arduino C functions "read" or "write" are used to avoid getting errors about undeclared functions
        if (funcIDSplit.length > 1 && (funcIDSplit[1].equals("read") || funcIDSplit[1].equals("write"))) {
            Attributes attr = new Attributes("function", "integer");
            symbolTable.insertSymbol(functionId, attr);
            node.type = attr.getVariableType();
        }
        //Enters if the Arduino C function "sleep" is used to avoid getting errors about undeclared functions
        else if (functionId.equals("sleep")) {
            Attributes attr = new Attributes("function", "void");
            symbolTable.insertSymbol(functionId, attr);
            node.type = attr.getVariableType();
        }
        this.visitChildren(node);
    }

    @Override
    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(LogicalNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(CondNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(AddNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(SubNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(MultNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(DivNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ModNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayExprNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayAccessNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(BlkNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ReturnExpNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PrintNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IdNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(NumberNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(FloatNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(CharNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PinNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(BooleanNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ConstantNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(StringNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(CommentNode node) {
        this.visitChildren(node);
    }

}
