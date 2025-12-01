
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InterfaceAccueil {
	public static void main(String[] args) {
		JFrame frame = new JFrame("M36-AD : TD3 - Gestion GRH ");
			  //Définissez le panel
			  JPanel panel = new JPanel();
			// Définir le menu principal
		      JMenuBar menu = new JMenuBar();
		      JMenu prof = new JMenu("Gestion Professeurs");
		      JMenu dep = new JMenu("Gestion Départements");
		      JMenu help = new JMenu("Aide");
		      // Définir le sous-menu pour Fichier
		      JMenuItem newpr = new JMenuItem("Recruter");		      
		      newpr.addActionListener(new ActionListener() {
		          
		          public void actionPerformed(ActionEvent e) {
		        	  recruter f1 = new recruter();
		        	  f1.setLocationRelativeTo(null);
		        	  f1.setVisible(true);
		          }
		      });
		      JMenuItem updatpr = new JMenuItem("Modifier");
		      updatpr.addActionListener(new ActionListener() {
		          
		          public void actionPerformed(ActionEvent e) {
		        	  updateprof f2 = new updateprof();
		        	  f2.setLocationRelativeTo(null);
		        	  f2.setVisible(true);
		          }
		      });
		      JMenuItem listpr = new JMenuItem("Lister/Exporter");
		      listpr.addActionListener(new ActionListener() {
		          
		          public void actionPerformed(ActionEvent e) {
		        	  listeprof f3 = new listeprof();
		        	  f3.setLocationRelativeTo(null);
		        	  f3.setVisible(true);
		          }
		      });

		      JMenuItem depinfo = new JMenuItem("Département Informatique");
		      JMenuItem depmath = new JMenuItem("Département Mathématique");
		      JMenuItem depphys = new JMenuItem("Département Physique");
		      JMenuItem apropos = new JMenuItem("À-propos");
		      apropos.addActionListener(new ActionListener() {
		          
		          public void actionPerformed(ActionEvent e) {
		                JFrame fdialog = new JFrame(" À-propos ... ");
		                JPanel dialog = new JPanel();
		                ImageIcon icon1 = new ImageIcon("C:\\fstlogo.png");
		  		        JLabel l1 = new JLabel("  Application Java (SWING/AWT) "); 
		                JLabel l2 = new JLabel("  pour la gestion des professeurs ");
		                JLabel l3 = new JLabel("  de la faculté des sciences à Tétouan  ");
		                dialog.add(new JLabel(icon1));		  		        
		                dialog.add(l1);
		                dialog.add(l2);
		                dialog.add(l3);
		                fdialog.add(dialog);
		                fdialog.setSize(350, 400);
		                dialog.setBackground(Color.white);
		                fdialog.setLocationRelativeTo(null);
		                fdialog.setVisible(true);
		      
		          }
		      });
		      prof.add(newpr);
		      prof.add(updatpr);
		      prof.add(listpr);
		      dep.add(depinfo);
		      dep.add(depmath);
		      dep.add(depphys);
		      help.add(apropos);
		      menu.add(prof);
		      menu.add(dep);
		      menu.add(help);
		      ImageIcon icon = new ImageIcon("C:\\fs-tetouan.png");
		      panel.add(new JLabel(icon));
		      frame.add(menu, BorderLayout.NORTH);
		      frame.add(panel, BorderLayout.CENTER);
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  frame.setSize(500, 600);
			  frame.setLocationRelativeTo(null);
			  frame.setVisible(true); 

	}
}
