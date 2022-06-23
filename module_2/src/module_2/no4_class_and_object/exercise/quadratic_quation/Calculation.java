package module_2.no4_class_and_object.exercise.quadratic_quation;

import java.util.Scanner;

public class Calculation {
    double a, b, c, x1, x2;

    public Calculation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    protected double delta() {
        return this.b * this.b - (4 * this.a * this.c);
    }

    protected void result() {
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình vô nghiệm!");
            } else {
                System.out.println("Phương trình có một nghiệm: "
                        + "x = " + (-c / b));
            }
            return;
        }
        if (delta() > 0) {
            x1 = (float) ((-b + Math.sqrt(delta())) / (2 * a));
            x2 = (float) ((-b - Math.sqrt(delta())) / (2 * a));
            System.out.println("Phương trình có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2);
        } else if (delta() == 0) {
            x1 = (-b / (2 * a));
            System.out.println("Phương trình có nghiệm kép: "
                    + "x1 = x2 = " + x1);
        } else {
            System.out.println("Phương trình vô nghiệm!");
        }
    }
}
