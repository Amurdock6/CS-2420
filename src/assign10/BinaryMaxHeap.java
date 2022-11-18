package assign10;

import java.util.NoSuchElementException;

public class BinaryMaxHeap<E> implements PriorityQueue<E> 
{
	
	private int size =  0;
	
	
	/**
	 * 
	 * If this constructor is used to create an empty binary heap, 
	 * it is assumed that the elements are ordered using their natural ordering 
	 * (i.e., E implements Comparable<? super E>)
	 * 
	 */
	public BinaryMaxHeap()
	{
		
	}
	
	/**
	 * 
	 * If this constructor is used to create an empty binary heap, 
	 * it is assumed that the elements are ordered using the provided Comparator object.
	 * 
	 */
	public BinaryMaxHeap(Comparator<? super E>)
	{
		
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
	public BinaryMaxHeap(List<? extends E>)
	{
		
	}
	
	/**
	 * 
	 * If this constructor is used, then the binary heap is constructed from the given list (see RECALL note above).  
	 * Also, it is assumed that the elements are ordered using the provided Comparator object.
	 * 
	 */
	public BinaryMaxHeap(List<? extends E>, Comparator<? super E>)
	{
		
	}
	
	/**
	 * Adds the given item to this priority queue.
	 * O(1) in the average case, O(log N) in the worst case
	 * 
	 * @param item
	 */
	@Override
	public void add(Object item) 
	{
		
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
		return null;
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
		return null;
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
	@Override
	public void clear() 
	{

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
		return null;
	}
	
	
	private void buildHeap()
	{
		
	}
	
	private void percolateUp()
	{
		
	}
	
	private void percolateDown()
	{
		
	}
	
	private void innerCompare()
	{
		
	}

}
