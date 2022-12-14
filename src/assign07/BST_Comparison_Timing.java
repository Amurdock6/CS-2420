package assign07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class BST_Comparison_Timing
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
		
		for(int N = 10000; N <= 200000; N += 10000)
		{
			long midpointTime, stopTime;
			int timesToLoop = 1000;

			// Generate ordered numbers
			List<Integer> testVals = new <Integer>ArrayList<Integer>();
			for(int i=0; i < N; i++)
				testVals.add(i + 1);
			
			Collections.shuffle(testVals);

			BinarySearchTree<Integer> treeTiming;
			BinarySearchTree<Integer> treeTiming3;
			TreeSet<Integer> treeTiming2;
			TreeSet<Integer> treeTiming4;

			
			// TEST NUMBER 1 BinarySerachTree contains
			
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
				//treeTiming = new TreeSet<Integer>();
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
				
				
				// TEST NUMBER 2 Tree Set Contains
				
				startTime = System.nanoTime();

				for (int i = 0; i < timesToLoop; i++)
				{
					treeTiming2 = new TreeSet<Integer>();
					for(int j : testVals)
						treeTiming2.add(j);
					for(int j = 0; j < N; j++)
						treeTiming2.contains(j + 1);
				}

				midpointTime = System.nanoTime();

				// Run an loop to capture the cost of the overhead
				for (long i = 0; i < timesToLoop; i++) 
				{
					treeTiming2 = new TreeSet<Integer>();
					for(int j : testVals) 
					{
						treeTiming2.add(j); // subtract the add time to see contains time
					}
					for(int j = 0; j < N; j++) {}
				}
					
					stopTime = System.nanoTime();

					// Subtract the cost of running the loop
					// from the cost of running the loop plus the real work.
					// Average it over the number of runs.
					double averageTime2 = ((midpointTime - startTime) - (stopTime - midpointTime))
							/ timesToLoop;

					System.out.println(N + "\t"+ averageTime2);
					
					
					
				// TEST NUMBER 3 BinarySearchTree Add
					
					
				startTime = System.nanoTime();

				for (int i = 0; i < timesToLoop; i++) 
				{
					treeTiming3 = new BinarySearchTree<Integer>();
					for (int j : testVals)
						treeTiming3.add(j);
				}

				midpointTime = System.nanoTime();

				// Run an loop to capture the cost of the overhead
				for (long i = 0; i < timesToLoop; i++) {
					treeTiming3 = new BinarySearchTree<Integer>();
					for (int j : testVals) 
					{
					}
					for (int j = 0; j < N; j++) {
					}
				}

				stopTime = System.nanoTime();

				// Subtract the cost of running the loop
				// from the cost of running the loop plus the real work.
				// Average it over the number of runs.
				double averageTime3 = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;

				System.out.println(N + "\t" + averageTime3);
				
				
				
				// TEST NUMBER 4 TreeSet add
				
				
				startTime = System.nanoTime();

				for (int i = 0; i < timesToLoop; i++) 
				{
					treeTiming4 = new TreeSet<Integer>();
					for (int j : testVals)
						treeTiming4.add(j);
				}

				midpointTime = System.nanoTime();

				// Run an loop to capture the cost of the overhead
				for (long i = 0; i < timesToLoop; i++) {
					treeTiming4 = new TreeSet<Integer>();
					for (int j : testVals) 
					{
					}
					for (int j = 0; j < N; j++) {
					}
				}

				stopTime = System.nanoTime();

				// Subtract the cost of running the loop
				// from the cost of running the loop plus the real work.
				// Average it over the number of runs.
				double averageTime4 = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;

				System.out.println(N + "\t" + averageTime4);
		}
		
		
	}
}