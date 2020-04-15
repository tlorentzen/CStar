package com.p4.parser.nodes;

import com.p4.parser.Parameters;

public class ArrayNode extends AstNode implements Parameters {
    String id;
    String Type;
    boolean isNegative;

    public ArrayNode(String id, String type){
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
}
