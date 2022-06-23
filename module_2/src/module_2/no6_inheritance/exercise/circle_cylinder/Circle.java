package module_2.no6_inheritance.exercise.circle_cylinder;

public class Circle {
    private double radius = 2;
    private String color = "blue";

    public Circle(float radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double area() {
        return radius * radius * Math.PI;
    }

    public String toString() {
        return "Color: " + color +
                "Radius = " + radius +
                "Area = " + area();
    }
}
