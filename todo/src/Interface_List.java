import java.rmi.Remote;
import java.util.List;

public interface Interface_List extends Remote{
    public void addTask(String task) throws Exception;
    public void removeTask(int index) throws Exception;
    public List<String> displayList() throws Exception;
    
}
