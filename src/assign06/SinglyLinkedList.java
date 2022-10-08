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
		temp = head.next;
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Removes all of the elements from this list.
	 * O(1) for a singly-linked list.
	 */
	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
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
	private class LinkedListIterator implements Iterator<T>
	{

		/**
		 * Iterator for going through items in a collection takes in a collection to iterate through
		 */
		public LinkedListIterator()
		{
			
		}

		/**
		 * Returns true if there are any more items in the collection to iterate through, false otherwise.
		 */
		public boolean hasNext() 
		{
			return false;
		}

		/**
		 * Must throw a NoSuchElementException if there are no more items to iterate through, 
		 * otherwise, returns the next item in the collection
		 */
		public T next() 
		{
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
			
		}
	}
}
