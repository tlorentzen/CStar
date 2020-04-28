package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class SmallNode extends LiteralNode<Byte>{
    public SmallNode(Byte value, Boolean isNegative) {
        super(value, isNegative);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
