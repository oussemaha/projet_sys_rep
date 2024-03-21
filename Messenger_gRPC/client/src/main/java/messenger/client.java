package messenger;

import java.util.Scanner;
import java.util.Iterator;

import grpc.stub.ChatGrpc;
import grpc.stub.ChatOuterClass.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class client {
    //colors for the console
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        ChatGrpc.ChatBlockingStub stub = ChatGrpc.newBlockingStub(channel);
        ChatGrpc.ChatStub stubStream = ChatGrpc.newStub(channel);
        Scanner scanner = new Scanner(System.in);
        String username;
        int responseCode;
        System.out.println("_________________________________________________________");
        System.out.println(ANSI_GREEN+"\tWelcome to the gRPC chat service"+ANSI_GREEN+ANSI_RESET);
        System.out.print("First of all, pick a username, ");
        do {
            System.out.print(ANSI_RED+"it must be unique: "+ANSI_RED+ANSI_RESET);
            username = scanner.nextLine();
            registrationM request = registrationM.newBuilder().setUsername(username).build();
            ServerResponse response = stub.registration(request);
            responseCode = response.getCode();
        } while (responseCode != 100);
        System.out.println(ANSI_YELLOW+"To use this service here are the appropriate commands\n"+ANSI_YELLOW+ANSI_RESET);
        System.out.println(ANSI_CYAN+"#To send a message type the following:                  "+ANSI_CYAN+ANSI_RESET);
        System.out.println("destination:message                                    ");
        System.out.println(ANSI_CYAN+"#To see the connected users type the following:         "+ANSI_CYAN+ANSI_RESET);
        System.out.println("server:list                                            ");
        System.out.println(ANSI_CYAN+"#To exit the service type the following:                "+ANSI_CYAN+ANSI_RESET);
        System.out.println("server:exit                                            ");
        System.out.println("_________________________________________________________");

        // registration
       

        StreamObserver<content> obs = stubStream.chat(new StreamObserver<content>() {
            @Override
            public void onNext(content value) {
                System.out.printf("[%s => %s ]: %s\n", value.getSource(), value.getDestination(), value.getMessage());
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
        // first message to register the stream Observer
        content message = content.newBuilder().setMessage(username).build();
        obs.onNext(message);
   

        while (true) {

            String command = scanner.nextLine();
            String[] command_args = command.split(":");
            if (command_args.length != 2) {
                System.out.println("Invalid command");
                continue;
            } else if (command_args[0].equals("server") && command_args[1].equals("list")) {
                Empty request = Empty.newBuilder().build();
                Iterator<connectedUser> users = stub.showUsers(request);
                connectedUser userTEMP;
                System.out.println("Connected users: ");
                while (users.hasNext()) {
                    userTEMP = users.next();
                    System.out.println(userTEMP.getUser());
                }

            } else if (command_args[0].equals("server") && command_args[1].equals("exit")) {
                obs.onCompleted();
                channel.shutdown();
                System.exit(0);
            } else {
                message = content.newBuilder().setDestination(command_args[0]).setSource(username)
                        .setMessage(command_args[1]).build();
                obs.onNext(message);
            }
        }
    }
}
