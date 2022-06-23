package haitt_demo.ss16_io_text_file.controller;

import haitt_demo.ss16_io_text_file.service.IPersonService;
import haitt_demo.ss16_io_text_file.service.StudentService;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {

        IPersonService iPersonService = new StudentService();
        Scanner scanner = new Scanner(System.in);
//        int number = Integer.parseInt(scanner.nextLine());
//        System.out.println(number);
//        File file = new File("C://codegym.txt");
//        try {
//            FileWriter fileWriter = new FileWriter(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        while (true) {
//            System.out.println("Hello");
//        }
        while (true) {
            System.out.println("Chào mừng bạn đến với ứng dụng quản lí sinh viên");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Hiển thị danh sách học sinh");
            System.out.println("3. Xóa học sinh");
            System.out.println("4. Cập nhật học sinh");
            System.out.print("Mời bạn nhập chức năng: ");
            int choose = Integer.parseInt(scanner.nextLine());
            if (choose == 1) {
                try {
                    iPersonService.add();
                } catch (Exception e) {
                    System.out.println("Xin chào");
                }
            } else if(choose ==2) {
                iPersonService.showAll();
            }
        }

    }
}
