package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

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
		fail("Not yet implemented");
	}

	@Test
	void testAdd() 
	{
		fail("Not yet implemented");
	}

	@Test
	void testPeek() 
	{
		fail("Not yet implemented");
	}

	@Test
	void testExtractMax() 
	{
		fail("Not yet implemented");
	}

	@Test
	void testSize() 
	{
		fail("Not yet implemented");
	}

	@Test
	void testIsEmpty() 
	{
		fail("Not yet implemented");
	}

	@Test
	void testClear() 
	{
		fail("Not yet implemented");
	}

	@Test
	void testToArray() 
	{
		fail("Not yet implemented");
	}

}
