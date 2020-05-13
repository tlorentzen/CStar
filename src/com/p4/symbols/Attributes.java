package com.p4.symbols;

public class Attributes{
    private String kind;
    private String variableType;
    private String scope;
    private int arrayLength;

    public Attributes(String kind, String variableType) {
        this.kind = kind;
        this.variableType = variableType;
    }

    public Attributes(String kind, String variableType, int arrayLength) {
        this.kind = kind;
        this.variableType = variableType;
        this.arrayLength = arrayLength;
    }

    public String getKind() {
        return kind;
    }

    public String getVariableType() {
        return variableType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getArrayLength() { return arrayLength; }
}
