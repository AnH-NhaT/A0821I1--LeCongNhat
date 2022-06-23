package module_2.no3_array_and_method.exercise;

import java.util.Scanner;

public class MaxInArray2d {
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
        int max = arr2d[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr2d[i][j] + " ");
                if (arr2d[i][j] > max)
                    max = arr2d[i][j];
            }
            System.out.println();
        }
        System.out.println("max = " + max);
    }
}
