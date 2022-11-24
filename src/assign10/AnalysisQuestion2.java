package assign10;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AnalysisQuestion2 
{
	public static void main(String[] args)
	{
	
		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) 
		{ 
			// empty block
		}
		
		for(int N = 1000; N <= 20000; N += 1000)
		{
			long midpointTime, stopTime;
			int timesToLoop = 100;

			Random rng = new Random();
			// Generate students
			LinkedList<Integer> testVals = new LinkedList<Integer>();
			for(int i=0; i < N; i++)
				testVals.add(rng.nextInt(N));

			@SuppressWarnings("unused")
			List<Integer> experiment2;

			startTime = System.nanoTime();
			
			for (int i = 0; i < timesToLoop; i++)
			{
				experiment2 = FindKLargest.findKLargestHeap(testVals, N);
				//experiment2 = FindKLargest.findKLargestSort(testVals, N);
			}

			midpointTime = System.nanoTime();

			// Run an loop to capture the cost of the overhead
			for (long i = 0; i < timesToLoop; i++) 
			{
				@SuppressWarnings("unused")
				List<Integer> experiment3 = new LinkedList<Integer>();
				for(int j = 0; j < testVals.size(); j++) 
				{
					
				}
				for(int j = 0; j < N; j++) {}
			}
				
				stopTime = System.nanoTime();

				// Subtract the cost of running the loop
				// from the cost of running the loop plus the real work.
				// Average it over the number of runs.
				double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
						/ timesToLoop;

				System.out.println(N + "\t"+ averageTime);
		}
		
	}
}
