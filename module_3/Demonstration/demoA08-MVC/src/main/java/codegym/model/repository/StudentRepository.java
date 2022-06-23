package codegym.model.repository;

import codegym.model.bean.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(String id);
    boolean save(Student student);
}
