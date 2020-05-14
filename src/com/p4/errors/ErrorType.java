package com.p4.errors;

public enum ErrorType {
    TYPE_ERROR("E1"),
    DUPLICATE_VARS("E2"),
    ZERO_DIVISION("E3"),
    SOURCE_FILE_DOES_NOT_EXIST("E4"),
    LEXER_ERROR("E5"),
    PARSER_ERROR("E6"),
    WRONG_EXTENSION("E7"),
    PARAMETER_ERROR("E8"),
    VOID_ASSIGN("E9"),
    GENERAL_WARNING("W1"),
    UNDECLARED_FUNCTION_WARNING("W2"),
    INFORMATION("I1"),
    ARDUINO_NOT_FOUND("W3"),
    ARDUINO_CLI_MISSING("W4"),
    MISSING_ARDUINO_FUNCTION("W5"),
    ARDUINO_FUNCTION_IN_INTERVAL("E10");

    private final String code;

    ErrorType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
