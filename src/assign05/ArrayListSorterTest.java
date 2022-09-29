package assign05;

/**
 * This class contains our ArrayListSorter tests
 * 
 * @author Todd Oldham and Alex Murdock
 * @version September 23, 2022
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArrayListSorterTest {

	@Test
	void testMergesort() {
		fail("Not yet implemented");
	}

	@Test
	void testQuicksort() {
		fail("Not yet implemented");
	}

	@Test
	void testGenerateAscending() 
	{
		int ascendingSize = 5;
		
		ArrayList<Integer> ascendingTest = ArrayListSorter.generateAscending(ascendingSize);
		
		System.out.println(ascendingTest.toString());
		
		assertTrue(ascendingTest.get(0) == 1);
		assertTrue(ascendingTest.get(1) == 2);
		assertTrue(ascendingTest.get(2) == 3);
		assertTrue(ascendingTest.get(3) == 4);
		assertTrue(ascendingTest.get(4) == 5);
	}

	@Test
	void testGeneratePermuted() 
	{
		int permuteSize = 3;
		
		ArrayList<Integer> permuteTest = ArrayListSorter.generatePermuted(permuteSize);
		
		System.out.println(permuteTest.toString());
		
		assertTrue(permuteTest.contains(1));
		assertTrue(permuteTest.contains(2));
		assertTrue(permuteTest.contains(3));

	}

	@Test
	void testGenerateDescending() 
	{
		int descendingSize = 5;
		
		ArrayList<Integer> descendingTest = ArrayListSorter.generateDescending(descendingSize);
		
		System.out.println(descendingTest.toString());
		
		assertTrue(descendingTest.get(0) == 5);
		assertTrue(descendingTest.get(1) == 4);
		assertTrue(descendingTest.get(2) == 3);
		assertTrue(descendingTest.get(3) == 2);
		assertTrue(descendingTest.get(4) == 1);
	}

}
