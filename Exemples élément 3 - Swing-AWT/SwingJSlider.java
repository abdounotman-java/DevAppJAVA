import javax.swing.event.*;  
import javax.swing.*; 

public class SwingJSlider { 
 public static void main(String[] args) 
  { 
   JFrame frame = new JFrame("M3-JAVA : GUI");
   JLabel label = new JLabel(); 
   JPanel p = new JPanel(); 
   JSlider slider = new JSlider(0, 100, 20); 
   slider.setPaintTicks(true); 
   slider.setPaintLabels(true); 
   slider.setMajorTickSpacing(20); 
   slider.setMinorTickSpacing(5); 
   slider.addChangeListener(new ChangeListener() 
   {
    public void stateChanged(ChangeEvent e) {
    label.setText("La valeur du Slider est : " + slider.getValue());
   }});
   p.add(slider); 
   p.add(label); 
   frame.add(p); 
   label.setText("La valeur du Slider est : " + slider.getValue()); 
   frame.setSize(300, 150); 
   frame.setVisible(true); 
  } 
}
