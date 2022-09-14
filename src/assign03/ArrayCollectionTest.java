package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayCollectionTest {
	
	private ArrayCollection arrayCollection;
	private ArrayCollection bigArray;

	@SuppressWarnings({ "rawtypes" })
	@BeforeEach
	void setUp() throws Exception 
	{ 
		// create collection
		arrayCollection = new ArrayCollection();
		bigArray = new ArrayCollection();
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	void testAdd() 
	{
		
		// create a bunch of stuff to put in collection
		Object testobj1 = "test1";
		Object testobj2 = "test2";
		Object testobj3 = "test3";
		Object testobj4 = "test4";
		Object testobj5 = "test5";
		Object testobj6 = 123;
		Object testobj7 = 223;
		Object testobj8 = 323;
		Object testobj9 = 423;
		Object testobj10 = 523;
		Object testobj11 = 623;
		
		// add stuff to collection
		bigArray.add(testobj1);
		bigArray.add(testobj2);
		bigArray.add(testobj3);
		bigArray.add(testobj4);
		bigArray.add(testobj5);
		bigArray.add(testobj6);
		bigArray.add(testobj7);
		bigArray.add(testobj8);
		bigArray.add(testobj9);
		bigArray.add(testobj10);
		bigArray.add(testobj11);
		
		arrayCollection.add(testobj1);
		
		// check the number of items in the collections
		assertTrue(bigArray.size() == 11);
		assertTrue(arrayCollection.size() == 1);
		
		// try adding items that are already in the array
		arrayCollection.add(testobj1);
		bigArray.add(testobj1);
		
		// make sure those items didn't get added
		assertTrue(bigArray.size() == 11);
		assertTrue(arrayCollection.size() == 1);
		
	}

	@Test
	void testAddAll() 
	{
		// create objects
		Object testobj1 = "test1";
		Object testobj2 = "test2";
		Object testobj3 = "test3";
		Object testobj4 = "test4";
		Object testobj5 = "test5";
		
		// add objects
		bigArray.add(testobj1);
		bigArray.add(testobj2);
		bigArray.add(testobj3);
		bigArray.add(testobj4);
		bigArray.add(testobj5);
		
		arrayCollection.add(testobj1);
		
		// add all objects
		arrayCollection.addAll(bigArray);
		
		assertTrue(arrayCollection.size() == 5);
		
	}

	@Test
	void testClear() 
	{
		
		Object testobj1 = "test1";
		Object testobj2 = "test2";
		Object testobj3 = "test3";
		Object testobj4 = "test4";
		Object testobj5 = "test5";
		
		bigArray.add(testobj1);
		bigArray.add(testobj2);
		bigArray.add(testobj3);
		bigArray.add(testobj4);
		bigArray.add(testobj5);
		
		bigArray.clear();
		
		assertTrue(bigArray.size() == 0);
		
	}

	@Test
	void testContains() {
		fail("Not yet implemented");
	}

	@Test
	void testContainsAll() {
		fail("Not yet implemented");
	}

	@Test
	void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

	@Test
	void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveAll() {
		fail("Not yet implemented");
	}

	@Test
	void testRetainAll() {
		fail("Not yet implemented");
	}

	@Test
	void testSize() {
		fail("Not yet implemented");
	}

	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	@Test
	void testToSortedList() {
		fail("Not yet implemented");
	}
	
	
//	public abstract class ArrayCollection<T> implements Collection<T> {	
	@Test
	void testForIterator() {
		ArrayCollection arrayCollection = new ArrayCollection();
//		Object testobj = 123;
//		Object testobj1 = "test";
//		Object myInt = 9;
//		T myTestString = (T) testobj1;
//		T myTestNum = (T) myInt; // Automatic casting: Object to T
//		arrayCollection.add(myTestNum);
//		arrayCollection.add(myTestString);
//		
//		arrayCollection.add();
//		arrayCollection.iterator();
		arrayCollection.test();

		fail("Not yet implemented");
	}

}
