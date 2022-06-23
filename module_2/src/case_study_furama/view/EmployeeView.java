package case_study_furama.view;

import case_study_furama.controller.EmployeeController;
import case_study_furama.model.Employee;
import case_study_furama.util.CommomUtil;
import case_study_furama.util.ConstantUtil;
import case_study_furama.util.ValidationUtil;

public class EmployeeView {
    private static EmployeeController employeeController= new EmployeeController();

    public static void emplayeeManager(){
        String tmp= "";
        int choice= 0;
        do {
            System.out.println("----- Employee View: ------\n"+
                    "1. Display list employees\n"+
            "2. Add new employee\n"+
            "3. Edit employee\n"+
            "4. Return main menu");

            System.out.print(tmp.isEmpty() ? "Input your choice: ": "Please just input number from 1 to 4: ");
            tmp = CommomUtil.getScanner().nextLine();
            if(ValidationUtil.isNumber(tmp)) choice= Integer.parseInt(tmp);
        }
        while (choice <= 0 || choice > 4);

        switch (choice){
            case 1:
                employeeController.getAll().forEach(System.out::println);
                break;
            case 2:
                employeeController.save(input());
                System.out.println("Create successful");
                break;
            case 3:
                employeeController.getAll().forEach(System.out::println);
                System.out.print("Choice ID to edit: ");
                int id= Integer.parseInt(CommomUtil.getScanner().nextLine());
                Employee employee= input();
                employee.setId(id);
                employeeController.save(employee);
                System.out.println("Update successful");
                break;
            case 4:
                HomeView.displayHomeMenu();
                break;
        }
    }

    private static Employee input(){
        System.out.print("Name: ");
        String name= CommomUtil.getScanner().nextLine();
        System.out.print("Address: ");
        String address= CommomUtil.getScanner().nextLine();
        String degree= "";
        do{
            System.out.print(degree.isEmpty()? "Degree: ": "Degree just with INTERMEDIATE, ASSOCIATE, BACHERLOR, MASTER: ");
            degree = CommomUtil.getScanner().nextLine();
        }while (!CommomUtil.enumContains(ConstantUtil.Degree.class, degree));


        System.out.print("Input employee salary: ");
        double salary= Double.parseDouble(CommomUtil.getScanner().nextLine());

        return new Employee(0, "EMP06", name, "23/09/1984", ConstantUtil.Gender.MALE, "0708230984",
                "quocnna@gmail.com", address, ConstantUtil.Degree.valueOf(degree.toUpperCase()), ConstantUtil.Position.SUPERVISOR, salary);
    }
}
