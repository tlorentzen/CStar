package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;

import java.util.ArrayList;
import java.util.List;

public class ArrayExprNode extends AstNode {
    public List<AstNode> Literals;

    public ArrayExprNode(){
        List<AstNode> Literals = new ArrayList<AstNode>();
    }

    public List<AstNode> getLiterals() {
        return Literals;
    }

    public void setLiterals(List<AstNode> literals) {
        Literals = literals;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
