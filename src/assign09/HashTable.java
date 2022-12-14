package assign09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * This class implements the map interface and represents a map of keys to values. It cannot contain
 * duplicate keys, and each key can map to at most one value.
 * 
 * @author Todd Oldham & Alex Murdock
 * @version 11/12/2022
 *
 * @param <K> - placeholder for key type
 * @param <V> - placeholder for value type
 */
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
	
	// COLLISIONS!
	private int collisions = 0;
	
	public int getCollisions()
	{
		return collisions;
	}
	
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
		
		// create a new ArrayList that is temporary to keep track of the entries
		ArrayList<LinkedList<MapEntry<K, V>>> tableTemp = new ArrayList<LinkedList<MapEntry<K, V>>>();
		
		tableTemp = table;
		
		// set table to a new array list
		table = new ArrayList<LinkedList<MapEntry<K, V>>>();
		
		// double the capacity
		capacity = capacity * 2;
		
		// add the empty linked lists to the new array list
		table = new ArrayList<LinkedList<MapEntry<K, V>>>();
		for(int i = 0; i < capacity; i++)
		   table.add(new LinkedList<MapEntry<K, V>>());
		
		// set size to zero
		size = 0;
		
		// rehash all of the items in table 
		
		// go through all the indices of table temp which was the old table
		for(int i = 0; i < tableTemp.size(); i++)
			// go through each item in each linked list in the table
			for(int j = 0; j < tableTemp.get(i).size(); j++)
				// if the item is not null
				if(tableTemp.get(i).get(j) != null)
					// add the item to the new table with twice the capacity
					put(tableTemp.get(i).get(j).getKey(), tableTemp.get(i).get(j).getValue());
		
		size++;
		
	}
	
	/**
	 * Removes all mappings from this map.
	 * 
	 * O(table length)
	 */
	@Override
	public void clear() 
	{
		// clear the arrayList
		table.clear();
		
		// set size to zero
		size = 0;
		
		// add in empty linked lists to the array list
		for(int i = 0; i < capacity; i++)
			   table.add(new LinkedList<MapEntry<K, V>>());
		
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
		index = key.hashCode() % table.size();
		
		if(index == Integer.MIN_VALUE)
			index++;
		
		index = Math.abs(index);
		
		// go through each item in the linked list to see if the key matches the key provided
		for(int j = 0; j < table.get(index).size(); j++)
		{
			if(j > 0)
				collisions++;
			
			if(table.get(index).get(j).getKey().equals(key))
				return true;
		}
		
		return false;
		

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
		// go through each index in the table
		for(int i = 0; i < capacity; i++)
			// go through each item in the linked list at the table index
			for(int j = 0; j < table.get(i).size(); j++)
			{
				
				if(j > 0)
					collisions++;
				
				// if the value of the linked list index matches the provided value return true
				if(table.get(i).get(j).getValue().equals(value))
					return true;
			}
		
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
		// create a tableList
		ArrayList<MapEntry<K,V>> tableList = new ArrayList<MapEntry<K, V>>();
		
		// go through each index in the table
		for(int i = 0; i < capacity; i++)
			// go through each item in the linked list at the table index
			for(int j = 0; j < table.get(i).size(); j++)
				// if the index of the linked list has an item add it to the list
				if(table.get(i).get(j) != null)
					tableList.add(table.get(i).get(j));
		
		return tableList;
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
		// set index variable
		int index;
		
		// take the value of key divided by table length, use the remainder to determine index
		index = key.hashCode() % table.size();
		
		if(index == Integer.MIN_VALUE)
			index++;
		
		index = Math.abs(index);
		
		// if the linked list contains the key return true
		for(int j = 0; j < table.get(index).size(); j++)
		{
			if(j > 0)
				collisions++;
			
			
			if(table.get(index).get(j).getKey().equals(key))
				return table.get(index).get(j).getValue();
		}
		
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
		
		// set index variable
		int index;
		int finalIndex = 0;
		
		// take the value of key divided by table length, use the remainder to determine index
		index = key.hashCode() % table.size();
		
		if(index == Integer.MIN_VALUE)
			index++;
		
		index = Math.abs(index);
		
		if(!containsKey(key))
		{
			
			// increase size
			size++;
			
			// change the load factor magnitude
			loadFactor = size / capacity;
			
			// if the load factor is too big rehash the table
			if(loadFactor >= 9)
				growRehash();
			
			// add an item at the index
			table.get(index).add(new MapEntry<K, V>(key, value));
			
			if(table.get(index).size() > 1)
				collisions ++;
			
			// return null since the key didn't exist
			return null;
		}
		
		else
		{
			// get the index of the key in the linked list
			for(int j = 0; j < table.get(index).size(); j++)
				if(table.get(index).get(j).getKey().equals(key))
					finalIndex = j;
			
			// get the old value from the item with the key
			V oldValue = table.get(index).get(finalIndex).getValue();
			
			// set the value to the new value
			table.get(index).get(finalIndex).setValue(value);
			
			// return the old value
			return oldValue;
		}
			
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
		
		// set index variable
		int index;
		int finalIndex = 0;
		
		// take the value of key divided by table length, use the remainder to determine index
		index = key.hashCode() % table.size();
		
		if(index == Integer.MIN_VALUE)
			index++;
		
		index = Math.abs(index);
		
		if(!containsKey(key))
			return null;
		
		else
		{
			
			//reduce size
			size--;
			
			// get the index of the key in the linked list
			for(int j = 0; j < table.get(index).size(); j++)
				if(table.get(index).get(j).getKey().equals(key))
					finalIndex = j;
			
			// get the old value from the item with the key
			V oldValue = table.get(index).get(finalIndex).getValue();
			
			//
			table.get(index).remove(finalIndex);
			
			// return the old value
			return oldValue;
		}
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
