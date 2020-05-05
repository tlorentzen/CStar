package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class NumberNode extends LiteralNode<Long> {
    private boolean parentheses = false;

    public NumberNode(Long value, Boolean isNegative) {
        super(value, isNegative);
    }

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
