package management.controller;

import management.model.Teacher;
import management.service.TeacherService;

import java.util.List;

public class TeacherController {
    TeacherService teacherService = new TeacherService();

    public void add(Teacher teacher) {
        teacherService.add(teacher);
    }

    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

    public void edit(String id) {
        teacherService.edit(id);
    }

    public void delete(String id) {
        teacherService.delete(id);
    }

    public void sortByName() {
        teacherService.sortByName();
    }

    public void sortById() {
        teacherService.sortById();
    }

    public void empty() {
        teacherService.empty();
    }

    public List<Teacher> find(String name) {
       return teacherService.find(name);
    }
}
