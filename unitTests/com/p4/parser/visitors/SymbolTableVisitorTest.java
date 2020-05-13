package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.symbols.Attributes;
import com.p4.symbols.PinAttributes;
import com.p4.symbols.SymbolTable;
import com.p4.syntaxSemantic.nodes.*;
import com.p4.syntaxSemantic.visitors.SymbolTableVisitor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class SymbolTableVisitorTest {
    private SymbolTableVisitor visitor = new SymbolTableVisitor(new SymbolTable(), new ErrorBag());

    @Test
    void visitIntegerDclNode_ReceivesStandardIntegerDcl_AddsNodeIdAsSymbolInSymbolTable() {
        //Arrange
        String id = "Id";
        IntegerDclNode Dcl = new IntegerDclNode(id);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(Dcl);
        boolean result = symbolTable.lookupSymbol(id) != null;

        //Assert
        assert(result);
    }

    @Test
    void visitIntegerDclNode_ReceivesNodeWithPinDclAsLeftChildAndPinNodeAsRightChild_SymbolForLeftChildHasAnalog1() {
        //Arrange
        String id = "Id";
        PinDclNode leftChild = new PinDclNode(id);
        PinNode rightChild = new PinNode(1, false);
        AssignNode assign = new AssignNode();
        assign.children.add(leftChild);
        assign.children.add(rightChild);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(assign);

        //Act
        visitor.visit(assign);
        boolean result = ((PinAttributes)symbolTable.lookupSymbol(((PinDclNode) leftChild).getId())).getAnalog();

        //Assert
        assert(result);
    }

    @Test
    void visitArrayDclNode_ReceivesStandardArrayDcl_AddsNodeIdAsSymbolInSymbolTable() {
        //Arrange
        String id = "Id";
        ArrayDclNode<Integer> Dcl = new ArrayDclNode<>(id);
        Dcl.children.add(new ArrayNode("array" + id, "integer"));
        ArrayExprNode arrayExpr = new ArrayExprNode();
        arrayExpr.children.add(new NumberNode((long)1, false));
        Dcl.children.add(arrayExpr);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(Dcl);
        boolean result = symbolTable.lookupSymbol(id) != null;

        //Assert
        assert(result);
    }

    @Test
    void visitArrayDclNode_ReceivesAlreadyAddedArrayDcl_GeneratesError() {
        //Arrange
        String id = "Id";
        ArrayDclNode<Integer> Dcl = new ArrayDclNode<>(id);
        Dcl.children.add(new ArrayNode("array" + id, "integer"));

        ArrayExprNode arrayExpr = new ArrayExprNode();
        arrayExpr.children.add(new NumberNode((long)1, false));
        Dcl.children.add(arrayExpr);

        SymbolTable symbolTable = new SymbolTable();
        Attributes attr = new Attributes("array", "integer", 1);
        symbolTable.insertSymbol(id, attr);
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(Dcl);
        boolean result = errorBag.isEmpty();

        //Assert
        assert(!result);
    }

    @Test
    void visitAssign_ReceivesNodeWithPinDclAsLeftChildAndIntegerNodeAsRightChild_SymbolForLeftChildHasAnalog0() {
        //Arrange
        String id = "Id";
        PinDclNode leftChild = new PinDclNode(id);
        NumberNode rightChild = new NumberNode((long) 2, false);
        AssignNode assign = new AssignNode();
        assign.children.add(leftChild);
        assign.children.add(rightChild);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(assign);

        //Act
        visitor.visit(assign);
        boolean result = ((PinAttributes)symbolTable.lookupSymbol(((PinDclNode) leftChild).getId())).getAnalog();

        //Assert
        assert(!result);
    }

    @Test
    void visitAssign_ReceivesNodeWithIdNodeAsLeftChildAndPinNodeAsRightChild_SymbolForLeftChildHasAnalog0() {
        //Arrange
        String id = "Id";
        PinDclNode dcl = new PinDclNode(id);
        IdNode leftChild = new IdNode(id, false);
        PinNode rightChild = new PinNode(1, false);
        AssignNode assign = new AssignNode();
        assign.children.add(leftChild);
        assign.children.add(rightChild);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(dcl);

        //Act
        visitor.visit(assign);
        boolean result = ((PinAttributes)symbolTable.lookupSymbol((leftChild).getId())).getAnalog();

        //Assert
        assert(result);
    }

    @Test
    void visitFuncCall_ReceivesStandardFuncCallNode_SymbolIsNotInserted() {
        //Arrange
        String id = "ID";
        IdNode idNode = new IdNode(id, false);
        FuncCallNode funcCall = new FuncCallNode(false);
        funcCall.children.add(idNode);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(funcCall);
        boolean result = symbolTable.lookupSymbol(id) == null;

        //Arrange
        assert(result);
    }

    @Test
    void visitFuncCall_ReceivesReadFuncCallNode_SymbolInsertedWithKindFunction() {
        //Arrange
        String id = "ID.read";
        IdNode idNode = new IdNode(id, false);
        FuncCallNode funcCall = new FuncCallNode(false);
        funcCall.children.add(idNode);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(funcCall);
        boolean result = symbolTable.lookupSymbol(id).getKind().equals("function");

        //Arrange
        assert(result);
    }

    @Test
    void visitFuncCall_ReceivesWriteFuncCallNode_SymbolInsertedWithKindFunction() {
        //Arrange
        String id = "ID.write";
        IdNode idNode = new IdNode(id, false);
        FuncCallNode funcCall = new FuncCallNode(false);
        funcCall.children.add(idNode);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(funcCall);
        boolean result = symbolTable.lookupSymbol(id).getKind().equals("function");

        //Arrange
        assert(result);
    }

    @Test
    void visitFuncCall_ReceivesSleepFuncCallNode_SymbolInsertedWithKindFunction() {
        //Arrange
        String id = "sleep";
        IdNode idNode = new IdNode(id, false);
        FuncCallNode funcCall = new FuncCallNode(false);
        funcCall.children.add(idNode);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(funcCall);
        boolean result = symbolTable.lookupSymbol(id).getKind().equals("function");

        //Arrange
        assert(result);
    }

    @Test
    void visitFuncDcl_ReceivesFuncDclNode_SymbolInsertedWithKindFunction() {
        //Arrange
        String id = "ID";
        FuncDclNode funcDcl = new FuncDclNode();
        funcDcl.setReturnType("void");
        funcDcl.setId(id);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(funcDcl);
        boolean result = symbolTable.lookupSymbol(id).getKind().equals("function");

        //Arrange
        assert(result);
    }

    @Test
    void visitFuncDcl_ReceivesFuncDclNode_FunctionScopeAdded() {
        //Arrange
        String id = "ID";
        FuncDclNode funcDcl = new FuncDclNode();
        funcDcl.setReturnType("void");
        funcDcl.setId(id);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(funcDcl);
        boolean result = symbolTable.lookupScope(funcDcl.getNodeHash()) != null;

        //Arrange
        assert(result);
    }

    @Test
    void visitFuncDcl_ReceivesAlreadyDeclaredFuncDclNode_DuplicateVarsErrorAdded() {
        //Arrange
        String id = "ID";
        FuncDclNode funcDcl = new FuncDclNode();
        funcDcl.setReturnType("void");
        funcDcl.setId(id);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(funcDcl);

        //Act
        visitor.visit(funcDcl);
        boolean result = !errorBag.isEmpty();

        //Arrange
        assert(result);
    }

    @Test
    void visitIterative_ReceivesIterativeNode_IterativeScopeAdded() {
        //Arrange
        IterativeNode iterativeNode = new IterativeNode();

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(iterativeNode);

        //Act
        boolean result = symbolTable.lookupScope(iterativeNode.getNodeHash()) != null;

        //Arrange
        assert(result);
    }

    @Test
    void visitParam_ReceivesParamNodeWithThreeChildren_AddsThreeChildrenToSymbolTable() {
        //Arrange
        ParamNode param = new ParamNode();
        String idOne = "id1";
        IdNode idNodeOne = new IdNode(idOne, false);
        String idTwo = "id2";
        IdNode idNodeTwo = new IdNode(idTwo, false);
        String idThree = "id1";
        IdNode idNodeThree = new IdNode(idThree, false);
        param.children.add(idNodeOne);
        param.children.add(idNodeTwo);
        param.children.add(idNodeThree);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(param);
        boolean result = (symbolTable.lookupSymbol(idOne) != null && symbolTable.lookupSymbol(idTwo) != null && symbolTable.lookupSymbol(idThree) != null);

        //Assert
        assert(result);
    }

    @Test
    void visitParam_ReceivesParamNodeWithOneChild_AddsChildWithCurrentScopeToSymbolTable() {
        //Arrange
        ParamNode param = new ParamNode();
        String id1 = "id1";
        IdNode idNode1 = new IdNode(id1, false);
        param.children.add(idNode1);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(param);
        boolean result = symbolTable.lookupSymbol(id1).getScope().equals(symbolTable.getCurrentScope().getScopeName());

        //Assert
        assert(result);
    }

    @Test
    void visitSelection_ReceivesIterativeNode_IterativeScopeAdded() {
        //Arrange
        SelectionNode selectionNode = new SelectionNode();

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(selectionNode);

        //Act
        boolean result = symbolTable.lookupScope(selectionNode.getNodeHash()) != null;

        //Arrange
        assert(result);
    }

    @AfterEach
    void tearDown() {
        visitor = new SymbolTableVisitor(new SymbolTable(), new ErrorBag());
    }
}