package com.example.todoapplication.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private Button signupButton;

    @FXML
    private TextField username;

    @FXML
    void initialize() {
        loginButton.setOnAction(event -> {
            System.out.println("Login clicked");
        });
    }
}