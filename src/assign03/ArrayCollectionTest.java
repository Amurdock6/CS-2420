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
	
//	@SuppressWarnings({ "unchecked" })
//	@Test
//	void testAdd() 
//	{
//		
//		// create a bunch of stuff to put in collection
//		Object testobj1 = "test1";
//		Object testobj2 = "test2";
//		Object testobj3 = "test3";
//		Object testobj4 = "test4";
//		Object testobj5 = "test5";
//		Object testobj6 = 123;
//		Object testobj7 = 223;
//		Object testobj8 = 323;
//		Object testobj9 = 420;
//		Object testobj10 = 523;
//		Object testobj11 = 69;
//		
//		// add stuff to collection
//		bigArray.add(testobj1);
//		bigArray.add(testobj2);
//		bigArray.add(testobj3);
//		bigArray.add(testobj4);
//		bigArray.add(testobj5);
//		bigArray.add(testobj6);
//		bigArray.add(testobj7);
//		bigArray.add(testobj8);
//		bigArray.add(testobj9);
//		bigArray.add(testobj10);
//		bigArray.add(testobj11);
//		
//		arrayCollection.add(testobj1);
//		
//		// check the number of items in the collections
//		assertTrue(bigArray.size() == 11);
//		assertTrue(arrayCollection.size() == 1);
//		
//		// try adding items that are already in the array
//		arrayCollection.add(testobj1);
//		bigArray.add(testobj1);
//		
//		// make sure those items didn't get added
//		assertTrue(bigArray.size() == 11);
//		assertTrue(arrayCollection.size() == 1);
//		
//	}
//
//	@SuppressWarnings("unchecked")
//	@Test
//	void testAddAll() 
//	{
//		// create objects
//		Object testobj1 = "test1";
//		Object testobj2 = "test2";
//		Object testobj3 = "test3";
//		Object testobj4 = "test4";
//		Object testobj5 = "test5";
//		
//		// add objects
//		bigArray.add(testobj1);
//		bigArray.add(testobj2);
//		bigArray.add(testobj3);
//		bigArray.add(testobj4);
//		bigArray.add(testobj5);
//		
//		arrayCollection.add(testobj1);
//		
//		// add all objects
//		arrayCollection.addAll(bigArray);
//		arrayCollection.containsAll(bigArray);
////		System.out.println(arrayCollection.containsAll(bigArray));
//		
//		// make sure that it adds objects not already in the collection
//		assertTrue(arrayCollection.size() == 5);
//		
//	}
//
//	@SuppressWarnings("unchecked")
//	@Test
//	void testClear() 
//	{
//		// create objects
//		Object testobj1 = "test1";
//		Object testobj2 = "test2";
//		Object testobj3 = "test3";
//		Object testobj4 = "test4";
//		Object testobj5 = "test5";
//		
//		// add objects
//		bigArray.add(testobj1);
//		bigArray.add(testobj2);
//		bigArray.add(testobj3);
//		bigArray.add(testobj4);
//		bigArray.add(testobj5);
//		
//		// clear objects
//		bigArray.clear();
//		
//		// make sure there are no objects
//		assertTrue(bigArray.size() == 0);
//		
//	}
//
//	@SuppressWarnings("unchecked")
//	@Test
//	void testContains() 
//	{
//		// create object
//		Object testobj1 = "test1";
//		
//		// add the object to the collection
//		arrayCollection.add(testobj1);
//		
//		// check that the collection contains the object
//		assertTrue(arrayCollection.contains(testobj1));
//	}
//
//	@SuppressWarnings("unchecked")
//	@Test
//	void testContainsAll() 
//	{
//		// create objects
//		Object testobj1 = "test1";
//		Object testobj2 = "test2";
//		Object testobj3 = "test3";
//		Object testobj4 = "test4";
//		Object testobj5 = "test5";
//		
//		// add objects
//		bigArray.add(testobj1);
//		bigArray.add(testobj2);
//		bigArray.add(testobj3);
//		bigArray.add(testobj4);
//		bigArray.add(testobj5);
//		
//		arrayCollection.add(testobj1);
//		arrayCollection.add(testobj2);
//		arrayCollection.add(testobj3);
//		arrayCollection.add(testobj4);
//		arrayCollection.add(testobj5);
//		
//		// test that big array contains all the same objects as array collection
//		assertTrue(bigArray.containsAll(arrayCollection));
//		
//	}
//
//	@Test
//	void testIsEmpty() 
//	{
//		// test that bigArray is empty to start
//		assertTrue(bigArray.isEmpty());
//		
//		// create objects
//		Object testobj1 = "test1";
//		Object testobj2 = "test2";
//		Object testobj3 = "test3";
//		Object testobj4 = "test4";
//		Object testobj5 = "test5";
//		
//		// add objects
//		bigArray.add(testobj1);
//		bigArray.add(testobj2);
//		bigArray.add(testobj3);
//		bigArray.add(testobj4);
//		bigArray.add(testobj5);
//		
//		bigArray.clear();
//		
//		//test that bigArray is empty after clearing items
//		assertTrue(bigArray.isEmpty());
//	}
//
//	@Test
//	void testIterator() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testRemove() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testRemoveAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testRetainAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSize() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testToArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testToSortedList() {
//		fail("Not yet implemented");
//	}
//	
//	
////	public abstract class ArrayCollection<T> implements Collection<T> {	
//	@Test
//	void testForIterator() {
//		ArrayCollection arrayCollection = new ArrayCollection();
////		Object testobj = 123;
////		Object testobj1 = "test";
////		Object myInt = 9;
////		T myTestString = (T) testobj1;
////		T myTestNum = (T) myInt; // Automatic casting: Object to T
////		arrayCollection.add(myTestNum);
////		arrayCollection.add(myTestString);
////		
////		arrayCollection.add();
////		arrayCollection.iterator()("Not yet implemented");
//	}

