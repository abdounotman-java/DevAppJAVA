import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;

public class SwingJTableAdd 
{  
    //TextField
    private JTextField text1, text2, text3, text4;
  
    // Header de JTable 
    public static final String[] columns = {
        "Nom", "Age", "Adresse"
    };
    // Créer le modèle de table
    private DefaultTableModel model = new DefaultTableModel(columns, 0);
    // Créer la table
    private JTable table = new JTable(model);
    // Créer le panneau principale
    private JPanel mainPanel = new JPanel(new BorderLayout());

    public SwingJTableAdd() 
    {
        //Bouton Add
        JButton addButton = new JButton("+ Add");
        //Bouton Clear
        JButton clearButton = new JButton("Clear");
        //Panneau des boutons
        JPanel buttonPanel = new JPanel();
        //Ajouter les boutons au panneau
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
    
        // Ce code est appelé lorsque le bouton Add est cliqué.
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //Ajouter les données du formulaire
              model.addRow(
                   new Object[]{
                         text1.getText(), 
                         text2.getText(),
                         text3.getText()
                   }
              );
            }
        });
    
        // Ce code est appelé lorsque le bouton Clear est cliqué.
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //Effacer le formulaire
              text1.setText("");
              text2.setText("");
              text3.setText("");
            }
        });
    
        //Créer le panneau de JTextFields
        JPanel textPanel = new JPanel(new BorderLayout());
        text1 = new JTextField("Saisir le Nom... ");
        text2 = new JTextField("Saisir l'Age...");
        text3 = new JTextField("Saisir l'Adresse...");
        //Ajouter les JTextFields au panneau
        textPanel.add(text1, BorderLayout.NORTH);
        textPanel.add(text2, BorderLayout.CENTER);
        textPanel.add(text3, BorderLayout.SOUTH);
  
        //Ajouter les panneaus et la table au panneau principale
        mainPanel.add(textPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    //Récupérer le panneau principale
    public JComponent getComponent() {
        return mainPanel;
    }
    // démarrer mon application en thread-safe
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("AD-M36 : Ajout direct dans JTable");
                f.getContentPane()
                 .add(new SwingJTableAdd().getComponent());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(340,250);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}
