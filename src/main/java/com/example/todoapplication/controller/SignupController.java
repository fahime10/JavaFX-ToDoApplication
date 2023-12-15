package com.example.todoapplication.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox signupCheckboxFemale;

    @FXML
    private CheckBox signupCheckboxMale;

    @FXML
    private TextField signupFirstName;

    @FXML
    private TextField signupLastName;

    @FXML
    private TextField signupLocation;

    @FXML
    private PasswordField signupPassword;

    @FXML
    private Button signupSubmitButton;

    @FXML
    private TextField signupUsername;

    @FXML
    void initialize() {

    }
}
