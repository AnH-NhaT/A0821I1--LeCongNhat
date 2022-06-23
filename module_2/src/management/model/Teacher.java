package management.model;

public class Teacher extends Person implements Comparable<Teacher> {
    private int salary;
    private String level;
    private String teacherId;

    public Teacher(String name, int age, int salary, String level, String teacherId) {
        super(name, age);
        this.salary = salary;
        this.level = level;
        this.teacherId = teacherId;
    }

    public Teacher() {
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public int compareTo(Teacher o) {
        return this.teacherId.compareTo(o.teacherId);
    }
}
