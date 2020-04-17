package com.p4.parser;

import com.p4.parser.nodes.AstNode;

public interface TNode {
    AstNode accept(Visitor visitor);
}
