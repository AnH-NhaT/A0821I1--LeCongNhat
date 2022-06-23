package module_2.no12_java_collection_framework.exercise.e1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LinkedList {
    Scanner scanner = new Scanner((System.in));
    List<Product> productList = new java.util.LinkedList<>();

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add();
        arrayList.add();
//        arrayList.edit();
//        arrayList.delete();
//        arrayList.display();
        arrayList.sort();
//        arrayList.find();
        arrayList.display();
    }

    public void add() {
        Product product = new Product();
        System.out.print("\nNhap ten san pham: ");
        product.setProductName(scanner.nextLine());
        System.out.print("Nhap gia san pham: ");
        product.setPrice(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhap ma san pham: ");
        product.setProductId(scanner.nextLine());
        productList.add(product);
    }

    public void display() {
        for (Product products : productList) {
            System.out.println("\nID: " + products.getProductId() +
                    "" + "\t\tNAME: " + products.getProductName() + "" +
                    "\t\tPRICE: " + products.getPrice());
        }
    }

    public void edit() {
        System.out.println("\nsua thong tin san pham");
        System.out.print("Nhap ID san pham: ");
        for (Product products : productList) {
            if (products.getProductId().equals(scanner.nextLine())) {
                System.out.print("Nhap ten san pham: ");
                products.setProductName(scanner.nextLine());
                System.out.print("Nhap gia san pham: ");
                products.setPrice(Integer.parseInt(scanner.nextLine()));
                System.out.print("Nhap ma san pham: ");
                products.setProductId(scanner.nextLine());
                break;
            }
        }
    }

    public void delete() {
        System.out.println("\nxoa thong tin san pham");
        System.out.print("Nhap ID san pham: ");
        for (Product products : productList) {
            if (products.getProductId().equals(scanner.nextLine())) {
                productList.remove(products);
                break;
            }
        }
    }

    public void find() {
        System.out.println("\nTim thong tin san pham");
        System.out.print("Nhap Ten san pham: ");
        String temp = scanner.nextLine();
        for (Product products : productList) {
            if (temp.equals(products.getProductName())) {
                System.out.println("\nID: " + products.getProductId() +
                        "" + "\t\tNAME: " + products.getProductName() + "" +
                        "\t\tPRICE: " + products.getPrice());
            }
        }
    }

    public void sort() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }
}
