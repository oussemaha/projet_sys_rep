import java.net.Socket;
import java.io.*;

public class ClientThread extends Thread {
    private Socket client;
    private String username;
    private int Nmessage=0;
    ClientThread(Socket client){
        super();
        this.client = client;
    }
    public void run(){
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while(true){
                String message = input.readLine();
                if(Nmessage==0){
                    username=message.split(":")[1];
                    System.out.println(client.getInetAddress().getHostAddress()+" chose his username as: " + username);
                    Nmessage++;
                    continue;
                }
                
                for(Socket c : Server.clients){
                    if(c != client){
                        PrintWriter output = new PrintWriter(c.getOutputStream(), true);
                        output.printf("%.10s : %s\n",username,message);
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

}
