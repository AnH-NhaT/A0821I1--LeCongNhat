package vehicle.view;

import vehicle.common.NotFoundVehicleException;
import vehicle.common.Validation;
import vehicle.model.Car;
import vehicle.service.CarService;
import vehicle.service.OtherServices;

import java.util.Scanner;

public class CarView {
    Scanner scanner = new Scanner(System.in);
    CarService service = new CarService();

    void add() {
        Car car = new Car();

        String plate;
        do {
            System.out.print("Biển kiểm soát: ");
            plate = scanner.nextLine();
            if (Validation.validateCar(plate) && !OtherServices.isExistAll(plate)) break;
            else if (plate.equals("")) return;
            else System.out.println("InputNotValid! OR Duplicated!");
        } while (true);
        car.setBienKiemSoat(plate);

        OtherServices.showBrand();
        System.out.print("Hãng sản xuất: ");
        car.setTenHangSx(scanner.nextLine());

        String year;
        while (true) {
            System.out.print("Năm sản xuất: ");
            year = scanner.nextLine();
            if (Validation.validateYear(year)) break;
            else if (year.equals("")) return;
        }
        car.setNamSx(Integer.parseInt(year));

        System.out.print("Chủ sở hữu: ");
        car.setChuSoHuu(scanner.nextLine());

        System.out.print("Kiểu xe: ");
        String kieuXe = OtherServices.carType(plate);
        car.setKieuXe(kieuXe);

        String num;
        while (true) {
            System.out.print("Số chỗ ngồi: ");
            num = scanner.nextLine();
            if (Validation.validatePosNum(num)) break;
            else if (num.equals("")) return;
        }
        car.setSoChoNgoi(Integer.parseInt(num));

        service.add(car);
    }

    void update(Car car) {
        String plate;
        do {
            System.out.print("Biển kiểm soát: ");
            plate = scanner.nextLine();
            if (Validation.validateCar(plate) && !OtherServices.isExistAll(plate)) break;
            else if (plate.equals("")) return;
            else System.out.println("InputNotValid! OR Duplicated!");
        } while (true);
        car.setBienKiemSoat(plate);

        OtherServices.showBrand();
        System.out.print("Hãng sản xuất: ");
        car.setTenHangSx(scanner.nextLine());

        String year;
        while (true) {
            System.out.print("Năm sản xuất: ");
            year = scanner.nextLine();
            if (Validation.validateYear(year)) break;
            else if (year.equals("")) return;
        }
        car.setNamSx(Integer.parseInt(year));

        System.out.print("Chủ sở hữu: ");
        car.setChuSoHuu(scanner.nextLine());

        System.out.print("Kiểu xe: ");
        String kieuXe = OtherServices.carType(plate);
        car.setKieuXe(kieuXe);

        String num;
        while (true) {
            System.out.print("Số chỗ ngồi: ");
            num = scanner.nextLine();
            if (Validation.validatePosNum(num)) break;
            else if (num.equals("")) return;
        }
        car.setSoChoNgoi(Integer.parseInt(num));
    }

    void updateEach() {

        System.out.print("Nhập biển kiểm soát: ");
        String plate = scanner.nextLine();

        if (service.isExist(plate)) {
            System.out.print("Update (Y/N)?: ");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Y")) {
                for (Car car : service.getAll()) {
                    if (car.getBienKiemSoat().equals(plate)) {
                        update(car);
                        service.rewrite();
                    }
                }
                System.out.println("Cập nhật thành công!");
            }
        } else {
            try {
                throw new NotFoundVehicleException("Biển kiểm soát không tồn tại");
            } catch (NotFoundVehicleException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    void show() {
        service.getAll().forEach(System.out::println);
    }

    void deleteEach() {
        System.out.print("Nhập biển kiểm soát: ");
        String plate = scanner.nextLine();
        if (service.isExist(plate)) {
            System.out.print("Delete (Y/N)?: ");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Y")) {
                service.getAll().removeIf(e -> e.getBienKiemSoat().equals(plate));
                service.rewrite();
                System.out.println("Đã xóa thành công!");
            }
        } else {
            try {
                throw new NotFoundVehicleException("Biển kiểm soát không tồn tại");
            } catch (NotFoundVehicleException e) {
                System.err.println(e.getMessage());
            }
        }

    }

    void find() {
        System.out.print("Nhập Hãng Sản xuất: ");
        String brand = scanner.nextLine();
        if (service.find(brand).size() != 0 && !brand.equals(""))
            service.find(brand).forEach(System.out::println);
        else {
            try {
                throw new NotFoundVehicleException("Không tìm thấy");
            } catch (NotFoundVehicleException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
