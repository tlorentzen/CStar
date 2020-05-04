package com.p4.syntaxSemantic.nodes;

import com.p4.syntaxSemantic.visitors.INodeVisitor;
import com.p4.syntaxSemantic.Parameters;

public class ArrayNode extends AstNode implements Parameters {
    private String id;
    private boolean isNegative;

    public ArrayNode(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
