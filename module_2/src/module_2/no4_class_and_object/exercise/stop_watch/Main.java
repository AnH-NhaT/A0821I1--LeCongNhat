package module_2.no4_class_and_object.exercise.stop_watch;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Wait a few seconds...");
        selectionSort();
        stopWatch.end();
        System.out.println("Times it took = " + stopWatch.getElapsedTime());

    }

    static void selectionSort() {
        int arr[] = new int[100000];
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(500);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
