package com.p4.parser;

public abstract class NodeVisitor {
    void visitChildren(AstNode node){
        for(AstNode child : node.children){
            child.accept(this);
        }
    }

    void visit(AstNode node){
        node.accept(this);
    }
}
