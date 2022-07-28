package vehicle.service;

import vehicle.common.FileProcessing;
import vehicle.model.Car;
import vehicle.model.Moto;
import vehicle.model.Truck;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final String PATH = "src/vehicle/data/One.csv";
    private final String COMMA = ",";
    private final String FIELD_NAME = "Biển kiểm soát,Hãng sản xuất,Năm sản xuất,Chủ sở hữu,Kiểu xe,Số chỗ ngồi,Công suất,Tải trọng";

    public List<String> getAll() {
        String[] lineSplit;
        List<String> res = new ArrayList<>();
        for (String s : FileProcessing.readFile(PATH)) {
            lineSplit = s.split(COMMA, -1);
            if (lineSplit.length == 8) {
                res.add(
                        "BienKiemSoat= " + lineSplit[0] +
                                " | TenHangSx= " + lineSplit[1] +
                                " | NamSx= " + lineSplit[2] +
                                " | ChuSoHuu= " + lineSplit[3] +
                                (!lineSplit[4].equals("") ? " | KieuXe= " + lineSplit[4] : "") +
                                (!lineSplit[5].equals("") ? " | SoChoNgoi= " + lineSplit[5] : "") +
                                (!lineSplit[6].equals("") ? " | CongSuat= " + lineSplit[6] : "") +
                                (!lineSplit[7].equals("") ? " | TaiTrong= " + lineSplit[7] : "")
                );
            }
        }
        return res;
    }


    public void addACar(Car object) {
        String line = object.getBienKiemSoat() +
                COMMA + object.getTenHangSx() +
                COMMA + object.getNamSx() +
                COMMA + object.getChuSoHuu() +
                COMMA + object.getKieuXe() +
                COMMA + object.getSoChoNgoi() +
                COMMA + "" + COMMA + "";

        FileProcessing.writeFile(PATH, line, FIELD_NAME);
    }

    public void addAMoto(Moto object) {
        String line = object.getBienKiemSoat() +
                COMMA + object.getTenHangSx() +
                COMMA + object.getNamSx() +
                COMMA + object.getChuSoHuu() +

                COMMA + "" + COMMA + "" +
                COMMA + object.getCongSuat() +
                COMMA + "";

        FileProcessing.writeFile(PATH, line, FIELD_NAME);
    }

    public void addATruck(Truck object) {
        String line = object.getBienKiemSoat() +
                COMMA + object.getTenHangSx() +
                COMMA + object.getNamSx() +
                COMMA + object.getChuSoHuu() +

                COMMA + "" + COMMA + "" +
                COMMA + "" +
                COMMA + object.getTaiTrong();

        FileProcessing.writeFile(PATH, line, FIELD_NAME);
    }

}
