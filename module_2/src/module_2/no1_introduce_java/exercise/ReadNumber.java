package module_2.no1_introduce_java.exercise;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        char next;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input a number: ");
            int num = scanner.nextInt();
            int hund = num / 100;
            int ones = num % 10;
            int tens = num / 10 % 10;
            String dozen;
            String unit;
            String hunder;
            if (num < 10 && num >= 0) {
                switch (num) {
                    case 0:
                        System.out.println("zero");
                        break;
                    case 1:
                        System.out.println("one");
                        break;
                    case 2:
                        System.out.println("two");
                        break;
                    case 3:
                        System.out.println("three");
                        break;
                    case 4:
                        System.out.println("four");
                        break;
                    case 5:
                        System.out.println("five");
                        break;
                    case 6:
                        System.out.println("six");
                        break;
                    case 7:
                        System.out.println("seven");
                        break;
                    case 8:
                        System.out.println("eight");
                        break;
                    case 9:
                        System.out.println("nine");
                        break;
                }
            } else if (num < 20) {
                switch (num % 10) {
                    case 0:
                        System.out.println("ten");
                        break;
                    case 1:
                        System.out.println("eleven");
                        break;
                    case 2:
                        System.out.println("twelve");
                        break;
                    case 3:
                        System.out.println("thirteen");
                        break;
                    case 4:
                        System.out.println("fourteen");
                        break;
                    case 5:
                        System.out.println("fifteen");
                        break;
                    case 6:
                        System.out.println("sixteen");
                        break;
                    case 7:
                        System.out.println("seventeen");
                        break;
                    case 8:
                        System.out.println("eighteen");
                        break;
                    case 9:
                        System.out.println("nineteen");
                        break;
                }
            } else if (num < 1000) {
                switch (ones) {
                    case 1:
                        unit = "-one";
                        break;
                    case 2:
                        unit = "-two";
                        break;
                    case 3:
                        unit = "-three";
                        break;
                    case 4:
                        unit = "-four";
                        break;
                    case 5:
                        unit = "-five";
                        break;
                    case 6:
                        unit = "-six";
                        break;
                    case 7:
                        unit = "-seven";
                        break;
                    case 8:
                        unit = "-eight";
                        break;
                    case 9:
                        unit = "-nine";
                        break;
                    default:
                        unit = "";
                }
                switch (tens) {
                    case 2:
                        dozen = "twenty";
                        break;
                    case 3:
                        dozen = "thirty";
                        break;
                    case 4:
                        dozen = "forty";
                        break;
                    case 5:
                        dozen = "fifty";
                        break;
                    case 6:
                        dozen = "sixty";
                        break;
                    case 7:
                        dozen = "seventy";
                        break;
                    case 8:
                        dozen = "eighty";
                        break;
                    case 9:
                        dozen = "ninety";
                        break;
                    default:
                        dozen = "";
                }
                switch (hund) {
                    case 1:
                        hunder = "one-hundred";
                        break;
                    case 2:
                        hunder = "two-hundred";
                        break;
                    case 3:
                        hunder = "three-hundred";
                        break;
                    case 4:
                        hunder = "four-hundred";
                        break;
                    case 5:
                        hunder = "five-hundred";
                        break;
                    case 6:
                        hunder = "six-hundred";
                        break;
                    case 7:
                        hunder = "seven-hundred";
                        break;
                    case 8:
                        hunder = "eight-hundred";
                        break;
                    case 9:
                        hunder = "nine-hundred";
                        break;
                    default:
                        hunder = "";
                }
                if (hunder == "") {
                    System.out.println("\t" + dozen + unit);
                } else {
                    if (dozen == "")
                        System.out.println("\t" + hunder + dozen + unit);
                    else
                        System.out.println("\t" + hunder + " and " + dozen + unit);
                }
            } else {
                System.out.println("\tOut of ability");
            }
            System.out.print("\t\tTo quit you must press 'q': ");
            next = scanner.next().charAt(0);
        } while (next != 'q');
        System.out.println("\nGoodbye!");
    }
}
