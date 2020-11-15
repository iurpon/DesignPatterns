package ru.trandefil.hw8.visitor;

public class Triangle implements Shape{
    @Override
    public void draw(int x, int y) {
        // draw a triangle
    }

    @Override
    public double getArea() {
        //calculate area triangle
        return 10;
    }

    @Override
    public double getPerimeter() {
        // calculate triangle perimeter
        return 10;
    }

    @Override
    public void move(int x, int y) {
        // draw triangle with another x, y coordinates
    }


    @Override
    public String accept(Visitor visitor) {
        return visitor.visitTriangle(this);
    }
}
