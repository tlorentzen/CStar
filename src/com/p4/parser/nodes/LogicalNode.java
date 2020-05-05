package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class LogicalNode extends AstNode{
    private int operator = -1;
    public boolean parentheses = false;


    public int getOperator() { return operator; }

    public void setOperator(int operator) { this.operator = operator; }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}