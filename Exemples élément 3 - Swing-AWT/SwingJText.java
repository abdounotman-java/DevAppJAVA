import javax.swing.*;
public class SwingJText {
 public static void main(String[] args) {
   JFrame frame = new JFrame("ILE - Java : Zone de Textes ");
   
   JTextArea desc = new JTextArea();
   desc.setBounds(15,20,250,100);
   JTextField txtlog = new JTextField(" > User Name <");
   txtlog.setBounds(45,140,100,30); 
   JPasswordField password = new JPasswordField(); 
   password.setBounds(150,140,100,30);
   frame.add(desc);
   frame.add(txtlog);
   frame.add(password); 
   frame.setSize(350, 250);
   frame.setLayout(null);
   frame.setVisible(true);   
 }
}