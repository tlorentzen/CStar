package com.p4.symbols;

import java.util.Map;
import java.util.Stack;

public class SymbolTable {

    private CStarScope currentScope;
    final private CStarScope globalScope;
    final private Stack<CStarScope> scopeStack = new Stack<>();
    int level = 0;

    public SymbolTable(){
        globalScope = new CStarScope("global", 0);
        currentScope = globalScope;
    }

    //todo skal også tjekke om scope navn allerede findes
    public void addScope(String scopeName){
        CStarScope scope = new CStarScope(scopeName, level + 1);
        scope.parent = currentScope;
        currentScope.children.add(scope);
        currentScope = scope;
        scopeStack.push(currentScope);
        level++;
        System.out.println(">> New scope added: " + scopeName + " (" + level + ")");
    }

    public void leaveScope(){
        if(currentScope.parent != null){
            String currentScopeName = currentScope.scopeName;
            currentScope = scopeStack.empty() ? globalScope : scopeStack.pop();
            level--;
            System.out.println(">> Leaving scope: "+currentScopeName+" (" + (level + 1) + ") -> " + currentScope.scopeName + " (" + (level) + ")");
        }else{
            System.out.println(">> Leaving scope: Already in global scope! (" + level + ")");
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
            if(scope.symbols.containsKey(symbol)){
                return scope.symbols.get(symbol);
            }
        }while((scope = scope.parent) != null);

       return null;
    }

    public CStarScope lookupScope(String scopeName){
        return this.findScope(scopeName, globalScope);
    }

    public boolean enterScope(String scopeName){
        CStarScope scope = this.findScope(scopeName, globalScope);

        if(scope != null){
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

    public FunctionAttributes lookupParam(String symbol){
        CStarScope scope = lookupScope(scopeName);

        if (scope == null){
            return null;
        }
        
        int numOfSymbols = scope.symbols.size();
        FunctionAttributes functionAttributes = (FunctionAttributes)lookup(funcName);
        
        // Goes through all symbols for a function scope
        // Finds all with the kind "param" and adds these to the function
        for (int i = 0; i < numOfSymbols; i++){
            scope.symbols.forEach((id, attributes) -> {
                if (attributes.kind.equals("param")) {
                    functionAttributes.parameters.add(id);
                }
            });
        }
        return functionAttributes;
    }

    public boolean declaredInCurrentScope(String symbol){
        return this.currentScope.symbols.containsKey(symbol);
    }

    public void insert(String symbol, Attributes attributes){
        currentScope.symbols.put(symbol, attributes);
    }

    public void outputAvailableSymbols(){
        CStarScope scope = currentScope;

        do{
            for (Map.Entry<String, Attributes> entry : scope.symbols.entrySet()){
                String key = entry.getKey();
                Attributes value = entry.getValue();

                System.out.printf("Symbol: %10s:%s \n", key, value.variableType);
            }
        } while((scope = scope.parent) != null);
    }
}

