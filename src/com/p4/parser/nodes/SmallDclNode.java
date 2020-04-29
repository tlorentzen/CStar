package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class SmallDclNode extends DclNode<Byte>{
    public SmallDclNode(String id){
        super(id);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
