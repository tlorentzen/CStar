package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class MultNode extends AstNode {
    private boolean parentheses = false;

    public boolean getParentheses() {
        return parentheses;
    }

    public void setParentheses(boolean parentheses) {
        this.parentheses = parentheses;
    }

     public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
