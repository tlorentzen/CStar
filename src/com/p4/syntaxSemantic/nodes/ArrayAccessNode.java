package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

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
