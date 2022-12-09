package comprehensive;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ComprehensiveExperiment2 
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
		
		for(int N = 10; N <= 200; N += 10)
		{
			long midpointTime, stopTime;
			int timesToLoop = 100;

			try 
			{
				FileWriter write = new FileWriter(new File("src/comprehensive/test" + N + "2.g"));
				write.write(gen(1, N));
				write.close();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			startTime = System.nanoTime();
			
			for (int i = 0; i < timesToLoop; i++)
			{
				for(int j = 0; j < N; j++)
				{
					RandomPhraseGenerator.main("src/comprehensive/test" + N + "2.g", 1);
				}
			}

			midpointTime = System.nanoTime();

			// Run an loop to capture the cost of the overhead
			for (long i = 0; i < timesToLoop; i++) 
			{
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
	
	public static String gen(int nt, int t) 
	{
		StringBuilder sb = new StringBuilder();
		
		//production rules for start non-terminal
		sb.append("{\n");
		sb.append("<start>\n");
		//<1>, <2>, ... <nt>
		for(int i = 1; i <= nt; i++)
			sb.append("<" + i + ">\n");
		sb.append("}\n");
		
		//production rules for each other non-terminal
		for(int i = 1; i<=nt; i++)
		{
			sb.append("{\n");
			sb.append("<" + i + ">\n");//nt name\
			sb.append(i + "\n");
			sb.append("}\n");
		}
		return sb.toString();
	}
}
