package td2authentification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class listeusers {

   public listeusers(){
                    try {
          // A. Enregistrer la classe de pilote
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l’hôte de la base et port
         String ip =  "localhost" ;  // dépend du contexte
         String port =  "3306" ;  // port MySQL par défaut
          // Nom de la base ;
         String nomBase =  "DBCafe" ;  // dépend du contexte
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
         System.out.println(" >> Générer la liste des utilisateurs enregistrés ...\n");
          // D. Exécuter des requêtes
    
                  String sql = "SELECT iduser, login, passwd, ConnectionNbr FROM TUsers" +
                          " ORDER BY iduser ASC";

         ResultSet res = smt.executeQuery(sql) ;
         System.out.println("Liste Des utilisateurs enregistrés \n");
         System.out.print("ID\t|\tLogin\t\t|\tPassWd\t\t|\tNbr Connect\n");
         System.out.println("-------------------------------------------------------------------------");
          while (res.next()) {
            //Récupérer par nom de colonne
            int id = res.getInt("iduser");
            String log = res.getString("login");
            String pass = res.getString("passwd");
            int nconect = res.getInt("ConnectionNbr");
            //Afficher les valeurs
            System.out.print(" " + id + "\t|\t");
            System.out.print(log + "\t\t|\t");
            System.out.print(pass + "\t\t|\t");
            System.out.println(nconect);
  
}
         // E. Fermer la connexion
         con.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }        
   }
}
