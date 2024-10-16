package com.wyattfredrickson;


/**
 * CarInfo class that contains the make, type, owner, licenseState, and licensePlate of a car
 */
public class CarInfo {
    // Attributes of the CarInfo class
    private String make; 
    private String type;
    private String owner;
    private String licenseState;
    private String licensePlate;

    /**
     * Constructor for the CarInfo class that takes in the make, type, owner, licenseState, and licensePlate of a car
     * @param make the make of the car
     * @param type the type of the car
     * @param owner the owner of the car
     * @param licenseState the state of the license plate
     * @param licensePlate the license plate of the car
     */
    public CarInfo(String make, String type, String owner, String licenseState, String licensePlate) {
        this.make = make;
        this.type = type;
        this.owner = owner;
        this.licenseState = licenseState;
        this.licensePlate = licensePlate;

    }

    /**
     * Getter methods for the individual attributes
     * @return the value of the individual attributes
     */
    public String getMake() {
        return make;
    }
    public String getType() {
        return type;
    }
    public String getOwner() {
        return owner;
    }
    public String getLicenseState() {
        return licenseState;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    
    /**
     * Method for generating a hash code for the CarInfo object,
     * based on the licensePlate and licenseState attributes
     * Takes the hash code of the licensePlate and licenseState attributes and multiplies them by a prime number
     */
    @Override
    public int hashCode() {
        final int primeNumber = 31; // prime number for generating hash code
        // return the hash code of the licensePlate and licenseState attributes by multiplying them by the prime number
        return primeNumber * licensePlate.hashCode() + licenseState.hashCode();
    }
    
    /**
     * Method for comparing two CarInfo objects for equality based on licensePlate and licenseState
     * @param obj the object to compare to the current object
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // if the object is the same, return true
            return true; // return true if the object is the same
        }
        // if the object is null or the classes are not the same, return false
        if (obj == null || getClass() != obj.getClass()) { // getClass() method is for getting the class of the object
            return false; // return false if the classes are not the same
        }
        // cast the object to a CarInfo object
        CarInfo carInfo = (CarInfo) obj; 
        // return true if the licensePlate and licenseState are the same
        return licensePlate.equals(carInfo.licensePlate) && licenseState.equals(carInfo.licenseState);
    
    }

    /**
     * Method for returning a string representation of the CarInfo object
     * 
     */
    @Override
    public String toString() {
        return "\nCar is: " + owner + " - " + " " + licensePlate + " " + licenseState + " " + make + " " + type; 
    }
}