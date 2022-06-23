package management.model;

public class Student extends Person implements Comparable<Student> {
    private String className;
    private String studentId;

    public Student() {
    }

    public Student(String name, int age, String className, String studentId) {
        super(name, age);
        this.className = className;
        this.studentId = studentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    @Override
    public int compareTo(Student o) {
        return this.studentId.compareTo(o.studentId);
    }
}
