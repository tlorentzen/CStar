package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;

public class LongNode extends LiteralNode<Long> {

    public LongNode(Long value, Boolean isNegative) {
        super(value, isNegative);
    }

    public void accept(SemanticsVisitor visitor) {
        visitor.visit(this);
    }
}
