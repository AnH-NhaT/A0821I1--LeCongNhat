package codegym.model.repository.impl;

import codegym.model.bean.Student;
import codegym.model.repository.StudentRepository;
import codegym.model.service.StudentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    static ArrayList<Student> studentList = new ArrayList<>();
    static final String SELECT_ALL_STUDENT="select * from student;";
    static final String ADD_STUDENT="insert into student(`name`,gender,birthday,`point`,account, class_id, email) \n" +
            " values (?,?,?,?,?,?,?);";
    static {
        studentList.add(new Student(1, "tuấn", true, "12/12/2022", 9, "tuanvn", 1, "chanhtv235@gmial.com"));
        studentList.add(new Student(2, "trâm", false, "12/12/2022", 8, "tram", 2, "chanhtv235@gmial.com"));
        studentList.add(new Student(3, "lịch", true, "12/12/2022", 7, "lichhn", 2, "chanhtv235@gmial.com"));
        studentList.add(new Student(4, "hải", true, "12/12/2022", 6, "haitt", 3, "chanhtv235@gmial.com"));
        studentList.add(new Student(5, "chánh", true, "12/12/2022", 4, "chanhtv", 1, "chanhtv235@gmial.com"));

    }
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        // lấy dữ liệu từ DB => JDBC
        Connection connection = ConnectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);

            ResultSet resultSet = preparedStatement.executeQuery();// dùng cho select
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                Boolean gender = resultSet.getBoolean("gender");
//                boolean gender =(gender1==1)?false:true;
                String birthday = resultSet.getString("birthday");
                int point = resultSet.getInt("point");
                String account = resultSet.getString("account");
                int classId = resultSet.getInt("class_id");
                String email = resultSet.getString("email");
                Student student = new Student(id,name,gender,birthday,point,account,classId,email);
                students.add(student);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }

    @Override
    public Student findById(String id) {
        return null;
    }

    @Override
    public boolean save(Student student) {
        Connection connection = ConnectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_STUDENT);
            // set param
            preparedStatement.setString(1,student.getName());
            preparedStatement.setBoolean(2,student.isGender());
            preparedStatement.setDate(3, Date.valueOf(student.getBirthday()));
            preparedStatement.setInt(4,student.getPoint());
            preparedStatement.setString(5,student.getEmail());// account là email
            preparedStatement.setInt(6,student.getClassId());
            preparedStatement.setString(7,student.getEmail());
            int check=preparedStatement.executeUpdate(); // dùng cho add, delete,
            if (check!=0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
