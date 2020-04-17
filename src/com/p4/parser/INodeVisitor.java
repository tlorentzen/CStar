package com.p4.parser;

import com.p4.parser.nodes.AstNode;
import com.p4.parser.nodes.INode;

public interface INodeVisitor {
    void visitChildren(AstNode node);

    void visit(INode node);
}
