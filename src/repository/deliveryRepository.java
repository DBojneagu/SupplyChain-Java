package repository;

import config.DatabaseConnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class deliveryRepository {
    private static deliveryRepository single_instance = null;

    public deliveryRepository() {
    }

    public static synchronized deliveryRepository getInstance() {
        if (single_instance == null) {
            single_instance = new deliveryRepository();
        }
        return single_instance;
    }
        public void addDeliveryDB(Delivery delivery) {
            String sql = "INSERT INTO delivery (id, name, price, vehicle_brand, vehicle_type) " +
                    "VALUES (?, ?, ?, ?, ?)";
            try {
                Connection connection = DatabaseConnection.getInstance();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setLong(1, delivery.getId());
                statement.setString(2, delivery.getName());
                statement.setDouble(3, delivery.getPrice());
                statement.setString(4, delivery.getVehicle_brand());
                statement.setString(5, delivery.getVehicle_type());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    public void deleteAllDeliveriesDB() {
        String sql = "DELETE FROM delivery";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void printAllDeliveriesDB() {
        String sql = "SELECT * FROM delivery";

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String vehicleBrand = resultSet.getString("vehicle_brand");
                String vehicleType = resultSet.getString("vehicle_type");

                System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price +
                        ", Vehicle Brand: " + vehicleBrand + ", Vehicle Type: " + vehicleType);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfDeliveryDB() {
        String sql = "SELECT COUNT(*) FROM delivery";
        int numberOfDelivery = 0;

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                numberOfDelivery = resultSet.getInt(1);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberOfDelivery;
    }

    public void deleteDeliveryByIdDB(long id) {
        String sql = "DELETE FROM delivery WHERE id = ?";

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDeliveryByIdDB(long id, Delivery updatedDelivery) {
        String sql = "UPDATE delivery SET name = ?, price = ?, vehicle_brand = ?, vehicle_type = ? WHERE id = ?";

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, updatedDelivery.getName());
            statement.setDouble(2, updatedDelivery.getPrice());
            statement.setString(3, updatedDelivery.getVehicle_brand());
            statement.setString(4, updatedDelivery.getVehicle_type());
            statement.setLong(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}






