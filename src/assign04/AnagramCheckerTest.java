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
	void testGetLargestAnagramGroupStringArray() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLargestAnagramGroupString() {
		fail("Not yet implemented");
	}

}
