package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class IterativeNode extends AstNode{
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getNodeHash() {
        return "IterativeNode-" + super.getNodeHash();
    }
}
