package com.p4.parser.nodes;


import com.p4.parser.AstTreeVisitor;

import java.util.ArrayList;
import java.util.List;

public class AstNode {
    public List<AstNode> children = new ArrayList<>();

    public List<AstNode> getChildren() { return children; }
    public void setChildren(List<AstNode> children) { this.children = children; }

    public void accept(AstTreeVisitor visitor){
        visitor.visit(0,this);
    }

    public String type;
}
