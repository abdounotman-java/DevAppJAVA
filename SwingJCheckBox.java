import java.awt.*;
import javax.swing.*;
public class SwingJCheckBox {
 public static void main(String[] args) {
  JFrame frame = new JFrame("M3-JAVA : GUI ");
  JLabel label = new JLabel("CheckBox : Langages ", JLabel.CENTER);
  //Définissez le panel
  JPanel panel = new JPanel();
  // Créer des cases à cocher    
  JCheckBox checkBox1 = new JCheckBox("C/C++", true);
  JCheckBox checkBox2 = new JCheckBox("Java", true);
  JCheckBox checkBox3 = new JCheckBox("PHP", false);
  JCheckBox checkBox4 = new JCheckBox("Python", true);
  // Ajouter les cases à cocher au frame
  panel.add(checkBox1); 
  panel.add(checkBox2);
  panel.add(checkBox3);
  panel.add(checkBox4);
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
