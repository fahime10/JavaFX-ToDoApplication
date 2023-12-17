package com.example.todoapplication.controller;

import com.example.todoapplication.animations.Shaker;
import com.example.todoapplication.database.DatabaseHelper;
import com.example.todoapplication.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    private AnchorPane window;

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
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error");

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
                } else {
                    Shaker shaker = new Shaker(window);
                    shaker.shake();
                    error.setContentText("Please provide correct credentials");
                    error.show();
                }
            } catch (SQLException e) {
                System.out.println("Something went wrong with the database...");
            } catch (NullPointerException e) {
                Shaker shaker = new Shaker(window);
                shaker.shake();
                error.setContentText("No credentials have been provided");
                error.show();
            }
        });
    }
}