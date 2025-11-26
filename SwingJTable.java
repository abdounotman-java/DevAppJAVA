import javax.swing.*;

public class SwingJTable {
 public static void main(String[] args) {
  JFrame frame = new JFrame("M3-JAVA : JTable : Liste étudiants ");
  String[] column = {"ID", "CNE", "Nom", "Note"};
  //Les lignes du JTable
  String[][] data = {{"01", "20854367", "Boujdain Ritaj", "11"}, 
	                 {"02", "19237645", "Zougrar Kamal", "14"}, 
	                 {"03", "27361238", "Belkbir Maroan", "09"} };
  // Créer le JTable
  JTable table = new JTable(data, column);
  JScrollPane scroll = new JScrollPane(table); 
  frame.add(scroll);
  frame.pack();
  frame.setSize(300, 200);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
 }
}
