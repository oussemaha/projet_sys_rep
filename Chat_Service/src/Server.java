import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    static List <Socket> clients = new ArrayList<Socket>();
    public static void main(String[] args) throws Exception {
        try{
            ServerSocket server = new ServerSocket(11000);
            System.out.println("Server is running on port 11000");
            while(true){
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getInetAddress().getHostAddress());
                clients.add(client);   
                ClientThread clientThread = new ClientThread(client);
                clientThread.start();
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e);
            
        }
    }
}
