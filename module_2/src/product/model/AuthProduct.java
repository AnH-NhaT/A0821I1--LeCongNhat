package product.model;

public class AuthProduct extends Product {
    private int maintenance;

    public AuthProduct() {
    }

    public AuthProduct(int id, String name,
                       int cost, String producer,
                       int maintenance) {
        super(id, name, cost, producer);
        this.maintenance = maintenance;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", maintenance=" + maintenance +
                '}';
    }
}
