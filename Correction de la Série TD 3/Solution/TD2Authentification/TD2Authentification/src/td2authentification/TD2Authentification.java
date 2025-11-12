package td2authentification;

import java.util.Scanner;

public class TD2Authentification {

    
    public static void pressEnterToContinue()
    { 
        System.out.println("\n     >>>>   Press Enter key to continue...\n\n");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {} 
    }

        public static void menu()
    {
         int choix = 0;
         Scanner masaisie = new Scanner(System.in,"UTF-8");
	 
	 do {
	        System.out.println(" >> GESTION AUTHENTIFICATION << \n");
                System.out.println("      1. Gestion de la table TUsers  ");
                System.out.println("      2. Se connecter à l'application Commande-Café ");
	 	System.out.println("      3. Ajouter un nouveau utilisateur   ");
                System.out.println("      4. Modifier le mot de pass d'un utilisateur   ");
                System.out.println("      5. Supprimer un utilisateur   ");
                System.out.println("      6. Afficher la liste des utilisateurs   ");
                System.out.println("      0. Quitter l'application   ");
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
                                System.out.println("\n ++++++ Choix 1 : Gestion de la table TUsers ++++++ \n");
                                createTUserCafe.menutusers();
                                pressEnterToContinue();
                            	break;
			 
			 case 2 : 
			 	//system("cls");
                                System.out.println("\n ++++++ Choix 2 : Se connecter à l'application Commande-Café   ++++++ \n");
                                authentifcation auth = new  authentifcation();
                                pressEnterToContinue();
                            	break;
			 case 3 : 
			 	System.out.println("\n ++++++ Choix 3 : Ajouter un utilisateur  ++++++ \n");
                                adduser addus = new  adduser();
                                pressEnterToContinue();
                                break;
			 case 4 : 
			 	System.out.println("\n ++++++ Choix 4 : Modifier le mot de pass d'un utilisateur  ++++++ \n");
                                updatepass updtpw = new  updatepass();
                                pressEnterToContinue();
                                break;
                         case 5 : 
			 	System.out.println("\n ++++++ Choix 5 : Supprimer un utilisateur   ++++++ \n");
                                deletuser delus = new  deletuser();
                                pressEnterToContinue();
                                break;
                         case 6 : 
			 	System.out.println("\n ++++++ Choix 6. Afficher la liste des utilisateurs   ++++++ \n");
                                listeusers alluser = new  listeusers();
                                pressEnterToContinue();
                                break;
                         case 0: 
                                System.out.println("\n   Merci \n   -------   Fin de Programme   -------");			 	
				break;
			 default : System.out.println("  Erreur, choix imprévu !!!!!   -------");
		 
                }    
              
	 }while(choix!=0);		

    }

    
    public static void main(String[] args) {
        menu();
    }
    
}
