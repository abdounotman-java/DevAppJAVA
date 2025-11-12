package connexionjv;

import java.sql.* ;
import java.io.* ;

//import com.mysql.jdbc.driver.* ;

import com.mysql.jdbc.Driver.*;

public class ConnexionJV {

public static Savepoint savepoint;

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
         
         try{   
            //définir la gestion des transactions manuelles
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
   
            //définir un point de sauvegarde
            Savepoint savepoint = conn.setSavepoint("Savepoint1");
   
            String query = "INSERT INTO inscription " +
                   "VALUES (10, 'Sara', 30, 'Larache')";
            stmt.executeUpdate(query); 
   
           //Soumettre une instruction SQL mal formée qui brise le code
            query = "INSERT INTO inscription " +
                   "VAL (11, 'Aniss', 26, 'Oued Laou')";
            stmt.executeUpdate(query);

            // S'il n'y a pas d'erreur.
            conn.commit();
            }
        catch(SQLException se)
            {
            // S'il y a une erreur.
            conn.rollback(savepoint);
            }
         
         
         conn.close();         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
   }
         
}

