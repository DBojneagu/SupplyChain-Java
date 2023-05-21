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

    public int getNumberOfOrdersDB() {
        String sql = "SELECT COUNT(*) FROM orders";
        int numberOfOrders = 0;

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                numberOfOrders = resultSet.getInt(1);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return numberOfOrders;
    }

    public void printAllOrdersDB() {
        String sql = "SELECT * FROM orders";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long productid = resultSet.getLong("product_id");
                long actionid = resultSet.getLong("action_id");
                double price = resultSet.getDouble("price");

                System.out.println("ID: " + id + ", ProductId: " + productid + ", ActionId: " + actionid + ", Price: " + price);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteOrderByIdDB(long id) {
        String sql = "DELETE FROM orders WHERE id = ?";

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isValidOrderIdDB(long id) {


        String sql = "SELECT COUNT(*) FROM orders WHERE id = ?";

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
