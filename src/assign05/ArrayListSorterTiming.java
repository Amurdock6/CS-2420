package assign05;

import java.util.Random;
import assign04.AnagramChecker;

public class ArrayListSorterTiming 
{

		private static Random rand;
		public static void main(String[] args)
		{
			rand = new Random();
			rand.setSeed(System.currentTimeMillis());
		

				int timesToLoop = 1000;
				
				// For each problem size n . . .
				for (int n = 1000; n <= 20000; n += 1000) 
				{
					
					long startTime, midpointTime, stopTime;
					
					// First, spin computing stuff until one second has gone by.
					// This allows this thread to stabilize.
					startTime = System.nanoTime();
					while (System.nanoTime() - startTime < 1000000000) 
					{ 
						// empty block
					}
					
//					 Now, run the test.
					startTime = System.nanoTime();
					// Test for areAnagrams
					for (int i = 0; i < timesToLoop; i++) 
					{
						
					}
					
					midpointTime = System.nanoTime();
					
					// Run a loop to capture the cost of running the loop.
					for (int i = 0; i < timesToLoop; i++) 
					{
						
					}
					
					stopTime = System.nanoTime();
					
					// Compute the time, subtract the cost of running the loop
					// from the cost of running the loop and doing the lookups.
					// Average it over the number of runs.
					double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
					System.out.println(n + "\t" + averageTime);
					
				}
		}
}
