package assign05;

import java.util.ArrayList;

/**
 * This class contains the methods for merge sort and quick sort 
 * along with methods for generating list arrays in ascending descending and random order
 * 
 * @author Todd Oldham and Alex Murdock
 * @version September 23, 2022
 */

public class ArrayListSorter 
{

	/**
	 *
	 *This method performs a merge sort on the generic ArrayList given as input.
	 *Your implementation must switch over to insertion sort when 
	 *the size of the sublist to be sorted meets a certain threshold 
	 *(i.e., becomes small enough).  
	 *Make this threshold value a private static variable that you can easily change.
	 * 
	 * @param <T>
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> mergeList) 
	{
		
	}
	
	/**
	 * 
	 * This method performs a quicksort on the generic ArrayList given as input.
	 * You must implement three different strategies for determining the pivot, 
	 * and your implementation should be able to easily switch among these strategies.  
	 * (Consider using a few private helper methods for your different pivot-selection strategies.)  
	 * You will perform timing experiments to determine which strategy works best.  
	 * Your implementation may switch to insertion sort on some small threshold, if you wish.
	 * 
	 * @param <T>
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> quickList) 
	{
		
	}
	
	
	/**
	 * 
	 * This method generates and returns an ArrayList of integers 1 to size in ascending order.
	 * 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateAscending(int size)
	{
		
		return null;
		
	}
	
	/**
	 * 
	 * This method generates and returns an ArrayList of integers 1 to size in permuted order
	 *  (i,e., randomly ordered).  
	 *  You may make use of Java's Collections.shuffle method.
	 * 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generatePermuted(int size)
	{
		
		return null;
		
	}
	
	/**
	 * 
	 * This method generates and returns an ArrayList of integers 1 to size in descending order.
	 * 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateDescending(int size)
	{
		
		return null;
		
	}
	
	
}
