package com.example.grhtd3.controller;

import com.example.grhtd3.models.Departement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import com.example.grhtd3.models.Professor;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ProfesseurController  implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private MenuItem idmenuprofcrud;


    @FXML
    private TableColumn<Professor, String> datecol;

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


    @FXML
    private TableView<Professor> table;


    @FXML
    private TextField txtdate;

    //@FXML
    //private TextField txtdep;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtgenre;

    @FXML
    private TextField txtgrade;

    @FXML
    private TextField txtnom;

    @FXML
    private Button updateButton;

    @FXML
    private ComboBox<String> txtdep;


    @FXML
    void Ajouter(ActionEvent event) {

        String stidpr, stnompr, stgenrepr, stemailpr, stdatepr, stgradepr, stdeppr, validdep = null;
        stnompr = txtnom.getText();
        stgenrepr = txtgenre.getText();
        stemailpr = txtemail.getText();
        stdatepr = txtdate.getText();
        stgradepr = txtgrade.getText();
        stdeppr = txtdep.getValue();

        try
        {
            pst2 = con.prepareStatement("select iddep from departement where nomdep = ? ");
            pst2.setString(1, stdeppr);
            ResultSet res2=pst2.executeQuery();

            while (res2.next()) {
                validdep = res2.getString("iddep");
            }

            //idprof,
            pst = con.prepareStatement("insert into professeur(nomprof, genreprof, emailprof, dateprof, gradeprof, iddep)values(?,?,?,?,?,?)");
            pst.setString(1, stnompr);
            pst.setString(2, stgenrepr);
            pst.setString(3, stemailpr);
            pst.setString(4, stdatepr);
            pst.setString(5, stgradepr);
            pst.setString(6, validdep);
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
            txtdep.setValue("");
            alert.showAndWait();

            table();

            txtnom.setText("");
            txtemail.setText("");
            txtgenre.setText("");
            txtgrade.setText("");
            txtdate.setText("");
            txtdep.setValue("");
            //txtgrade.requestFocus();
        }
        catch (SQLException ex)
        {
            //FXMLDocument
            //Logger.getLogger(com.example.grhtd3.NULL.ProfController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void Modifier(ActionEvent event) {
        myIndex = table.getSelectionModel().getSelectedIndex();

        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
        String stidpr, stnompr, stgenrepr, stemailpr, stdatepr, stgradepr, stdeppr,validdep = null;
        stnompr = txtnom.getText();
        stgenrepr = txtgenre.getText();
        stemailpr = txtemail.getText();
        stdatepr = txtdate.getText();
        stgradepr = txtgrade.getText();
        stdeppr = txtdep.getValue();

        try
        {
/*            String query1 = "select iddep from departement where nomdep = stdeppr";
            Statement stm2 = con.createStatement();
            ResultSet res2 = stm2.executeQuery(query1);
*/
            pst2 = con.prepareStatement("select iddep from departement where nomdep = ? ");
            pst2.setString(1, stdeppr);
            ResultSet res2=pst2.executeQuery();

            while (res2.next()) {
                validdep = res2.getString("iddep");
            }
            pst = con.prepareStatement("update professeur set nomprof = ?, genreprof = ?, emailprof = ?, dateprof = ?, gradeprof = ?, iddep = ? where idprof = ? ");

            pst.setString(1, stnompr);
            pst.setString(2, stgenrepr);
            pst.setString(3, stemailpr);
            pst.setString(4, stdatepr);
            pst.setString(5, stgradepr);

            pst.setString(6, validdep);
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
            //Logger.getLogger(com.example.grhtd3.NULL.ProfController.class.getName()).log(Level.SEVERE, null, ex);
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
           // Logger.getLogger(com.example.grhtd3.NULL.ProfController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void professeurcrud(ActionEvent event) {

    }



    Connection con;
    PreparedStatement pst, pst2, pst1;
    int myIndex;
    int id;
    String deplis[] = new String[10];


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

    public void table()
    {
//        txtdep.getItems().removeAll();
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
                    st.setdep(deplis[Integer.valueOf(rs.getString("iddep"))-1]);
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
                    //txtdep.setText(table.getItems().get(myIndex).getdep());
                    txtdep.setValue(table.getItems().get(myIndex).getdep());
                    //txtdep.setText(deplis[Integer.valueOf(table.getItems().get(myIndex).getdep())-1]);
                    //txtdep.setValue(String.valueOf(table.getItems().get(myIndex).getdep()));
                    //System.out.println("le département sélctionné : " + (deplis[Integer.valueOf(table.getItems().get(myIndex).getdep())-1]));
                    //listdep.setValue(deplis[Integer.valueOf(table.getItems().get(myIndex).getdep())-1]);

                }
            });
            return myRow;
        });


    }


    public void listedepart() {
        Connect();

    }
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
            try
            {
                // first I execute the query that select name of department one by one
                String query = "Select nomdep from departement";
                Statement stm1 = con.createStatement();
                ResultSet res1 = stm1.executeQuery(query);
                txtdep.getItems().removeAll();
                int i=0;
                while (res1.next()) {
                    txtdep.getItems().addAll(res1.getString("nomdep")) ;
                    deplis[i++] = res1.getString("nomdep");
                }
            }

            catch (SQLException ex)
            {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

            table();

    }

}
