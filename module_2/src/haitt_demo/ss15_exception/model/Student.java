package haitt_demo.ss15_exception.model;

public class Student extends Person {
    private double point;
    private static String nameClass = "A0821I1";

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public static String getNameClass() {
        return nameClass;
    }

    public static void setNameClass(String nameClass) {
        Student.nameClass = nameClass;
    }
    public Student(String name, int age, String address, double point) {
       super(name, age,address);
        this.point = point;
    }

    public Student() {
    }


    @Override
    public String toString() {
        return "Name: "+this.getName()+", address: "+this.getAddress();
    }
}
