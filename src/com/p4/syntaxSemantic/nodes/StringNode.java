package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class StringNode extends LiteralNode<String> {
    public StringNode (String value) {
        super(value, false);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
