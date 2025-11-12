package connexionjv;

import java.io.BufferedReader;
import java.sql.* ;
import java.io.* ;

//import com.mysql.jdbc.driver.* ;

import com.mysql.jdbc.Driver.*;

public class ConnexionJV {

    private static BufferedReader keyboard = new BufferedReader( new InputStreamReader( System.in ) );
    
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
         String motDePasse =  "FS.Tetouan_2023" ;  // dépend du contexte
          // B. Créer une connexion
         Connection conn = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
        
	String readedLogin = "";
	System.out.println( "Bienvenue à l'espace Scolarité FS-Tétouan");
	while( true ) {
      	    System.out.print( "Login: ");
	    String login = keyboard.readLine();
	    System.out.print( "Password: ");
	    String password = keyboard.readLine();
            String strSql = "SELECT * FROM TUsers WHERE Login='" + login + "' AND Password='" + password + "'";
            Statement stmt = conn.createStatement(); 
            ResultSet res = stmt.executeQuery( strSql );
            if ( res.next() ) {
		strSql = "UPDATE TUsers SET ConnectionNbr=ConnectionNbr+1 WHERE ID=" + res.getInt( "ID" );
		Statement stUpdate = conn.createStatement();
                stUpdate.executeUpdate( strSql );
		readedLogin = res.getString( "login" );
		break;
	       }
	    System.out.println( "ERREUR, Mot de passe eronné" );
            }
         System.out.println( readedLogin + ", vous êtes connecté +++ " );
         conn.close();         
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
   }
         
}
