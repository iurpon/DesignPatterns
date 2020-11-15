package ru.trandefil.hw8.visitor;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(),new Rectangle(), new Triangle()};
        Visitor visitor = new ShapeVolumeVisitor(10);
        for(Shape shape: shapes){
            System.out.println("Shape volume is " + shape.accept(visitor));
        }
    }
}
