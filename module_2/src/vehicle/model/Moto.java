package vehicle.model;

public class Moto extends Vehicle {
    private int congSuat;

    public Moto() {
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "Moto{" + super.toString() +
                ", congSuat=" + congSuat +
                '}';
    }
}
