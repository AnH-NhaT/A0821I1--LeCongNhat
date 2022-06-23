package module_2.no3_array_and_method.exercise;

import java.util.Scanner;

public class InsertElement {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int index, value;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] new_arr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\nInput a number you wanna insert: ");
        value = scanner.nextInt();
        System.out.print("Input it's position: ");
        index = scanner.nextInt();
        int[] assign = insertOne(arr, index, value);
        for (int i = 0; i < assign.length; i++) {
            System.out.print(assign[i] + " ");
        }
//        if (index > arr.length || index < 0)
//            System.out.println("Out of Array' size");
//        else {
//            new_arr[index] = value;
//            for (int i = 0; i < index; i++) {
//                new_arr[i] = arr[i];
//            }
//            for (int i = index + 1; i < new_arr.length; i++) {
//                new_arr[i] = arr[i - 1];
//            }
//            for (int i = 0; i < new_arr.length; i++) {
//                System.out.print(new_arr[i] + " ");
//            }
//        }
    }

    public static int[] insertOne(int[] arr, int index, int value) {
        int[] new_arr = new int[arr.length + 1];
        if (index > arr.length || index < 0)
            System.out.println("Index is out of array' size");
        else {
            new_arr[index] = value;
            for (int i = 0; i < index; i++) {
                new_arr[i] = arr[i];
            }
            for (int i = index + 1; i < new_arr.length; i++) {
                new_arr[i] = arr[i - 1];
            }
        }
        return new_arr;
    }


}
