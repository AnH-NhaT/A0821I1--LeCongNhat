package case_study_furama.model;

import java.time.LocalDate;

public class Booking implements Comparable<Booking> {
    private int id;
    private String code;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isContracted;
    private int customerId;
    private int facilityId;

    public Booking(String code, LocalDate startDate, LocalDate endDate, int customerId, int facilityId) {
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.facilityId = facilityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public boolean isContracted() {
        return isContracted;
    }

    public void setContracted(boolean contracted) {
        isContracted = contracted;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public int compareTo(Booking o) {
        int tmp = o.getStartDate().compareTo(getStartDate());
        return tmp != 0 ? o.getStartDate().compareTo(getStartDate()) : o.getEndDate().compareTo(getStartDate());
    }
}
