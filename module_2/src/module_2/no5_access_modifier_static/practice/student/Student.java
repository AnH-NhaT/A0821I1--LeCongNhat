package module_2.no5_access_modifier_static.practice.student;

public class Student {
    private static String name = "John", classes = "C02";

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
