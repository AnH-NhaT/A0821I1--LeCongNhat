package codegym.model.service.impl;

import codegym.model.bean.Student;
import codegym.model.repository.StudentRepository;
import codegym.model.repository.impl.StudentRepositoryImpl;
import codegym.model.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String id) {
        return null;
    }

    @Override
    public boolean save(Student student) {
        return studentRepository.save(student);
    }
}
