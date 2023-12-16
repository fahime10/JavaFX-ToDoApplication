package com.example.todoapplication.controller;

import com.example.todoapplication.database.DatabaseHelper;
import com.example.todoapplication.model.User;
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
        DatabaseHelper databaseHelper = new DatabaseHelper();

        signupSubmitButton.setOnAction(event -> {
            createUser();
        });
    }

    private void createUser() {
        DatabaseHelper databaseHelper = new DatabaseHelper();

        String firstName = signupFirstName.getText();
        String lastName = signupLastName.getText();
        String username = signupUsername.getText();
        String password = signupPassword.getText();
        String location = signupLocation.getText();
        String gender = "";

        if (signupCheckboxFemale.isSelected()) {
            gender = "Female";
        } else if (signupCheckboxMale.isSelected()) {
            gender = "Male";
        }

        User user = new User(firstName, lastName, username, password, location, gender);

        databaseHelper.addNewUser(user);

    }
}
