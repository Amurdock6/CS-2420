package assign07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BST_Timing 
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

			// Generate ordered numbers
			List<Integer> testVals = new <Integer>ArrayList();
			for(int i=0; i < N; i++)
				testVals.add(i + 1);
			
			Collections.shuffle(testVals);

			BinarySearchTree<Integer> treeTiming;

			startTime = System.nanoTime();

			for (int i = 0; i < timesToLoop; i++)
			{
				treeTiming = new BinarySearchTree<Integer>();
				for(int j : testVals)
					treeTiming.add(j);
				for(int j = 0; j < N; j++)
					treeTiming.contains(j + 1);
			}

			midpointTime = System.nanoTime();

			// Run an loop to capture the cost of the overhead
			for (long i = 0; i < timesToLoop; i++) 
			{
				treeTiming = new BinarySearchTree<Integer>();
				for(int j : testVals) 
				{
					treeTiming.add(j); // subtract the add time to see contains time
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
