package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class CharDclNode extends DclNode<Character> {
    public CharDclNode(String id){
        super(id);
        this.type = "character";
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
