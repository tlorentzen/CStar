package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class StringNode extends LiteralNode<String> {

    public StringNode (String value) {
        super(value, false);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
