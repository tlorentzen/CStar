package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;

public class PinDclNode extends DclNode<Integer> {
    public PinDclNode(String id){
        super(id);
        this.type = "pin";
    }

    public void accept(SemanticsVisitor visitor) {
        visitor.visit(this);
    }
}
