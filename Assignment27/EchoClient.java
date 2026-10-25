import java.io.*; 
import java.net.*;
public class EchoClient 
{ 
public static void main(String[] args) 
{ 
try 
{ 
Socket socket = new Socket("localhost", 5001);
       BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in));

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

        PrintWriter output = new PrintWriter(
            socket.getOutputStream(), true);

        System.out.print("Enter a message: ");
        String message = keyboard.readLine();

        output.println(message);

        String reply = input.readLine();
        System.out.println("Echo from server: " + reply);

        socket.close();

    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
 
}
