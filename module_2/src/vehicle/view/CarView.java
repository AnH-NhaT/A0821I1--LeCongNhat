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
        System.out.print("Biển kiểm soát: ");
        plate = scanner.nextLine();
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

        service.addACar(car);
    }

    void show() {
        service.getAll().forEach(System.out::println);
    }

}
