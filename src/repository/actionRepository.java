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


    public int getNumberOfActionsDB() {
        String sql = "SELECT COUNT(*) FROM action";
        int numberOfActions = 0;

        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                numberOfActions = resultSet.getInt(1);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberOfActions;
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


    public boolean isValidActionIdDB(long id, String actionType) {
        String tableName = getTableNameByActionType(actionType);
        if (tableName == null) {
            return false;
        }

        String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE id = ?";

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Return true if the action ID exists in the specified action type table
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Action getActionById(long id) {


        String sql = "SELECT * FROM action WHERE id = ?";

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve the action details from the result set
                long actionId = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                // Create an instance of the Action object with the retrieved details
                Action action = new Action(actionId, name, price);

                return action;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Return null if no action with the given ID is found
    }



    private String getTableNameByActionType(String ActionType) {
        switch (ActionType) {
            case "1":
                return "delivery";
            case "2":
                return "measuring";
            case "3":
                return "assembly";
            default:
                return null;
        }
    }
    public void deleteActionByIdDB(long id) {
        String sql = "DELETE FROM action WHERE id = ?";

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
