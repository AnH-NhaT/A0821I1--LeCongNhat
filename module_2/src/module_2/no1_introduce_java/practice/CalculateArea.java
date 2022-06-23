package module_2.no1_introduce_java.practice;

import java.util.Scanner;

public class CalculateArea {

    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter width: ");
        width = scanner.nextFloat();
        System.out.print("enter height: ");
        height = scanner.nextFloat();
        float area = width * height;
        System.out.println("area = " + area);
    }
}
