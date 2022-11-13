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
		
		// return true if the index of the list of the index of the table is not null otherwise false
		return table.get(index).contains(key);

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
		return table.contains(value);
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
		
		// if the linked list doesn't contain the key return null
		if(!table.get(index).contains(key))
			return null;
		
		else
		{
			// get the index of the key in the linked list
			int finalIndex = table.get(index).indexOf(key);
			
			// return the value of the item in the linked list at the index of the table we are searching for
			return table.get(index).get(finalIndex).getValue();
		}
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
		
		// take the value of key divided by table length, use the remainder to determine index
		index = key.hashCode() % table.size();
		
		if(!containsKey(key))
		{
			
			// increase size
			size++;
			
			// change the load factor magnitude
			loadFactor = size / capacity;
			
			// if the load factor is too big rehash the table
			if(loadFactor > 9)
				growRehash();
			
			// add an item at the index
			table.get(index).add(new MapEntry<K, V>(key, value));
			
			// return null since the key didn't exist
			return null;
		}
		
		else
		{
			// get the index of the key in the linked list
			int finalIndex = table.get(index).indexOf(key);
			
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
		
		// take the value of key divided by table length, use the remainder to determine index
		index = key.hashCode() % table.size();
		
		if(!containsKey(key))
			return null;
		
		else
		{
			
			//reduce size
			size--;
			
			// get the index of the key in the linked list
			int finalIndex = table.get(index).indexOf(key);
			
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
