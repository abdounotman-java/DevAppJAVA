import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class SwingJTableSupOne extends JFrame 
{
   private JTable table;
   private JButton btn;
   private DefaultTableModel tablemodel;
   private String[] columns;
   private Object[][] rows;
   
   public SwingJTableSupOne() 
   {
      setTitle("M36-AD : JTable-Supprimer une ligne selectionnée ");
      //Header de JTable 
  	  columns = new String[] {"ID", "CNE", "Nom", "Note"};
      //données pour JTable dans un tableau 2D
  	  rows  = new Object[][] {
  		   				 {"01", "20854367", "Boujdain Ritaj", "11"}, 
  		                 {"02", "19237645", "Zougrar Kamal", "14"}, 
  		                 {"03", "27361238", "Belkbir Maroan", "09"} };

      
      tablemodel = new DefaultTableModel(rows, columns);
      table = new JTable(tablemodel);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      btn = new JButton("Supprimer");
    
      btn.addActionListener(new ActionListener() 
      {
         @Override
         public void actionPerformed(ActionEvent ae) 
         {
            // vérifier d'abord la ligne sélectionnée
            if(table.getSelectedRow() != -1) 
            {
               // supprimer la ligne sélectionnée du modèle de table
               tablemodel.removeRow(table.getSelectedRow());
               JOptionPane.showMessageDialog(null, "Etudiant supprimé avec succès ....");
            }
         }
      });
    
      add(new JScrollPane(table), BorderLayout.CENTER);
      add(btn, BorderLayout.SOUTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(420, 320);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   public static void main(String args[]) 
   {
      new SwingJTableSupOne();
   }
}