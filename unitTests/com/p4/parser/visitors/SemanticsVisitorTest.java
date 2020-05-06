package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
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
        var result = idNode.type.equals(attr.variableType);

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
        var result = visitor.errors.getErrorType(0) == ErrorType.TYPE_ERROR;

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
        var rightChild = new FuncCallNode(false);
        rightChild.children.add(funcCallId);
        visitor.symbolTable.calledFunctions.add("func" + id);

        var leftChild = new IdNode(id, false);
        var attr = new Attributes();
        attr.variableType = "integer";
        attr.kind = "dcl";
        visitor.symbolTable.insertSymbol(id, attr);

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
        var result = visitor.errors.getErrorType(0) == ErrorType.TYPE_ERROR;

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
        var result = visitor.errors.getErrorType(0) == ErrorType.TYPE_ERROR;

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
        var result = visitor.errors.getErrorType(0) == ErrorType.TYPE_ERROR;

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
        var result = visitor.errors.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitArrayDcl_(){}

    @Test
    void visitReturnExpr_(){}

    @Test
    void visitFuncCall_ReceivesDeclaredKnownAndCalledFunction_SetsTheFunctionTypeToTheTypeOfTheRelatedAttribute(){
        //Arrange
        var id = "idFunc";
        Attributes attr = new Attributes();
        attr.variableType = "integer";
        attr.kind = "function";
        attr.scope = visitor.symbolTable.getCurrentScope().getScopeName();
        visitor.symbolTable.insertSymbol(id, attr);
        var funcCallId = new IdNode(id, false);
        var funcCall = new FuncCallNode(false);
        funcCall.children.add(funcCallId);
        visitor.symbolTable.declaredFunctions.add("func" + id);
        visitor.symbolTable.calledFunctions.add("func" + id);

        //Act
        visitor.visit(funcCall);
        var result = funcCall.type.equals("integer");

        //Assert
        assert(result);
    }

    @Test
    void visitFuncCall_ReceivesKnownAndCalledButNotDeclaredFunction_AddsUndeclaredFunctionWarning(){
        //Arrange
        var id = "idFunc";
        Attributes attr = new Attributes();
        attr.variableType = "integer";
        attr.kind = "function";
        attr.scope = visitor.symbolTable.getCurrentScope().getScopeName();
        visitor.symbolTable.insertSymbol(id, attr);
        var funcCallId = new IdNode(id, false);
        var funcCall = new FuncCallNode(false);
        funcCall.children.add(funcCallId);
        visitor.symbolTable.calledFunctions.add("func" + id);

        //Act
        visitor.visit(funcCall);
        var result = visitor.errors.getErrorType(0) == ErrorType.UNDECLARED_FUNCTION_WARNING;

        //Assert
        assert(result);
    }

    @Test
    void visitFuncCall_ReceivesFunctionWithTheWorngNumberOfParams_AddsParameterError(){
        //Arrange
        var id = "idFunc";
        Attributes attr = new Attributes();
        attr.variableType = "integer";
        attr.kind = "function";
        attr.scope = visitor.symbolTable.getCurrentScope().getScopeName();
        visitor.symbolTable.insertSymbol(id, attr);
        var funcCallId = new IdNode(id, false);
        var funcCall = new FuncCallNode(false);
        funcCall.children.add(funcCallId);
        visitor.symbolTable.calledFunctions.add("func" + id);
        visitor.symbolTable.addScope("FuncNode-" + id);
        Attributes param1 = new Attributes();
        param1.variableType = "integer";
        param1.kind = "param";
        param1.scope = visitor.symbolTable.getCurrentScope().getScopeName();
        visitor.symbolTable.insertParam("param1", param1);
        param1.variableType = "integer";
        param1.kind = "param";
        param1.scope = visitor.symbolTable.getCurrentScope().getScopeName();
        visitor.symbolTable.insertParam("param2", param1);
        param1.variableType = "integer";
        param1.kind = "param";
        param1.scope = visitor.symbolTable.getCurrentScope().getScopeName();
        visitor.symbolTable.insertParam("param3", param1);
        visitor.symbolTable.leaveScope();
        visitor.symbolTable.declaredFunctions.add(id);
        visitor.symbolTable.calledFunctions.add(id);

        //Act
        visitor.visit(funcCall);
        var result = visitor.errors.getErrorType(0) == ErrorType.PARAMETER_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitFuncDcl_ReceivesFuncDclWithDefinedScope_MethodThrowsNoErrors(){
        //Arrange
        var id = "idFunc";
        var funcDcl = new FuncDclNode();
        funcDcl.id = id;

        Attributes attr = new Attributes();
        attr.variableType = "integer";

        visitor.symbolTable.addScope("FuncNode-" + id);
        visitor.symbolTable.insertSymbol(id, attr);
        visitor.symbolTable.declaredFunctions.add(id);
        visitor.symbolTable.calledFunctions.add(id);

        //Act
        visitor.visit(funcDcl);
        var result = visitor.errors.isEmpty();

        //Assert
        assert(result);
    }

    @Test
    void visitFuncDcl_ReceivesFuncDclWithABlkChildWithADifferentTypeThenFuncType_ErrorIsAdded(){
        //Arrange
        var id = "idFunc";
        var funcDclId = new IdNode(id, false);
        var funcDcl = new FuncDclNode();
        funcDcl.id = id;
        funcDcl.children.add(funcDclId);

        var blkNode = new BlkNode();
        var returnExpNode = new ReturnExpNode();
        returnExpNode.type = "character";

        var intNode = new CharNode('c', false);
        returnExpNode.type = "character";
        returnExpNode.children.add(intNode);

        blkNode.children.add(returnExpNode);
        funcDcl.children.add(blkNode);
        Attributes attr = new Attributes();
        attr.variableType = "integer";
        attr.kind = "function";

        visitor.symbolTable.insertSymbol(id, attr);
        visitor.symbolTable.declaredFunctions.add(id);
        visitor.symbolTable.calledFunctions.add(id);
        visitor.symbolTable.addScope("FuncNode-" + id);
        visitor.symbolTable.leaveScope();

        //Act
        visitor.visit(funcDcl);
        var result = visitor.errors.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitSelection_ReceivesSelectionNodeWithAcceptedCondition_NoErrorsAreAdded(){
        //Arrange
        var selection = new SelectionNode();
        var condition = new CondNode();
        var int1 = new NumberNode((long) 2, false);
        var int2 = new NumberNode((long) 2, false);
        condition.setOperator(CStarParser.IS);
        condition.children.add(int1);
        condition.children.add(int2);
        selection.children.add(condition);

        visitor.symbolTable.addScope(selection.getNodeHash());

        //Act
        visitor.visit(selection);
        var result = visitor.errors.isEmpty();

        //Assert
        assert(result);
    }

    @Test
    void visitSelection_ReceivesSelectionNodeWithUnacceptedCondition_TypeErrorAdded(){
        //Arrange
        var selection = new SelectionNode();
        var condition = new CondNode();
        var int1 = new CharNode('c', false);
        var int2 = new NumberNode((long) 2, false);
        condition.setOperator(CStarParser.IS);
        condition.children.add(int1);
        condition.children.add(int2);
        selection.children.add(condition);

        visitor.symbolTable.addScope(selection.getNodeHash());

        //Act
        visitor.visit(selection);
        var result = visitor.errors.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitIterative_ReceivesSelectionNodeWithAcceptedCondition_NoErrorsAreAdded(){
        //Arrange
        var iterative = new IterativeNode();
        var condition = new CondNode();
        var int1 = new NumberNode((long) 2, false);
        var int2 = new NumberNode((long) 2, false);
        condition.setOperator(CStarParser.IS);
        condition.children.add(int1);
        condition.children.add(int2);
        iterative.children.add(condition);

        visitor.symbolTable.addScope(iterative.getNodeHash());

        //Act
        visitor.visit(iterative);
        var result = visitor.errors.isEmpty();

        //Assert
        assert(result);
    }

    @Test
    void visitIterative_ReceivesSelectionNodeWithUnacceptedCondition_TypeErrorAdded(){
        //Arrange
        var iterative = new IterativeNode();
        var condition = new CondNode();
        var int1 = new CharNode('c', false);
        var int2 = new NumberNode((long) 2, false);
        condition.setOperator(CStarParser.IS);
        condition.children.add(int1);
        condition.children.add(int2);
        iterative.children.add(condition);

        visitor.symbolTable.addScope(iterative.getNodeHash());

        //Act
        visitor.visit(iterative);
        var result = visitor.errors.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitDiv_ReceivesDivNodeWithAcceptedIntegerOperands_NodeTypeSetToInteger(){
        //Arrange

        //Act

        //Assert
        assert(false);
    }

    @Test
    void visitDiv_ReceivesDivNodeWithUncompinableOperands_TypeErrorAdded(){
        //Arrange

        //Act

        //Assert
        assert(false);
    }

    @Test
    void visitDiv_ReceivesDivNodeTryingToDivideByZero_ZeroDivisionErrorAdded(){
        //Arrange

        //Act

        //Assert
        assert(false);
    }
}