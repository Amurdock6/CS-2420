package assign09;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class AnalysisProblem5HW9
{
	public static void main(Integer[] args)
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
			int timesToLoop = 10000;

			Random rng = new Random();
			// Generate students
			LinkedList<MapEntry<Integer, Integer>> testVals = new LinkedList<MapEntry<Integer, Integer>>();
			for(int i=0; i < N; i++)
				testVals.add(new MapEntry<Integer, Integer>(rng.nextInt(N), i + 1));

			//HashTable<Integer, Integer>problem5;
			HashMap<Integer, Integer> problem5;

			startTime = System.nanoTime();

			//problem5 = new HashTable<Integer, Integer>();
			problem5 = new HashMap<Integer, Integer>();
			
			for (int i = 0; i < timesToLoop; i++)
			{
				for(int j = 0; j < testVals.size(); j++)
					problem5.put(testVals.get(j).getKey(), testVals.get(j).getValue());
			}

			midpointTime = System.nanoTime();

			// Run an loop to capture the cost of the overhead
			for (long i = 0; i < timesToLoop; i++) 
			{
				//problem5 = new HashTable<Integer, Integer>();
				problem5 = new HashMap<Integer, Integer>();
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