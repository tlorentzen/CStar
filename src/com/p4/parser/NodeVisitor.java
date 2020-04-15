package com.p4.parser;

public interface NodeVisitor {
    void visitChildren(AstNode node);

    void visit(AstNode node);

}
