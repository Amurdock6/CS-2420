package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class ArrayCollectionTest {

	@Test
	void testArrayCollection() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
		
		ArrayCollection arrayCollection = new ArrayCollection();
		ArrayCollection addAllFromCollect = new ArrayCollection();
		ArrayCollection bigArray = new ArrayCollection();
		
		Object testobj = 123;
		Object testobj1 = "test1";
		Object testobj2 = "test2";
		Object testobj3 = "test3";
		Object testobj4 = "test4";
		Object testobj5 = "test5";
		
		bigArray.add(testobj2);
		bigArray.add(testobj3);
		bigArray.add(testobj4);
		bigArray.add(testobj5);
		
		arrayCollection.add(testobj1);
		//arrayCollection.add(testobj2);
		arrayCollection.addAll(bigArray);
		
		System.out.println(arrayCollection.toArray());
		System.out.println(arrayCollection.size());
		
		fail("Not yet implemented");
	}

	@Test
	void testAddAll() {
		fail("Not yet implemented");
	}

	@Test
	void testClear() {
		fail("Not yet implemented");
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
