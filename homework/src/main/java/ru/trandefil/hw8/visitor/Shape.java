package ru.trandefil.hw8.visitor;

public interface Shape {

    void draw(int x, int y);

    double getArea();

    double getPerimeter();

    void move(int x, int y);

    String accept(Visitor visitor);
}
