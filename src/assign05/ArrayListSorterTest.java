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

//	@Test
//	void testMergesort() 
//	{
//		int mergeSize = 1000;
//		
//		ArrayList<Integer> mergeTest = ArrayListSorter.generatePermuted(mergeSize);
//		
//		ArrayListSorter.mergesort(mergeTest, 20);
//		
//		System.out.println(mergeTest);
//		
//		assertTrue(mergeTest.get(0) == 1);
//		assertTrue(mergeTest.get(500) == 501);
//		assertTrue(mergeTest.get(999) == 1000);
//
//	}

	@Test
	void testQuicksort() 
	{
		int quickSortSize = 1000;
		
		ArrayList<Integer> quickSortTest = ArrayListSorter.generatePermuted(quickSortSize);
		
		System.out.println(quickSortTest + " pre test");
		
		ArrayListSorter.quicksort(quickSortTest);
		
		assertTrue(quickSortTest.get(0) == 1);
		assertTrue(quickSortTest.get(500) == 501);
		assertTrue(quickSortTest.get(999) == 1000);
	}
//	
//	@Test
//	void testQuicksortGetMedian() 
//	{
//		int quickSortSize = 1000;
//		
//		ArrayList<Integer> quickSortTest = ArrayListSorter.generatePermuted(quickSortSize);
//		
//		ArrayListSorter.quicksort(quickSortTest);
//		
//		assertTrue(ArrayListSorter.quicksort.getMedian(quickSortTest) ==  500);
//	}
//
//	@Test
//	void testGenerateAscending() 
//	{
//		int ascendingSize = 5;
//		
//		ArrayList<Integer> ascendingTest = ArrayListSorter.generateAscending(ascendingSize);
//		
//		//System.out.println(ascendingTest.toString());
//		
//		assertTrue(ascendingTest.get(0) == 1);
//		assertTrue(ascendingTest.get(1) == 2);
//		assertTrue(ascendingTest.get(2) == 3);
//		assertTrue(ascendingTest.get(3) == 4);
//		assertTrue(ascendingTest.get(4) == 5);
//	}
//
//	@Test
//	void testGeneratePermuted() 
//	{
//		int permuteSize = 3;
//		
//		ArrayList<Integer> permuteTest = ArrayListSorter.generatePermuted(permuteSize);
//		
//		//System.out.println(permuteTest.toString());
//		
//		assertTrue(permuteTest.contains(1));
//		assertTrue(permuteTest.contains(2));
//		assertTrue(permuteTest.contains(3));
//
//	}
//
//	@Test
//	void testGenerateDescending() 
//	{
//		int descendingSize = 5;
//		
//		ArrayList<Integer> descendingTest = ArrayListSorter.generateDescending(descendingSize);
//		
//		//System.out.println(descendingTest.toString());
//		
//		assertTrue(descendingTest.get(0) == 5);
//		assertTrue(descendingTest.get(1) == 4);
//		assertTrue(descendingTest.get(2) == 3);
//		assertTrue(descendingTest.get(3) == 2);
//		assertTrue(descendingTest.get(4) == 1);
//	}

}
