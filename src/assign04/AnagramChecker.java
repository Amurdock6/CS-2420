package assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * This class contains our anagram checker which sorts the anagrams 
 * and finds the largest group of anagrams in a provided list of words
 * 
 * @author Todd Oldham and Alex Murdock
 * @version September 16, 2022
 */

public class AnagramChecker 
{

   /**
	*This method returns the lexicographically-sorted version of the input string. 
	*The sorting must be accomplished using an insertion sort
	*
	*@param String
	*@return sorted 
	*
	*/
	public static String sort(String unsorted)
	{
		// make our string an array of characters
		char[] splitString = unsorted.toCharArray();
		
		for (int i = 1 ; i < splitString.length; i++)
		{
			// set the position as the first character
			int position = i - 1;
			
			// set the value we are looking at as the second character
			char currentChar = splitString[i];
			
			// while our character is smaller than the characters on the left and position is greater than -1
			while(position > -1 && splitString[position] > currentChar )
			{
				// set the current position with the bigger character
				splitString[position + 1] = splitString[position];
				
				// reduce the position
	             position--;
	        }
			
			// set the final position for our current character
			splitString[position + 1] = currentChar;
	     }
		
		// create a string
		String sorted = "";
		
		// add the characters together to form a new sorted string
		for (int j = 0; j < splitString.length; j++)
			sorted = sorted + splitString[j];
		
		return sorted;
	}
	
	
	/**
	 * This generic method sorts the input array using an insertion sort and the input Comparator object.
	 * @param <T>
	 */
	public static <T> void insertionSort(T[] toBeSorted, Comparator<? super T> comp)
	{
		for (int i = 1 ; i < toBeSorted.length; i++)
		{
			// set the position as the first string
			int position = i - 1;
			
			// set the value we are looking at as the second string
			T currentString = toBeSorted[i];
			
			// while our string is smaller than the characters on the left and position is greater than -1
			while(position > -1 && comp.compare(toBeSorted[position], currentString ) > 0)
			{
				// set the current position with the bigger string
				toBeSorted[position + 1] = toBeSorted[position];
				
				// reduce the position
	             position--;
	        }
			
			// set the final position for our current string
			toBeSorted[position + 1] = currentString;
	     }
	}
	
	/**This method returns true if the two input strings are anagrams of each other, otherwise returns false.  
	 * This method must call your sort(String) method.
	 * 
	 * @param firstWord
	 * @param secondWord
	 * @return boolean
	 */
	public static boolean areAnagrams(String firstWord, String secondWord)
	{
		// if the sorted first word is the same as the sorted second word return true
		if(sort(firstWord.toLowerCase()).compareTo(sort(secondWord.toLowerCase())) == 0)
			return true;
		else
			return false;
	}
	
   /**This method returns the largest group of anagrams in the input array of words, in no particular order.  
	*It returns an empty array if there are no anagrams in the input array.  
	*This method must call your areAnagrams(String, String) method 
	*and your insertionSort(T[], Comparator) method with a new Comparator class or lambda expression that you design.
	*
	*@param String[]
	*@return largest group of anagrams
	*
	*/
	public static String[] getLargestAnagramGroup(String[] wordArray)
	{	
		// Comparator
		SortBySize sortBySize = new SortBySize();
		
		// sort the array
		insertionSort(wordArray, sortBySize);
		
		// to keep track of how many times we run through the loop
		int counter = 0;
		
		// first index last index and largest for one group of anagrams
		int currentFirst;
		int currentLast;
		int currentLargest;
		
		// first index last index and largest for biggest group of anagrams
		String largestAnagram = "";
		int setLargest = 0;
		
		// loop through all the strings in word array
		for(int i = 0; i < wordArray.length - 1; i++)
		{
			
			// set counter to current index
			counter = i;
			
			// set first to the current string
			currentFirst = counter;
			
			// while the values we are checking are anagrams
			while (areAnagrams(wordArray[currentFirst], wordArray[counter + 1]) && counter < wordArray.length - 2) 
			{
				counter++;
			}
			
			if(counter == wordArray.length - 2)
				if(areAnagrams(wordArray[currentFirst], wordArray[counter + 1]))
						counter++;
			
			// set the last value to the number of indexes checked
			currentLast = counter +1;
			// total number of anagrams is biggest minus smallest
			currentLargest = currentLast - currentFirst;
			
			// if we have one word that doesn't have other anagrams
			if(currentLargest == 1)
				currentLargest = 0;
			
			// if there are more anagrams in this group than the set highest set new highest
			else if(currentLargest > setLargest)
			{
				
				//largest anagram
				largestAnagram = wordArray[currentFirst];
				
				// keep track of largest number of anagrams
				setLargest = currentLargest;
			}
		}
		
		// array of largest group of anagrams
		String[] largestAnagramGroup = new String[setLargest];
		
		if(setLargest == 0)
			return largestAnagramGroup;
		
		for(int j = 0; j < wordArray.length; j++)
		{
			if(areAnagrams(wordArray[j], largestAnagram))
				largestAnagramGroup[j] = wordArray[j];
		}
		
		return largestAnagramGroup;
	}

	
   /**This method behaves the same as the previous method, but reads the list of words from the input filename.  
	*It is assumed that the file contains one word per line.  
	*If the file does not exist or is empty, the method returns an empty array because there are no anagrams.  
	*This method must call your getLargestAnagramGroup(String[]) method.
	*
	*@param filename
	*@return largestAnagram
	*
	*/
	@SuppressWarnings("finally")
	public static String[] getLargestAnagramGroup(String filename) {
		// create a new String array
		String[] AnagramListFromFile = {};

		// save the file as a variable
		File listOfWords = new File(filename);

		// counter to add words to the array
		int counter = 0;

		try {
			// create a scanner to run through the file
			Scanner findWords = new Scanner(listOfWords);

			// there are more lines in the file
			while (findWords.hasNextLine()) {
				// add the words to the new array
				String newWord = findWords.nextLine();
				AnagramListFromFile[counter] = newWord;

				counter++;
			}

			findWords.close();
		} 
		
		finally 
		{
		    // create a largest anagram array
			String[] LargestAnagram = getLargestAnagramGroup(AnagramListFromFile);

			
			
			return LargestAnagram;
		}

	}
	
	/**
	 * 
	 * Compares two strings and checks to see which string is bigger.
	 *
	 */
	public static class SortBySize implements Comparator<String> {

		public int compare(String str1, String str2) {
			
			// Turn strings into char arrays then sort
			char[] arr1 = str1.toCharArray();
			Arrays.sort(arr1);
			char[] arr2 = str2.toCharArray();
			Arrays.sort(arr2);

			int counter = -1;

			// if the length of the array is smaller than the other then it is not going to be bigger
			if (arr1.length < arr2.length) {
				return counter;
			} 
			
			else 
			{
				// Checks index of characters in the arrays.
				for (int i = 0; i < arr2.length; i++) 
				{
					// If the char of the first is smaller than the second it's smaller
					if (arr1[i] < arr2[i])
					{
						counter = 1;
						return counter;
					}
				}
			}

			counter = -1;
			return counter;
		}

	}
}

