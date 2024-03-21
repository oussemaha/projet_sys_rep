package grpc.chat;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class server {
    public static void main(String[] args) throws Exception{
        System.out.println("Starting");
        Server server = ServerBuilder.forPort(9090).addService(new chatServiceImpl()).build();
        server.start();
        System.out.println("Server started at " + server.getPort());
        server.awaitTermination();
    }
}