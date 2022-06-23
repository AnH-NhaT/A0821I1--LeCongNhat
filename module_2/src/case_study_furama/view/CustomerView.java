package case_study_furama.view;

import case_study_furama.controller.CustomerController;
import case_study_furama.model.Customer;
import case_study_furama.util.CommomUtil;
import case_study_furama.util.ConstantUtil;
import case_study_furama.util.ValidationUtil;

public class CustomerView {
    private static CustomerController customerController = new CustomerController();

    public static void customerManager() {
        String tmp = "";
        int choice = 0;
        do {
            System.out.println("----- Customer View: -----" +
                    "1. Display list manager\n" +
                    "2. Add new manager\n" +
                    "3. Edit manager\n" +
                    "4. Return main menu");

            System.out.print(tmp.isEmpty() ? "Input your choice: " : "Please just input number from 1 to 4: ");
            tmp = CommomUtil.getScanner().nextLine();
            if (ValidationUtil.isNumber(tmp)) choice = Integer.parseInt(tmp);
        }
        while (choice <= 0 || choice > 4);

        switch (choice) {
            case 1:
                customerController.getAll().forEach(System.out::println);
                break;
            case 2:
                customerController.save(input());
                System.out.println("Create successful");
                break;
            case 3:
                customerController.getAll().forEach(System.out::println);
                System.out.print("Choice ID to edit: ");
                int id= Integer.parseInt(CommomUtil.getScanner().nextLine());
                Customer customer= input();
                customer.setId(id);
                customerController.save(customer);
                System.out.println("Update successful");
                break;
            case 4:
                HomeView.displayHomeMenu();
                break;
        }
    }

    private static Customer input(){
        System.out.print("Name: ");
        String name = CommomUtil.getScanner().nextLine();
        System.out.print("Address: ");
        String address = CommomUtil.getScanner().nextLine();
        return new Customer(1, "CUS01", name, "23/09/1984", ConstantUtil.Gender.MALE, "0708230984",
                "phongnna@gmail.com", address, ConstantUtil.TypeCustomer.SILVER);
    }
}
