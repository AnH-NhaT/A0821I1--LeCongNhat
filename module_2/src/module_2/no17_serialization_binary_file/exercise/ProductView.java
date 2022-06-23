package module_2.no17_serialization_binary_file.exercise;

import java.util.Scanner;

public class ProductView {
    static Scanner scanner = new Scanner(System.in);
    static ProductService productService = new ProductService();

    public static void main(String[] args) {
        int choice = -1;
        while (choice != 4) {
            System.out.print("1: ADD\t\t2:SHOW\t\t3:SEARCH\t\t4:OUT: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    find();
                    break;
                case 4:
                    break;
            }
        }
    }

    static void add() {
        Product product = new Product();
        System.out.print("Mã sản phẩm: ");
        product.setCode(scanner.nextLine());
        System.out.print("Tên sản phẩm: ");
        product.setName(scanner.nextLine());
        System.out.print("Hãn sản xuất: ");
        product.setBrand(scanner.nextLine());
        System.out.print("Giá: ");
        product.setPrice(Integer.parseInt(scanner.nextLine()));
        System.out.print("Các mô tả khác: ");
        product.setDescription(scanner.nextLine());
        productService.add(product);
    }

    static void display() {
        for (Product product : productService.getAll()) {
            System.out.println(product);
        }
    }

    static void find() {
        System.out.print("Find By Name: ");
        String name = scanner.nextLine();
        productService.find(name);
    }
}
