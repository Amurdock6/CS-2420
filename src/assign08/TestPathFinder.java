package assign08;

/**
 * 
 * @author Daniel Kopta
 * This class shows an example of how to run your pathfinder.
 */
public class TestPathFinder {

	
	public static void main(String[] args) {	
		/*
		 * The below code assumes you have a folder called assignment8_files 
		 * in your project folder, and in that folder is a file called bigMaze.txt.
		 * If your solution is implemented correctly, it will produce a file called
		 * testOutput.txt which has the solution to the maze.
		 * You will have to browse to that folder to view the output, it will not 
		 * automatically show up in Eclipse.
		 * testOutput1.txt - solution maze with shortest path to closest goal
		 * testOutput2.txt - solution maze with any path to any goal
		 */
		
		// Run the pathfinder with a final argument of true to find the shortest path to the closest goal
		PathFinder.solveMaze("C:\\Users\\todd-\\OneDrive\\Documents\\GitHub\\CS-2420\\src\\assign08Resources\\pacmanPy3\\problem5.txt", "C:\\Users\\todd-\\OneDrive\\Documents\\GitHub\\CS-2420\\src\\assign08Resources\\pacmanPy3\\testOutput1.txt", true);
		// Run the pathfinder with a final argument of false to find any path to any goal
		PathFinder.solveMaze("C:\\Users\\todd-\\OneDrive\\Documents\\GitHub\\CS-2420\\src\\assign08Resources\\pacmanPy3\\problem5.txt", "C:\\Users\\todd-\\OneDrive\\Documents\\GitHub\\CS-2420\\src\\assign08Resources\\pacmanPy3\\testOutput2.txt", false);

	}
}
