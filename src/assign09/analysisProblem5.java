package assign09;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class analysisProblem5
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
		
		for(int N = 100; N <= 2000; N += 100)
		{
			long midpointTime, stopTime;
			int timesToLoop = 10;

			Random rng = new Random();
			// Generate students
			LinkedList<MapEntry<String, Integer>> testVals = new LinkedList<MapEntry<String, Integer>>();
			for(int i=0; i < N; i++)
				testVals.add(new MapEntry(rng.nextInt(N).toString()), i + 1));

			HashTable<String, Integer>problem5;
			//HashMap<String, Integer> problem5;

			startTime = System.nanoTime();

			problem5 = new HashTable<String, Integer>();
			//problem5 = new HashMap<String, Integer>();
			
			for (int i = 0; i < timesToLoop; i++)
			{
				for(int j = 0; j < testVals.size(); j++)
					problem5.put(testVals.get(j).getKey(), testVals.get(j).getValue());
			}

			midpointTime = System.nanoTime();

			// Run an loop to capture the cost of the overhead
			for (long i = 0; i < timesToLoop; i++) 
			{
				problem5 = new HashTable<String, Integer>();
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