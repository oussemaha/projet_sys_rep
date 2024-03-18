public class server {
    public static void main(String[] args) {
        try{
            Impl_List list = new Impl_List();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("todo_list", list);
            System.out.println("Server is running...");
        }
        catch(Exception e){
            System.out.println("Server Error: " + e);
        }
    }
    
}
