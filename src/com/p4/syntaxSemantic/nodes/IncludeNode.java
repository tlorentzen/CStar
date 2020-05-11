package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class IncludeNode extends AstNode {
    private String include;

    public IncludeNode(String include) {
        this.include = include;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
