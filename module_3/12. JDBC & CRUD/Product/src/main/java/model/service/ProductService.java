package model.service;

import model.dto.ProductDTO;
import model.entity.Product;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private final String COUNT_ROWS = "select count(*) as total from product";
    private final String SELECT_ALL = "select product.*, category.name as category_name from product join category on product.category_id = category.id order by product.id limit ?,?";
    private final String INSERT_SQL = "insert into product(name,price,quantity,color,description,category_id,date,type) values(?,?,?,?,?,?,?,?)";
    private final String DELETE_SQL = "delete from product where id=?";
    private final String UPDATE_SQL = "update product set name=?,price=?,quantity=?,color=?,description=?,category_id=?,date=?,type=? where id=?";
    private final String SEARCH_SQL = "select product.*, category.name as category_name from product join category on product.category_id = category.id where product.name like binary ? and product.color like binary ? and product.category_id like binary ?";

    public int countRows() {
        int count = 0;
        try (PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(COUNT_ROWS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<ProductDTO> selectAll(int start, int amount) {
        List<ProductDTO> productList = new ArrayList<>();
        try (PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(SELECT_ALL)) {
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, amount);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String description = resultSet.getString(6);
                int category_id = resultSet.getInt(7);
                String date = resultSet.getString(8);
                boolean type = resultSet.getBoolean(9);
                String category_name = resultSet.getString(10);
                productList.add(new ProductDTO(id, name, price, quantity, color, description, category_id, date, type, category_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public int save(Product product) {
        try (PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(product.getId() > 0 ? UPDATE_SQL : INSERT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategory_id());
            preparedStatement.setDate(7, Date.valueOf(product.getDate()));
            preparedStatement.setBoolean(8, product.getType());
            if (product.getId() > 0) preparedStatement.setInt(9, product.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int id) {
        try (PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<ProductDTO> search(String na, String co, String ca) {
        List<ProductDTO> productList = new ArrayList<>();
        try (PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(SEARCH_SQL)) {
            preparedStatement.setString(1, "%" + na + "%");
            preparedStatement.setString(2, "%" + co + "%");
            preparedStatement.setString(3, "%" + ca + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String description = resultSet.getString(6);
                int category_id = resultSet.getInt(7);
                String date = resultSet.getString(8);
                boolean type = resultSet.getBoolean(9);
                String category_name = resultSet.getString(10);
                productList.add(new ProductDTO(id, name, price, quantity, color, description, category_id, date, type, category_name));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productList;
    }
}
