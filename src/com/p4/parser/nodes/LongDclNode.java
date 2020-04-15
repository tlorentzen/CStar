package com.p4.parser.nodes;

public class LongDclNode extends DclNode<Long>{

    public LongDclNode(String id){
        super(id);
        this.type = "long";
    }
}
