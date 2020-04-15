package com.p4.parser.nodes;

abstract class LiteralNode<T> extends AstNode{
    public T Value;

    public LiteralNode(T value){
        Value = value;
    }

    public T getValue() {
        return Value;
    }

    public void setValue(T value) {
        Value = value;
    }
}
