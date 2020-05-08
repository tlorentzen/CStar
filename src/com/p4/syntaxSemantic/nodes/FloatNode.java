package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class FloatNode extends LiteralNode<Float> {
    public FloatNode(float value, boolean isNegative) {
        super(value, isNegative);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
