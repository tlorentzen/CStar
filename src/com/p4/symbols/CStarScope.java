package com.p4.symbols;

import javax.management.Attribute;
import java.util.*;

public class CStarScope{
    //Name of the scope
    String scopeName;
    //Parent scope
    CStarScope parent;
    //The symbols in the scope
    HashMap<String, Attributes> symbols = new HashMap<>();
    public Map<String, String> params = new LinkedHashMap<>();

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
