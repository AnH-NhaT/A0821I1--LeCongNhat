package codegym.model.repository;

import codegym.model.bean.StudentClass;

import java.util.List;

public interface StudentClassRepository {
    List<StudentClass> findAll();
}
