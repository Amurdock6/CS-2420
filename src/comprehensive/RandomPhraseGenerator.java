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
 * @version 11/29/2022
 */
public class RandomPhraseGenerator 
{
	// Our array list of array list will hold the terminals for each of our non terminals
	static ArrayList<ArrayList<String>> terminals  = new ArrayList<ArrayList<String>>();			
	
	// We will use a HashMap to store our non-terminal keys
	// For exe:"Noun" = 0 in our ArrayList so when ever we want to get a random noun value we will call our first ArrayList and then 
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
		int startTerminals = keysToNonTerminals.get("<start>");
		
		// Get one of the random terminal phrases out of the start terminal array list
		String phrase = randomTerminal(startTerminals);
		
		// Build as many phrases as the input value
		int z = Integer.parseInt(args[1]);
		for (int p = 0; p < z;) {
			buildPhrase(phrase);
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
	private static String getContentInCurlyBraces(Scanner fileReader, String fileData) {
		// This will make it so we only print out content within the curly braces
		if (fileData.equals("{")) {
			// Get subsequent lines in the file
			while (!fileData.equals("}")) {
				fileData = fileReader.nextLine();
				// If the line is a right curly brace don't do anything
				if (!fileData.equals("}")) {
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
			}
		}
		// To let the other methods know what line to continue scanning at
		return fileData;
	}
	
	
	/**
	 *
	 * This method takes in our final phrase and replaces Non-Terminals until all
	 * the Non-Terminals have been replaced creating a completed finial phrase
	 * 
	 * @param phrase
	 * @return final phrase
	 */
	private static String buildPhrase(String phrase) {
		// Create a string builder for the final phrase and for any Non-Terminals we find.
		StringBuilder finalPhrase = new StringBuilder();
		StringBuilder NonTerminal = new StringBuilder();

		int start = 0;
		int leftAngleIndex = 0;
		int rightAngleIndex = 0;
		int end = phrase.length();

		// Will find index of the current "<" bracket.
		int leftAngleBracketLocation = phrase.indexOf("<", leftAngleIndex);

		// Will find the index of the current ">" bracket.
		int rightAngleBracketLocation = phrase.indexOf(">", rightAngleIndex);

		// Will find all of the Non-Terminal values in our phrase and then replace them with terminal values.
		while (leftAngleBracketLocation != -1) {
			// This will append everything up to the first Non-Terminal.
			finalPhrase.append(phrase, start, leftAngleBracketLocation);
		
			
			// This will append the non-terminal and tell us what non-terminal we have so we can find the coresponding terminal value for it.
			NonTerminal.append(phrase, leftAngleBracketLocation, rightAngleBracketLocation + 1);
			
			// This should replace the non-terminal with a terminal value
			String terminalValue = findTerminalValue(NonTerminal.toString());
			
			NonTerminal.setLength(0);
			
			// If our new terminal value sill contains a non-terminal then we will keep finding a replacemnt until we have no more non-termianls
			if (terminalValue.contains("<")) {
				terminalValue = buildPhrase(terminalValue);
//				int nonTermStartLeft = 0;
//				int nonTermStartRight = 0;
//
//				// Will find index of the current "<" bracket.
//				int leftAngleBracketLocationNonTerm = phrase.indexOf("<", nonTermStartLeft);
//
//				// Will find the index of the current ">" bracket.
//				int rightAngleBracketLocationNonTerm = phrase.indexOf(">", nonTermStartRight);
//
//				// need to write some code that will check to make sure our value dosent contain a non-terminal
//				while (terminalValue.contains("<")) {
//
//					NonTerminal.append(terminalValue, leftAngleBracketLocationNonTerm, rightAngleBracketLocationNonTerm + 1);
//
//					terminalValue = findTerminalValue(NonTerminal.toString());
//					System.out.println(terminalValue + " found terminal in terminal here is output");
////				}
			}
			
			finalPhrase.append(terminalValue);

			// This will set our NonTerminal StringBuilder back to 0 so we are not building Non-Terminals on top of each other.
			NonTerminal.setLength(0);
		
			// This will allow us to keep finding non-terminals unitl there is no more non-terminals.
			leftAngleIndex = leftAngleBracketLocation;
			rightAngleIndex = rightAngleBracketLocation;

			// Update the start and end indices for the finalPhrase StringBuilder
			start = rightAngleBracketLocation + 1;

			// Find the next Non-Terminal value
			leftAngleBracketLocation = phrase.indexOf("<", leftAngleIndex + 1);
			rightAngleBracketLocation = phrase.indexOf(">", rightAngleIndex + 1);
		}
		
		// This will complete the rest of the phrase after the final non-terminal is added.
		finalPhrase.append(phrase, rightAngleIndex + 1, end);

		System.out.println(finalPhrase.toString() + " This is the final phrase");
		return finalPhrase.toString();
	}
	
	
	/**
	 * This method will take in a non-terminal then find the coresponding terminal value and return it.
	 * 
	 * @param nonterminal
	 * @return terminal value
	 */
	private static String findTerminalValue(String nonterminal) {
		// This will find the value in our keysToNonTerminals.
		int indexVal = keysToNonTerminals.get(nonterminal);
		
		// We then use that key to grab a termial value from our ArrayList that coresponds with the non-terminal.
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
		
		// This get a non-terminal value for us
		String terminalVal = terminals.get(indexOfNonTerminal).get(indexOfTerminal);
		
		// need to write some code that will check to make sure our value dosent contain a non-terminal
//		if (terminalVal.contains("<")) {
//			buildPhrase(terminalVal);
//		}
		
		// Return the String associated with the random index to replace the NonTerminal
		return terminalVal;
	}
}
