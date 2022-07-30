package com.jdps.lsp;

/*
Created by J.Fırat ©
    Date : 30.07.2022
    Time : 23:45
*/
//LSP - Liskov Substitution Principle
interface Shape {
    double area();
    double perimeter();
    double volume();
}

class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }

    @Override
    public double volume() {
        return 0;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public double volume() {
        return 0;
    }
}
public class LSPDemo {
    public static void main(String[] args) {
        Shape square = new Square(10);
        Shape rectangle = new Rectangle(10, 20);
        System.out.println(square.area());
        System.out.println(rectangle.area());
        System.out.println(square.perimeter());
        System.out.println(rectangle.perimeter());
        System.out.println(square.volume());
        System.out.println(rectangle.volume());
    }
}