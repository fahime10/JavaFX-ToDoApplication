package com.example.todoapplication.controller;

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

    @FXML
    void initialize() {
        String loginUsername = username.getText().trim();
        String loginPassword = password.getText().trim();

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
            if (!loginUsername.equals("") && !loginPassword.equals("")) {
                loginUser(loginUsername, loginPassword);
            } else {
                System.out.println("Error logging in...");
            }
        });
    }

    private void loginUser(String username, String password) {

    }
}