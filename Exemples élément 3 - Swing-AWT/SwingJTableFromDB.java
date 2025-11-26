import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class SwingJTableFromDB 
{
  public static void main(String[] args) 
  {
    try 
  {
     String url = "jdbc:mysql://localhost:3306/dbemploye";
     String user = "root";
     String password = "FS.Tetouan_2023";
     Connection con = DriverManager.getConnection(url, user, password);      
     String query = "SELECT * FROM inscription";
     Statement stm = con.createStatement();
     ResultSet res = stm.executeQuery(query);
     int size = 0;
     while (res.next()) size++;
     res = stm.executeQuery(query);
     String columns[] = { "ID", "Nom", "Age" , "Adresse"};
     String data[][] = new String[size][4];
     int i = 0;
     while (res.next()) {
        int id = res.getInt("id");
        String nom = res.getString("nom");
        int age = res.getInt("age");
        String adr = res.getString("adresse");
        data[i][0] = id + "";
        data[i][1] = nom;
        data[i][2] = age + "";
        data[i][3] = adr;
        i++;
      }
     DefaultTableModel model = new DefaultTableModel(data, columns);
     JTable table = new JTable(model);
     table.setShowGrid(true);
     table.setShowVerticalLines(true);
     JScrollPane pane = new JScrollPane(table);
     JFrame f = new JFrame("M36-AD : JTable from DB : Liste des inscrits");
     JPanel panel = new JPanel();
     panel.add(pane);
     f.add(panel);
     f.setSize(500, 250);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setVisible(true);    
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }
}