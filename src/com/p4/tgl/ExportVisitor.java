package com.p4.tgl;

public class ExportVisitor implements Visitor {

    @Override
    public String visitCircle(Circle circle) {
        System.out.println(circle.toString());
        return circle.toString();
    }

}
