package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class represents a binary max heap and implements Priority Queue
 * 
 * @author Todd Oldahm and Alex Murdock
 * @version 11/18/2022
 */

public class BinaryMaxHeap<E> implements PriorityQueue<E> 
{
	
	private int size =  0;
	private E backingArray[];
	private Comparator<? super E> cmp;
	
	
	/**
	 * 
	 * If this constructor is used to create an empty binary heap, 
	 * it is assumed that the elements are ordered using their natural ordering 
	 * (i.e., E implements Comparable<? super E>)
	 * 
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap()
	{
		
		backingArray = (E[]) new Object[10];
	}
	
	/**
	 * 
	 * If this constructor is used to create an empty binary heap, 
	 * it is assumed that the elements are ordered using the provided Comparator object.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(Comparator<? super E> comp)
	{
		cmp = comp;
		backingArray = (E[]) new Object[10];
	}
	
	/**
	 * 
	 * If this constructor is used, then the binary heap is constructed from the given list.  
	 * Also, it is assumed that the elements are ordered using their natural ordering 
	 * (i.e., E implements Comparable<? super E>).  
	 * RECALL: Using the buildHeap operation, we can construct a binary heap from these N items in O(N) time, 
	 * which is more efficient than adding them to the binary heap one at a time.  
	 * This constructor must use such an operation.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(List<? extends E> initialList)
	{
		backingArray = (E[]) new Object[initialList.size()];
		buildHeap(initialList);
	}
	
	/**
	 * 
	 * If this constructor is used, then the binary heap is constructed from the given list (see RECALL note above).  
	 * Also, it is assumed that the elements are ordered using the provided Comparator object.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(List<? extends E> initialList, Comparator<? super E> comp)
	{
		cmp = comp;
		backingArray = (E[]) new Object[initialList.size()];
		buildHeap(initialList);
	}
	
	/**
	 * Adds the given item to this priority queue.
	 * O(1) in the average case, O(log N) in the worst case
	 * 
	 * @param item
	 */
	@Override
	public void add(E item) 
	{
		
		if(size() == backingArray.length - 1)
			grow();
		
		// Set the index at size to the item
		backingArray[size()] = item;
		
		// Increase size
		size++;
		
		// Percolate the item added up until order is restored
		percolateUp(size() - 1);
		
	}

	/**
	 * Returns, but does not remove, the maximum item this priority queue.
	 * O(1)
	 * 
	 * @return the maximum item
	 * @throws NoSuchElementException if this priority queue is empty
	 */
	@Override
	public E peek() throws NoSuchElementException 
	{
		// if there is nothing 
		if(isEmpty())
			throw new NoSuchElementException();
		
		return backingArray[0];
	}

	/**
	 * Returns and removes the maximum item this priority queue.
	 * O(log N)
	 * 
	 * @return the maximum item
	 * @throws NoSuchElementException if this priority queue is empty
	 */
	@Override
	public E extractMax() throws NoSuchElementException 
	{
		E maxValue;
		
		// if there is nothing 
		if(isEmpty())
			throw new NoSuchElementException();
		
		else
		{
			// Place the max value in a placeholder
			maxValue = backingArray[0];
			
			// Set the root which should be the max value to the last item in the heap
			backingArray[0] = backingArray[size() - 1];
			
			// reduce size
			size--;
			
			// Set index that had an item to null
			backingArray[size()] = null;
			
			// Percolate the item placed in the root down until order is restored
			percolateDown(0);
			
			// Return the max value
			return maxValue;
			
		}
	}

	/**
	 * Returns the number of items in this priority queue.
	 * O(1)
	 */
	@Override
	public int size() 
	{
		return size;
	}

	/**
	 * Returns true if this priority queue is empty, false otherwise.
	 * O(1)
	 */
	@Override
	public boolean isEmpty() 
	{
		if(size == 0)
			return true;
		
		return false;
	}

	/**
	 * Empties this priority queue of items.
	 * O(1)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() 
	{
		size = 0;
		
		backingArray = (E[]) new Object[10];
	}

	/** 
	 * Creates and returns an array of the items in this priority queue,
	 * in the same order they appear in the backing array.
	 * O(N)
	 * 
	 * (NOTE: This method is needed for grading purposes. The root item 
	 * must be stored at index 0 in the returned array, regardless of 
	 * whether it is in stored there in the backing array.) 
	 */
	@Override
	public Object[] toArray() 
	{
		// Create an object array
		Object returnArray[] = new Object[size()];
		
		// Set the items in backing array to return array
		for(int i = 0; i < size(); i++)
		{
			returnArray[i] = backingArray[i];
		}
		
		// return the  object array
		return returnArray;
		
	}
	
