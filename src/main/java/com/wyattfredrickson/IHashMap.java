package com.wyattfredrickson;


/**
 * Interface IHashMap<K, V> that defines the methods,
 * for a custom HashMap implementation that takes in a key and a value pair
 */
public interface IHashMap<K, V> {
    /**
     * Gets the value associated with the key
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    public V get(K key);

    /**
     * Returns true if this map contains no key-value mappings
     * @return true if this map contains no key-value mappings
     */
    public boolean isEmpty();

    /**
     * Places a key-value pair into the map
     * @param key the key
     * @param value the value
     * @return the previous value associated with key, or null if there was no mapping for key
     */
    public V put(K key, V value); 

    /**
     * Removes the mapping for a key from this map if it is present
     * @param key the key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key
     */
    public V remove(K key);

    /**
     * Returns the number of key-value mappings in this map
     * @return the number of key-value mappings in this map
     */
    public int size();
    





    /**
     * Define an inner class for "Entries" that will be used to store key-value pairs
     * Using a static inner class since it does not need to access any instance variables of the outer class
     */
    public static class Entry<K, V> {
        K key; 
        V value;

        /**
         * Constructs an individual entry object with a key and value pair
         * @param key the key
         * @param value the value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        /**
         * Getter methods for the key and value
         * Returns the key & value pair
         * @return the key & value pair
         */
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value; 
        }

        /**
         * toString method that returns the key and value pair
         */
        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}