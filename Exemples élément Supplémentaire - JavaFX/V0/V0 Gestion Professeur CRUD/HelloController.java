package com.example.profcrud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Button addButton;

    @FXML
    private ComboBox<?> cbgrade;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<?, ?> depprof;

    @FXML
    private TableColumn<?, ?> email;

    @FXML
    private TableColumn<?, ?> genre;

    @FXML
    private TableColumn<?, ?> grade;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> nom;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;

    @FXML
    private TableView<?> table;

    @FXML
    private TextField txtdate;

    @FXML
    private TextField txtdep;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtnom;

    @FXML
    private Button updateButton;

    @FXML
    void Ajouter(ActionEvent event) {

    }

    @FXML
    void Modifier(ActionEvent event) {

    }

    @FXML
    void Supprimer(ActionEvent event) {

    }

}