	/**
	 * 
	 * Used to create our heap in O(N) time by using percolate down in the constructors
	 * 
	 * @param initialList
	 */
	private void buildHeap(List<? extends E> initialList)
	{
		// going through each item in the givenList
		for(int i = 0; i < initialList.size(); i++)
		{
			// setting the backing array index to the corresponding item in the list
			backingArray[i] = initialList.get(i);
			
			// get the last non leaf node
			int percolateDownIndex = (size() / 2) - 1;
			
			// use the last non leaf node to percolate down to restore order in the complete tree
			if(percolateDownIndex >= 0)
				percolateDown(percolateDownIndex);
		}
	}
	
	/**
	 * 
	 * Given an index go up through the tree until the parent is bigger than the given item
	 * 
	 * @param index
	 */
	private void percolateUp(int index)
	{
		// while the index is not the root and the parent is smaller than the index
		while(index > 0 && innerCompare(backingArray[index], backingArray[parent(index)]) > 0)
		{
			// swap the index and the parent items
			swap(index, parent(index));
			
			// move up to the next level
			index = parent(index);
		}
	}
	
	
	/**
	 * 
	 * Given an index go down through the tree until the children are smaller than the given item
	 * 
	 * @param index
	 */
	private void percolateDown(int index)
	{
		// While we are not on the lowest level
		while(index <= (size() - 1) / 2)
		{
			// if the index has two children check both children
			if(rightChild(index) < size())
			{
				// if the left child is bigger than the right child
				if(innerCompare(backingArray[leftChild(index)], backingArray[rightChild(index)]) > 0)
					// check if the left child is bigger than the parent, if yes swap
					if(innerCompare(backingArray[leftChild(index)], backingArray[index]) > 0)
					{
						swap(leftChild(index), index);
						index = leftChild(index);
					}
				
					
					// leave the loop order restored
					else
						break;
				
				// Right child is bigger than left child
				else
					// If the right child is bigger than the parent, swap items
					if(innerCompare(backingArray[rightChild(index)], backingArray[index]) > 0)
					{
						swap(rightChild(index), index);
						index = rightChild(index);
					}
					
					// leave the loop order restored
					else
						break;
			}
			
			// if the index only has one child check the left child
			else
				// if the leftChild is bigger than the parent, swap the items
				if(innerCompare(backingArray[leftChild(index)], backingArray[index]) > 0)
					swap(leftChild(index), index);
				
				else
					// leave the loop order restored
					break;
				
		}
	}
	
	/**
	 * 
	 * Given two indices, swap the items at those locations in the array
	 * 
	 * @param index
	 * @param parentIndex
	 */
	private void swap(int index, int parentIndex)
	{
		// Set the index item to a temporary holder
		E temp = backingArray[index];
		
		// Set the index item to the parent item
		backingArray[index] = backingArray[parentIndex];
		
		// Set the parent item to the index item in the temporary holder
		backingArray[parentIndex] = temp;
		
		
	}
	
	/**
	 * 
	 * Use to see if we are using comparable or comparator
	 * 
	 * @param firstItem
	 * @param secondItem
	 * @return if the item is bigger or smaller
	 */
	@SuppressWarnings("unchecked")
	private int innerCompare(E firstItem, E secondItem)
	{
		// If we have been given a comparator use it.
		if(cmp != null)
			return cmp.compare(firstItem, secondItem);
		
		// If we have not been given a comparator use comparable.
		return((Comparable<? super E>)firstItem).compareTo(secondItem);
	}
	
	/**
	 * 
	 * When the array gets too big create a new array with the items that is twice as big as the old array
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void grow()
	{
		// Create temporary array with twice as many spaces as the first
		E tempArray[] = (E[]) new Object[backingArray.length * 2]; 
		
		// Set each of the items up to the end of the backing array as the items in the temporary array
		for(int i = 0; i < size(); i++)
		{
			tempArray[i] = backingArray[i];
		}
		
		// set the backing array to the temporary  array
		backingArray = tempArray;
		
	}
	
	/**
	 * 
	 * get the left child of any node
	 * 
	 * @param index
	 * @return left child index
	 */
	private int leftChild(int index)
	{
		return (index * 2 + 1);
	}
	
	/**
	 * 
	 * get the right child of any node
	 * 
	 * @param index
	 * @return right child index
	 */
	private int rightChild(int index)
	{
		return (index * 2 + 2);
	}
	
	/**
	 * 
	 * get the parent of any node
	 * 
	 * @param index
	 * @return parent index
	 */
	private int parent(int index)
	{
		return (index - 1) / 2;
	}

}
