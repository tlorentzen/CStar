package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.parser.CStarParser;
import com.p4.parser.nodes.*;
import com.p4.symbols.Attributes;
import com.p4.symbols.SymbolTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void visitAssign_ReceivesAssignWithFuncCallAsSecondChildOfTypeArduinoC_SetsTheTypeToTheTypeOfLeftChild(){
        //Arrange
        var assign = new AssignNode();

        var id = "id";
        var funcCallId = new IdNode("func" + id, false);
        funcCallId.type = "ArduinoC";

        var rightChild = new FuncCallNode(false);
        rightChild.children.add(funcCallId);

        var leftChild = new IdNode(id, false);
        var attr = new Attributes();
        attr.variableType = "integer";
        visitor.symbolTable.insertSymbol(id, attr);
        visitor.symbolTable.declaredFunctions.add("func" + id);

        assign.children.add(leftChild);
        assign.children.add(rightChild);

        //Act
        visitor.visit(assign);
        var result = assign.type.equals("integer");

        //Assert
        assert(result);
    }

    @Test
    void visitAssign_ReceivesIntegerAndFloat_SetsTheTypeToFloat(){
        //Arrange
        var assign = new AssignNode();

        var id = "id";
        var leftChild = new IdNode(id, false);
        leftChild.type = "decimal";
        var attr = new Attributes();
        attr.kind = "dcl";
        attr.variableType = "decimal";
        visitor.symbolTable.insertSymbol(id, attr);

        var rightChild = new NumberNode((long)1, false);
        rightChild.type = "integer";

        assign.children.add(leftChild);
        assign.children.add(rightChild);

        //Act
        visitor.visit(assign);
        var result = assign.type.equals("decimal");

        //Assert
        assert(result);
    }

    @Test
    void visitLogical_ReceivesLogicalWithTwoBooleanChildren_SetsTypeToBoolean(){
        //Arrange
        var logical = new LogicalNode();
        var child1 = new BooleanNode(true, false);
        var child2 = new BooleanNode(true, false);
        logical.children.add(child1);
        logical.children.add(child2);

        //Act
        visitor.visit(logical);
        var result = logical.type.equals("boolean");

        //Assert
        assert(result);
    }

    @Test
    void visitLogical_ReceivesLogicalWithOneBooleanAndOneSmallIntegerChild_AddsTypeErrorToErrors(){
        //Arrange
        var logical = new LogicalNode();
        var child1 = new BooleanNode(true, false);
        var child2 = new NumberNode((long) 2, false);
        logical.children.add(child1);
        logical.children.add(child2);

        //Act
        visitor.visit(logical);
        var result = !visitor.errors.isEmpty();

        //Assert
        assert(result);
    }

    @Test
    void visitCond_ReceivesLogicalWithTwoBooleanChildren_SetsTypeToBoolean(){
        //Arrange
        var cond = new CondNode();
        var child1 = new BooleanNode(true, false);
        var child2 = new BooleanNode(false, false);
        cond.setOperator(CStarParser.IS);
        cond.children.add(child1);
        cond.children.add(child2);

        //Act
        visitor.visit(cond);
        var result = cond.type.equals("boolean");

        //Assert
        assert(result);
    }

    @Test
    void visitCond_ReceivesLogicalWithTwoSmallIntegerChildren_SetsTypeToBoolean(){
        //Arrange
        var cond = new CondNode();
        var child1 = new NumberNode((long)1, false);
        var child2 = new NumberNode((long)2, false);
        cond.setOperator(CStarParser.LESS_THAN);
        cond.children.add(child1);
        cond.children.add(child2);

        //Act
        visitor.visit(cond);
        var result = cond.type.equals("boolean");

        //Assert
        assert(result);
    }

    @Test
    void visitCond_ReceivesLogicalWithTwoDifferentChildren_AddsError(){
        //Arrange
        var cond = new CondNode();
        var child1 = new NumberNode((long)1, false);
        var child2 = new BooleanNode(false, false);
        cond.setOperator(CStarParser.LESS_THAN);
        cond.children.add(child1);
        cond.children.add(child2);

        //Act
        visitor.visit(cond);
        var result = !visitor.errors.isEmpty();

        //Assert
        assert(result);
    }

    @Test
    void visitArrayAccess_ReceivesAccessNodeWithIdAndIndex_SetsTypeToIdType(){
        //Arrange
        var access = new ArrayAccessNode(false);
        String id = "id";
        var idNode = new IdNode(id, false);
        var attr = new Attributes();
        attr.variableType = "integer";
        visitor.symbolTable.insertSymbol(id, attr);
        var indexNode = new NumberNode((long) 1, false);

        access.children.add(idNode);
        access.children.add(indexNode);

        //Act
        visitor.visit(access);
        var result = access.type.equals("integer");

        //Assert
        assert(result);
    }

    @Test
    void visitArrayAccess_ReceivesAccessNodeWithDecimalIndex_AddsErrorToErrors(){
        //Arrange
        var access = new ArrayAccessNode(false);
        String id = "id";
        var idNode = new IdNode(id, false);
        var attr = new Attributes();
        attr.variableType = "integer";
        visitor.symbolTable.insertSymbol(id, attr);
        var indexNode = new FloatNode(1, false);

        access.children.add(idNode);
        access.children.add(indexNode);

        //Act
        visitor.visit(access);
        var result = !visitor.errors.isEmpty();

        //Assert
        assert(result);
    }

    @Test
    void visitArrayAccess_ReceivesAccessNodeWithBooleanIndex_AddsErrorToErrors(){
        //Arrange
        var access = new ArrayAccessNode(false);
        String id = "id";
        var idNode = new IdNode(id, false);
        var attr = new Attributes();
        attr.variableType = "integer";
        visitor.symbolTable.insertSymbol(id, attr);
        var indexNode = new BooleanNode(false, false);

        access.children.add(idNode);
        access.children.add(indexNode);

        //Act
        visitor.visit(access);
        var result = !visitor.errors.isEmpty();

        //Assert
        assert(result);
    }
}