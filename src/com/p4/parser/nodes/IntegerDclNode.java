package com.p4.parser.nodes;

public class IntegerDclNode extends DclNode<Integer> {
    public IntegerDclNode(String id){
        super(id);
        this.type = "integer";
    }
}
