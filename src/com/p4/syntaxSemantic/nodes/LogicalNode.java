package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;
import org.antlr.v4.runtime.CommonToken;

public class LogicalNode extends AstNode {
    private CommonToken token;
    private boolean parentheses;

    public int getToken() {
        return token.getType();
    }

    public void setToken(int operator) {
        this.token = new CommonToken(operator);
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