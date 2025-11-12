import java.io.File;
import java.io.IOException;

public class NewFile
{
   public static void main( String[] args )
   {
	   try {
		     File myFile = new File("F:/FS/Mes Cours/JAVA/Exp/9 File/newFile.txt");
		     /* Si le fichier est créé, alors la méthode createNewFile() renverrait 
		      true et  si le fichier est déjà présent il retournerait faux */
		     
	             boolean varF = myFile.createNewFile();
		     if (varF){
		          System.out.println("Fichier crée avec succés");
		     }
		     else{
		          System.out.println("Le fichier existe déjà");
		     }
	    	} catch (IOException e) {
	    		System.out.println("Exception Occurred:");
		        e.printStackTrace();
		  }

   }
}