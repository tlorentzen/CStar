package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class IterativeNode extends AstNode {
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getNodeHash() {
        return "IterativeNode-" + super.getNodeHash();
    }
}
