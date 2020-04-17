package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class FloatDclNode extends DclNode<Float>{
    public FloatDclNode(String id){
        super(id);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
