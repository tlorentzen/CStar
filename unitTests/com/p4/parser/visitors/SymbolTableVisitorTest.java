package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.symbols.PinAttributes;
import com.p4.symbols.SymbolTable;
import com.p4.syntaxSemantic.nodes.*;
import com.p4.syntaxSemantic.visitors.SymbolTableVisitor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class SymbolTableVisitorTest {
    private SymbolTableVisitor visitor = new SymbolTableVisitor(new SymbolTable(), new ErrorBag());

    @Test
    void visitIntegerDclNode_ReceivesStandardIntegerDcl_AddsNodeIdAsSymbolInSymbolTable(){
        //Arrange
        String id = "Id";
        IntegerDclNode Dcl = new IntegerDclNode(id);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(Dcl);
        var result = symbolTable.lookupSymbol(id) != null;

        //Assert
        assert(result);
    }

    @Test
    void visitIntegerDclNode_ReceivesNodeWithPinDclAsLeftChildAndPinNodeAsRightChild_SymbolForLeftChildHasAnalog1(){
        //Arrange
        String id = "Id";
        var leftChild = new PinDclNode(id);
        var rightChild = new PinNode(1, false);
        AssignNode assign = new AssignNode();
        assign.children.add(leftChild);
        assign.children.add(rightChild);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(assign);

        //Act
        visitor.visit(assign);
        var result = ((PinAttributes)symbolTable.lookupSymbol(((PinDclNode) leftChild).getId())).getAnalog();

        //Assert
        assert(result);
    }

    @Test
    void visitArrayDclNode_ReceivesStandardArrayDcl_AddsNodeIdAsSymbolInSymbolTable(){
        //Arrange
        String id = "Id";
        ArrayDclNode<Integer> Dcl = new ArrayDclNode<>(id);
        Dcl.children.add(new ArrayNode("array" + id, "integer"));

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(Dcl);
        var result = symbolTable.lookupSymbol(id) != null;

        //Assert
        assert(result);
    }

    @Test
    void visitArrayDclNode_ReceivesAlreadyAddedArrayDcl_GeneratesError(){
        //Arrange
        String id = "Id";
        ArrayDclNode<Integer> Dcl = new ArrayDclNode<>(id);
        Dcl.children.add(new ArrayNode("array" + id, "integer"));

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(Dcl);

        //Act
        visitor.visit(Dcl);
        var result = errorBag.isEmpty();

        //Assert
        assert(!result);
    }

    @Test
    void visitAssign_ReceivesNodeWithPinDclAsLeftChildAndIntegerNodeAsRightChild_SymbolForLeftChildHasAnalog0(){
        //Arrange
        String id = "Id";
        var leftChild = new PinDclNode(id);
        var rightChild = new NumberNode((long) 2, false);
        AssignNode assign = new AssignNode();
        assign.children.add(leftChild);
        assign.children.add(rightChild);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(assign);

        //Act
        visitor.visit(assign);
        var result = ((PinAttributes)symbolTable.lookupSymbol(((PinDclNode) leftChild).getId())).getAnalog();

        //Assert
        assert(!result);
    }

    @Test
    void visitAssign_ReceivesNodeWithIdNodeAsLeftChildAndPinNodeAsRightChild_SymbolForLeftChildHasAnalog0(){
        //Arrange
        String id = "Id";
        PinDclNode dcl = new PinDclNode(id);
        var leftChild = new IdNode(id, false);
        var rightChild = new PinNode(1, false);
        AssignNode assign = new AssignNode();
        assign.children.add(leftChild);
        assign.children.add(rightChild);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(dcl);

        //Act
        visitor.visit(assign);
        var result = ((PinAttributes)symbolTable.lookupSymbol((leftChild).getId())).getAnalog();

        //Assert
        assert(result);
    }

    @Test
    void visitFuncCall_ReceivesStandardFuncCallNode_SymbolIsNotInserted(){
        //Arrange
        var id = "ID";
        var idNode = new IdNode(id, false);
        var funcCall = new FuncCallNode(false);
        funcCall.children.add(idNode);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(funcCall);
        var result = symbolTable.lookupSymbol(id) == null;

        //Arrange
        assert(result);
    }

    @Test
    void visitFuncCall_ReceivesReadFuncCallNode_SymbolInsertedWithKindFunction(){
        //Arrange
        var id = "ID.read";
        var idNode = new IdNode(id, false);
        var funcCall = new FuncCallNode(false);
        funcCall.children.add(idNode);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(funcCall);
        var result = symbolTable.lookupSymbol(id).getKind().equals("function");

        //Arrange
        assert(result);
    }

    @Test
    void visitFuncCall_ReceivesWriteFuncCallNode_SymbolInsertedWithKindFunction(){
        //Arrange
        var id = "ID.write";
        var idNode = new IdNode(id, false);
        var funcCall = new FuncCallNode(false);
        funcCall.children.add(idNode);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(funcCall);
        var result = symbolTable.lookupSymbol(id).getKind().equals("function");

        //Arrange
        assert(result);
    }

    @Test
    void visitFuncCall_ReceivesSleepFuncCallNode_SymbolInsertedWithKindFunction(){
        //Arrange
        var id = "sleep";
        var idNode = new IdNode(id, false);
        var funcCall = new FuncCallNode(false);
        funcCall.children.add(idNode);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(funcCall);
        var result = symbolTable.lookupSymbol(id).getKind().equals("function");

        //Arrange
        assert(result);
    }

    @Test
    void visitFuncDcl_ReceivesFuncDclNode_SymbolInsertedWithKindFunction(){
        //Arrange
        var id = "ID";
        var funcDcl = new FuncDclNode();
        funcDcl.setReturnType("void");
        funcDcl.setId(id);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(funcDcl);
        var result = symbolTable.lookupSymbol(id).getKind().equals("function");

        //Arrange
        assert(result);
    }

    @Test
    void visitFuncDcl_ReceivesFuncDclNode_FunctionScopeAdded(){
        //Arrange
        var id = "ID";
        var funcDcl = new FuncDclNode();
        funcDcl.setReturnType("void");
        funcDcl.setId(id);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(funcDcl);
        var result = symbolTable.lookupScope(funcDcl.getNodeHash()) != null;

        //Arrange
        assert(result);
    }

    @Test
    void visitFuncDcl_ReceivesAlreadyDeclaredFuncDclNode_DuplicateVarsErrorAdded(){
        //Arrange
        var id = "ID";
        var funcDcl = new FuncDclNode();
        funcDcl.setReturnType("void");
        funcDcl.setId(id);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(funcDcl);

        //Act
        visitor.visit(funcDcl);
        var result = !errorBag.isEmpty();

        //Arrange
        assert(result);
    }

    @Test
    void visitIterative_ReceivesIterativeNode_IterativeScopeAdded(){
        //Arrange
        var iterativeNode = new IterativeNode();

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(iterativeNode);

        //Act
        var result = symbolTable.lookupScope(iterativeNode.getNodeHash()) != null;

        //Arrange
        assert(result);
    }

    @Test
    void visitParam_ReceivesParamNodeWithThreeChildren_AddsThreeChildrenToSymbolTable(){
        //Arrange
        var param = new ParamNode();
        var idOne = "id1";
        var idNodeOne = new IdNode(idOne, false);
        var idTwo = "id2";
        var idNodeTwo = new IdNode(idTwo, false);
        var idThree = "id1";
        var idNodeThree = new IdNode(idThree, false);
        param.children.add(idNodeOne);
        param.children.add(idNodeTwo);
        param.children.add(idNodeThree);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(param);
        var result = (symbolTable.lookupSymbol(idOne) != null && symbolTable.lookupSymbol(idTwo) != null && symbolTable.lookupSymbol(idThree) != null);

        //Assert
        assert(result);
    }

    @Test
    void visitParam_ReceivesParamNodeWithOneChild_AddsChildWithCurrentScopeToSymbolTable(){
        //Arrange
        var param = new ParamNode();
        var idOne = "id1";
        var idNodeOne = new IdNode(idOne, false);
        param.children.add(idNodeOne);

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(param);
        var result = symbolTable.lookupSymbol(idOne).getScope().equals(symbolTable.getCurrentScope().getScopeName());

        //Assert
        assert(result);
    }

    @Test
    void visitSelection_ReceivesIterativeNode_IterativeScopeAdded(){
        //Arrange
        var selectionNode = new SelectionNode();

        var symbolTable = new SymbolTable();
        var errorBag = new ErrorBag();
        visitor = new SymbolTableVisitor(symbolTable, errorBag);

        visitor.visit(selectionNode);

        //Act
        var result = symbolTable.lookupScope(selectionNode.getNodeHash()) != null;

        //Arrange
        assert(result);
    }

    @AfterEach
    void tearDown(){
        visitor = new SymbolTableVisitor(new SymbolTable(), new ErrorBag());
    }
}