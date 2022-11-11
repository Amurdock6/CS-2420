package assign07;

import java.io.FileWriter;
import java.io.PrintWriter;



/**
 * 
 * @author Daniel Kopta
 * In-class demo of a binary search tree.
 * Note that this BST only holds strings.
 * This class uses recursive methods, but iterative
 * solutions exist as well.
 *
 */
public class BST {

	BinaryNode root;

	public BST()
	{
		root = null;
	}

	
	private class BinaryNode {

		String data;
		BinaryNode left;
		BinaryNode right;

		public BinaryNode(String d) {
			data = d;
			left = null;
			right = null;
		}

	}


	/**
	 * Driver method for inserting an item
	 * @param s - the item to insert
	 */
	public void insert(String s)
	{
		if(root == null)
			root = new BinaryNode(s);
		else
			insertRecursive(s, root);
	}
	
	

	/**
	 * Recursive method used by the insert driver
	 * @param s - the item to insert
	 * @param n - the current node
	 */
	private void insertRecursive(String s, BinaryNode n)
	{
		// need to go left
		if(s.compareTo(n.data) < 0)
		{
			if(n.left == null)
				n.left = new BinaryNode(s);
			else
				insertRecursive(s, n.left);
		}
		
		// need to go right
		else
		{
			if(n.right == null)
				n.right = new BinaryNode(s);
			else
				insertRecursive(s, n.right);
		}
		
	}


	/**
	 * Driver method for searching for an item
	 * @param s - the item to search for
	 * @return - returns whether or not the item is found
	 */
	public boolean contains(String s)
	{
		return searchRecursive(s, root);
	}

	/**
	 * Recursive method used by the contains driver
	 * @param s - the item to search for
	 * @param n - the current node
	 * @return - returns whether or not the item is found in the subtree
	 */
	private boolean searchRecursive(String s, BinaryNode n)
	{
		if(n == null)
			return false;
		
		if(s.equals(n.data))
			return true;
		
		if(s.compareTo(n.data) < 0)
			return searchRecursive(s, n.left);

		else
			return searchRecursive(s, n.right);
		
	}


	/**
	 * Writes the tree to a dot file
	 * @param filename - the file to write to
	 */
	public void writeDot(String filename)
	{
		try {
			// PrintWriter(FileWriter) will write output to a file
			PrintWriter output = new PrintWriter(new FileWriter(filename));

			// Set up the dot graph and properties
			output.println("digraph BST {");
			output.println("node [shape=record]");

			if(root != null)
				writeDotRecursive(root, output);
			// Close the graph
			output.println("}");
			output.close();
		}
		catch(Exception e){e.printStackTrace();}
	}
	
		
	/**
	 * Recursive helper for writing this tree to a dot file
	 * @param n - the current subtree
	 * @param output - a PrintWriter with an open output file
	 * @throws Exception
	 */
	private void writeDotRecursive(BinaryNode n, PrintWriter output) throws Exception
	{
		output.println(n.data + "[label=\"<L> |<D> " + n.data + "|<R> \"]");
		if(n.left != null)
		{ 
			// write the left subtree
			writeDotRecursive(n.left, output);

			// then make a link between n and the left subtree
			output.println(n.data + ":L -> " + n.left.data + ":D" );
		}
		if(n.right != null)
		{
			// write the left subtree
			writeDotRecursive(n.right, output);

			// then make a link between n and the right subtree
			output.println(n.data + ":R -> " + n.right.data + ":D" );
		}
	}
}


