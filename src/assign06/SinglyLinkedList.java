package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

import assign03.ArrayCollection;

/**
 * This class simulates a linked list without using the java linked list methods
 * 
 * @author Todd Oldham and Alex Murdock
 * @version October 7, 2022
 */
public class SinglyLinkedList<T> implements List 
{
	
	/**
	 * 
	 * Nested Node class is how we are going to add, get, remove, etc.. from the list
	 * 
	 * @author Todd Oldham and Alex Murdock
	 *
	 * @param <T>
	 */
	private class Node<T>
	{
		// Each Node has a value associated
		T element;
		// Each nod has a next node - unless it is the node at the end of the list
		Node next;
		
		/**
		 * 
		 * Constructor takes in our value
		 * Creates Node
		 * 
		 * @param data
		 */
		Node(T data)
		{
			element = data;
			next = null;
		}
	}
	
	// head is the first of the list, (also the top of the stack);
	private Node head = null;
	// size will be useful for other methods
	private int size = 0;
	
	/**
	 * 
	 * This method given an index will return the node we are searching for
	 * This will be used in many of the methods we need to implement
	 * 
	 * @param index
	 * @return
	 */
	private Node getNodeAtIndex(int index)
	{
		// set the current head to a temp value
		Node temp = head;
		
		// loop till we get to the index we want setting temp equal to the next node
		for(int i = 0; i < index; i++)
		{
			temp = temp.next;
		}
		
		// return the node we want
		return temp;
	}
	
	
	/**
	 * 
	 * empty constructor
	 * 
	 */
	public SinglyLinkedList()
	{
		
	}

	/**
	 * Inserts an element at the beginning of the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @param element - the element to add
	 */
	@Override
	public void insertFirst(Object element) 
	{
		// set current head to temp
		Node temp = head;
		
		// set the head as the new element
		head = new Node(element);
		
		// set temp to node after head
		head.next = temp;
		
		// we have one more item in the list
		size = size + 1;
	}

