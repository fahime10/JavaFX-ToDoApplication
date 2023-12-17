package com.example.todoapplication.database;

import com.example.todoapplication.model.User;

import java.sql.*;

public class DatabaseHelper extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" +
                                  dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);

        return dbConnection;
    }

    public void addNewUser(User user) {
        String query = "INSERT INTO " + Const.USER_TABLE + "(" + Const.FIRST_NAME +
                        ", " + Const.LAST_NAME + ", " + Const.USERNAME + ", " +
                        Const.PASSWORD + ", " + Const.LOCATION + ", " + Const.GENDER + ") " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getLocation());
            preparedStatement.setString(6, user.getGender());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet result = null;

        if (!user.getUsername().equals("") || !user.getPassword().equals("")) {
            String query = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERNAME +
                           "=?" + " AND " + Const.PASSWORD + "=?";

            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());

                result = preparedStatement.executeQuery();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
