package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.parser.nodes.IdNode;
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


}