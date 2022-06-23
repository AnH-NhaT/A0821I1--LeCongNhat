package module_2.no3_array_and_method.exercise;

import java.util.Scanner;

public class SumDiagonalLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row and collum: ");
        int row_col = scanner.nextInt();
        int arr2d[][] = new int[row_col][row_col];
        for (int i = 0; i < row_col; i++) {
            for (int j = 0; j < row_col; j++) {
                System.out.printf("arr2d[%d][%d] = ", i, j);
                arr2d[i][j] = scanner.nextInt();
            }
        }
        int diagonal1 = 0;
        int diagonal2 = 0;
        for (int i = 0; i < row_col; i++) {
            for (int j = 0; j < row_col; j++) {
                System.out.print(arr2d[i][j] + " ");
                if (i == j)
                    diagonal1 += arr2d[i][j];
            }
            System.out.println();
        }
        int temp = row_col - 1;
        for (int i = 0; i < row_col; i++) {
            diagonal2 += arr2d[i][temp];
            // because the elements' order of array doesn't change
            temp--;
        }
        System.out.println("Sum of two diagonal lines = " + (diagonal2 + diagonal1));
    }
}
