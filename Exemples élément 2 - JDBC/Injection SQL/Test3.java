package connexionjv;

import java.io.BufferedReader;
import java.sql.* ;
import java.io.* ;

//import com.mysql.jdbc.driver.* ;

import com.mysql.jdbc.Driver.*;

public class ConnexionJV {

    private static BufferedReader keyboard = new BufferedReader( new InputStreamReader( System.in ) );
    
public  static  void main (String[] args) throws Exception {
       //try {
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
            //try (Statement stmt = conn.createStatement(); ResultSet res = stmt.executeQuery( strSql )){
            Statement stmt = conn.createStatement(); 
            ResultSet res = stmt.executeQuery( strSql );
            if ( res.next() ) {
		strSql = "UPDATE TUsers SET ConnectionNbr=ConnectionNbr+1 WHERE ID=" + res.getInt( "ID" );
		Statement stUpdate = conn.createStatement();
                stUpdate.executeUpdate( strSql );
		readedLogin = res.getString( "login" );
		break;
	       }
            //}
	    System.out.println( "ERREUR, Mot de passe eronné" );
            }
            
         System.out.println( readedLogin + ", vous êtes connecté +++ " );
         conn.close();         
         
      //}  //catch (Exception e) {
         // gestion des exceptions
         //System.out.println(e);
      //}
   }
         
}




/*import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Connect {
	
	private static BufferedReader keyboard = new BufferedReader( new InputStreamReader( System.in ) );

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		try ( FileInputStream fis = new FileInputStream( "conf.properties" ) ) {
			props.load( fis );
		}
		
		Class.forName( props.getProperty( "jdbc.driver.class" ) );
		
		String url = props.getProperty( "jdbc.url" );
		String dbLogin = props.getProperty( "jdbc.login" );
		String dbPassword = props.getProperty( "jdbc.password" );
		
		try ( Connection connection = DriverManager.getConnection( url, dbLogin, dbPassword ) ) {
			String readedLogin = "";
			System.out.println( "Welcome to WebStore V1.0 - Copyright KooR.fr");
			while( true ) {
				System.out.print( "Login: ");
				String login = keyboard.readLine();
				System.out.print( "Password: ");
				String password = keyboard.readLine();
				
				String strSql = "SELECT * FROM T_Users WHERE login='" + login + "' AND password='" + password + "'";
				try ( Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( strSql ) ) {
					if ( resultSet.next() ) {
						strSql = "UPDATE T_Users SET connectionNumber=connectionNumber+1 WHERE idUser=" + resultSet.getInt( "idUser" );
						try ( Statement stUpdate = connection.createStatement() ) {
							stUpdate.executeUpdate( strSql );
						}
						
						readedLogin = resultSet.getString( "login" );
						break;
					}
					System.out.println( "Wrong password" );
				}
			}
			
			System.out.println( readedLogin + ", you are connected" );
		}
		
	}

}
*/
/*

import java.util.Scanner;


  try{
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO inscription values(?,?,?,?)");
            FileInputStream file = new FileInputStream("ListeEmp.txt");   
            Scanner s = new Scanner(file);             
            System.out.println("Liste des employées emportés à partir du fichier 'ListeEmp.txt' \n");
            System.out.print("ID\t|\tNom\t\t|\tAge\t\t|\tVille\n");
            System.out.println("-------------------------------------------------------------------");                            
            while(s.hasNextLine()){
                int sid=s.nextInt();
                String sname=s.next();
                int sage=s.nextInt();
                String sville=s.next();         
                System.out.print(" " + sid + "\t|\t");
                System.out.print(sname + "\t\t|\t");
                System.out.print(sage + "\t\t|\t");
                System.out.println(sville);
                stmt.setInt(1,sid);
                stmt.setString(2,sname);
                stmt.setInt(3,sage);
                stmt.setString(4,sville);         
                stmt.executeUpdate();}
            }catch(IOException e){   
                    e.printStackTrace();
            }
       */