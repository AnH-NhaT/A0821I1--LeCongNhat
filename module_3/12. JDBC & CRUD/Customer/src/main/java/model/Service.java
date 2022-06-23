package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private final String URL = "jdbc:mysql://localhost:3306/customer";
    private final String USER = "root";
    private final String PASSWORD = "111111";

    private final String SELECT_ALL = "select * from customer";
    private final String INSERT_SQL = "insert into customer (name,email,nation) values (?,?,?)";
    private final String DELETE_SQL = "delete from customer where id=?";
    private final String UPDATE_SQL = "update customer set name=?,email=?,nation=? where id=?";
    private final String SEARCH_SQL = "select * from customer where name like '%@%' or nation like '%@%' or email like '%@%'";
    private final String DESCENDING = "select * from customer order by name desc";
    private final String ASCENDING = "select * from customer order by name asc";

    private Connection connection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Customer> select(String sql) {
        List<Customer> customerList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String nation = resultSet.getString("nation");
                customerList.add(new Customer(id, name, email, nation));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public List<Customer> getAll() {
        return select(SELECT_ALL);
    }

    public List<Customer> search(String words) {
        return select(SEARCH_SQL.replace("@", words));
    }

    public List<Customer> asc() {
        return select(ASCENDING);
    }

    public List<Customer> desc() {
        return select(DESCENDING);
    }

    public void save(Customer customer) {
        try (PreparedStatement preparedStatement = connection().prepareStatement(customer.getId() > 0 ? UPDATE_SQL : INSERT_SQL)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getNation());
            if (customer.getId() > 0) preparedStatement.setInt(4, customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection().prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public List<Customer> search(String words) {
//        List<Customer> list = new ArrayList<>();
//        for (Customer customer : getAll())
//            if (customer.getName().toLowerCase().contains(words)) list.add(customer);
//        return list;
//    }

//    public List<Customer> sortByName() {
//        List<Customer> sortedlist = getAll();
//        sortedlist.sort(Comparator.comparing(Customer::getName));
//        return sortedlist;
//    }

}