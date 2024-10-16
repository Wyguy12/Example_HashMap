package com.wyattfredrickson;
import java.util.HashMap;
import java.util.Random;

/**
 * Sources:
 * Introduction to Java Programming and Data Structures, Comprehensive Version, 12th Edition - Y. Daniel Liang
 */


/**
 * The Main class will implement methods for testing the functionality of the custom HashMap implementation. 
 */
public class Main {

    /**
     * Method that displays the developer information
     */
    public void displayDeveloperInfo() {
        System.out.println("Wyatt Fredrickson - fredricw@csp.edu");
        System.out.println("I certify that this is my own work");
    }

    /**
     * Method that generates random car information and stores it in a hashmap with the key as the hash code of the CarInfo object
     */
    public void generateRandomCarInfo() {
        Random random = new Random(); // Create an instance of the Random class
        String[] make = {"Honda", "Ford", "Chevrolet", "Dodge", "Jeep", "Tesla", "Ram", "Cadillac", "Buick", "Lincoln", // An array of car makes AI GENERATED CAR MAKES
                           "GMC", "Chrysler", "Nissan", "Toyota", "Subaru", "Mazda", "Kia", "Hyundai", "Volvo", "Lexus",
                           "Mitsubishi", "Acura", "Infiniti", "Fiat", "Pontiac", "Oldsmobile", "Saturn", "Hummer", "Mercury", 
                           "Plymouth", "Geo", "Scion", "Jaguar", "Land Rover", "Mini", "BMW", "Mercedes-Benz", "Audi", "Volkswagen",
                           "Porsche", "Ferrari", "Maserati", "Bentley"}; 
        String[] type = {"Sedan", "SUV", "Pickup", "Coupe", "Hatchback", "Convertible", "Minivan", "Crossover"}; // An array of car types AI GENERATED CAR TYPES
        String[] owner = {"John Smith", "Emily Johnson", "Michael Williams", "Sarah Brown", "David Jones", "Jessica Miller", // An array of car owners AI GENERATED CAR OWNERS   
                          "James Davis", "Ashley Wilson", "Christopher Martinez", "Emma Moore", "Daniel Anderson", "Sophia Taylor",
                          "Ethan Thomas", "Olivia Harris", "Benjamin Martin", "Isabella Thompson", "William White", "Ava Clark", 
                          "Noah Rodriguez", "Mia Lewis", "Liam Walker", "Amelia Lee", "Mason Hall", "Harper Allen", "Logan Young",
                          "Abigail King", "Lucas Wright", "Evelyn Scott", "Jacob Green", "Ella Baker", "Elijah Adams", 
                          "Charlotte Nelson", "Oliver Carter", "Grace Perez", "Alexander Mitchell", "Victoria Roberts", "Henry Turner",
                          "Lily Phillips", "Samuel Parker", "Chloe Edwards", "Jack Hernandez"};         
        String[] licenseState = {"MN", "WI", "IL", "IA", "SD", "NE", "KS", "MO", "OK", "TX", // An array of license plate states
                                 "LA", "MS", "AL", "FL", "GA", "SC", "NC", "VA", "WV", "MD", 
                                 "DE", "NJ", "PA", "NY", "CT", "RI", "MA", "NH", "VT", "ME", 
                                 "MI", "OH", "IN", "KY", "TN", "AR", "AZ", "CA", "CO", "ID", 
                                 "MT", "NV", "NM", "OR", "UT", "WA", "WY", "AK", "HI", "DC", "ND"};
        String[] licensePlate = {"A4QAP6", "GZVLYC", "0VR3TC", "CUQVDI", "LPH3K8", "C5MI9G", "J5RF9N", "I15TCX", "PS5FUC", "K6CDPU", // An array of license plates AI GENERATED LICENSE PLATES
                                 "4362WN", "DUW1H8", "GFZZMM", "HT1FZP", "PL2XKA", "UV8QSM", "E1BTHX", "QV6TJP", "YH9RCZ", "KL2VPX", 
                                 "RM5WLU", "VP3QZN", "T6BXD4", "F9JHRL", "XN7TWQ", "PA8YZK", "JK3NVT", "GH4LBM", "ZW9RDK", "LO7PJM",
                                 "QF5HVG", "NW8KST", "BY1WXP", "RE2VMY", "DH7PKZ", "WL9UFC", "JX4QCM", "MO3SVD", "TC6GJN", "UZ8FBW"}; 
                                
       
        HashMap<Integer, CarInfo> map = new HashMap<>(); // Create an instance of the HashMap class with the key as an Integer and the value as a CarInfo object 
        
        // Add 100 different randomized CarInfo object key value-pairs to the hashmap with the key as the index and the value as the CarInfo object 
        for (int i = 0; i < 100; i++) { // Iterate through the loop 100 times
            // By using the length of the array as the bound for the random number generator we can ensure that the random number generated will be within the bounds of the array
            int randomMake = random.nextInt(make.length); // Generate a random make from the make array
            int randomType = random.nextInt(type.length); // Generate a random type from the type array
            int randomOwner = random.nextInt(owner.length); // Generate a random owner from the owner array
            int randomLicenseState = random.nextInt(licenseState.length); // Generate a random license plate number from the licenseState array
            int randomLicensePlate = random.nextInt(licensePlate.length); // Generate a random license plate number from the licensePlate array

            // Create an instance of the CarInfo class with the randomly generated car information from the arrays
            CarInfo carInfo = new CarInfo(make[randomMake], type[randomType], owner[randomOwner], licenseState[randomLicenseState], licensePlate[randomLicensePlate]);
            // map.put(carInfo.hashCode( ), carInfo); // Place the CarInfo object into the hashmap with the key as the hash code of the CarInfo object
            map.put(i, carInfo); // Place the CarInfo object into the hashmap with the key as the index of the loop iteration from 0 to 100
        }
            // Iterate through the hashmap and print out the key value-pairs of the hashmap
            for (Integer key : map.keySet()) {
                System.out.println("Index is: " + key);
                System.out.println(map.get(key));
            }
        }

    /**
     * Main method that will test the functionality of the custom HashMap implementation
     * @param args
     */
    public static void main(String[] args) {


        Main main = new Main(); // Create an instance of the Main class
        main.displayDeveloperInfo(); // Pass the instance variable to the displayDeveloperInfo method
        main.generateRandomCarInfo(); // Pass the instance variable to the generateRandomCarInfo method


    }
}