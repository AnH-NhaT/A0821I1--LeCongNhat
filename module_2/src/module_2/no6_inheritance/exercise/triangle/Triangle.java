package module_2.no6_inheritance.exercise.triangle;

import module_2.no6_inheritance.practice.Shape;

public class Triangle extends Shape {
    private double side1 = 1, side2 = 1, side3 = 1;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String color, boolean filled) {
        super(color, filled);
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        double area = 0;
        double p = (side1 + side2 + side3) / 2;
        area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        return area;
    }

    public double getPerimeter() {
        return side1 + side3 + side2;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1= " + side1 +
                ", side2= " + side2 +
                ", side3= " + side3 +
                "}\n" + "color= " + getColor() +
                ", peri= " + getPerimeter() +
                ", area= " + getArea();
    }
}
