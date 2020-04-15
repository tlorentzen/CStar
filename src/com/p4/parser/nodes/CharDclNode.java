package com.p4.parser.nodes;

public class CharDclNode extends DclNode<Character> {
    public CharDclNode(String id){
        super(id);
        this.type = "character";
    }
}
