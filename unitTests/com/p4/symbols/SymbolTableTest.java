package com.p4.symbols;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTableTest {

    private SymbolTable symbolTable = new SymbolTable();

    @BeforeEach
    void setUp() {
        symbolTable = new SymbolTable();
    }

    @Test
    void addScope_ReceivesNewScopeName_EntersAddedScope() {
        String scopeName = "NewScope";
        symbolTable.addScope(scopeName);
        assert(symbolTable.getCurrentScope().getScopeName().equals(scopeName));
    }

    @Test
    void addScope_ReceivesAlreadyExistingScope_StaysInCurrentScope() {
        String scopeName = "ExistingScope";
        symbolTable.addScope(scopeName);
        CStarScope result = symbolTable.lookupScope(scopeName);
        symbolTable.addScope(scopeName);

        assert(symbolTable.getCurrentScope() == result);
    }

    @Test
    void leaveScope_LeavesTheCurrentScopeAndEntersGlobalWithNoParent() {
        String scopeName = "NewScope";
        symbolTable.addScope(scopeName);
        symbolTable.leaveScope();
        assert(symbolTable.getCurrentScope().parent == null);
    }

    @Test
    void leaveScope_TheStackContainsThreeScopes_PopsTheCorrectScopeOffTheStack() {
        String scopeName = "NewScope";
        String firstScopeName = "FirstScopeName";
        String secondScopeName = "SecondScopeName";
        String thirdScopeName = "ThirdScopeName";
        symbolTable.addScope(firstScopeName);
        symbolTable.addScope(secondScopeName);
        symbolTable.addScope(thirdScopeName);
        CStarScope result = symbolTable.getCurrentScope();
        symbolTable.addScope(scopeName);
        symbolTable.leaveScope();
        assert(symbolTable.getCurrentScope() == result);
    }

    @Test
    void getCurrentScope_NoScopeAdded_ReturnsTheGlobalScope() {
        assert(symbolTable.getCurrentScope().parent == null);
    }

    @Test
    void getCurrentScope_OneScopeAdded_ReturnsTheAddedScope() {
        String scopeName = "NewScope";
        symbolTable.addScope(scopeName);
        assert(symbolTable.getCurrentScope().getScopeName().equals(scopeName));
    }

    @Test
    void getParent_ReturnsTheScopeAddedJustBeforeTheCurrentScope() {
        String firstScopeName = "FirstScopeName";
        String secondScopeName = "SecondScopeName";
        String thirdScopeName = "ThirdScopeName";
        symbolTable.addScope(firstScopeName);
        symbolTable.addScope(secondScopeName);
        symbolTable.addScope(thirdScopeName);
        assert(symbolTable.getCurrentScope().parent.getScopeName().equals(secondScopeName));
    }

    @Test
    void lookup_ReceivesSymbolNameWithinTheCurrentScope_ReturnsTheCorrespondingAttributesObject() {
        String firstScopeName = "FirstScopeName";
        symbolTable.addScope(firstScopeName);
        Attributes attr = new Attributes();
        attr.kind = "SymbolKind";
        symbolTable.insertSymbol("symbol", attr);
        assert(symbolTable.lookup("symbol").equals(attr));
    }

    @Test
    void lookup_ReceivesSymbolNameWithinTheParentScope_ReturnsTheCorrespondingAttributesObject() {
        String firstScopeName = "FirstScopeName";
        String secondScopeName = "SecondScopeName";
        String thirdScopeName = "ThirdScopeName";
        symbolTable.addScope(firstScopeName);
        Attributes attr = new Attributes();
        attr.kind = "SymbolKind";
        symbolTable.insertSymbol("symbol", attr);
        symbolTable.addScope(secondScopeName);
        symbolTable.addScope(thirdScopeName);
        assert(symbolTable.lookup("symbol").equals(attr));
    }

    @Test
    void lookup_ReceivesSymbolNameWithinChildScopeScope_ReturnsNull() {
        String firstScopeName = "FirstScopeName";
        String secondScopeName = "SecondScopeName";
        symbolTable.addScope(firstScopeName);
        symbolTable.addScope(secondScopeName);
        Attributes attr = new Attributes();
        attr.kind = "SymbolKind";
        symbolTable.insertSymbol("symbol", attr);
        symbolTable.leaveScope();
        assert(symbolTable.lookup("symbol") == null);
    }

    @Test
    void lookupScope() {
        //Todo: implement
    }

    @Test
    void enterScope() {
        //Todo: implement
    }

    @Test
    void lookupParam() {
        //Todo: implement
    }

    @Test
    void declaredInCurrentScope() {
        //Todo: implement
    }

    @Test
    void insertSymbol() {
        //Todo: implement
    }

    @Test
    void insertParam() {
        //Todo: implement
    }

    @Test
    void outputAvailableSymbols() {
        //Todo: implement
    }

    @Test
    void outputSymbolTable() {
        //Todo: implement
    }

    @Test
    void isSetupAndLoopDefined() {
        //Todo: implement
    }

    @AfterEach
    void tearDown() {
    }
}