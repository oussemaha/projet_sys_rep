import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class client {
    public static void main(String[] args) {
        try {
            List<String> tasks=null;
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            Interface_List list = (Interface_List) reg.lookup("todo_list");
            System.out.println("Connected to server...");
            while(true){
                System.out.println("1. Add Task");
                System.out.println("2. Remove Task");
                System.out.println("3. Display List");
                System.out.println("4. Clear screen");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(System.console().readLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter task: ");
                        list.addTask(System.console().readLine());
                        break;
                    case 2:
                        System.out.print("Enter index: ");
                        list.removeTask(Integer.parseInt(System.console().readLine()));
                        break;
                    case 3:
                        tasks=list.displayList();
                        System.out.println("#############");
                        for(int i=0;i<tasks.size();i++){
                            System.out.printf("n°%d : %s\n",(i+1),tasks.get(i));
                        }
                        System.out.println("#############");   
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        break; 
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
    
}
