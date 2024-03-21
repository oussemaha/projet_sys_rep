package messenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
                responseObserver.onCompleted();
                for (Map.Entry<String, StreamObserver<content>> entry : clients.entrySet()) {
                    if (entry.getValue().equals(responseObserver)) {
                        System.out.println("User " + entry.getKey() + " disconnected");
                        clients.remove(entry.getKey());
                        clientsNameList.remove(entry.getKey());
                        break;
                    }
                }
            }
            @Override
            public void onCompleted(){
                //DELETE THE CLIENT FROM THE LIST
                for (Map.Entry<String, StreamObserver<content>> entry : clients.entrySet()) {
                    responseObserver.onCompleted();
                    if (entry.getValue().equals(responseObserver)) {
                        clients.remove(entry.getKey());
                        clientsNameList.remove(entry.getKey());
                        break;
                    }
                }
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

