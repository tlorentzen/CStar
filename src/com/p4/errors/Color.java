package com.p4.errors;

// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
public enum Color {
    //Color end string, color reset
    RESET("\033[0m"),

    // Regular Colors. Normal color, no bold, background color etc.
    WHITE("\033[0;37m"),    // WHITE

    // Bold
    RED_BOLD("\033[1;31m"),     // RED
    YELLOW_BOLD("\033[1;33m"),  // YELLOW
    BLUE_BOLD("\033[1;34m");   // BLUE


    private final String code;

    Color(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
