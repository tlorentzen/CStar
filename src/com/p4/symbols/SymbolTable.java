package com.p4.symbols;

public class SymbolTable {

    private CStarScope currentScope;

    public SymbolTable(){
        this.currentScope = new CStarScope("global");
    }

    public void addScope(String scopeName){
        currentScope.children.add(new CStarScope(scopeName));
    }

    public void leaveScope(){
        if(currentScope.parent != null)
            currentScope = currentScope.parent;
    }

    public CStarScope getParent(){
        return currentScope.parent;
    }

    public Attributes lookup(String symbol){
        Attributes attri = currentScope.symbols.getOrDefault(symbol, null);

        if(attri == null){
            CStarScope scope = currentScope;

            while((scope = scope.parent) != null){
                attri = scope.symbols.getOrDefault(symbol, null);

                if(attri != null)
                    break;
            }
        }

        return attri;
    }

    public boolean declaredInCurrentScope(String symbol){
        return this.currentScope.symbols.containsKey(symbol);
    }

    public void insert(String symbol, Attributes attributes){
        currentScope.symbols.put(symbol, attributes);
    }
}

