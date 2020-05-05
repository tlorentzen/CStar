package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.parser.nodes.IdNode;
import com.p4.parser.nodes.NumberNode;
import com.p4.symbols.Attributes;
import com.p4.symbols.SymbolTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SemanticsVisitorTest {
    private SemanticsVisitor visitor = new SemanticsVisitor(new SymbolTable(), new ErrorBag());

    @BeforeEach
    void setup(){
        visitor = new SemanticsVisitor(new SymbolTable(), new ErrorBag());
    }

    @Test
    void visitId_ReceivesDeclaredId_SetsTypeToTypeOfAttribute(){
        //Arrange
        var id = "id";
        var idNode = new IdNode(id, false);
        var attr = new Attributes();
        attr.variableType = "type";
        visitor.symbolTable.insertSymbol(id, attr);

        //Act
        visitor.visit(idNode);
        var result = idNode.type.equals("type");

        //Assert
        assert(result);
    }

    @Test
    void visitId_ReceivesIdNotDeclaredButCalled_SetsTypeToArduinoC(){
        //Arrange
        var id = "id";
        var idNode = new IdNode(id, false);
        visitor.symbolTable.calledFunctions.add(id);

        //Act
        visitor.visit(idNode);
        var result = idNode.type.equals("ArduinoC");

        //Assert
        assert(result);
    }

    @Test
    void visitId_ReceivesIdNotDeclared_SetsTypeToNotDeclared(){
        //Arrange
        var id = "id";
        var idNode = new IdNode(id, false);

        //Act
        visitor.visit(idNode);
        var result = idNode.type.equals("Not declared");

        //Assert
        assert(result);
    }

    @Test
    void visitNumber_ReceivesNumberOfSizeBiggerThanLong_AddsTypeErrorToErrors(){
        //Arrange
        var number = new NumberNode(Long.MAX_VALUE + 1, false);

        //Act
        visitor.visit(number);
        var result = !visitor.errors.isEmpty();

        //Assert
        assert(result);
    }

    @Test
    void visitNumber_ReceivesNumberOfSmallIntegerSize_SetsNodeTypeToSmallInteger(){
        //Arrange
        var number = new NumberNode((long)1, false);

        //Act
        visitor.visit(number);
        var result = number.type.equals("small integer");

        //Assert
        assert(result);
    }

    @Test
    void visitNumber_ReceivesNumberOfIntegerSize_SetsNodeTypeToInteger(){
        //Arrange
        var number = new NumberNode((long) Integer.MAX_VALUE - 1, false);

        //Act
        visitor.visit(number);
        var result = number.type.equals("integer");

        //Assert
        assert(result);
    }

    @Test
    void visitNumber_ReceivesNumberOfLongIntegerSize_SetsNodeTypeToLongInteger(){
        //Arrange
        var number = new NumberNode(Long.MAX_VALUE-1, false);

        //Act
        visitor.visit(number);
        var result = number.type.equals("long integer");

        //Assert
        assert(result);
    }
}