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

	private class BinaryNode<Type> 
	{

		private Type data;

		private BinaryNode<Type> leftChild;

		private BinaryNode<Type> rightChild;

		public BinaryNode(Type data, BinaryNode<Type> leftChild, BinaryNode<Type> rightChild) 
		{
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		public BinaryNode(Type data) 
		{
			this(data, null, null);
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
		public BinaryNode<Type> getLeftChild() 
		{
			return leftChild;
		}

		/**
		 * @param leftChild - reference of the left child node to be set
		 */
		public void setLeftChild(BinaryNode<Type> leftChild) 
		{
			this.leftChild = leftChild;
		}

		/**
		 * @return reference to the right child node
		 */
		public BinaryNode<Type> getRightChild() 
		{
			return rightChild;
		}

		/**
		 * @param rightChild - reference of the right child node to be set
		 */
		public void setRightChild(BinaryNode<Type> rightChild) 
		{
			this.rightChild = rightChild;
		}

		/**
		 * @return reference to the leftmost node in the binary tree rooted at this node
		 */
		public BinaryNode<Type> getLeftmostNode() 
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
		public BinaryNode<Type> getRightmostNode() 
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
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Removes all items from this set. The set will be empty after this method
	 * call.
	 */
	@Override
	public void clear() 
	{
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the first (i.e., smallest) item in this set.
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	@Override
	public Type first() throws NoSuchElementException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns true if this set contains no items.
	 */
	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the last (i.e., largest) item in this set.
	 * 
	 * @throws NoSuchElementException if the set is empty
	 */
	@Override
	public boolean remove(Type item) 
	{
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the number of items in this set.
	 */
	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns an ArrayList containing all of the items in this set, in sorted
	 * order.
	 */
	@Override
	public ArrayList<Type> toArrayList() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
