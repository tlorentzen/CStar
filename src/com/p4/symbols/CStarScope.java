package com.p4.symbols;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CStarScope{
    String ScopeName;
    CStarScope parent;
    HashMap<String, Attributes> symbols = new HashMap<>();
    List<CStarScope> children = new ArrayList<>();

    public CStarScope(String scopeName){
        this.ScopeName = scopeName;
    }
}
