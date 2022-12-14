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
	void testBinaryMaxHeapListOfQextendsEWerid() 
	{
		
		List<Integer> list3 = new LinkedList<Integer>();
		
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(-12);
		list3.add(-69);
		list3.add(5);
		list3.add(7);
		list3.add(4 / 2 + 1);
		list3.add(32);
		list3.add(69 * 420 + 55445 - 121);
		list3.add(2);
		list3.add(56);
		
		BinaryMaxHeap<Integer> constructor3 = new BinaryMaxHeap<Integer>(list3);
		
		assertFalse(constructor3.isEmpty());
		assertTrue(constructor3.size() == 12);
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
	void testBinaryMaxHeapListOfQextendsEComparatorOfQsuperEWerid() 
	{
		integerComparator cmp = new integerComparator();
		
		List<Integer> list4 = new LinkedList<Integer>();
		
		list4.add(1);
		list4.add(2);
		list4.add(3);
		list4.add(-12);
		list4.add(-69);
		list4.add(5);
		list4.add(7);
		list4.add(4 / 2 + 1);
		list4.add(32);
		list4.add(69 * 420 + 55445 - 121);
		list4.add(2);
		list4.add(56);
		
		BinaryMaxHeap<Integer> constructor3 = new BinaryMaxHeap<Integer>(list4, cmp);
		
		assertFalse(constructor3.isEmpty());
		assertTrue(constructor3.size() == 12);
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
	void testAddWerid() 
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
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
		
		Test.add(4);
		assertTrue(Test.size() == 13);
		Test.add(5);
		assertTrue(Test.size() == 14);
		Test.add(6);
		assertTrue(Test.size() == 15);
		Test.add(7);
		Test.add(8);
		Test.add(9);
		assertTrue(Test.size() == 18);
		Test.clear();
		Test.add(10);
		Test.add(11);
		assertTrue(Test.size() == 2);
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
	void testPeekWerid() 
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
		assertTrue(Test.peek() == 84304);
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
		listTest.add(12);
		listTest.add(22);
		listTest.add(5);
		listTest.add(7);
		listTest.add(14);
		listTest.add(32);
		listTest.add(9);
		listTest.add(2);
		listTest.add(4);
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
				
		assertTrue(Test.extractMax() == 32);
		assertTrue(Test.size() == 11);
		assertTrue(Test.extractMax() == 22);
		assertTrue(Test.size() == 10);
		assertTrue(Test.extractMax() == 14);
	}
	
	@Test
	void testExtractMaxWerid() 
	{
		
		BinaryMaxHeap<Integer> TestEmpty = new BinaryMaxHeap<Integer>();
		assertThrows(NoSuchElementException.class, () -> TestEmpty.extractMax());
		
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
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);

		assertTrue(Test.extractMax() == 84304);
		assertTrue(Test.size() == 11);
		assertTrue(Test.extractMax() == 56);
		assertTrue(Test.size() == 10);
		assertTrue(Test.extractMax() == 32);
	}
	
	@Test
	void testExtractMaxOneValue()
	{
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>();
		Test.add(32);
		Test.add(22);
		assertTrue(Test.extractMax() == 32);
		assertTrue(Test.extractMax() == 22);
	}
	
	@Test
	void testExtractMaxOneValue2()
	{
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>();
		Test.add(1 - 212 + 4545 * 2 / 5);
		Test.add(-22);
		
		assertTrue(Test.extractMax() == 1607);
		assertTrue(Test.extractMax() == -22);
		assertTrue(Test.size() == 0);
		
		Test.add(56);
		Test.add(-12);
		Test.add(-69);
		Test.add(5);
		Test.add(7);
		Test.add(4 / 2 + 1);
		Test.add(32);
		
		assertTrue(Test.size() == 7);
		assertTrue(Test.extractMax() == 56);
		
		Test.clear();
		assertTrue(Test.size() == 0);
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
	void testSizeWerid() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
		
		assertTrue(Test.size() == 3);
		
		Test.add(1 - 212 + 4545 * 2 / 5);
		Test.add(-12);
		
		assertTrue(Test.size() == 5);
		assertTrue(Test.extractMax() == 1607);
		assertTrue(Test.size() == 4);
		
		Test.add(455);
		Test.add(6999);
		
		assertTrue(Test.size() == 6);
		assertTrue(Test.extractMax() == 6999);
		assertTrue(Test.size() == 5);
		
		Test.clear();
		Test.add(14);
		Test.add(32);
		
		assertTrue(Test.size() == 2);
		assertTrue(Test.extractMax() == 32);
		assertTrue(Test.size() == 1);
		
		Test.add(69);
		Test.add(-2);
		
		assertTrue(Test.size() == 3);
		assertTrue(Test.extractMax() == 69);
		Test.add(54654 / 45 / 12 +46 * 69);
		assertTrue(Test.size() == 3);
		
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
	void testIsEmptyWerid() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(1);
		listTest.add(2);
		listTest.add(3);
		
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
		
		Test.add(56);
		Test.add(-12);
		Test.add(-69);
		Test.add(5);
		Test.add(7);
		Test.add(4 / 2 + 1);
		Test.add(32);
		Test.add(69 * 420 + 55445 - 121);
		
		assertFalse(Test.isEmpty());
		
		Test.clear();
		
		assertTrue(Test.isEmpty());
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
	void testClearWerid() 
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
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
		
		Test.add(56);
		Test.add(-12);
		Test.add(-69);
		Test.add(5);
		Test.add(7);
		Test.add(4 / 2 + 1);
		Test.add(32);
		Test.add(69 * 420 + 55445 - 121);
		
		Test.clear();
		
		Test.add(56);
		Test.add(-12);
		Test.add(-69);
		Test.add(5);
		Test.add(7);
		Test.add(4 / 2 + 1);
		Test.add(32);
		Test.add(69 * 420 + 55445 - 121);
		
		assertTrue(Test.size() == 8);
		
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
	
	@Test
	void testToArrayWerid() 
	{
		List<Integer> listTest = new LinkedList<Integer>();
		
		listTest.add(2);
		listTest.add(-2);
		listTest.add(9 + 9 - 7 / 2);
		
		BinaryMaxHeap<Integer> Test = new BinaryMaxHeap<Integer>(listTest);
		
		Test.add(-12);
		Test.add(-69);
		Test.add(5);
		Test.add(7);
		Test.add(4 / 2 + 1);
		Test.add(32);
		Test.add(69 * 420 + 55445 - 121);
		Test.add(2);
		Test.add(56);
		
		Object[] arrayTest = Test.toArray();
		
		assertTrue(arrayTest.length == 12);
		assertTrue(arrayTest[0].equals((Integer)84304));
		assertTrue(arrayTest[2] == (Integer)56);
		
	}

}
