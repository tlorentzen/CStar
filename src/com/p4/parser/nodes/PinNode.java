package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class PinNode extends LiteralNode<Integer> {

    public PinNode(Integer value, Boolean isNegative) {
        super(value, isNegative);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
