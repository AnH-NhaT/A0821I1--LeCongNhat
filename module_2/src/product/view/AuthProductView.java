package product.view;

import product.common.NotFoundProductException;
import product.common.Validation;
import product.service.AuthProductService;
import product.model.AuthProduct;

import java.util.Scanner;

class AuthProductView {

    Scanner scanner = new Scanner(System.in);
    AuthProductService service = new AuthProductService();

    void add() {
        AuthProduct authProduct = new AuthProduct();

        System.out.print("Enter Name: ");
        authProduct.setName(scanner.nextLine());
        while (true) {
            System.out.print("Enter Cost: ");
            String cost = scanner.nextLine();
            if (Validation.validateCost(cost)) {
                authProduct.setCost(Integer.parseInt(cost));
                break;
            } else if (Validation.validateEnter(cost))
                return;
        }
        System.out.print("Enter Producer: ");
        authProduct.setProducer(scanner.nextLine());
        System.out.print("Enter Maintenance: ");
        authProduct.setMaintenance(Integer.parseInt(scanner.nextLine()));

        service.add(authProduct);
        display();
    }

    void display() {
        service.getAll().forEach(System.out::println);
    }

    void delete() {
        while (true) {
            try {
                System.out.print("Delete by Id: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (service.delete(id)) {
                    display();
                    break;
                } else
                    throw new NotFoundProductException("Unmatched!");
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
                for (AuthProduct s : service.find(name)) {
                    System.out.println(s);
                }
                break;
            } catch (NotFoundProductException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
