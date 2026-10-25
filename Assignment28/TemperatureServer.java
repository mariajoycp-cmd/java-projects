import java.rmi.*; 
import java.rmi.registry.*;
public class TemperatureServer 
{ 
public static void main(String[] args) 
{ 
try 
{ 
TemperatureService service = new TemperatureServiceImpl();
       Registry registry =
            LocateRegistry.createRegistry(1099);

        registry.rebind("TemperatureService", service);

        System.out.println(
            "Temperature RMI Server is running...");
    } catch (Exception e) {
        System.out.println("Server Error: " + e.getMessage());
    }
}
 
}
