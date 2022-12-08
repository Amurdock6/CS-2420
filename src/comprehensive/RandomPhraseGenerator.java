package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * This class produces a random phrase given a grammar
 * 
 * @author Todd Oldham and Alex Murdock
 * @version 12/8/2022
 */
public class RandomPhraseGenerator 
{
	// Our array list of array list will hold the terminals for each of our non terminals
	static ArrayList<ArrayList<String>> terminals  = new ArrayList<ArrayList<String>>();			
	
	// We will use a HashMap to store our non-terminal keys
	// For exe:"Noun" = 0 in our ArrayList so when ever we want to get a random noun value 
	//we will call our first ArrayList and then  Get a random value from within that ArrayList
	static HashMap<String, Integer> keysToNonTerminals  = new HashMap<String, Integer>();
	
	// We will use i + 1 as our key when adding items to a HashMap 
	static int i = -1;
	
	/**
	 * Main method for RandomPhraseGenerator
	 * @param args command line parameters
	 */
	public static void main(String grammar, int phrasesGenerated) 
	{	
		// Try to read the file and extract non terminals and associated terminals
		try 
		{
			File inputedFile = new File(grammar);
			Scanner fileReader = new Scanner(inputedFile);

			while (fileReader.hasNextLine()) 
			{
				String fileData = fileReader.nextLine();
				fileData = getContentInCurlyBraces(fileReader, fileData);
			}

			fileReader.close();

		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("An error occurred when trying to open the file.");
			e.printStackTrace();
		}
		
		// Get the index in our array list of array list for start
		int startTerminals = keysToNonTerminals.get("<start>");
		
		// Build as many phrases as command line tells us to.
		int z = phrasesGenerated;
		for (int p = 0; p < z;) 
		{
			// Get one of the random terminal phrases out of the start terminal array list
			String phrase = randomTerminal(startTerminals);
			
			finalPhrase(phrase);
			p++;
		}
	}

	/**
	 * This method will find only data inside of the curly braces
	 * 
	 * @param fileReader
	 * @param fileData
	 * @return The line of text for the scanner to pick back up yet
	 */
	private static String getContentInCurlyBraces(Scanner fileReader, String fileData) 
	{
		// This will make it so we only print out content within the curly braces
		if (fileData.equals("{")) 
		{
			// Get subsequent lines in the file until we reach right curly brace
			while (!fileData.equals("}")) 
			{
				fileData = fileReader.nextLine();
				// If the line isn't a right curly brace extract data
				if (!fileData.equals("}")) 
				{
					// This will check for Non-Terminal data points
					fileData = getNonTerminalValues(fileReader, fileData);
				}
			}
		}
		// return the line we are at in the file
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

		// Create a string builder to build our non terminal.
		StringBuilder sb = new StringBuilder();

		// This will tell us if we found a non-terminal.
		if (startOfStringChar == '<') 
		{

			// Tells us where the non-terminal ends.
			int RightAngle = fileData.indexOf('>');

			// This is how we will get each char of the non-terminal to add into our StringBuilder.
			for (int j = 0; j < RightAngle + 1; j++) 
			{
				sb.append(fileData.charAt(j));
			}

			ArrayList<String> terminalValuesToAdd = new ArrayList<String>();
			
			// will check to make sure this non-terminal hasn't already been added
			if (!keysToNonTerminals.containsKey(sb.toString())) 
			{
				// We will then add the completed String into our HashMap and give it a key.
				keysToNonTerminals.put(sb.toString(), i + 1);
				i++;

				while (!fileData.equals("}"))
				{
					// This will see at what index our new non-terminal is at and then add all of our values into that
						terminalValuesToAdd.add(fileData);
						fileData = fileReader.nextLine();
				}
				
				// This will add all of our new values to the main ArrayList
				terminals.add(terminalValuesToAdd);
			}
		}
		// To let the other methods know what line to continue scanning at
		return fileData;
	}
	
	
	/**
	 * This method will take a line of text and find all the non-terminals contained within it and replace them with a terminal value.
	 * 
	 * @param phrase
	 * @return completedPhrase
	 */
	private static String buildPhrase(String phrase) 
	{
		// Create a string builder for the completedPhrase and for any Non-Terminals we find.
		StringBuilder completedPhrase = new StringBuilder();
		StringBuilder nonTerminal = new StringBuilder();

		int start = 0;
		int leftAngleIndex = 0;
		int rightAngleIndex = 0;
		int end = phrase.length();

		// Will find index of the current "<" bracket.
		int leftAngleBracketLocation = phrase.indexOf("<", leftAngleIndex);

		// Will find the index of the current ">" bracket.
		int rightAngleBracketLocation = phrase.indexOf(">", rightAngleIndex);
		
		// Will find all of the non-terminal values in our phrase and then replace them with terminal values.
		while (leftAngleBracketLocation != -1) {
			// This will append everything up to the first Non-Terminal.
			completedPhrase.append(phrase, start, leftAngleBracketLocation);
		
			// This will append the non-terminal and tell us what non-terminal we have so we can find the corresponding terminal value for it.
			nonTerminal.append(phrase, leftAngleBracketLocation, rightAngleBracketLocation + 1);
			
			// This should replace the non-terminal with a terminal value
			String terminalValue = findTerminalValue(nonTerminal.toString());
			
			nonTerminal.setLength(0);
			
			// If our new terminal value sill contains a non-terminal 
			//then we will keep finding a replacement until we have no more non-terminals
			if (terminalValue.contains("<")) 
			{
				terminalValue = buildPhrase(terminalValue);
			}
			
			completedPhrase.append(terminalValue);

			// This will set our NonTerminal StringBuilder back to 0 so we are not building Non-Terminals on top of each other.
			nonTerminal.setLength(0);
		
			// This will allow us to keep finding non-terminals until there are no more non-terminals.
			leftAngleIndex = leftAngleBracketLocation;
			rightAngleIndex = rightAngleBracketLocation;

			// Update the start and end indices for the finalPhrase StringBuilder
			start = rightAngleBracketLocation + 1;

			// Find the next Non-Terminal value
			leftAngleBracketLocation = phrase.indexOf("<", leftAngleIndex + 1);
			rightAngleBracketLocation = phrase.indexOf(">", rightAngleIndex + 1);
		}
		
		// This will complete the rest of the phrase after the final non-terminal is added.
		completedPhrase.append(phrase, rightAngleIndex + 1, end);

		return completedPhrase.toString();
	}
	
	/**
	 * This method will take in a non-terminal then find the corresponding terminal value and return it.
	 * 
	 * @param nonterminal
	 * @return terminal value
	 */
	private static String findTerminalValue(String nonterminal) 
	{
		// This will find the value in our keysToNonTerminals.
		int indexVal = keysToNonTerminals.get(nonterminal);
		
		// We then use that key to grab a terminal value from our ArrayList that corresponds with the non-terminal.
		return randomTerminal(indexVal);
	}	
	
	/**
	 * This method takes a integer index value and gets a random terminal for the non-terminal associated with the index
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
	 * This method will build our finalPhrase and give us an end product.
	 * 
	 * @return completed finalPhrase
	 */
	private static String finalPhrase(String phrase) 
	{
		// If we have no non-terminals in our text then we will simply return the phrase we were given
		if(phrase.indexOf("<", 0) == -1) 
		{
			//System.out.println(phrase);
			return phrase;
		}
		
		// Otherwise build phrase until no more non terminals exist
		String finalPhrase = buildPhrase(phrase);
		
		//System.out.println(finalPhrase);
		return finalPhrase;
	}
}
