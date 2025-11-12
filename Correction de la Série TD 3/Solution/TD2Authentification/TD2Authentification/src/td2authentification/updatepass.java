package td2authentification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class updatepass {
    public updatepass() {
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
         Connection conn = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
         
         //Préparation de notre Requête paramétrée
         PreparedStatement stmt = conn.prepareStatement("UPDATE TUsers SET passwd = ? WHERE login = ?");
         Scanner s=new Scanner(System.in);
         System.out.println("  --- Modifier le mot de passe de l'utilisateur --- ");
            System.out.print("\n   - Entrer > le Login de l'utilsateur à modifier :   ");
            String slogin=s.next();           
            
            System.out.print("   - Entrer le nouveau mot de passe de l'utilisateur " + slogin + " :   ");
            String snewpass=s.next();
            
            stmt.setString(1, snewpass);
            stmt.setString(2,slogin);
            
            int i=stmt.executeUpdate();
            System.out.println("\n\n   >> " + i+" mot de passe modifée avec succés");
            
         conn.close();         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }

    }
    
}
