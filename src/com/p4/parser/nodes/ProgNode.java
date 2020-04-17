package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class ProgNode extends AstNode{

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
