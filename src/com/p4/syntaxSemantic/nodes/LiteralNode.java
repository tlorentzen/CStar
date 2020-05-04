package com.p4.syntaxSemantic.nodes;

abstract class LiteralNode<T> extends AstNode {
    private T value;
    private Boolean isNegative;

    public LiteralNode(T value, Boolean isNegative) {
        this.value = value;
        this.isNegative = isNegative;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Boolean getIsNegative() {
        return isNegative;
    }

    public void setIsNegative(boolean isNegative) {
        this.isNegative = isNegative;
    }
}

