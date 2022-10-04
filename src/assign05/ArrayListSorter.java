package assign05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> mergeList, int threshold) 
	{
		  //Create a temp space and ensure it is large enough
		ArrayList<T> temp = new ArrayList<T>(mergeList.size());
				
		for(int i=0; i < mergeList.size(); i++)
			temp.add(null);
		  
		  // call internal overloaded method for entire array, and merge space
		  // NOTE: size()-1, not size
		  mergesort(mergeList, temp, 0, mergeList.size() - 1, threshold);
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
	private static <T extends Comparable<? super T>> void mergesort(ArrayList<T> mergeList, ArrayList<T> temp, int start, int end, int threshold) 
	{

		  // TODO: Replace this with an insertion sort threshold
		  if(end - start <= threshold)
		  {		  
			  insertionSort(mergeList, start, end);
			  return;
		  }

		  // get the middle value of the list
		  int mid = start + (end - start) / 2;
		  
		  // call merge sort, creates first half
		  mergesort(mergeList, temp, start, mid, threshold);
		  
		  // call merge sort, creates second half
		  mergesort(mergeList, temp, mid + 1, end, threshold);
		  
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
	private static <T extends Comparable<? super T>> void merge(ArrayList<T> mergeList, ArrayList<T> temp, int start, int mid, int end)
	{

		// set the start index
		int i = start;
		
		// set the middle index
		int j = mid + 1;
		
		// set position to merge them back together
		int mergePos = start;

		// check if the current i is less than current j, if yes add i to temp, if no add j to temp
		while (i <= mid && j <= end) 
		{
			if (mergeList.get(i).compareTo(mergeList.get(j)) < 1)
				temp.set(mergePos++, mergeList.get(i++));
			
			else
				temp.set(mergePos++, mergeList.get(j++)); 
		}

		//copy anything left over from larger half to temp
		while (i <= mid) 
		{
            temp.set(mergePos++, mergeList.get(i++));
        }
		
		while (j <= end) 
		{
            temp.set(mergePos++, mergeList.get(j++));
        }

		//copy temp (from start to end) back into arr (from start to end)
		for(int s = start; s <= end; s++)
			mergeList.set(s, temp.get(s));

	}
	
	/**
	 * This generic method sorts the input array using an insertion sort.
	 * @param ArrayList<T>
	 * @param leftIndex
	 * @param rightIndex
	 */
	public static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> toBeSorted, int leftIndex, int rightIndex)
	{
		for (int i = leftIndex + 1; i <= rightIndex; i++)
		{
			
			// set the value we are looking at as the second item
			T currentValue = toBeSorted.get(i);
			
			// set the position as the first item
			int position = i - 1;
			
			// while our item is smaller than the items on the left and position is greater than -1
			while(position >= leftIndex && toBeSorted.get(position).compareTo(currentValue) > -1)
			{
				// set the current position with the bigger item
				toBeSorted.set(position + 1, toBeSorted.get(position));
				
				// reduce the position
	             position--;
	        }
			
			// set the final position for our current item
			toBeSorted.set(position + 1, currentValue);
	     }
	}
	
	// A utility function to swap two elements
    static int[] swap(int[] arr, int L, int R)
    {
    	System.out.println("swaping");
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
        
        return arr;
    }
	
	/**
	 * 
	 * This method performs a quicksort on the generic ArrayList given as input. You
	 * must implement three different strategies for determining the pivot, and your
	 * implementation should be able to easily switch among these strategies.
	 * (Consider using a few private helper methods for your different
	 * pivot-selection strategies.) You will perform timing experiments to determine
	 * which strategy works best. Your implementation may switch to insertion sort
	 * on some small threshold, if you wish.
	 * 
	 * @param <T>
	 */
	 public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> quickList) {
		// converts ArrayList to array to make pseudo code run
		Object[] ob = quickList.toArray();
		int[] intList = new int[ob.length];
		
		// takes items from our ArrayList and puts them into array
		for (int x = 0; x < intList.length; x++) {
			intList[x] = (Integer) ob[x];
		}

		int pivot = intList[quicksort.getMedian(quickList)];
		int leftBound = intList[0];
		int rightBound = intList.length;

		int L = leftBound, R = rightBound - 1;
		
		while (L <= R) {
			while (L < rightBound && intList[L] <= pivot) {
				L++;
			}
			while (R >= leftBound && intList[R] >= pivot) {
				R--;
			}

			if (L < R) {
				// swaps the reference points
				intList = swap(intList, L, R);
			}
			
			// swaps the reference points
			intList = swap(intList, L, R);
		}
		
		// need to set our quickList equals to our intList
		System.out.println(Arrays.toString(intList));
		
//		find pivot, swap with item at rightBound;
//
//		L = leftBound, R = rightBound - 1;
//
//		while(L <= R){
//		  while(L < rightBound && arr[L] <= pivot)
//		    L++;
//		  while(R >= leftBound && arr[R] >= pivot)
//		    R--;
//
//		  if(L < R)
//		    swapReferences(arr, L, R);
//		}
//
//		swapReferences(arr, L, rightBound);
		
		

	}

	public interface quicksort {
		/**
		 * This method will grab the median of the entire ArrayList
		 * 
		 * @return median
		 */
		static <T> int getMedian(ArrayList<T> passedArrayList) {
			double lower = 0;
			double upper = 0;

			if (passedArrayList.size() % 2 == 1)
				System.out.println(passedArrayList.get((passedArrayList.size() + 1) / 2 - 1));
			else {
				// Will make sure that our passed array is able to be divided
				lower = (double) (passedArrayList.size() / 2 - 1);
				upper = (double) (passedArrayList.size() / 2);
			}

			return (int) Math.round((lower + upper) / 2.0);
		}

		/**
		 * This method will randomly grab a index out of the provided ArrayList
		 * 
		 * @param <T>
		 * @return median
		 */
		static <T> int getRandom(ArrayList<T> passedArrayList) {
			int arrayListSize = passedArrayList.size();

			Random rand = new Random(); // instance of random class
			int upperbound = arrayListSize;
			int randomIndex = rand.nextInt(upperbound);

			return randomIndex;
		}

		/**
		 * This method will grab three random indexes and then determine the median
		 * based off of those
		 * 
		 * @return median
		 */
		static <T> int getThreeRandomThenMedian(ArrayList<T> passedArrayList) {
			int[] intArray;
			intArray = new int[3];
			
			// sets are array with 3 random numbers from our passedArrayList
			intArray[0] = getRandom(passedArrayList);
			intArray[1] = getRandom(passedArrayList);
			intArray[2] = getRandom(passedArrayList);
			
			// finds the median of our 3 random numbers
			Arrays.sort(intArray);
			double median;
			if (intArray.length % 2 == 0)
			    median = ((double)intArray[intArray.length/2] + (double)intArray[intArray.length/2 - 1])/2;
			else
			    median = (double) intArray[intArray.length/2];
			
			// converts our median from a double to a int so we can grab the median from our array
			int returnMedian = (int) Math.round(median);
			
			return returnMedian;
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
