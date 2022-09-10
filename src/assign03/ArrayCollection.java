package assign03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Daniel Kopta and Todd Oldahm and Alex Murdock
 * Implements the Collection interface using an array as storage.
 * The array must grow as needed.
 * An ArrayCollection can not contain duplicates.
 * All methods should be implemented as defined by the Java API, unless otherwise specified.
 * 
 * It is your job to fill in the missing implementations and to comment this class. 
 * Every method should have comments (Javadoc-style prefered). 
 * The comments should at least indicate what the method does, 
 * what the arguments mean, and what the returned value is. 
 * It should specify any special cases that the method
 * handles. Any code that is not self-explanatory should be commented.
 *
 * @param <T> - generic type placeholder
 */
public class ArrayCollection<T> implements Collection<T> 
{

	private T data[]; // Storage for the items in the collection
	private int size; // Keep track of how many items this collection holds

	// There is no clean way to convert between T and Object, so we suppress the warning.
	@SuppressWarnings("unchecked")  
	public ArrayCollection()
	{
		size = 0;
		// We can't instantiate an array of unknown type T, so we must create an Object array, and typecast
		data = (T[]) new Object[10]; // Start with an initial capacity of 10
	}

	/**
	 * This is a helper method specific to ArrayCollection
	 * Doubles the size of the data storage array, retaining its current contents.
	 */
	@SuppressWarnings("unchecked")
	private void grow()
	{
		// TODO fill in
		// You will need to use something similar to the code in the constructor above to create a new array.
		
		// Creates a new array twice the size of the old one
		T dataGrow[] = (T[]) new Object[this.size() * 2];
		
		// Add the data from the old array to the new one
		
	}

	/**
	 * Ensures that this collection contains the specified element
	 */
	public boolean add(T arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Adds all of the elements in the specified collection to this collection
	 */
	public boolean addAll(Collection<? extends T> arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Removes all of the elements from this collection
	 */
	public void clear() 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Returns true if this collection contains the specified element.
	 */
	public boolean contains(Object arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns true if this collection contains all of the elements in the specified collection.
	 */
	public boolean containsAll(Collection<?> arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns true if this collection contains no elements.
	 */
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns an iterator over the elements in this collection.
	 */
	public Iterator<T> iterator() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present
	 */
	public boolean remove(Object arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Removes all of this collection's elements that are also contained in the specified collection
	 */
	public boolean removeAll(Collection<?> arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Retains only the elements in this collection that are contained in the specified collection
	 */
	public boolean retainAll(Collection<?> arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the number of elements in this collection.
	 */
	public int size() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns an array containing all of the elements in this collection.
	 */
	public Object[] toArray() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	 * Don't implement this method (unless you want to).
	 * It must be here to complete the Collection interface.
	 * We will not test this method.
	 */
	public <T> T[] toArray(T[] arg0) {
		return null;
	}



	/*
     
	*/
	/**
	 * Sorting method specific to ArrayCollection - not part of the Collection interface.
     	Must implement a selection sort (see Assignment 2 for code).
     	Must not modify this ArrayCollection.
	 * @param cmp - the comparator that defines item ordering
	 * @return - the sorted list
	 */
	public ArrayList<T> toSortedList(Comparator<? super T> cmp)
	{
		// TODO fill in this method
		return null;
	}


	/**
	 * 
	 * @author Todd Oldham and Alex Murdock
	 * Describe your ArrayCollectionIterator class here.
	 *
	 */
	private class ArrayCollectionIterator implements Iterator<T>
	{
		/**
		 * Iterator for going through items in a collection
		 */
		public ArrayCollectionIterator()
		{
			// TODO Auto-generated method stub
		}

		/**
		 * Returns true if there are any more items in the collection to iterate through, false otherwise.
		 */
		public boolean hasNext() 
		{
			// TODO Auto-generated method stub
			return false;
		}

		/**
		 * Must throw a NoSuchElementException if there are no more items to iterate through, 
		 * otherwise, returns the next item in the collection
		 */
		public T next() 
		{
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * This method removes the last item that was returned by next. 
		 * It can therefore only be called once per call to next. 
		 * If next has not been called since the last call to remove, or if it hasn't been called at all, 
		 * throws an IllegalStateException.
		 */
		public void remove() 
		{
			// TODO Auto-generated method stub
		}

	}

}
