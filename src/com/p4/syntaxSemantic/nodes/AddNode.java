package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class AddNode extends ExpressionNode {
    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
