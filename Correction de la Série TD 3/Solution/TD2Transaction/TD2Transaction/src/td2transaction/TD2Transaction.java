package td2transaction;

import java.util.Scanner;

public class TD2Transaction {

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
	        System.out.println(" >> GESTION DES CLIENT / COMMANDES << \n");
                System.out.println("      1. Gestion la base de données DBCafe  ");
                System.out.println("      2. Gestion des Clients  ");
	 	System.out.println("      3. Gestion des Commandes   ");
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
                                System.out.println("\n ++++++ Choix 1 : Gestion de la base de données DBCafe ++++++ \n");
                                createdbcafe.menuDB();
                                pressEnterToContinue();
                            	break;
			 
			 case 2 : 
			 	//system("cls");
                                System.out.println("\n ++++++ Choix 2 : Gestion des Clients  ++++++ \n");
                                gestionclient.menugestionclt();
                                pressEnterToContinue();
                            	break;
			 case 3 : 
			 	System.out.println("\n ++++++ Choix 3 : Gestion des Commandes  ++++++ \n");
                                gestioncommande.menugestioncmd();
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
