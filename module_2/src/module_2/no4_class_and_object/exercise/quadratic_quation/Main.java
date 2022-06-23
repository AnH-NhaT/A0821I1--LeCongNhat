package module_2.no4_class_and_object.exercise.quadratic_quation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        a = sc.nextDouble();
        System.out.print("Enter b: ");
        b = sc.nextDouble();
        System.out.print("Enter c: ");
        c = sc.nextDouble();
        Calculation calculation = new Calculation(a, b, c);
        calculation.result();
    }
}
