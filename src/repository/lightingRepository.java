package repository;

import config.DatabaseConnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class lightingRepository {
    private static lightingRepository single_instance = null;

    public lightingRepository() {
    }

    public static synchronized lightingRepository getInstance() {
        if (single_instance == null) {
            single_instance = new lightingRepository();
        }
        return single_instance;
    }
    public void addlightingDB(Lighting lighting) {
        String sql = "INSERT INTO lighting (id, name, price, stock,power,type) " +
                "VALUES (?, ?, ?, ?,?,?)";
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, lighting.getId());
            statement.setString(2, lighting.getName());
            statement.setDouble(3, lighting.getPrice());
            statement.setInt(4, lighting.getStock());
            statement.setInt(5, lighting.getPower());
            statement.setString(6, lighting.getType());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAllLighting() {
        String sql = "DELETE FROM lighting";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}






