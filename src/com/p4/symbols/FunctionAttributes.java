package com.p4.symbols;

import java.util.*;


public class FunctionAttributes extends Attributes {
    public ArrayList<Tuple> parameters = new ArrayList<>();
   // public Map<String, Attributes> parameters = new Map<>();

    public void addParameter(String id, Attributes parameterAttributes){
        Tuple tuple = new Tuple(id, parameterAttributes);
        parameters.add(tuple);
    }
}
