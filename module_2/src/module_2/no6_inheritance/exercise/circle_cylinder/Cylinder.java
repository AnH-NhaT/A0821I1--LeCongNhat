package module_2.no6_inheritance.exercise.circle_cylinder;

import java.util.Scanner;

public class Cylinder extends Circle {
    private double height = 5;

    public Cylinder(float radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public Cylinder() {
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double volume() {
        return area() * height;
    }

    @Override
    public String toString() {
        return "\nColor: " + getColor() +
                "\nRadius = " + getRadius() +
                "\nArea = " + area() +
                "\nVolume = " + volume();
    }


    public static void main(String[] args) {
        Cylinder geo = new Cylinder();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        geo.setRadius(sc.nextDouble());
        System.out.print("Enter height: ");
        geo.setHeight(sc.nextDouble());

        System.out.println(geo.toString());
    }
}
