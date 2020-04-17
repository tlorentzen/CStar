package com.p4.parser.nodes;

public class FuncNode extends AstNode{
    public String id;
    public String returnType;

    public String getId() { return id; }

    public String getReturnType() {
        return returnType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
}
