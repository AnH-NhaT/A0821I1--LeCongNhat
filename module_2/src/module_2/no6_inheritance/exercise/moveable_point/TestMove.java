package module_2.no6_inheritance.exercise.moveable_point;

import java.util.Arrays;
import java.util.Scanner;

public class TestMove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("x= ");
        MovablePoint movablePoint = new MovablePoint();
        movablePoint.setX(scanner.nextFloat());
        System.out.print("y= ");
        movablePoint.setY(scanner.nextFloat());
        System.out.print("xSpeed= ");
        movablePoint.setXSpeed(scanner.nextFloat());
        System.out.print("ySpeed= ");
        movablePoint.setYSpeed(scanner.nextFloat());
        System.out.println(movablePoint);
        float[] arr = movablePoint.move();
        System.out.println(Arrays.toString(arr));
    }


}
