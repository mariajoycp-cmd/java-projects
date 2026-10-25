import java.rmi.*;
import java.rmi.server.*;
public class CalculatorImpl extends UnicastRemoteObject implements Calculator 
{
    public CalculatorImpl() throws RemoteException {
        super();
    }   

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

public int subtract(int a, int b) throws RemoteException {
    return a - b;
}

public int multiply(int a, int b) throws RemoteException {
    return a * b;
}

public double divide(int a, int b) throws RemoteException {
    if (b == 0) {
        throw new RemoteException("Division by zero is not allowed");
    }
    return (double) a / b;
}
 
}
