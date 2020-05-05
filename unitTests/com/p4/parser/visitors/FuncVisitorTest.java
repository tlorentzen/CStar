package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.parser.nodes.FuncCallNode;
import com.p4.parser.nodes.FuncDclNode;
import com.p4.parser.nodes.IdNode;
import com.p4.symbols.SymbolTable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class FuncVisitorTest {

    private FuncVisitor visitor = new FuncVisitor(new SymbolTable(), new ErrorBag());

    @BeforeAll
    static void beforeAll() {

    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void visitFuncCall_ReceivesAStandardFuncCallNode_AddsTheFuncIdToCalledFunctionsButNotDeclaredFunctions() {
        //Arrange
        FuncCallNode funcCall = new FuncCallNode(false);
        funcCall.children = new ArrayList<>();
        IdNode idNode = new IdNode("FuncId", false);
        funcCall.children.add(idNode);
        String id = ((IdNode)funcCall.children.get(0)).id;

        //Act
        visitor.visit(funcCall);
        var result = visitor.symbolTable.calledFunctions.contains(id) && !visitor.symbolTable.declaredFunctions.contains(id);

        //Assert
        assert (result);
    }

    @Test
    void visitFuncCall_ReceivesAReadFuncCallNode_AddsTheFuncIdToCalledFunctionsAndDeclaredFunctions() {
        //Arrange
        FuncCallNode funcCall = new FuncCallNode(false);
        funcCall.children = new ArrayList<>();
        IdNode idNode = new IdNode("FuncId.read", false);
        funcCall.children.add(idNode);
        String id = ((IdNode)funcCall.children.get(0)).id;

        //Act
        visitor.visit(funcCall);
        var result = visitor.symbolTable.calledFunctions.contains(id) && visitor.symbolTable.declaredFunctions.contains(id);

        //Assert
        assert (result);
    }

    @Test
    void visitFuncCall_ReceivesAWriteFuncCallNode_AddsTheFuncIdToCalledFunctionsAndDeclaredFunctions() {
        //Arrange
        FuncCallNode funcCall = new FuncCallNode(false);
        funcCall.children = new ArrayList<>();
        IdNode idNode = new IdNode("FuncId.write", false);
        funcCall.children.add(idNode);
        String id = ((IdNode)funcCall.children.get(0)).id;

        //Act
        visitor.visit(funcCall);
        var result = visitor.symbolTable.calledFunctions.contains(id) && visitor.symbolTable.declaredFunctions.contains(id);

        //Assert
        assert (result);
    }

    @Test
    void visitFuncDcl_ReceivesAFuncDclNode_AddsTheFuncIdToDeclaredFunctions() {
        //Arrange
        FuncDclNode funcDcl = new FuncDclNode();
        funcDcl.children = new ArrayList<>();
        funcDcl.id = "FuncId";

        //Act
        visitor.visit(funcDcl);
        var result = visitor.symbolTable.declaredFunctions.contains(funcDcl.id);

        //Assert
        assert (result);
    }

    @AfterEach
    void tearDown(){
        visitor = new FuncVisitor(new SymbolTable(), new ErrorBag());
    }
}