package module_2.no3_array_and_method.exercise;

import java.util.Scanner;

public class CountShownCharsInString {
    public static void main(String[] args) {
        String str = "\"aaacccvvvggjjjjjjrrkwwwwwwwwwwlllllll\"";
        Scanner scanner = new Scanner(System.in);
        System.out.println(str);
        System.out.print("Enter a character: ");
        int achar = scanner.next().charAt(0);
        int count = 0;
        boolean check = true;
        for (int i = 0; i < str.length(); i++) {
            if (achar == str.charAt(i)) {
                count++;
                check = false;
            }
        }
        if (check)
            System.out.println("This Character is not found!");
        else
            System.out.printf("Character: \'%c\' appears %d times", achar, count);
    }
}
