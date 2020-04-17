package com.p4.symbols;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private CStarScope currentScope;
    int level = 0;

    public SymbolTable(){
        this.currentScope = new CStarScope("global", 0);
    }

    public void addScope(String scopeName){
        CStarScope s = new CStarScope(scopeName, level+1);
        s.parent = currentScope;
        currentScope.children.add(s);
        currentScope = s;
        level++;
        System.out.println(">> New scope added: "+scopeName+" ("+level+")");
    }

    public void leaveScope(){
        if(currentScope.parent != null){
            String currentScopeName = currentScope.scopeName;
            currentScope = currentScope.parent;
            level--;
            System.out.println(">> Leaving scope: "+currentScopeName+" ("+(level+1)+") -> "+currentScope.scopeName+" ("+(level)+")");
        }else{
            System.out.println(">> Leaving scope: Already in global scope! ("+level+")");
        }
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

    public boolean declaredInAccessibleScope(String symbol){
        if(declaredInCurrentScope(symbol)){
            return true;
        }

        CStarScope scope = currentScope;

        while((scope = scope.parent) != null){
            if(scope.symbols.containsKey(symbol))
                return true;
        }

        return false;
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
        }while((scope = scope.parent) != null);
    }
}

