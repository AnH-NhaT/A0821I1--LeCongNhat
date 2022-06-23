package codegym.model.repository.impl;

import codegym.model.bean.Student;
import codegym.model.bean.StudentClass;
import codegym.model.repository.StudentClassRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentClassRepositoryImpl implements StudentClassRepository {
    final String FIND_ALL = "SELECT * FROM class;";

    @Override
    public List<StudentClass> findAll() {
        List<StudentClass> classList = new ArrayList<>();
        Connection connection = ConnectDataBase.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("class_name");
                int classTypeId = resultSet.getInt("class_type_id");
                StudentClass studentClass = new StudentClass(id, name, classTypeId);
                classList.add(studentClass);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classList;
    }
}
