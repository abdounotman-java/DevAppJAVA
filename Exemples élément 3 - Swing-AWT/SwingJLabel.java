import javax.swing.JFrame;
import javax.swing.JLabel;
public class SwingJLabel {
 public static void main(String[] args) {
  JFrame frame = new JFrame("ILE - Java : GUI ");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(265, 200);
  JLabel label = new JLabel("Les composants Swing : JLabel", JLabel.CENTER);
  frame.add(label);
  frame.setVisible(true);
 }
}
