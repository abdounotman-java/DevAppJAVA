package com.example.grhtd3.controller;

import com.example.grhtd3.GRHAccueilApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Platform.exit;

public class Accueil {

    @FXML
    private MenuItem idabout;
    @FXML
    private MenuItem idprofesseur;

    @FXML
    private MenuItem iddepinfo;

    @FXML
    void sedeconnecter(ActionEvent event) {
    exit();
    }


        @FXML
    void aboutgrh(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader4 = new FXMLLoader(GRHAccueilApplication.class.getResource("about-view.fxml"));
            Scene scene4 = new Scene(fxmlLoader4.load(), 600, 400);
            Stage stage4 = new Stage();
            stage4.setTitle("M36-AD : GRH de la FS-Tétouan - ABOUT ");
            stage4.setScene(scene4);
            stage4.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void deprtamentinformatique(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader3 = new FXMLLoader(GRHAccueilApplication.class.getResource("departement-view.fxml"));
            Scene scene3 = new Scene(fxmlLoader3.load(), 565, 550);
            Stage stage3 = new Stage();
            stage3.setTitle("M36-AD : GRH de la FS-Tétouan - Dépatement Informatique");
            stage3.setScene(scene3);
            stage3.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void departementmathematique(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader4 = new FXMLLoader(GRHAccueilApplication.class.getResource("departementmath-view.fxml"));
            Scene scene4 = new Scene(fxmlLoader4.load(), 565, 550);
            Stage stage4 = new Stage();
            stage4.setTitle("M36-AD : GRH de la FS-Tétouan - Dépatement Mathématique");
            stage4.setScene(scene4);
            stage4.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void professeurcrud(javafx.event.ActionEvent actionEvent) {
    //void professeurcrud(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(GRHAccueilApplication.class.getResource("professeur-view.fxml"));
            Scene scene2 = new Scene(fxmlLoader2.load(), 565, 550);
            Stage stage2 = new Stage();
            stage2.setTitle("M36-AD : GRH de la FS-Tétouan - Gestion Professeurs");
            stage2.setScene(scene2);
            stage2.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
