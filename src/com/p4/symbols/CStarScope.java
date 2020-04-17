package com.p4.symbols;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CStarScope{
    String scopeName;
    CStarScope parent;
    HashMap<String, Attributes> symbols = new HashMap<>();
    List<CStarScope> children = new ArrayList<>();
    int level;

    public CStarScope(String scopeName, int level){
        this.scopeName = scopeName;
        this.level = level;
    }
}
