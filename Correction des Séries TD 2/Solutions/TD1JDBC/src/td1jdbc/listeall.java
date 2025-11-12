package td1jdbc;

import java.sql.*;

public class listeall {

    public listeall(){
                 try {
          // A. Enregistrer la classe de pilote
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l’hôte de la base et port
         String ip =  "localhost" ;  // dépend du contexte
         String port =  "3306" ;  // port MySQL par défaut
          // Nom de la base ;
         String nomBase =  "DBStds" ;  // dépend du contexte
          // Chaîne de connexion
         String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // dépend du contexte
         String motDePasse =  "FS.Tetouan_2023" ;  // dépend du contexte
          // B. Créer une connexion
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
         // C. Créer un objet Statement
         Statement smt = con.createStatement() ;
         System.out.println(" >> Générer la liste des convoqués en CR ...\n");
          // D. Exécuter des requêtes
    
                  String sql = "SELECT ID, CNE, Nom, Note FROM student" +
                          " ORDER BY Nom ASC";

         ResultSet res = smt.executeQuery(sql) ;
         System.out.println("Liste Des Étudiants Convoqués Aux Contrôles De La Session Rattrapage \n");
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
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }        

    }
}
