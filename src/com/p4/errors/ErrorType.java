package com.p4.errors;

public enum ErrorType {
    TYPE_ERROR("E1"),
    DUPLICATE_VARS("E2"),
    ZERO_DIVISION("E3"),
    SOURCE_FILE_DOES_NOT_EXIST("E100"),
    PARSER_ERROR("E102"),
    LEXER_ERROR("E101"),
    WRONG_EXTENSION("E103"),
    PARAMETER_ERROR("E200"),
    GENERAL_WARNING("W1"),
    UNDECLARED_FUNCTION_WARNING("W2"),
    INFORMATION("I1"),
    VOID_ASSIGN("E201"),
    ARDUINO_NOT_FOUND("E207"),
    ARDUINO_CLI_MISSING("W100"),
    MISSING_ARDUINO_FUNCTION("W300");

    private final String code;

    ErrorType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
