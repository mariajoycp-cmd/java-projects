public class Vehicle {

    private String registrationNumber;
    private String ownerName;
    private String model;
    private int manufacturingYear;

    
    public Vehicle() {
        this.registrationNumber = "PENDING";
        this.ownerName = "Unknown";
        this.model = "Standard";
        this.manufacturingYear = 2024;
    }

    // Parameterized Constructor
    public Vehicle(String registrationNumber, String ownerName,
                   String model, int manufacturingYear) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
    }

    // Copy Constructor
    public Vehicle(Vehicle other) {
        this.registrationNumber = other.registrationNumber;
        this.ownerName = other.ownerName;
        this.model = other.model;
        this.manufacturingYear = other.manufacturingYear;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Registration Number : " + registrationNumber);
        System.out.println("Owner Name          : " + ownerName);
        System.out.println("Model               : " + model);
        System.out.println("Manufacturing Year  : " + manufacturingYear);
        System.out.println("------------------------------------");
    }

    // Main Method
    public static void main(String[] args) {

        // Using Default Constructor
        Vehicle defaultVehicle = new Vehicle();

        // Using Parameterized Constructor
        Vehicle parameterizedVehicle =
                new Vehicle("MH12AB1234", "Maria", "FZS V4", 2024);

        // Using Copy Constructor
        Vehicle copiedVehicle = new Vehicle(parameterizedVehicle);

        System.out.println("--- Default Constructor ---");
        defaultVehicle.displayDetails();

        System.out.println("--- Parameterized Constructor ---");
        parameterizedVehicle.displayDetails();

        System.out.println("--- Copy Constructor ---");
        copiedVehicle.displayDetails();
    }
}