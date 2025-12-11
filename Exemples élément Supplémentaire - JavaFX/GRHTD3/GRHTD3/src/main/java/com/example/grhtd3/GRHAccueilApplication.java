package com.example.grhtd3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GRHAccueilApplication extends Application {
    @Override
    public void start(Stage primarystage) throws IOException {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("authentification-view.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(GRHAccueilApplication.class.getResource("authentification-view.fxml"));
        Scene scene = new Scene(root, 500, 300);
        primarystage.setTitle("M36-AD : GRH de la FS-Tétouan");
        primarystage.setScene(scene);
        primarystage.show();
    }catch(IOException e){
        e.printStackTrace();
    }
    }

    public static void main(String[] args) {
        launch();
    }
}