package vehicle.service;

import vehicle.common.FileProcessing;
import vehicle.model.Car;
import vehicle.model.Moto;
import vehicle.model.Truck;

import java.util.List;

public class OtherServices {
    private static final String PATH = "src/vehicle/data/Brand.csv";

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

}
