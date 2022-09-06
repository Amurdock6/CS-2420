package assign02;

import java.util.GregorianCalendar;

public class LibraryBook extends Book {
	
	private String holder;
	private GregorianCalendar duedate;

	public LibraryBook(long isbn, String author, String title){
		super(isbn, author, title);
	}
	
	
	/*
	 * Holder and due date should be set to null if checked in
	 */
	public Object bookCheckIn(long isbn, String holder) {
		this.holder.equals(null) ;
		this.duedate.equals(null);
		return this;
	}
	
	
	/*
	 * Holder and due date should be set if checked out
	 */
	public Object bookCheckOut(long isbn, String newHolder, int month, int day, int year) {
		this.holder = newHolder;
		this.duedate = new GregorianCalendar(year, month, day);
		return this;
	}
	

	/*
	 * Returns the current holder for the book
	 */
	public String getHolder() {
		return this.holder;
	}
	
	
	/*
	 * Returns the due date for the book
	 */
	public GregorianCalendar getDueDate() {
		return this.duedate;
	}
}
