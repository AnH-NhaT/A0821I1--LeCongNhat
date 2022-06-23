package management.view;

import management.controller.StudentController;
import management.model.Student;

import java.util.Scanner;

class StudentView {
    static Scanner scanner = new Scanner(System.in);

    StudentController studentController = new StudentController();

    static void manage() {
        StudentView testStudent = new StudentView();
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
                    testStudent.add();
                    break;
                case "2":
                    testStudent.display();
                    break;
                case "3":
                    testStudent.delete();
                    break;
                case "5":
                    testStudent.edit();
                    break;
                case "6":
                    testStudent.empty();
                    break;
                case "7":
                    testStudent.find();
                    break;
                case "8":
                    testStudent.sortByName();
                    break;
                case "9":
                    testStudent.sortById();
                    break;
                default:
                    if (!choice.equals("4"))
                        System.err.print("\tYour choice is invalid!\n");
                    break;
            }
        }
    }

    void add() {
        Student student = new Student();
        System.out.print("Enter Name: ");
        student.setName(scanner.nextLine());
        System.out.print("Enter Class: ");
        student.setClassName(scanner.nextLine());
        studentController.add(student);
        display();
    }

    void delete() {
        System.out.print("Delete by Id: ");
        String id = scanner.nextLine();
        studentController.delete(id);
        display();
    }

    void edit() {
        System.out.print("Edit by Id: ");
        String id = scanner.nextLine();
        studentController.edit(id);
        display();
    }

    void find() {
        System.out.print("Find by Name: ");
        String name = scanner.nextLine();
//        studentController.find(name);
        for (Student s : studentController.find(name)) {
            System.out.println("ID: "
                    + s.getStudentId() + "\t\t NAME: " +
                    s.getName() + "\t\tCLASS: " +
                    s.getClassName());
        }
    }

    void display() {
        for (Student s : studentController.getAll()) {
            System.out.println("ID: "
                    + s.getStudentId() + "\t\t NAME: " +
                    s.getName() + "\t\tCLASS: " +
                    s.getClassName());
        }
    }

    void empty() {
        studentController.empty();
        System.out.println("File was empty!");
    }

    void sortByName() {
        studentController.sortByName();
        display();
    }

    void sortById() {
        studentController.sortById();
        display();
    }
}
