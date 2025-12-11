package com.example.grhtd3;

import com.example.grhtd3.NULL.ProfController;
import com.example.grhtd3.models.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GRHAccueilController  implements Initializable {

    @FXML
    private Button addButton;

    //@FXML
    //private ComboBox<?> cbgrade;

    @FXML
    private TableColumn<Professor, String> datecol;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<Professor, String> depprofcol;

    @FXML
    private TableColumn<Professor, String> emailcol;

    @FXML
    private TableColumn<Professor, String> genrecol;

    @FXML
    private TableColumn<Professor, String> gradecol;

    @FXML
    private TableColumn<Professor, String> idcol;

    @FXML
    private TableColumn<Professor, String> nomcol;

    /*@FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;*/

    @FXML
    private TableView<Professor> table;

    @FXML
    private TextField txtdate;

    @FXML
    private TextField txtgrade;

    @FXML
    private TextField txtgenre;


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
        String stidpr, stnompr, stgenrepr, stemailpr, stdatepr, stgradepr, stdeppr;
        stnompr = txtnom.getText();
        stgenrepr = txtgenre.getText();
        stemailpr = txtemail.getText();
        stdatepr = txtdate.getText();
        stgradepr = txtgrade.getText();
        stdeppr = txtdep.getText();

        try
        {
            //idprof,
            pst = con.prepareStatement("insert into professeur(nomprof, genreprof, emailprof, dateprof, gradeprof, iddep)values(?,?,?,?,?,?)");
            pst.setString(1, stnompr);
            pst.setString(2, stgenrepr);
            pst.setString(3, stemailpr);
            pst.setString(4, stdatepr);
            pst.setString(5, stgradepr);
            pst.setString(6, stdeppr);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Gestion des professeurs FS-Tétouan");


            alert.setHeaderText("Professeur Recrutement");
            alert.setContentText("Professeur est ajouté avec Succès !");
            txtnom.setText("");
            txtemail.setText("");
            txtgenre.setText("");
            txtgrade.setText("");
            txtdate.setText("");
            txtdep.setText("");
            alert.showAndWait();

            table();

            txtnom.setText("");
            txtemail.setText("");
            txtgenre.setText("");
            txtgrade.setText("");
            txtdate.setText("");
            txtdep.setText("");
            //txtgrade.requestFocus();
        }
        catch (SQLException ex)
        {
            //FXMLDocument
            Logger.getLogger(ProfController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void Modifier(ActionEvent event) {
        myIndex = table.getSelectionModel().getSelectedIndex();

        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
        String stidpr, stnompr, stgenrepr, stemailpr, stdatepr, stgradepr, stdeppr;
        stnompr = txtnom.getText();
        stgenrepr = txtgenre.getText();
        stemailpr = txtemail.getText();
        stdatepr = txtdate.getText();
        stgradepr = txtgrade.getText();
        stdeppr = txtdep.getText();

        try
        {
            //pst = con.prepareStatement("insert into professeur(nomprof, genreprof, emailprof, dateprof, gradeprof, iddep)values(?,?,?,?,?,?)");
            //pst = con.prepareStatement("update registation set name = ?,mobile = ? ,course = ? where id = ? ");
            pst = con.prepareStatement("update professeur set nomprof = ?, genreprof = ?, emailprof = ?, dateprof = ?, gradeprof = ?, iddep = ? where idprof = ? ");
            pst.setString(1, stnompr);
            pst.setString(2, stgenrepr);
            pst.setString(3, stemailpr);
            pst.setString(4, stdatepr);
            pst.setString(5, stgradepr);
            pst.setString(6, stdeppr);
            pst.setInt(7, id);
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Gestion des professeurs FS-Tétouan");


            alert.setHeaderText("Modification Professuer");
            alert.setContentText("Professeur est modifié avec succès !");

            alert.showAndWait();
            table();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ProfController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void Supprimer(ActionEvent event) {
        myIndex = table.getSelectionModel().getSelectedIndex();

        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));


        try
        {
            pst = con.prepareStatement("delete from professeur where idprof = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Gestion des professeurs FS-Tétouan ");


            alert.setHeaderText("Suppression Professeur");
            alert.setContentText("Proffeseur est supprimé avec succès !");

            alert.showAndWait();
            table();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ProfController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void table()
    {
        Connect();
        ObservableList<Professor> professors = FXCollections.observableArrayList();
        try
        {
            pst = con.prepareStatement("select * from professeur");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Professor st = new Professor();
                    st.setIdpr(rs.getString("idprof"));
                    st.setnom(rs.getString("nomprof"));
                    st.setgenre(rs.getString("genreprof"));
                    st.setemail(rs.getString("emailprof"));
                    st.setdate(rs.getString("dateprof"));
                    st.setgrade(rs.getString("gradeprof"));
                    st.setdep(rs.getString("iddep"));
                    professors.add(st);
                }
            }
            table.setItems(professors);
            idcol.setCellValueFactory(f -> f.getValue().idProperty());
            nomcol.setCellValueFactory(f -> f.getValue().NomprProperty());
            emailcol.setCellValueFactory(f -> f.getValue().emailProperty());
            datecol.setCellValueFactory(f -> f.getValue().dateProperty());
            genrecol.setCellValueFactory(f -> f.getValue().genreProperty());
            gradecol.setCellValueFactory(f -> f.getValue().gradeProperty());
            depprofcol.setCellValueFactory(f -> f.getValue().depProperty());


        }

        catch (SQLException ex)
        {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setRowFactory( tv -> {
            TableRow<Professor> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  table.getSelectionModel().getSelectedIndex();

                    id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                    txtnom.setText(table.getItems().get(myIndex).getnom());
                    txtemail.setText(table.getItems().get(myIndex).getemail());
                    txtgrade.setText(table.getItems().get(myIndex).getgrade());
                    txtgenre.setText(table.getItems().get(myIndex).getgenre());
                    txtdate.setText(table.getItems().get(myIndex).getdate());
                    txtdep.setText(table.getItems().get(myIndex).getdep());

                }
            });
            return myRow;
        });


    }



    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;



    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprof","root","FS.Tetouan_2023");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        table();
    }

}
