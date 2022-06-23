package module_2.no14_sort_algorithm.exercise;

public class InsertionSort {
    private static Integer[] integers = {14, 3, 6, 5};

    public static void main(String[] args) {
        for (int i = 1; i < integers.length; i++) {
            int key = integers[i];
            int j = i - 1;
            while (j >= 0 && integers[j] > key) {
                integers[j + 1] = integers[j];
                j--;
            }
            integers[j + 1] = key;
        }
    }
}
