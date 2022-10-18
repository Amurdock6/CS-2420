package assign06;

import java.util.Random;

public class Assignment6Timing 
{

	private static Random rand;
	public static void main(String[] args)
	{
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) 
		{ 
			// empty block
		}

//		// Time adding N values to different kinds of stacks
//		for(int N = 1000; N <= 15000; N += 1000)
//		{
//			timeAddN(N);
//		}

		// Time adding then removing N values to different kinds of stacks
		for(int N = 1000; N <= 15000; N += 1000)
		{
			timeRemoveN(N);
		}
		
		
//		// Time adding then peeking N values to different kinds of stacks
//		for(int N = 1000; N <= 15000; N += 1000)
//		{
//			timePeekN(N);
//		}
	}

	private static void timeAddN(int N)
	{
		long startTime, midpointTime, stopTime;
		int timesToLoop = 100000;

		// Generate random input before starting the timer
		int[] testVals = new int[N];
		for(int i=0; i < N; i++)
			testVals[i] = randomInteger();

		Stack<Integer> timeStack;

		startTime = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
			timeStack = new ArrayStack<Integer>();
			//timeStack = new LinkedListStack<Integer>();
			for(int j : testVals)
				timeStack.push(j);
		}

		midpointTime = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			timeStack = new ArrayStack<Integer>();
			//timeStack = new LinkedListStack<Integer>();
			for(int j : testVals) {}
		}

		stopTime = System.nanoTime();

		// Subtract the cost of running the loop
		// from the cost of running the loop plus the real work.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
				/ timesToLoop;

		System.out.println(N + "\t"+ averageTime);
	}
	
	private static void timeRemoveN(int N)
	{
		long startTime, midpointTime, stopTime;
		int timesToLoop = 100000;
		//int timesToLoop = 500;

		// Generate random input before starting the timer
		int[] testVals = new int[N];
		for(int i=0; i < N; i++)
			testVals[i] = randomInteger();

		Stack<Integer> timeStack;

		startTime = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
			timeStack = new ArrayStack<Integer>();
			//timeStack = new LinkedListStack<Integer>();
			for(int j : testVals)
				timeStack.push(j);
			for(int j = 0; j < N; j++)
				timeStack.pop();
		}

		midpointTime = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			timeStack = new ArrayStack<Integer>();
			//timeStack = new LinkedListStack<Integer>();
			for(int j : testVals) 
			{
				timeStack.push(j); // subtract the push time since we are timing pop
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
	
	
	private static void timePeekN(int N)
	{
		long startTime, midpointTime, stopTime;
		int timesToLoop = 100000;
		//int timesToLoop = 500;

		// Generate random input before starting the timer
		int[] testVals = new int[N];
		for(int i=0; i < N; i++)
			testVals[i] = randomInteger();

		Stack<Integer> timeStack;

		startTime = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
			timeStack = new ArrayStack<Integer>();
			//timeStack = new LinkedListStack<Integer>();
			for(int j : testVals)
				timeStack.push(j);
			for(int j = 0; j < N; j++)
			{
				timeStack.peek();
				timeStack.pop();
			}
		}

		midpointTime = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			timeStack = new ArrayStack<Integer>();
			//timeStack = new LinkedListStack<Integer>();
			for(int j : testVals) 
			{
				timeStack.push(j); // subtract the push time since we are timing peek
				timeStack.pop(); // also subtract the time for pop since we want peek
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

	public static Integer randomInteger()
	{
		return rand.nextInt();
	}
	
}
