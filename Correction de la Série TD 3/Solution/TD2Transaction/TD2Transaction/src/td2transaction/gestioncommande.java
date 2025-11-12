package td2transaction;

import java.util.Scanner;
import java.sql.* ;
import java.io.* ;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class gestioncommande {

    public static void passercmd()
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
         
         //Préparation de notre Requête paramétrée
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO commande(idclt,datcmd,qtecmd) values(?,?,?)");
         Scanner s=new Scanner(System.in);
         //System.out.println("Entrer id client : ");
         //int sid=s.nextInt();
         //stmt.setInt(1,sid);
         int nbr=0;
         String choix="oui";
         while(choix.equals("oui"))
         {
            System.out.println("  --- Passer la commande " + ++nbr + "  --- ");
            System.out.print("\n   - Entrer > ID client :  ");
            int sidclt=s.nextInt();            
            long millis=System.currentTimeMillis(); 
            java.sql.Date sdate = new java.sql.Date(millis);
            System.out.println(  "   -        > Date Commande : " + sdate);
            System.out.print("   - Entrer > Quantité comandée du café en Kg :  ");
            int sqte=s.nextInt();
            stmt.setInt(1,sidclt);
            stmt.setDate(2, sdate);
            stmt.setInt(3,sqte);
            int i=stmt.executeUpdate();
            System.out.println("   >> " + i+" commande inséré avec succés");
            System.out.println("\\nnVous voulez ajouter une autre commande (oui/non) ?");
            choix=s.next();
         } 
         conn.close();         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }

    }


    public static void updateqte()
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
         
         //Préparation de notre Requête paramétrée
         PreparedStatement stmt = conn.prepareStatement("UPDATE commande SET qtecmd = ? WHERE idcmd = ?");
         Scanner s=new Scanner(System.in);
         System.out.println("  --- Modifier quantité demandée dans une commande --- ");
            System.out.print("\n   - Entrer > ID commande à modifier :   ");
            int sidcmd=s.nextInt();           
            
            System.out.print("   - Entrer la nouvelle quantité comandée du café en Kg :   ");
            int sqte=s.nextInt();
            
            stmt.setInt(1, sqte);
            stmt.setInt(2,sidcmd);
            
            int i=stmt.executeUpdate();
            System.out.println("   >> " + i+" commande modifée avec succés");
            
         conn.close();         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);
      }
 
    }
    
    public static void deletcmd()
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
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
         
         // C. Créer un objet Statement
         
         System.out.println("\n >> Suppression d'unE commande ...");
         //Préparation de notre Requête paramétrée
         
            Scanner s=new Scanner(System.in);
            System.out.print("\n   - Entrer > ID de la commande à supprimer :   ");
            int sidcmd=s.nextInt();                       
            PreparedStatement stmtcmd = con.prepareStatement("DELETE FROM COMMANDE WHERE idcmd = ?");
            stmtcmd.setInt(1,sidcmd);
            int i=stmtcmd.executeUpdate();
            
            System.out.println(" Suppression ...");
           
           System.out.println("La commande ID: " + sidcmd + " supprimée avec succès  ...");
         
         // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }        
    
    }
    
    public static void listecmd(){
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
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
         // C. Créer un objet Statement
         PreparedStatement stmt = con.prepareStatement("SELECT idcmd, idclt, datcmd, qtecmd FROM commande WHERE idclt = ? ORDER BY idcmd ASC");
         Scanner s=new Scanner(System.in);
         System.out.println("  --- Afficher les commande effectuées par un client --- ");
            System.out.print("\n   - Entrer > ID client rechercher :   ");
            int sidclt=s.nextInt();              
            stmt.setInt(1, sidclt);
            ResultSet res = stmt.executeQuery(  );
         System.out.println("Liste des commandes effectués par le client ID: " + sidclt + "\n");
         System.out.print("ID CMD\t|\tID CLT \t|\tDATE CMD\t|\tQTE CMD\n");
         System.out.println("---------------------------------------------------------------");
          while (res.next()) {
            //Récupérer par nom de colonne
            int vidcmd = res.getInt("idcmd");
            int vidclt = res.getInt("idclt");
            Date vdatecmd = res.getDate("datcmd");
            int vqtecmd = res.getInt("qtecmd");
            
            //Afficher les valeurs
            System.out.print(" " + vidcmd + "\t|\t");
            System.out.print(vidclt + "\t|\t");
            System.out.print(vdatecmd + "\t|\t");
            System.out.println(vqtecmd);
        }
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }        

    }
    
    public static void listeallcmd()
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
         Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
         // C. Créer un objet Statement
         PreparedStatement stmt = con.prepareStatement("SELECT idcmd, idclt, datcmd, qtecmd FROM commande ORDER BY idcmd ASC");
         Scanner s=new Scanner(System.in);
         System.out.println("  --- Afficher toutes les commandes effectuées  --- ");
         ResultSet res = stmt.executeQuery(  );
         System.out.println("Liste des commandes effectuées : \n");
         System.out.print("ID CMD\t|\tID CLT \t|\tDATE CMD\t|\tQTE CMD\n");
         System.out.println("---------------------------------------------------------------");
          while (res.next()) {
            //Récupérer par nom de colonne
            int vidcmd = res.getInt("idcmd");
            int vidclt = res.getInt("idclt");
            Date vdatecmd = res.getDate("datcmd");
            int vqtecmd = res.getInt("qtecmd");
            
            //Afficher les valeurs
            System.out.print(" " + vidcmd + "\t|\t");
            System.out.print(vidclt + "\t|\t");
            System.out.print(vdatecmd + "\t|\t");
            System.out.println(vqtecmd);
        }
        // E. Fermer la connexion
         con.close();
         
      }  catch (Exception e) {
         // gestion des exceptions
         System.out.println(e);

      }        
        
    }
    
    public static void menugestioncmd()
    {
         int choix = 0;
         Scanner masaisie = new Scanner(System.in,"UTF-8");
	 
	 do {
	        System.out.println(" >> GESTION DES COMMANDES << \n");
                System.out.println("      1. Passer une commande  ");
                System.out.println("      2. Importer la liste des commandes  ");
                System.out.println("      3. Modifier la quantité commandée d'une commande  ");
                System.out.println("      4. Supprimer une commande  ");
                System.out.println("      5. Afficher la liste des commandes effectuées par un client  ");
                System.out.println("      6. Afficher toutes les commandes effectuées  ");
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
	 		        System.out.println("\n ++++++ Choix 1 : Passer une Commande  ++++++ \n");
                                passercmd();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 
			 case 2 : 
			        System.out.println("\n ++++++ Choix 2 : Importer la liste des commandes  ++++++ \n");
                                //loadclients();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 3 :
                                System.out.println("\n ++++++ Choix 3 : Modifier la quantité commandée d'une commande  ++++++ \n");
                                updateqte();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 4 :
                                System.out.println("\n ++++++ Choix 4 : Supprimer une commande  ++++++ \n");
                                deletcmd();
                                TD2Transaction.pressEnterToContinue();
                            	break;
			 case 5 :
                                System.out.println("\n ++++++ Choix 5 :  Afficher la liste des clients  ++++++ \n");
                                listecmd();
                                TD2Transaction.pressEnterToContinue();
                            	break;			 
                         case 6 :
                                System.out.println("\n ++++++ Choix 5 :  Afficher la liste des clients  ++++++ \n");
                                listeallcmd();
                                TD2Transaction.pressEnterToContinue();
                            	break;			 
                         case 0: {
			 	System.out.println("\n \n   -------   Fin de l'interface de gestion des CLIENTS   -------");
			 	TD2Transaction.pressEnterToContinue();
                                TD2Transaction.menu();
				break;
			 }
                         default : System.out.println("  Erreur, choix imprévu !!!!!   -------");
		 
                }    
              
	 }while(choix!=0);		


    }
        
}
