package com.p4.symbols;

import java.util.*;

public class CStarScope{
    //Name of the scope
    String scopeName;
    //Parent scope
    CStarScope parent;
    //The symbols in the scope
    HashMap<String, Attributes> symbols = new HashMap<>();
    public Map<String, Attributes> params = new LinkedHashMap<>();

    //Nested scopes within the current scope
    List<CStarScope> children = new ArrayList<>();

    public CStarScope(String scopeName){
        this.scopeName = scopeName;
    }

    public String getScopeName() {
        return scopeName;
    }
}
