package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;

public class FuncDclNode extends AstNode{
    private String id;
    private String returnType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReturnType() {
        return returnType;
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
