package module_2.no3_array_and_method.exercise;

import java.util.Scanner;

public class MinInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter quantity of elements: ");
        int n = scanner.nextInt();
        int i = 0;
        int[] arr = new int[n];
        while (i < n) {
            System.out.printf("element %d = ", i);
            arr[i] = scanner.nextInt();
            i++;
        }
        int min = arr[0];
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
            if (arr[j] < min)
                min = arr[j];
        }
        System.out.println("\nMin = " + min);
    }
}
