import java.io.*;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws Exception {
        try{
            Socket client = new Socket("localhost", 11000);
            System.out.println("Connected to server");

            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your username: ");
            output.println("username:" + console.readLine());
            new receiveThread(input).start();
            while(true){
                String message = console.readLine();
                
                if(message.equals("exit")) break;
                output.println(message);
            }
            client.close();
           }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
}
