import java.io.*; 
import java.net.*;
public class ChatServer 
{ 
public static void main(String[] args) 
{ 
try 
{ 
ServerSocket serverSocket = new ServerSocket(5002);
 System.out.println("Server is waiting for client...");
       Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

        PrintWriter output = new PrintWriter(
            socket.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in));

        String message;

        while ((message = input.readLine()) != null) {
            System.out.println("Client: " + message);

            if (message.equalsIgnoreCase("bye")) {
                break;
            }

            System.out.print("Server: ");
            String reply = keyboard.readLine();

            output.println(reply);

            if (reply.equalsIgnoreCase("bye")) {
                break;
            }
        }

        socket.close();
        serverSocket.close();
        System.out.println("Chat ended.");

    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
 
}
