package com.p4.symbols;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CStarScope{
    //Name of the scope
    String scopeName;
    //Parent scope
    CStarScope parent;
    //The symbols in the scope
    HashMap<String, Attributes> symbols = new HashMap<>();
    //Nested scopes within the current scope
    List<CStarScope> children = new ArrayList<>();
    int level;

    public CStarScope(String scopeName, int level){
        this.scopeName = scopeName;
        this.level = level;
    }

    public String getScopeName() {
        return scopeName;
    }

    public int getLevel() {
        return level;
    }
}
