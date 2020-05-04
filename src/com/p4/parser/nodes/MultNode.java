package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;
import org.antlr.v4.runtime.CommonToken;

public class MultNode extends AstNode{
    public boolean parentheses = false;
    CommonToken token = new CommonToken(11);

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
