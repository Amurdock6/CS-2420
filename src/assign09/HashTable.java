package assign09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> implements Map<K, V>
{

	// table for all of our entries
	private ArrayList<LinkedList<MapEntry<K, V>>> table;
	
	// keep track of number of entries
	private int size = 0;
	
	// keep track of number of indices or buckets of the table
	private int capacity = 100;
	
	// keep track of load factor
	private double loadFactor = 0;
	
	/**
	 * 
	 * Constructor to create hashTable
	 * 
	 */
	public HashTable()
	{
		table = new ArrayList<LinkedList<MapEntry<K, V>>>();
		for(int i = 0; i < capacity; i++)
		   table.add(new LinkedList<MapEntry<K, V>>());
	}
	
	/**
	 * 
	 * If the load factor gets too big grow the array and rehash all of the items in the old table
	 * 
	 */
	public void growRehash()
	{
		
		// double the capacity
		capacity = capacity * 2;
		
		// create a new ArrayList that is temporary
		ArrayList<LinkedList<MapEntry<K, V>>> tableTemp = new ArrayList<LinkedList<MapEntry<K, V>>>();
		
		// add linked lists to fill the capacity
		for(int i = 0; i < capacity; i++)
		   tableTemp.add(new LinkedList<MapEntry<K, V>>());
		
		// rehash all of the items in table 
		for(MapEntry<K, V> e : this.entries())
		{
			put(e.getKey(), e.getValue());
		}
		
		table = tableTemp;
		
	}
	
	/**
	 * Removes all mappings from this map.
	 * 
	 * O(table length)
	 */
	@Override
	public void clear() 
	{
		table.clear();
		size = 0;		
	}

	/**
	 * Determines whether this map contains the specified key.
	 * 
	 * O(1)
	 * 
	 * @param key
	 * @return true if this map contains the key, false otherwise
	 */
	@Override
	public boolean containsKey(K key) 
	{
		// set index variable
		int index;
		
		// take the value of key divided by table length, use the remainder to determine index
		index = (int)key % table.size();	
		
		// retrun true if the index of the list of the index of the table is not null otherwise false
		return table.get(index).get((int)key) != null;

	}

	/**
	 * Determines whether this map contains the specified value.
	 * 
	 * O(table length)
	 * 
	 * @param value
	 * @return true if this map contains one or more keys to the specified value,
	 *         false otherwise
	 */
	@Override
	public boolean containsValue(V value) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns a List view of the mappings contained in this map, where the ordering of 
	 * mapping in the list is insignificant.
	 * 
	 * O(table length)
	 * 
	 * @return a List object containing all mapping (i.e., entries) in this map
	 */
	@Override
	public List<MapEntry<K, V>> entries() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the value to which the specified key is mapped.
	 * 
	 * O(1)
	 * 
	 * @param key
	 * @return the value to which the specified key is mapped, or null if this map
	 *         contains no mapping for the key
	 */
	@Override
	public V get(K key) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Determines whether this map contains any mappings.
	 * 
	 * O(1)
	 * 
	 * @return true if this map contains no mappings, false otherwise
	 */
	@Override
	public boolean isEmpty() 
	{
		if(size() == 0)
			return true;
		
		else
			return false;
	}

	/**
	 * Associates the specified value with the specified key in this map.
	 * (I.e., if the key already exists in this map, resets the value; 
	 * otherwise adds the specified key-value pair.)
	 * 
	 * O(1)
	 * 
	 * @param key
	 * @param value
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key
	 */
	@Override
	public V put(K key, V value) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Removes the mapping for a key from this map if it is present.
	 * 
	 * O(1)
	 *
	 * @param key
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key
	 */
	@Override
	public V remove(K key) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Determines the number of mappings in this map.
	 * 
	 * O(1)
	 * 
	 * @return the number of mappings in this map
	 */
	@Override
	public int size() 
	{
		return size;
	}
	
}