//	@SuppressWarnings("unchecked")
//	@Test
//	void genralTestForFunctionality() {
//
//		ArrayCollection arrayCollection = new ArrayCollection();
//		ArrayCollection addAllFromCollect = new ArrayCollection();
//		ArrayCollection bigArray = new ArrayCollection();
//
//		Object testobj1 = "test1";
//		Object testobj2 = "test2";
//		Object testobj3 = "test3";
//		Object testobj4 = "test4";
//		Object testobj5 = "test5";
//		Object testobj6 = 123;
//
//		bigArray.add(testobj1);
//		bigArray.add(testobj2);
//
//		arrayCollection.add(testobj1);
//		arrayCollection.add(testobj2);
////		arrayCollection.addAll(bigArray);
////		for (Object u : bigArray) {
////			System.out.println(u);
////		}
//		
//
//		arrayCollection.containsAll(bigArray);
//
////		System.out.println(arrayCollection.containsAll(bigArray));
//
//
//	}
	
	
	@Test
	void testForNext() {
		ArrayCollection arrayCollection = new ArrayCollection();
		ArrayCollection addAllFromCollect = new ArrayCollection();
		
		Object testobj1 = 0;
		Object testobj2 = "test2";
		Object testobj3 = "test3";
		Object testobj4 = "test4";
		Object testobj5 = 6;

		arrayCollection.add(testobj1);
		arrayCollection.add(testobj2);
		arrayCollection.add(testobj3);
		arrayCollection.add(testobj4);
		arrayCollection.add(testobj5);
		
		for (Object u : arrayCollection) {
			System.out.println(u);
		}
		
//		arrayCollection.add(testobj2);
//		arrayCollection.add(testobj3);
//		
//		addAllFromCollect.add(testobj5);
//		addAllFromCollect.add(testobj3);
//		addAllFromCollect.add(testobj4);
//		
//		arrayCollection.addAll(addAllFromCollect);
////		System.out.println(arrayCollection.containsAll(addAllFromCollect));
		
//		arrayCollection.iterator().next();
//		System.out.println(arrayCollection.iterator().next());
		
	}

}
