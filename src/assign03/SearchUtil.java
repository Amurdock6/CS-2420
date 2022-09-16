package assign03;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Daniel Kopta and Todd Oldham and Alex Murdock
 * A utility class for searching, containing just one method (see below).
 *
 */
public class SearchUtil {

	
	/**
	 * 
	 * @param <T>	The type of elements contained in the list
	 * @param list	An ArrayList to search through. 
	 * 				This ArrayList is assumed to be sorted according 
	 * 				to the supplied comparator. This method has
	 * 				undefined behavior if the list is not sorted. 
	 * @param item	The item to search for
	 * @param cmp	Comparator for comparing Ts or a super class of T
	 * @return		true if the item exists in the list, false otherwise
	 */
	public static <T> boolean binarySearch(ArrayList<T> list, T item, Comparator<? super T> cmp)
	{
		
		// create max, min, middle variables
		int min = 0;
		int max = list.size() - 1;
		int middle = 0;
		
		// while our min is less than or equal to our max
		while(min <= max) 
		{
			// get the average value to be the middle
			middle = (min + max) / 2;
			
			if(cmp.compare(item, list.get(middle)) == 0)
				return true;
			
			else if(cmp.compare(item, list.get(middle)) < 1) 
				max = middle - 1;
			
			else 
				min = middle + 1;
		}
		return false;
	}	
}