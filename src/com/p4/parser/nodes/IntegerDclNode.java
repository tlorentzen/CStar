package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class IntegerDclNode extends DclNode<Integer> {
    public IntegerDclNode(String id){
        super(id);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
