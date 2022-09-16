package assign03;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import assign02.Library;
import assign02.LibraryBook;

public class TimeArrayCollection {
	private static Random rand;
	public static void main(String[] args)
	{
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
	
		//TODO: Write code to time your toSortedList, contains, and SearchUtil.binarySearch methods so you can plot the results.
	
		ArrayCollection testContains_SearchUtil = new ArrayCollection();
		
		ArrayList searchUtil = new ArrayList();
		
		IntegerComparator testComparator = new IntegerComparator();
		
			// Do 10000 lookups and use the average running time.
			int timesToLoop = 100000000;
			
			int[] searchNums;
			searchNums = new int[timesToLoop];
			
			for(int q = 0; q < timesToLoop; q++)
			{
				searchNums[q] = randomInt();
			}
			
			
			int t = 0;
			
			// For each problem size n . . .
			for (int n = 1000; n <= 20000; n += 1000) 
			{
				while ( t < n)
				{
					testContains_SearchUtil.add(randomInt());
					searchUtil.add(randomInt());
					
					t++;
				}
				
//				long startTime, midpointTime, stopTime;
//				
//				// First, spin computing stuff until one second has gone by.
//				// This allows this thread to stabilize.
//				startTime = System.nanoTime();
//				while (System.nanoTime() - startTime < 1000000000) 
//				{ 
//					// empty block
//				}
//				
//				// Now, run the test.
//				startTime = System.nanoTime();
//				for (int i = 0; i < timesToLoop; i++) 
//				{
//					testContains_SearchUtil.contains(searchNums[i]);
//				}
//				
//				midpointTime = System.nanoTime();
//				
//				// Run a loop to capture the cost of running the "timesToLoop" loop and generating a random ISBN.
//				for (int i = 0; i < timesToLoop; i++) 
//				{
//					
//				}
//				
//				stopTime = System.nanoTime();
//				
//				// Compute the time, subtract the cost of running the loop
//				// from the cost of running the loop and doing the lookups.
//				// Average it over the number of runs.
//				double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
//				System.out.println(n + "\t" + averageTime);
				
				
//				// Second test for search Util
			
				long startTime2, midpointTime2, stopTime2;
				
				// First, spin computing stuff until one second has gone by.
				// This allows this thread to stabilize.
				startTime2 = System.nanoTime();
				while (System.nanoTime() - startTime2 < 1000000000) 
				{ 
					// empty block
				}
				
				// Now, run the test.
				startTime2 = System.nanoTime();
				for (int i = 0; i < timesToLoop; i++) 
				{
					SearchUtil.binarySearch(searchUtil, searchNums[i], testComparator);
				}
				
				midpointTime2 = System.nanoTime();
				
				// Run a loop to capture the cost of running the "timesToLoop" loop and generating a random ISBN.
				for (int i = 0; i < timesToLoop; i++) 
				{
					
				}
				
				stopTime2 = System.nanoTime();
				
				// Compute the time, subtract the cost of running the loop
				// from the cost of running the loop and doing the lookups.
				// Average it over the number of runs.
				double averageTime2 = ((midpointTime2 - startTime2) - (stopTime2 - midpointTime2)) / (double) timesToLoop;
				System.out.println(n + "\t" + averageTime2);
				
				}
	}
		

		


	

	public static Integer randomInt()
	{
		return rand.nextInt();
	}

}
