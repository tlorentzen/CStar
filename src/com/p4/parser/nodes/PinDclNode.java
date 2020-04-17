package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class PinDclNode extends DclNode<Integer> {
    public PinDclNode(String id){
        super(id);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
