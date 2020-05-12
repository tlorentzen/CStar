package com.p4;

public class Board {
    private String name = "";
    private String core = "";
    private String port = "";
    private String fqbn = "";

    public Board(String name, String core, String port, String fqbn) {
        this.name = name;
        this.core = core;
        this.port = port;
        this.fqbn = fqbn;
    }

    public String getName() {
        return name;
    }

    public String getCore() {
        return core;
    }

    public String getPort() {
        return port;
    }

    public String getFqbn() {
        return fqbn;
    }
}
