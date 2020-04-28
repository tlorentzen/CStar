package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;
import org.antlr.v4.runtime.CommonToken;

public class ModNode extends AstNode {
    CommonToken token = new CommonToken(15);

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
