package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class ProgNode extends AstNode{

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
