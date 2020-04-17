package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;

public class ArrayDclNode<T> extends DclNode<T> {
    public ArrayDclNode(String id) {
        super(id);
        this.type = "array";
    }

    @Override
    public void accept(SemanticsVisitor visitor) {
        visitor.visit(this);
    }
}
