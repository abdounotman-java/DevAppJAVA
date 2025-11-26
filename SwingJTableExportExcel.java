
import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

class SwingJTableExportExcel extends JFrame
{
	//Header de JTable 
	  String[] columns = new String[] {"ID", "CNE", "Nom", "Note"};
      //données pour JTable dans un tableau 2D
	  Object[][] data  = new Object[][] {
  		   				 {"01", "20854367", "Boujdain Ritaj", "11"}, 
  		                 {"02", "19237645", "Zougrar Kamal", "14"}, 
  		                 {"03", "27361238", "Belkbir Maroan", "09"} };

  
 
  //crée un JTable avec des données
  JTable table = new JTable(data, columns);
  JPanel panel = new JPanel(new BorderLayout());
  JButton btn = new JButton("Export");

  public SwingJTableExportExcel(){
    setSize(450,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setTitle("M36-AD : Exporter JTable en Excel");
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
          fw.write(m.getValueAt(i,j).toString()+"\t");
        }
        fw.write("\n");
      }

      fw.close();
    }
    catch(IOException e){ System.out.println(e); }
  }

  public static void main(String[] args){
        new SwingJTableExportExcel();
  }

  class MyListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if(e.getSource() == btn){
           JFileChooser fchoose = new JFileChooser();
           int option = fchoose.showSaveDialog(SwingJTableExportExcel.this);
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
