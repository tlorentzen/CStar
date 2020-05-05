package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.parser.nodes.*;
import com.p4.symbols.PinAttributes;
import com.p4.symbols.SymbolTable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTableVisitorTest {
    private SymbolTableVisitor visitor = new SymbolTableVisitor(new SymbolTable(), new ErrorBag());

    @Test
    void visitBooleanDclNode_ReceivesStandardBooleanDcl_AddsNodeIdAsSymbolInSymbolTable(){
        //Arrange
        String id = "BooleanId";
        BooleanDclNode boolDcl = new BooleanDclNode(id);

        //Act
        visitor.visit(boolDcl);
        var result = visitor.symbolTable.lookup(id) != null;

        //Assert
        assertTrue(result);
    }

    @Test
    void visitBooleanDclNode_ReceivesAlreadyAddedBooleanDcl_GeneratesError(){
        //Arrange
        String id = "BooleanId";
        BooleanDclNode boolDcl = new BooleanDclNode(id);
        visitor.visit(boolDcl);

        //Act
        visitor.visit(boolDcl);
        var result = visitor.errors.isEmpty();

        //Assert
        assertFalse(result);
    }

    @Test
    void visitSmallDclNode_ReceivesStandardSmallDcl_AddsNodeIdAsSymbolInSymbolTable(){
        //Arrange
        String id = "Id";
        SmallDclNode Dcl = new SmallDclNode(id);

        //Act
        visitor.visit(Dcl);
        var result = visitor.symbolTable.lookup(id) != null;

        //Assert
        assertTrue(result);
    }

    @Test
    void visitSmallDclNode_ReceivesAlreadyAddedSmallDcl_GeneratesError(){
        //Arrange
        String id = "Id";
        SmallDclNode Dcl = new SmallDclNode(id);
        visitor.visit(Dcl);

        //Act
        visitor.visit(Dcl);
        var result = visitor.errors.isEmpty();

        //Assert
        assertFalse(result);
    }

    @Test
    void visitArrayDclNode_ReceivesStandardArrayDcl_AddsNodeIdAsSymbolInSymbolTable(){
        //Arrange
        String id = "Id";
        ArrayDclNode<Integer> Dcl = new ArrayDclNode<>(id);
        Dcl.children.add(new ArrayNode("array" + id, "integer"));

        //Act
        visitor.visit(Dcl);
        var result = visitor.symbolTable.lookup(id) != null;

        //Assert
        assertTrue(result);
    }

    @Test
    void visitArrayDclNode_ReceivesAlreadyAddedArrayDcl_GeneratesError(){
        //Arrange
        String id = "Id";
        ArrayDclNode<Integer> Dcl = new ArrayDclNode<>(id);
        Dcl.children.add(new ArrayNode("array" + id, "integer"));
        visitor.visit(Dcl);

        //Act
        visitor.visit(Dcl);
        var result = visitor.errors.isEmpty();

        //Assert
        assertFalse(result);
    }

    @Test
    void visitCharDclNode_ReceivesStandardCharDcl_AddsNodeIdAsSymbolInSymbolTable(){
        //Arrange
        String id = "Id";
        CharDclNode Dcl = new CharDclNode(id);

        //Act
        visitor.visit(Dcl);
        var result = visitor.symbolTable.lookup(id) != null;

        //Assert
        assertTrue(result);
    }

    @Test
    void visitCharDclNode_ReceivesAlreadyAddedCharDcl_GeneratesError(){
        //Arrange
        String id = "Id";
        CharDclNode Dcl = new CharDclNode(id);
        visitor.visit(Dcl);

        //Act
        visitor.visit(Dcl);
        var result = visitor.errors.isEmpty();

        //Assert
        assertFalse(result);
    }

    @Test
    void visitFloatDclNode_ReceivesStandardFloatDcl_AddsNodeIdAsSymbolInSymbolTable(){
        //Arrange
        String id = "Id";
        FloatDclNode Dcl = new FloatDclNode(id);

        //Act
        visitor.visit(Dcl);
        var result = visitor.symbolTable.lookup(id) != null;

        //Assert
        assertTrue(result);
    }

    @Test
    void visitFloatDclNode_ReceivesAlreadyAddedFloatDcl_GeneratesError(){
        //Arrange
        String id = "Id";
        FloatDclNode Dcl = new FloatDclNode(id);
        visitor.visit(Dcl);

        //Act
        visitor.visit(Dcl);
        var result = visitor.errors.isEmpty();

        //Assert
        assertFalse(result);
    }

    @Test
    void visitIntegerDclNode_ReceivesStandardIntegerDcl_AddsNodeIdAsSymbolInSymbolTable(){
        //Arrange
        String id = "Id";
        IntegerDclNode Dcl = new IntegerDclNode(id);

        //Act
        visitor.visit(Dcl);
        var result = visitor.symbolTable.lookup(id) != null;

        //Assert
        assertTrue(result);
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
        visitor.visit(assign);

        //Act
        visitor.visit(assign);
        var result = ((PinAttributes)visitor.symbolTable.lookup(((PinDclNode) leftChild).id)).analog;

        //Assert
        assertTrue(result);
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
        visitor.visit(assign);

        //Act
        visitor.visit(assign);
        var result = ((PinAttributes)visitor.symbolTable.lookup(((PinDclNode) leftChild).id)).analog;

        //Assert
        assertFalse(result);
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
        visitor.visit(dcl);

        //Act
        visitor.visit(assign);
        var result = ((PinAttributes)visitor.symbolTable.lookup((leftChild).id)).analog;

        //Assert
        assertTrue(result);
    }

    @Test
    void visitFuncCall(){
        //Arrange


    }

    @AfterEach
    void tearDown(){
        visitor = new SymbolTableVisitor(new SymbolTable(), new ErrorBag());
    }
}