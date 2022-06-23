package vehicle.service;

import vehicle.common.FileProcessing;
import vehicle.model.Car;
import vehicle.model.Moto;
import vehicle.model.Truck;

import java.util.List;

public class OtherServices {
    private static final String PATH = "src/vehicle/data/Brand.csv";

    static CarService carService = new CarService();
    static TruckService truckService = new TruckService();
    static MotoService motoService = new MotoService();

    private static List<String> getBrand() {
        return FileProcessing.readFile(PATH);
    }

    public static void showBrand() {
        System.out.printf("%-20s %-20s %-20s%n", "Mã hãng sản xuất", "Tên hãng sản xuất", "Tên quốc gia");
        System.out.println("------------------------------------------------------");
        for (String line : getBrand()) {
            String[] split = line.split(",");
            System.out.printf("%-20s %-20s %-20s%n", split[0], split[1], split[2]);
        }
    }

    public static String carType(String type) {
        String result = "";
        char choice = type.charAt(2);
        if (choice == 'B') {
            System.out.print("BUS\n");
            result = "BUS";
        } else if (choice == 'A') {
            System.out.print("TOURIST\n");
            result = "TOURIST";
        }

        return result;
    }

    public static boolean isExistAll(String plate) {
        for (Car car : carService.getAll()) {
            if (car.getBienKiemSoat().equals(plate)) return true;
        }
        for (Truck truck : truckService.getAll()) {
            if (truck.getBienKiemSoat().equals(plate)) return true;
        }
        for (Moto moto : motoService.getAll()) {
            if (moto.getBienKiemSoat().equals(plate)) return true;
        }
        return false;
    }

    public static void deleteAll(String plate) {
        if (carService.getAll().removeIf(e -> e.getBienKiemSoat().equals(plate)))
            carService.rewrite();
        else if (truckService.getAll().removeIf(e -> e.getBienKiemSoat().equals(plate)))
            truckService.rewrite();
        else if (motoService.getAll().removeIf(e -> e.getBienKiemSoat().equals(plate)))
            motoService.rewrite();
    }


}
