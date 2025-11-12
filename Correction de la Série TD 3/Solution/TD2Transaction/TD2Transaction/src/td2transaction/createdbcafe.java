package td2transaction;

import java.util.Scanner;
import java.sql.* ;

public class createdbcafe {

    public static void createdbcafe()
    {
       try {
          // chargement de la classe par son nom
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l’hôte de la base et port
         String ip =  "localhost" ;  // dépend du contexte
         String port =  "3306" ;  // port MySQL par défaut
          // Chaîne de connexion
         String conString = protocole +  "//" + ip +  ":" + port ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // dépend du contexte
         String motDePasse =  "FS.Tetouan_2023" ;  // dépend du contexte
         // C. Connexion
         Connection conct = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
        
        // D. Exécuter la requéte
        Statement stmt = conct.createStatement();
        //étape 4: exécuter la requéte
        System.out.println("\n >> Création de la base de données ...");
        stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS DBCafe");
        System.out.println("Base de données DBCafe crée avec succés ...\n\n");

        // E. Fermer la connexion
         conct.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
        
    }
    
    public static void createtbclt()
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
            String sql =  "CREATE TABLE IF NOT EXISTS CLIENT " +
                       "(idclt INTEGER NOT NULL AUTO_INCREMENT, " +
                       " nomclt VARCHAR(100), " + 
                       " adrclt VARCHAR(100), " + 
                       " telclt LONG, " + 
                       " PRIMARY KEY ( idclt ))";
         
            smt.executeUpdate(sql);
            
            System.out.println("La table CLIENT créée avec succés ...");
      
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }

    }
    
    public static void createtbcmd()
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
             // D. Exécuter des requêtes            
            System.out.println("\n >> Création de la table Commande ...");
            String sql =  "CREATE TABLE IF NOT EXISTS COMMANDE " +
                       "(idcmd INTEGER NOT NULL AUTO_INCREMENT, " +
                       " idclt INTEGER NOT NULL, " + 
                       " datcmd DATE, " + 
                       " qtecmd INTEGER, " + 
                       " FOREIGN KEY (idclt) REFERENCES CLIENT(idclt)," + 
                       " PRIMARY KEY ( idcmd ))" ;
         
            smt.executeUpdate(sql);
            
            System.out.println("La table COMMANDE créée avec succés ...");
      
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }

    }
    
    public static void deletclt()
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
             
             System.out.println("\n >> Suppression de la table Client ...");
             // D. Exécuter des requêtes
            
            smt.executeUpdate("DROP TABLE IF EXISTS COMMANDE");
            
            smt.executeUpdate("DROP TABLE IF EXISTS CLIENT");
            
            System.out.println(" La table Client supprimée avec succés ...\n\n");
            
      
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
    
    public static void deletcmd()
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
             System.out.println("\n >> Suppression de la table Commande ...");
             // D. Exécuter des requêtes
            
        smt.executeUpdate("DROP TABLE IF EXISTS COMMANDE");
        System.out.println(" La table Commande supprimée avec succés ...\n\n");
      
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }

    }
    
    public static void deletbdcafe()
    {
       try {
          // chargement de la classe par son nom
         Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
         
          // Protocole de connexion
         String protocole =  "jdbc:mysql:" ;
          // Adresse IP de l’hôte de la base et port
         String ip =  "localhost" ;  // dépend du contexte
         String port =  "3306" ;  // port MySQL par défaut
          // Chaîne de connexion
         String conString = protocole +  "//" + ip +  ":" + port ;
          // Identifiants de connexion et mot de passe
         String nomConnexion =  "root" ;  // dépend du contexte
         String motDePasse =  "FS.Tetouan_2023" ;  // dépend du contexte
         // C. Connexion
         Connection conct = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
        
        // D. Exécuter la requéte
        Statement stmt = conct.createStatement();
        //étape 4: exécuter la requéte
        System.out.println("\n >> Suppression de la base de données ...");
        stmt.executeUpdate("DROP DATABASE IF EXISTS DBCafe");
        System.out.println(" Base de données DBCafe supprimée avec succés ...\n\n");

        // E. Fermer la connexion
         conct.close();
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
    }
    
    public static void menuDB()
    {
         int choix = 0;
         Scanner masaisie = new Scanner(System.in,"UTF-8");
	 
	 do {
	        System.out.println(" >> CREATION DE LA BASE DE DONNEES DES CLIENTS / COMMANDES << \n");
                System.out.println("      1. Créer la base de données DBCafe  ");
                System.out.println("      2. Créer la table des clients  ");
                System.out.println("      3. Créer la table des commandes  ");
                System.out.println("      4. Supprimer la table des clients  ");                
                System.out.println("      5. Supprimer la table des commandes  ");                
                System.out.println("      6. Supprimer la base de données DBCafe  ");                
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
	 		        System.out.println("\n ++++++ Choix 1 : Créer la base de données  ++++++ \n");
                                createdbcafe();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 
			 case 2 : 
			        System.out.println("\n ++++++ Choix 2 : Créer de la table CLIENT  ++++++ \n");
                                createtbclt();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 3 :
                                System.out.println("\n ++++++ Choix 3 : Créer de la table COMMANDE  ++++++ \n");
                                createtbcmd();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 4 :
                                System.out.println("\n ++++++ Choix 4 : Supprimer de la table CLIENT  ++++++ \n");
                                deletclt();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 5 :
                                System.out.println("\n ++++++ Choix 5 : Supprimer de la table COMMANDE  ++++++ \n");
                                deletcmd();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 6 :
                                System.out.println("\n ++++++ Choix 6 : Supprimer de la base de données DBCafe  ++++++ \n");
                                deletbdcafe();
                                TD2Transaction.pressEnterToContinue();
                            	TD2Transaction.pressEnterToContinue();
                            	break;
			 
                         case 0: {
			 	System.out.println("\n \n   -------   Fin de l'interface de gestion de la base de données DBCafe   -------");
			 	TD2Transaction.pressEnterToContinue();
                                TD2Transaction.menu();
				break;
			 }
                         default : System.out.println("  Erreur, choix imprévu !!!!!   -------");
		 
                }    
              
	 }while(choix!=0);		


    }
    
}