	/**
	 * Inserts an element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || 
	index > size())
	 */
	@Override
	public void insert(int index, Object element) throws IndexOutOfBoundsException 
	{
		if(index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		
		else if( index == 0)
			insertFirst(element);
		
		else
		{
			// Get the node before where we want to insert
			Node beforeInsert = getNodeAtIndex(index - 1);
			
			// Set the after node
			Node afterNode = beforeInsert.next;
			
			// Create a new node and put the element into it
			Node insertNode = new Node(element);
				
			// Set the new node to the index after the before node
			beforeInsert.next = insertNode;
			
			// increase the size of the list
			size = size + 1;
			
			insertNode.next = afterNode;
			
		}
	}

	/**
	 * Gets the first element in the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public Object getFirst() throws NoSuchElementException 
	{
		// if there are no elements in the list throw error
		if(size() == 0)
			throw new NoSuchElementException();
		
		// return the value of head
		else
			return head.element;
	}

	/**
	 * Gets the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 */
	@Override
	public Object get(int index) throws IndexOutOfBoundsException 
	{
		// if the index is not within the list bounds throw error
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		// return the value of the node we are interested in
		else
			return getNodeAtIndex(index).element;
	}

	/**
	 * Deletes and returns the first element from the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public Object deleteFirst() throws NoSuchElementException 
	{
		if(size() == 0)
			throw new NoSuchElementException();
		else
		{
			// Get the value from the node to be deleted
			Object deletedValue = head.element;
			
			// Set the reference of the node after the node before the node to be deleted to the node after the deleted node
			head = head.next;
			
			// Reduce size to show that one of the list items was removed
			size = size - 1;
			
			return deletedValue;
		}
	}

	/**
	 * Deletes and returns the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 */
	@Override
	public Object delete(int index) throws IndexOutOfBoundsException 
	{
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		// if the index is zero use our delete first so we don't get an error trying to get the index before zero
		else if(index == 0)
			return deleteFirst();
		
		else
		{
			// Get the node before the node to be deleted
			Node beforeDelete = getNodeAtIndex(index - 1);
			
			// Get the value from the node to be deleted
			Object deletedValue = beforeDelete.next.element;
			
			// Set the reference of the node after the node before the node to be deleted to the node after the deleted node
			beforeDelete.next = beforeDelete.next.next;
			
			// Reduce size to show that one of the list items was removed
			size = size - 1;
			
			return deletedValue;
		}
	}

	/**
	 * Determines the index of the first occurrence of the specified element in the list, 
	 * or -1 if this list does not contain the element.
	 * O(N) for a singly-linked list.
	 * 
	 * @param element - the element to search for
	 * @return the index of the first occurrence; -1 if the element is not found
	 */
	@Override
	public int indexOf(Object element) 
	{
		// run through the list looking for the element
		for(int i = 0; i < size(); i++)
			// if the element of the node we are checking is the element return the value of the index of that element
			if(getNodeAtIndex(i).element == element)
				return i;
		
		// if the element isn't found return -1
		return -1;

	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return the number of elements in this list
	 */
	@Override
	public int size() 
	{
		return size;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return true if this collection contains no elements; false, otherwise
	 */
	@Override
	public boolean isEmpty() 
	{
		// if the list is empty return true
		if(size() == 0)
			return true;
		
		// if it is not empty return false
		else
			return false;
	}

	/**
	 * Removes all of the elements from this list.
	 * O(1) for a singly-linked list.
	 */
	@Override
	public void clear()
	{
		// set the head element and next to null
		head = null;
		
		// set the size equal to zero
		size = 0;
	}

	/**
	 * Generates an array containing all of the elements in this list in proper sequence 
	 * (from first element to last element).
	 * O(N) for a singly-linked list.
	 * 
	 * @return an array containing all of the elements in this list, in order
	 * 
	 */
	@Override
	public Object[] toArray() 
	{
		// create a new array with the size of the the list
		Object[] convertedArray = new Object[size()];
		
		// go through the list adding each element to the array.
		for (int i = 0; i < size(); i++)
			convertedArray[i] = getNodeAtIndex(i).element;
		
		return convertedArray;
	}

	/**
	 * @return an iterator over the elements in this list in proper sequence 
	 *(from first element to last element)
	 *
	 */
	@Override
	public Iterator iterator() 
	{
		return new LinkedListIterator();
	}
	
	/**
	 * 
	 * This iterator iterates through our linked list and has hasNext, next, and remove methods
	 * 
	 * @author Todd Oldham and Alex Murdock
	 *
	 */
	private class LinkedListIterator implements Iterator<Object>
	{
		
		private int index = 0;
		private Node currentNode = head;
		private Node previousNode = null;
		private Node beforePrevious = null;
		private int nextHasBeenCalled = 0;
		
		/**
		 * Iterator for going through items in a collection takes in a collection to iterate through
		 */
		public LinkedListIterator()
		{
			
		}

		/**
		 * Returns true if there are any more items in the collection to iterate through, false otherwise.
		 */
		@Override
		public boolean hasNext() 
		{
			return index < size();
		}

		
		/**
		 * 
		 * Must throw a NoSuchElementException if there are no more items to iterate through, 
		 * otherwise, returns the next item in the collection
		 * 
		 * @throws NoSuchElementException
		 * @return next element
		 * 
		 */
		@Override
		public Object next() 
		{
			if(!hasNext())
				throw new NoSuchElementException();
			
			else
			{
				//next has been called set to 1
				nextHasBeenCalled = 1;
				
				// increase the index
				index++;
				
				if(index == 2)
					beforePrevious = head;
				
				if(index >= 3)
					beforePrevious = beforePrevious.next;
				
				// Set the previous node to what the current node was
				previousNode = currentNode;
				
				// Set the current node to the next node
				currentNode = currentNode.next;
				
				
				// return the element from what the current node was
				return previousNode.element;
			}
				
		}

		/**
		 * This method removes the last item that was returned by next. 
		 * It can therefore only be called once per call to next. 
		 * If next has not been called since the last call to remove, or if it hasn't been called at all, 
		 * throws an IllegalStateException.
		 * 
		 * @throws IllegalStateException
		 * 
		 */
		@Override
		public void remove() 
		{
			if(nextHasBeenCalled == 1)
			{
				// reset if next has been called
				nextHasBeenCalled = 0;
				
				// if the item to remove is the first item
				if(index == 1)
				{
					// set the head to the next item
					head = head.next;
					
					// reduce the index
					index--;
					
					// reduce the size
					size--;
				}
				
				else
				{
					// set the reference from before remove to the item after remove
					beforePrevious.next = beforePrevious.next.next;
					
					// reduce index
					index --;
					
					// reduce size
					size--;
				}
				
			}
			
			else
				throw new IllegalStateException();
		}
	}
}
