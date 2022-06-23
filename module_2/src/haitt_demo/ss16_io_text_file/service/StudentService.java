package haitt_demo.ss16_io_text_file.service;

import haitt_demo.ss16_io_text_file.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IPersonService {
    Scanner scanner = new Scanner(System.in);
    List<Student> students = new LinkedList<>();

    @Override
    public void add() throws NumberFormatException, Exception {
        try {
            //Các lỗi có thể xảy ra với đoạn code này?
            Student student = new Student();
            //Tên: nhập số, length >100 kí tự
            System.out.print("Mời bạn nhập tên: ");
            student.setName(scanner.nextLine());
            //Tuổi < 0, >100, nhập chữ, số nguyên.
            while (true) {
                try {
                    System.out.print("Mời bạn nhập tuổi: ");
                    student.setAge(Integer.parseInt(scanner.nextLine()));
                    if (student.getAge() < 0 || student.getAge() > 100) {
                        throw new Exception("Tuổi bạn nhập nhỏ hơn 0 và lớn 100");
                    }
                    break;
                } catch (NumberFormatException e) {
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
            writeFile(student);
            students.add(student);
        } catch (Exception e) {
            System.out.println("Lỗi.");
        }


    }

    private void writeFile(Student student) {
//        try {
//            FileWriter fileWriter = new FileWriter("RealProduct.csv");
//            fileWriter.write(student.toString());
//            fileWriter.write("\n");
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            FileWriter fileWriter = new FileWriter("RealProduct.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(student.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public void showAll() {
//        try {
////            FileReader fileReader = new FileReader("RealProduct.csv"); //Đường dẫn tương đối
////            int character;
////            String temp = "";
////            while ((character = fileReader.read()) != -1) {
////                temp += (char)character; //Ép kiểu tường minh
////            }
////            students = new ArrayList<>();
////            String[] strings = temp.split("\n");
////            for(int i =0; i<strings.length; i++) {
////                String[] strings1 = strings[i].split(",");
////                Student student = new Student();
////                student.setName(strings1[0]);
////                student.setAddress(strings1[1]);
////                students.add(student);
////            }
////            for(Student student: students) {
////                System.out.println(student);
////            }
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }

        try {
            FileReader fileReader = new FileReader("RealProduct.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            students = new ArrayList<>();
            while ((line = bufferedReader.readLine())!= null) {
                String[] strings = line.split(",");
                Student student = new Student(strings[0],strings[1]);
                students.add(student);
            }
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
