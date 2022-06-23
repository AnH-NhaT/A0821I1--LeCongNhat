package case_study_furama.model;

import case_study_furama.util.ConstantUtil;
import case_study_furama.util.ConstantUtil.RoomType;

public class Villa extends Facility{
    private RoomType roomType;
    private double areaPool;
    private int numberOfFloor;

    public Villa(){};

    public Villa(String code, String name, double areaUsed, double price, int maxPeople, ConstantUtil.RentType rentType, RoomType roomType, double areaPool, int numberOfFloor) {
        super(code, name, areaUsed, price, maxPeople, rentType);
        this.roomType = roomType;
        this.areaPool = areaPool;
        this.numberOfFloor = numberOfFloor;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id=" + getId() +
                ", code='" + getCode() + '\'' +
                ", name='" + getName() + '\'' +
                ", areaUsed=" + getAreaUsed() +
                ", price=" + getPrice() +
                ", maxPeople=" + getMaxPeople() +
                ", rentType=" + getRentType() +
                "roomType=" + roomType +
                ", areaPool=" + areaPool +
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }
}
