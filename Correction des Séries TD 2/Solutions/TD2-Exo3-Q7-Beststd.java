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
         System.out.println(" >> Recherche de l'étudiant majorant de la promotion ...\n");
          // D. Exécuter des requêtes
            String sql = "SELECT ID, CNE, Nom, Note FROM student" +
                          " WHERE Note = (" +
                          " SELECT MAX(Note) FROM student )";

         ResultSet res = smt.executeQuery(sql) ;
         System.out.println("L'étudiant majorant de la promotion M36-1D / SMI-S6 \n");
         System.out.print("ID\t|\tCNE\t\t|\tNom\t\t|\tNote\n");
         System.out.println("-------------------------------------------------------------------");
          while (res.next()) {
            //Récupérer par nom de colonne
            int id = res.getInt("ID");
            int cne = res.getInt("CNE");
            String nom = res.getString("Nom");
            float note = res.getFloat("Note");
            //Afficher les valeurs
            System.out.print(" " + id + "\t|\t");
            System.out.print(cne + "\t|\t");
            System.out.print(nom + "\t|\t");
            System.out.println(note);
          }

        // E. Fermer la connexion
         conct.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
    }
}
