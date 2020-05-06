package com.p4.symbols;

public class Attributes{
    private String kind;
    private String variableType;
    private String scope;

    public Attributes() {

    }
    public Attributes(String kind, String variableType) {
        this.kind = kind;
        this.variableType = variableType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
