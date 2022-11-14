package assign09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class HashTableTesting {

	@Test
	void testGrowRehash() 
	{
		
		HashTable<Integer, Integer> growRehash = new HashTable<Integer, Integer>();
		
		for(int i = 0; i < 100000; i++)
			growRehash.put(i + 1, 1);
		
		System.out.println(growRehash.size());
		System.out.println(growRehash.getCollisions());
		assertTrue(growRehash.size() == 100000);
	}

	@Test
	void testClear() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash ada = new StudentGoodHash(1004203, "Ada", "Lovelace");
		StudentGoodHash edsger = new StudentGoodHash(1010661, "Edsger", "Dijkstra");
		StudentGoodHash grace = new StudentGoodHash(1019941, "Grace", "Hopper");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		studentGpaTable.put(alan, 3.2);
		studentGpaTable.put(ada, 3.5);
		studentGpaTable.put(edsger, 3.8);
		studentGpaTable.put(grace, 4.0);
		
		studentGpaTable.clear();
		assertTrue(studentGpaTable.size() == 0);
		assertTrue(studentGpaTable.isEmpty());
		
		studentGpaTable.put(alan, 3.2);
		assertTrue(studentGpaTable.size() == 1);
		assertTrue(studentGpaTable.containsKey(alan));
	}

	@Test
	void testContainsKey() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		studentGpaTable.put(alan, 3.2);
		
		
		assertTrue(studentGpaTable.containsKey(alan));
	}

	@Test
	void testContainsValue() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		studentGpaTable.put(alan, 3.2);
		
		
		assertTrue(studentGpaTable.containsValue(3.2));
	}

	@Test
	void testEntries() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash ada = new StudentGoodHash(1004203, "Ada", "Lovelace");
		StudentGoodHash edsger = new StudentGoodHash(1010661, "Edsger", "Dijkstra");
		StudentGoodHash grace = new StudentGoodHash(1019941, "Grace", "Hopper");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		studentGpaTable.put(alan, 3.2);
		studentGpaTable.put(ada, 3.5);
		studentGpaTable.put(edsger, 3.8);
		studentGpaTable.put(grace, 4.0);
		
		
		assertTrue(studentGpaTable.entries().size() == 4);
	}

	@Test
	void testGet() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		studentGpaTable.put(alan, 3.2);
		
		assertTrue(studentGpaTable.get(alan) == 3.2);
	}

	@Test
	void testIsEmpty() 
	{
		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		
		assertTrue(studentGpaTable.isEmpty());
	}

	@Test
	void testPut() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash ada = new StudentGoodHash(1004203, "Ada", "Lovelace");
		StudentGoodHash edsger = new StudentGoodHash(1010661, "Edsger", "Dijkstra");
		StudentGoodHash grace = new StudentGoodHash(1019941, "Grace", "Hopper");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		studentGpaTable.put(alan, 3.2);
		studentGpaTable.put(ada, 3.5);
		studentGpaTable.put(edsger, 3.8);
		studentGpaTable.put(grace, 4.0);
		studentGpaTable.put(alan, 1.0);
		
		assertTrue(studentGpaTable.size() == 4);
	}

	@Test
	void testRemove() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash ada = new StudentGoodHash(1004203, "Ada", "Lovelace");
		StudentGoodHash edsger = new StudentGoodHash(1010661, "Edsger", "Dijkstra");
		StudentGoodHash grace = new StudentGoodHash(1019941, "Grace", "Hopper");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		studentGpaTable.put(alan, 3.2);
		studentGpaTable.put(ada, 3.5);
		studentGpaTable.put(edsger, 3.8);
		studentGpaTable.put(grace, 4.0);
		
		assertTrue(studentGpaTable.remove(alan) == 3.2);
		assertTrue(studentGpaTable.remove(ada) == 3.5);
		assertTrue(studentGpaTable.remove(ada) == null);
		
		assertTrue(studentGpaTable.size() == 2);
	}

	@Test
	void testSize() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash ada = new StudentGoodHash(1004203, "Ada", "Lovelace");
		StudentGoodHash edsger = new StudentGoodHash(1010661, "Edsger", "Dijkstra");
		StudentGoodHash grace = new StudentGoodHash(1019941, "Grace", "Hopper");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		assertTrue(studentGpaTable.size() == 0);
		studentGpaTable.put(alan, 3.2);
		assertTrue(studentGpaTable.size() == 1);
		studentGpaTable.put(ada, 3.5);
		assertTrue(studentGpaTable.size() == 2);
		studentGpaTable.put(edsger, 3.8);
		assertTrue(studentGpaTable.size() == 3);
		studentGpaTable.put(grace, 4.0);
		assertTrue(studentGpaTable.size() == 4);
		
		assertTrue(studentGpaTable.remove(alan) == 3.2);
		assertTrue(studentGpaTable.size() == 3);
		assertTrue(studentGpaTable.remove(ada) == 3.5);
		assertTrue(studentGpaTable.size() == 2);
		assertTrue(studentGpaTable.remove(ada) == null);	
		assertTrue(studentGpaTable.size() == 2);
	}

}
