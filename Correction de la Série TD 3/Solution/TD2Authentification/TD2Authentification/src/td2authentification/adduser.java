package td2authentification;
import java.util.Scanner;
import java.sql.* ;
import java.io.* ;
import com.mysql.jdbc.Driver.*;

public class adduser {
public adduser()
{  
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
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO TUsers(login, passwd) values(?,?)");
         Scanner s=new Scanner(System.in);
         System.out.println("Ajout d'un nouveau utilsateur : ");
         System.out.print("   >  Entrer Login :   ");
         String slog=s.next();
         System.out.print("   >  Entrer Mot de Pass :   ");
         String spass=s.next();
         
         stmt.setString(1,slog);
         stmt.setString(2,spass);
         
         int i=stmt.executeUpdate();
         System.out.println("\n\n L'utilsateur " + slog + " est ajouté avec succés");
         
         conn.close();         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }    
    }
}