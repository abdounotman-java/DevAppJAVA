import java.awt.*;
import javax.swing.*;
public class SwingJComboBox {
 public static void main(String[] args) {
  JFrame frame = new JFrame("M3-JAVA : GUI ");
  JLabel label = new JLabel("ComboBox : Filières de la FS-Tétouan ", JLabel.CENTER);
  //Définissez le panel
  JPanel panel = new JPanel();
  //Set data in the drop-down list
  String[] filieres = {"SMI", "SMA", "SMP", "SMC", "SVI"};
  // Créer une liste déroulante
  JComboBox cb = new JComboBox(filieres);
  frame.setLayout(new GridLayout(6, 1));
  frame.add(label);
  frame.add(panel); 
  frame.add(cb);
  frame.pack();
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(260, 150);
  frame.setVisible(true);
 }
}
