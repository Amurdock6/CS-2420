package assign04;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests our AnagramChecker class
 * 
 * @author Todd Oldham and Alex Murdock
 * @version September 16, 2022
 */

import org.junit.jupiter.api.Test;

class AnagramCheckerTest {

	@Test
	void testSort() 
	{
		// create a string
		String unsorted = "sort";
		
		// sort the string
		String sorted = AnagramChecker.sort(unsorted);
		
		System.out.println(sorted);
		
		// make sure the string is sorted
		assertTrue(sorted.equals("orst"));
	}

	@Test
	void testInsertionSort() {
		fail("Not yet implemented");
	}

	@Test
	void testAreAnagrams() 
	{
		// create some strings
		String word1 = "play";
		String word2 = "bat";
		String word3 = "tab";
		
		// test to make sure are anagrams can tell if they are anagrams or not
		assertFalse(AnagramChecker.areAnagrams(word1, word2));
		assertTrue(AnagramChecker.areAnagrams(word3, word2));
	}

	@Test
	void testGetLargestAnagramGroupStringArray() 
	{
		// create test array
		String[] testArray = {"carets", "Caters", "caster", "play", "bat", "tab"};
		String[] answer = {"carets", "Caters", "caster"};
		String[] noAnagram = {"carets", "play", "bat"};
		
		// test if the correct array is returned
		assertTrue(AnagramChecker.getLargestAnagramGroup(testArray).equals(answer));
		
		assertTrue(AnagramChecker.getLargestAnagramGroup(noAnagram).length == 0);

	}

	@Test
	void testGetLargestAnagramGroupString() 
	{
		// File array of strings
		String [] testAnswer = {"carets", "Caters", "caster", "crates", "Reacts", "recast", "traces"};
		
		// Test if the get largest returns the correct array
		assertTrue(AnagramChecker.getLargestAnagramGroup("sample_word_list.txt").equals(testAnswer));
	}

}