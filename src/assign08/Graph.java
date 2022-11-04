package assign08;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;



/**
 * 
 * @author Daniel Kopta and Todd Oldham and Alex Murdock
 * This Graph class acts as a starting point for your maze path finder.
 * Add to this class as needed.
 */
public class Graph {

	// The graph itself is just a 2D array of nodes
	private Node[][] nodes;
	
	// The node to start the path finding from
	private Node start;
	
	// The size of the maze
	private int width;
	private int height;
	
	/**
	 * Constructs a maze graph from the given text file.
	 * @param filename - the file containing the maze
	 * @throws Exception
	 */
	public Graph(String filename) throws Exception
	{
		BufferedReader input;
		input = new BufferedReader(new FileReader(filename));

		if(!input.ready())
		{
			input.close();
			throw new FileNotFoundException();
		}

		// read the maze size from the file
		String[] dimensions = input.readLine().split(" ");
		height = Integer.parseInt(dimensions[0]);
		width = Integer.parseInt(dimensions[1]);

		// instantiate and populate the nodes
		nodes = new Node[height][width];
		for(int i=0; i < height; i++)
		{
			String row = input.readLine().trim();

			for(int j=0; j < row.length(); j++)
				switch(row.charAt(j))
				{
				case 'X':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isWall = true;
					break;
				case ' ':
					nodes[i][j] = new Node(i, j);
					break;
				case 'S':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isStart = true;
					start = nodes[i][j];
					break;
				case 'G':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isGoal = true;
					break;
				default:
					throw new IllegalArgumentException("maze contains unknown character: \'" + row.charAt(j) + "\'");
				}
		}
		input.close();
	}
	
	/**
	 * Outputs this graph to the specified file.
	 * Use this method after you have found a path to one of the goals.
	 * Before using this method, for the nodes on the path, you will need 
	 * to set their isOnPath value to true. 
	 * 
	 * @param filename - the file to write to
	 */
	public void printGraph(String filename)
	{
		try
		{
			PrintWriter output = new PrintWriter(new FileWriter(filename));
			output.println(height + " " + width);
			for(int i=0; i < height; i++)
			{
				for(int j=0; j < width; j++)
				{
					output.print(nodes[i][j]);
				}
				output.println();
			}
			output.close();
		}
		catch(Exception e){e.printStackTrace();}
	}

	
	
	/**
	 * Traverse the graph with BFS (shortest path to closest goal)
	 * A side-effect of this method should be that the nodes on the path
	 * have had their isOnPath member set to true.
	 * @return - the length of the path
	 */
	public int CalculateShortestPath()
	{

		start.visited = true;
		start.isOnPath = true;
		
		LinkedList<Node> nodeQueue = new LinkedList<Node>();
		
		nodeQueue.offer(start);
		
		while(!nodeQueue.isEmpty())
		{
			Node current = nodeQueue.poll();
			if(current.isGoal == true)
			{
				while(current.isStart == false)
				{
					current.isOnPath = true;
					current = current.cameFrom;
				}
				return 0;
			}
			
			current.neighbors[0] = nodes[current.x - 1][current.y];
			current.neighbors[1] = nodes[current.x + 1][current.y];
			current.neighbors[2] = nodes[current.x][current.y - 1];
			current.neighbors[3] = nodes[current.x][current.y + 1];
			
			for(Node neighborNode : current.neighbors)
			{
				if(!neighborNode.visited && !neighborNode.isWall)
				{
					neighborNode.visited = true;
					neighborNode.cameFrom = current;
					nodeQueue.offer(neighborNode);
				}
			}
		}
		
		return 0;
	}

	
	/**
	 * Traverse the graph with DFS (any path to any goal)
	 * A side-effect of this method should be that the nodes on the path
	 * have had their isOnPath member set to true.
	 * @return - the length of the path
	 */
	public int CalculateAPath()
	{
		// TODO: Fill in this method
		start.visited = true;
		start.isOnPath = true;

		Stack<Node> stack = new Stack<Node>();
		
		stack.push(start);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			
			if (current.isGoal == true) {
				while(current.isStart == false)
				{
					current.isOnPath = true;
					current = current.cameFrom;
				}
				
				return 0;
			}
			
			if (!current.visited) {
				current.visited = true;

				// gets neigbours of current Node
				current.neighbors[0] = nodes[current.x - 1][current.y];
				current.neighbors[1] = nodes[current.x + 1][current.y];
				current.neighbors[2] = nodes[current.x][current.y - 1];
				current.neighbors[3] = nodes[current.x][current.y + 1];
				
				for(Node neighborNode : current.neighbors)
				{
					if(!neighborNode.visited && !neighborNode.isWall)
					{
						neighborNode.visited = true;
						neighborNode.cameFrom = current;
						stack.push(neighborNode);
					}
				}
				
			}
		}
		return 0;
	}

	
	/**
	 * @author Daniel Kopta and Todd Oldham and Alex Murdock
	 * 	A node class to assist in the implementation of the graph.
	 * 	You will need to add additional functionality to this class.
	 */
	private static class Node
	{
		// The node's position in the maze
		private int x, y;
		
		// The type of the node
		private boolean isStart;
		private boolean isGoal;
		private boolean isOnPath;
		private boolean isWall;
		private boolean visited;
		private Node cameFrom;
		private Node[] neighbors = new Node[4];
				
		public Node(int _x, int _y)
		{
			isStart = false;
			isGoal = false;
			isOnPath = false;
			visited = false;
			
			x = _x;
			y = _y;
			
			cameFrom = null;
			
		}
		
		@Override
		public String toString()
		{
			if(isWall)
				return "X";
			if(isStart)
				return "S";
			if(isGoal)
				return "G";
			if(isOnPath)
				return ".";
			return " ";
		}
	}
	
}
