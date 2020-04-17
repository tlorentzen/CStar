package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;

public class ArrayAssignNode extends AstNode {
    public ArrayAssignNode(){}

    @Override
    public void accept(SemanticsVisitor visitor) {
        visitor.visit(this);
    }
}
