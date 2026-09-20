// Program to demonstrate Default, Parameterized, and Copy Constructors
public class Assignment2 {

    // Instance variables
    String name;
    int age;

    // Default Constructor
    Assignment2() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized Constructor
    Assignment2(String n, int a) {
        name = n;
        age = a;
    }

    // Copy Constructor
    Assignment2(Assignment2 s) {
        name = s.name;
        age = s.age;
    }

    // Display Method
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {

        // Creating object using Default Constructor
        Assignment2 s1 = new Assignment2();

        // Creating object using Parameterized Constructor
        Assignment2 s2 = new Assignment2("Maria Joy", 20);

        // Creating object using Copy Constructor
        Assignment2 s3 = new Assignment2(s2);

        // Display details of object created using Default Constructor
        System.out.println("Default Constructor");
        s1.display();

        // Display details of object created using Parameterized Constructor
        System.out.println("Parameterized Constructor");
        s2.display();

        // Display details of object created using Copy Constructor
        System.out.println( "Copy Constructor");
        s3.display();
    }
}