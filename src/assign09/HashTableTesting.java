package assign09;

import static org.junit.jupiter.api.Assertions.*;

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
	void testClearWeridInput() 
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
		studentGpaTable.put(edsger, -2453.4%-38);
		assertTrue(studentGpaTable.size() == 2);
		assertTrue(studentGpaTable.containsKey(alan));
		
		studentGpaTable.clear();
		assertTrue(studentGpaTable.size() == 0);
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
	void testContainsMultipleKeys() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash ada = new StudentGoodHash(1004203, "Ada", "Lovelace");
		StudentGoodHash edsger = new StudentGoodHash(1010661, "Edsger", "Dijkstra");
		StudentGoodHash grace = new StudentGoodHash(1019941, "Grace", "Hopper");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		studentGpaTable.put(ada, 3.2);
		studentGpaTable.put(edsger, -13.255);
		studentGpaTable.put(grace, 3%-.2);
		studentGpaTable.put(alan, 3-2.2);
		
		assertTrue(studentGpaTable.containsKey(grace));
		assertTrue(studentGpaTable.containsKey(alan));
		assertTrue(studentGpaTable.containsKey(edsger));
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
	void testContainsValueMultipleValues() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash ada = new StudentGoodHash(1004203, "Ada", "Lovelace");
		StudentGoodHash edsger = new StudentGoodHash(1010661, "Edsger", "Dijkstra");
		StudentGoodHash grace = new StudentGoodHash(1019941, "Grace", "Hopper");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		studentGpaTable.put(alan, 3.2);
		studentGpaTable.put(ada, 0.00);
		studentGpaTable.put(edsger, 6%-9.420);
		studentGpaTable.put(grace, -6542.87942312132);
		
		assertTrue(studentGpaTable.containsValue(3.2));
		assertTrue(studentGpaTable.containsValue(6%-9.420));
		assertTrue(!(studentGpaTable.containsValue(720.80)));
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
	void testEntriesAfterRemove() 
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
		studentGpaTable.remove(ada);
		studentGpaTable.remove(grace);
		
		
		assertTrue(studentGpaTable.entries().size() == 2);
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
	void testGetWeridInput() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash jebediah = new StudentGoodHash(0, "Jebediah", "Kerman");
		StudentGoodHash bill = new StudentGoodHash(69, "Bill", "Kerman");
		StudentGoodHash bob = new StudentGoodHash(420, "B", "n");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		studentGpaTable.put(alan, 3.2);
		studentGpaTable.put(jebediah, 3.2);
		studentGpaTable.put(bill, 3.2);
		studentGpaTable.put(bob, -453.23213215);
		
		
		assertTrue(studentGpaTable.get(alan) == 3.2);
		assertTrue(!(studentGpaTable.get(bob) == 3.2));
		assertTrue(studentGpaTable.get(bob) == -453.23213215);
	}

	@Test
	void testIsEmpty() 
	{
		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		
		assertTrue(studentGpaTable.isEmpty());
	}
	
	@Test
	void testIsEmptyWithInputs() 
	{
		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		assertTrue(studentGpaTable.isEmpty());
		
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash ada = new StudentGoodHash(1004203, "Ada", "Lovelace");
		StudentGoodHash edsger = new StudentGoodHash(1010661, "Edsger", "Dijkstra");
		StudentGoodHash grace = new StudentGoodHash(1019941, "Grace", "Hopper");

		studentGpaTable.put(alan, 3.2);
		studentGpaTable.put(ada, 3.5);
		studentGpaTable.put(edsger, 3.8);
		studentGpaTable.put(grace, 4.0);
		
		assertTrue(studentGpaTable.size() == 4);
		
		studentGpaTable.remove(alan);
		studentGpaTable.remove(ada);
		studentGpaTable.remove(edsger);
		studentGpaTable.remove(grace);
		
		assertTrue(studentGpaTable.size() == 0);
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
	void testPutWeridInputs() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash tim = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash ada = new StudentGoodHash(1004203, "Ada", "Lovelace");
		StudentGoodHash edsger = new StudentGoodHash(1010661, "Edsger", "Dijkstra");
		StudentGoodHash grace = new StudentGoodHash(1019941, "Grace", "Hopper");
		StudentGoodHash jebediah = new StudentGoodHash(0, "Jebediah", "Kerman");
		StudentGoodHash bill = new StudentGoodHash(69, "Bill", "Kerman");
		StudentGoodHash bob = new StudentGoodHash(420, "B", "n");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		studentGpaTable.put(alan, 3.2);
		studentGpaTable.put(ada, 3.5);
		studentGpaTable.put(edsger, -3.8);
		studentGpaTable.put(grace, 4.0);
		studentGpaTable.put(tim, 1.01);
		studentGpaTable.put(jebediah, 0.0569);
		studentGpaTable.put(bill, -211219.121120);
		studentGpaTable.put(bob, 12132132.01211);
		
		assertTrue(studentGpaTable.size() == 7);
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
	void testRemoveWeridInputs() 
	{
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash ada = new StudentGoodHash(1004203, "Ada", "Lovelace");
		StudentGoodHash edsger = new StudentGoodHash(1010661, "Edsger", "Dijkstra");
		StudentGoodHash grace = new StudentGoodHash(1019941, "Grace", "Hopper");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		studentGpaTable.put(alan, -3.22121231231);
		studentGpaTable.put(ada, -34454564.5465465);
		studentGpaTable.put(edsger, 3454654654654562.145);
		studentGpaTable.put(grace, 446545468.6942069);
		studentGpaTable.put(grace, 446545468.6942068);
		
		assertTrue(studentGpaTable.remove(grace) == 446545468.6942068);
		assertTrue(studentGpaTable.remove(ada) == -34454564.5465465);
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
	
	@Test
	void testSize2() {
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash grace = new StudentGoodHash(1019941, "Grace", "Hopper");
		StudentGoodHash jebediah = new StudentGoodHash(1004245, "Jebediah", "Kerman");
		StudentGoodHash bill = new StudentGoodHash(1010687, "Bill", "Kerman");
		StudentGoodHash bob = new StudentGoodHash(1019914, "Bob", "Kerman");

		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		assertTrue(studentGpaTable.size() == 0);
		studentGpaTable.put(bob, 2.2);
		studentGpaTable.put(grace, -4.0);
		studentGpaTable.put(bill, 3.975212132132133);
		studentGpaTable.put(jebediah, -3.975212132132133);
		assertTrue(!(studentGpaTable.entries().size() == 0));
		assertTrue(studentGpaTable.size() == 4);
		assertTrue(studentGpaTable.size() != 23123123);
		assertTrue(studentGpaTable.size() != -23123123);
		studentGpaTable.remove(bob);
		assertTrue(studentGpaTable.size() == 3);
		studentGpaTable.put(alan, 1.1);
		assertTrue(studentGpaTable.size() == 4);
	}
	
	@Test
	void testColisonNone() {
		StudentGoodHash alan = new StudentGoodHash(1019999, "Alan", "Turing");
		StudentGoodHash ada = new StudentGoodHash(1004203, "Ada", "Lovelace");
		StudentGoodHash edsger = new StudentGoodHash(1010661, "Edsger", "Dijkstra");
		StudentGoodHash grace = new StudentGoodHash(1019941, "Grace", "Hopper");
		
		HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
		assertTrue(studentGpaTable.size() == 0);
		studentGpaTable.put(alan, 3.5);
		studentGpaTable.put(ada, 3.6);
		studentGpaTable.put(edsger, 3.8);
		studentGpaTable.put(grace, 4.0);
		
		int numberOfCollison = studentGpaTable.getCollisions();
		
		assertTrue(numberOfCollison == 1);
	}
	
	@Test
	void testColisonLots() {
		StudentBadHash alan = new StudentBadHash(1019999, "Alan", "Turing");
		StudentBadHash ada = new StudentBadHash(1004203, "Ada", "Lovelace");
		StudentBadHash edsger = new StudentBadHash(1010661, "Edsger", "Dijkstra");
		StudentBadHash grace = new StudentBadHash(1019941, "Grace", "Hopper");
		StudentBadHash jebediah = new StudentBadHash(1004245, "Jebediah", "Kerman");
		StudentBadHash bill = new StudentBadHash(1010687, "Bill", "Kerman");
		StudentBadHash bob = new StudentBadHash(1019914, "Bob", "Kerman");
		
		HashTable<StudentBadHash, Double> studentGpaTable = new HashTable<StudentBadHash, Double>();
		assertTrue(studentGpaTable.size() == 0);
		studentGpaTable.put(alan, 3.5);
		studentGpaTable.put(ada, 3.6);
		studentGpaTable.put(edsger, 3.8);
		studentGpaTable.put(grace, 4.0);
		studentGpaTable.put(jebediah, 3.3);
		studentGpaTable.put(bill, 2.5);
		studentGpaTable.put(bob, 2.8);
		
		int numberOfCollison = studentGpaTable.getCollisions();
		
		assertTrue(numberOfCollison == 21);
	}
}
