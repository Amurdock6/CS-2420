package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

																												     // (Arg0)      (Arg1)
// PS to Todd you will run the file in the CMD line using this command "java comprehensive/RandomPhraseGenerator.java super_simple.g 5"
// Just open the cmd prompt and go to the src directory for all of our projects this semester and then you just need to run the above command.

/**
 * This class represents produces a random phrase given a grammar
 * 
 * @author Todd Oldahm and Alex Murdock
 * @version 11/29/2022
 */
public class RandomPhraseGenerator 
{
	// The first thing we are going to do is intiate our HashMap
	static HashMap<Integer, String> nonTerminals = new HashMap<>();
	
	/**
	 * Main method for RandomPhraseGenerator
	 * @param args
	 */
	public static void main(String[] args) {	
		// We will use i + 1 as our key when adding items to our HashMap 
		int i = -1;
		
		// Then we will read the file and put the contents of it into our Data Structre
		try {
			File inputedFile = new File(args[0]);
			Scanner fileReader = new Scanner(inputedFile);

			while (fileReader.hasNextLine()) {
				String fileData = fileReader.nextLine();
				System.out.println(fileData);	
			}

			fileReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred when trying to open the file.");
			e.printStackTrace();
		}
		
		System.out.println("number of random phrases to genarate " + args[1]);
	}
	
	
	/**
	 * This method will scan through the provided file and find all non-terminals.
	 * @return list of non-terminals
	 */
	public String[] findNonTerminals() {
		
		
		return null;
	}
	
	
}


