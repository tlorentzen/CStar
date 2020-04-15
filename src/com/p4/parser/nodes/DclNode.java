package com.p4.parser.nodes;

public abstract class DclNode<T> extends AstNode {
    public String id;
    public String type;
    T value;

    public DclNode(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
