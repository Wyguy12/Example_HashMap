package com.wyattfredrickson;
import java.util.LinkedList;


/**
 * Custom HashMap class that implements the IHashMap interface
 * 
 * Collision-Strategy is seperate chaining because 
 * 
 */
public class HashMap<K, V> implements IHashMap<K, V> {
    private static int MAXIMUM_CAPACITY = 1 << 30; // This value is = 2^30 = 1073741824 maximum capacity of the hashmap

    private int DEFAULT_INITIAL_CAPACITY = 100; // default initial capacity of the hashmap is 100
    private int capacity; // variable to store the capacity of the hashmap

    private static float DEFAULT_LOAD_FACTOR = 0.75f; // variable to store the default load factor of the hashmap
    private float loadFactorThreshold; // variable to store the load factor of the hashmap

    private int size = 0; // variable to store the size of the hashmap


    LinkedList<IHashMap.Entry<K, V>>[] table; // New HashTable, that creates an Array of LinkedLists where each element(Bucket) 
                                              // of the Array will store a LinkedList containing an entry of key value-pairs.

    /**
     * Default constructor that initializes the capacity and load factor threshold of the hashmap
     * size = 100
     * Threshold - 0.75f
     */
    public HashMap() {
        this.capacity = DEFAULT_INITIAL_CAPACITY; // Assign the default initial capacity to the capacity - size 100
        this.loadFactorThreshold = DEFAULT_LOAD_FACTOR; // Assign the default load factor to the load factor threshold - 0.75f 
        table = new LinkedList[capacity];
    }
    
    /**
     * Method that gets the hash value of the key
     */
    @Override
    public V get(K key) {
        int theBucketIndex = key.hashCode(); // Generate the hash value of the key and assign it to theBucketIndex variable
        if (table[theBucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[theBucketIndex]; // Create a new Hash table of Arrays to store the key inside of the individual buckets of the linkedlist
            for (Entry<K, V> entry: bucket)
                if (entry.getKey().equals(key))
                    return entry.getValue();
        }
        return null;
    }

    /**
     * Method returns true if the map is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0; // if the size of the hashmap is 0, then the hashmap is empty
    }

    /**
     * Method for putting a key value-pair into the hashmap
     */
    @Override
    public V put(K key, V value) {
        if (get(key) != null) {
            int theBucketIndex = key.hashCode(); // Generate the hash value of the key and assign it to theBucketIndex variable
            LinkedList<Entry<K, V>> bucket = table[theBucketIndex]; // Create a new Hash table of Arrays to store the key inside of the individual buckets of the linkedlist
            for (Entry<K, V> entry: bucket) // Iterate through the Entry data structure bucket by bucket to place an entry 
                if(entry.getKey().equals(key)) { // If entry key matches the instance key value 
                    V theOldValue = entry.getValue(); // Get the value of the entry and place the value into the V object reference variable theOldValue
                    entry.value = value; // Now replace the old value with the new value
                    return theOldValue; // Return the old value for the key
                }
        }
        // Checking the load capacity and rehashing the table if need be
        if (size >= capacity * loadFactorThreshold) {
            if (capacity == MAXIMUM_CAPACITY)
                throw new RuntimeException("Exceeding the maximum capacity!");

            rehash(); // Call the rehash method to double the capacity of the hash table Array if the capacity has been reached
        }
            // Checking if the Hashtable is null and if it is then create a new bucket to store key value-pairs
            int theBucketIndex = key.hashCode(); // Generate the hash value of the key and assign it to theBucketIndex variable   
            if (table[theBucketIndex] == null) { // If the bucket is empty
                table[theBucketIndex] = new LinkedList<Entry<K, V>>(); // Create a new LinkedList to store the key value-pairs
            }
            table[theBucketIndex].add(new HashMap.Entry<K, V>(key, value)); // Add the key value-pair to the bucket of the LinkedList in the HashTable
            size ++; // Increase the size 
            return value; // And return the updated value
    }

    /**
     * Method for removing a key value-pair from the hashmap
     */
    @Override
    public V remove(K key) {
        if (get(key) == null) // If the key is not found in the hashmap then
            return null; // Return null
        int theBucketIndex = key.hashCode(); // Generate the hash value of the key and assign it to theBucketIndex variable
        if (table[theBucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[theBucketIndex];
            for (Entry<K, V> entry: bucket) {
                if (entry.getKey().equals(key)) {// If the entry key matches the instance keys value
                    V removedValue = entry.getValue(); // Get the value of the entry and place the value into the V object reference variable removedValue
                    bucket.remove(entry); // Then remove the entry from the bucket if it equals
                    size--; // Decrease the HashTable by 1
                    return removedValue; // Return the removed value of the key
                }
            }    
        }
        return null;
    }

    /**
     * Method for returning the size of the hashmap
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Method for reshasing the hashmap when the load factor threshold is reached maximum capacity
     */
    private void rehash() {
        if (capacity == MAXIMUM_CAPACITY) // If the capacity is equal to the maximum capacity then return
            return;

        if (size >= capacity * loadFactorThreshold) { // If the size is greater than or equal to the capacity multiplied by the load factor threshold
            int newCapacity = capacity * 2; // Then double the capacity of the hash table Array and assign it to the newCapacity variable
            LinkedList<Entry<K, V>>[] newTable = new LinkedList[newCapacity];
            size = 0; // Reset the size of the hash table to 0

            for (LinkedList<Entry<K, V>> bucket : table) { // Iterate through the Entry data structure bucket by bucket to place an entry
                if (bucket != null) {
                    for (Entry<K, V> entry : bucket) {
                        int newIndex = hash(entry.getKey()) % newCapacity;
                        if (newTable[newIndex] == null) {
                            newTable[newIndex] = new LinkedList<>();
                        }
                        newTable[newIndex].add(entry); // Assign the entry to the new table
                        size++; // Increase the size of the hash table by 1
                    }
                }
            }
            table = newTable; // Assign the new table to the table
            capacity = newCapacity; // Assign the new capacity to the capacity
        }    
    }

    /**
     * Method for generating the hash value of the key
     * @param key the key to generate the hash value
     * @return the hash value of the key
     */
    private int hash(K key) {
        int hashCode = key.hashCode(); // Get the hash code of the key
        return supplementalHash(hashCode) & (capacity - 1); // Return the hash value of the key by using the supplemental hash method
    }

    /**
     * Method for generating the supplemental hash value of the key to avoid clustering further
     * @param h the hash code of the key
     * @return the supplemental hash value of the key
     */
    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12); // Apply the XOR operation to the hash code and shift the bits to the right by 20 and 12 then store the result in h
        return h ^ (h >>> 7) ^ (h >>> 4); // Now apply the XOR operation to the hash code and shift the bits to the right by 7 and 4 then return the result of h
    }
}