package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;
import org.antlr.v4.runtime.CommonToken;

import java.util.ArrayList;

public class PrintNode extends AstNode {
    ArrayList<AstNode> formatString = new ArrayList<>();

    public void addToFormatString(AstNode node){
        formatString.add(node);
    }

    @Override
    public void accept(INodeVisitor visitor) {

        visitor.visit(this);
    }
}
