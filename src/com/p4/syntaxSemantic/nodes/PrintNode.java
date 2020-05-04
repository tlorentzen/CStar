package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;
import java.util.ArrayList;

public class PrintNode extends AstNode {
    private ArrayList<AstNode> formatString = new ArrayList<>();

    public ArrayList<AstNode> getFormatString() {
        return formatString;
    }

    public void addToFormatString(AstNode node) {
        formatString.add(node);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
