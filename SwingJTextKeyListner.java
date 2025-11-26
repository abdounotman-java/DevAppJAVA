import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingJTextKeyListner extends JFrame 
{  
   public static void main(String[]args){
      new SwingJTextKeyListner().initComponent();
   }
   public void initComponent() {
      setLayout(new FlowLayout());
      JLabel lbl = new JLabel("Entrez l'âge : ");
      JTextField zoneage = new JTextField(10);
      add(lbl);
      add(zoneage);
   
      zoneage.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
             char c = e.getKeyChar();
             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                  e.consume();  // ignorer l'événement 
             }
         }
      });
   
      setSize(310,70);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
}

