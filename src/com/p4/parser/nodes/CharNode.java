package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class CharNode extends LiteralNode<Character> {

    public CharNode(Character value, Boolean isNegative) {
        super(value, isNegative);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
