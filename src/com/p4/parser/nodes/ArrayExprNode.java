package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class ArrayExprNode extends AstNode {

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
