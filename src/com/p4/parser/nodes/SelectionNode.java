package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class SelectionNode extends AstNode{
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getNodeHash() {
        return "SelectionNode-" + super.getNodeHash();
    }
}
