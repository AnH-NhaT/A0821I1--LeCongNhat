package module_2.no3_array_and_method.exercise;

import java.util.Scanner;

public class SumOfCollum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row: ");
        int row = scanner.nextInt();
        System.out.print("Enter collum: ");
        int col = scanner.nextInt();
        int arr2d[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("arr2d[%d][%d] = ", i, j);
                arr2d[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Enter the collum' position needed to calculate the sum: ");
        int position = scanner.nextInt();
        if (position < 0 || position >= row * col)
            System.out.println("There's no this collum!");
        else {
            int sum = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (j == position)
                        sum += arr2d[i][j];
                }
            }
            System.out.printf("Sum of collum'%d' = %d", position, sum);
        }
    }
}
