import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.CellEditorListener;
import java.awt.Component;
import java.awt.event.*;
import java.util.EventObject;

public class SwingJTableDelete 
{
  public static void main(String[] args) 
  {  
	    String[] columns = new String[] {"ID", "CNE", "Nom", "Note"," "};
	  //Les lignes du JTable
	    Object[][] data = new Object[][] {{"01", "20854367", "Boujdain Ritaj", "11", " "}, 
		                 {"02", "19237645", "Zougrar Kamal", "14", " "}, 
		                 {"03", "27361238", "Belkbir Maroan", "09", " "} };
    
    //définir le modéle de JTable
    DefaultTableModel model = new DefaultTableModel(data, columns);
    //crée un JTable avec des données
    JTable table = new JTable(model);

    //définir notre Renderer sur la colonne " "
    table.getColumn(" ").setCellRenderer(new MyRendererAndEditor(table));
    table.getColumn(" ").setCellEditor(new MyRendererAndEditor(table));

    JFrame f = new JFrame("M36-AD : JTable & Delete : Liste étudiants ");

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new JScrollPane(table));
    f.setSize(500, 180);
    f.setVisible(true);
  }
}

class MyRendererAndEditor implements TableCellRenderer, TableCellEditor 
{
  private JButton btn;
  private int row;

  MyRendererAndEditor(JTable table) {
    btn = new JButton("Supprimer");
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(row);
      }
    });
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object 
  value, boolean isSelected, boolean hasFocus, int row, int column) 
  {
    return btn;
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object 
  value, boolean isSelected, int row, int column) 
  {
    this.row = row;
    return btn;
  }

  @Override
  public Object getCellEditorValue() { return true; }

  @Override
  public boolean isCellEditable(EventObject anEvent) { return true; }

  @Override
  public boolean shouldSelectCell(EventObject anEvent) { return true; }

  @Override
  public boolean stopCellEditing() { return true; }

  @Override
  public void cancelCellEditing() {}

  @Override
  public void addCellEditorListener(CellEditorListener l) {}

  @Override
  public void removeCellEditorListener(CellEditorListener l) {}
}
