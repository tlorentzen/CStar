package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class CommentNode extends AstNode{
    String comment;

    public CommentNode(String comment){
        this.comment = comment;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
