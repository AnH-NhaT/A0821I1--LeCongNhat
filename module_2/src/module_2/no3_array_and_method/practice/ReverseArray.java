package module_2.no3_array_and_method.practice;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        int n;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter amount of array' element: ");
            n = scanner.nextInt();
            if (n > 20 || n < 1) {
                System.out.print("MAX is 20 elements");
                break;
            }
            int[] arr = new int[n];
//        input array
            for (int i = 0; i < n; i++) {
                System.out.print("array [" + i + "] = ");
                arr[i] = scanner.nextInt();
            }
//         print array
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
//        reverse array
            for (int i = 0; i < n / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[n - 1 - i];
                arr[n - 1 - i] = temp;
            }
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } while (n < 21 && n > 0);
    }
}
