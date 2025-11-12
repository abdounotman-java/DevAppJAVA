package td1jdbc;
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.io.*;
public class TD1JDBC {
    
    static private void pressEnterToContinue()
    { 
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {} 
    }
    
    public static void main(String[] args) {
         
         int choix = 0;
         Scanner masaisie = new Scanner(System.in,"UTF-8");
	 
	 do {
	        System.out.println(" >> GESTION DES �TUDIANTS - M36: Architecture Distribu�e << \n");
                System.out.println("      1. Cr�er la base de donn�es des �tudiants  ");
                System.out.println("      2. Cr�er la table des �tudiants   ");
	 	System.out.println("      3. Inscription des nouveaux �tudiants   ");
                System.out.println("      4. Traiter les demandes de v�rification notes   ");
                System.out.println("      5. �liminer les �tudiants en NV : Note Non-Valid�   ");
                System.out.println("      6. Afficher la liste de la session de ratrrapage   ");
                System.out.println("      7. Rechercher l'�tudiant majorant de la promotion   ");
	 	System.out.println("      8. Afficher la liste des �tudiants  inscrits");
                System.out.println("      9. Supprimer la base de donn�es des �tudiants  ");
                System.out.println("      0. Quitter l'application  ");
                                System.out.print("\n Entrez votre choix :  ");
	 	try
                 {
                  choix = masaisie.nextByte();
                
                 }catch(Exception e)
                  {
                     System.out.println("  Erreur, choix impr�vu !!!!!   -------");
                     e.printStackTrace();
                  } 
	 	switch(choix)
	 	{
	 		case 1 : 
	 		        //system("cls"); 		  
                                System.out.println("\n ++++++ Choix 1 : Cr�er la base de donn�es  ++++++ \n");
                                createdb cdb = new createdb();
                                //cdb.createdb();
                                // Pour v�rification sur le serveur DB : show database;
                                pressEnterToContinue();
                            	break;
			 
			 case 2 : 
			 	//system("cls");
                                System.out.println("\n ++++++ Choix 2 : Cr�er de la table STUDENT  ++++++ \n");
                                createtbstd tstd = new createtbstd();
                                //cdb.createdb();
                                // Pour v�rification sur le serveur DB : show tables;    &    describe student;
                                pressEnterToContinue();
                            	break;
			 case 3 : 
			 	System.out.println("\n ++++++ Choix 3 : Inscription des �tudiants  ++++++ \n");
                                addsutds astd = new addsutds();
                                pressEnterToContinue();
                                break;
			 case 4 : 
			 	System.out.println("\n ++++++ Choix 4 : Modification de la note d'un �tudiant  ++++++ \n");
                                updtnote unote = new updtnote();
                                pressEnterToContinue();
                                break;
			 case 5 : 
			 	System.out.println("\n ++++++ Choix 5 : Suppression des �tudiants ayant des notes �liminatoires (Note < 05/20)  ++++++ \n");
                                delnotenv dnv = new delnotenv();
                                pressEnterToContinue();
                                break;
			 case 6 : 
			 	System.out.println("\n ++++++ Choix 6 : La liste de la session de rattrapage - CR  ++++++ \n");
                                listecr lcr = new listecr();
                                System.out.println("\n");
                                pressEnterToContinue();
                                break;
                         case 7 : 
			 	System.out.println("\n ++++++ Choix 7 : Recherche l'�tudiant major de la promo liste de la session de rattrapage - CR  ++++++ \n");
                                beststd bstd = new beststd();
                                System.out.println("\n");
                                pressEnterToContinue();
                                break;
			 case 8 : 
			 	System.out.println("\n ++++++ Choix 8 : La liste des �tudiants inscrits dans le Module M36 - Architecture Distribu�e  ++++++ \n");
                                listeall lall = new listeall();
                                System.out.println("\n");
                                pressEnterToContinue();
                                break;
                         case 9 : 
			 	//system("cls");
                                System.out.println("\n ++++++ Choix 8 : Supprimer la base de donn�es  ++++++ \n");
                                dropdb ddb = new dropdb();
                                pressEnterToContinue();
				break;
			 case 0: {
			 	//system("cls");
			 	System.out.println("\n   Merci \n   -------   Fin de Programme   -------");
			 	
				break;
			 }
                         default : System.out.println("  Erreur, choix impr�vu !!!!!   -------");
		 
                }    
              
	 }while(choix!=0);		

    }
    
}


/*System.out.println("      3. Afficher la liste des etudiantes convoques au rattrapage   ");
	 	System.out.println("      4. Afficher la liste des etudiantes dans le sens decroissant des moyennes   \n");
	 	System.out.println("      5. Rechercher un Etudiant(e) dans la liste des etudiantes   \n");
	 	System.out.println("      6. Pour touver l indice de l etudiant qu il la note maximale, puis calcul la moyenne de la classe \n");
	 	System.out.println("      7. Pour Enregistree la liste dans un fichier \n");
	 	System.out.println("      8. Pour le nombre des etudaintes incrit par un fichier   \n");
	 	System.out.println("      9. Pour Convertir le nom completNom Complet (NC) de tous les etudiants enregistres   \n");
	 	System.out.println("      10. Pour supprimer les etudiants ayant NV (Moy < 03/20) a partir d un fichier \n");
	 	System.out.println("      11. Pour Modifier le Note de CF d'un etudiant(e)     \n");
	 	System.out.println("      0. Quitter le Programme    \n");*/
	 	

	 /*
			 case 5 : {
			 	system("cls");
			 	rechercher(T,N);
				break;
			 }
			 case 6 : {
			 	system("cls");
			 	float moy;
			    int k = etd_max(T,N,&moy);
			    System.out.println("\n L'etudiant ayant une note maximale dans la position %d",k);
			    System.out.println("\n la moyenne de la classe %.2f",moy);
				break;
			 }
			 case 7 : {
			 	system("cls");
			 	enregistrer(T,"ETD.txt",N);
				break;
			 }
			 case 8 : {
			 	system("cls");
			    System.out.println("\n le nombre des etudiant inscrits est : %d",nbr_etd("ETD.txt"));
				break;
			 }
			 case 9: {
			 	system("cls");
			 	convert_nom(T,N);
			 	afficher(T,N);
				break;
			 }
			 case 10: {
			 	system("cls");
			 	supprimer("ETD.txt");
				break;
			 }
			 case 11: {
			 	system("cls");
			 	char ch[20],nins[20];
			 	float cf;
			 	System.out.println("\n Donner le nom : "); scanf("%s",ch);
			 	System.out.println("\n Donner L NINS : "); scanf("%s",nins);
			 	System.out.println("\n Donner la note de CF : "); scanf("%f",&cf);
			 	modf_cf("ETD.txt",nins,ch,cf);
				break;
			 }*/
		

     /*
        String cmd="cls";                           
        try
                {
                        Runtime r = Runtime.getRuntime();
                        Process p = r.exec(cmd);
                        //Attente que le process soit fini
                        p.waitFor();
                }
                catch(Exception e)
                {
                        //System.out.println("Erreur d'execution " + e.printStackTrace());
                }*/


/*
//System.out.print("\033[H\033[2J");  
                              //  System.out.flush();
                            //Runtime.getRuntime().exec("clear");
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                //Runtime.getRuntime().exec(cls);
                           /*String cmd="cls";
                        Runtime r = Runtime.getRuntime();
                        Process p = r.exec();
                        //Attente que le process soit fini
                        p.waitFor();*/
                                
              