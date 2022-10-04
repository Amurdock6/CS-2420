package assign05;

import java.util.ArrayList;

public class QuickSortTiming 
{
	public static void main(String[] args)
	{

			int timesToLoop = 100000;
			
			// For each problem size n . . .
			for (int n = 1000; n <= 10000; n += 1000) 
			{
				
				long startTime, midpointTime, stopTime;
				
				ArrayList<Integer> quickSort = ArrayListSorter.generatePermuted(n);

				
				// Test first pivot point
				
				// First, spin computing stuff until one second has gone by.
				// This allows this thread to stabilize.
				startTime = System.nanoTime();
				while (System.nanoTime() - startTime < 1000000000) 
				{ 
					// empty block
				}
				
//				 Now, run the test.
				startTime = System.nanoTime();
				// Test for areAnagrams
				for (int i = 0; i < timesToLoop; i++) 
				{
					ArrayListSorter.quicksort(new ArrayList<Integer>(quickSort));
				}
				
				midpointTime = System.nanoTime();
				
				// Run a loop to capture the cost of running the loop.
				for (int i = 0; i < timesToLoop; i++) 
				{
					new ArrayList<Integer>(quickSort);
				}
				
				stopTime = System.nanoTime();
				
				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and doing the lookups.
				// Average it over the number of runs.
				double averageTime1 = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
				System.out.println(n + "\t" + averageTime1);
				
				
				
				// Test the second pivot point
				
				// First, spin computing stuff until one second has gone by.
				// This allows this thread to stabilize.
				startTime = System.nanoTime();
				while (System.nanoTime() - startTime < 1000000000) 
				{ 
					// empty block
				}
				
//				 Now, run the test.
				startTime = System.nanoTime();
				// Test for areAnagrams
				for (int i = 0; i < timesToLoop; i++) 
				{
					ArrayListSorter.quicksort(new ArrayList<Integer>(quickSort));
				}
				
				midpointTime = System.nanoTime();
				
				// Run a loop to capture the cost of running the loop.
				for (int i = 0; i < timesToLoop; i++) 
				{
					new ArrayList<Integer>(quickSort);
				}
				
				stopTime = System.nanoTime();
				
				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and doing the lookups.
				// Average it over the number of runs.
				double averageTime2 = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
				System.out.println(n + "\t" + averageTime2);
				
				
				
				// Test the third pivot point
				
				
				// First, spin computing stuff until one second has gone by.
				// This allows this thread to stabilize.
				startTime = System.nanoTime();
				while (System.nanoTime() - startTime < 1000000000) 
				{ 
					// empty block
				}
				
//				 Now, run the test.
				startTime = System.nanoTime();
				// Test for areAnagrams
				for (int i = 0; i < timesToLoop; i++) 
				{
					ArrayListSorter.quicksort(new ArrayList<Integer>(quickSort));
				}
				
				midpointTime = System.nanoTime();
				
				// Run a loop to capture the cost of running the loop.
				for (int i = 0; i < timesToLoop; i++) 
				{
					new ArrayList<Integer>(quickSort);
				}
				
				stopTime = System.nanoTime();
				
				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and doing the lookups.
				// Average it over the number of runs.
				double averageTime3 = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
				System.out.println(n + "\t" + averageTime3);
				
			}
	}
}
