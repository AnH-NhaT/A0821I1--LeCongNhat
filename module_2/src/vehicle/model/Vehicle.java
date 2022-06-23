package vehicle.model;

public abstract class Vehicle {
    private String bienKiemSoat;
    private String tenHangSx;
    private int namSx;
    private String ChuSoHuu;

    public Vehicle() {
    }

    public Vehicle(String bienKiemSoat, String tenHangSx, int namSx, String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.tenHangSx = tenHangSx;
        this.namSx = namSx;
        ChuSoHuu = chuSoHuu;
    }

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public String getTenHangSx() {
        return tenHangSx;
    }

    public void setTenHangSx(String tenHangSx) {
        this.tenHangSx = tenHangSx;
    }

    public int getNamSx() {
        return namSx;
    }

    public void setNamSx(int namSx) {
        this.namSx = namSx;
    }

    public String getChuSoHuu() {
        return ChuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        ChuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return "bienKiemSoat='" + bienKiemSoat + '\'' +
                ", tenHangSx='" + tenHangSx + '\'' +
                ", namSx=" + namSx +
                ", ChuSoHuu='" + ChuSoHuu + '\'';
    }
}
