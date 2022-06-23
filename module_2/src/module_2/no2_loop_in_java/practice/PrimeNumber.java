package module_2.no2_loop_in_java.practice;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        int count = 0;
        while (count < 10) {
            System.out.print("Enter a number: ");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            boolean check = true;
            if (num < 2) {
                System.out.println("\t" + num + " is not a prime number");
            } else {
                for (int i = 2; i < num; i++) {
                    if (num % i == 0) {
                        check = false;
                    }
                }
                if (check) {
                    System.out.println("\t" + num + " is a prime number");
                } else {
                    System.out.println("\t" + num + " is not a prime number");
                }
            }
            count++;
        }
    }
}
