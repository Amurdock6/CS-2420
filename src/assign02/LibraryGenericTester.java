package assign02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains tests for LibraryGeneric.
 * 
 * @author Erin Parker and Todd Oldham and Alex Murdock
 * @version September 6, 2022
 */
public class LibraryGenericTester 
{
	private LibraryGeneric<String> nameLib;  // library that uses names to identify patrons (holders)
	private LibraryGeneric<String> books;
	private LibraryGeneric<PhoneNumber> phoneLib;  // library that uses phone numbers to identify patrons
	
	@BeforeEach
	void setUp() throws Exception 
	{
		nameLib = new LibraryGeneric<String>();
		nameLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		nameLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		nameLib.add(9780446580342L, "David Baldacci", "Simple Genius");

		phoneLib = new LibraryGeneric<PhoneNumber>();
		phoneLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		phoneLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		phoneLib.add(9780446580342L, "David Baldacci", "Simple Genius");		
	}
	
	@Test
	public void testNameLibCheckout() 
	{
		String patron = "Jane Doe";
		assertTrue(nameLib.checkout(9780330351690L, patron, 1, 1, 2008));
		assertTrue(nameLib.checkout(9780374292799L, patron, 1, 1, 2008));
	}

	@Test
	public void testNameLibLookup() 
	{
		String patron = "Jane Doe";
		nameLib.checkout(9780330351690L, patron, 1, 1, 2008);
		nameLib.checkout(9780374292799L, patron, 1, 1, 2008);
		ArrayList<LibraryBookGeneric<String>> booksCheckedOut = nameLib.lookup(patron);
		
		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
		assertTrue(booksCheckedOut.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
		assertEquals(patron, booksCheckedOut.get(0).getHolder());
		assertEquals(patron, booksCheckedOut.get(1).getHolder());
	}
	
	@Test
	public void testNameLibCheckin() 
	{
		String patron = "Jane Doe";
		nameLib.checkout(9780330351690L, patron, 1, 1, 2008);
		nameLib.checkout(9780374292799L, patron, 1, 1, 2008);
		assertTrue(nameLib.checkin(patron));
	}
	
	@Test
	public void testMultipleCheckin()
	{
		String patron = "Jane Doe";
		// check out three books
		nameLib.checkout(9780330351690L, patron, 1, 1, 2008);
		nameLib.checkout(9780374292799L, patron, 1, 1, 2008);
		nameLib.checkout(9780446580342L, patron, 1, 1, 2008);
		// all three should be checked in
		assertTrue(nameLib.checkin(patron));
		// no books are checked out
		assertFalse(nameLib.checkin(patron));
	}

	@Test
	public void testPhoneLibCheckout() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		assertTrue(phoneLib.checkout(9780330351690L, patron, 1, 1, 2008));
		assertTrue(phoneLib.checkout(9780374292799L, patron, 1, 1, 2008));
	}

	@Test
	public void testPhoneLibLookup() 
	{
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		phoneLib.checkout(9780330351690L, patron, 1, 1, 2008);
		phoneLib.checkout(9780374292799L, patron, 1, 1, 2008);
		ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut = phoneLib.lookup(patron);
		
		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
		assertTrue(booksCheckedOut.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
		assertEquals(patron, booksCheckedOut.get(0).getHolder());
		assertEquals(patron, booksCheckedOut.get(1).getHolder());
	}

	@Test
	public void testPhoneLibCheckin() 
	{
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		phoneLib.checkout(9780330351690L, patron, 1, 1, 2008);
		phoneLib.checkout(9780374292799L, patron, 1, 1, 2008);
		assertTrue(phoneLib.checkin(patron));
	}
	
	@Test
	public void testISBNsorting()
	{
		ArrayList<LibraryBookGeneric<String>> SortedIsbn = nameLib.getInventoryList();
		assertTrue(SortedIsbn.get(0).getIsbn() == 9780330351690L);
		assertTrue(SortedIsbn.get(1).getIsbn() == 9780374292799L);
		assertTrue(SortedIsbn.get(2).getIsbn() == 9780446580342L);
	}
	
	@Test
	public void testOrderByDueDate()
	{
		
		String patron = "Jane Doe";
		// check out three books
		nameLib.checkout(9780330351690L, patron, 1, 1, 2008);
		nameLib.checkout(9780374292799L, patron, 1, 5, 2007);
		nameLib.checkout(9780446580342L, patron, 1, 1, 2007);
		
		ArrayList<LibraryBookGeneric<String>> SortedDueDate = nameLib.getOverdueList(1, 1, 2000);
		assertTrue(SortedDueDate.get(0).getIsbn() == 9780446580342L);
		assertTrue(SortedDueDate.get(1).getIsbn() == 9780374292799L);
		assertTrue(SortedDueDate.get(2).getIsbn() == 9780330351690L);
	}
	
	
	@Test
	public void getOrderedByTitle()
	{
		nameLib = new LibraryGeneric<String>();
		nameLib.add(9780374292719L, "Thomas L. Friedman", "Adventure Book");
		nameLib.add(9780374292729L, "Thomas L. Friedman", "Aaddventure");
		nameLib.add(9780374292749L, "Thomas L. Friedman", "Zaxaphone Book");
		nameLib.add(9780374292759L, "Thomas L. Friedman", "Biology Book");
		nameLib.add(9780374292789L, "Thomas L. Friedman", "ZedBook");


		books = new LibraryGeneric<String>();
		books.add(9780374292729L, "Thomas L. Friedman", "Aaddventure");
		books.add(9780374292719L, "Thomas L. Friedman", "Adventure Book");
		books.add(9780374292759L, "Thomas L. Friedman", "Biology Book");
		books.add(9780374292749L, "Thomas L. Friedman", "Zaxaphone Book");
		books.add(9780374292789L, "Thomas L. Friedman", "ZedBook");
		
		assertEquals(books.getOrderedByTitle(), nameLib.getOrderedByTitle());
	}
	
	@Test
	public void getOrderedByTitleError()
	{
		nameLib = new LibraryGeneric<String>();
		nameLib.add(9780374292719L, "Thomas L. Friedman", "Adventure Book");
		nameLib.add(9780374292729L, "Thomas L. Friedman", "Aaddventure");
		nameLib.add(9780374292749L, "Thomas L. Friedman", "Zaxaphone Book");
		nameLib.add(9780374292759L, "Thomas L. Friedman", "Biology Book");
		nameLib.add(9780374292789L, "Thomas L. Friedman", "ZedBook");


		books = new LibraryGeneric<String>();
		books.add(9780374292729L, "Thomas L. Friedman", "Aaddventure");
		books.add(9780374292729L, "Thomas L. Friedman", "Not in other array");
		books.add(9780374292749L, "Thomas L. Friedman", "Zaxaphone Book");
		books.add(9780374292759L, "Thomas L. Friedman", "Biology Book");
		books.add(9780374292789L, "Thomas L. Friedman", "ZedBook");
		
		assertFalse(books.getOrderedByTitle().equals(nameLib.getOrderedByTitle()));
	}
}
