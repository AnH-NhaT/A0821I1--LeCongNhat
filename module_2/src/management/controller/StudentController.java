package management.controller;

import management.model.Student;
import management.service.StudentService;

import java.util.List;

public class StudentController {
    StudentService service = new StudentService();

    public void add(Student student) {
        service.add(student);
    }

    public void delete(String id) {
        service.delete(id);
    }

    public void edit(String id) {
        service.edit(id);
    }

    public List<Student> find(String name) {
        return service.find(name);
    }

    public void empty() {
        service.empty();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortById() {
        service.sortById();
    }

    public List<Student> getAll() {
        return service.getAll();
    }
}
