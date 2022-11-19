package assign10;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class contains generic static methods for finding the k largest items in a list.
 * 
 * @author Erin Parker & Todd Oldham & Alex Murdock
 * @version 11/18/2022
 */
public class FindKLargest 
{
	
	/**
	 * Determines the k largest items in the given list, using a binary max heap and the 
	 * natural ordering of the items.
	 * 
	 * @param items - the given list
	 * @param k - the number of largest items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of the given list
	 */
	public static <E extends Comparable<? super E>> List<E> findKLargestHeap(List<E> items, int k) throws IllegalArgumentException 
	{
		// If k is bigger than the size of the list
		if(k > items.size())
			throw new IllegalArgumentException();
		
		// If k is negative
		else if(k < 0)
			throw new IllegalArgumentException();
		
		// Create new binary heap
		BinaryMaxHeap<E> klargest = new BinaryMaxHeap<E>(items);
		
		// create a list
		List<E> biggestK = new LinkedList<E>();
		
		// for the number of k add the largest to the list
		for(int i = 0; i < k; i++)
		{
			biggestK.add(klargest.extractMax());
		}
		
		// return the list
		return biggestK;
	}

	/**
	 * Determines the k largest items in the given list, using a binary max heap.
	 * 
	 * @param items - the given list
	 * @param k - the number of largest items
	 * @param cmp - the comparator defining how to compare items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of the given list
	 */
	public static <E> List<E> findKLargestHeap(List<E> items, int k, Comparator<? super E> cmp) throws IllegalArgumentException 
	{
		// If k is bigger than the size of the list
		if(k > items.size())
			throw new IllegalArgumentException();
		
		// If k is negative
		else if(k < 0)
			throw new IllegalArgumentException();
		
		// Create new binary heap
		BinaryMaxHeap<E> klargest = new BinaryMaxHeap<E>(items, cmp);
		
		// create a list
		List<E> biggestK = new LinkedList<E>();
		
		// for the number of k add the largest to the list
		for(int i = 0; i < k; i++)
		{
			biggestK.add(klargest.extractMax());
		}
		
		// return the list
		return biggestK;
	}

	/**
	 * Determines the k largest items in the given list, using Java's sort routine and the 
	 * natural ordering of the items.
	 * 
	 * @param items - the given list
	 * @param k - the number of largest items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of the given list
	 */
	public static <E extends Comparable<? super E>> List<E> findKLargestSort(List<E> items, int k) throws IllegalArgumentException 
	{
		
		// If k is bigger than the size of the list
		if(k > items.size())
			throw new IllegalArgumentException();
		
		// If k is negative
		else if(k < 0)
			throw new IllegalArgumentException();
		
		// sort the list
		Collections.sort(items);
		
		// create a list
		List<E> biggestK = new LinkedList<E>();
		
		// for the number of k add the largest to the list
		for(int i = 0; i < k; i++)
		{
			biggestK.add(items.get(items.size() - 1 - i));
		}
		
		// return the list
		return biggestK;
	}

	/**
	 * Determines the k largest items in the given list, using Java's sort routine.
	 * 
	 * @param items - the given list
	 * @param k - the number of largest items
	 * @param cmp - the comparator defining how to compare items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of the given list
	 */
	public static <E> List<E> findKLargestSort(List<E> items, int k, Comparator<? super E> cmp) throws IllegalArgumentException 
	{
		
		// If k is bigger than the size of the list
		if(k > items.size())
			throw new IllegalArgumentException();
		
		// If k is negative
		else if(k < 0)
			throw new IllegalArgumentException();
		
		// sort the list
		Collections.sort(items, cmp);
		
		// create a list
		List<E> biggestK = new LinkedList<E>();
		
		// for the number of k add the largest to the list
		for(int i = 0; i < k; i++)
		{
			biggestK.add(items.get(items.size() - 1 - i));
		}
		
		// return the list
		return biggestK;
	}
}