import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Impl_List extends UnicastRemoteObject implements Interface_List{
    Impl_List() throws RemoteException{
        super();
    }
    List<String> tasks = new ArrayList<String>();
    public void addTask(String task) throws Exception{
        tasks.add(task);
    }
    public void removeTask(int index) throws Exception{
        tasks.remove(index);
    }
    public List<String> displayList() throws Exception{
        return tasks;
    }
    
}
