package module_2.no7_abstract_class_and_interface.practice.p2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        CircleComparable[] circles = new CircleComparable[6];
        circles[0] = new CircleComparable(3.6);
        circles[1] = new CircleComparable(3.1, "indigo", false);
        circles[2] = new CircleComparable(3.1, "indigo", false);
        circles[3] = new CircleComparable();
        circles[4] = new CircleComparable(1.5, "indigo", false);
        circles[5] = new CircleComparable(4.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (CircleComparable circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (CircleComparable circle : circles) {
            System.out.println(circle);
        }
    }
}
