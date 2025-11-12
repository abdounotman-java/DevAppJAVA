package td1jdbc;

import java.sql.* ;

public class createdb {

    public createdb ()
    {
            try {
          // chargement de la classe par son nom
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l’hôte de la base et port
         String ip =  "localhost" ;  // dépend du contexte
         String port =  "3306" ;  // port MySQL par défaut
          // Chaîne de connexion
String conString = protocole +  "//" + ip +  ":" + port ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // dépend du contexte
         String motDePasse =  "FS.Tetouan_2023" ;  // dépend du contexte
         // C. Connexion
         Connection conct = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
        
        // D. Exécuter la requéte
        Statement stmt = conct.createStatement();
        //étape 4: exécuter la requéte
        System.out.println("\n >> Création de la base de données ...");
        stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS DBStds");
        System.out.println("Base de données DBStds crée avec succés ...\n\n");

        // E. Fermer la connexion
         conct.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
    }

}
/*package td1jdbc;

import java.sql.* ;

public class createdb {

    public createdb ()
    {
       try {
          // chargement de la classe par son nom
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l’hôte de la base et port
         String ip =  "localhost" ;  // dépend du contexte
         String port =  "3306" ;  // port MySQL par défaut
          // Chaîne de connexion
         String conString = protocole +  "//" + ip +  ":" + port ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // dépend du contexte
         String motDePasse =  "FS.Tetouan_2023" ;  // dépend du contexte
         // C. Connexion
         Connection conct = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
        
        // D. Exécuter la requéte
        Statement stmt = conct.createStatement();
        //étape 4: exécuter la requéte
        System.out.println("\n >> Création de la base de données ...");
        stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS DBStds");
        System.out.println("Base de données DBStds crée avec succés ...\n\n");

        // E. Fermer la connexion
         conct.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
    }
}
*/