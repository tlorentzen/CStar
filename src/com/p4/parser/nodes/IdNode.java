package com.p4.parser.nodes;

import com.p4.parser.Parameters;

public class IdNode extends AstNode implements Parameters {
    public String id;
    public String Type;
    boolean IsNegative;

    public IdNode(String id){
        this.id = id;
    }
    public IdNode(String id, String type){
        this.id = id;
        this.type = type;
    }
}
