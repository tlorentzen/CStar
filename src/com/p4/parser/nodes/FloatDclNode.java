package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;

public class FloatDclNode extends DclNode<Float>{
    public FloatDclNode(String id){
        super(id);
        this.type = "decimal";
    }

    @Override
    public void accept(SemanticsVisitor visitor) {
        visitor.visit(this);
    }
}
