package product.view;

import java.util.Scanner;

public class MainView {

    static Scanner scanner = new Scanner(System.in);
    static String choice;
    static AuthProductView real = new AuthProductView();
    static HandProductView hand = new HandProductView();

    public static void main(String[] args) {

        do {

            System.out.print("\t1. ADD\t");
            System.out.print("\t2. SHOW\t");
            System.out.print("\t3. DELETE\t");
            System.out.print("\t4. FIND\t");
            System.out.print("\t5. EXIT:\t");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    add();
                    break;
                case "2":
                    show();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    find();
                    break;
            }
        } while (!choice.equals("5"));

    }

    private static String getInput() {
        System.out.print("\t1. AuthProduct\t");
        System.out.print("\t2. HandProduct:\t");
        return scanner.nextLine();
    }

    private static void add() {
        choice = getInput();
        if (choice.equals("1"))
            real.add();
        else if (choice.equals("2"))
            hand.add();
    }

    private static void show() {
        choice = getInput();
        if (choice.equals("1"))
            real.display();
        else if (choice.equals("2"))
            hand.display();
    }

    private static void delete() {
        choice = getInput();
        if (choice.equals("1"))
            real.delete();
        else if (choice.equals("2"))
            hand.delete();
    }

    private static void find() {
        choice = getInput();
        if (choice.equals("1"))
            real.find();
        else if (choice.equals("2"))
            hand.find();
    }
}
