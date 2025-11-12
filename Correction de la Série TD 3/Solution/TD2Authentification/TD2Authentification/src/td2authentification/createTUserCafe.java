package td2authentification;
//package td2transaction;

import java.util.Scanner;
import java.sql.* ;

public class createTUserCafe {
 
    public static void createtusers()
    {
                try {
          // chargement de la classe par son nom
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
             Statement smt = con.createStatement() ;
             System.out.println("\n >> Création de la table Client ...");
             // D. Exécuter des requêtes
            String sql =  "CREATE TABLE IF NOT EXISTS TUsers " +
                       "(iduser INTEGER NOT NULL AUTO_INCREMENT, " +
                       " login VARCHAR(100), " + 
                       " passwd VARCHAR(100), " + 
                       " ConnectionNbr INTEGER DEFAULT 0, " + 
                       " PRIMARY KEY ( iduser ))";
         
            smt.executeUpdate(sql);
            
            System.out.println("La table TUsers créée avec succés ...");
      
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }

    }
    
    
    public static void delettusers()
    {
                try {
          // chargement de la classe par son nom
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
        try{   
            //définir la gestion des transactions manuelles
            con.setAutoCommit(false);
            
             // C. Créer un objet Statement
             Statement smt = con.createStatement() ;
             
             System.out.println("\n >> Suppression de la table TUsers ...");
             // D. Exécuter des requêtes
            
            smt.executeUpdate("DROP TABLE IF EXISTS TUsers");
                        
            System.out.println(" La table TUsers supprimée avec succés ...\n\n");
            // S'il n'y a pas d'erreur.
            con.commit();
            }
        catch(SQLException se)
            {
            // S'il y a une erreur.
            con.rollback();
            }
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }

    }
    
    
    public static void menutusers()
    {
         int choix = 0;
         Scanner masaisie = new Scanner(System.in,"UTF-8");
	 
	 do {
	        System.out.println(" >> CREATION DE LA TABLE TUsers << \n");
                System.out.println("      1. Créer la table des utilisateurs  ");
                System.out.println("      2. Supprimer la table des utilisateurs  ");                
                System.out.println("      0. Retourner au menu principal  ");
                System.out.print("\n Entrez votre choix :  ");
	 	try
                 {
                  choix = masaisie.nextByte();
                
                 }catch(Exception e)
                  {
                     System.out.println("  Erreur, choix imprévu !!!!!   -------");
                     e.printStackTrace();
                  } 
	 	switch(choix)
	 	{
	 		case 1 : 
	 		        System.out.println("\n ++++++ Choix 1 : Créer la table TUsers  ++++++ \n");
                                createtusers();
                                TD2Authentification.pressEnterToContinue();
                            	break;
			 
			 case 2 : 
                                System.out.println("\n ++++++ Choix 2 : Supprimer de la table TUsers  ++++++ \n");
                                delettusers();
                                TD2Authentification.pressEnterToContinue();
                            	break;
                         case 0: {
			 	System.out.println("\n \n   -------   Fin de l'interface de gestion de la base de données DBCafe   -------");
			 	TD2Authentification.pressEnterToContinue();
                                TD2Authentification.menu();
				break;
			 }
                         default : System.out.println("  Erreur, choix imprévu !!!!!   -------");
		 
                }    
              
	 }while(choix!=0);		


    }
    
    
}
