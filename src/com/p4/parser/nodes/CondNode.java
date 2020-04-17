package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class CondNode extends AstNode{
    private String operator;

    public String getOperator() { return operator; }

    public void setOperator(String operator) { this.operator = operator; }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
