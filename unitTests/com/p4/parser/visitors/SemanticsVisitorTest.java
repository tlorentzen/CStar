package com.p4.parser.visitors;

import com.p4.errors.ErrorBag;
import com.p4.errors.ErrorType;
import com.p4.symbols.Attributes;
import com.p4.symbols.SymbolTable;
import com.p4.syntaxSemantic.CStarParser;
import com.p4.syntaxSemantic.nodes.*;
import com.p4.syntaxSemantic.visitors.SemanticsVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SemanticsVisitorTest {
    private SemanticsVisitor visitor = new SemanticsVisitor(new SymbolTable(), new ErrorBag());

    @BeforeEach
    void setup() {
        visitor = new SemanticsVisitor(new SymbolTable(), new ErrorBag());
    }

    @Test
    void visitId_ReceivesDeclaredId_SetsTypeToTypeOfAttribute() {
        //Arrange
        String id = "id";
        IdNode idNode = new IdNode(id, false);
        Attributes attr = new Attributes("dcl", "type");
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.insertSymbol(id, attr);
        visitor = new SemanticsVisitor(symbolTable, new ErrorBag());

        //Act
        visitor.visit(idNode);
        boolean result = idNode.type.equals(attr.getVariableType());

        //Assert
        assert(result);
    }

    @Test
    void visitId_ReceivesIdNotDeclaredButCalled_SetsTypeToArduinoC() {
        //Arrange
        String id = "id";
        IdNode idNode = new IdNode(id, false);
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.calledFunctions.add(id);
        visitor = new SemanticsVisitor(symbolTable, new ErrorBag());

        //Act
        visitor.visit(idNode);
        boolean result = idNode.type.equals("ArduinoC");

        //Assert
        assert(result);
    }

    @Test
    void visitId_ReceivesIdNull_SetsTypeToNull(){
        //Arrange
        String id = "id";
        IdNode idNode = new IdNode(id, false);

        //Act
        visitor.visit(idNode);
        boolean result = idNode.type == null;

        //Assert
        assert(result);
    }

    @Test
    void visitNumber_ReceivesNumberOfSizeBiggerThanLong_AddsTypeErrorToErrors() {
        //Arrange
        NumberNode number = new NumberNode(Long.MAX_VALUE + 1, false);
        ErrorBag error = new ErrorBag();
        visitor = new SemanticsVisitor(new SymbolTable(), error);

        //Act
        visitor.visit(number);
        boolean result = error.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitNumber_ReceivesNumberOfSmallIntegerSize_SetsNodeTypeToSmallInteger() {
        //Arrange
        NumberNode number = new NumberNode((long)1, false);

        //Act
        visitor.visit(number);
        boolean result = number.type.equals("small integer");

        //Assert
        assert(result);
    }

    @Test
    void visitNumber_ReceivesNumberOfIntegerSize_SetsNodeTypeToInteger() {
        //Arrange
        NumberNode number = new NumberNode((long) Integer.MAX_VALUE - 1, false);

        //Act
        visitor.visit(number);
        boolean result = number.type.equals("integer");

        //Assert
        assert(result);
    }

    @Test
    void visitNumber_ReceivesNumberOfLongIntegerSize_SetsNodeTypeToLongInteger() {
        //Arrange
        NumberNode number = new NumberNode(Long.MAX_VALUE-1, false);

        //Act
        visitor.visit(number);
        boolean result = number.type.equals("long integer");

        //Assert
        assert(result);
    }

    @Test
    void visitAssign_ReceivesAssignWithFuncCallAsSecondChildOfTypeArduinoC_SetsTheTypeToTheTypeOfLeftChild() {
        //Arrange
        AssignNode assign = new AssignNode();

        String id = "id";
        IdNode funcCallId = new IdNode("func" + id, false);
        FuncCallNode rightChild = new FuncCallNode(false);
        rightChild.children.add(funcCallId);
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.calledFunctions.add("func" + id);
        visitor = new SemanticsVisitor(symbolTable, new ErrorBag());

        IdNode leftChild = new IdNode(id, false);
        Attributes attr = new Attributes("dcl", "integer");
        symbolTable.insertSymbol(id, attr);

        assign.children.add(leftChild);
        assign.children.add(rightChild);

        //Act
        visitor.visit(assign);
        boolean result = assign.type.equals("integer");

        //Assert
        assert(result);
    }

    @Test
    void visitAssign_ReceivesIntegerAndFloat_SetsTheTypeToFloat() {
        //Arrange
        AssignNode assign = new AssignNode();

        String id = "id";
        IdNode leftChild = new IdNode(id, false);
        leftChild.type = "decimal";

        SymbolTable symbolTable = new SymbolTable();
        Attributes attr = new Attributes("dcl", "decimal");

        symbolTable.insertSymbol(id, attr);
        visitor = new SemanticsVisitor(symbolTable, new ErrorBag());

        NumberNode rightChild = new NumberNode((long)1, false);
        rightChild.type = "integer";

        assign.children.add(leftChild);
        assign.children.add(rightChild);

        //Act
        visitor.visit(assign);
        boolean result = assign.type.equals("decimal");

        //Assert
        assert(result);
    }

    @Test
    void visitLogical_ReceivesLogicalWithTwoBooleanChildren_SetsTypeToBoolean() {
        //Arrange
        LogicalNode logical = new LogicalNode();
        BooleanNode child1 = new BooleanNode(true, false);
        BooleanNode child2 = new BooleanNode(true, false);
        logical.children.add(child1);
        logical.children.add(child2);

        //Act
        visitor.visit(logical);
        boolean result = logical.type.equals("boolean");

        //Assert
        assert(result);
    }

    @Test
    void visitLogical_ReceivesLogicalWithOneBooleanAndOneSmallIntegerChild_AddsTypeErrorToErrors() {
        //Arrange
        LogicalNode logical = new LogicalNode();
        BooleanNode child1 = new BooleanNode(true, false);
        NumberNode child2 = new NumberNode((long) 2, false);
        logical.children.add(child1);
        logical.children.add(child2);
        ErrorBag error = new ErrorBag();
        visitor = new SemanticsVisitor(new SymbolTable(), error);

        //Act
        visitor.visit(logical);
        boolean result = error.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitCond_ReceivesLogicalWithTwoBooleanChildren_SetsTypeToBoolean() {
        //Arrange
        CondNode cond = new CondNode();
        BooleanNode child1 = new BooleanNode(true, false);
        BooleanNode child2 = new BooleanNode(false, false);
        cond.setToken(CStarParser.IS);
        cond.children.add(child1);
        cond.children.add(child2);

        //Act
        visitor.visit(cond);
        boolean result = cond.type.equals("boolean");

        //Assert
        assert(result);
    }

    @Test
    void visitCond_ReceivesLogicalWithTwoSmallIntegerChildren_SetsTypeToBoolean(){
        //Arrange
        CondNode cond = new CondNode();
        NumberNode child1 = new NumberNode((long)1, false);
        NumberNode child2 = new NumberNode((long)2, false);
        cond.setToken(CStarParser.LESS_THAN);
        cond.children.add(child1);
        cond.children.add(child2);

        //Act
        visitor.visit(cond);
        boolean result = cond.type.equals("boolean");

        //Assert
        assert(result);
    }

    @Test
    void visitCond_ReceivesLogicalWithTwoDifferentChildren_AddsError() {
        //Arrange
        CondNode cond = new CondNode();
        NumberNode child1 = new NumberNode((long)1, false);
        BooleanNode child2 = new BooleanNode(false, false);
        cond.setToken(CStarParser.LESS_THAN);
        cond.children.add(child1);
        cond.children.add(child2);
        ErrorBag error = new ErrorBag();
        visitor = new SemanticsVisitor(new SymbolTable(), error);

        //Act
        visitor.visit(cond);
        boolean result = error.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitArrayAccess_ReceivesAccessNodeWithIdAndIndex_SetsTypeToIdType() {
        //Arrange
        ArrayAccessNode access = new ArrayAccessNode(false);
        String id = "id";
        IdNode idNode = new IdNode(id, false);

        Attributes attr = new Attributes("dcl", "integer");
        SymbolTable symbolTable = new SymbolTable();
        visitor = new SemanticsVisitor(symbolTable, new ErrorBag());
        symbolTable.insertSymbol(id, attr);
        NumberNode indexNode = new NumberNode((long) 1, false);

        access.children.add(idNode);
        access.children.add(indexNode);

        //Act
        visitor.visit(access);
        boolean result = access.type.equals("integer");

        //Assert
        assert(result);
    }

    @Test
    void visitArrayAccess_ReceivesAccessNodeWithDecimalIndex_AddsErrorToErrors() {
        //Arrange
        ArrayAccessNode access = new ArrayAccessNode(false);
        String id = "id";
        IdNode idNode = new IdNode(id, false);

        Attributes attr = new Attributes("dcl", "integer");
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.insertSymbol(id, attr);
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        FloatNode indexNode = new FloatNode(1, false);

        access.children.add(idNode);
        access.children.add(indexNode);

        //Act
        visitor.visit(access);
        boolean result = errorBag.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitArrayAccess_ReceivesAccessNodeWithBooleanIndex_AddsErrorToErrors() {
        //Arrange
        ArrayAccessNode access = new ArrayAccessNode(false);
        String id = "id";
        IdNode idNode = new IdNode(id, false);

        Attributes attr = new Attributes("dcl", "integer");
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.insertSymbol(id, attr);
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);
        BooleanNode indexNode = new BooleanNode(false, false);

        access.children.add(idNode);
        access.children.add(indexNode);

        //Act
        visitor.visit(access);
        boolean result = errorBag.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitArrayDcl_ReceivesCorrectArrayDcl_SetsTheType() {
        //Arrange
        String id = "id";
        ArrayDclNode<?> dcl = new ArrayDclNode<Integer>(id);
        dcl.children.add(new ArrayNode(id, "integer"));
        dcl.children.add(new ArrayExprNode());

        //Act
        visitor.visit(dcl);
        String result = dcl.type;

        //Assert
        assert(result.equals("integer"));
    }

    @Test
    void visitArrayDcl_ReceivesArrayDclWithArrayExprWithIllegalTypeConversions_AddsTypeError() {
        //Arrange
        String id = "id";
        ArrayDclNode<?> dcl = new ArrayDclNode<Integer>(id);
        dcl.children.add(new ArrayNode(id, "integer"));
        ArrayExprNode expr = new ArrayExprNode();
        expr.children.add(new IdNode("intId", "integer"));
        expr.children.add(new IdNode("decimalId", "decimal"));
        dcl.children.add(expr);

        Attributes intAttr = new Attributes("dcl", "integer");
        Attributes decimalAttr = new Attributes("dcl", "decimal");
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.insertSymbol("intId", intAttr);
        symbolTable.insertSymbol("decimalId", decimalAttr);
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(dcl);
        ErrorType result = errorBag.getErrorType(0);

        //Assert
        assert(result.equals(ErrorType.TYPE_ERROR));
    }

    @Test
    void visitReturnExpr_ReceivesCorrectReturnExprNode_ReturnsCorrectReturnType() {
        //Arrange
        ReturnExpNode expr = new ReturnExpNode();
        String id = "Id";
        expr.children.add(new IdNode(id, false));

        Attributes attr = new Attributes("integer", "integer");
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.insertSymbol(id, attr);
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(expr);
        String result = expr.type;

        //Assert
        assert(result.equals("integer"));
    }

    @Test
    void visitReturnExpr_ReceivesArrayReturnExprNode_AddsTypeError() {
        //Arrange
        ReturnExpNode expr = new ReturnExpNode();
        String id = "Id";
        expr.children.add(new IdNode(id, false));

        Attributes attr = new Attributes("array", "integer");
        SymbolTable symbolTable = new SymbolTable();
        symbolTable.insertSymbol(id, attr);
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(expr);
        ErrorType result = errorBag.getErrorType(0);

        //Assert
        assert(result.equals(ErrorType.TYPE_ERROR));
    }

    @Test
    void visitFuncCall_ReceivesDeclaredKnownAndCalledFunction_SetsTheFunctionTypeToTheTypeOfTheRelatedAttribute() {
        //Arrange
        String id = "idFunc";
        Attributes attr = new Attributes("function", "integer");

        SymbolTable symbolTable = new SymbolTable();
        symbolTable.insertSymbol(id, attr);
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        IdNode funcCallId = new IdNode(id, false);
        FuncCallNode funcCall = new FuncCallNode(false);
        funcCall.children.add(funcCallId);
        symbolTable.declaredFunctions.add("func" + id);
        symbolTable.calledFunctions.add("func" + id);

        //Act
        visitor.visit(funcCall);
        boolean result = funcCall.type.equals("integer");

        //Assert
        assert(result);
    }

    @Test
    void visitFuncCall_ReceivesKnownAndCalledButNotDeclaredFunction_AddsUndeclaredFunctionWarning() {
        //Arrange
        String id = "idFunc";
        Attributes attr = new Attributes("function", "integer");

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        symbolTable.insertSymbol(id, attr);
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        IdNode funcCallId = new IdNode(id, false);
        FuncCallNode funcCall = new FuncCallNode(false);
        funcCall.children.add(funcCallId);
        symbolTable.calledFunctions.add("func" + id);

        //Act
        visitor.visit(funcCall);
        boolean result = errorBag.getErrorType(0) == ErrorType.UNDECLARED_FUNCTION_WARNING;

        //Assert
        assert(result);
    }

    @Test
    void visitFuncCall_ReceivesFunctionWithTheWrongNumberOfParams_AddsParameterError() {
        //Arrange
        String id = "idFunc";
        Attributes attr = new Attributes("function", "integer");

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        IdNode funcCallId = new IdNode(id, false);
        FuncCallNode funcCall = new FuncCallNode(false);
        funcCall.children.add(funcCallId);
        symbolTable.insertSymbol(id, attr);
        symbolTable.declaredFunctions.add(id);
        symbolTable.calledFunctions.add(id);
        symbolTable.addScope("FuncNode-" + id);

        Attributes param1 = new Attributes("param", "integer");
        param1.setScope(symbolTable.getCurrentScope().getScopeName());
        symbolTable.insertParam("param1", param1);

        param1 = new Attributes("param", "integer");
        param1.setScope(symbolTable.getCurrentScope().getScopeName());
        symbolTable.insertParam("param2", param1);

        param1 = new Attributes("param", "integer");
        param1.setScope(symbolTable.getCurrentScope().getScopeName());
        symbolTable.insertParam("param3", param1);

        //Act
        visitor.visit(funcCall);
        boolean result = errorBag.getErrorType(0) == ErrorType.PARAMETER_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitFuncDcl_ReceivesFuncDclWithDefinedScope_MethodThrowsNoErrors() {
        //Arrange
        String id = "idFunc";
        FuncDclNode funcDcl = new FuncDclNode();
        funcDcl.setId(id);

        Attributes attr = new Attributes("function", "integer");

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        symbolTable.addScope("FuncNode-" + id);
        symbolTable.insertSymbol(id, attr);
        symbolTable.declaredFunctions.add(id);
        symbolTable.calledFunctions.add(id);

        //Act
        visitor.visit(funcDcl);
        boolean result = errorBag.isEmpty();

        //Assert
        assert(result);
    }

    @Test
    void visitFuncDcl_ReceivesFuncDclWithABlkChildWithADifferentTypeThenFuncType_ErrorIsAdded() {
        //Arrange
        String id = "idFunc";
        IdNode funcDclId = new IdNode(id, false);
        FuncDclNode funcDcl = new FuncDclNode();
        funcDcl.setId(id);
        funcDcl.children.add(funcDclId);

        BlkNode blkNode = new BlkNode();
        ReturnExpNode returnExpNode = new ReturnExpNode();
        returnExpNode.type = "character";

        CharNode charNode = new CharNode('c', false);
        returnExpNode.type = "character";
        returnExpNode.children.add(charNode);

        blkNode.children.add(returnExpNode);
        funcDcl.children.add(blkNode);
        Attributes attr = new Attributes("function", "integer");

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        symbolTable.insertSymbol(id, attr);
        symbolTable.declaredFunctions.add(id);
        symbolTable.calledFunctions.add(id);
        symbolTable.addScope("FuncNode-" + id);
        symbolTable.leaveScope();

        //Act
        visitor.visit(funcDcl);
        boolean result = errorBag.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitSelection_ReceivesSelectionNodeWithAcceptedCondition_NoErrorsAreAdded() {
        //Arrange
        SelectionNode selection = new SelectionNode();
        CondNode condition = new CondNode();
        NumberNode int1 = new NumberNode((long) 2, false);
        NumberNode int2 = new NumberNode((long) 2, false);
        condition.setToken(CStarParser.IS);
        condition.children.add(int1);
        condition.children.add(int2);
        selection.children.add(condition);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        symbolTable.addScope(selection.getNodeHash());

        //Act
        visitor.visit(selection);
        boolean result = errorBag.isEmpty();

        //Assert
        assert(result);
    }

    @Test
    void visitSelection_ReceivesSelectionNodeWithUnacceptedCondition_TypeErrorAdded() {
        //Arrange
        SelectionNode selection = new SelectionNode();
        CondNode condition = new CondNode();
        CharNode charNode = new CharNode('c', false);
        NumberNode intNode = new NumberNode((long) 2, false);
        condition.setToken(CStarParser.IS);
        condition.children.add(charNode);
        condition.children.add(intNode);
        selection.children.add(condition);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        symbolTable.addScope(selection.getNodeHash());

        //Act
        visitor.visit(selection);
        boolean result = errorBag.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitIterative_ReceivesSelectionNodeWithAcceptedCondition_NoErrorsAreAdded() {
        //Arrange
        IterativeNode iterative = new IterativeNode();
        CondNode condition = new CondNode();
        NumberNode int1 = new NumberNode((long) 2, false);
        NumberNode int2 = new NumberNode((long) 2, false);
        condition.setToken(CStarParser.IS);
        condition.children.add(int1);
        condition.children.add(int2);
        iterative.children.add(condition);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        symbolTable.addScope(iterative.getNodeHash());

        //Act
        visitor.visit(iterative);
        boolean result = errorBag.isEmpty();

        //Assert
        assert(result);
    }

    @Test
    void visitIterative_ReceivesSelectionNodeWithUnacceptedCondition_TypeErrorAdded() {
        //Arrange
        IterativeNode iterative = new IterativeNode();
        CondNode condition = new CondNode();
        CharNode charNode = new CharNode('c', false);
        NumberNode intNode = new NumberNode((long) 2, false);
        condition.setToken(CStarParser.IS);
        condition.children.add(charNode);
        condition.children.add(intNode);
        iterative.children.add(condition);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        symbolTable.addScope(iterative.getNodeHash());

        //Act
        visitor.visit(iterative);
        boolean result = errorBag.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitDiv_ReceivesDivNodeWithAcceptedSmallIntegerOperands_NodeTypeSetToInteger() {
        //Arrange
        DivNode div = new DivNode();
        NumberNode int1 = new NumberNode((long) 2, false);
        NumberNode int2 = new NumberNode((long) 2, false);
        div.children.add(int1);
        div.children.add(int2);

        //Act
        visitor.visit(div);
        String result = div.type;

        //Assert
        assert(result.equals("small integer"));
    }

    @Test
    void visitDiv_ReceivesDivNodeWithUncompinableOperands_TypeErrorAdded() {
        //Arrange
        DivNode div = new DivNode();
        NumberNode charNode = new NumberNode((long) 2, false);
        CharNode intNode = new CharNode('c', false);
        div.children.add(charNode);
        div.children.add(intNode);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(div);
        boolean result = errorBag.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitDiv_ReceivesDivNodeTryingToDivideByZero_ZeroDivisionErrorAdded() {
        //Arrange
        DivNode div = new DivNode();
        NumberNode int1 = new NumberNode((long) 2, false);
        NumberNode int2 = new NumberNode((long) 0, false);
        div.children.add(int1);
        div.children.add(int2);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(div);
        boolean result = errorBag.getErrorType(0) == ErrorType.ZERO_DIVISION;

        //Assert
        assert(result);
    }

    @Test
    void visitSub_ReceivesDivNodeWithAcceptedSmallIntegerOperands_NodeTypeSetToInteger() {
        //Arrange
        SubNode div = new SubNode();
        NumberNode int1 = new NumberNode((long) 2, false);
        NumberNode int2 = new NumberNode((long) 2, false);
        div.children.add(int1);
        div.children.add(int2);

        //Act
        visitor.visit(div);
        String result = div.type;

        //Assert
        assert(result.equals("small integer"));
    }

    @Test
    void visitSub_ReceivesDivNodeWithUncompinableOperands_TypeErrorAdded() {
        //Arrange
        SubNode div = new SubNode();
        NumberNode int1 = new NumberNode((long) 2, false);
        CharNode int2 = new CharNode('c', false);
        div.children.add(int1);
        div.children.add(int2);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(div);
        boolean result = errorBag.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }

    @Test
    void visitAdd_ReceivesDivNodeWithAcceptedSmallIntegerOperands_NodeTypeSetToInteger() {
        //Arrange
        AddNode div = new AddNode();
        NumberNode int1 = new NumberNode((long) 2, false);
        NumberNode int2 = new NumberNode((long) 2, false);
        div.children.add(int1);
        div.children.add(int2);

        //Act
        visitor.visit(div);
        String result = div.type;

        //Assert
        assert(result.equals("small integer"));
    }

    @Test
    void visitAdd_ReceivesDivNodeWithUncompinableOperands_TypeErrorAdded() {
        //Arrange
        AddNode div = new AddNode();
        NumberNode int1 = new NumberNode((long) 2, false);
        CharNode int2 = new CharNode('c', false);
        div.children.add(int1);
        div.children.add(int2);

        SymbolTable symbolTable = new SymbolTable();
        ErrorBag errorBag = new ErrorBag();
        visitor = new SemanticsVisitor(symbolTable, errorBag);

        //Act
        visitor.visit(div);
        boolean result = errorBag.getErrorType(0) == ErrorType.TYPE_ERROR;

        //Assert
        assert(result);
    }
}