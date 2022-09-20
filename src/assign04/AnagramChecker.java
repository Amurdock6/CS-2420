package assign04;

import java.io.File;
import java.io.FileNotFoundException;
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
			while(position > -1 && comp.compare(toBeSorted[position], currentString ) > 1)
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
		if(sort(firstWord).compareTo(sort(secondWord)) == 0)
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
		
		String[] largestAnagram = {};
		
		// need to create comparator class or lambda expression
		insertionSort(wordArray, SortBySize);
		
		// this won't work right. Just an idea but not entirely sure what to do.
		for(int i = 1; i < wordArray.length; i++)
			if( areAnagrams(wordArray[0], wordArray[i]))
				largestAnagram[i] = wordArray[i];
			
		
		return largestAnagram;
	}
	
	class SortBySize implements Comparator<String[]> {

		@Override
		public int compare(String[] o1, String[] o2) {
			// TODO Auto-generated method stub
			
			// Grabs the sizes of our anagrams
			int anagramSize1 = o1.length;
			int anagramSize2 = o2.length;
			
			// Compares the twos lengths and sees which is larger
			if(anagramSize1 > anagramSize2) {
				// do something when anagramSize1 is larger
			} else if (anagramSize1 < anagramSize2) {
				// do something when anagramSize2 is larger
			} else if (anagramSize1 == anagramSize2) {
				// do something when the anagrams are equal in length
			}
			
			System.out.println(anagramSize1);
			
			return 0;
		}
		
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
	public static String[] getLargestAnagramGroup(String filename)
	{
		// create a new String array
		String[] AnagramListFromFile = {};
		
		// save the file as a variable
		File listOfWords = new File(filename);
		
		// counter to add words to the array
		int counter = 0;
		
	    try 
	    {
	    	// create a scanner to run through the file
	    	Scanner findWords = new Scanner(listOfWords);
		
		    // there are more lines in the file
		    while (findWords.hasNextLine()) 
		    {
		    	// add the words to the new array
		    	String newWord = findWords.nextLine();
		    	AnagramListFromFile[counter] = newWord;
		    	
		    	counter++;
		    }
		    
		    findWords.close();
	    } 
	    
	    // catch an error if the file isn't found
	    catch (FileNotFoundException e) 
	    {
	      System.out.println("File not found");
	      e.printStackTrace();
	    }
	    
	    // create a largest anagram array
		String[] LargestAnagram = getLargestAnagramGroup(AnagramListFromFile);

		
		
		return LargestAnagram;
	}
}

