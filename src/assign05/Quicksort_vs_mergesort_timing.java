package assign05;

import java.util.ArrayList;

public class Quicksort_vs_mergesort_timing 
{
	public static void main(String[] args)
	{

			int timesToLoop = 1000;
			
			// For each problem size n . . .
			for (int n = 1000; n <= 10000; n += 1000) 
			{
				
				long startTime, midpointTime, stopTime;
				
				ArrayList<Integer> versusAscending = ArrayListSorter.generateAscending(n);
				ArrayList<Integer> versusDescending = ArrayListSorter.generateDescending(n);
				ArrayList<Integer> versuspermuted = ArrayListSorter.generatePermuted(n);

				
				// Test quickSort ascending
				
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
					ArrayListSorter.quicksort(new ArrayList<Integer>(versusAscending), 1);
				}
				
				midpointTime = System.nanoTime();
				
				// Run a loop to capture the cost of running the loop.
				for (int i = 0; i < timesToLoop; i++) 
				{
					new ArrayList<Integer>(versusAscending);
				}
				
				stopTime = System.nanoTime();
				
				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and doing the lookups.
				// Average it over the number of runs.
				double averageTime1 = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
				System.out.println(n + "\t" + averageTime1);
				
				
				
				// Test mergeSort ascending
				
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
					ArrayListSorter.mergesort(new ArrayList<Integer>(versusAscending), 60);
				}
				
				midpointTime = System.nanoTime();
				
				// Run a loop to capture the cost of running the loop.
				for (int i = 0; i < timesToLoop; i++) 
				{
					new ArrayList<Integer>(versusAscending);
				}
				
				stopTime = System.nanoTime();
				
				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and doing the lookups.
				// Average it over the number of runs.
				double averageTime2 = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
				System.out.println(n + "\t" + averageTime2);
				
				
				// Test quickSort descending
				
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
					ArrayListSorter.quicksort(new ArrayList<Integer>(versusDescending), 1);
				}
				
				midpointTime = System.nanoTime();
				
				// Run a loop to capture the cost of running the loop.
				for (int i = 0; i < timesToLoop; i++) 
				{
					new ArrayList<Integer>(versusDescending);
				}
				
				stopTime = System.nanoTime();
				
				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and doing the lookups.
				// Average it over the number of runs.
				double averageTime3 = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
				System.out.println(n + "\t" + averageTime3);
				
				
				
				// Test mergeSort descending
				
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
					ArrayListSorter.mergesort(new ArrayList<Integer>(versusDescending), 60);
				}
				
				midpointTime = System.nanoTime();
				
				// Run a loop to capture the cost of running the loop.
				for (int i = 0; i < timesToLoop; i++) 
				{
					new ArrayList<Integer>(versusDescending);
				}
				
				stopTime = System.nanoTime();
				
				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and doing the lookups.
				// Average it over the number of runs.
				double averageTime4 = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
				System.out.println(n + "\t" + averageTime4);
				
				
				
				// Test quickSort permuted
				
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
					ArrayListSorter.quicksort(new ArrayList<Integer>(versuspermuted), 1);
				}
				
				midpointTime = System.nanoTime();
				
				// Run a loop to capture the cost of running the loop.
				for (int i = 0; i < timesToLoop; i++) 
				{
					new ArrayList<Integer>(versuspermuted);
				}
				
				stopTime = System.nanoTime();
				
				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and doing the lookups.
				// Average it over the number of runs.
				double averageTime5 = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
				System.out.println(n + "\t" + averageTime5);
				
				
				
				// Test mergeSort permuted
				
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
					ArrayListSorter.mergesort(new ArrayList<Integer>(versuspermuted), 60);
				}
				
				midpointTime = System.nanoTime();
				
				// Run a loop to capture the cost of running the loop.
				for (int i = 0; i < timesToLoop; i++) 
				{
					new ArrayList<Integer>(versuspermuted);
				}
				
				stopTime = System.nanoTime();
				
				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and doing the lookups.
				// Average it over the number of runs.
				double averageTime6 = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
				System.out.println(n + "\t" + averageTime6);
				
			}
	}
}
