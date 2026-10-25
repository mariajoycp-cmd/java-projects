import java.rmi.*;
public interface TemperatureService extends Remote { double celsiusToFahrenheit(double celsius) throws RemoteException;
double fahrenheitToCelsius(double fahrenheit)
    throws RemoteException;
 
}
