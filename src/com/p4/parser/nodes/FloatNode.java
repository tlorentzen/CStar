package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class FloatNode extends LiteralNode<Float>{

    public FloatNode(Float value, Boolean isNegative) {
        super(value, isNegative);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
