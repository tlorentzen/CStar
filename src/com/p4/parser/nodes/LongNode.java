package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class LongNode extends LiteralNode<Long> {

    public LongNode(Long value, Boolean isNegative) {
        super(value, isNegative);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
