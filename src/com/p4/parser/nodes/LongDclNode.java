package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class LongDclNode extends DclNode<Long>{

    public LongDclNode(String id){
        super(id);
        this.type = "long";
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
