package com.p4.parser.nodes;

import com.p4.parser.INodeVisitor;
import com.p4.parser.Parameters;

public class ArrayNode extends AstNode implements Parameters {
    String id;
    boolean isNegative;

    public ArrayNode(String id, String type){
        this.id = id;
        switch(type){
            case "integer":
                this.type = "int";
                break;
            case "decimal":
                this.type = "float";
                break;
            case "character":
                this.type = "char";
                break;
            default:
                this.type = type;
                break;
        }
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
