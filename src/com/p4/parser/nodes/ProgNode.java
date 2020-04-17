package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;

public class ProgNode extends AstNode{

    public void accept(SemanticsVisitor visitor) {
        visitor.visitProg(this);
    }
}
