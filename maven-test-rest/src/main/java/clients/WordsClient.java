package clients;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordsClient {

	public static String getWordsFromJsonFile() {
		
		StringBuilder wordsJson = new StringBuilder();
		
	    try {
	        File myObj = new File("C:\\Users\\Ismail Serrar\\eclipse-workspaces\\eclipse-workshops\\maven-test-parent\\maven-test-rest\\src\\main\\resources\\words.json");
	        Scanner myReader = new Scanner(myObj);
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	          wordsJson.append(data);
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	    
	    return wordsJson.toString();
	}
}
