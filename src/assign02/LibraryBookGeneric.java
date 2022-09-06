package assign02;

import java.util.GregorianCalendar;

public class LibraryBookGeneric<Type> extends Book {


	private Type holder;
	private GregorianCalendar duedate;

	public LibraryBookGeneric(long isbn, String author, String title){
		super(isbn, author, title);
	}
	
	
	/*
	 * Holder and due date should be set to null if checked in
	 */
	public Object bookCheckIn(long isbn, Type holder) {
		this.holder.equals(null) ;
		this.duedate.equals(null);
		return this;
	}
	
	
	/*
	 * Holder and due date should be set if checked out
	 */
	public Object bookCheckOut(long isbn, Type newHolder, int month, int day, int year) {
		this.holder = newHolder;
		this.duedate = new GregorianCalendar(year, month, day);
		return this;
	}
	

	/*
	 * Returns the current holder for the book
	 */
	public Type getHolder() {
		return this.holder;
	}
	
	
	/*
	 * Returns the due date for the book
	 */
	public GregorianCalendar getDueDate() {
		return this.duedate;
	}
}
