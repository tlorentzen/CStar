package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;
import org.antlr.v4.runtime.CommonToken;

public class DivNode extends AstNode{

    CommonToken token = new CommonToken(12);

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
