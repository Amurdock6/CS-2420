package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> mergeList) 
	{
		  //Create a temp space and ensure it is large enough
		  T[] temp = (T[]) new Object[10];
		  
		  // call internal overloaded method for entire array, and merge space
		  // NOTE: size()-1, not size
		  mergesort(mergeList, temp, 0, mergeList.size() - 1);
	}
	
	/**
	 * 
	 * Overloaded version of mergesort
	 * 
	 * @param <T>
	 * @param mergeList
	 * @param temp
	 * @param start
	 * @param end
	 */
	private static <T extends Comparable<? super T>> void mergesort(ArrayList<T> mergeList, T[] temp, int start, int end) 
	{

		  // TODO: Replace this with an insertion sort threshold
		  if(start >= end)
		    return;

		  // get the middle value of the list
		  int mid = start + (end - start) / 2;
		  
		  // call merge sort, creates first half
		  mergesort(mergeList, temp, start, mid);
		  
		  // call merge sort, creates second half
		  mergesort(mergeList, temp, mid + 1, end);
		  
		  // call merge, sorts and puts them back together
		  merge(mergeList, temp, start, mid, end);
	}
	
	/**
	 * 
	 * Merge method that sorts and puts the split up lists or arrays back together again
	 * 
	 * @param <T>
	 * @param mergeList
	 * @param temp
	 * @param start
	 * @param mid
	 * @param end
	 */
	private static <T extends Comparable<? super T>> void merge(ArrayList<T> mergeList, T[] temp, int start, int mid, int end)
	{

		int i = start; 
		int j = mid + 1; 
		int mergePos = start;

		while (i <= mid && j <= end) 
		{
			if (mergeList.get(i).compareTo(mergeList.get(j)) < 1)
				temp[mergePos++] = mergeList.get(i++);
			
			else
				temp[mergePos++] = mergeList.get(j++); 
		}

		copy anything left over from larger half to temp

		copy temp (from start to end) back into arr (from start to end) 

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
//	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> quickList) 
//	{
//		System.out.print(quicksort.getMedian(quickList));
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
//		
//	}
	
//	public interface quicksort 
//	{
//		/**
//		 * This method will grab the median of the entire ArrayList
//		 * @return median
//		 */
//		private static <T> int getMedian(ArrayList<T> passedArrayList) {
//
//	        if (passedArrayList.size() % 2 == 1)
//	            System.out.println(passedArrayList.get((passedArrayList.size() + 1) / 2 - 1));
//	        else {
//	            double lower = passedArrayList.get(passedArrayList.size() / 2 - 1);
//	            double upper = passedArrayList.get(passedArrayList.size() / 2);
//
//	           System.out.println((lower + upper) / 2.0);
//	        }
//	        
//			return 0;
//		}
		
		/**
		 * This method will randomly grab a index out of the provided ArrayList
		 * @param <T>
		 * @return median
		 */
		private static <T> int getRandom(ArrayList<T> passedArrayList) {
			int arrayListSize = passedArrayList.size();
			
			Random rand = new Random(); //instance of random class
		      int upperbound = arrayListSize;
		      int randomIndex = rand.nextInt(upperbound); 
			
			return randomIndex;
		}
		
		/**
		 * This method will grab three random indexes and then determine the median based off of those
		 * @return median
		 */
		private static <T> int getThreeRandomThenMedian(ArrayList<T> passedArrayList) {
			
			 return 0;
		}
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
