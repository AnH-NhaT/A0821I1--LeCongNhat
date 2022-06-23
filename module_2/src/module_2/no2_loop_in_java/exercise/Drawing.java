package module_2.no2_loop_in_java.exercise;

import java.util.Scanner;

public class Drawing {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            int n = 5;
            switch (choice) {
                case 1:
                    System.out.println("Draw the triangle");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i >= j)
                                System.out.print(" * ");
                            else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i > j)
                                System.out.print("   ");
                            else {
                                System.out.print(" * ");
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    for (int i = 0; i < n; i++) {
                        for (int j = n; j > 0; j--) {
                            if (i >= j)
                                System.out.print("   ");
                            else {
                                System.out.print(" * ");
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    for (int i = 0; i < n; i++) {
                        for (int j = n; j > 0; j--) {
                            if (i >= j - 1)
                                System.out.print(" * ");
                            else {
                                System.out.print("   ");
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    int h = n - 1;
                    int h2 = n - 1;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n * 2 - 1; j++) {
                            if (j < h || j > h2)
                                System.out.print("   ");
                            else {
                                System.out.print(" * ");
                            }
                        }
                        System.out.println("");
                        h--;
                        h2++;
                    }
                    break;
                case 2:
                    System.out.println("Draw the square");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 8; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println("");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
