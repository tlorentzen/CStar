package com.p4.parser.nodes;

public class ArrayDclNode<T> extends DclNode<T> {
    public ArrayDclNode(String id) {
        super(id);
        this.type = "array";
    }
}
