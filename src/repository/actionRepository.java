package repository;

import config.DatabaseConnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class actionRepository {
    private static actionRepository single_instance = null;
    public actionRepository(){}
    public static synchronized actionRepository getInstance(){
        if(single_instance == null){
            single_instance = new actionRepository();
        }
        return single_instance;
    }
    public void addActionDB(Action action) {
        String sql = "INSERT INTO action (id, name,price) " +
                "VALUES (?, ?, ?)";
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, action.getId());
            statement.setString(2,action.getName());
            statement.setDouble(3,action.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void printAllActionsDB() {
        String sql = "SELECT * FROM action";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAllActionsDB() {
        String sql = "DELETE FROM action";
        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
