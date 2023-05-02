package com.example.projet_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ModifierCle implements Initializable {

    @FXML
    private ListView<Cle> listBoxCle;

    @FXML
    private TextField newCouleurCle;

    @FXML
    private TextField newLibelleCle;

    @FXML
    private Button btnConfirmer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Cle laCle = AccueilController.selectionnee;
        newCouleurCle.setText(laCle.getCouleur());
        newLibelleCle.setText(laCle.getLibelle());
    }

    public void actionConfirmer(ActionEvent actionEvent) {

        String serveur = "jdbc:mysql://172.19.0.34:3306/projetClef";
        String user = "phpmyadmin";
        String password = "0550002D";

        try {
            Connection connexion = DriverManager.getConnection(serveur, user, password);
            Statement st = connexion.createStatement();
            Cle laCle = AccueilController.selectionnee;
            st.execute("UPDATE clef SET couleurClef = '" + newCouleurCle.getText() + "', libelleClef = '" + newLibelleCle.getText() + "' WHERE numeroClef = " + laCle.getNumero());
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Succès");
            alert1.setHeaderText("Réussi");
            alert1.setContentText("La clé a bien été modifiée!");
            alert1.showAndWait();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actionQuitter(ActionEvent actionEvent) {
        Stage window = (Stage) btnConfirmer.getScene().getWindow();
        window.close();
    }
}

