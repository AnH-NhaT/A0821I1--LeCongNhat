package management.service;

import management.data.FileProcess;
import management.model.Student;

import java.util.*;

public class StudentService {
    public static final String PATH = "src/management/data/Student.csv";
    public static final String COMMA = ",";
    List<Student> studentList = scanFile();

    public Scanner input() {
        return new Scanner(System.in);
    }


    public void add(Student student) {
        student.setStudentId("id" + (studentList.size() + 1) + "");
        String line = student.getStudentId() +
                COMMA + student.getName() +
                COMMA + student.getClassName();
        FileProcess.writeFile(PATH, line);
        studentList.add(student);
    }

    public void empty() {
        FileProcess.emptyFile(PATH);
    }

    public List<Student> scanFile() {
        List<String> listLine = FileProcess.readFile(PATH);
        String[] lineSplit;
        List<Student> list = new ArrayList<>();
        for (String s : listLine) {
            Student studentNew = new Student();
            lineSplit = s.split(COMMA);
            if (lineSplit.length == 3) {
                studentNew.setStudentId(lineSplit[0]);
                studentNew.setName(lineSplit[1]);
                studentNew.setClassName(lineSplit[2]);
                list.add(studentNew);
            }
        }
        return list;
    }

    public void rewrite() {
        for (Student e : studentList) {
            String line = e.getStudentId() +
                    COMMA + e.getName() +
                    COMMA + e.getClassName();
            FileProcess.writeFile(PATH, line);
        }
    }

    public void sortById() {
        Collections.sort(studentList);
        rewrite();
    }

    public void sortByName() {
        studentList.sort(Comparator.comparing(Student::getName).thenComparing(Student::getStudentId));
        rewrite();
    }


    public void delete(String id) {
        for (Student student : studentList) {
            if (id.equals(student.getStudentId())) {
                studentList.remove(student);
                break;
            }
        }
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).setStudentId("id" + (i + 1));
        }
        rewrite();
    }


    public void edit(String id) {
        for (Student i : studentList) {
            if (id.equals(i.getStudentId())) {
                System.out.print("New Name: ");
                i.setName(input().nextLine());
                System.out.print("New Class: ");
                i.setClassName(input().nextLine());
            }
        }
        rewrite();
    }

    public List<Student> find(String name) {
        List<Student> newList = new ArrayList<>();
        boolean spot = true;
        for (Student student : studentList) {
            if (student.getClassName().contains(name)) {
                newList.add(student);
                spot = false;
            }
        }
        if (spot) {
            System.err.println("Not found!");
        }
        return newList;
    }

    public List<Student> getAll() {
        return studentList;
    }

}