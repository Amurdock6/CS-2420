package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

																												     // (Arg0)      (Arg1)
// PS to Todd you will run the file in the CMD line using this command "java comprehensive/RandomPhraseGenerator.java super_simple.g 5"
// Just open the cmd prompt and go to the src directory for all of our projects this semester and then you just need to run the above command.

/**
 * This class represents produces a random phrase given a grammar
 * 
 * @author Todd Oldahm and Alex Murdock
 * @version 11/29/2022
 * @param <E>
 */
public class RandomPhraseGenerator 
{
	// The ArrayList will store 
	ArrayList<ArrayList<String>> terminals  = new ArrayList<ArrayList<String>>();			
	
	// We will use a HashMap to store our non-termial keys so for exe: 0 = "Noun" in our ArrayList so when ever we want to get a ranodm noun value we will call our first ArrayList and then 
	// Get a random value from with in that ArrayList
	HashMap<Integer, String> keysToNonTerminals  = new HashMap<Integer, String>();
	
	// We will use i + 1 as our key when adding items to a HashMap 
	static int i = -1;
	
	
	/**
	 * Main method for RandomPhraseGenerator
	 * @param args command line parameters
	 */
	public static void main(String[] args) {	

		// Will read the file and start calling our methods to figure out some of the logic
		try {
			File inputedFile = new File(args[0]);
			Scanner fileReader = new Scanner(inputedFile);

			while (fileReader.hasNextLine()) {
				String fileData = fileReader.nextLine();
				getContentInCurleyBraces(fileReader, fileData);
			}

			fileReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred when trying to open the file.");
			e.printStackTrace();
		}
		
		System.out.println("number of random phrases to genarate " + args[1]);
	}
	
	
	/**
	 * This mehtod will find only data insdie of the curely braces
	 */
	private static void getContentInCurleyBraces(Scanner fileReader, String fileData) {
		// This will make it so we only print out content with in the curely braces
		if (fileData.equals("{")) {
			// add logic for what to do when it finds angle brackets
			while (!fileData.equals("}")) {
				fileData = fileReader.nextLine();
				if (fileData.equals("}")) {
					System.out.println("\n");
				} else {
					// This will check for Non-Terminal data points
					getNonTermialValues(fileData);
					System.out.println(fileData);
				}
			}

		}
	}
	
	
/**
 * This method will find all non-terminals and add them into the appropate dataStructure along with ther terminal values
 * @param fileData
 */
	private static void getNonTermialValues(String fileData) {
		// This will check for '<' and '>' brackets to help tell if the value we are looking at is a non-terimal or not.
		char startOfStringChar = fileData.charAt(0);
		int endOfString = fileData.length();
		char endOfStringChar = fileData.charAt(endOfString - 1);

		// Will use this to find out if non-terminal is the start or not
		StringBuilder sb = new StringBuilder();

		// This will tell us if we found a non-terminal
		if (startOfStringChar == '<') {
			
			// Tells us where the non-terminal ends
			int LeftAngle = fileData.indexOf('>');

			// This is how we will build our strings to see what they are called
			for (int j = 0; j < LeftAngle; j++) {
				
				// Checks to make sure there is no spaces in the non-terminal
				if (fileData.indent(j) == " ") {
					break;
				} else {
					sb.append(fileData.indent(j));
				}
			}

		}
	}
	
	/* changes */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String randomTermial(int indexOfNonTerminal) 
	{
		// Create random generator
		Random terminalIndex = new Random();
		
		// Get the indices available for the NonTerminal we are interested in
		int randomValues = terminals.get(indexOfNonTerminal).size() - 1;
		
		// Get a random index for one of the options for the NonTerminal
		int indexOfTerminal = terminalIndex.nextInt(randomValues);
		
		// Return the String associated with the random index to replace the NonTerminal
		return terminals.get(indexOfNonTerminal).get(indexOfTerminal);
	}

}
	

	// create a method that will create a new HashMap when a new source of terminals are found for a specfic non-terminal. exe: we find terminal values for the <Noun> non-terminal we will make a new HashMap to store all of those Noun terminals in. 



	// create a method that will take args[1] as a paramter and will output the given number of randomly genrated phases based off of the value of args[1]. This will be the last method to be called most likely as it glues everything togther and makes a finished product. 


