package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayCollectionTest {
	
	private ArrayCollection arrayCollection;
	private ArrayCollection bigArray;

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
		bigArray.add(1375);
		bigArray.add(2046);
		
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

	@SuppressWarnings("unchecked")
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
		System.out.println(arrayCollection.size());
		
		// add all objects
		arrayCollection.addAll(bigArray);
		System.out.println(arrayCollection.size());
		
		// make sure that it adds objects not already in the collection
		assertTrue(arrayCollection.size() == 5);
		
	}

	@SuppressWarnings("unchecked")
	@Test
	void testClear() 
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
		
		// clear objects
		bigArray.clear();
		
		// make sure there are no objects
		assertTrue(bigArray.size() == 0);
		
	}

	@SuppressWarnings("unchecked")
	@Test
	void testContains() 
	{
		// create object
		Object testobj1 = "test1";
		
		// add the object to the collection
		arrayCollection.add(testobj1);
		
		// check that the collection contains the object
		assertTrue(arrayCollection.contains(testobj1));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testContainsAll() 
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
		arrayCollection.add(testobj2);
		arrayCollection.add(testobj3);
		arrayCollection.add(testobj4);
		arrayCollection.add(testobj5);
		
		// test that big array contains all the same objects as array collection
		assertTrue(bigArray.containsAll(arrayCollection));
		
	}

	@SuppressWarnings("unchecked")
	@Test
	void testIsEmpty() 
	{
		// test that bigArray is empty to start
		assertTrue(bigArray.isEmpty());
		
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
		
		bigArray.clear();
		
		//test that bigArray is empty after clearing items
		assertTrue(bigArray.isEmpty());
	}


	@SuppressWarnings("unchecked")
	@Test
	void testRemove() 
	{
		// create object
		Object testobj1 = "test1";
		Object testobj2 = "test2";
		Object testobj3 = "test3";
		Object testobj4 = "test4";
		Object testobj5 = "test5";
		
		// add the objects to the collections
		arrayCollection.add(testobj1);
		
		bigArray.add(testobj1);
		bigArray.add(testobj2);
		bigArray.add(testobj3);
		bigArray.add(testobj4);
		bigArray.add(testobj5);
		
		// remove the object
		arrayCollection.remove(testobj1);
		bigArray.remove(testobj3);
		
		// check that the collection contains the object
		assertTrue(arrayCollection.size() == 0);
		assertTrue(bigArray.size() == 4);
		
		
	
	}

	@SuppressWarnings("unchecked")
	@Test
	void testRemoveAll() 
	{
		// create object
		Object testobj1 = "test1";
		Object testobj2 = "test2";
		Object testobj3 = "test3";
		Object testobj4 = "test4";
		Object testobj5 = "test5";
		
		// add the objects to the collections
		arrayCollection.add(testobj1);
		arrayCollection.add(testobj2);
		arrayCollection.add(testobj3);
		arrayCollection.add(testobj4);
		
		bigArray.add(testobj1);
		bigArray.add(testobj2);
		bigArray.add(testobj3);
		bigArray.add(testobj4);
		bigArray.add(testobj5);
		
		// remove all the objects
		arrayCollection.addAll(bigArray);
		
		arrayCollection.removeAll(arrayCollection);
		
		assertTrue(arrayCollection.size() == 0);
	}

	@Test
	void testRetainAll() 
	{
		// create object
		Object testobj1 = "test1";
		Object testobj2 = "test2";
		Object testobj3 = "test3";
		Object testobj4 = "test4";
		Object testobj5 = "test5";
		
		// add the objects to the collections
		arrayCollection.add(testobj1);
		arrayCollection.add(testobj2);
		arrayCollection.add(testobj3);
		arrayCollection.add(testobj4);
		arrayCollection.add(testobj5);
		
		bigArray.add(testobj1);
		
		// retain only the objects that bigArray has
		arrayCollection.retainAll(bigArray);
		assertTrue(arrayCollection.size() == 1);
	}

//	@SuppressWarnings("unchecked")
	@Test
	void testSize() 
	{
		// create object
		Object testobj1 = "test1";
		Object testobj2 = "test2";
		Object testobj3 = "test3";
		Object testobj4 = "test4";
		Object testobj5 = "test5";
		
		// add the objects to the collections
		arrayCollection.add(testobj1);
		arrayCollection.add(testobj2);
		arrayCollection.add(testobj3);
		arrayCollection.add(testobj4);
		arrayCollection.add(testobj5);
		
		// test size of collection after specific methods
		assertTrue(arrayCollection.size() == 5);
	
		arrayCollection.remove(testobj3);
		
		assertTrue(arrayCollection.size() == 4);
		
		arrayCollection.clear();
		
		assertTrue(arrayCollection.size() == 0);
	}

//	@SuppressWarnings("unchecked")
//	@Test
//	void testToArray() 
//	{
//		// create object
//		Object testobj1 = "test1";
//		Object testobj2 = "test2";
//		Object testobj3 = "test3";
//		Object testobj4 = "test4";
//		Object testobj5 = "test5";
//		
//		// add the objects to the collections
//		arrayCollection.add(testobj1);
//		arrayCollection.add(testobj2);
//		arrayCollection.add(testobj3);
//		arrayCollection.add(testobj4);
//		arrayCollection.add(testobj5);
//		
//		Object[] arrayCollectionToArray = arrayCollection.toArray();
//		
//		Object[] testToArray = {testobj1, testobj2, testobj3, testobj4, testobj5};
//		
//		assertTrue(arrayCollectionToArray.equals(testToArray));
//	}

	@SuppressWarnings("unchecked")
	@Test
	void testToSortedList() 
	{
		
		// create object
		int testobj6 = 123;
		int testobj7 = 6655;
		int testobj8 = 323;
		int testobj9 = 1;
		int testobj10 = 772;
		
		bigArray.add(testobj6);
		bigArray.add(testobj7);
		bigArray.add(testobj8);
		bigArray.add(testobj9);
		bigArray.add(testobj10);
		
		IntegerComparator toSorted = new IntegerComparator();
		
		ArrayList sortTestList = new ArrayList();
		sortTestList = bigArray.toSortedList(toSorted);
		Object[] testObjectArray;
		testObjectArray = new Object[5];
		int counter = 0;
		
		for(Object t : sortTestList) {
			
			testObjectArray[counter] = t;
			counter++;
			
		}
		assertTrue(testObjectArray[0].equals(testobj9));
	}
}
