package com.p4.symbols;

public class SymbolTable {

    private CStarScope currentScope;
    int level = 0;

    public SymbolTable(){
        this.currentScope = new CStarScope("global");
    }

    public void addScope(String scopeName){
        CStarScope s = new CStarScope(scopeName);
        s.parent = currentScope;
        currentScope.children.add(s);
        currentScope = s;
        level++;
        System.out.println(">> New scope added: "+scopeName+" ("+level+")");
    }

    public void leaveScope(){
        if(currentScope.parent != null){
            String currentScopeName = currentScope.ScopeName;
            currentScope = currentScope.parent;
            level--;
            System.out.println(">> Leaving scope: "+currentScopeName+" ("+(level+1)+") -> "+currentScope.ScopeName+" ("+(level)+")");
        }else{
            System.out.println(">> Leaving scope: Already in global scope! ("+level+")");
        }
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
}

