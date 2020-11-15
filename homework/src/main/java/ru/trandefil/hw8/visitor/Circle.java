package ru.trandefil.hw8.visitor;

public class Circle  implements Shape{
    @Override
    public void draw(int x, int y) {
        // draw a circle
    }

    @Override
    public double getArea() {
        //calculate area circle
        return 10;
    }

    @Override
    public double getPerimeter() {
        // calculate circle perimeter
        return 10;
    }

    @Override
    public void move(int x, int y) {
        // draw circle with another x, y coordinates
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }
}
