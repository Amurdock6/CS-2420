package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FindKLargestTesting {

	@Test
	void testFindKLargestHeapListOfEInt() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		listTest.add(22);
		listTest.add(4);
		listTest.add(5);
		listTest.add(6);
		listTest.add(21);
		listTest.add(7);
		listTest.add(8);
		listTest.add(9);
		listTest.add(20);
		
		List<Integer> results = new LinkedList<Integer>();
		
		results = FindKLargest.findKLargestHeap(listTest, 3);
		
		assertTrue(results.get(0) == 22);
		assertTrue(results.get(1) == 21);
		assertTrue(results.get(2) == 20);
		assertTrue(results.size() == 3);
	}
	
	@Test
	void testFindKLargestHeapListOfEIntWerid() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		listTest.add(-12);
		listTest.add(-69);
		listTest.add(5);
		listTest.add(7);
		listTest.add(4 / 2 + 1);
		listTest.add(32);
		listTest.add(69 * 420 + 55445 - 121);
		listTest.add(2);
		listTest.add(56);
		
		List<Integer> results = new LinkedList<Integer>();
		
		results = FindKLargest.findKLargestHeap(listTest, 3);
		
		assertTrue(results.get(0) == 84304);
		assertTrue(results.get(1) == 56);
		assertTrue(results.get(2) == 32);
		assertTrue(results.size() == 3);
	}

	@Test
	void testFindKLargestHeapListOfEIntComparatorOfQsuperE() 
	{
		integerComparator cmp = new integerComparator();
		
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		listTest.add(22);
		listTest.add(4);
		listTest.add(5);
		listTest.add(6);
		listTest.add(21);
		listTest.add(7);
		listTest.add(8);
		listTest.add(9);
		listTest.add(20);
		
		List<Integer> results = new LinkedList<Integer>();
		
		results = FindKLargest.findKLargestHeap(listTest, 3, cmp);
		
		assertTrue(results.get(0) == 22);
		assertTrue(results.get(1) == 21);
		assertTrue(results.get(2) == 20);
		assertTrue(results.size() == 3);
	}
	
	@Test
	void testFindKLargestHeapListOfEIntComparatorOfQsuperEWerid() 
	{
		integerComparator cmp = new integerComparator();
		
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		listTest.add(-12);
		listTest.add(-69);
		listTest.add(5);
		listTest.add(7);
		listTest.add(4 / 2 + 1);
		listTest.add(32);
		listTest.add(69 * 420 + 55445 - 121);
		listTest.add(2);
		listTest.add(56);
		
		List<Integer> results = new LinkedList<Integer>();
		
		results = FindKLargest.findKLargestHeap(listTest, 3, cmp);
		
		assertTrue(results.get(0) == 84304);
		assertTrue(results.get(1) == 56);
		assertTrue(results.get(2) == 32);
		assertTrue(results.size() == 3);
	}

	@Test
	void testFindKLargestSortListOfEInt() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		listTest.add(22);
		listTest.add(4);
		listTest.add(5);
		listTest.add(6);
		listTest.add(21);
		listTest.add(7);
		listTest.add(8);
		listTest.add(9);
		listTest.add(20);
		
		List<Integer> results = new LinkedList<Integer>();
		
		results = FindKLargest.findKLargestSort(listTest, 3);
		
		assertTrue(results.get(0) == 22);
		assertTrue(results.get(1) == 21);
		assertTrue(results.get(2) == 20);
		assertTrue(results.size() == 3);
	}
	
	@Test
	void testFindKLargestSortListOfEIntWerid() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		listTest.add(-12);
		listTest.add(-69);
		listTest.add(5);
		listTest.add(7);
		listTest.add(4 / 2 + 1);
		listTest.add(32);
		listTest.add(69 * 420 + 55445 - 121);
		listTest.add(2);
		listTest.add(56);
		
		List<Integer> results = new LinkedList<Integer>();
		
		results = FindKLargest.findKLargestSort(listTest, 3);
		
		assertTrue(results.get(0) == 84304);
		assertTrue(results.get(1) == 56);
		assertTrue(results.get(2) == 32);
		assertTrue(results.size() == 3);
	}

	@Test
	void testFindKLargestSortListOfEIntComparatorOfQsuperE() 
	{
		
		integerComparator cmp = new integerComparator();
		
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		listTest.add(22);
		listTest.add(4);
		listTest.add(5);
		listTest.add(6);
		listTest.add(21);
		listTest.add(7);
		listTest.add(8);
		listTest.add(9);
		listTest.add(20);
		
		List<Integer> results = new LinkedList<Integer>();
		
		results = FindKLargest.findKLargestSort(listTest, 3, cmp);
		
		assertTrue(results.get(0) == 22);
		assertTrue(results.get(1) == 21);
		assertTrue(results.get(2) == 20);
		assertTrue(results.size() == 3);
	}
	
	@Test
	void testFindKLargestSortListOfEIntComparatorOfQsuperEWerid() 
	{
		
		integerComparator cmp = new integerComparator();
		
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		listTest.add(-12);
		listTest.add(-69);
		listTest.add(5);
		listTest.add(7);
		listTest.add(4 / 2 + 1);
		listTest.add(32);
		listTest.add(69 * 420 + 55445 - 121);
		listTest.add(2);
		listTest.add(56);
		
		List<Integer> results = new LinkedList<Integer>();
		
		results = FindKLargest.findKLargestSort(listTest, 3, cmp);
		
		assertTrue(results.get(0) == 84304);
		assertTrue(results.get(1) == 56);
		assertTrue(results.get(2) == 32);
		assertTrue(results.size() == 3);
		results.clear();
		assertTrue(results.size() == 0);
	}

}
