package case_study_furama.model;

public class Contract {
    private int id;
    private String code;
    private double downPayment;
    private double totalPayment;
    private String bookingCode;
    private String customerCode;

    public Contract(String code, double downPayment, double totalPayment, String bookingCode, String customerCode) {
        this.code = code;
        this.downPayment = downPayment;
        this.totalPayment = totalPayment;
        this.bookingCode = bookingCode;
        this.customerCode = customerCode;
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

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}
