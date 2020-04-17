package com.p4.tgl;

public class Circle implements Shape {

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }

    public String toString() {
        return "Im a circle!";
    }
}
