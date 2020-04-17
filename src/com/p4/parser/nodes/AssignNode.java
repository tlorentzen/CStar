package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;

public class AssignNode extends AstNode {
    public AssignNode(){}

    @Override
    public void accept(SemanticsVisitor visitor) {
        visitor.visitAssign(this);
    }
}
