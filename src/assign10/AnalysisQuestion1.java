package assign10;

import java.util.Random;

public class AnalysisQuestion1 
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
			int timesToLoop = 1000;

			Random rng = new Random();

			BinaryMaxHeap<Integer> experiment1;

			startTime = System.nanoTime();

			experiment1 = new BinaryMaxHeap<Integer>();
			
			for (int i = 0; i < timesToLoop; i++)
			{
				for(int j = 0; j < N; j++)
				{
					experiment1.add(rng.nextInt(N));
//					experiment1.peek();
				}
				
				for(int k = 0; k < N; k++)
				{
					experiment1.extractMax();
				}
			}

			midpointTime = System.nanoTime();

			// Run an loop to capture the cost of the overhead
			for (long i = 0; i < timesToLoop; i++) 
			{
				experiment1 = new BinaryMaxHeap<Integer>();
				for(int j = 0; j < N; j++) 
				{
					experiment1.add(rng.nextInt(N));
				}
				for(int j = 0; j < N; j++) 
				{
					
				}
			}
				
				stopTime = System.nanoTime();

				// Subtract the cost of running the loop
				// from the cost of running the loop plus the real work.
				// Average it over the number of runs.
				double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;

				System.out.println(N + "\t"+ averageTime);
		}
		
	}
}
