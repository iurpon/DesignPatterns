package ru.trandefil.hw8.visitor;

public interface Visitor {

    String visitTriangle(Triangle triangle);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);
}
