package com.p4.symbols;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {

    private CStarScope currentScope;
    final private CStarScope globalScope;
    final private Stack<CStarScope> scopeStack = new Stack<>();
    public ArrayList<String> declaredFunctions = new ArrayList<>();
    public ArrayList<String> calledFunctions = new ArrayList<>();

    public SymbolTable(){
        globalScope = new CStarScope("global");
        currentScope = globalScope;
    }

    //todo skal også tjekke om scope navn allerede findes
    public void addScope(String scopeName){
        //If the scope already exists, do not add it.
        if(lookupScope(scopeName) != null){
            //Todo: handle trying to add existing scope
        } else {
            CStarScope scope = new CStarScope(scopeName);
            scope.parent = currentScope;
            currentScope.children.add(scope);
            scopeStack.push(currentScope);
            currentScope = scope;
        }
    }

    public void leaveScope(){
        this.leaveScope(null);
    }

    public void leaveScope(String hash){
        if(currentScope.parent != null){
            String currentScopeName = currentScope.scopeName;

            if(hash != null){
                currentScope.scopeName = hash;
                currentScopeName = hash;
            }

            currentScope = scopeStack.empty() ? globalScope : scopeStack.pop();
        }else{
            //Todo: handle already in global scope, hence leave is called to many times
        }
    }
    
    public CStarScope getCurrentScope(){
        return currentScope;
    }

    public CStarScope getParent(){
        return currentScope.parent;
    }

    public Attributes lookup(String symbol){
        CStarScope scope = currentScope;

        do{
            if(!scope.params.isEmpty() && scope.params.containsKey(symbol)){
                return scope.params.get(symbol);
            }
            if(!scope.symbols.isEmpty() && scope.symbols.containsKey(symbol)){
                return scope.symbols.get(symbol);
            }
        }while((scope = scope.parent) != null);

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

        if(current_scope.scopeName.equals(scopeName)){
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
        return this.currentScope.symbols.containsKey(symbol);
    }

    public void insertSymbol(String symbol, Attributes attributes){
        currentScope.symbols.put(symbol, attributes);
    }

    public void insertParam(String id, Attributes attributes){
        currentScope.params.put(id, attributes);
    }

    public void outputAvailableSymbols(){
        CStarScope scope = currentScope;

        do{
            for (Map.Entry<String, Attributes> entry : scope.symbols.entrySet()){
                String key = entry.getKey();
                Attributes value = entry.getValue();

                //System.out.printf("Symbol: %10s:%s \n", key, value.variableType);
            }
        } while((scope = scope.parent) != null);
    }

    public void outputSymbolTable(CStarScope scope){
        CStarScope oldScope = scope;

        for (Map.Entry<String, Attributes> entry : scope.symbols.entrySet()){
            String key = entry.getKey();
            Attributes value = entry.getValue();

            //System.out.printf("Current scope: " + scope.scopeName + " Symbol: %10s:%s \n", key, value.variableType);
        }

        scope = oldScope;
        for (CStarScope child : scope.children) {
            outputSymbolTable(child);
        }
    }
}

