package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListStackTester 
{
	
	private LinkedListStack testStack;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		testStack = new LinkedListStack();
	}

	@Test
	void testClear() 
	{
		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		testStack.clear();
		
		assertTrue(testStack.size() == 0);
		assertTrue(testStack.isEmpty());
	}

	@Test
	void testIsEmpty() 
	{
		assertTrue(testStack.isEmpty());
	}

	@Test
	void testPeek() 
	{
		testStack.push(1);
		assertTrue( (int) testStack.peek() == 1);
		
		testStack.push(2);
		assertTrue( (int) testStack.peek() == 2);
		
		testStack.push(3);
		assertTrue( (int) testStack.peek() == 3);
	}
	
	@Test
	void testPeekException() 
	{
		assertThrows(NoSuchElementException.class, () -> testStack.peek() );
	}

	@Test
	void testPop() 
	{
		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		
		assertTrue((int) testStack.pop() == 3);
		assertTrue((int) testStack.pop() == 2);
		assertTrue((int) testStack.pop() == 1);
		
		assertTrue(testStack.isEmpty());
		assertTrue(testStack.size() == 0);
	}
	
	@Test
	void testPopException() 
	{
		assertThrows(NoSuchElementException.class, () -> testStack.pop() );
	}

	@Test
	void testPush() 
	{
		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		
		assertTrue((int) testStack.peek() == 3);
		assertFalse(testStack.isEmpty());
		assertTrue(testStack.size() == 3);
	}

	@Test
	void testSize() 
	{
		testStack.push(1);
		assertTrue(testStack.size() == 1);
		testStack.push(2);
		assertTrue(testStack.size() == 2);
		testStack.push(3);
		assertTrue(testStack.size() == 3);
	}

}
