package ru.trandefil.hw8.visitor;

public class Rectangle implements Shape{
    @Override
    public void draw(int x, int y) {
        // draw a rectangle
    }

    @Override
    public double getArea() {
        //calculate area rectangle
        return 10;
    }

    @Override
    public double getPerimeter() {
        // calculate rectangle perimeter
        return 10;
    }

    @Override
    public void move(int x, int y) {
        // draw rectangle with another x, y coordinates
    }


    @Override
    public String accept(Visitor visitor) {
        return visitor.visitRectangle(this);
    }
}
