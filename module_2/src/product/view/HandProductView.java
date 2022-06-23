package product.view;

import product.common.NotFoundProductException;
import product.model.HandProduct;
import product.service.HandProductService;

import java.util.Scanner;

class HandProductView {

    Scanner scanner = new Scanner(System.in);
    HandProductService service = new HandProductService();

    void add() {
        HandProduct handProduct = new HandProduct();

        System.out.print("Enter Name: ");
        handProduct.setName(scanner.nextLine());
        System.out.print("Enter Cost: ");
        handProduct.setCost(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter Producer: ");
        handProduct.setProducer(scanner.nextLine());
        System.out.print("Enter Nation: ");
        handProduct.setNation(scanner.nextLine());
        System.out.print("Enter Status: ");
        handProduct.setStatus(scanner.nextLine());

        service.add(handProduct);
        display();
    }

    void delete() {
        while (true) {
            try {
                System.out.print("Delete by Id: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (service.delete(id)) {
                    display();
                    break;
                } else {
                    throw new NotFoundProductException("Unmatched!");
                }
            } catch (NotFoundProductException e) {
                System.out.println(e.getMessage());
                break;
            } catch (Exception e) {
                System.out.println("Enter again!");
            }
        }
    }

    void find() {
        while (true) {
            try {
                System.out.print("Find by Name: ");
                String name = scanner.nextLine();
                for (HandProduct s : service.find(name)) {
                    System.out.println(s);
                }
                break;
            } catch (NotFoundProductException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    void display() {
        service.getAll().forEach(System.out::println);
    }

}
