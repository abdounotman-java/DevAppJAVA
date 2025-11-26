import javax.swing.*;
import javax.swing.event.*;
public class SwingJSpinner 
{
 public static void main(String[] args) 
 {  
  JFrame frame = new JFrame("M3-JAVA : GUI ");  
  JLabel label = new JLabel();          
  label.setHorizontalAlignment(JLabel.CENTER);  
  label.setSize(250,100);    
  SpinnerModel model = new SpinnerNumberModel(
                1, //valeur initiale
                1, //valeur minimum
                10, //valeur maximum
                1 //pas
    ); 
  JSpinner sp = new JSpinner(model); 
  sp.setBounds(100,100,45,30);  
  frame.add(sp);  
  frame.add(label);
  frame.setSize(250,250);  
  frame.setLayout(null);  
  frame.setVisible(true);  
  //lorsque la flèche haut ou la flèche bas est appuyé
  sp.addChangeListener(new ChangeListener() {
    public void stateChanged(ChangeEvent e) {
    label.setText("Quantité : " + ((JSpinner)e.getSource()).getValue() + " (Kg)");
                                            }});
 }
}