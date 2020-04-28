package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class BooleanDclNode extends DclNode<Boolean>{
    public BooleanDclNode(String id){
        super(id);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
