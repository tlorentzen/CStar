package com.p4;

public class Board {
    public String name = "";
    public String core = "";
    public String port = "";
    public String fqbn = "";

    public void printInfo(){
        System.out.println("Board: "+this.name+" - "+this.port);
        System.out.println();
    }
}
