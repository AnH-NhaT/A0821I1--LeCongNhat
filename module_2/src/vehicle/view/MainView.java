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
                    delete();
//                    deleteEach();
                    break;
                case "4":
                    find();
//                    findEach();
                    break;
                case "5":
                    update();
//                    updateEach();
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
                case "1":
                    truckView.add();
                    return;
                case "2":
                    carView.add();
                    return;
                case "3":
                    motoView.add();
                    return;
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
                case "1":
                    truckView.show();
                    return;
                case "2":
                    carView.show();
                    return;
                case "3":
                    motoView.show();
                    return;
            }
        } while (!choice.equals(""));
    }

    private static void delete() {
        System.out.print("Nhập biển kiểm soát: ");
        String plate = scanner.nextLine();

        if (OtherServices.isExistAll(plate)) {

            System.out.print("Delete (Y/N)?: ");
            choice = scanner.nextLine().toUpperCase();

            if (choice.equals("Y")) {
                OtherServices.deleteAll(plate);
                System.out.println("Đã xóa thành công!");
            }
        } else
            try {
                throw new NotFoundVehicleException("Biển kiểm soát không tồn tại");
            } catch (NotFoundVehicleException e) {
                System.err.println(e.getMessage());
            }
    }

    private static void deleteEach() {
        do {
            System.out.println("1. Xóa xe tải");
            System.out.println("2. Xóa xe hơi");
            System.out.println("3. Xóa xe máy");
            System.out.print(": ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    truckView.deleteEach();
                    return;
                case "2":
                    carView.deleteEach();
                    return;
                case "3":
                    motoView.deleteEach();
                    return;
            }
        } while (!choice.equals(""));
    }

    private static void find() {
        System.out.print("Nhập Hãng Sản xuất: ");
        String brand = scanner.nextLine();
        if (brand.equals("")) return;
        else if (
                truckService.find(brand).size() == 0 &&
                        carService.find(brand).size() == 0 &&
                        motoService.find(brand).size() == 0
        ) {
            try {
                throw new NotFoundVehicleException("Không tìm thấy");
            } catch (NotFoundVehicleException e) {
                System.err.println(e.getMessage());
            }
        }
        truckService.find(brand).forEach(System.out::println);
        carService.find(brand).forEach(System.out::println);
        motoService.find(brand).forEach(System.out::println);
    }

    private static void findEach() {
        do {
            System.out.println("1. Tìm xe tải");
            System.out.println("2. Tìm xe hơi");
            System.out.println("3. Tìm xe máy");
            System.out.print(": ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    truckView.find();
                    return;
                case "2":
                    carView.find();
                    return;
                case "3":
                    motoView.find();
                    return;
            }
        } while (!choice.equals(""));
    }

    private static void update() {
        System.out.print("Nhập biển kiểm soát: ");
        String plate = scanner.nextLine();

        if (OtherServices.isExistAll(plate)) {
            System.out.print("Update (Y/N)?: ");
            choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Y")) {

                for (Car car : carService.getAll()) {
                    if (car.getBienKiemSoat().equals(plate)) {
                        carView.update(car);
                        carService.rewrite();
                    }
                }
                for (Truck truck : truckService.getAll()) {
                    if (truck.getBienKiemSoat().equals(plate)) {
                        truckView.update(truck);
                        truckService.rewrite();
                    }
                }
                for (Moto moto : motoService.getAll()) {
                    if (moto.getBienKiemSoat().equals(plate)) {
                        motoView.update(moto);
                        motoService.rewrite();
                    }
                }

                System.out.println("Cập nhật thành công!");
            }
        } else
            try {
                throw new NotFoundVehicleException("Biển kiểm soát không tồn tại");
            } catch (NotFoundVehicleException e) {
                System.err.println(e.getMessage());
            }
    }

    private static void updateEach() {
        do {
            System.out.println("1. Cập nhật xe tải");
            System.out.println("2. Cập nhật xe hơi");
            System.out.println("3. Cập nhật xe máy");
            System.out.print(": ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    truckView.updateEach();
                    return;
                case "2":
                    carView.updateEach();
                    return;
                case "3":
                    motoView.updateEach();
                    return;
            }
        } while (!choice.equals(""));
    }

}
