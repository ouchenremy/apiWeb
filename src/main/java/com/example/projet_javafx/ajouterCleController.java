package com.example.projet_javafx;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ajouterCleController implements Initializable {

    @FXML
    private TextField zoneNumeroCle;

    @FXML
    private TextField zoneCouleurCle;

    @FXML
    private TextField zoneLibelleCle;

    @FXML
    private Button btnAnnuler;
    public void confirmerAction(ActionEvent actionEvent) {
        String serveur = "jdbc:mysql://172.19.0.34:3306/projetClef";
        String user = "phpmyadmin";
        String password = "0550002D";
        if(zoneNumeroCle.getText() != "" && Integer.parseInt(zoneNumeroCle.getText()) > 0 && zoneCouleurCle.getText() != "" && zoneLibelleCle.getText() != "") {
            try {
                Connection connexion = DriverManager.getConnection(serveur, user, password);
                PreparedStatement stmt;
                stmt = connexion.prepareStatement("INSERT INTO clef VALUES (?, ?, ?)");
                stmt.setInt(1, Integer.parseInt(zoneNumeroCle.getText()));
                stmt.setString(2, zoneCouleurCle.getText());
                stmt.setString(3, zoneLibelleCle.getText());
                stmt.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Saisi");
                alert.setContentText("Votre clé à bien été ajouté :)");
                alert.showAndWait();
            } catch (SQLException e) {

                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Erreur");
                alert1.setHeaderText("Saisi");
                alert1.setContentText("Cette clé existe déjà. Veuillez recommencer !");
                alert1.showAndWait();
                throw new RuntimeException(e);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur de saisi");
            alert.setHeaderText("Saisi");
            alert.setContentText("Il y a eu une erreur dans la saisi de votre nouvelle clé. Veuillez recommencer !");
            alert.showAndWait();
        }
    }

    public void annulerAction(ActionEvent actionEvent) throws IOException {
            Stage window = (Stage) btnAnnuler.getScene().getWindow();
            window.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // force the field to be numeric only
        zoneNumeroCle.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    zoneNumeroCle.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
