package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class AssignNode extends AstNode {
    public AssignNode(){}

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
