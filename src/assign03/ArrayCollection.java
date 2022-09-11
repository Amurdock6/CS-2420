package assign03;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		// copy the data from the old array to the new one
		for(int i = 0; i < this.size(); i++)
			dataGrow[i] = data[i];
		
		// create a new array for data
		data = (T[]) new Object[this.size() * 2];
		
		// assign the the copied array back to data
		data = dataGrow;
	}

	/**
	 * Ensures that this collection contains the specified element
	 */
	public boolean add(T arg0) 
	{
		
		// if the collection already has the element return false
		if (this.contains(arg0))
			return false;
		
		else
		{
			// if the collection does not have an empty spot the collection needs to grow
			if(!this.iterator().hasNext())
				this.grow();
			
			// add the new element to the collection
			data[size()] = arg0;
			
			// increase the value of size
			size++;
			
			return true;
		}
	}
	
	/**
	 * Adds all of the elements in the specified collection to this collection
	 * Only add items that do not already exist in this ArrayCollection
	 */
	public boolean addAll(Collection<? extends T> arg0) 
	{
		// create a variable to check if any new elements were added
		boolean itemAdded = false;
		
		// create next item variable
		T nextItem = arg0.iterator().next();
		
		// while the collection to be added has more items
		while(arg0.iterator().hasNext())
			
			// check if our collection has that item if it doesn't have that item 
			//add it and change our variable to true
			if(!this.contains(nextItem))
			{
				this.add(nextItem);
				itemAdded = true;
			}
		
			// set next item
			nextItem = arg0.iterator().next();
				
		return itemAdded;
	}

	/**
	 * Removes all of the elements from this collection
	 */
	public void clear() 
	{
		// while there are still items in the collection
		while(this.iterator().hasNext())
		{
			// go to the next item
			this.iterator().next();
			// remove that item
			this.iterator().remove();
		}
	}

	/**
	 * Returns true if this collection contains the specified element.
	 */
	public boolean contains(Object arg0) 
	{
		// while there are still items in the collection
		while(this.iterator().hasNext())
		{
			
			// if the next item equals the input item return true
			if(this.iterator().next().equals(arg0))
				return true;
		}
		return false;
	}

	/**
	 * Returns true if this collection contains all of the elements in the specified collection.
	 */
	public boolean containsAll(Collection<?> arg0) 
	{
		// while the collection we are checking has more items
		while(arg0.iterator().hasNext())
		{
			// if our collection does not have that item return false
			if(!this.contains(arg0.iterator().next()))
					return false;
		}
		
		// only returns true if our collection has all the items
		return true;
	}

	/**
	 * Returns true if this collection contains no elements.
	 */
	public boolean isEmpty() 
	{
		// if the size of our collection is zero return true
		if(this.size() == 0)
			return true;
		
		else
			return false;
	}

	/**
	 * Returns an iterator over the elements in this collection.
	 */
	public Iterator<T> iterator() 
	{
		// Create a new iterator
		ArrayCollectionIterator collectionIterator = new ArrayCollectionIterator();
		
		return collectionIterator;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present
	 */
	@SuppressWarnings("unchecked")
	public boolean remove(Object arg0) 
	{
		// New variable for the location of the item to remove
		int location = 0;
		
		// if our collection does not contain the item return false
		if(!this.contains(arg0))
			return false;
		
		else
		{
			// find the location of the item in our collection
			while(this.iterator().hasNext())
			{
				// when we find the location leave the loop
				if(this.iterator().next().equals(arg0))
					break;
				
				location ++;
			}
			
			// move all the data from the right of the item one to the left
			for(int i = location; i < this.size() - 1; i++)
				data[i] = data[i + 1];
			
			// create a new array one smaller than the original
			T removeData[] = (T[]) new Object[(this.size()) - 1];
			
			// copy the data from the old array to the new one
			for(int i = 0; i < this.size() - 1; i++)
				removeData[i] = data[i];
			
			// create a new array for data
			data = (T[]) new Object[ (this.size()) - 1];
			
			// assign the the copied array back to data
			data = removeData;
			
			// decrease size
			size --;
			
			return true;
		}
	}

	/**
	 * Removes all of this collection's elements that are also contained in the specified collection
	 */
	public boolean removeAll(Collection<?> arg0) 
	{
		// create a variable to check if any new elements were removed
		boolean itemRemoved = false;
				
		// create next item remove variable
		Object nextRemoveItem = arg0.iterator().next();
		
		// while the collection to be removed has more items
		while(arg0.iterator().hasNext())
			
			// check if our collection has that item if it does have that item 
			//remove it and change our variable to true
			if(this.contains(nextRemoveItem))
			{
				this.remove(nextRemoveItem);
				itemRemoved = true;
			}
		
			// set next item
			nextRemoveItem = arg0.iterator().next();
			
		return itemRemoved;
	}

	/**
	 * Retains only the elements in this collection that are contained in the specified collection
	 */
	public boolean retainAll(Collection<?> arg0) 
	{
		// item removed variable
		boolean itemNotRetained = false;
		
		// create next item
		Object nextRetainItem = this.iterator().next();
		
		// while the collection we are checking still has items
		while(this.iterator().hasNext())
		{
			// if the input collection contains the item in our collection
			if(arg0.contains(nextRetainItem))
			{
				// go to the next item
				nextRetainItem = arg0.iterator().next();
			}
			
			else
			{
				// if the input collection does not contain the item in our collection
				// remove that item
				this.iterator().remove();
				
				// an item was removed, so the method returns true
				itemNotRetained = true;
				
				// go to the next item
				nextRetainItem = arg0.iterator().next();
			}
				
		}
		
		return itemNotRetained;
	}

	/**
	 * Returns the number of elements in this collection.
	 */
	public int size() 
	{
		// This returns the value of size which would be the number of elements in the collection
		return size;
	}

	/**
	 * Returns an array containing all of the elements in this collection.
	 */
	@SuppressWarnings("unchecked")
	public Object[] toArray() 
	{
		// Creates a new array the same size as data
		T dataCopy[] = (T[]) new Object[this.size()];
		
		// copy the data from data to the new one
		for(int i = 0; i < this.size(); i++)
			dataCopy[i] = data[i];
		
		return dataCopy;
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
	@SuppressWarnings("unchecked")
	public ArrayList<T> toSortedList(Comparator<? super T> cmp)
	{
		for(int i = 0; i < this.size() - 1; i++) 
		{
			int j, minIndex;
			for(j = i + 1, minIndex = i; j < this.size(); j++)
				if(cmp.compare( (T)this.toArray()[j], (T)this.toArray()[minIndex]) < 0)
					minIndex = j;
			T[] temp = (T[]) this.toArray()[i];
			this.toArray()[i] = (T[])this.toArray()[minIndex];
			this.toArray()[minIndex] = temp;
		}
		
		return (ArrayList<T>) Arrays.asList(this.toArray());
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
