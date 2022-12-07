package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
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
	// Our array list of array list will hold the terminals for each of our non terminals
	static ArrayList<ArrayList<String>> terminals  = new ArrayList<ArrayList<String>>();			
	
	// We will use a HashMap to store our non-terminal keys
	// For exe: 0 = "Noun" in our ArrayList so when ever we want to get a random noun value we will call our first ArrayList and then 
	// Get a random value from within that ArrayList
	static HashMap<Integer, String> keysToNonTerminals  = new HashMap<Integer, String>();
	
	// We will use i + 1 as our key when adding items to a HashMap 
	static int i = -1;
	
	
	/**
	 * Main method for RandomPhraseGenerator
	 * @param args command line parameters
	 */
	public static void main(String[] args) {	
		// Try to read the file and extract non terminals and associated terminals
		// Will read the file and start calling our methods to figure out some of the logic
		try {
			File inputedFile = new File(args[0]);
			Scanner fileReader = new Scanner(inputedFile);

			while (fileReader.hasNextLine()) {
				String fileData = fileReader.nextLine();
				fileData = getContentInCurlyBraces(fileReader, fileData);
			}

			fileReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred when trying to open the file.");
			e.printStackTrace();
		}
		
		System.out.println("number of random phrases to genarate " + args[1]);
		keysToNonTerminals.values();	
	}
	
	
	/**
	 * This method will find only data inside of the curly braces
	 * 
	 * @param fileReader
	 * @param fileData
	 * @return The line of text for the scanner to pick back up yet
	 */
	private static String getContentInCurlyBraces(Scanner fileReader, String fileData) {
		// This will make it so we only print out content within the curly braces
		if (fileData.equals("{")) {
			// add logic for what to do when it finds angle brackets
			while (!fileData.equals("}")) {
				fileData = fileReader.nextLine();
				if (fileData.equals("}")) {
//					System.out.println("\n");
				} else {
					System.out.println(fileData);
					// This will check for Non-Terminal data points
					fileData = getNonTerminalValues(fileReader, fileData);
				}
			}

		}

		// To let the other methods know what line to continue scanning at
		return fileData;
	}

	
	/**
	 * This method will find all non-terminals and add them into the appropriate
	 * dataStructure along with their terminal values.
	 * 
	 * @param fileData
	 * @return The line of text for the scanner to pick back up yet
	 */
	private static String getNonTerminalValues(Scanner fileReader, String fileData) {
		// This will check for '<' and '>' brackets to help tell if the value we are looking at is a non-terminal or not.
		char startOfStringChar = fileData.charAt(0);

		// Will use this to find out what our non terminal is called by combing the chars into a String.
		StringBuilder sb = new StringBuilder();

		// This will tell us if we found a non-terminal.
		if (startOfStringChar == '<') {

			// Tells us where the non-terminal ends.
			int LeftAngle = fileData.indexOf('>');

			// This is how we will get each char of the non-terminal to add into our StringBuilder.
			for (int j = 0; j < LeftAngle; j++) {
				sb.append(fileData.indent(j));
//				System.out.println(sb.toString());
			}

			ArrayList<String> terminalValuesToAdd = new ArrayList<String>();
			// will check to make sure this non-terminal hasn't already been added
			if (!keysToNonTerminals.containsValue(sb.toString())) {
				// We will then add the completed String into our HashMap and give it a key.
				keysToNonTerminals.put(i + 1, sb.toString());
				i++;

				while (!fileData.equals("}")) {
					// This will see at what index our new non-termial is at and then add all of our values into that
					terminalValuesToAdd.add(fileData);
					fileData = fileReader.nextLine();
				}
				
				// This will add all of our new values to the main ArrayList
				terminals.add(terminalValuesToAdd);

			} else if (keysToNonTerminals.containsValue(sb.toString())) {
				// if the non-terminal already exist then we will just add the new values we found into its existing index

			}

		} else {
			// TODO create a method that will find detecet if there is other Non-Terminals in a line of text
		}
		
		System.out.println(terminals.toString());
		
		// To let the other methods know what line to continue scanning at
		return fileData;
	}

	// TODO need to then add every line after the non-terminal into the corresponding ArrayList until we reach a '}'

	// TODO add logic for if the line does not start with '<' changes

	// To check that everything was added correctly


	/**
	 * 
	 * This method takes a integer index value and gets a random terminal for the non terminal associated with the index
	 * 
	 * @param indexOfNonTerminal
	 * @return
	 */
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
	
	
	/**
	 * 
	 * @param fileData
	 * @return
	 */
	private static String NonTerminalTerminal(String NonTerminal)
	{
		int sizeOfString = NonTerminal.length();
		
		StringBuilder nonTerminal = new StringBuilder();
		
		for(int j = 0; j < sizeOfString; j++)
		{
			if(NonTerminal.charAt(j) == '<')
			{
				j++;
				
				while(NonTerminal.charAt(j) != '>')
				{
					nonTerminal.append(NonTerminal.charAt(j));
					j++;
					
				}
				return nonTerminal.toString();
			}
		}
		return null;
		
	}
}
	

	// create a method that will create a new HashMap when a new source of terminals are found for a specific non-terminal. exe: we find terminal values for the <Noun> non-terminal we will make a new HashMap to store all of those Noun terminals in. 



	// create a method that will take args[1] as a parameter and will output the given number of randomly generated phases based off of the value of args[1]. This will be the last method to be called most likely as it glues everything together and makes a finished product. 


