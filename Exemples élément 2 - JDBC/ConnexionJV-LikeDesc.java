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
         String sql = "SELECT id, nom, age, adresse FROM inscription" +
           " WHERE nom LIKE '%med%'" +
           " ORDER BY nom DESC";
         ResultSet res = smt.executeQuery(sql);
         //étape 5: extraire les données
         while(res.next()){
         //Récupérer par nom de colonne
         int id = res.getInt("id");
         String nom = res.getString("nom");
         int age = res.getInt("age");
         String adresse = res.getString("adresse");
         //Afficher les valeurs
         System.out.print("ID: " + id);
         System.out.print(", Nom: " + nom);
         System.out.print(", Age: " + age);
         System.out.println(", Adresse: " + adresse);
         }
         // E. Fermer la connexion
         con.close();         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }
   }
         
}