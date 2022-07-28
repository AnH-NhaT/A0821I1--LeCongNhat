package vehicle.view;

import vehicle.common.NotFoundVehicleException;
import vehicle.common.Validation;
import vehicle.model.Truck;
import vehicle.service.OtherServices;
import vehicle.service.TruckService;

import java.util.Scanner;

public class TruckView {
    Scanner scanner = new Scanner(System.in);
    TruckService service = new TruckService();

    void add() {

        Truck truck = new Truck();

        String plate;

        System.out.print("Biển kiểm soát: ");
        plate = scanner.nextLine();

        truck.setBienKiemSoat(plate);
        OtherServices.showBrand();

        System.out.print("Hãng sản xuất: ");
        truck.setTenHangSx(scanner.nextLine());

        String year;
        while (true) {
            System.out.print("Năm sản xuất: ");
            year = scanner.nextLine();
            if (Validation.validateYear(year)) break;
            else if (year.equals("")) return;
        }
        truck.setNamSx(Integer.parseInt(year));

        System.out.print("Chủ sở hữu: ");
        truck.setChuSoHuu(scanner.nextLine());

        String num;
        while (true) {
            System.out.print("Tải trọng: ");
            num = scanner.nextLine();
            if (Validation.validatePosNum(num)) break;
            else if (num.equals("")) return;
        }
        truck.setTaiTrong(Integer.parseInt(num));

        service.add(truck);
    }

    void update(Truck truck) {
        String plate;

        System.out.print("Biển kiểm soát: ");
        plate = scanner.nextLine();

        truck.setBienKiemSoat(plate);
        OtherServices.showBrand();

        System.out.print("Hãng sản xuất: ");
        truck.setTenHangSx(scanner.nextLine());

        String year;
        while (true) {
            System.out.print("Năm sản xuất: ");
            year = scanner.nextLine();
            if (Validation.validateYear(year)) break;
            else if (year.equals("")) return;
        }
        truck.setNamSx(Integer.parseInt(year));

        System.out.print("Chủ sở hữu: ");
        truck.setChuSoHuu(scanner.nextLine());

        String num;
        while (true) {
            System.out.print("Tải trọng: ");
            num = scanner.nextLine();
            if (Validation.validatePosNum(num)) break;
            else if (num.equals("")) return;
        }
        truck.setTaiTrong(Integer.parseInt(num));
    }

    void updateEach() {

        System.out.print("Nhập biển kiểm soát: ");
        String plate = scanner.nextLine();

        if (service.isExist(plate)) {
            System.out.print("Update (Y/N)?: ");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Y")) {
                for (Truck truck : service.getAll()) {
                    if (truck.getBienKiemSoat().equals(plate)) {
                        update(truck);
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
