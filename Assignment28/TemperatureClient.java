import java.rmi.*; 
import java.util.Scanner;
public class TemperatureClient 
{ 
public static void main(String[] args) {
 try { TemperatureService service = (TemperatureService) Naming.lookup("rmi://localhost/TemperatureService");
       Scanner sc = new Scanner(System.in);

        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Celsius: ");
            double c = sc.nextDouble();

            System.out.printf("Temperature in Fahrenheit: %.2f%n",
                service.celsiusToFahrenheit(c));

        } else if (choice == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double f = sc.nextDouble();

            System.out.printf("Temperature in Celsius: %.2f%n",
                service.fahrenheitToCelsius(f));

        } else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    } catch (Exception e) {
        System.out.println("Client Error: " + e.getMessage());
    }
}
 
}

