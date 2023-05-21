package repository;

import config.DatabaseConnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class measuringRepository {
    private static measuringRepository single_instance = null;

    public measuringRepository() {
    }

    public static synchronized measuringRepository getInstance() {
        if (single_instance == null) {
            single_instance = new measuringRepository();
        }
        return single_instance;
    }
    public void addMeasuringDB(Measuring measuring) {
        String sql = "INSERT INTO measuring (id, name, price, category) " +
                "VALUES (?, ?, ?, ?)";
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, measuring.getId());
            statement.setString(2, measuring.getName());
            statement.setDouble(3, measuring.getPrice());
            statement.setString(4, measuring.getCategory());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAllMeasuringsDB() {
        String sql = "DELETE FROM measuring";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAllMeasuringDB() {
        String sql = "SELECT * FROM measuring";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String category = resultSet.getString("category");

                System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price +
                        ", Category: " + category);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}






