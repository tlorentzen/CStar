package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;

public class IntegerDclNode extends DclNode<Integer> {
    public IntegerDclNode(String id){
        super(id);
        this.type = "integer";
    }

    public void accept(SemanticsVisitor visitor) {
        visitor.visit(this);
    }
}
