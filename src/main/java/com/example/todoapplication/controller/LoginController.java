package com.example.todoapplication.controller;

import com.example.todoapplication.database.DatabaseHelper;
import com.example.todoapplication.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginSignupButton;

    @FXML
    private TextField username;

    private DatabaseHelper databaseHelper;

    @FXML
    void initialize() {
        databaseHelper = new DatabaseHelper();

        loginSignupButton.setOnAction(event -> {
            loginSignupButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/todoapplication/signup.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        loginButton.setOnAction(event -> {
            User user = new User();

            user.setUsername(username.getText().trim());
            user.setPassword(password.getText().trim());

            ResultSet result = databaseHelper.getUser(user);

            int counter = 0;

            try {
                while (result.next()) {
                    counter++;
                }

                if (counter == 1) {
                    System.out.println("Login Successful");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}