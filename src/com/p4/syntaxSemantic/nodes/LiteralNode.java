package com.p4.syntaxSemantic.nodes;

abstract class LiteralNode<T> extends AstNode {
    private T value;
    private boolean isNegative;

    public LiteralNode(T value, boolean isNegative) {
        this.value = value;
        this.isNegative = isNegative;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean getIsNegative() {
        return isNegative;
    }

    public void setIsNegative(boolean isNegative) {
        this.isNegative = isNegative;
    }
}

