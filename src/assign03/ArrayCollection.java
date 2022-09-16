package assign03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
	private int realItemsInArray = 0; // Keeps track of how many items we have that aren't null
	private int counter = 0;
	private int retainCounter = 0;
	boolean hasNextBeenCalled = false;

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
		// You will need to use something similar to the code in the constructor above to create a new array.
		
		// Creates a new array twice the size of the old one
		T dataGrow[] = (T[]) new Object[this.data.length * 2];
		
		// copy the data from the old array to the new one
		for(int i = 0; i < this.data.length; i++)
			dataGrow[i] = data[i];
		
		// create a new array for data
		data = (T[]) new Object[this.data.length * 2];
		
		// assign the copied array back to data
		data = dataGrow;
	}
	
	/**
	 * Ensures that this collection contains the specified element
	 */
	public boolean add(T arg0) {

		// if the collection already has the element return false
		if (this.contains(arg0) == true) {
			return false;
		} else {
			// if the collection does not have an empty spot the collection needs to grow
			if (this.iterator().hasNext() == false) {
				this.grow();
			}

			// increase the value of realItemsInArray
			realItemsInArray++;

			data[realItemsInArray - 1] = arg0;

			return true;
		}
	}

	
	/**
	 * Adds all of the elements in the specified collection to this collection
	 * Only add items that do not already exist in this ArrayCollection
	 */
	@SuppressWarnings("unchecked")
	public boolean addAll(Collection<? extends T> arg0) {
		// create a variable to check if any new elements were added
		boolean itemAdded = false;

		for (Object u : arg0) {
			if (this.contains(u) == false) {
				if (this.iterator().hasNext() == false) {
					this.grow();
				}

				this.add((T) u);

				itemAdded = true;
			} else if (this.contains(u) == true) {
				// If u is null it will be added to our array because it is a place holder.
				int occurrences = Collections.frequency(this, u);

				if (occurrences <= 2)
					// Checks to see how many times the current item is in our array if it is only
					// in there once it will be added to array
					this.add((T) u);
			}
		}
		
		return itemAdded;
	}

	
	/**
	 * Removes all of the elements from this collection
	 */
	public void clear() {
			// a simple loop to set all items in the collection to null
			for (int i = 0; i < data.length; i++) {
				data[i] = null;
			}
			
			realItemsInArray = 0;
		}

	
	/**
	 * Returns true if this collection contains the specified element.
	 */
	public boolean contains(Object arg0) {
		for (Object c : data) {
			if (arg0 == null) {
				return true;
			} else if (arg0.equals(c)) {
				return true;
			}
		}

		return false;
	}


	
	/**
	 * Returns true if this collection contains all of the elements in the specified collection.
	 */
	public boolean containsAll(Collection<?> arg0) {
		// double for each loop that will check to see if the valuse in our parameter collection those in our main collection
		for (Object x : arg0) {
			for (Object c : data) {
				if (x == null) {
					return true;
				} else if (c.equals(x)) {
					return true;
				}
			}

			return false;
		}

		// only returns true if our collection has all the items
		return true;
	}

	/**
	 * Returns true if this collection contains no elements.
	 */
	public boolean isEmpty() {
		// if the size of our collection is zero return true
		if (this.realItemsInArray == 0)
			return true;

		else
			return false;
	}

	/**
	 * Returns an iterator over the elements in this collection.
	 */
	public Iterator<T> iterator() {
		// Create a new iterator
		ArrayCollectionIterator collectionIterator = new ArrayCollectionIterator();

		return collectionIterator;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present
	 */
	@SuppressWarnings("unchecked")
	public boolean remove(Object arg0) {
		// New variable for the location of the item to remove
		int location = 0;

		// if our collection does not contain the item return false
		if (this.contains(arg0) == false) {
			return false;

		} else {
			// find the location of the item in our collection
			while (this.iterator().hasNext() == true) {
				// when we find the location leave the loop
				if (this.iterator().next() == arg0) {
					break;
				}

				location++;
			}
			
			// tells our code where we should delete the item from
			int whereToDelete = data.length - location - 1;

			// move all the data from the right of the item one to the left
			for (int i = whereToDelete; i < data.length - 1; i++)
				data[i] = data[i + 1];

			// create a new array one smaller than the original
			T removeData[] = (T[]) new Object[(data.length) - 1];
			
			// copy the data from the old array to the new one
			for (int i = 0; i < data.length - 1; i++)
				removeData[i] = data[i];


			// create a new array for data
			data = (T[]) new Object[data.length - 1];

			// assign the the copied array back to data
			data = removeData;

			// decrease size
			size--;

			// Decreases size of real items in the array meaning values that aren't null
			realItemsInArray--;

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
				realItemsInArray--;
			}
		
			// set next item
			nextRemoveItem = arg0.iterator().next();
			
		return itemRemoved;
	}

	
	/**
	 * Retains only the elements in this collection that are contained in the specified collection
	 */
	@SuppressWarnings("unused")
	public boolean retainAll(Collection<?> arg0) {
		// Compare to list one elment at a time. If there elments are diffrent delete it from the data collection. If they are the same skip.
		
		// item removed variable
		boolean itemNotRetained = false;

		// create next item and grab the current parameters item
		Object nextRetainItem = this.iterator().next();
		Object nextParamItem = arg0.iterator().next();
		// while the collection we are checking still has items
		while (this.iterator().hasNext() == true && arg0.iterator().hasNext() == true) {
			if (nextRetainItem == null) {

			} else if (!nextRetainItem.equals(nextParamItem)) {
				// if the input collection does not contain the item in our collection
				// remove that item
				hasNextBeenCalled = true;
				this.iterator().remove();
				
				// an item was removed, so the method returns true
				itemNotRetained = true;
			}
			
			// go to next item 
			retainCounter++;
			nextRetainItem = this.iterator().next();
			nextParamItem = arg0.iterator().next();
		}
		
		// sets the counter back to zero so it does not screw up future remove methods
		retainCounter = 0;
		return itemNotRetained;
	}

	
	/**
	 * Returns the number of elements in this collection.
	 */
	public int size() 
	{
		// This returns the value of size which would be the number of elements in the collection
		return realItemsInArray;
	}

	
	/**
	 * Returns an array containing all of the elements in this collection.
	 */
	@SuppressWarnings("unchecked")
	public Object[] toArray() 
	{
		// Creates a new array the same size as data
		T dataCopy[] = (T[]) new Object[realItemsInArray];
		
		// copy the data from data to the new one
		for(int i = 0; i < realItemsInArray; i++)
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


	/**
	 * Sorting method specific to ArrayCollection - not part of the Collection interface.
     	Must implement a selection sort (see Assignment 2 for code).
     	Must not modify this ArrayCollection.
	 * @param cmp - the comparator that defines item ordering
	 * @return - the sorted list
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<T> toSortedList(Comparator<? super T> cmp)
	{
		ArrayList<T> sortedArrayList = new ArrayList<T>();
		
		// for loop should run through all the items starting at zero
		for(int i = 0; i < realItemsInArray; i++) 
		{
			// j is every item after i and i is the min index
			int j, minIndex;
			
			// loop through all items 
			for(j = i + 1, minIndex = i; j < realItemsInArray; j++)
				
				// check j against i (min index) if j is less than i we want j to be minINdez
				if(cmp.compare(data[j], data[minIndex]) < 0)
					minIndex = j;
			
			// create temporary storage
			T temp = data[i];
			// i data goes into min index spot
			data[i] = data[minIndex];
			// min index spot is what we stored in temp
			data[minIndex] =  temp;
			
		}
		
		for(int k = 0; k < realItemsInArray; k++)
			sortedArrayList.add(data[k]);
		
		return sortedArrayList;
	}


	/**
	 * 
	 * @author Todd Oldham and Alex Murdock
	 * Describe your ArrayCollectionIterator class here.
	 *
	 */
	private class ArrayCollectionIterator implements Iterator<T>
	{
		boolean hasRemovedBeenCalled = false;
		/**
		 * Iterator for going through items in a collection takes in a collection to iterate through
		 */
		public ArrayCollectionIterator()
		{
			// ArrayCollectionIterator
		}

		/**
		 * Returns true if there are any more items in the collection to iterate through, false otherwise.
		 */
		public boolean hasNext() {
			// number of items in collection
			int numOfItems = ArrayCollection.this.data.length;

			// get the value of next
			int hasNext = counter;

			// if next is less than the number of items then there are more items in the
			// collection
			if (hasNext < numOfItems) {
				return true;
			} else {
				counter = 0;
				return false;
			}

		}

		/**
		 * Must throw a NoSuchElementException if there are no more items to iterate through, 
		 * otherwise, returns the next item in the collection
		 */
		public T next() {
			// get number of items in the array
			int numOfItems = ArrayCollection.this.data.length;

			// Checks to see if there is a next item in ArrayCollection
			// This if statment will only work when calling retainAll
			if (retainCounter > 0) {
				
				return data[retainCounter];
			} else if (counter <= numOfItems) {

				counter++;

				return data[counter - 1];

			} else {
				// If there is no next item we will throw a NoSuchElementException
				throw new NoSuchElementException();
			}
		}

		/**
		 * This method removes the last item that was returned by next. 
		 * It can therefore only be called once per call to next. 
		 * If next has not been called since the last call to remove, or if it hasn't been called at all, 
		 * throws an IllegalStateException.
		 */
		public void remove() {
			if (hasNextBeenCalled == false) {
				throw new IllegalStateException();
			} else if (hasRemovedBeenCalled == false && retainCounter > 0) {
				next();
				
				int itemToDelete = retainCounter;
				
				// Tells are program that we can call next() again
				hasNextBeenCalled = false;
				
				data[itemToDelete] = null;
				realItemsInArray--;
				
				retainCounter = retainCounter - 1;
			} else if (hasRemovedBeenCalled == false) {
			// Grabs Value and converts it to int then subtracts one from returned value of
			// next() which will give us the correct value to delete
			next();
			
			int itemToDelete = counter - 1;
			
			// Tells are program that we can call next() again
			hasNextBeenCalled = false;
			data[itemToDelete] = null;
			realItemsInArray--;
			
			// return our index to zero since we have found the place in the collection we want do remove
			counter = 0;
			} else {
				throw new IllegalStateException();
			}

		}

	}

}
