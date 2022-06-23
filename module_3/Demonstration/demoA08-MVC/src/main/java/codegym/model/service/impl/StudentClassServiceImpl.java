package codegym.model.service.impl;

import codegym.model.bean.StudentClass;
import codegym.model.repository.StudentClassRepository;
import codegym.model.repository.impl.StudentClassRepositoryImpl;
import codegym.model.service.StudentClassService;

import java.util.List;

public class StudentClassServiceImpl implements StudentClassService {
    private StudentClassRepository studentClassRepository = new StudentClassRepositoryImpl();
    @Override
    public List<StudentClass> findAll() {
        return studentClassRepository.findAll();
    }
}
