package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * File to revel the bugs in assignment 3 
 * 
 * @author Alex Murdock
 *
 */
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
		arrayCollection.add(1);
		assertTrue(arrayCollection.contains(1));
		arrayCollection2.addAll(arrayCollection);
		
		// checks to make sure we have added all items correctly
		assertTrue(arrayCollection2.containsAll(arrayCollection));
		
		// removes all itesms out of arrayCollection2
		arrayCollection2.removeAll(arrayCollection);
		assertFalse(arrayCollection2.containsAll(arrayCollection));
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
		
		// will throw an error but that is what we want because next() should throw a NoSuchElementException() if there is not a next item in our arrayCollection.
		assertTrue(arrayCollection.size() == 0);
		arrayCollection.remove(1);
		arrayCollection.removeAll(arrayCollection);
		assertTrue(arrayCollection.size() == 0);
	}	
	
	@Test
	void retainAllOnSmallCollection() {
		arrayCollection.add("1");
		arrayCollection.add("2");
		arrayCollection.add("3");
		arrayCollection.add("4");
		arrayCollection.add("5");
		
		arrayCollection2.add("1");
		arrayCollection2.add("2");
		arrayCollection2.add("3");
		arrayCollection2.add("4");
		arrayCollection2.add("6");
		
		arrayCollection.retainAll(arrayCollection2);
		
		assertTrue(arrayCollection.size() == 4);
		assertTrue(arrayCollection.contains("1"));
	}
	
	@Test
	void retainAllOnArrayCollectionOfOneItem() {
		// create and add object into arrayCollection
		Object testobj1 = "test1";
		arrayCollection.add(testobj1);
		
		// adds same object into our seconed arrayCollection
		arrayCollection2.add(testobj1);
		
		// will check to make sure our first array retains only and all matching items that are present in arrayCollection2
		arrayCollection.retainAll(arrayCollection2);
		
		assertTrue(arrayCollection.contains(testobj1));
	}
	
	@Test
	void containsAllLargeCollection() {
		for (int i = 0; i <= 1000; i++) {
			arrayCollection.add(randomStringGen());
		}
		
		arrayCollection2.addAll(arrayCollection);
		
		assertTrue(arrayCollection2.size() != 0);
		assertTrue(arrayCollection.containsAll(arrayCollection2));
	}
	
	@Test
	void RemoveOnALargeCollection() {
		for (int i = 0; i <= 1; i++) {
			arrayCollection.add(randomStringGen());
		}
		
		arrayCollection.add(1);
		assertTrue(arrayCollection.contains(1));
		arrayCollection.remove(1);
		assertTrue(arrayCollection.contains(1) == false);
	}
	
	@Test
	void containsAllWithDiffrentTypes() {
		Object testObj = "16";
		
		arrayCollection.add(1.1);
		arrayCollection.add("test");
		arrayCollection.add(2);
		arrayCollection.add(testObj);
		arrayCollection.add(null);
		arrayCollection.add('a');
		arrayCollection.add(true);
		
		arrayCollection2.addAll(arrayCollection);
		assertTrue(arrayCollection2.containsAll(arrayCollection));
	}


}
