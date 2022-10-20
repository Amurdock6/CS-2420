package assign06;

import java.util.NoSuchElementException;

/**
 * This class simulates a stack without using the java stack methods
 * 
 * @author Todd Oldham and Alex Murdock
 * @version October 7, 2022
 */

public class LinkedListStack<E> implements Stack<E>
{
	
	// instance of singly linked list
	private SinglyLinkedList<E> instanceLinkedList;
	
	/*
	 *  empty constructor
	 */
	public LinkedListStack()
	{
		instanceLinkedList = new SinglyLinkedList<E>();
	}

	/**
	 * 
	 * Removes all of the elements from the stack.
	 * 
	 */
	@Override
	public void clear() 
	{
		instanceLinkedList.clear();
	}

	/**
	 * @return true if the stack contains no elements; false, otherwise.
	 */
	@Override
	public boolean isEmpty() 
	{
		return instanceLinkedList.isEmpty();
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * @return 
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public E peek() throws NoSuchElementException 
	{
		return instanceLinkedList.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public E pop() throws NoSuchElementException 
	{
		return instanceLinkedList.deleteFirst();
	}

	/**
	 * Adds a given element to the stack, putting it at the top of the stack.
	 * 
	 * @param element - the element to be added
	 */
	@Override
	public void push(E element) 
	{
		instanceLinkedList.insertFirst(element);
	}

	/**
	 * @return the number of elements in the stack
	 */
	@Override
	public int size() 
	{
		return instanceLinkedList.size();
	}

}
