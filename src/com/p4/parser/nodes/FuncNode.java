package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

public class FuncNode extends AstNode{
    public String id;
    public String returnType;

    public String getId() { return id; }

    public String getReturnType() {
        return returnType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Overrides the getNodeHash method in AstNode, so that the hash can be used to find the scope
     * @return the hash of the FuncNode
     */
    @Override
    public String getNodeHash() {
        return "FuncNode-" + id;
    }
}
