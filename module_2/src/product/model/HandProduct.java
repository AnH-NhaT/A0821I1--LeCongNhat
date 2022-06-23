package product.model;

public class HandProduct extends Product {
    private String nation;
    private String status;

    public HandProduct() {
    }

    public HandProduct(int id, String name,
                       int cost, String producer,
                       String nation, String status) {
        super(id, name, cost, producer);
        this.nation = nation;
        this.status = status;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", nation='" + nation + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
