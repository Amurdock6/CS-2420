package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class BinaryMaxHeapTesting {

	@Test
	void testBinaryMaxHeap() 
	{
		BinaryMaxHeap<Integer> constructor1 = new BinaryMaxHeap<Integer>();
		
		assertTrue(constructor1.isEmpty());
		assertTrue(constructor1.size() == 0);
		
	}

	@Test
	void testBinaryMaxHeapComparatorOfQsuperE() 
	{
		integerComparator cmp = new integerComparator();
		
		BinaryMaxHeap<Integer> constructor2 = new BinaryMaxHeap<Integer>(cmp);
		
		assertTrue(constructor2.isEmpty());
		assertTrue(constructor2.size() == 0);
	}

	@Test
	void testBinaryMaxHeapListOfQextendsE() 
	{
		
		List<Integer> list3 = new LinkedList<Integer>();
		
		list3.add(1);
		list3.add(2);
		list3.add(3);
		
		BinaryMaxHeap<Integer> constructor3 = new BinaryMaxHeap<Integer>(list3);
		
		assertFalse(constructor3.isEmpty());
		assertTrue(constructor3.size() == 3);
	}

	@Test
	void testBinaryMaxHeapListOfQextendsEComparatorOfQsuperE() 
	{
		integerComparator cmp = new integerComparator();
		
		List<Integer> list4 = new LinkedList<Integer>();
		
		list4.add(1);
		list4.add(2);
		list4.add(3);
		
		BinaryMaxHeap<Integer> constructor3 = new BinaryMaxHeap<Integer>(list4, cmp);
		
		assertFalse(constructor3.isEmpty());
		assertTrue(constructor3.size() == 3);
	}

	@Test
	void testAdd() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
		
		Test.add(4);
		assertTrue(Test.size() == 4);
		Test.add(5);
		assertTrue(Test.size() == 5);
		Test.add(6);
		assertTrue(Test.size() == 6);
		Test.add(7);
		Test.add(8);
		Test.add(9);
		Test.add(10);
		Test.add(11);
		assertTrue(Test.size() == 11);
	}

	@Test
	void testPeek() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
		
		Test.add(12);
		Test.add(22);
		Test.add(5);
		Test.add(7);
		Test.add(14);
		Test.add(32);
		Test.add(9);
		Test.add(2);
		Test.add(4);
		assertTrue(Test.peek() == 32);
	}

	@Test
	void testExtractMax() 
	{
		
		BinaryMaxHeap<Integer> TestEmpty = new BinaryMaxHeap<Integer>();
		assertThrows(NoSuchElementException.class, () -> TestEmpty.extractMax());
		
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
		
		Test.add(12);
		Test.add(22);
		Test.add(5);
		Test.add(7);
		Test.add(14);
		Test.add(32);
		Test.add(9);
		Test.add(2);
		Test.add(4);
		assertTrue(Test.extractMax() == 32);
		assertTrue(Test.size() == 11);
		assertTrue(Test.extractMax() == 22);
		assertTrue(Test.size() == 10);
		assertTrue(Test.extractMax() == 14);
	}

	@Test
	void testSize() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
		
		assertTrue(Test.size() == 3);
		
		Test.add(12);
		Test.add(22);
		
		assertTrue(Test.size() == 5);
		assertTrue(Test.extractMax() == 22);
		assertTrue(Test.size() == 4);
		
		Test.add(5);
		Test.add(7);
		
		assertTrue(Test.size() == 6);
		assertTrue(Test.extractMax() == 12);
		assertTrue(Test.size() == 5);
		
		Test.add(14);
		Test.add(32);
		
		assertTrue(Test.size() == 7);
		assertTrue(Test.extractMax() == 32);
		assertTrue(Test.size() == 6);
		
		Test.add(9);
		Test.add(2);
		
		assertTrue(Test.size() == 8);
		assertTrue(Test.extractMax() == 14);
		assertTrue(Test.size() == 7);
		
	}

	@Test
	void testIsEmpty() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
		
		assertFalse(Test.isEmpty());
	}

	@Test
	void testClear() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
		
		Test.clear();
		
		assertTrue(Test.isEmpty());
		assertTrue(Test.size() == 0);
		
	}

	@Test
	void testToArray() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
		
		Test.add(12);
		Test.add(22);
		Test.add(5);
		Test.add(7);
		Test.add(14);
		Test.add(32);
		Test.add(9);
		Test.add(2);
		Test.add(4);
		
		Object[] arrayTest = Test.toArray();
		
		assertTrue(arrayTest.length == 12);
		assertTrue(arrayTest[0] == (Integer)32);
		
	}

}
