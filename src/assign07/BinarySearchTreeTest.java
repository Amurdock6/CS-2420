package assign07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
	
	private BinarySearchTree<String> testTree;

	@BeforeEach
	void setUp() throws Exception 
	{
		testTree = new BinarySearchTree();
	}
	
	@Test
	void testAdd() 
	{
		testTree.add("hello");
		assertTrue(testTree.contains("hello"));
		
		testTree.add("saturday");
		assertTrue(testTree.contains("saturday"));
		
		testTree.add("testing");
		assertTrue(testTree.contains("testing"));
		
		testTree.add("hello");
		assertTrue(testTree.size() == 3);
		
		
	}

	@Test
	void testAddAll() 
	{
		ArrayList<String> addAllCollection = new ArrayList();
		
		addAllCollection.add("hello");
		addAllCollection.add("saturday");
		addAllCollection.add("testing");
		
		testTree.addAll(addAllCollection);
		
		assertTrue(testTree.containsAll(addAllCollection));
		
		
	}

	@Test
	void testClear() 
	{
		testTree.add("hello");
		testTree.add("goodbye");
		testTree.add("saturday");
		testTree.add("testing");
		
		testTree.clear();
		
		assertTrue(testTree.size() == 0);
		
	}

	@Test
	void testContains() 
	{
		assertFalse(testTree.contains("anything"));
		
		testTree.add("anything");
		
		assertTrue(testTree.contains("anything"));
	}

	@Test
	void testContainsAll() 
	{
		
		ArrayList<String> addAllCollection = new ArrayList();
		
		addAllCollection.add("hello");
		addAllCollection.add("saturday");
		addAllCollection.add("testing");
		
		assertFalse(testTree.containsAll(addAllCollection));
		
		testTree.addAll(addAllCollection);
		
		assertTrue(testTree.containsAll(addAllCollection));
		
	}

	@Test
	void testFirst() 
	{
		testTree.add("saturday");
		testTree.add("testing");
		testTree.add("hello");
		testTree.add("goodbye");

		assertTrue(testTree.first() == "goodbye");
	}

	@Test
	void testIsEmpty() 
	{
		assertTrue(testTree.isEmpty());
	}

	@Test
	void testLast() 
	{
		testTree.add("saturday");
		testTree.add("testing");
		testTree.add("hello");
		testTree.add("goodbye");

		assertTrue(testTree.last() == "testing");
	}

	@Test
	void testRemove() 
	{
		testTree.add("saturday");
		testTree.add("testing");
		testTree.add("hello");
		testTree.add("goodbye");
		
		testTree.remove("saturday");
		
		assertFalse(testTree.remove("void"));
		assertFalse(testTree.contains("saturday"));
		assertTrue(testTree.size() == 3);
	}

	@Test
	void testRemoveAll() 
	{
		ArrayList<String> addAllCollection = new ArrayList();
		
		addAllCollection.add("hello");
		addAllCollection.add("saturday");
		addAllCollection.add("testing");
		addAllCollection.add("goodbye");
		
		testTree.addAll(addAllCollection);
		
		assertTrue(testTree.size() == 4);
		assertTrue(testTree.containsAll(addAllCollection));
		
		testTree.add("final");
		
		testTree.removeAll(addAllCollection);
		
		assertTrue(testTree.size() == 1);
		assertFalse(testTree.containsAll(addAllCollection));
		
	}

	@Test
	void testSize() 
	{
		assertTrue(testTree.size() == 0);
		
		testTree.add("one");
		
		assertTrue(testTree.size() == 1);
		
		testTree.add("two");
		
		assertTrue(testTree.size() == 2);
		
		testTree.remove("two");
		
		assertTrue(testTree.size() == 1);
	}

	@Test
	void testToArrayList() 
	{
		testTree.add("saturday");
		testTree.add("testing");
		testTree.add("hello");
		testTree.add("goodbye");
		testTree.add("final");
		
		ArrayList finalTest = testTree.toArrayList();
		
		assertTrue(finalTest.size() == 5);
		assertTrue(finalTest.get(0) == "final");
		assertTrue(finalTest.get(2) == "hello");
		assertTrue(finalTest.get(4) == "testing");
	}

}
