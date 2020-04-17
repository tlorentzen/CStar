package com.p4.parser.nodes;

import com.p4.parser.SemanticsVisitor;

public interface INode {
    public void accept(SemanticsVisitor visitor);
}
