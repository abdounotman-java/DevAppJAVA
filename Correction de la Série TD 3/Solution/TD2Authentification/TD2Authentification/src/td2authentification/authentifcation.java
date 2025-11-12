package td2authentification;
import java.io.BufferedReader;
import java.sql.* ;
import java.io.* ;

import com.mysql.jdbc.Driver.*;

public class authentifcation {

    private static BufferedReader keyboard = new BufferedReader( new InputStreamReader( System.in ) );

public  authentifcation() {
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
        
	String readedLogin = "";
	System.out.println( "\n >>>>>>>   Bienvenue à l'espace Commercial - Café    <<<<<<<<");
        int i=1;
	while( i<=3 ) {
            System.out.print( " \n\n ");
      	    System.out.print( "   >>   Login: ");
	    String login = keyboard.readLine();
	    System.out.print( "\n   >>   Password: ");
	    String password = keyboard.readLine();
            String strSql = "SELECT * FROM TUsers WHERE login=? AND passwd=?";
            PreparedStatement stmt = conn.prepareStatement(strSql); 
            stmt.setString(1, login);
            stmt.setString(2, password);
           // System.out.println(stmt);
            ResultSet res = stmt.executeQuery(  );
            
            if ( res.next() ) {
		strSql = "UPDATE TUsers SET ConnectionNbr=ConnectionNbr+1 WHERE iduser=?";
		PreparedStatement stUpdate = conn.prepareStatement(strSql);
                stUpdate.setInt(1, res.getInt("iduser"));
                //System.out.println(stUpdate);
                stUpdate.executeUpdate(  );
		readedLogin = res.getString( "login" );
		break;
	       }
	    System.out.println( "\n >>>>> ERREUR, Mot de passe eronné  !!!!  " );
            i++;
            }
        if(i==4)
            System.out.println("\n   !!!!! ERREUR D'AUTHENTIFICATION après 3 essais échoués  !!!!!  " );
        else
          {
            System.out.println("\n   +++ " + readedLogin + ", vous êtes connecté +++ " );
            APPmenuprincipale Appm = new APPmenuprincipale(readedLogin);
            TD2Authentification.pressEnterToContinue();
          }  
         
         conn.close();         
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
   }         
    
}
