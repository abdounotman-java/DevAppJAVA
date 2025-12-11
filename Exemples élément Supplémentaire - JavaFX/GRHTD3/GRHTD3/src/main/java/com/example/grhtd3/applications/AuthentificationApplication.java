package com.example.grhtd3.applications;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthentificationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AuthentificationApplication.class.getResource("GRHAccueil-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 260);
        stage.setTitle("M36-AD : Authentification ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}