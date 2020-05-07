package com.p4.symbols;

import java.util.*;

public class CStarScope {
    private String scopeName;
    private CStarScope parent;
    //The symbols in the scope
    private HashMap<String, Attributes> symbols = new HashMap<>();
    private Map<String, Attributes> params = new LinkedHashMap<>();

    //Nested scopes within the current scope
    List<CStarScope> children = new ArrayList<>();

    public CStarScope(String scopeName){
        this.scopeName = scopeName;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String name) {
        scopeName = name;
    }

    public CStarScope getParent() {
        return parent;
    }

    public void setParent(CStarScope parent) {
        this.parent = parent;
    }

    public HashMap<String, Attributes> getSymbols() {
        return symbols;
    }

    public void setSymbols(String id, Attributes attribute) {
        symbols.put(id, attribute);
    }

    public Map<String, Attributes> getParams() {
        return params;
    }

    public void addParams(String id, Attributes attribute) {
        params.put(id, attribute);
    }
}
