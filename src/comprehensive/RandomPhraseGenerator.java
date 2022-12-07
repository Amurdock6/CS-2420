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
	// Our array list of array list will hold the terminals for each of our non terminals
	static ArrayList<ArrayList<String>> terminals  = new ArrayList<ArrayList<String>>();			
	
	// We will use a HashMap to store our non-terminal keys
	// For exe: 0 = "Noun" in our ArrayList so when ever we want to get a random noun value we will call our first ArrayList and then 
	// Get a random value from within that ArrayList
	static HashMap<String, Integer> keysToNonTerminals  = new HashMap<String, Integer>();
	
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
		
		// Get the index in our array list of array list for start
		System.out.println(keysToNonTerminals);
		int startTerminals = keysToNonTerminals.get("<start>");
		
		// Get one of the random terminal phrases out of the start terminal array list
		String phrase = randomTerminal(startTerminals);
		
//		System.out.println("number of random phrases to genarate " + args[1]);
		buildPhrase(phrase);
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
//					System.out.println(fileData);
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
	private static String getNonTerminalValues(Scanner fileReader, String fileData)
	{
		// This will check for '<' and '>' brackets to help tell if the value we are looking at is a non-terminal or not.
		char startOfStringChar = fileData.charAt(0);

		// Will use this to find out what our non terminal is called by combing the chars into a String.
		StringBuilder sb = new StringBuilder();

		// This will tell us if we found a non-terminal.
		if (startOfStringChar == '<') {

			// Tells us where the non-terminal ends.
			int RightAngle = fileData.indexOf('>');

			// This is how we will get each char of the non-terminal to add into our StringBuilder.
			for (int j = 0; j < RightAngle + 1; j++) {
				sb.append(fileData.charAt(j));
			}

			ArrayList<String> terminalValuesToAdd = new ArrayList<String>();
			// will check to make sure this non-terminal hasn't already been added
			if (!keysToNonTerminals.containsKey(sb.toString())) {
				// We will then add the completed String into our HashMap and give it a key.
				keysToNonTerminals.put(sb.toString(), i + 1);
				i++;

				while (!fileData.equals("}")) {
					// This will see at what index our new non-termial is at and then add all of our values into that
						terminalValuesToAdd.add(fileData);
						fileData = fileReader.nextLine();
				}
				
				// This will add all of our new values to the main ArrayList
				terminals.add(terminalValuesToAdd);

			} else if (keysToNonTerminals.containsKey(sb.toString())) {
				// if the non-terminal already exist then we will just add the new values we found into its existing index

			}

		} else {
			// TODO create a method that will find detecet if there is other Non-Terminals in a line of text
		}
		
//		System.out.println(terminals.toString());
		
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
	 * @return terminal
	 */
	private static String randomTerminal(int indexOfNonTerminal) 
	{
		// Create random generator
		Random terminalIndex = new Random();
		
		// Get the indices available for the NonTerminal we are interested in
		int randomValues = terminals.get(indexOfNonTerminal).size() - 1;
		
		// Get a random index for one of the options for the NonTerminal
		int indexOfTerminal = terminalIndex.nextInt(randomValues) + 1;
		
		// Return the String associated with the random index to replace the NonTerminal
		return terminals.get(indexOfNonTerminal).get(indexOfTerminal);
	}
	
	
	/**
	 * 
	 * This method finds Non terminals in a supposed terminal value
	 * 
	 * @param fileData
	 * @return non terminal
	 */
	private static String NonTerminalTerminal(String NonTerminal, int nonTerminalCounter)
	{
		// Get the size of the string being entered
		int sizeOfString = NonTerminal.length();
		
		// Create a string builder for the non terminal
		StringBuilder nonTerminal = new StringBuilder();
		
		// Left Angle bracket counter
		int LeftAngleBracketCounter = 0;
		
		// Go through the entered phrase getting a specified non terminal out of it
		for(int j = 0; j < sizeOfString; j++)
		{
			// When we find a left angle bracket
			if(NonTerminal.charAt(j) == '<')
			{
				// Increase the number of non terminals in the phrase
				LeftAngleBracketCounter ++;
				
				// If we are at the non terminal that we want
				if(LeftAngleBracketCounter == nonTerminalCounter)
				{
					// get the characters for that non terminal 
					while(NonTerminal.charAt(j) != '>')
					{
						nonTerminal.append(NonTerminal.charAt(j));
						j++;
					}
					nonTerminal.append(NonTerminal.charAt(j));
					// return the non terminal
					return nonTerminal.toString();
				}
				
			}
		}
		
		return null;
	}
	
	
	
	
	/**
	 * 
	 * This method takes in our final phrase and replaces non terminals until all the non terminals have been replaced
	 * 
	 * @param phrase
	 * @return final phrase
	 */
	private static String buildPhrase(String phrase)
	{
		
		// create a string builder for the final phrase
		StringBuilder finalPhrase = new StringBuilder();
		
		// Left angle bracket counter
		int leftAngleCounter = 0;
		
		// For all of the characters in the phrase we are trying to build
		for(int j = 0; j < phrase.length(); j++)
		{
			// add characters while we don't have a non terminal
			while(phrase.charAt(j) != '<')
			{
				finalPhrase.append(phrase.charAt(j));
				j++;
				
				if(j == phrase.length() && !finalPhrase.toString().contains("<"))
				{
					System.out.println(finalPhrase.toString());
					return finalPhrase.toString();
				}
				
			}
			
			// skip past the rest of the characters for the non terminal
			while(phrase.charAt(j) != '>')				
			{
				j++;
			}
			
			leftAngleCounter ++;
			
			// if there is a non terminal
			if(NonTerminalTerminal(phrase, leftAngleCounter) != null)
			{
				// find the index of the non terminal in our array list of array lists	
				int nextNonTerminal = keysToNonTerminals.get(NonTerminalTerminal(phrase, leftAngleCounter));
				
				// get a random terminal from the array list for the terminals
				String nextTerminal = randomTerminal(nextNonTerminal);
				
				System.out.println(nextTerminal);
				
				// add the random terminal to the final phrase after removing the non terminals
				finalPhrase.append(nextTerminal);
			}
			
			// one character after the right angle bracket
			j++;
			
			// If there are still more characters in the phrase
			if(j < phrase.length())
			{
				if(phrase.charAt(j) != '<')
					// add the character after the terminal / right angle bracket
					finalPhrase.append(phrase.charAt(j));
				
				// If the character is left angle bracket j-- to account for for loop
				if(phrase.charAt(j) == '<')
					j--;
			}
		}
		
		// Once the phrase is completed more non terminals may have been added. 
		// Repeat buildPhrase until no more non terminals
		System.out.println(finalPhrase.toString() + " Before Recursion");
		if(finalPhrase.toString().contains("<") != false)
		{
			System.out.println("Recursion");
			buildPhrase(finalPhrase.toString());
		}
		
		else
		{
			System.out.println("Here");
			System.out.println(finalPhrase.toString() + " Final");
			return finalPhrase.toString();
		}
		
		return null;
	}

}
	

	// create a method that will create a new HashMap when a new source of terminals are found for a specific non-terminal. exe: we find terminal values for the <Noun> non-terminal we will make a new HashMap to store all of those Noun terminals in. 



	// create a method that will take args[1] as a parameter and will output the given number of randomly generated phases based off of the value of args[1]. This will be the last method to be called most likely as it glues everything together and makes a finished product. 


