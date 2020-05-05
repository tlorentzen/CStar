package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class FuncCallNode extends AstNode {
    private boolean isNegative;

    //index 0 is ID, Everything that follows is parameter values
    public FuncCallNode(boolean isNegative) {
        this.isNegative = isNegative;
    }

    public boolean getIsNegative() {
        return isNegative;
    }

    public void setIsNegative(boolean isNegative) {
        this.isNegative = isNegative;
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
