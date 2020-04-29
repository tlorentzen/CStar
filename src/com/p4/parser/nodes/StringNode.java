package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class StringNode extends AstNode {
    String value;

    public StringNode (String value) {
       this.value = value;
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
