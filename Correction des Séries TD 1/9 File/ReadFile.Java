import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadFile
{
   public static void main( String[] args )
   {
    String filename= "F:/FS/Mes Cours/JAVA/Exp/9 File/newFile.txt";
	try (FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
          System.out.println(line);
        }
       }
	catch (IOException e) {
     System.out.println("Error reading file: " + e.getMessage());
    }
   }
}