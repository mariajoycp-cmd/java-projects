import java.io.*;
import java.util.Scanner;

public class PatientFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Writing patient details to file
            FileWriter writer = new FileWriter("patient.txt");

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Patient Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Diagnosis: ");
            String diagnosis = sc.nextLine();

            writer.write("Patient ID: " + id + "\n");
            writer.write("Patient Name: " + name + "\n");
            writer.write("Patient Age: " + age + "\n");
            writer.write("Diagnosis: " + diagnosis + "\n");

            writer.close();

            // Reading patient details from file
            FileReader reader = new FileReader("patient.txt");
            int ch;

            System.out.println("\nPatient Details:");
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