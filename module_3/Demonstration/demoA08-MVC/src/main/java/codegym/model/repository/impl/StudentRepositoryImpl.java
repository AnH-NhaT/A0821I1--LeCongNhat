package codegym.model.repository.impl;

import codegym.model.bean.Student;
import codegym.model.repository.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private final String ADD_NEW_STUDENT ="insert into student(`name`,gender,birthday,`point`,account, class_id, email)  values (?,?,?,?,?,?,?)";
    private final String DELETE_STUDENT ="call delete_student_by_id(?);";
    private final String SEARCH ="SELECT * FROM student where name like ? and email like ? and class_id like ?;";
    @Override
    public List<Student> findAll() {
        Connection connection =ConnectDataBase.getConnection();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                Boolean gender = resultSet.getBoolean("gender");
                String birthday = resultSet.getString("birthday");
                int point = resultSet.getInt("point");
                String account = resultSet.getString("account");
                int classId = resultSet.getInt("class_id");
                String email = resultSet.getString("email");
                Student student = new Student(id,name,gender,birthday,point,account,classId,email);
                students.add(student);
            }
            System.out.println(preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }



    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public boolean save(Student student) {
        Connection connection =ConnectDataBase.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_STUDENT);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setBoolean(2,student.isGender());
            preparedStatement.setDate(3, Date.valueOf(student.getBirthday()));
            preparedStatement.setInt(4,student.getPoint());
            preparedStatement.setString(5,student.getEmail());// account là email
            preparedStatement.setInt(6,student.getClassId());
            preparedStatement.setString(7,student.getEmail());
            int check=preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            if (check!=0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectDataBase.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_STUDENT);
            callableStatement.setInt(1,id);
            boolean check = callableStatement.executeUpdate()>0;
            return check;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Student> search(String nameSearch, String emailSearch,String classId) {
        Connection connection = ConnectDataBase.getConnection();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1,"%"+nameSearch+"%");
            preparedStatement.setString(2,"%"+emailSearch+"%");
            preparedStatement.setString(3,"%"+classId+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                Boolean gender = resultSet.getBoolean("gender");
                String birthday = resultSet.getString("birthday");
                int point = resultSet.getInt("point");
                String account = resultSet.getString("account");
                int classId1 = resultSet.getInt("class_id");
                String email = resultSet.getString("email");
                Student student = new Student(id,name,gender,birthday,point,account,classId1,email);
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return students;
    }
}
