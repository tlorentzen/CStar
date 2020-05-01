package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class ConstantNode extends LiteralNode<String>{
    public ConstantNode(String value, Boolean isNegative) {
        super(value, isNegative);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
