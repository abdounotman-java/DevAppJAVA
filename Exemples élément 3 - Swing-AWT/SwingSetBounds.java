import javax.swing.*;
public class SwingSetBounds 
{
 public static void main(String arg[]) 
 {
  JFrame f = new JFrame("ILE - Java : GUI");
  f.setSize(300, 300);
  // Définir la disposition sur null
  f.setLayout(null);
  // Créer le bouton
  JButton btn = new JButton("Inscription en Mini-Projet ");
  // Définir la position et la taille du bouton
  btn.setBounds(40,30,200,40);
  f.add(btn);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  f.setLocationRelativeTo(null);
  f.setVisible(true);
 }
}