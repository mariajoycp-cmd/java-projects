import java.rmi.*; 
import java.util.Scanner;
public class CalculatorClient 
{ 
public static void main(String[] args) 
{ 
try 
{ 
Calculator service = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");
       Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("Addition: " + service.add(a, b));
        System.out.println("Subtraction: " + service.subtract(a, b));
        System.out.println("Multiplication: " + service.multiply(a, b));
        System.out.println("Division: " + service.divide(a, b));

        sc.close();
    } catch (Exception e) {
        System.out.println("Client Error: " + e.getMessage());
    }
}
 
}


