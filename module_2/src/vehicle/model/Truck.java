package vehicle.model;

public class Truck extends Vehicle {
    private int taiTrong;

    public Truck() {
    }

    public int getTaiTrong() {
        return taiTrong;
    }

    public void setTaiTrong(int taiTrong) {
        this.taiTrong = taiTrong;
    }

    @Override
    public String toString() {
        return "Truck{" + super.toString() +
                ", taiTrong=" + taiTrong +
                '}';
    }

}
