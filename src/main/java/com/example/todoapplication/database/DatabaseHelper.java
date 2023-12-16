package com.example.todoapplication.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHelper extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" +
                                  dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);

        return dbConnection;
    }

    public void addNewUser(String firstName, String lastName, String username,
                           String password, String location, String gender) {
        String query = "INSERT INTO " + Const.USER_TABLE + "(" + Const.FIRST_NAME +
                        ", " + Const.LAST_NAME + ", " + Const.USERNAME + ", " +
                        Const.PASSWORD + ", " + Const.LOCATION + ", " + Const.GENDER + ") " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, location);
            preparedStatement.setString(6, gender);

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
