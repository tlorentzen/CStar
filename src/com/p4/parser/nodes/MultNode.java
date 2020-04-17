package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;
import org.antlr.v4.runtime.CommonToken;

public class MultNode extends AstNode{
    CommonToken token = new CommonToken(11);

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}