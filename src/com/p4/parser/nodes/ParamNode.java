package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class ParamNode extends AstNode {
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
