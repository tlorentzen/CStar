package com.p4.parser.nodes;

import com.p4.parser.visitors.INodeVisitor;

public class StmtNode extends AstNode{
    // stmt: ( assign SEMICOLON | expr SEMICOLON | func_call SEMICOLON | selection | iterative )+;
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}