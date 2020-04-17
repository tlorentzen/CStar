package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;

public class IterativeNode extends AstNode{

    public void accept(SemanticsVisitor visitor) {
        visitor.visit(this);
    }
}
