package model;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String nation;

    public Customer(int id, String name, String email, String nation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nation = nation;
    }

    public Customer(String name, String email, String nation) {
        this.name = name;
        this.email = email;
        this.nation = nation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Customer() {
    }
}