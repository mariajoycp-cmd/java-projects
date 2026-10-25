import java.io.*;
import java.net.*;
public class EchoServer 
{ 
public static void main(String[] args) 
{ 
try 
{ 
ServerSocket serverSocket = new ServerSocket(5001); 
System.out.println("Echo Server is waiting...");
       Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

        PrintWriter output = new PrintWriter(
            socket.getOutputStream(), true);

        String message = input.readLine();

        System.out.println("Received: " + message);
        output.println(message);

        System.out.println("Echo sent successfully.");

        socket.close();
        serverSocket.close();

    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
}
