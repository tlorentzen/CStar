package com.p4.parser;

public enum CStarTypes {
    INTEGER(1), LONG_INTEGER(2), CHARACTER(3), DECIMAL(4), PIN(5);

    private final int id;

    CStarTypes(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
