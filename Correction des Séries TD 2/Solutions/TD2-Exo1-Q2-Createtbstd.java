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
          // Adresse IP de l�h�te de la base et port
         String ip =  "10.18.1.1" ;  // d�pend du contexte
         String port =  "3306" ;  // port MySQL par d�faut
          // Nom de la base ;
         String nomBase =  "DBStds" ;  // d�pend du contexte
          // Cha�ne de connexion
         String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // d�pend du contexte
         String motDePasse =  "FSTet.23" ;  // d�pend du contexte
	 // B. Cr�er une connexion
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;

         /// C. Cr�er un objet Statement
         Statement smt = con.createStatement() ;
        System.out.println("\n >> Cr�ation de la table ...");
          // D. Ex�cuter des requ�tes
         String sql =  "CREATE TABLE IF NOT EXISTS STUDENT " +
                       "(ID INTEGER NOT NULL AUTO_INCREMENT, " +
                       " CNE INTEGER, " + 
                       " Nom VARCHAR(100), " + 
                       " Note DEC, " + 
                       " PRIMARY KEY ( ID ))";
         
         smt.executeUpdate(sql);
         System.out.println("La table STUDENT cr��e avec succ�s ...");

        // E. Fermer la connexion
         conct.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
    }
}
