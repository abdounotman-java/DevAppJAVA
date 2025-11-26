import java.awt.*;
import javax.swing.*;
public class SwingJRadioButton {
 public static void main(String[] args) {
  JFrame frame = new JFrame("M3-JAVA : GUI ");
  JLabel label = new JLabel("Les Boutons Radio : GENRE ", JLabel.CENTER);
  //Définissez le panel
  JPanel panel = new JPanel();
  //Créer des boutons radio
  ButtonGroup group = new ButtonGroup();     
  JRadioButton radio1 = new JRadioButton("Male", true);
  JRadioButton radio2 = new JRadioButton("Female", false);
  // Ajouter les boutons radio au groupe
  group.add(radio1);
  group.add(radio2);
  // Ajouter les boutons au frame
  panel.add(radio1); 
  panel.add(radio2);// Ajouter label et panel au frame
  frame.setLayout(new GridLayout(2, 1));
  frame.add(label);
  frame.add(panel); 
  frame.pack();
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(260, 150);
  frame.setVisible(true);
 }
}
