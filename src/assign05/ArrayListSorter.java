package assign05;

import java.util.ArrayList;
import java.util.Collections;

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
//		mergesort(arr)
//		{ 
//		  Create a temp space and ensure it is large enough
//		  // call internal overloaded method for entire array, and merge space
//		  // NOTE: size()-1, not size
//		  mergesort(arr, temp, 0, arr.size() - 1, ...);
//		}
		
//		mergesort(arr, temp, start, end) 
//		{
//
//			  // TODO: Replace this with an insertion sort threshold
//			  if(start >= end)
//			    return;
//
//			  int mid = start + (end - start) / 2;
//			  mergesort(arr, temp, start, mid);
//			  mergesort(arr, temp, mid + 1, end);
//			  merge(arr, temp, start, mid, end);
//		}
		
//		merge(arr, temp, start, mid, end)
//		{
//
//			  int i = start; 
//			  int j = mid + 1; 
//			  int mergePos = start;
//
//			  while (i <= mid && j <= end) 
//			  {
//			    if (arr[i] <= arr[j])
//			      temp[mergePos++] = arr[i++]; 
//			    else
//			      temp[mergePos++] = arr[j++]; 
//			  }
//
//			  copy anything left over from larger half to temp
//
//			  copy temp (from start to end) back into arr (from start to end) 
//
//		}
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
//		find pivot, swap with item at rightBound;
//
//		L = leftBound, R = rightBound - 1;
//
//		while(L <= R)
//		{
//		  while(L < rightBound && arr[L] <= pivot)
//		    L++;
//		  
//		  while(R >= leftBound && arr[R] >= pivot)
//		    R--;
//
//		  if(L < R)
//		    swapReferences(arr, L, R);
//		}
//
//		swapReferences(arr, L, rightBound);
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
		
		ArrayList<Integer> ascendingList = new ArrayList<>();
		
		for(int i = 0; i < size; i++)
		{
			ascendingList.add(i + 1);
		}
		
		return ascendingList;
		
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
		
		ArrayList<Integer> permutedList = new ArrayList<>();
		
		for(int i = 0; i < size; i++)
		{
			permutedList.add(i + 1);
		}
		
		Collections.shuffle(permutedList);
		
		return permutedList;
		
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
		ArrayList<Integer> descendingList = new ArrayList<>();
		
		for(int i = 0; i < size; i++)
		{
			descendingList.add(size - i);
		}
		
		return descendingList;
		
	}
	
	
}
