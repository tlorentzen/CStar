package com.p4.symbols;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SymbolTableTest {
    private SymbolTable symbolTable = new SymbolTable();

    @BeforeEach
    void setUp() {
        symbolTable = new SymbolTable();
    }

    @Test
    void addScope_ReceivesNewScopeName_EntersAddedScope() {
        //Arrange
        String scopeName = "NewScope";
        symbolTable.addScope(scopeName);

        //Act
        String result = symbolTable.getCurrentScope().getScopeName();

        //Assert
        assert(result.equals(scopeName));
    }

    @Test
    void addScope_ReceivesAlreadyExistingScope_StaysInCurrentScope() {
        //Arrange
        String scopeName = "ExistingScope";
        symbolTable.addScope(scopeName);

        //Act
        CStarScope result = symbolTable.lookupScope(scopeName);
        symbolTable.addScope(scopeName);

        //Assert
        assert(symbolTable.getCurrentScope() == result);
    }

    @Test
    void leaveScope_LeavesTheCurrentScopeAndEntersGlobalWithNoParent() {
        //Arrange
        String scopeName = "NewScope";
        symbolTable.addScope(scopeName);
        symbolTable.leaveScope();

        //Act
        CStarScope result = symbolTable.getCurrentScope().getParent();

        //Assert
        assert(result == null);
    }

    @Test
    void leaveScope_TheStackContainsThreeScopes_PopsTheCorrectScopeOffTheStack() {
        //Arrange
        String scopeName = "NewScope";
        String firstScopeName = "FirstScopeName";
        String secondScopeName = "SecondScopeName";
        String thirdScopeName = "ThirdScopeName";
        symbolTable.addScope(firstScopeName);
        symbolTable.addScope(secondScopeName);
        symbolTable.addScope(thirdScopeName);

        //Act
        CStarScope result = symbolTable.getCurrentScope();
        symbolTable.addScope(scopeName);
        symbolTable.leaveScope();

        //Assert
        assert(symbolTable.getCurrentScope() == result);
    }

    @Test
    void getCurrentScope_NoScopeAdded_ReturnsTheGlobalScope() {
        assert(symbolTable.getCurrentScope().getParent() == null);
    }

    @Test
    void getCurrentScope_OneScopeAdded_ReturnsTheAddedScope() {
        //Arrange
        String scopeName = "NewScope";
        symbolTable.addScope(scopeName);

        //Act
        String result = symbolTable.getCurrentScope().getScopeName();

        // Assert
        assert(result.equals(scopeName));
    }

    @Test
    void getParent_ReturnsTheScopeAddedJustBeforeTheCurrentScope() {
        //Arrange
        String firstScopeName = "FirstScopeName";
        String secondScopeName = "SecondScopeName";
        String thirdScopeName = "ThirdScopeName";
        symbolTable.addScope(firstScopeName);
        symbolTable.addScope(secondScopeName);
        symbolTable.addScope(thirdScopeName);

        //Act
        String result = symbolTable.getCurrentScope().getParent().getScopeName();

        // Assert
        assert(result.equals(secondScopeName));
    }

    @Test
    void lookup_ReceivesSymbolNameWithinTheCurrentScope_ReturnsTheCorrespondingAttributesObject() {
        //Arrange
        String firstScopeName = "FirstScopeName";
        symbolTable.addScope(firstScopeName);
        Attributes attr = new Attributes("SymbolKind", "someType");
        symbolTable.insertSymbol("symbol", attr);

        //Act
        Attributes result = symbolTable.lookupSymbol("symbol");

        //Assert
        assert(result.equals(attr));
    }

    @Test
    void lookup_ReceivesSymbolNameWithinTheParentScope_ReturnsTheCorrespondingAttributesObject() {
        //Arrange
        String firstScopeName = "FirstScopeName";
        String secondScopeName = "SecondScopeName";
        String thirdScopeName = "ThirdScopeName";
        symbolTable.addScope(firstScopeName);
        Attributes attr = new Attributes("SymbolKind", "someType");
        symbolTable.insertSymbol("symbol", attr);
        symbolTable.addScope(secondScopeName);
        symbolTable.addScope(thirdScopeName);

        //Act
        Attributes result = symbolTable.lookupSymbol("symbol");

        //Assert
        assert(result.equals(attr));
    }

    @Test
    void lookup_ReceivesSymbolNameWithinChildScope_ReturnsNull() {
        //Arrange
        String firstScopeName = "FirstScopeName";
        String secondScopeName = "SecondScopeName";
        symbolTable.addScope(firstScopeName);
        symbolTable.addScope(secondScopeName);
        Attributes attr = new Attributes("SymbolKind", "type");
        symbolTable.insertSymbol("symbol", attr);
        symbolTable.leaveScope();

        //Act
        Attributes result = symbolTable.lookupSymbol("symbol");

        // Assert
        assert(result == null);
    }

    @Test
    void lookupScope_ReceivesAnExistentScope_ReturnsTheScope() {
        //Arrange
        String firstScopeName = "FirstScopeName";
        String secondScopeName = "SecondScopeName";
        symbolTable.addScope(firstScopeName);
        symbolTable.addScope(secondScopeName);

        //Act
        String result = symbolTable.lookupScope(secondScopeName).getScopeName();

        //Assert
        assert(result.equals(secondScopeName));
    }

    @Test
    void lookupScope_ReceivesANonExistentScope_ReturnsNull() {
        //Arrange
        String firstScopeName = "FirstScopeName";
        symbolTable.addScope(firstScopeName);

        //Act
        CStarScope result = symbolTable.lookupScope("SomeScope");

        //Assert
        assert(result == null);
    }

    @Test
    void enterScope_ReceivesExistingScopeName_SetsTheCurrentScopeToTheReceivedScope() {
        //Arrange
        String firstScopeName = "FirstScopeName";
        String secondScopeName = "SecondScopeName";
        symbolTable.addScope(firstScopeName);
        symbolTable.addScope(secondScopeName);
        symbolTable.leaveScope();
        symbolTable.leaveScope();

        //Act
        symbolTable.enterScope(secondScopeName);
        String result = symbolTable.getCurrentScope().getScopeName();

        //Assert
        assert(result.equals(secondScopeName));
    }

    @Test
    void enterScope_ReceivesExistingScopeName_PushesTheCurrentScopeToTheStack_LeavingTheScopeEntersThePreviousCurrentScope() {
        //Arrange
        String firstScopeName = "FirstScopeName";
        String secondScopeName = "SecondScopeName";
        symbolTable.addScope(firstScopeName);
        symbolTable.addScope(secondScopeName);
        symbolTable.leaveScope();
        symbolTable.leaveScope();
        CStarScope previousCurrentScope = symbolTable.getCurrentScope();

        //Act
        symbolTable.enterScope(secondScopeName);
        symbolTable.leaveScope();
        CStarScope result = symbolTable.getCurrentScope();

        //Assert
        assert(result.equals(previousCurrentScope));
    }

    @Test
    void insertSymbol_ReceivesSymbolAndAttributes_TheCurrentScopeContainsTheSymbol() {
        //Arrange
        String symbol = "SymbolName";
        Attributes attr = new Attributes("symbolKind", "variableType");

        //Act
        symbolTable.insertSymbol(symbol, attr);
        boolean result = symbolTable.getCurrentScope().getSymbols().containsKey(symbol);

        //Assert
        assert(result);
    }

    @Test
    void insertParam_ReceivesParamAndAttributes_TheCurrentScopeContainsTheParam() {
        //Arrange
        String param = "ParamName";
        Attributes attr = new Attributes("symbolKind", "variableType");

        //Act
        symbolTable.insertParam(param, attr);
        boolean result = symbolTable.getCurrentScope().getParams().containsKey(param);

        //Assert
        assert(result);
    }

    @Test
    void isSetupAndLoopDefined_TheSymbolTableContainsBothSetupAndLoop_ReturnsTrue() {
        //Arrange
        symbolTable.declaredFunctions.add("setup");
        symbolTable.declaredFunctions.add("loop");

        //Act
        boolean result = symbolTable.isSetupAndLoopDefined();

        //Assert
        assert(result);
    }

    @Test
    void isSetupAndLoopDefined_TheSymbolTableContainsOnlySetup_ReturnsFalse() {
        //Arrange
        symbolTable.declaredFunctions.add("setup");

        //Act
        boolean result = symbolTable.isSetupAndLoopDefined();

        //Assert
        assert(!result);
    }

    @Test
    void isSetupAndLoopDefined_TheSymbolTableContainsOnlyLoop_ReturnsFalse() {
        //Arrange
        symbolTable.declaredFunctions.add("loop");

        //Act
        boolean result = symbolTable.isSetupAndLoopDefined();

        //Assert
        assert(!result);
    }

    @Test
    void isSetupAndLoopDefined_TheSymbolTableContainsNeitherSetupNorLoop_ReturnsFalse() {
        //Arrange

        //Act
        boolean result = symbolTable.isSetupAndLoopDefined();

        //Assert
        assert(!result);
    }

    @AfterEach
    void tearDown() {
    }
}