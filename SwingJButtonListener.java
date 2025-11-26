import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
public class SwingJButtonListener {
 public static void main(String[] args) {
  JFrame frame = new JFrame("M3-JAVA : GUI ");
  JLabel label = new JLabel("Les Bouttons d'action ", JLabel.CENTER);
  //Définissez le panel
  JPanel panel = new JPanel();
  //Définir les boutons
  JButton btn1 = new JButton("Ajouter");    
  btn1.addActionListener(new ActionListener()
  {
    public void actionPerformed(ActionEvent e)
    {
      //afficher le jdialog lorsque le bouton est cliqué
      JDialog dialog = new JDialog(frame, "Ajout ... ", true);
      JLabel l = new JLabel("  L'ajout avec succès ... "); 
      dialog.add(l);
      dialog.setLocationRelativeTo(frame);
      dialog.setSize(200, 80);
      dialog.setVisible(true);
    }
  });
  
  JButton btn2 = new JButton("Annuler");
  // Ajouter les boutons au frame
  panel.add(btn1); 
  panel.add(btn2);   
  // Ajouter label et panel au frame
  frame.setLayout(new GridLayout(2, 1));
  frame.add(label);
  frame.add(panel); 
  frame.pack();
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(260, 150);
  frame.setVisible(true);
 }
}
