package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class IntervalNode extends AstNode{
    private String leftBracket;
    private String rightBracket;

    public String getLeftBracket() { return leftBracket; }

    public String getRightBracket() { return rightBracket; }

    public void setLeftBracket(String leftBracket) { this.leftBracket = leftBracket; }

    public void setRightBracket(String rightBracket) { this.rightBracket = rightBracket; }

    @Override
    public void accept(INodeVisitor visitor) {visitor.visit(this);}
}
