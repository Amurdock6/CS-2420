package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assign02.LibraryGeneric;
import assign02.PhoneNumber;

class SinglyLinkedListTester 
{
	
	private SinglyLinkedList testList;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		testList = new SinglyLinkedList();
	}
	
	@Test
	void testInsertFirst() 
	{
		testList.insertFirst(5);
		
		assertTrue( (int) testList.get(0) == 5);
	}

	@Test
	void testInsert() 
	{
		testList.insert(0, 4);
		testList.insert(1, 6);
		testList.insert(2, 7);
		testList.insert(1, 8);
		testList.insertFirst(5);
		
		assertTrue( (int) testList.get(0) == 5);
		assertTrue( (int) testList.get(1) == 4);
		assertTrue( (int) testList.get(2) == 8);
		assertTrue( (int) testList.get(3) == 6);
		assertTrue( (int) testList.get(4) == 7);
	}
	
	@Test
	void testInsertThrowsException() 
	{
		
		testList.insert(0, 4);
		testList.insert(1, 6);
		testList.insert(2, 7);
		
		assertThrows(IndexOutOfBoundsException.class, () -> testList.insert(6, 8) );

	}

	@Test
	void testGetFirst() 
	{
		testList.insert(0, 4);
		testList.insert(1, 6);
		testList.insert(2, 7);
		testList.insert(1, 8);
		testList.insertFirst(5);
		
		assertTrue( (int) testList.getFirst() == 5);
	}
	
	@Test
	void testGetFirstThrowsException() 
	{
		assertThrows(NoSuchElementException.class, () -> testList.getFirst() );
	}

	@Test
	void testGet() 
	{
		testList.insert(0, 4);
		testList.insert(1, 6);
		testList.insert(2, 7);
		testList.insert(1, 8);
		
		assertTrue( (int) testList.get(0) == 4);
		assertTrue( (int) testList.get(1) == 8);
		assertTrue( (int) testList.get(2) == 6);
		assertTrue( (int) testList.get(3) == 7);
		
		assertThrows(IndexOutOfBoundsException.class, () -> testList.get(4) );
	}

	@Test
	void testDeleteFirst() 
	{
		testList.insert(0, 4);
		testList.insert(1, 6);
		testList.insert(2, 7);
		testList.insert(1, 8);
		testList.deleteFirst();
		
		assertTrue( (int) testList.get(0) == 8);
		assertTrue( (int) testList.get(1) == 6);
		assertTrue( (int) testList.get(2) == 7);
	}
	
	@Test
	void testDeleteFirstThrowsException() 
	{
		assertThrows(NoSuchElementException.class, () -> testList.deleteFirst() );
	}

	@Test
	void testDelete() 
	{
		testList.insert(0, 4);
		testList.insert(1, 6);
		testList.insert(2, 7);
		testList.insert(1, 8);
		testList.delete(2);
		
		assertTrue( (int) testList.get(0) == 4);
		assertTrue( (int) testList.get(1) == 8);
		assertTrue( (int) testList.get(2) == 7);
		
		assertThrows(IndexOutOfBoundsException.class, () -> testList.delete(3) );
	}

	@Test
	void testIndexOf() 
	{
		testList.insert(0, 4);
		testList.insert(1, 6);
		testList.insert(2, 7);
		testList.insert(1, 8);
		
		assertTrue(testList.indexOf(6) == 2);
	}

	@Test
	void testSize() 
	{
		testList.insert(0, 4);
		testList.insert(1, 6);
		testList.insert(2, 7);
		testList.insert(1, 8);
		
		assertTrue(testList.size() == 4);
	}

	@Test
	void testIsEmpty() 
	{
		assertTrue(testList.isEmpty());
		assertTrue(testList.size() == 0);
	}

	@Test
	void testClear() 
	{
		testList.insert(0, 4);
		testList.insert(1, 6);
		testList.insert(2, 7);
		testList.insert(1, 8);
		testList.clear();
		
		assertTrue(testList.isEmpty());
		assertTrue(testList.size() == 0);
	}

	@Test
	void testToArray() 
	{
		testList.insert(0, 4);
		testList.insert(1, 6);
		testList.insert(2, 7);
		testList.insert(1, 8);
		
		Object[] testArray = testList.toArray();
		
		assertTrue( (int) testArray[0] == 4);
		assertTrue( (int) testArray[1] == 8);
		assertTrue( (int) testArray[2] == 6);
		assertTrue( (int) testArray[3] == 7);
		
	}

}
