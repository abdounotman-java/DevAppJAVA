import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class SwingJTableDynamic extends JPanel 
{
    //Header de JTable 
	  String[] columns = new String[] {"ID", "CNE", "Nom", "Note"};
    //données pour JTable dans un tableau 2D
	  Object[][] data = new Object[][] {
		   				 {"01", "20854367", "Boujdain Ritaj", "11"}, 
		                 {"02", "19237645", "Zougrar Kamal", "14"}, 
		                 {"03", "27361238", "Belkbir Maroan", "09"} };

     //crée un JTable avec des données
    JTable table = new JTable(data, columns);

    TableRowSorter<TableModel> sort = new TableRowSorter<>(table.getModel());

    JTextField textField = new JTextField();

    public SwingJTableDynamic() 
    {
        //définir la largeur de la 3éme colonne sur 200 pixels
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(2).setPreferredWidth(200);
    
        table.setRowSorter(sort);

        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Chercher un mot:"), BorderLayout.WEST);
        p.add(textField, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(p, BorderLayout.SOUTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        textField.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String str = textField.getText();
                if (str.trim().length() == 0) {
                    sort.setRowFilter(null);
                } else {
                    sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String str = textField.getText();
                if (str.trim().length() == 0) {
                    sort.setRowFilter(null);
                } else {
                    sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
               JFrame f = new JFrame("M36-AD : JTable Dynamic : Liste étudiants ");
               f.add(new SwingJTableDynamic());
               f.setSize(500, 180);
               f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               f.setLocationRelativeTo(null);
               f.setVisible(true);
            }
        });
    }
}