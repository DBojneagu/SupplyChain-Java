package repository;

import config.DatabaseConnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class productRepository {
    private static productRepository single_instance = null;

    public productRepository() {
    }

    public static synchronized productRepository getInstance() {
        if (single_instance == null) {
            single_instance = new productRepository();
        }
        return single_instance;
    }
    public void addProductDB(Product product) {
        String sql = "INSERT INTO product (id, name, price, stock) " +
                "VALUES (?, ?, ?, ?)";
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getStock());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAllProdcutsDB() {
        String sql = "DELETE FROM product";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}






