package com.p4.parser.nodes;

public class PinDclNode extends DclNode<Integer> {
    public PinDclNode(String id){
        super(id);
        this.type = "pin";
    }
}
