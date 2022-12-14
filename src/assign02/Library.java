package assign02;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a library, which is a collection of library books.
 * 
 * @author Erin Parker and Todd Oldham and Alex Murdock
 * @version September 6, 2022
 */
public class Library 
{

	private ArrayList<LibraryBook> library;
	private ArrayList<LibraryBook> holderBooks;

	/**
	 * Creates an empty library.
	 */
	public Library() 
	{
		library = new ArrayList<LibraryBook>();
	}

	/**
	 * Adds to the library the book, specified by the given ISBN, author, and
	 * title. Assumes there is no possibility of duplicate library books.
	 * 
	 * @param isbn - ISBN of the book to be added
	 * @param author - author of the book to be added
	 * @param title - title of the book to be added
	 */
	public void add(long isbn, String author, String title) 
	{
		library.add(new LibraryBook(isbn, author, title));
	}

	/**
	 * Add the list of library books to the library. Assumes there is no
	 * possibility of duplicate library books.
	 * 
	 * @param list - list of library books to be added
	 */
	public void addAll(ArrayList<LibraryBook> list) 
	{
		library.addAll(list);
	}

	/**
	 * Adds the the library the books specified by the input file. Assumes the
	 * input files specifies one book per line with ISBN, author, and title
	 * separated by tabs.
	 * 
	 * If file does not exist or format is violated, prints an error message and
	 * does not change the library.
	 * 
	 * @param filename
	 */
	public void addAll(String filename) 
	{
		ArrayList<LibraryBook> toBeAdded = new ArrayList<LibraryBook>();

		try 
		{
			Scanner fileIn = new Scanner(new File(filename));
			int lineNum = 1;

			while(fileIn.hasNextLine()) 
			{
				String line = fileIn.nextLine();

				Scanner lineIn = new Scanner(line);
				lineIn.useDelimiter("\\t");

				if(!lineIn.hasNextLong()) 
				{
					lineIn.close();
					throw new ParseException("ISBN", lineNum);
				}
				long isbn = lineIn.nextLong();

				if(!lineIn.hasNext()) 
				{
					lineIn.close();
					throw new ParseException("Author", lineNum);
				}
				String author = lineIn.next();

				if(!lineIn.hasNext()) 
				{
					lineIn.close();
					throw new ParseException("Title", lineNum);
				}
				String title = lineIn.next();

				toBeAdded.add(new LibraryBook(isbn, author, title));

				lineNum++;
				lineIn.close();
			}
			fileIn.close();
		}
		catch(FileNotFoundException e) 
		{
			System.err.println(e.getMessage() + " Nothing added to the library.");
			return;
		}
		catch(ParseException e) {
			System.err.println(e.getLocalizedMessage() + " formatted incorrectly at line " + e.getErrorOffset()
					+ ". Nothing added to the library.");
			return;
		}

		library.addAll(toBeAdded);
	}

	/**
	 * Returns the holder of the library book with the specified ISBN.
	 * 
	 * If no book with the specified ISBN is in the library, returns null.
	 * 
	 * @param isbn - ISBN of the book to be looked up
	 */
	public String lookup(long isbn) 
	{
		// FILL IN -- do not return null unless appropriate
		// go through all the books in the library to see if isbn exists
		for (int i = 0; i < library.size(); i++) 
		{
			// if isbn exists return holder or null if no holder
			if (isbn == library.get(i).getIsbn()) 
			{
				return library.get(i).getHolder();
			}
		}
		return null;
	}

	/**
	 * Returns the list of library books checked out to the specified holder.
	 * 
	 * If the specified holder has no books checked out, returns an empty list.
	 * 
	 * @param holder - holder whose checked out books are returned
	 */
	public ArrayList<LibraryBook> lookup(String holder) 
	{
		// FILL IN -- do not return null
		// create a new array of library books
		holderBooks = new ArrayList<LibraryBook>();
		
		// go through all the books in the library
		for (int i = 0; i < library.size(); i++) 
		{
			// if the holder matches the holder for the book add that book to the array
			if (holder == library.get(i).getHolder()) 
			{
				holderBooks.add(library.get(i));
			}
		}
		
		// return list of books checked out by the holder
		return holderBooks;
	}

	/**
	 * Sets the holder and due date of the library book with the specified ISBN.
	 * 
	 * If no book with the specified ISBN is in the library, returns false.
	 * 
	 * If the book with the specified ISBN is already checked out, returns
	 * false.
	 * 
	 * Otherwise, returns true.
	 * 
	 * @param isbn - ISBN of the library book to be checked out
	 * @param holder - new holder of the library book
	 * @param month - month of the new due date of the library book
	 * @param day - day of the new due date of the library book
	 * @param year - year of the new due date of the library book
	 * 
	 */
	public boolean checkout(long isbn, String holder, int month, int day, int year) 
	{
		// FILL IN -- do not return false unless appropriate
		// Checks to see if the book is already checked out
		String isBookCheckedOut = lookup(isbn);

		// Checks to see if ISBN exist and if it does it will check out the book
		for (int i = 0; i < library.size(); i++) 
		{
			// returns false if the book is already checked out
			if (isbn == library.get(i).getIsbn())
			{
				if (isBookCheckedOut != null)
					return false;

				else
					// checks out the book
					library.get(i).bookCheckOut(isbn, holder, month, day, year);
				
				return true;
			}

		}
		
		return false;
	}

	/**
	 * Unsets the holder and due date of the library book.
	 * 
	 * If no book with the specified ISBN is in the library, returns false.
	 * 
	 * If the book with the specified ISBN is already checked in, returns false.
	 * 
	 * Otherwise, returns true.
	 * 
	 * @param isbn - ISBN of the library book to be checked in
	 */
	public boolean checkin(long isbn)
	{
		// FILL IN -- do not return false unless appropriate
		// Checks to see if the book is already checked in
		String isBookCheckedIn = lookup(isbn);

		// Checks to see if ISBN exist and if it does it will check in the book
		for (int i = 0; i < library.size(); i++)
		{
			// if the book is already checked in returns false
			if (isbn == library.get(i).getIsbn())
			{
				if (isBookCheckedIn == null)
					return false;

				else
					// checks in book
					library.get(i).bookCheckIn(isbn, isBookCheckedIn);
				
				return true;
			}

		}
		
		return false;
	}

	/**
	 * Unsets the holder and due date for all library books checked out by the
	 * specified holder.
	 * 
	 * If no books with the specified holder are in the library, returns false;
	 * 
	 * Otherwise, returns true.
	 * 
	 * @param holder - holder of the library books to be checked in
	 */
	public boolean checkin(String holder) 
	{
		// FILL IN -- do not return false unless appropriate
		// Go through all the books in the library
		for (int i = 0; i < library.size(); i++) 
		{
			// Checks if the holder is in the library
			if (holder == library.get(i).getHolder())
			{
				// Goes through all the books in the library again and checks in all the books with that holder
				for (int j = 0; j < library.size(); j++)
				{
					if(holder == library.get(j).getHolder())
						library.get(j).bookCheckIn(library.get(j).getIsbn(), holder);
				}
				
				return true;
			}
		}
		
		return false;
	}
}
