package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class ArrayAssignNode extends AstNode {
    public ArrayAssignNode(){}

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
