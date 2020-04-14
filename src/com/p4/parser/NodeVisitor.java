package com.p4.parser;

public class NodeVisitor {
    public void visitChildren(AstNode node){
        for(AstNode child : node.children){
            child.accept(this);
        }
    }

    public void visit(AstNode node){}
}
