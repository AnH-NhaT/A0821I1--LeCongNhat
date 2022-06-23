package module_2.no15_exception_debug.exercise;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalTriangleException {
        int x, y, z;
        Scanner scanner = new Scanner(System.in);
        System.out.println("x= ");
        x = scanner.nextInt();
        System.out.println("y= ");
        y = scanner.nextInt();
        System.out.println("z= ");
        z = scanner.nextInt();
        try {
            Triangle triangle = new Triangle(x, y, z);
            System.out.println(triangle.perimeter());
        } catch (IllegalTriangleException e) {
            System.out.print(e.getMessage());
        }
    }
}
