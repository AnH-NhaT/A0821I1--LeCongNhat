package management.service;

import management.data.FileProcess;
import management.model.Teacher;

import java.util.*;

public class TeacherService {
    List<Teacher> teacherList = scanFile();
    private static final String PATH = "src/management/data/Teacher.csv";
    private static final String COMMA = ",";

    public Scanner input() {
        return new Scanner(System.in);
    }

    public void add(Teacher teacher) {
        teacher.setTeacherId("id" + (scanFile().size() + 1) + "");
        String line = teacher.getTeacherId() +
                COMMA + teacher.getName() +
                COMMA + teacher.getAge() +
                COMMA + teacher.getSalary() +
                COMMA + teacher.getLevel();
        FileProcess.writeFile(PATH, line);
        teacherList.add(teacher);
    }

    public void empty() {
        FileProcess.emptyFile(PATH);
    }

    public List<Teacher> scanFile() {
        List<String> listLine = FileProcess.readFile(PATH);
        String[] lineSplit;
        List<Teacher> list = new ArrayList<>();
        for (String s : listLine) {
            Teacher teacherNew = new Teacher();
            lineSplit = s.split(COMMA);
            if (lineSplit.length == 5) {
                teacherNew.setTeacherId(lineSplit[0]);
                teacherNew.setName(lineSplit[1]);
                teacherNew.setAge(Integer.parseInt(lineSplit[2]));
                teacherNew.setSalary(Integer.parseInt(lineSplit[3]));
                teacherNew.setLevel(lineSplit[4]);
                list.add(teacherNew);
            }
        }
        return list;
    }

    public List<Teacher> getAll() {
        return teacherList;
    }

    public void rewrite() {
        empty();
        for (Teacher teacher : teacherList) {
            String line = teacher.getTeacherId() +
                    COMMA + teacher.getName() +
                    COMMA + teacher.getAge() +
                    COMMA + teacher.getSalary() +
                    COMMA + teacher.getLevel();
            FileProcess.writeFile(PATH, line);
        }
    }

    public void delete(String id) {
        for (Teacher teacher : teacherList) {
            if (id.equals(teacher.getTeacherId())) {
                teacherList.remove(teacher);
                break;
            }
        }
        for (int i = 0; i < teacherList.size(); i++) {
            teacherList.get(i).setTeacherId("id" + (i + 1));
        }
        rewrite();
    }

    public void edit(String id) {
        for (Teacher i : teacherList) {
            if (id.equals(i.getTeacherId())) {
                System.out.print("Enter Name: ");
                i.setName(input().nextLine());
                while (true) {
                    try {
                        System.out.print("Enter Age: ");
                        i.setAge(Integer.parseInt(input().nextLine()));
                        break;
                    } catch (Exception e) {
                        System.out.println("INPUT NOT VALID!");
                    }
                }
                while (true) {
                    try {
                        System.out.print("Enter Salary: ");
                        i.setSalary(Integer.parseInt(input().nextLine()));
                        break;
                    } catch (Exception e) {
                        System.out.println("INPUT NOT VALID!");
                    }
                }
                System.out.print("Enter level (THS; TS; PGS.TS; GS): ");
                i.setLevel(input().nextLine().toUpperCase());
            }
        }
        rewrite();
    }

    public void sortByName() {
        teacherList.sort(Comparator.comparing(Teacher::getName).thenComparing(Teacher::getTeacherId));
        rewrite();
    }

    public void sortById() {
        Collections.sort(teacherList);
        rewrite();
    }

    public List<Teacher> find(String name) {
        List<Teacher> newList = new ArrayList<>();
        boolean spot = true;
        for (Teacher teacher : teacherList) {
            if (teacher.getName().contains(name)) {
                newList.add(teacher);
                spot = false;
            }
        }
        if (spot) {
            System.err.println("Not found!");
        }
        return newList;
    }

}
