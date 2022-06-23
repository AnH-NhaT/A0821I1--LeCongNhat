package haitt_demo.ss15_exception.model;

public class Teacher extends Person {
    private String level;

    public Teacher() {
    }


    public Teacher(String level) {
        this.level = level;
    }

    public Teacher(String name, int age, String address, String level) {
        super(name, age, address);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
