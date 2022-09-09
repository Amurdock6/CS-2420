package assign02;

import java.util.GregorianCalendar;

/**
 * This class represents a generic library book, which extends book, in which the ISBN, author, and title cannot
 * change once the book is created.  Note that ISBNs are unique.
 * A holder and due date are also added to the book
 * 
 * @author Todd Oldham and Alex Murdock
 * @version September 6, 2022
 */
public class LibraryBookGeneric<Type> extends Book 
{

	// add a book holder and a due date
	private Type holder;
	private GregorianCalendar duedate;

	// constructor for library book
	public LibraryBookGeneric(long isbn, String author, String title)
	{
		super(isbn, author, title);
	}
	
	
	/*
	 * Holder and due date should be set to null if checked in
	 */
	public Object bookCheckIn(long isbn, Type holder)
	{
		// set holder and due date to null
		this.holder = null;
		this.duedate = null;
		return this;
	}
	
	
	/*
	 * Holder and due date should be set if checked out
	 */
	public Object bookCheckOut(long isbn, Type newHolder, int month, int day, int year)
	{
		// set holder and due date equal to the input information
		this.holder = newHolder;
		this.duedate = new GregorianCalendar(year, month, day);
		return this;
	}
	

	/*
	 * Returns the current holder for the book
	 */
	public Type getHolder()
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
