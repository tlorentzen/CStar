package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;
import org.antlr.v4.runtime.CommonToken;

public class SubNode extends AstNode{
    CommonToken token = new CommonToken(10);

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
