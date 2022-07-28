package vehicle.view;

import vehicle.common.NotFoundVehicleException;
import vehicle.model.Car;
import vehicle.model.Moto;
import vehicle.model.Truck;
import vehicle.service.CarService;
import vehicle.service.MotoService;
import vehicle.service.OtherServices;
import vehicle.service.TruckService;

import java.util.Scanner;

public class MainView {
    static Scanner scanner = new Scanner(System.in);
    static String choice;

    static CarView carView = new CarView();
    static MotoView motoView = new MotoView();
    static TruckView truckView = new TruckView();

    static CarService carService = new CarService();
    static TruckService truckService = new TruckService();
    static MotoService motoService = new MotoService();

    public static void main(String[] args) {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG");
        do {
            choice = getInput();
            switch (choice) {
                case "1":
                    add();
                    break;
                case "2":
                    show();
                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
            }
        } while (!choice.equals("6"));
    }

    private static String getInput() {
        System.out.println("----------------------------");
        System.out.println("Chọn chức năng:");
        System.out.println("1. Thêm mới phương tiện");
        System.out.println("2. Hiện thị phương tiện");
        System.out.println("3. Xóa phương tiện");
        System.out.println("4. Tìm phương tiện");
        System.out.println("5. Cập nhật phương tiện");
        System.out.println("6. Thoát");
        System.out.print(": ");
        return scanner.nextLine();
    }

    private static void add() {
        do {
            System.out.println("1. Thêm xe tải");
            System.out.println("2. Thêm xe hơi");
            System.out.println("3. Thêm xe máy");
            System.out.print(": ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    truckView.add();
                    return;
                }
                case "2" -> {
                    carView.add();
                    return;
                }
                case "3" -> {
                    motoView.add();
                    return;
                }
            }
        } while (!choice.equals(""));
    }

    private static void show() {
        do {
            System.out.println("1. Xem xe tải");
            System.out.println("2. Xem xe hơi");
            System.out.println("3. Xem xe máy");
            System.out.print(": ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    truckView.show();
                    return;
                }
                case "2" -> {
                    carView.show();
                    return;
                }
                case "3" -> {
                    motoView.show();
                    return;
                }
            }
        } while (!choice.equals(""));
    }

}
