package connexionjv;
import java.util.Scanner;

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
         String motDePasse =  "PassWors" ;  // dépend du contexte
          // B. Créer une connexion
         Connection conn = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
         
         try{
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO inscription values(?,?,?,?)");
         
            // Le fichier d'entrée
            FileInputStream file = new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\ConnexionJV\\build\\classes\\connexionjv\\ListeEmp.txt");   
            Scanner s = new Scanner(file);             
            int nbr=0;
            System.out.println("Liste des employées emportés à partir du fichier 'ListeEmp.txt' \n");
            System.out.print("ID\t|\tNom\t\t|\tAge\t\t|\tVille\n");
            System.out.println("-------------------------------------------------------------------");                            
            while(s.hasNextLine())
              {
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
                int i=stmt.executeUpdate();              
                //System.out.println(i+" inséré avec succés");                
            }
         }
         catch(IOException e)
        {   
            e.printStackTrace();
        }
         conn.close();         
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
   }
         
}


