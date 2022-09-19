package assign04;

import java.util.Comparator;

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
			// set the position as the second character and compare to the left
			int position = i;
			// set the value we are looking at as the second character
			char currentChar = splitString[i];
			
			// while our character is smaller than the characters on the left
			while(splitString[position - 1] > currentChar || position > 0)
			{
				// set the current position with the bigger character
				splitString[position] = splitString[position-1];
	             position--;
	        }
			// set the final position for our current character
			splitString[position] = currentChar;
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
		
		String[] largestAnagram = {"abc"};
		
		return largestAnagram;
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
		
		String[] largestAnagram = {"abc"};
		return largestAnagram;
	}
}
