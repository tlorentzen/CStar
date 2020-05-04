package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class SubNode extends AstNode{
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
