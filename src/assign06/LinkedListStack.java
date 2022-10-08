package assign06;

import java.util.NoSuchElementException;

/**
 * This class simulates a stack without using the java stack methods
 * 
 * @author Todd Oldham and Alex Murdock
 * @version October 7, 2022
 */

public class LinkedListStack<T> implements Stack
{
	
	// instance of singly linked list
	private SinglyLinkedList instanceLinkedList;
	
	/*
	 *  empty constructor
	 */
	public LinkedListStack()
	{
		instanceLinkedList = new SinglyLinkedList();
	}

	@Override
	public void clear() 
	{
		instanceLinkedList.clear();
	}

	@Override
	public boolean isEmpty() 
	{
		return instanceLinkedList.isEmpty();
	}

	@Override
	public Object peek() throws NoSuchElementException 
	{
		return instanceLinkedList.getFirst();
	}

	@Override
	public Object pop() throws NoSuchElementException 
	{

		return instanceLinkedList.deleteFirst();
		
	}

	@Override
	public void push(Object element) 
	{
		instanceLinkedList.insertFirst(element);
		
	}

	@Override
	public int size() 
	{
		return instanceLinkedList.size();
	}

}
