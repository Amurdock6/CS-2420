package assign04;

import java.util.Random;

public class AnagramTiming {
	private static Random rand;
	public static void main(String[] args)
	{
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
	

			// Do 10000000 lookups and use the average running time.
		
			// I would recommend 10000000 timesToLoop for areAnagrams test
			// I would recommend ... timesToLoop for getLargestAnagramGroup test
			int timesToLoop = 1000;
			
			// For each problem size n . . .
			for (int n = 1000; n <= 20000; n += 1000) 
			{
				
				// Uncomment when running getLargestAnagramGroup test
				String[] anagramArray = new String[n];
				
				// Adds random strings to anagramArray
				for (int i = 0; i < anagramArray.length; i++) {
					anagramArray[i] = getRandString();
				}
				
				long startTime, midpointTime, stopTime;
				
				// First, spin computing stuff until one second has gone by.
				// This allows this thread to stabilize.
				startTime = System.nanoTime();
				while (System.nanoTime() - startTime < 1000000000) 
				{ 
					// empty block
				}
				
				// Now, run the test.
//				startTime = System.nanoTime();
//				// Test for areAnagrams
//				for (int i = 0; i < timesToLoop; i++) 
//				{
//					AnagramChecker.areAnagrams(getRandString(),getRandString());
//				}
				
//				 Test for getLargestAnagramGroup
				startTime = System.nanoTime();
				for (int i = 0; i < timesToLoop; i++) 
				{
					AnagramChecker.getLargestAnagramGroup(anagramArray);
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
	
	
	/**
	 * Generates our random strings
	 * 
	 * @return generatedString
	 */
	public static String getRandString() {
		// create instance of Random class
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int rand_int = rand.nextInt(10);

		// Checks to make sure that rand_int doesn't equal 0 or 1
		if (rand_int < 2) {
			rand_int = rand.nextInt(10);
		}

		// Generates random strings
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = rand_int;

		String generatedString = rand.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generatedString;

	}
}
	
