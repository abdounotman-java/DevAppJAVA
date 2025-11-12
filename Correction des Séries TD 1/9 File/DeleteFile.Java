import java.io.File;
public class DeleteFile
{
   public static void main( String[] args )
   {
	String filename= "F:/FS/Mes Cours/JAVA/Exp/9 File/newFile1.txt";
	File myFile = new File(filename); 
	myFile.delete();
   }
}