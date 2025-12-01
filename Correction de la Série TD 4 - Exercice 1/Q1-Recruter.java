import java.io.* ;
import com.mysql.jdbc.Driver.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import java.sql.*;

public class recruter {
 public static void main(String[] args) {

	  JFrame frame = new JFrame("M36-AD : TD3 - Gestion GRH << Recruter un nouveau professeur >>");
	  JPanel mainPanel = new JPanel(new BorderLayout());
	  JLabel label = new JLabel("Recrutement d'un nouveau professeur à la FS-Tétouan ", JLabel.CENTER);
	  JPanel textPanel = new JPanel(new BorderLayout());	
      JTextField txtid = new JTextField("    >>  Saisir l'identifiant du professeur  <<   ");
      JTextField txtnom = new JTextField("    >>  Saisir le nom du professeur  <<   ");
      JTextField txtemail = new JTextField("    >>  Saisir l'émail du professeur  <<   ");
      JTextField txtdate = new JTextField("    >>  Saisir la date de recrutement du professeur  <<   ");
      JTextField txtdep = new JTextField("    >>  Saisir le département du professeur  <<   ");
      txtdate.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e) {
              char c = e.getKeyChar();
              if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                   e.consume();  // ignorer l'événement 
              }
          }
       });

	  String[] grades = {"PESA", "PH", "PES"};
  	  JComboBox cbgrade = new JComboBox(grades);
  	  JPanel panelgenre = new JPanel();
  	  panelgenre.getBorder();
  	  ButtonGroup group = new ButtonGroup();     
  	  JRadioButton radio1 = new JRadioButton("Male", true);
  	  JRadioButton radio2 = new JRadioButton("Female", false);
  	  
  	  group.add(radio1);
  	  group.add(radio2);
  	  panelgenre.add(radio1); 
  	  panelgenre.add(radio2);// Ajouter label et panel au frame
  	  panelgenre.setLayout(new GridLayout(1, 2));

  	  radio1.setActionCommand("M");
  	  radio2.setActionCommand("F");
      JButton addButton = new JButton("Ajouter");
      JButton clearButton = new JButton("Clear");
      //Panneau des boutons
      JPanel buttonPanel = new JPanel();
      //Ajouter les boutons au panneau
      buttonPanel.add(addButton);
      buttonPanel.add(clearButton);
      // Ce code est appelé lorsque le bouton Add est cliqué.
      addButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            //Ajouter les données du formulaire
        	   try 
        	    {

            String url = "jdbc:mysql://localhost:3306/dbprof";
            String user = "root";
            String password = "FS.Tetouan_2023";
            Connection con = DriverManager.getConnection(url, user, password);      
            PreparedStatement stmt = con.prepareStatement("INSERT INTO professeur values(?,?,?,?,?,?,?)");
            stmt.setString(1,txtid.getText());
            stmt.setString(2,txtnom.getText());
            stmt.setString(3,group.getSelection().getActionCommand());
            stmt.setString(4,txtemail.getText());
            stmt.setString(5,txtdate.getText());
            stmt.setString(6,cbgrade.getSelectedItem().toString());
            stmt.setString(7,txtdep.getText());
            int i=stmt.executeUpdate();
            if(i!=0)
            {
                //afficher le jdialog lorsque le bouton est cliqué
                JDialog dialog = new JDialog(frame, "Ajout ... ", true);
                JLabel l = new JLabel("  L'ajout du professeur avec succès ... "); 
                dialog.add(l);
                dialog.setLocationRelativeTo(frame);
                dialog.setSize(300, 100);
                dialog.setVisible(true);
            }
            con.close();         
           }  catch (Exception eE) {
           // gestion des exceptions
               System.out.println(eE);
           }

          }
      });
  
      // Ce code est appelé lorsque le bouton Clear est cliqué.
      clearButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            //Effacer le formulaire
            txtid.setText("    >>  Saisir l'identifiant du professeur  <<   "); 
            txtnom.setText("    >>  Saisir le nom du professeur  <<   ");
            txtemail.setText("    >>  Saisir l'émail du professeur  <<   ");
            txtdate.setText("    >>  Saisir la date de recrutement du professeur  <<   ");
            txtdep.setText("    >>  Saisir le département du professeur  <<   ");
      	    cbgrade.setSelectedIndex(-1);            
          }
      });
      textPanel.add(txtid);
      textPanel.add(txtnom);
      textPanel.add(txtemail);
      textPanel.add(txtdate);
      textPanel.add(txtdep);
      textPanel.add(panelgenre);
      textPanel.add(cbgrade);
      textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
      
      frame.add(mainPanel, BorderLayout.CENTER);
	  mainPanel.add(label, BorderLayout.NORTH);
	  mainPanel.add(textPanel, BorderLayout.CENTER);
	  mainPanel.add(buttonPanel, BorderLayout.SOUTH);
	  
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setSize(500, 300);
	  frame.setVisible(true); 

	}

}
