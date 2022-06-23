package management.view;

import management.controller.TeacherController;
import management.model.Teacher;

import java.util.Scanner;
import java.util.regex.Pattern;

class TeacherView {
    static Scanner scanner = new Scanner(System.in);
    TeacherController teacherController = new TeacherController();

    static void manage() {
        TeacherView teacherView = new TeacherView();
        String choice = "";
        while (!choice.equals("4")) {
            System.out.println("\t1: Add\t\t2: Display\t" +
                    "\t3: Delete\t\t4: Back\t\t5: Upd" +
                    "ate\t\t6: Clear\t\t7: Find");
            System.out.println("\t8: Sort by Name\t\t" +
                    "\t\t9: Sort by Id");
            System.out.print("\tYour choice: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    teacherView.add();
                    break;
                case "2":
                    teacherView.display();
                    break;
                case "3":
                    teacherView.delete();
                    break;
                case "5":
                    teacherView.edit();
                    break;
                case "6":
                    teacherView.empty();
                    break;
                case "7":
                    teacherView.find();
                    break;
                case "8":
                    teacherView.sortByName();
                    break;
                case "9":
                    teacherView.sortById();
                    break;
                default:
                    if (!choice.equals("4"))
                        System.err.print("\tYour choice is invalid!\n");
                    break;
            }
        }
    }

    void empty() {
        teacherController.empty();
        System.out.println("File was empty!");
    }

    void add() {
        Teacher teacher = new Teacher();
        System.out.print("Enter Name: ");
        teacher.setName(scanner.nextLine());
        Pattern patternAge = Pattern.compile("^\\d{1,2}$");
        while (true) {
            System.out.print("Enter Age: ");
            String temp = scanner.nextLine();
            if (patternAge.matcher(temp).matches()) {
                if (Integer.parseInt(temp) > 0) {
                    teacher.setAge(Integer.parseInt(temp));
                    break;
                }
            }
        }
        Pattern patternWage = Pattern.compile("^[0-9]{1,}$");
        while (true) {
            System.out.print("Enter Salary: ");
            String temp = scanner.nextLine();
            if (patternWage.matcher(temp).find()) {
                if (Integer.parseInt(temp) > 0) {
                    teacher.setSalary(Integer.parseInt(temp));
                    break;
                }
            }
        }
        Pattern patternLevel = Pattern.compile("^GS|TS|THS$");
        while (true) {
            System.out.print("Enter level (THS; TS; GS): ");
            String temp = scanner.nextLine().toUpperCase();
            if (patternLevel.matcher(temp).find()) {
                teacher.setLevel(temp);
                break;
            }
        }
        teacherController.add(teacher);
        display();
    }

    void display() {
        for (Teacher s : teacherController.getAll()) {
            System.out.println("ID: " +
                    s.getTeacherId() + "\t\t NAME: " +
                    s.getName() + "\t\tAGE: " +
                    s.getAge() + "\t\tWAGE: " +
                    s.getSalary() + "\t\tLEVEL: " +
                    s.getLevel());
        }
    }

    void edit() {
        System.out.print("Edit by ID: ");
        String id = scanner.nextLine();
        teacherController.edit(id);
        display();
    }

    void delete() {
        System.out.print("Delete by ID: ");
        String id = scanner.nextLine();
        teacherController.delete(id);
        display();
    }

    void sortByName() {
        teacherController.sortByName();
        display();
    }

    void sortById() {
        teacherController.sortById();
        display();
    }

    void find() {
        System.out.print("Find by Name: ");
        String name = scanner.nextLine();
        for (Teacher s : teacherController.find(name)) {
            System.out.println("ID: " +
                    s.getTeacherId() + "\t\t NAME: " +
                    s.getName() + "\t\tAGE: " +
                    s.getAge() + "\t\tWAGE: " +
                    s.getSalary() + "\t\tLEVEL: " +
                    s.getLevel());
        }
    }
}
