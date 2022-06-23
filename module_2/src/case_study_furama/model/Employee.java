package case_study_furama.model;

import case_study_furama.util.ConstantUtil;
import case_study_furama.util.ConstantUtil.Degree;
import case_study_furama.util.ConstantUtil.Position;

public class Employee extends Person {
    private Degree degree;
    private Position position;
    private double salary;

    public Employee(){};

    public Employee(int id, String code, String fullName, String birthday, ConstantUtil.Gender gender, String phone, String email, String address, Degree degree, Position position, double salary) {
        super(id, code, fullName, birthday, gender, phone, email, address);
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        return getId()== ((Employee)o).getId();
    }

    @Override
    public String toString() {
        return  getId() +
                "," + getCode() +
                "," + getFullName() +
                "," + getBirthday() +
                "," + getGender() +
                "," + getPhone() +
                "," + getEmail() +
                "," + getAddress() +
                "," + degree +
                "," + position +
                "," + salary;
    }
}
