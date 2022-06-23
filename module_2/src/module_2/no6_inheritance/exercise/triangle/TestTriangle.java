package module_2.no6_inheritance.exercise.triangle;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("side1 = ");
        Triangle triangle = new Triangle();
        triangle.setSide1(sc.nextDouble());
        System.out.print("side2 = ");
        triangle.setSide2(sc.nextDouble());
        System.out.print("side3 = ");
        triangle.setSide3(sc.nextDouble());
        System.out.print("color = ");
        sc.nextLine();
        triangle.setColor(sc.nextLine());
        System.out.println(triangle);
    }
}
