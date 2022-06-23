package module_2.no5_access_modifier_static.practice.circle;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius * radius * 3.14;
    }
}
