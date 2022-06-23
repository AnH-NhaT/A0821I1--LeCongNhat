package case_study_furama.view;

import case_study_furama.controller.FacilityController;
import case_study_furama.model.Facility;
import case_study_furama.model.House;
import case_study_furama.model.Villa;
import case_study_furama.util.CommomUtil;
import case_study_furama.util.ConstantUtil.*;
import case_study_furama.util.ValidationUtil;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FacilityView {
    private static FacilityController facilityController= new FacilityController();

    public static void facilityManager(){
        String tmp = "";
        int choice = 0;
        do {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Edit facility");
            System.out.println("4. Return main menu");

            System.out.print(tmp.isEmpty() ? "Input your choice: " : "Please just input number from 1 to 4: ");
            tmp = CommomUtil.getScanner().nextLine();
            if (ValidationUtil.isNumber(tmp)) choice = Integer.parseInt(tmp);
        }
        while (choice <= 0 || choice > 4);

        switch (choice) {
            case 1:
                Set<Entry<Facility, Integer>> set= facilityController.getAll().entrySet();
                for (Entry<Facility, Integer> e: set){
                    System.out.println(e.getKey() + " Used{count="+ e.getValue()+ "}");
                }
                break;
            case 2:
                create();
                System.out.println("Create successful");
                break;
            case 3:
//                facilityController.getAll().forEach(System.out::println);
//                System.out.print("Choice ID to edit: ");
//                int id= Integer.parseInt(CommomUtil.getScanner().nextLine());
//                Facility customer= input();
//                customer.setId(id);
//                facilityController.save(customer);
//                System.out.println("Update successful");
                break;
            case 4:
                HomeView.displayHomeMenu();
                break;
        }
    }

    private static void create(){
        String tmp = "";
        int choice = 0;
        do {
            System.out.println("1. Add new villa");
            System.out.println("2. Add new house");
            System.out.println("3. Add new rooom");
            System.out.println("4. Back to menu");

            System.out.print(tmp.isEmpty() ? "Input your choice: " : "Please just input number from 1 to 4: ");
            tmp = CommomUtil.getScanner().nextLine();
            if (ValidationUtil.isNumber(tmp)) choice = Integer.parseInt(tmp);
        }
        while (choice <= 0 || choice > 4);

        switch (choice) {
            case 1:
                Villa villa= new Villa("VIL01", "Aston Villa", 12, 123, 10, RentType.MONTH, RoomType.DELUXE,  234, 3);
                facilityController.save(villa);
                break;
            case 2:
                House house= new House( "HOU02", "Country House", 12, 123, 10, RentType.MONTH, RoomType.STANDARD, 3);
                facilityController.save(house);
                break;
            case 3:
                break;
            case 4:
                facilityManager();
                break;
        }
    }

    private void update(){

    }
}
