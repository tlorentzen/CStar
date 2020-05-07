package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.AstTreeVisitor;
import com.p4.syntaxSemantic.visitors.INodeVisitor;
import java.util.ArrayList;
import java.util.List;

public abstract class AstNode {
    public List<AstNode> children = new ArrayList<>();
    public int lineNumber = 0;
    public String type;

    public List<AstNode> getChildren() { 
        return children; 
    }

    //Gets the unique hash code for the specific node
    public String getNodeHash() {
        return String.valueOf(this.hashCode());
    }

    public abstract void accept(INodeVisitor visitor);

    //todo slet?
    public void accept(AstTreeVisitor visitor) {
        visitor.visit(0,this);
    }
}
