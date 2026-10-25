import java.rmi.*; 
import java.rmi.registry.*;
public class CalculatorServer { public static void main(String[] args) { try { Calculator service = new CalculatorImpl();
       Registry registry = LocateRegistry.createRegistry(1099);

        registry.rebind("CalculatorService", service);

        System.out.println("Calculator RMI Server is running...");
    } catch (Exception e) {
        System.out.println("Server Error: " + e.getMessage());
    }
}
}
