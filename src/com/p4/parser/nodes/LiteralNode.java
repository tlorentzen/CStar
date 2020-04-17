package com.p4.parser.nodes;

abstract class LiteralNode<T> extends AstNode{
    public T value;
    public Boolean isNegative;

    public LiteralNode(T value, Boolean isNegative){
        this.value = value;
        this.isNegative = isNegative;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
