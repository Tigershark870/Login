package com.example.login;


import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class RegistrierungController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    public void register(ActionEvent event) throws SQLException{

        Window owner = submitButton.getScene().getWindow();

        System.out.println(nameField.getText());
        System.out.println(emailField.getText());
        System.out.println(passwordField.getText());

        if(nameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Error!",
                    "Bitte den Namen eintragen");
            return;
        }

        if(emailField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Error!",
                    "Bitte die E-Mail Adresse eintragen");
            return;
        }
        if(passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Error!",
                    "Bitte das Passwort eintragen");
            return;
        }

        String name = nameField.getText();
        String email = emailField.getText();
        String passwort = passwordField.getText();

        UserDAO dao = new UserDAO();
        dao.insertRecord(name, email, passwort);

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registrierung erfolgreich",
                "Wilkommen " + nameField.getText());
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
