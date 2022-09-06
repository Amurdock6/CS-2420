package assign02;


/**
 * This class represents a book, in which the ISBN, author, and title cannot
 * change once the book is created.  Note that ISBNs are unique.
 * 
 * @author Erin Parker and Todd Oldham and Alex Murdock
 * @version September 6, 2022
 */
public class Book 
{

	private long isbn;

	private String author;

	private String title;

	/**
	 * Creates a book from the given ISBN, author, and title.
	 * 
	 * @param isbn
	 * @param author
	 * @param title
	 */
	public Book(long isbn, String author, String title) 
	{
		this.isbn = isbn;
		this.author = author;
		this.title = title;
	}

	/**
	 * Accessor method for the author field.
	 * 
	 * @return the author
	 */
	public String getAuthor() 
	{
		return this.author;
	}

	/**
	 * Accessor method for the isbn field.
	 * 
	 * @return the ISBN
	 */
	public long getIsbn() 
	{
		return this.isbn;
	}

	/**
	 * Accessor method for the title field.
	 * 
	 * @return the title
	 */
	public String getTitle() 
	{
		return this.title;
	}

	/**
	 * Two books are considered equal if they have the same ISBN, author, and
	 * title.
	 * 
	 * @param other - the object begin compared with this book
	 * @return true if other object is a Book type and is equal to this book, false otherwise
	 */
	public boolean equals(Object other)
	{
		// FILL IN -- do not return false unless appropriate
		// If other isn't a book return false
		if (!(other instanceof Book)) 
		{
			return false;
		} 
		
		// if other is a book check to see if it is the same author title and isbn
		else if (other instanceof Book) 
		{
			// set other as a book
			Book b = (Book) other;
			
			// if book is equal return true
			if (b.isbn == this.isbn && b.author == this.author && b.title == this.title) 
			{
				return true;
			}
			
			else 
			{
				// book is not equal
				return false;
			}
		}
		
		else 
		{
			return false;
		}

	}

	/**
	 * Returns a textual representation of this book.
	 */
	public String toString() 
	{
		return isbn + ", " + author + ", \"" + title + "\"";
	}
}