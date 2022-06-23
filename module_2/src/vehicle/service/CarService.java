package vehicle.service;

import vehicle.common.FileProcessing;
import vehicle.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private static final String PATH = "src/vehicle/data/Car.csv";
    private static final String COMMA = ",";
    private static final String FIRST_LINE = "Biển kiểm soát,Hãng sản xuất,Năm sản xuất,Chủ sở hữu,Kiểu xe,Số chỗ ngồi";

    List<Car> carList = scanFile();

    private List<Car> scanFile() {
        List<String> listLine = FileProcessing.readFile(PATH);
        String[] lineSplit;
        List<Car> list = new ArrayList<>();
        for (String s : listLine) {
            Car carFile = new Car();
            lineSplit = s.split(COMMA);
            if (lineSplit.length == 6) {
                carFile.setBienKiemSoat(lineSplit[0]);
                carFile.setTenHangSx(lineSplit[1]);
                carFile.setNamSx(Integer.parseInt(lineSplit[2]));
                carFile.setChuSoHuu(lineSplit[3]);
                carFile.setKieuXe(lineSplit[4]);
                carFile.setSoChoNgoi(Integer.parseInt(lineSplit[5]));
                list.add(carFile);
            }
        }
        return list;
    }

    public void add(Car car) {
        String line = car.getBienKiemSoat() +
                COMMA + car.getTenHangSx() +
                COMMA + car.getNamSx() +
                COMMA + car.getChuSoHuu() +
                COMMA + car.getKieuXe() +
                COMMA + car.getSoChoNgoi();
        FileProcessing.writeFile(PATH, line, FIRST_LINE);
        carList.add(car);
    }

    public void rewrite() {
        FileProcessing.emptyFile(PATH);
        for (Car car : carList) {
            String line = car.getBienKiemSoat() +
                    COMMA + car.getTenHangSx() +
                    COMMA + car.getNamSx() +
                    COMMA + car.getChuSoHuu() +
                    COMMA + car.getKieuXe() +
                    COMMA + car.getSoChoNgoi();
            FileProcessing.writeFile(PATH, line, FIRST_LINE);
        }
    }

    public boolean isExist(String plate) {
        for (Car car : carList) {
            if (car.getBienKiemSoat().equals(plate))
                return true;
        }
        return false;
    }

    public List<Car> find(String brand) {
        List<Car> list = new ArrayList<>();
        for (Car car : scanFile()) {
            if (car.getTenHangSx().contains(brand))
                list.add(car);
        }
        return list;
    }

    public List<Car> getAll() {
        carList = scanFile();
        return carList;
    }
}
