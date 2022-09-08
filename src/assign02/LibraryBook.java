package assign02;

import java.util.GregorianCalendar;

/**
 * This class represents a library book, which extends book, in which the ISBN, author, and title cannot
 * change once the book is created.  Note that ISBNs are unique.
 * A holder and due date are also added to the book
 * 
 * @author Todd Oldham and Alex Murdock
 * @version September 6, 2022
 */
public class LibraryBook extends Book 
{
	
	// create holder and due date for library books
	private String holder;
	private GregorianCalendar duedate;
	
	// constructor for library book
	public LibraryBook(long isbn, String author, String title)
	{
		super(isbn, author, title);
	}
	
	
	/*
	 * Holder and due date should be set to null if checked in
	 */
	public Object bookCheckIn(long isbn, String holder) 
	{
		// set holder and due date to null
		this.holder = null ;
		this.duedate = null;
		return this;
	}
	
	
	/*
	 * Holder and due date should be set if checked out
	 */
	public Object bookCheckOut(long isbn, String newHolder, int month, int day, int year) 
	{
		// set holder and due date based on given information
		this.holder = newHolder;
		this.duedate = new GregorianCalendar(year, month, day);
		return this;
	}
	

	/*
	 * Returns the current holder for the book
	 */
	public String getHolder() 
	{
		return this.holder;
	}
	
	
	/*
	 * Returns the due date for the book
	 */
	public GregorianCalendar getDueDate() 
	{
		return this.duedate;
	}
}
