package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class BlkNode extends AstNode {

    String parentID = "";

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }
    
    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
