package com.example.authentificationjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import java.awt.event.ActionEvent;

public class HelloController {
    @FXML private Label labelres;
    @FXML private TextField txtlog;
    @FXML private PasswordField txtpass;
    @FXML private Button btncon;
    @FXML private Button btnannul;

    public void connecter(javafx.event.ActionEvent actionEvent) {
        if(txtlog.getText().equals("Admin")==true && txtpass.getText().equals("FS_2023")==true)
        {
            labelres.setTextFill(Paint.valueOf("#008000"));
            labelres.setText("OK, Bienvenue en JavaFX Application!");
        }
        else
        {
            labelres.setTextFill(Paint.valueOf("#FF0000"));
            labelres.setText("ECHEC, erreur d'authentification !!!!");
        }

    }

    public void annuler(javafx.event.ActionEvent actionEvent) {
        txtlog.setText("");
        txtpass.setText("");
        labelres.setText("  ");
    }
}