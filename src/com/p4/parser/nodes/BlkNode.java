package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class BlkNode extends AstNode{
    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
    //blk: LEFT_BRACE ( dcl | stmt | return_exp)* RIGHT_BRACE;
}
