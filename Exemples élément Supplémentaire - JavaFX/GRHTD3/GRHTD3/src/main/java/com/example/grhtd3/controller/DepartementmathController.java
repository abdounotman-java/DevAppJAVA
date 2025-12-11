package com.example.grhtd3.controller;

        import com.example.grhtd3.models.Departement;
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

public class DepartementmathController   implements Initializable {

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
    private MenuItem idmenuprofcrud;

    @FXML
    private TableColumn<Professor, String> nomcol;

    @FXML
    private TableView<Professor> table;

    @FXML
    private TextField txtabout;

    @FXML
    private TextField txtannee;

    @FXML
    private TextField txtnom;

    @FXML
    private Button updateButton;

    @FXML
    void Modifier(ActionEvent event) {

    }

    @FXML
    void Supprimer(ActionEvent event) {

    }

    @FXML
    void professeurcrud(ActionEvent event) {

    }

    Connection con;
    PreparedStatement pst, pst1;
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

    public void table()
    {
        Connect();
        ObservableList<Professor> professors = FXCollections.observableArrayList();
        try
        {
            pst = con.prepareStatement("select * from professeur where iddep = 2 ");
            pst1 = con.prepareStatement("select * from departement where iddep = 2 ");
            ResultSet rs1 = pst1.executeQuery();
            while (rs1.next())
            {
                rs1.getString("iddep");
                txtnom.setText(rs1.getString("nomdep"));
                txtabout.setText(rs1.getString("aboutdep"));
                txtannee.setText(rs1.getString("annedep"));
            }

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
/*
                    id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                    txtnom.setText(table.getItems().get(myIndex).getnom());
                    txtemail.setText(table.getItems().get(myIndex).getemail());
                    txtgrade.setText(table.getItems().get(myIndex).getgrade());
                    txtgenre.setText(table.getItems().get(myIndex).getgenre());
                    txtdate.setText(table.getItems().get(myIndex).getdate());
                    txtdep.setText(table.getItems().get(myIndex).getdep());
*/
                }
            });
            return myRow;
        });


    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        table();
    }

}
