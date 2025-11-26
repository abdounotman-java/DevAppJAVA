import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import javax.swing.event.*;

public class SwingJTableUpdate 
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

    public SwingJTableUpdate() 
    {
        //Bouton Add
        JButton addButton = new JButton("+ Add");
        //Bouton Update
        JButton updateButton = new JButton("Update");
        //Panneau des boutons
        JPanel buttonPanel = new JPanel();
        //Ajouter les boutons au panneau
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
    
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
        
              //Effacer le formulaire aprés l'ajout
              text1.setText("Saisir le Nom ....");
              text2.setText("Saisir l'Age ....");
              text3.setText("Saisir l'Adresse ....");
            }
        });

          // Récupérer la ligne sélectionnée de JTable dans JTextfields
          table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
          @Override
          public void valueChanged(ListSelectionEvent e) {
                int i = table.getSelectedRow();
                text1.setText((String)model.getValueAt(i, 0));
                text2.setText((String)model.getValueAt(i, 1));
                text3.setText((String)model.getValueAt(i, 2));
            }
        });
    
        // Ce code est appelé lorsque le bouton Update est cliqué.
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //Mettre à jour le formulaire
               int i = table.getSelectedRow();
               model.setValueAt(text1.getText(), i, 0);
               model.setValueAt(text2.getText(), i, 1);
               model.setValueAt(text3.getText(), i, 2);
            }
        });
    
        //Créer le panneau de JTextFields
        JPanel textPanel = new JPanel(new BorderLayout());
        text1 = new JTextField("Saisir le Nom ....");
        text2 = new JTextField("Saisir l'Age ....");
        text3 = new JTextField("Saisir l'Adresse ....");
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
                JFrame f = new JFrame("M36-AD : Mettre à jour une ligne JTable");
                f.getContentPane().add(new SwingJTableUpdate().getComponent());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(340,250);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}
