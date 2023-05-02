package com.example.projet_javafx;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloController {
    @FXML
    private TextField monId;
    @FXML
    private TextField monMdp;
    @FXML
    protected void onHelloButtonClick() throws IOException {
        /*String id, mdp;

        id = monId.getText();
        mdp = monMdp.getText();

        monMdp.setVisible(false);

        if(id.equals("admin") && mdp.equals("admin")) {
            Stage newWindow = new Stage();
            FXMLLoader fxmlLoader = new
                    FXMLLoader(HelloApplication.class.getResource("accueil.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            newWindow.setScene(scene);
            // Specifies the modality for new window.
            newWindow.initModality(Modality.APPLICATION_MODAL);
            newWindow.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur de connexion");
            alert.setHeaderText("Connexion");
            alert.setContentText("utilisateur non reconnu. Réessayez !");
            alert.showAndWait();
        }*/
        try {
            String serveur = "jdbc:mysql://172.19.0.34:3306/projetClef";
            String user = "phpmyadmin";
            String password = "0550002D";

            String id = monId.getText();
            String mdp = monMdp.getText();
            String motDePasse = "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connexion = DriverManager.getConnection(serveur, user, password);

            Statement st = connexion.createStatement();
            ResultSet rs = st.executeQuery("select nom, mdp from utilisateurs where nom ='" +  id + "'");
            if(rs.next())
            {
                motDePasse = "sio++" + mdp;

                Hasher hasher = Hashing.sha256().newHasher();
                hasher.putString(motDePasse, Charsets.UTF_8);
                HashCode sha256 = hasher.hash();
                if(sha256.toString().equals(rs.getString("mdp"))) {
                    Stage newWindow = new Stage();
                    FXMLLoader fxmlLoader = new
                            FXMLLoader(HelloApplication.class.getResource("accueil.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 640, 480);
                    newWindow.setScene(scene);
                    // Specifies the modality for new window.
                    newWindow.initModality(Modality.APPLICATION_MODAL);
                    newWindow.show();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Erreur de connexion");
                    alert.setHeaderText("Connexion");
                    alert.setContentText("L'identifiant ou le mdp est incorrect. Réessayez !");
                    alert.showAndWait();
                }

                //Cle uneCle = new Cle(rs.getInt("numeroClef"), rs.getString("couleurClef"), rs.getString("libelleClef"));
                //listItems.add(uneCle);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erreur de connexion");
                alert.setHeaderText("Connexion");
                alert.setContentText("utilisateur non reconnu, DOMMAAAAGE. Réessayez !");
                alert.showAndWait();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}