package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class ArrayAccessNode extends AstNode {
    public ArrayAccessNode(){}

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
