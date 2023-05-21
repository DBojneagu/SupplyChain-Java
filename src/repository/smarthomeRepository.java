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

}






