package haitt_demo.ss15_exception.service;

import haitt_demo.ss15_exception.model.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IPersonService {
    Scanner scanner = new Scanner(System.in);
    List<Student> students = new LinkedList<>();

    @Override
    public void add() throws NumberFormatException,Exception {
        try {
            //Các lỗi có thể xảy ra với đoạn code này?
            Student student = new Student();
            //Tên: nhập số, length >100 kí tự
            System.out.print("Mời bạn nhập tên: ");
            student.setName(scanner.nextLine());
            //Tuổi < 0, >100, nhập chữ, số nguyên.
            while(true) {
                try {
                    System.out.print("Mời bạn nhập tuổi: ");
                    student.setAge(Integer.parseInt(scanner.nextLine()));
                    if(student.getAge()<0 || student.getAge()>100) {
                        throw new Exception("Tuổi bạn nhập nhỏ hơn 0 và lớn 100");
                    }
                    break;
                }
                catch (NumberFormatException e) {
                    System.out.println("Bạn nhập không phải số");
                    System.out.println("Mời bạn nhập lại");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Mời bạn nhập lại");
                } finally {
                    System.out.println("hello A08");
                }
            }

            System.out.print("Mời bạn nhập địa chỉ: ");
            student.setAddress(scanner.nextLine());
            //Điểm <0. Nhập chữ
            System.out.print("Mời bạn nhập điểm: ");
            student.setPoint(Double.parseDouble(scanner.nextLine()));
            students.add(student);
        } catch (Exception e) {
            System.out.println("Lỗi.");
        }


    }
    @Override
    public void edit() {

    }
    @Override
    public void showAll() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
        }
    }

}
