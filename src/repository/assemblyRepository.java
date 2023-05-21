package repository;

import config.DatabaseConnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class assemblyRepository {
    private static assemblyRepository single_instance = null;

    public assemblyRepository() {
    }

    public static synchronized assemblyRepository getInstance() {
        if (single_instance == null) {
            single_instance = new assemblyRepository();
        }
        return single_instance;
    }
    public void addAssemblyDB(Assembly assembly) {
        String sql = "INSERT INTO assembly (id, name, price, number_of_products, number_of_employees) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, assembly.getId());
            statement.setString(2, assembly.getName());
            statement.setDouble(3, assembly.getPrice());
            statement.setInt(4, assembly.getNumber_of_products());
            statement.setInt(5, assembly.getNumber_of_employees());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAllAssembliesDB() {
        String sql = "DELETE FROM assembly";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}






