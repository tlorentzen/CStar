package com.p4.symbols;

public class Tuple {
    String id;
    Attributes attributes;

    public Tuple (String id, Attributes attributes) {
        this.id = id;
        this.attributes = attributes;
    }
    
    public String getId(){
        return id;
    }
    
    public Attributes getAttributes(){
        return attributes;
    }
}
