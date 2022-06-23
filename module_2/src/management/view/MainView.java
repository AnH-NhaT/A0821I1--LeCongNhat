package management.view;

import java.util.Scanner;

public class MainView {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        choice();
    }

    static void choice() {
        String choose = "";
        while (!choose.equals("3")) {
            System.out.print("1. Student\t\t2. Teacher\t\t3. Exit: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    StudentView.manage();
                    break;
                case "2":
                    TeacherView.manage();
                    break;
            }
        }
    }
}
