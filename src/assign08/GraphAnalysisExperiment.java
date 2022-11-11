package assign08;

public class GraphAnalysisExperiment 
{
	//Design and conduct an experiment to compare BFS to DFS performance. 
	//We recommend using random mazes that are at least 50x50 with 30% wall density and 5 goals 
	//(see the provided random maze generator). 
	//On average, does DFS or BFS require searching more nodes before finding a goal? 
	//You do not need to take thousands of samples like in previous analysis assignments, but you should use at least 10 random mazes.

	public static void main(String[] args) 
	{
		
		for(int i = 0; i < 10; i ++)
		{
		
		MazeGen.randomMaze("C:\\Users\\todd-\\OneDrive\\Documents\\GitHub\\CS-2420\\src\\assign08Resources\\pacmanPy3/problem5.txt", 50, 0.3, 5);
		// Run the pathfinder with a final argument of true to find the shortest path to the closest goal
		PathFinder.solveMaze("C:\\Users\\todd-\\OneDrive\\Documents\\GitHub\\CS-2420\\src\\assign08Resources\\pacmanPy3\\problem5.txt", "C:\\Users\\todd-\\OneDrive\\Documents\\GitHub\\CS-2420\\src\\assign08Resources\\pacmanPy3\\testOutput1.txt", true);
		// Run the pathfinder with a final argument of false to find any path to any goal
		PathFinder.solveMaze("C:\\Users\\todd-\\OneDrive\\Documents\\GitHub\\CS-2420\\src\\assign08Resources\\pacmanPy3\\problem5.txt", "C:\\Users\\todd-\\OneDrive\\Documents\\GitHub\\CS-2420\\src\\assign08Resources\\pacmanPy3\\testOutput2.txt", false);
		
		}
	}
	
}
