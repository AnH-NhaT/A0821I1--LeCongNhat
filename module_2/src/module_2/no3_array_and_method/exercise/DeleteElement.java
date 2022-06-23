package module_2.no3_array_and_method.exercise;

import java.util.Scanner;

public class DeleteElement {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int value, temp = 0;
        boolean check = true;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 3, 6, 9, 3, 5};
        int[] new_arr = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\nInput a number you wanna delete: ");
        value = scanner.nextInt();
        int[] assign = removeOne(arr, value);
        for (int i = 0; i < assign.length; i++) {
            System.out.print(assign[i] + " ");
        }

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == value) {
//                temp = i;
//                check = false;
//                break;
//            }
//        }
//        if (check)
//            System.out.println("The number you enter has no in this array!");
//        else {
//            for (int i = 0; i < temp; i++) {
//                new_arr[i] = arr[i];
//            }
//            for (int i = temp; i < new_arr.length; i++) {
//                new_arr[i] = arr[i + 1];
//            }
//            for (int i = 0; i < new_arr.length; i++) {
//                System.out.print(new_arr[i] + " ");
//            }
//        }

    }

    public static int[] removeOne(int[] arr, int value) {
        int temp = 0;
        boolean check = true;
        int[] new_arr = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                temp = i;
                check = false;
                break;
            }
        }
        if (check) {
            return arr;
        } else {
            for (int i = 0; i < temp; i++) {
                new_arr[i] = arr[i];
            }
            for (int i = temp; i < new_arr.length; i++) {
                new_arr[i] = arr[i + 1];
            }
        }
        return new_arr;
    }

}
