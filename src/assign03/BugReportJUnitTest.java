package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BugReportJUnitTest {

	private ArrayCollection<Object> arrayCollection;
	private ArrayCollection<Object> arrayCollection2;
	
	@BeforeEach
	void setUp() throws Exception 
	{ 
		// create collection
		arrayCollection = new ArrayCollection<Object>();
		arrayCollection2 = new ArrayCollection<Object>();
	}
	
	private String randomStringGen() {
		// creating a random string generator to make testing easier
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		
		// ranodm int generator to give use random string length
		Random rand = new Random(); // instance of random class
		int upperbound = 25;
		// generate random values from 0-24
		int int_random = rand.nextInt(upperbound);
		
		StringBuilder sb = new StringBuilder(int_random);
		
		for (int i = 0; i < int_random; i++) {

			// generate a random number between 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		
		return sb.toString();
	}
	
	
	@Test
	void addAllandRemoveAllOnALargeCollection() {
		// will add 1000 random items into our arrayCollection
		for (int i = 0; i <= 1000; i++) {
			arrayCollection.add(randomStringGen());
		}

		// will add all items from arrayCollection into arrayCollection2
		arrayCollection2.addAll(arrayCollection);
		// checks to make sure we have added all items correctly
		assertTrue(arrayCollection2.containsAll(arrayCollection));
		
		
		// removes all itesms out of arrayCollection2
		arrayCollection2.removeAll(arrayCollection);
		assertTrue(arrayCollection2.size() == 0);
	}
	
	@Test
	void hasNextOnEmptyList() {
		assertFalse(arrayCollection.iterator().hasNext());
	}
	
	@Test
	void removeAndRemoveAllAfterClear() {
		// will add 1000 random items into our arrayCollection
		for (int i = 0; i <= 1000; i++) {
			arrayCollection.add(randomStringGen());
		}
		
		arrayCollection.add(1);
		
		assertTrue(arrayCollection.size() != 0);
		
		arrayCollection.clear();
		
		assertTrue(arrayCollection.size() == 0);
		assertFalse(arrayCollection.remove(1));
		assertFalse(arrayCollection.removeAll(arrayCollection));
		assertTrue(arrayCollection.size() == 0);
	}
	
	@Test
	void test() {
		
	}
	
	@Test
	void retainAllOnSmallCollection() {
		
	}
	
	// recreates error 
	@Test
	void retainAllOnArrayCollectionOfOneItem() {
		// create and add object into arrayCollection
		Object testobj1 = "test1";
		arrayCollection.add(testobj1);
		
		// adds same object into our seconed arrayCollection
		arrayCollection2.add(testobj1);
		
		// will check to make sure our first array retains only and all matching items that are present in arrayCollection2
		assertTrue(arrayCollection.retainAll(arrayCollection2));
	}
	
	
	


}
