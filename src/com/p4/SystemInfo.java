package com.p4;

//https://mkyong.com/java/how-to-detect-os-in-java-systemgetpropertyosname/
public class SystemInfo {
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isMac() {
        return (OS.contains("mac"));
    }

    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }

    public static String getOsString() {
        if (isWindows()) {
            return "win";
        }
        else if (isMac()) {
            return "mac";
        }
        else if (isUnix()) {
            return "unix";
        }
        else {
            return "";
        }
    }
}
