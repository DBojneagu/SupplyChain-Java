package repository;

import config.DatabaseConnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class furnitureRepository {
    private static furnitureRepository single_instance = null;

    public furnitureRepository() {
    }

    public static synchronized furnitureRepository getInstance() {
        if (single_instance == null) {
            single_instance = new furnitureRepository();
        }
        return single_instance;
    }
    public void addfurnitureDB(Furniture furniture) {
        String sql = "INSERT INTO furniture (id, name, price, stock,material,height,width) " +
                "VALUES (?, ?, ?, ?,?,?,?)";
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, furniture.getId());
            statement.setString(2, furniture.getName());
            statement.setDouble(3, furniture.getPrice());
            statement.setInt(4, furniture.getStock());
            statement.setString(5, furniture.getMaterial());
            statement.setDouble(6, furniture.getHeight());
            statement.setDouble(7, furniture.getWidth());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAllFurnitureDB() {
        String sql = "DELETE FROM furniture";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteFurnitureByIdDB(long id) {
        String sql = "DELETE FROM furniture WHERE id = ?";

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfFurnitureDB() {
        String sql = "SELECT COUNT(*) FROM furniture";
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


    public void printAllFurnitureDB() {
        String sql = "SELECT * FROM furniture";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int stock = resultSet.getInt("stock");
                String material = resultSet.getString("material");
                double height = resultSet.getDouble("height");
                double width = resultSet.getDouble("width");

                System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price +
                        ", Stock: " + stock + ", Material: " + material +
                        ", Height: " + height + ", Width: " + width);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}






