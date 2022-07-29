package final_test;

import java.util.Scanner;

import final_test.dao.impl.CustomerDAOImpl;

public class Main {
	private static CustomerDAOImpl cImpl = new CustomerDAOImpl();
	static Scanner scanner = new Scanner(System.in);
	static String choice;

	public static void main(String[] args) {
		System.out.println("CHƯƠNG TRÌNH QUẢN LÝ");
		do {
			choice = getInput();
			switch (choice) {
			case "1":
				cImpl.insertFromCSV();
				break;
			case "2":
				cImpl.update();
				break;
			case "3":
				cImpl.delete();
				break;
			case "4":
				cImpl.ShowInformation();
				break;
			}
		} while (!choice.equals("q"));
	}

	private static String getInput() {
		System.out.println("----------------------------");
		System.out.println("Chọn chức năng:");
		System.out.println("1. INSERT");
		System.out.println("2. UPDATE");
		System.out.println("3. DELETE");
		System.out.println("4. DISPLAY");
		System.out.println("q. Thoát");
		System.out.print(": ");
		return scanner.nextLine();
	}
}
