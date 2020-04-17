package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;

public class FuncCallNode extends AstNode{
    public Boolean isNegative;

    //index 0 is ID, Everything that follows is parameter values
    public FuncCallNode(Boolean isNegative){
        this.isNegative = isNegative;
    }

    public void accept(SemanticsVisitor visitor) {
        visitor.visit(this);
    }
}
