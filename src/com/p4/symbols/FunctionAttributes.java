package com.p4.symbols;

import java.util.*;

public class FunctionAttributes extends Attributes {
    private ArrayList<String> parameters;

    public FunctionAttributes (String kind, String variableType) {
        super(kind, variableType);
    }

    public ArrayList<String> getParameters() {
        return parameters;
    }

    public void addParameter(String parameter) {
        parameters.add(parameter);
    }
}
