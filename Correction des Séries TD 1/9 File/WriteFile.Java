import java.io.FileWriter;
import java.io.IOException;
public class WriteFile
{
   public static void main( String[] args )
   {
    try
	{
	    String filename= "F:/FS/Mes Cours/JAVA/Exp/9 File/newFile.txt";
	    FileWriter fw = new FileWriter(filename,true); 
		//la valeur true entraine l'ajout du nouveau contenu à l'ancien
	    fw.write("Voici le contenu qui va être ajouté au fichier ");
        //appends the string to the file
	    fw.close();
	}
	catch(IOException ioe)
	{
	    System.err.println("IOException: " + ioe.getMessage());
	}
   }
}