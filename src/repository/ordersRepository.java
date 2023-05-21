package repository;

import config.DatabaseConnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ordersRepository {
    private static ordersRepository single_instance = null;
    public ordersRepository(){}
    public static synchronized ordersRepository getInstance(){
        if(single_instance == null){
            single_instance = new ordersRepository();
        }
        return single_instance;
    }
    public void addordersDB(Order orders) {
        String sql = "INSERT INTO orders (id, product_id,action_id,price) " +
                "VALUES (?, ?, ?,?)";
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, orders.getId());
            statement.setLong(2, orders.getProduct().getId());
            statement.setLong(3, orders.getAction().getId());
            statement.setDouble(4, orders.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteAllorderssDB() {
        String sql = "DELETE FROM orders";
        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
