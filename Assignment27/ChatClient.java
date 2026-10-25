import java.io.*; 
import java.net.*;
public class ChatClient {
 public static void main(String[] args) 
{ 
try 
{ 
Socket socket = new Socket("localhost", 5002); 
System.out.println("Connected to server.");
       BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in));

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

        PrintWriter output = new PrintWriter(
            socket.getOutputStream(), true);

        String message;

        while (true) {
            System.out.print("Client: ");
            message = keyboard.readLine();

            output.println(message);

            if (message.equalsIgnoreCase("bye")) {
                break;
            }

            String reply = input.readLine();
            System.out.println("Server: " + reply);

            if (reply == null || reply.equalsIgnoreCase("bye")) {
                break;
            }
        }

        socket.close();
        System.out.println("Disconnected from server.");

    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
 
}
