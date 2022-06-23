package vehicle.view;

import vehicle.common.NotFoundVehicleException;
import vehicle.common.Validation;
import vehicle.model.Moto;
import vehicle.service.MotoService;
import vehicle.service.OtherServices;

import java.util.Scanner;

public class MotoView {
    Scanner scanner = new Scanner(System.in);
    MotoService service = new MotoService();

    void add() {
        Moto moto = new Moto();

        String plate;
        do {
            System.out.print("Biển kiểm soát: ");
            plate = scanner.nextLine();
            if (Validation.validateMoto(plate) && !OtherServices.isExistAll(plate)) break;
            else if (plate.equals("")) return;
            else System.out.println("InputNotValid! OR Duplicated!");
        } while (true);
        moto.setBienKiemSoat(plate);

        OtherServices.showBrand();
        System.out.print("Hãng sản xuất: ");
        moto.setTenHangSx(scanner.nextLine());

        String year;
        while (true) {
            System.out.print("Năm sản xuất: ");
            year = scanner.nextLine();
            if (Validation.validateYear(year)) break;
            else if (year.equals("")) return;
        }
        moto.setNamSx(Integer.parseInt(year));

        System.out.print("Chủ sở hữu: ");
        moto.setChuSoHuu(scanner.nextLine());

        String num;
        while (true) {
            System.out.print("Công suất: ");
            num = scanner.nextLine();
            if (Validation.validatePosNum(num)) break;
            else if (num.equals("")) return;
        }
        moto.setCongSuat(Integer.parseInt(num));

        service.add(moto);
    }

    void update(Moto moto) {
        String plate;
        do {
            System.out.print("Biển kiểm soát: ");
            plate = scanner.nextLine();
            if (Validation.validateMoto(plate) && !OtherServices.isExistAll(plate)) break;
            else if (plate.equals("")) return;
            else System.out.println("InputNotValid! OR Duplicated!");
        } while (true);
        moto.setBienKiemSoat(plate);

        OtherServices.showBrand();
        System.out.print("Hãng sản xuất: ");
        moto.setTenHangSx(scanner.nextLine());

        String year;
        while (true) {
            System.out.print("Năm sản xuất: ");
            year = scanner.nextLine();
            if (Validation.validateYear(year)) break;
            else if (year.equals("")) return;
        }
        moto.setNamSx(Integer.parseInt(year));

        System.out.print("Chủ sở hữu: ");
        moto.setChuSoHuu(scanner.nextLine());

        String num;
        while (true) {
            System.out.print("Công suất: ");
            num = scanner.nextLine();
            if (Validation.validatePosNum(num)) break;
            else if (num.equals("")) return;
        }
        moto.setCongSuat(Integer.parseInt(num));
    }

    void updateEach() {

        System.out.print("Nhập biển kiểm soát: ");
        String plate = scanner.nextLine();

        if (service.isExist(plate)) {
            System.out.print("Update (Y/N)?: ");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Y")) {
                for (Moto moto : service.getAll()) {
                    if (moto.getBienKiemSoat().equals(plate)) {
                        update(moto);
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
