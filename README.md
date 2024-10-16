Project Overview
The Car Information Management System is a program that stores information about cars, including the car's make, type, owner, license plate, and state of registration. The system uses a custom HashMap implementation to store and retrieve CarInfo objects. The HashMap uses separate chaining to handle collisions, and the key for each car is generated using the hash code of its license plate and state.

Key Features
Custom HashMap Implementation: The system implements a custom HashMap that uses separate chaining to manage collisions. The HashMap supports operations like inserting, retrieving, and removing key-value pairs.


CarInfo Class: Represents detailed information about a car, including:
make: The make of the car.
type: The type of the car (e.g., sedan, SUV, pickup).
owner: The owner of the car.
licensePlate: The license plate number.
licenseState: The state where the car's license plate was issued.

Classes
1. CarInfo Class
Stores detailed information about the car such as the make, type, owner, license state, and license plate.
Implements:
hashCode(): Generates a hash code based on the license plate and license state.
equals(): Compares two CarInfo objects based on their license plate and license state.
toString(): Returns a string representation of the car's details.

2. HashMap Class
Implements a custom HashMap using separate chaining (with linked lists) to manage collisions.
Key operations include:
put(K key, V value): Inserts or updates a key-value pair in the hash map.
get(K key): Retrieves the value associated with the given key.
remove(K key): Removes the key-value pair associated with the given key.
size(): Returns the number of key-value pairs in the hash map.
The HashMap automatically rehashes (doubles in size) when the load factor threshold is reached.

3. IHashMap Interface
Defines the methods that the custom HashMap must implement, including:
get(K key): Retrieves the value associated with the key.
isEmpty(): Returns true if the map is empty.
put(K key, V value): Inserts a key-value pair into the map.
remove(K key): Removes the key-value pair associated with the key.
size(): Returns the size of the map.
Also defines the Entry inner class that holds key-value pairs in the HashMap.

Random CarInfo Generator
The program generates random car information using arrays of makes, types, owners, license states, and license plates. The generateRandomCarInfo method creates 100 random CarInfo objects and stores them in the custom HashMap.

Car Makes: Randomly generated list of car makes (e.g., Honda, Ford, Tesla).
Car Types: Randomly generated list of car types (e.g., sedan, SUV, pickup).
Car Owners: Randomly generated list of owner names.
License States: Randomly generated list of state abbreviations.
License Plates: Randomly generated list of license plates.