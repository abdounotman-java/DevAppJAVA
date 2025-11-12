package connexionjv;
import java.util.Scanner;

import java.sql.* ;
import java.io.* ;

//import com.mysql.jdbc.driver.* ;

import com.mysql.jdbc.Driver.*;

public class ConnexionJV {

public  static  void main (String[] args) {
       try {
          // A. Enregistrer la classe de pilote
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l’hôte de la base et port
         String ip =  "localhost" ;  // dépend du contexte
         String port =  "3306" ;  // port MySQL par défaut
          // Nom de la base ;
         String nomBase =  "dbemploye" ;  // dépend du contexte
          // Chaîne de connexion
         String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // dépend du contexte
         String motDePasse =  "Pass.Word" ;  // dépend du contexte
          // B. Créer une connexion
         Connection conn = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
         

         PreparedStatement stmt = conn.prepareStatement("INSERT INTO inscription values(?,?,?,?)");
         Scanner s=new Scanner(System.in);
         
         int nbr=0;
         String choix="oui";
         while(choix.equals("oui"))
         {
	 System.out.println("  --- Ajout de l'employe " + ++nbr + "  --- ");
         System.out.println("Entrer id : ");
         int sid=s.nextInt();
         System.out.println("Entrer Nom : ");
         String sname=s.next();
         System.out.println("Entrer Age : ");
         int sage=s.nextInt();
         System.out.println("Entrer Ville : ");
         String sville=s.next();
         
         stmt.setInt(1,sid);
         stmt.setString(2,sname);
         stmt.setInt(3,sage);
         stmt.setString(4,sville);
         
         int i=stmt.executeUpdate();
         System.out.println(i+" inséré avec succés");
         System.out.println("\nVous voulez ajouter un autre employe (oui/non) ?");
        choix=s.next();
         }
         conn.close();         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
   }
         
}


