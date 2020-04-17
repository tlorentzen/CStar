package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;
import org.antlr.v4.runtime.CommonToken;

public class SubNode extends AstNode{
    CommonToken token = new CommonToken(10);

    public void accept(SemanticsVisitor visitor) {
        visitor.visit(this);
    }
}
