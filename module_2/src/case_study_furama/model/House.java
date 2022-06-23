package case_study_furama.model;

import case_study_furama.util.ConstantUtil;
import case_study_furama.util.ConstantUtil.RoomType;

public class House extends Facility {
    private RoomType roomType;
    private int numberOfFloor;

    public House() { }

    public House(String code, String name, double areaUsed, double price, int maxPeople, ConstantUtil.RentType rentType, RoomType roomType, int numberOfFloor) {
        super(code, name, areaUsed, price, maxPeople, rentType);
        this.roomType = roomType;
        this.numberOfFloor = numberOfFloor;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
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
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }
}
