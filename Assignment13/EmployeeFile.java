import java.io.*;
import java.util.Scanner;

public class EmployeeFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Writing employee details to file
            FileWriter writer = new FileWriter("employee.txt");

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();

            writer.write("Employee ID: " + id + "\n");
            writer.write("Employee Name: " + name + "\n");
            writer.write("Employee Salary: " + salary + "\n");

            writer.close();

            // Reading employee details from file
            FileReader reader = new FileReader("employee.txt");
            int ch;

            System.out.println("\nEmployee Details:");
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}