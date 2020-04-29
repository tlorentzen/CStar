package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class BooleanNode extends LiteralNode<Boolean>{
    public BooleanNode(Boolean value, Boolean isNegative) {
        super(value, isNegative);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
