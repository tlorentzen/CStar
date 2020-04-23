package com.p4.parser;

import com.p4.parser.nodes.AstNode;
import com.p4.parser.nodes.ProgNode;

public interface Visitor {
    AstNode VisitProgNode(ProgNode prognode);

}
