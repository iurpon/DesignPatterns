package ru.trandefil.hw8.visitor;

public class ShapeVolumeVisitor implements Visitor {

    private int height;

    @Override
    public String visitTriangle(Triangle triangle) {

        return String.valueOf(triangle.getArea() * height);
    }

    @Override
    public String visitCircle(Circle circle) {
        return String.valueOf(circle.getArea() * height);
    }

    @Override
    public String visitRectangle(Rectangle rectangle) {
        return String.valueOf(rectangle.getArea() * height);
    }

    public ShapeVolumeVisitor(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
