package module_2.no1_introduce_java.exercise;

import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input amount of dolar: ");
        float usd = scanner.nextFloat();
        System.out.println(usd + " USD = " + (usd * 23000.0) + " VND");
    }
}
