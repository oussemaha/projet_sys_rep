package grpc.chat;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import grpc.stub.ChatGrpc;
import grpc.stub.ChatOuterClass.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        ChatGrpc.ChatBlockingStub stub = ChatGrpc.newBlockingStub(channel);
        ChatGrpc.ChatStub stubStream = ChatGrpc.newStub(channel);
        Scanner scanner = new Scanner(System.in);
        String username;
        int responseCode;

        //registration
        do{
            System.out.println("pick a username: ");
            username= scanner.nextLine();
            registrationM request = registrationM.newBuilder().setUsername(username).build();
            ServerResponse response = stub.registration(request);
            responseCode = response.getCode();
        }while(responseCode != 100);

        StreamObserver<content> obs= stubStream.chat(new StreamObserver<content>() {
            @Override
            public void onNext(content value) {
                System.out.printf("[%s => %s ]: %s\n",value.getSource(),value.getDestination(),value.getMessage());
            }
            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }
            @Override
            public void onCompleted() {
                System.out.println("Server has closed the connection");
            }
        });
        System.out.println("Successfully connected");
        //first message to register the stream Observer
        content message = content.newBuilder().setMessage(username).build();
        obs.onNext(message);
        
        while(true){
            
            System.out.println("Choose an option: ");
            System.out.println("1. send message to a user");
            System.out.println("2. Check list of connected users");
            System.out.println("3. exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Enter the message: ");
                    String text = scanner.nextLine();
                    message = content.newBuilder().setDestination(text.split(":")[0]).setSource(username).setMessage(text.split(":")[1]).build();
                    obs.onNext(message);
                    break;
                case 2:
                    // check list of connected users
                    Empty request1 = Empty.newBuilder().build();
                    Iterator<connectedUser> users=stub.showUsers(request1);
                    connectedUser userTEMP;
                    System.out.println("Connected users: ");
                    while(users.hasNext()){       
                        userTEMP = users.next();   
                        System.out.println(userTEMP.getUser());
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}