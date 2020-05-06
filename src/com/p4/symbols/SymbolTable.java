package com.p4.symbols;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    private CStarScope currentScope;
    final private CStarScope globalScope;
    final private Stack<CStarScope> scopeStack = new Stack<>();
    public ArrayList<String> declaredFunctions = new ArrayList<>();
    public ArrayList<String> calledFunctions = new ArrayList<>();
    public HashMap<String, PinAttributes> pinList = new HashMap<>();

    public SymbolTable() {
        globalScope = new CStarScope("global");
        currentScope = globalScope;
    }

    //Adds a scope to the symbol table
    public void addScope(String scopeName) {
        //Enters if the scope name has not already been used
        if (lookupScope(scopeName) == null) {
            CStarScope scope = new CStarScope(scopeName);
            scope.setParent(currentScope);
            currentScope.children.add(scope);
            scopeStack.push(currentScope);
            currentScope = scope;
        }
    }

    public void leaveScope() {
        this.leaveScope(null);
    }

    public void leaveScope(String scopeName) {
        //Enters if non-global scope
        if (currentScope.getParent() != null) {
            if (scopeName != null) {
                currentScope.setScopeName(scopeName);
            }

            //Removes the scope from the stack and set current scope to the outer scope
            currentScope = scopeStack.empty() ? globalScope : scopeStack.pop();
        }
    }

    //TODO Ida og lena nåede hertil
    public CStarScope getCurrentScope() {
        return currentScope;
    }

    public CStarScope getParent() {
        return currentScope.getParent();
    }

    public Attributes lookup(String symbol) {
        CStarScope scope = currentScope;

        do {
            if (!scope.getParams().isEmpty() && scope.getParams().containsKey(symbol)) {
                return scope.getParams().get(symbol);
            }
            if (!scope.getSymbols().isEmpty() && scope.getSymbols().containsKey(symbol)) {
                return scope.getSymbols().get(symbol);
            }
        } while((scope = scope.getParent()) != null);

       return null;
    }

    /**
     *
     * @param scopeName the name of the scope to find.
     * @return the scope or null if not found.
     */
    public CStarScope lookupScope(String scopeName){
        return this.findScope(scopeName, globalScope);
    }

    public boolean enterScope(String scopeName){
        CStarScope scope = this.findScope(scopeName, globalScope);

        if(scope != null){
            scopeStack.push(currentScope);
            currentScope = scope;
            return true;
        }

        return false;
    }

    private CStarScope findScope(String scopeName, CStarScope current_scope){

        if(current_scope.getScopeName().equals(scopeName)){
            return current_scope;
        }

        CStarScope scope = null;

        for (CStarScope childScope : current_scope.children) {
            scope = this.findScope(scopeName, childScope);

            if(scope != null)
                break;
        }

        return scope;
    }

    public Attributes lookupParam(String symbol){
        CStarScope scope = currentScope;

        if (scope == null){
            return null;
        }

        return lookup(symbol);
    }

    public boolean declaredInCurrentScope(String symbol){
        return this.currentScope.getSymbols().containsKey(symbol);
    }

    public void insertSymbol(String symbol, Attributes attributes){
        if (attributes.getVariableType().equals("pin")) {
            pinList.put(symbol, (PinAttributes)attributes);
        }

        currentScope.getSymbols().put(symbol, attributes);
    }

    public void insertParam(String id, Attributes attributes){
        currentScope.getParams().put(id, attributes);
    }

    public void outputAvailableSymbols(){
        CStarScope scope = currentScope;

        do{
            for (Map.Entry<String, Attributes> entry : scope.getSymbols().entrySet()){
                String key = entry.getKey();
                Attributes value = entry.getValue();

                //System.out.printf("Symbol: %10s:%s \n", key, value.variableType);
            }
        } while((scope = scope.getParent()) != null);
    }

    public void outputSymbolTable(CStarScope scope){
        CStarScope oldScope = scope;

        for (Map.Entry<String, Attributes> entry : scope.getSymbols().entrySet()){
            String key = entry.getKey();
            Attributes value = entry.getValue();

            //System.out.printf("Current scope: " + scope.scopeName + " Symbol: %10s:%s \n", key, value.variableType);
        }

        scope = oldScope;
        for (CStarScope child : scope.children) {
            outputSymbolTable(child);
        }
    }

    public boolean isSetupAndLoopDefined(){
        return (this.declaredFunctions.contains("setup")
                && this.declaredFunctions.contains("loop"));
    }

    public PinAttributes getPin(String symbol){
        return this.pinList.getOrDefault(symbol, null);
    }

}

