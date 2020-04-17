package com.p4.errors;

public enum ErrorType {
    E_TYPE_ERROR("E1"),
    DUPLICATE_VARS("E2");

    private final String code;

    ErrorType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}

