package com.example.projet_javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AccueilController implements Initializable{

    private int critereRecherche = 0;

    @FXML
    private ListView<Cle> listBoxCle;

    @FXML
    private ChoiceBox choixRecherche;

    @FXML
    private TextField zoneRecherche;

    static Cle selectionnee;

    static final ObservableList<Cle> listItems =
            FXCollections.observableArrayList();
    public void ajouterAction(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ajouterCle.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        newWindow.setScene(scene);
        // Specifies the modality for new window.
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String serveur = "jdbc:mysql://172.19.0.6:3306/projetClef";
        String user = "phpmyadmin";
        String password = "0550002D";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connexion = DriverManager.getConnection(serveur, user, password);

            Statement st = connexion.createStatement();
            ResultSet rs = st.executeQuery("select * from clef");

            while(rs.next())
            {
                Cle uneCle = new Cle(rs.getInt("numeroClef"), rs.getString("couleurClef"), rs.getString("libelleClef"));
                listItems.add(uneCle);
            }
            listBoxCle.setItems(listItems);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        //Adding action to the choice box
        choixRecherche.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                    this.critereRecherche = (int) new_val;
                });

    }

    public void supprimerAction(ActionEvent actionEvent) {

        int selectedItem = listBoxCle.getSelectionModel().getSelectedIndex();

        String serveur = "jdbc:mysql://172.19.0.6:3306/projetClef";
        String user = "phpmyadmin";
        String password = "0550002D";
        if(selectedItem >= 0) {
            try {
                Connection connexion = DriverManager.getConnection(serveur, user, password);
                Statement st = connexion.createStatement();
                Cle laCle = (Cle) listItems.get(selectedItem);
                st.execute("delete from clef where numeroClef = " + laCle.getNumero());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            listItems.remove(selectedItem);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur de selection");
            alert.setHeaderText("Selection");
            alert.setContentText("Veuillez sélectionner une clé à supprimer dans la liste !");
            alert.showAndWait();
        }
    }

    public void actionRechercher(ActionEvent actionEvent) {
        String serveur = "jdbc:mysql://172.19.0.6:3306/projetClef";
        String user = "phpmyadmin";
        String password = "0550002D";

        switch(critereRecherche) {

            case 0:
                try {
                    listItems.clear();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connexion = DriverManager.getConnection(serveur, user, password);

                    Statement st = connexion.createStatement();
                    ResultSet rs = st.executeQuery("select * from clef where numeroClef = " + zoneRecherche.getText());


                    while (rs.next()) {
                        Cle uneCle = new Cle(rs.getInt("numeroClef"), rs.getString("couleurClef"), rs.getString("libelleClef"));
                        listItems.add(uneCle);
                    }

                    listBoxCle.setItems(listItems);

                    if(listBoxCle.getItems().isEmpty())
                    {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Erreur");
                        alert.setHeaderText("Saisi");
                        alert.setContentText("Aucune clé avec ce numéro n'a été trouvée!");
                        alert.showAndWait();
                    }

                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case 1:
                try {
                    listItems.clear();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connexion = DriverManager.getConnection(serveur, user, password);

                    Statement st = connexion.createStatement();
                    ResultSet rs = st.executeQuery("select * from clef where couleurCLef LIKE '" + zoneRecherche.getText() + "%'");


                    while (rs.next()) {
                        Cle uneCle = new Cle(rs.getInt("numeroClef"), rs.getString("couleurClef"), rs.getString("libelleClef"));
                        listItems.add(uneCle);
                    }
                    listBoxCle.setItems(listItems);

                    if(listBoxCle.getItems().isEmpty())
                    {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Erreur");
                        alert.setHeaderText("Saisi");
                        alert.setContentText("Aucune clé avec cette couleur n'a été trouvée!");
                        alert.showAndWait();
                    }


                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case 2:
                try {
                    listItems.clear();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connexion = DriverManager.getConnection(serveur, user, password);

                    Statement st = connexion.createStatement();
                    ResultSet rs = st.executeQuery("select * from clef where libelleClef LIKE '" + zoneRecherche.getText() + "%'");


                    while (rs.next()) {
                        Cle uneCle = new Cle(rs.getInt("numeroClef"), rs.getString("couleurClef"), rs.getString("libelleClef"));
                        listItems.add(uneCle);
                    }
                    listBoxCle.setItems(listItems);

                    if(listBoxCle.getItems().isEmpty())
                    {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Erreur");
                        alert.setHeaderText("Saisi");
                        alert.setContentText("Aucune clé avec ce libellé n'a été trouvée!");
                        alert.showAndWait();
                    }


                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    public void modifierAction(ActionEvent actionEvent) throws IOException {


        int selectedItem = listBoxCle.getSelectionModel().getSelectedIndex();

        if(selectedItem >= 0) {
            AccueilController.selectionnee = listItems.get(selectedItem);
            Stage newWindow = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("modifierCle.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            newWindow.setScene(scene);
            // Specifies the modality for new window.
            newWindow.initModality(Modality.APPLICATION_MODAL);
            newWindow.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur de selection");
            alert.setHeaderText("Selection");
            alert.setContentText("Veuillez sélectionner une clé à modifier dans la liste !");
            alert.showAndWait();
        }
    }

    public void actionRaffraichir(ActionEvent actionEvent) {
        listItems.clear();
        String serveur = "jdbc:mysql://172.19.0.6:3306/projetClef";
        String user = "phpmyadmin";
        String password = "0550002D";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connexion = DriverManager.getConnection(serveur, user, password);

            Statement st = connexion.createStatement();
            ResultSet rs = st.executeQuery("select * from clef");

            while(rs.next())
            {
                Cle uneCle = new Cle(rs.getInt("numeroClef"), rs.getString("couleurClef"), rs.getString("libelleClef"));
                listItems.add(uneCle);
            }
            listBoxCle.setItems(listItems);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}