import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


class updateprof  extends JFrame{
	  
	private static final long serialVersionUID = 1L;

	public updateprof() {
		  setTitle("M36-AD : TD3 - Gestion GRH << Modifier les informations d'un professeur >>");
		  JPanel mainPanel = new JPanel(new BorderLayout());
		  JTextField txtidsearch = new JTextField("    >>  Saisir l'identifiant du professeur à mettre à jour  <<   ");
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
	      JButton updateButton = new JButton("Modifier");
	      JButton clearButton = new JButton("Clear");
	      //Panneau des boutons
	      JPanel buttonPanel = new JPanel();
	      //Ajouter les boutons au panneau
	      buttonPanel.add(updateButton);
	      buttonPanel.add(clearButton);
	      // Ce code est appelé lorsque le bouton Add est cliqué.
	      updateButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            //Ajouter les données du formulaire
	        	   try 
	        	    {

	            String url = "jdbc:mysql://localhost:3306/dbprof";
	            String user = "root";
	            String password = "FS.Tetouan_2023";
	            Connection con = DriverManager.getConnection(url, user, password);      
	            PreparedStatement stmt = con.prepareStatement("UPDATE professeur SET idprof = ?, nomprof = ?, genreprof = ?, emailprof = ?, dateprof = ?, gradeprof = ?, iddep = ?  WHERE idprof = ?");
	              
	            stmt.setString(1,txtid.getText());
	            stmt.setString(2,txtnom.getText());
	            stmt.setString(3,group.getSelection().getActionCommand());
	            stmt.setString(4,txtemail.getText());
	            stmt.setString(5,txtdate.getText());
	            stmt.setString(6,cbgrade.getSelectedItem().toString());
	            stmt.setString(7,txtdep.getText());
	            stmt.setString(8,txtidsearch.getText());
	            int i=stmt.executeUpdate();
	            if(i!=0)
	            {
	                //afficher le jdialog lorsque le bouton est cliqué
	                JFrame dialog = new JFrame("Update ... ");
	                JLabel l = new JLabel("  Les informations du professeur modifiées avec succès ... "); 
	                dialog.add(l);
	                dialog.setSize(400, 100);
	                dialog.setLocationRelativeTo(null);
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
	            txtnom.setText("    >>  Saisir le nouveau nom du professeur  <<   ");
	            txtemail.setText("    >>  Saisir le nouveau émail du professeur  <<   ");
	            txtdate.setText("    >>  Saisir la nouvelle date de recrutement du professeur  <<   ");
	            txtdep.setText("    >>  Saisir le nouveau département du professeur  <<   ");
	            txtidsearch.setText("    >>  Saisir l'identifiant du professeur à mettre à jour  <<   ");
	      	    cbgrade.setSelectedIndex(-1);
	      	    textPanel.setVisible(false);
	      	    buttonPanel.setVisible(false);
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
	      textPanel.setVisible(false);
	      buttonPanel.setVisible(false);
	      
		  JPanel SearchPanel = new JPanel(new BorderLayout());	
	      JLabel Searchlabel = new JLabel("Saisir l'identifiant du professeur à mettre à jour : ", JLabel.CENTER);
	      JLabel SePlabel = new JLabel("                                                     ", JLabel.CENTER);
	      
		  JButton SearchButton = new JButton("Rechercher");
		  SearchPanel.add(Searchlabel, BorderLayout.NORTH);
		  SearchPanel.add(txtidsearch, BorderLayout.CENTER);
		  SearchPanel.add(SearchButton, BorderLayout.EAST);
		  SearchPanel.add(SePlabel, BorderLayout.SOUTH);
	      
		  SearchButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            //Ajouter les données du formulaire
	        	   try 
	        	    {

	            String url = "jdbc:mysql://localhost:3306/dbprof";
	            String user = "root";
	            String password = "FS.Tetouan_2023";
	            Connection con = DriverManager.getConnection(url, user, password);      
	 	        PreparedStatement stmt = con.prepareStatement("SELECT * FROM professeur WHERE idprof = ?");
	            stmt.setString(1,txtidsearch.getText());
	            ResultSet res = stmt.executeQuery();
	            if(res.next())
	            {
	                //afficher les infos du professeur
	            	textPanel.setVisible(true);
	            	buttonPanel.setVisible(true);
	            	String depprof = res.getString("iddep");
	            	txtid.setText(res.getString("idprof")); 
	                txtnom.setText(res.getString("nomprof"));
	                txtemail.setText(res.getString("emailprof"));
	                txtdate.setText(res.getString("dateprof"));
	                txtdep.setText( res.getString("iddep"));
	                if(res.getString("genreprof").equals("M"))
	                {
	                	radio1.setSelected(true);
	                    radio2.setSelected(false);
	                }
	                else
	                {
	                	radio2.setSelected(true);
	                    radio1.setSelected(false);
	                }
	                
	                if(res.getString("gradeprof").equals("PESA"))
	          	    	cbgrade.setSelectedIndex(0);
	          	    else if(res.getString("gradeprof").equals("PH"))
	          	    	cbgrade.setSelectedIndex(1);
	          	    else
	          	    	cbgrade.setSelectedIndex(2);
	            }
	            else
	            {
	            	//afficher le jdialog lorsque le prof recherché n'existe pas
	                JFrame dialog = new JFrame("Erreur ... ");
	                JLabel l = new JLabel("  Le professeur recherché n'existe pas ... "); 
	                dialog.add(l);
	                dialog.setSize(400, 100);
	                dialog.setLocationRelativeTo(null);
	                dialog.setVisible(true);
	            }
	            con.close();         
	           }  catch (Exception eE) {
	           // gestion des exceptions
	               System.out.println(eE);
	           }

	          }
	      });
	      
	      
		  mainPanel.add(SearchPanel, BorderLayout.NORTH);
		  mainPanel.add(textPanel, BorderLayout.CENTER);
		  mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		  add(mainPanel, BorderLayout.CENTER);
		  setLocationRelativeTo(null);
		  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  setSize(500, 300);
		  setVisible(true); 

		}
}
