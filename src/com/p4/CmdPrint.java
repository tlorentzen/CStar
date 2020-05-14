package com.p4;

public class CmdPrint {

    // Ansi colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private static String setColor(String color) {
        if (!SystemInfo.isWindows()) {
            return color;
        }
        return "";
    }

    public static void print(String text, boolean skipNewline) {
        if (skipNewline) {
            System.out.print(text);
        }
        else {
            System.out.println(text);
        }
    }

    public static void printOk() {
        print(setColor(ANSI_GREEN)+"OK!\n"+setColor(ANSI_RESET), true);
    }

    public static void printFailed() {
        print(setColor(ANSI_RED)+"Failed!\n"+setColor(ANSI_RESET), true);
    }
}
