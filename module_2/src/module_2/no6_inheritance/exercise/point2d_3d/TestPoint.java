package module_2.no6_inheritance.exercise.point2d_3d;

import java.util.Arrays;
import java.util.Scanner;

public class TestPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("X = ");
        Point3D point3D = new Point3D();
        point3D.setX(scanner.nextFloat());
        System.out.print("Y = ");
        point3D.setY(scanner.nextFloat());
        System.out.print("Y = ");
        point3D.setZ(scanner.nextFloat());
        System.out.println(point3D);

        float[] test = point3D.getXYZ();
        System.out.println(Arrays.toString(test));
    }
}
