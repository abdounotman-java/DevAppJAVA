package td1jdbc;

import java.sql.* ;
import java.io.* ;
import com.mysql.jdbc.Driver.*;

public class createdb {

    public createdb ()
    {
       try {
          // chargement de la classe par son nom
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l’hôte de la base et port
         String ip =  "10.18.1.1" ;  // dépend du contexte
         String port =  "3306" ;  // port MySQL par défaut
          // Nom de la base ;
         String nomBase =  "DBStds" ;  // dépend du contexte
          // Chaîne de connexion
         String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // dépend du contexte
         String motDePasse =  "FSTet.23" ;  // dépend du contexte
	 // B. Créer une connexion
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
         // C. Créer un objet Statement
         Statement smt = con.createStatement() ;
         System.out.println("\n >> Ajout des étudiants dans la table  ...");
          // D. Exécuter des requêtes
         System.out.println("Insertion...");
    
         String sql = "INSERT INTO STUDENT (CNE, Nom, Note)" +
                   "VALUES (20854367, 'Boujdain Amal', 11)";		
         smt.executeUpdate(sql);
         
         sql = "INSERT INTO STUDENT (CNE, Nom, Note)" +
                   "VALUES (19237645, 'Zougrar Imad', 14)";
         smt.executeUpdate(sql);
         
         sql = "INSERT INTO STUDENT (CNE, Nom, Note)" +
                   "VALUES (27361238, 'Dadi Maroan', 04)";         				
         smt.executeUpdate(sql);
         
         System.out.println("Les données des étudiants insérés dans la table STUDENT avec succés ...");

        // E. Fermer la connexion
         conct.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
    }
}
