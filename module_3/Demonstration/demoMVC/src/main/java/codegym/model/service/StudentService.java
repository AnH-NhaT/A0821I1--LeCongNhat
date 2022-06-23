package codegym.model.service;

import codegym.model.bean.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(String id);
    boolean save(Student student);
}
