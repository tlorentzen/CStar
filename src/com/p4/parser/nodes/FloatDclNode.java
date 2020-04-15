package com.p4.parser.nodes;

public class FloatDclNode extends DclNode<Float>{
    public FloatDclNode(String id){
        super(id);
        this.type = "decimal";
    }
}
