package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class ArrayAccessNode extends AstNode {

    public boolean isNegative;

    public ArrayAccessNode(Boolean isNegative){
        this.isNegative = isNegative;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
