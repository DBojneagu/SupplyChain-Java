package repository;

import config.DatabaseConnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class smarthomeRepository {
    private static smarthomeRepository single_instance = null;

    public smarthomeRepository() {
    }

    public static synchronized smarthomeRepository getInstance() {
        if (single_instance == null) {
            single_instance = new smarthomeRepository();
        }
        return single_instance;
    }
    public void addsmarthomeDB(SmartHome smarthome) {
        String sql = "INSERT INTO smarthome (id, name, price, stock,category,app_name) " +
                "VALUES (?, ?, ?, ?,?,?)";
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, smarthome.getId());
            statement.setString(2, smarthome.getName());
            statement.setDouble(3, smarthome.getPrice());
            statement.setInt(4, smarthome.getStock());
            statement.setString(5, smarthome.getCategory());
            statement.setString(6, smarthome.getAppName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAllsmarthome() {
        String sql = "DELETE FROM smarthome";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void printAllSmartHomeDB() {
        String sql = "SELECT * FROM smarthome";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int stock = resultSet.getInt("stock");
                String category = resultSet.getString("category");
                String appName = resultSet.getString("app_name");

                System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price +
                        ", Stock: " + stock + ", Category: " + category + ", App Name: " + appName);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteSmarthomeByIdDB(long id) {
        String sql = "DELETE FROM smarthome WHERE id = ?";

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getNumberOfSmartHomeDB() {
        String sql = "SELECT COUNT(*) FROM smarthome";
        int numberOfProducts = 0;

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                numberOfProducts = resultSet.getInt(1);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberOfProducts;
    }


}






