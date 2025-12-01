
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

class listeprof extends JFrame
{
	private static final long serialVersionUID = 1L;
	//Header de JTable 
	  String[] columns = new String[] {"ID", "NOM", "GENRE", "EMAIL", "DATE", "GRADE", "DEPARTEMENT"};
      //données pour JTable dans un tableau 2D
	  //Object[][] data  = new Object[][] {{"","","","","",""} };
	     String data[][] = new String[10][7];

  
 
  //crée un JTable avec des données
  JTable table = new JTable(data, columns);
  JPanel panel = new JPanel(new BorderLayout());
  JButton btn = new JButton("Export");

  public listeprof(){
	
	    try 
	    {
	       String url = "jdbc:mysql://localhost:3306/dbprof";
	       String user = "root";
	       String password = "FS.Tetouan_2023";
	       Connection con = DriverManager.getConnection(url, user, password);      
	       String query = "SELECT * FROM professeur";
	       Statement stm = con.createStatement();
	       ResultSet res = stm.executeQuery(query);
	       int size = 0;
	       while (res.next()) size++;
	       res = stm.executeQuery(query);
	       table.setSize(size, 7);
	       int i = 0;
		   String data[][] = new String[size][7];
	       while (res.next()) {
	    	  String id = res.getString("idprof");
	          String nom = res.getString("nomprof");
	          String genre = res.getString("genreprof");
	          String email = res.getString("emailprof");
	          String date = res.getString("dateprof");
	          String grade = res.getString("gradeprof");
	          String depprof = res.getString("iddep");
	          data[i][0] = id + "";
	          data[i][1] = nom;
	          data[i][2] = genre + "";
	          data[i][3] = email;
	          data[i][4] = date + "";
	          data[i][5] = grade;
	          data[i][6] = depprof + "";
	          
	          i++;
	        }
	       DefaultTableModel model = new DefaultTableModel(data, columns);
	       table.setModel(model);
	       table.setShowGrid(true);
	       table.setShowVerticalLines(true);
	       con.close();
	      } catch(SQLException e) {
	        e.printStackTrace();
	      }  
	  
    setSize(700,200);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setTitle("M36-AD : TD3 - Gestion GRH <<  Lister/Exporter Liste des professeurs  >> ");
    panel.add(btn, BorderLayout.SOUTH);
    panel.add(new JScrollPane(table), BorderLayout.NORTH);
    add(panel);
    setVisible(true);
    btn.addActionListener(new MyListener());
  }

  public void export(JTable table, File file){
    try
    {
      TableModel m = table.getModel();
      FileWriter fw = new FileWriter(file);

      for(int i = 0; i < m.getColumnCount(); i++){
        fw.write(m.getColumnName(i) + "\t");
      }

      fw.write("\n");

      for(int i=0; i < m.getRowCount(); i++) {
        for(int j=0; j < m.getColumnCount(); j++) {
          fw.write(m.getValueAt(i,j)+"\t");
        }
        fw.write("\n");
      }

      fw.close();
    }
    catch(IOException e){ System.out.println(e); }
  }


  class MyListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if(e.getSource() == btn){
           JFileChooser fchoose = new JFileChooser();
           int option = fchoose.showSaveDialog(listeprof.this);
           if(option == JFileChooser.APPROVE_OPTION){
             String name = fchoose.getSelectedFile().getName(); 
             String path = fchoose.getSelectedFile().getParentFile().getPath();
             String file = path + "\\" + name + ".xls"; 
             export(table, new File(file));
           }
         }
      }
  }
}


