package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class ConstantNode extends LiteralNode<String> {
    public ConstantNode(String value, boolean isNegative) {
        super(value, isNegative);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
