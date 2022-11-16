package assign09;

import java.util.LinkedList;
import java.util.Random;

public class analysisProblem2Experiment 
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
			LinkedList<MapEntry<StudentGoodHash, Integer>> testVals = new LinkedList<MapEntry<StudentGoodHash, Integer>>();
			for(int i=0; i < N; i++)
				testVals.add(new MapEntry<StudentGoodHash, Integer>(new StudentGoodHash(1 + rng.nextInt(N), "First", "Last"), i + 1));

			HashTable<StudentGoodHash, Integer> problem2;

			startTime = System.nanoTime();

			problem2 = new HashTable<StudentGoodHash, Integer>();
			
			for (int i = 0; i < timesToLoop; i++)
			{
				for(int j = 0; j < testVals.size(); j++)
					problem2.put(testVals.get(j).getKey(), testVals.get(j).getValue());
			}
			
			//System.out.println(problem2.getCollisions());

			midpointTime = System.nanoTime();

			// Run an loop to capture the cost of the overhead
			for (long i = 0; i < timesToLoop; i++) 
			{
				problem2 = new HashTable<StudentGoodHash, Integer>();
				for(int j = 0; j < testVals.size(); j++) 
				{
					// subtract time to return collisions
					//problem2.getCollisions();
				}
				for(int j = 0; j < N; j++) {}
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
