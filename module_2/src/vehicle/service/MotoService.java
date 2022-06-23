package vehicle.service;

import vehicle.common.FileProcessing;
import vehicle.model.Moto;

import java.util.ArrayList;
import java.util.List;

public class MotoService {
    private static final String PATH = "src/vehicle/data/Moto.csv";
    private static final String COMMA = ",";
    private static final String FIRST_LINE = "Biển kiểm soát,Hãng sản xuất,Năm sản xuất,Chủ sở hữu,Công suất";

    List<Moto> motoList = scanFile();

    private List<Moto> scanFile() {
        List<String> listLine = FileProcessing.readFile(PATH);
        String[] lineSplit;
        List<Moto> list = new ArrayList<>();
        for (String s : listLine) {
            Moto motoFile = new Moto();
            lineSplit = s.split(COMMA);
            if (lineSplit.length == 5) {
                motoFile.setBienKiemSoat(lineSplit[0]);
                motoFile.setTenHangSx(lineSplit[1]);
                motoFile.setNamSx(Integer.parseInt(lineSplit[2]));
                motoFile.setChuSoHuu(lineSplit[3]);
                motoFile.setCongSuat(Integer.parseInt(lineSplit[4]));
                list.add(motoFile);
            }
        }
        return list;
    }

    public void add(Moto moto) {
        String line = moto.getBienKiemSoat() +
                COMMA + moto.getTenHangSx() +
                COMMA + moto.getNamSx() +
                COMMA + moto.getChuSoHuu() +
                COMMA + moto.getCongSuat();
        FileProcessing.writeFile(PATH, line, FIRST_LINE);
        motoList.add(moto);
    }

    public void rewrite() {
        FileProcessing.emptyFile(PATH);
        for (Moto moto : motoList) {
            String line = moto.getBienKiemSoat() +
                    COMMA + moto.getTenHangSx() +
                    COMMA + moto.getNamSx() +
                    COMMA + moto.getChuSoHuu() +
                    COMMA + moto.getCongSuat();
            FileProcessing.writeFile(PATH, line, FIRST_LINE);
        }
    }

    public boolean isExist(String plate) {
        for (Moto moto : motoList) {
            if (moto.getBienKiemSoat().equals(plate))
                return true;
        }
        return false;
    }

    public List<Moto> find(String brand) {
        List<Moto> list = new ArrayList<>();
        for (Moto moto : scanFile()) {
            if (moto.getTenHangSx().contains(brand))
                list.add(moto);
        }
        return list;
    }

    public List<Moto> getAll() {
        motoList = scanFile();
        return motoList;
    }
}
