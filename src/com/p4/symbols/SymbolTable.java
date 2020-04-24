package com.p4.symbols;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private CStarScope currentScope;
    private CStarScope globalScope;
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
        level++;
        System.out.println(">> New scope added: " + scopeName + " (" + level + ")");
    }

    public void leaveScope(){
        if(currentScope.parent != null){
            String currentScopeName = currentScope.scopeName;
            currentScope = currentScope.parent;
            level--;
            System.out.println(">> Leaving scope: "+currentScopeName+" (" + (level + 1) + ") -> " + currentScope.scopeName + " (" + (level) + ")");
        }else{
            System.out.println(">> Leaving scope: Already in global scope! (" + level + ")");
        }
    }
    
    public String getCurrentScope(){
        return currentScope.scopeName;
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

    public CStarScope lookupFuncScope(String scopeName){
        int index = 0;
        CStarScope scope = globalScope;

        do {
            if (scope.scopeName.equals(scopeName)) {
                return scope;
            }
            scope = globalScope.children.get(index);
            index++;
        } while (scope != null);

        return null;
    }

    public FunctionAttributes lookupParam(String scopeName, String funcName){
        CStarScope scope = lookupFuncScope(scopeName);

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
                    functionAttributes.addParameter(id, attributes);
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

