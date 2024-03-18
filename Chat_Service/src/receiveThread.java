import java.io.BufferedReader;

public class receiveThread extends Thread {
    private BufferedReader input;
    receiveThread(BufferedReader input){
        super();
        this.input = input;
    }
    public void run(){
        try{
            while (true) System.out.println(input.readLine());
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
}
