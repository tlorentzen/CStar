package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class NumberNode extends LiteralNode<Long>{
    public boolean parentheses = false;
    public NumberNode(Long value, Boolean isNegative) {
        super(value, isNegative);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
