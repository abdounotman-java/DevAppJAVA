package connexionjv;

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
         String motDePasse =  "Pass.Wrd" ;  // dépend du contexte
          // B. Créer une connexion
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
         // C. Créer un objet Statement
         Statement smt = con.createStatement() ;
          // D. Exécuter des requêtes
         System.out.println("Suppression ...");
         String sql = "DELETE FROM inscription WHERE id = 3";
         smt.executeUpdate(sql);
         System.out.println("L'enregistrement avec l'id = 3 a été supprimer avec succès...");
         // E. Fermer la connexion
         con.close();         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }
   }
         
}