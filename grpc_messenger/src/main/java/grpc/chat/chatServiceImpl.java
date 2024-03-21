package grpc.chat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import grpc.stub.ChatGrpc.ChatImplBase;
import grpc.stub.ChatOuterClass.*;
import io.grpc.stub.StreamObserver;

public class chatServiceImpl extends ChatImplBase {
    List<String> clientsNameList = new ArrayList<String>();
    Map<String, StreamObserver<content>> clients = new ConcurrentHashMap<String,StreamObserver<content>>();

    chatServiceImpl() {
        super();
    }

    @Override
    public void registration(registrationM request, StreamObserver<ServerResponse> responseObserver) {
        if (clientsNameList.contains(request.getUsername())) {
            ServerResponse.Builder response = ServerResponse.newBuilder();
            response.setMessage("username already taken")
                    .setCode(200);
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        } else {
            clientsNameList.add(request.getUsername());
            ServerResponse.Builder response = ServerResponse.newBuilder();
            response.setMessage("successfully registered")
                    .setCode(100);
            System.out.println("User " + request.getUsername() + " connected");

            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public StreamObserver<content> chat(StreamObserver<content> responseObserver){
        return new StreamObserver<content>(){
            @Override
            public void onNext(content request){
                if(!clients.containsValue(responseObserver)){
                    clients.put(request.getMessage(),responseObserver);
                    return;
                }
                clients.get(request.getDestination()).onNext(request);
            }
            @Override
            public void onError(Throwable t){
                responseObserver.onNext(content.newBuilder().setMessage("Error: " + t.getMessage()).build());
            }
            @Override
            public void onCompleted(){
            }
        };
    }
    @Override
    public void showUsers(Empty request,StreamObserver<connectedUser> responseObserver){
        connectedUser.Builder response = connectedUser.newBuilder();
        for(String user : clientsNameList){
            response.setUser(user);
            responseObserver.onNext(response.build());
        }
        responseObserver.onCompleted();

    }
}

