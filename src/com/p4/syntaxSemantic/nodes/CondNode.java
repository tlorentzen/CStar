package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;
import org.antlr.v4.runtime.CommonToken;

public class CondNode extends AstNode {
    private CommonToken token;

    public int getToken() {
        return token.getType();
    }

    public void setToken(int operator) {
        this.token = new CommonToken(operator);
    }

    @Override
    public void accept(INodeVisitor visitor) {
            visitor.visit(this);
    }
}
