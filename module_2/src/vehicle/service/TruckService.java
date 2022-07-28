package vehicle.service;

import vehicle.common.FileProcessing;
import vehicle.model.Truck;

import java.util.ArrayList;
import java.util.List;

public class TruckService {
    private static final String PATH = "src/vehicle/data/One.csv";
    private static final String COMMA = ",";
    private final String FIELD_NAME = "Biển kiểm soát,Hãng sản xuất,Năm sản xuất,Chủ sở hữu,Kiểu xe,Số chỗ ngồi,Công suất,Tải trọng";
    List<Truck> truckList = scanFile();

    private List<Truck> scanFile() {
        List<String> listLine = FileProcessing.readFile(PATH);
        String[] lineSplit;
        List<Truck> list = new ArrayList<>();
        for (String s : listLine) {
            Truck truckFile = new Truck();
            lineSplit = s.split(COMMA);
            if (lineSplit.length == 5) {
                truckFile.setBienKiemSoat(lineSplit[0]);
                truckFile.setTenHangSx(lineSplit[1]);
                truckFile.setNamSx(Integer.parseInt(lineSplit[2]));
                truckFile.setChuSoHuu(lineSplit[3]);
                truckFile.setTaiTrong(Integer.parseInt(lineSplit[4]));
                list.add(truckFile);
            }
        }
        return list;
    }

    public void add(Truck truck) {
        String line = truck.getBienKiemSoat() +
                COMMA + truck.getTenHangSx() +
                COMMA + truck.getNamSx() +
                COMMA + truck.getChuSoHuu() +
                COMMA + "" + COMMA + "" + COMMA + "" +
                COMMA + truck.getTaiTrong();
        FileProcessing.writeFile(PATH, line, FIELD_NAME);
        truckList.add(truck);
    }

    public void rewrite() {
        FileProcessing.emptyFile(PATH);
        for (Truck truck : truckList) {
            String line = truck.getBienKiemSoat() +
                    COMMA + truck.getTenHangSx() +
                    COMMA + truck.getNamSx() +
                    COMMA + truck.getChuSoHuu() +
                    COMMA + truck.getTaiTrong();
            FileProcessing.writeFile(PATH, line, FIELD_NAME);
        }
    }

    public boolean isExist(String plate) {
        for (Truck truck : truckList) {
            if (truck.getBienKiemSoat().equals(plate))
                return true;
        }
        return false;
    }

    public List<Truck> find(String brand) {
        List<Truck> list = new ArrayList<>();
        for (Truck truck : scanFile()) {
            if (truck.getTenHangSx().contains(brand))
                list.add(truck);
        }
        return list;
    }

    public List<Truck> getAll() {
        truckList = scanFile();
        return truckList;
    }
}
