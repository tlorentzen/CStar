package com.p4.syntaxSemantic.nodes;

public abstract class DclNode<T> extends AstNode {
    private String id;

    public DclNode(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
