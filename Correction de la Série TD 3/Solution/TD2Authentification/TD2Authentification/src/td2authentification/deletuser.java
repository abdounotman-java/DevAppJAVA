package td2authentification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class deletuser {

public deletuser(){
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
         
         System.out.println("\n >> Suppression d'un utilisateur ...");
         //Préparation de notre Requête paramétrée
         
            Scanner s=new Scanner(System.in);
            System.out.print("\n   - Entrer > Nom de l'utilisateur à supprimer :   ");
            String slogin=s.next();                       
            PreparedStatement stmtcmd = con.prepareStatement("DELETE FROM TUsers WHERE login = ?");
            stmtcmd.setString(1,slogin);
            int i=stmtcmd.executeUpdate();
            
            System.out.println(" Suppression ...");
           
           System.out.println("L'utilisateur " + slogin + " supprimé avec succès  ...");
         
         // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }        

}    
}
