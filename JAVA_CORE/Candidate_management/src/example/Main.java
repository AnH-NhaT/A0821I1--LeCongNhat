package example;

import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static String choice;

	public static void main(String[] args) {
		System.out.println("CHƯƠNG TRÌNH QUẢN LÝ");
		do {
			choice = getInput();
			switch (choice) {
			case "1":
				System.out.println("1: Experience, 2: Fresher, 3, Intern");
				String s = scanner.nextLine();
				if (s.equals("1")) {
					View.insertExperience();
				} else if (s.equals("2")) {
					View.insertFresher();
				} else if (s.equals("3")) {
					View.insertIntern();
				}
				break;
			case "2":
				View.removeDuplicatedID();
				break;
			case "3":
				View.showFullname();
				break;
			case "4":
				View.sort();
				break;
			case "5":
				View.show();
				break;
			}
		} while (!choice.equals("q"));
	}

	private static String getInput() {
		System.out.println("----------------------------");
		System.out.println("Chọn chức năng:");
		System.out.println("1. insert");
		System.out.println("2. removeDuplicatedID");
		System.out.println("3. showFullname");
		System.out.println("4. sort");
		System.out.println("5. showAll");
		System.out.println("q. Thoát");
		System.out.print(": ");
		return scanner.nextLine();
	}

}
