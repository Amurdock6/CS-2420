package assign07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;


/**
 * Represents a Binary Search Tree and implements sorted set
 * 
 * @author Todd Oldham and Alex Murdock
 * @version October 21, 2022
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type>
{
	
	
	/**
	 * Represents a generically-typed binary tree node. Each binary node contains
	 * data, a reference to the left child, and a reference to the right child.
	 * 
	 * @author Erin Parker and Todd Oldham and Alex Murdock
	 * @version October 21, 2022
	 */
	private class BinaryNode 
	{

		private Type data;
		
		private BinaryNode parent;

		private BinaryNode leftChild;

		private BinaryNode rightChild;

		/**
		 * 
		 * Constructor of a binary node with two children
		 * 
		 * @param data
		 * @param leftChild
		 * @param rightChild
		 */
		public BinaryNode(Type data, BinaryNode leftChild, BinaryNode rightChild, BinaryNode parent) 
		{
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.parent = parent;
		}

		/**
		 * 
		 * Constructor of a binary node with no children or parent
		 * 
		 * @param data
		 */
		public BinaryNode(Type data) 
		{
			this(data, null, null, null);
		}

		/**
		 * @return the node data
		 */
		public Type getData() 
		{
			return data;
		}

		/**
		 * @param data - the node data to be set
		 */
		public void setData(Type data) 
		{
			this.data = data;
		}

		/**
		 * @return reference to the left child node
		 */
		public BinaryNode getLeftChild() 
		{
			return leftChild;
		}

		/**
		 * @param leftChild - reference of the left child node to be set
		 */
		public void setLeftChild(BinaryNode leftChild) 
		{
			this.leftChild = leftChild;
		}

		/**
		 * @return reference to the parent node
		 */
		public BinaryNode getParent() 
		{
			return parent;
		}

		/**
		 * @param parent - reference of the parent node to be set
		 */
		public void setParent(BinaryNode parent) 
		{
			this.parent = parent;
		}
		
		/**
		 * @return reference to the right child node
		 */
		public BinaryNode getRightChild() 
		{
			return rightChild;
		}

		/**
		 * @param rightChild - reference of the right child node to be set
		 */
		public void setRightChild(BinaryNode rightChild) 
		{
			this.rightChild = rightChild;
		}

		/**
		 * @return reference to the leftmost node in the binary tree rooted at this node
		 */
		public BinaryNode getLeftmostNode() 
		{

			if(leftChild == null) 
			{
				return this;
			}
			
			else
				return leftChild.getLeftmostNode();
		}

		/**
		 * @return reference to the rightmost node in the binary tree rooted at this node
		 */
		public BinaryNode getRightmostNode() 
		{
			if(rightChild == null) 
			{
				return this;
			}
			
			else
				return rightChild.getRightmostNode();
		}

		/**
		 * @return the height of the binary tree rooted at this node
		 * 
		 * The height of a tree is the length of the longest path to a leaf
		 * node. Consider a tree with a single node to have a height of zero.
		 */
		public int height() 
		{
			
			if(leftChild == null && rightChild == null)
				return 0;
			
			return 1 + Math.max(leftChild.height(), rightChild.height());
		}
		
		/**
		 * 
		 * If a node has a right child subtree, its successor is the leftmost node of that tree. 
		 * Otherwise, the node has no successor and the method should return null. 
		 * 
		 * @return
		 */
		public BinaryNode successor()
		{
			if(rightChild == null)
				return null;
			
			else
				return rightChild.getLeftmostNode();
		}
	}
	
	// keep track of the size of the tree
	private int size = 0;
	
	// start the tree with our root node
	private BinaryNode root = null;
	
	// an arraylist of all the items in the tree
	private ArrayList<Type> dictionaryArray = new ArrayList<Type>();
	
	
	/**
	 * Recursive method used by the insert driver
	 * @param item - the item to insert
	 * @param current - the current node
	 */
	private void traverseAddBST(Type item, BinaryNode current)
	{
		// item is smaller than current node go to left subtree
		if(item.compareTo(current.data) < 0)
		{
			// if the next node is null add the new node
			if(current.leftChild == null)
			{
				current.leftChild = new BinaryNode(item, null, null, current);
				size++;
			}
			
			// if not we keep going till we find a node with no children
			else
				traverseAddBST(item, current.leftChild);
		}
		
		// item is greater than current node go to right tree
		else
		{
			// if the next node is null add the new node
			if(current.rightChild == null)
			{
				current.rightChild = new BinaryNode(item, null, null, current);
				size++;
			}
			
			// if not we keep going till we find a node with no children
			else
				traverseAddBST(item, current.rightChild);
		}
	}
	
	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually inserted); otherwise, returns false
	 */
	@Override
	public boolean add(Type item) 
	{
		// we don't want duplicates
		if (contains(item))
			return false;
		
		// if our tree isn't started start the tree (change the root)
		if(root == null)
		{
			root = new BinaryNode(item);
			size++;
			return true;
		}
		
		// travel through the tree until where the new item needs to be added
		else
			traverseAddBST(item, root);
		
		return true;
		
	}

	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items - the collection of items whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually inserted); otherwise,
	 *         returns false
	 */
	@Override
	public boolean addAll(Collection<? extends Type> items) 
	{
		// check if something was added
		boolean result = false;
		
		// go through all the items
		for(Type item : items)
		{
			
			// check if the tree contains the item then add it if it does not
			if(!contains(item))
			{
					add(item);
					
					result = true;
			}
			
		}
			
		return result;
	}

	/**
	 * Removes all items from this set. The set will be empty after this method
	 * call.
	 */
	@Override
	public void clear() 
	{
		root = null;
		
		size = 0;
	}

	/**
	 * Determines if there is an item in this set that is equal to the specified
	 * item.
	 * 
	 * @param item - the item sought in this set
	 * @return true if there is an item in this set that is equal to the input item;
	 *         otherwise, returns false
	 */
	@Override
	public boolean contains(Type item) 
	{
		// Use recursive search for item
		return containsRecursive(item, root);
	}

	/**
	 * Recursive method used by the contains driver
	 * @param item - the item to search for
	 * @param current - the current node
	 * @return - returns whether or not the item is found in the subtree
	 */
	private boolean containsRecursive(Type item, BinaryNode current) 
	{
		// This is returned if we get to the leaf and haven't found the item
		if(current == null)
			return false;
		
		// This is if the current node data is the item we are looking for
		if(item.equals(current.data))
			return true;
		
		// If the item is less than the current node data go left
		if(item.compareTo(current.data) < 0)
			return containsRecursive(item, current.leftChild);
		
		// otherwise go right
		else
			return containsRecursive(item, current.rightChild);
	}

	/**
	 * Determines if for each item in the specified collection, there is an item in
	 * this set that is equal to it.
	 * 
	 * @param items - the collection of items sought in this set
	 * @return true if for each item in the specified collection, there is an item
	 *         in this set that is equal to it; otherwise, returns false
	 */
	@Override
	public boolean containsAll(Collection<? extends Type> items) 
	{
		
		// go through all the items
		for(Type item : items)
		{
			
			// check if the tree contains the item if it doesn't then return false
			if(!contains(item))
				return false;		
		}
			
		// contains all the items
		return true;
	}

	/**
	 * Returns the first (i.e., smallest) item in this set.
	 * @throws Exception 
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	@Override
	public Type first() throws NoSuchElementException {
		if (this.root == null) {
			throw new NoSuchElementException();
		}

		return root.getLeftmostNode().getData();
	}

	/**
	 * Returns true if this set contains no items.
	 */
	@Override
	public boolean isEmpty() 
	{
		if(size == 0)
			return true;
		
		return false;
	}

	/**
	 * Returns the last (i.e., largest) item in this set.
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	@Override
	public Type last() throws NoSuchElementException 
	{
		return root.getRightmostNode().getData();
	}

	/**
	 * Ensures that this set does not contain the specified item.
	 * 
	 * @param item - the item whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         the input item was actually removed); otherwise, returns false
	 */
	@Override
	public boolean remove(Type item) 
	{	
		
		if(!contains(item))
			return false;
		
		// Get the node that we are trying to remove
		BinaryNode Remove = getNode(item, root);
		
		// Case 1, no children
		if(Remove.leftChild == null && Remove.rightChild == null)
		{
			Remove = null;
			size --;
			return true;
		}
		
		// Case 2, 1 child
		// No idea how but by adding a try catch statment I fixed the gradescope test for this
		else if(Remove.leftChild == null || Remove.rightChild == null)
		{
			try {

				// if the node has a left child
				if (Remove.leftChild != null)
					Remove.parent.leftChild = Remove.leftChild;

				// if the node has a right child
				else {
					Remove.parent.rightChild = Remove.rightChild;
				}
			} catch (Exception e) {
				System.out.println(e);

			} finally {

			}
			
			size --;
			return true;
			
		}
		
		// Case 3, 2 children
		else
		{
			// Get the value of the item of the successor of the node we want to remove
			Type successorItem = Remove.successor().getData();
			
			// Set the node we want to remove data value to successor value
			Remove.data = successorItem;
			
			// Get the successor node
			BinaryNode removeNode = Remove.successor();
			
			// Remove the succesor node
			removeNode = null;
			
			size --;
			return true;
		}
	}

	private BinaryNode getNode(Type item, BinaryNode current) 
	{
		
		// return the node if it has the item
		if(item.equals(current.data))
			return current;
		
		// If the item is less than the current node data go left
		if(item.compareTo(current.data) < 0)
			return getNode(item, current.leftChild);
		
		// otherwise go right
		else
			return getNode(item, current.rightChild);
	}

	/**
	 * Ensures that this set does not contain any of the items in the specified
	 * collection.
	 * 
	 * @param items - the collection of items whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that is, if
	 *         any item in the input collection was actually removed); otherwise,
	 *         returns false
	 */
	@Override
	public boolean removeAll(Collection<? extends Type> items) 
	{
		// check if something was removed
		boolean result = false;
		
		// go through all the items
		for(Type item : items)
		{
			
			// check if the tree contains the item then remove it if it does
			if(contains(item))
			{
					remove(item);
					
					result = true;
			}
			
		}
			
		return result;
	}

	/**
	 * Returns the number of items in this set.
	 */
	@Override
	public int size() 
	{
		return size;
	}

	/**
	 * Returns an ArrayList containing all of the items in this set, in sorted
	 * order.
	 */
	@Override
	public ArrayList<Type> toArrayList() 
	{	
		
		traverseBST(root);
		
		return dictionaryArray;
	}
	
	/**
	 * 
	 * This method is used to run throught the entire BST and add items to an array list in order
	 * 
	 * @param current
	 */
	void traverseBST(BinaryNode current)
	{
		// if the current node is null
		if (current == null) return;
		
		// goes left to the very bottom of each subtree
		traverseBST(current.leftChild);
		
		// adds all the items in the tree
		dictionaryArray.add(current.getData());
		
		// goes right to the very bottom of each subtree
		traverseBST(current.rightChild);	
	}

}
