package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;

public class FloatNode extends LiteralNode<Float>{

    public FloatNode(Float value, Boolean isNegative) {
        super(value, isNegative);
    }

    public void accept(SemanticsVisitor visitor) {
        visitor.visitFloat(this);
    }
}
