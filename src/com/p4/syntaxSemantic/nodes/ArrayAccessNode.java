package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class ArrayAccessNode extends AstNode {
    private boolean isNegative;

    public ArrayAccessNode(boolean isNegative){
        this.isNegative = isNegative;
    }

    public boolean getIsNegative() {
        return isNegative;
    }

    public void setIsNegative(boolean isNegative) {
        this.isNegative = isNegative;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
