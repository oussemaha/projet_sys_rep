package grpc.stub;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: chat.proto")
public final class ChatGrpc {

  private ChatGrpc() {}

  public static final String SERVICE_NAME = "Chat";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.stub.ChatOuterClass.registrationM,
      grpc.stub.ChatOuterClass.ServerResponse> getRegistrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registration",
      requestType = grpc.stub.ChatOuterClass.registrationM.class,
      responseType = grpc.stub.ChatOuterClass.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.stub.ChatOuterClass.registrationM,
      grpc.stub.ChatOuterClass.ServerResponse> getRegistrationMethod() {
    io.grpc.MethodDescriptor<grpc.stub.ChatOuterClass.registrationM, grpc.stub.ChatOuterClass.ServerResponse> getRegistrationMethod;
    if ((getRegistrationMethod = ChatGrpc.getRegistrationMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getRegistrationMethod = ChatGrpc.getRegistrationMethod) == null) {
          ChatGrpc.getRegistrationMethod = getRegistrationMethod = 
              io.grpc.MethodDescriptor.<grpc.stub.ChatOuterClass.registrationM, grpc.stub.ChatOuterClass.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Chat", "registration"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stub.ChatOuterClass.registrationM.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stub.ChatOuterClass.ServerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatMethodDescriptorSupplier("registration"))
                  .build();
          }
        }
     }
     return getRegistrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.stub.ChatOuterClass.Empty,
      grpc.stub.ChatOuterClass.connectedUser> getShowUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "showUsers",
      requestType = grpc.stub.ChatOuterClass.Empty.class,
      responseType = grpc.stub.ChatOuterClass.connectedUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.stub.ChatOuterClass.Empty,
      grpc.stub.ChatOuterClass.connectedUser> getShowUsersMethod() {
    io.grpc.MethodDescriptor<grpc.stub.ChatOuterClass.Empty, grpc.stub.ChatOuterClass.connectedUser> getShowUsersMethod;
    if ((getShowUsersMethod = ChatGrpc.getShowUsersMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getShowUsersMethod = ChatGrpc.getShowUsersMethod) == null) {
          ChatGrpc.getShowUsersMethod = getShowUsersMethod = 
              io.grpc.MethodDescriptor.<grpc.stub.ChatOuterClass.Empty, grpc.stub.ChatOuterClass.connectedUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Chat", "showUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stub.ChatOuterClass.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stub.ChatOuterClass.connectedUser.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatMethodDescriptorSupplier("showUsers"))
                  .build();
          }
        }
     }
     return getShowUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.stub.ChatOuterClass.content,
      grpc.stub.ChatOuterClass.content> getChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "chat",
      requestType = grpc.stub.ChatOuterClass.content.class,
      responseType = grpc.stub.ChatOuterClass.content.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.stub.ChatOuterClass.content,
      grpc.stub.ChatOuterClass.content> getChatMethod() {
    io.grpc.MethodDescriptor<grpc.stub.ChatOuterClass.content, grpc.stub.ChatOuterClass.content> getChatMethod;
    if ((getChatMethod = ChatGrpc.getChatMethod) == null) {
      synchronized (ChatGrpc.class) {
        if ((getChatMethod = ChatGrpc.getChatMethod) == null) {
          ChatGrpc.getChatMethod = getChatMethod = 
              io.grpc.MethodDescriptor.<grpc.stub.ChatOuterClass.content, grpc.stub.ChatOuterClass.content>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Chat", "chat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stub.ChatOuterClass.content.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stub.ChatOuterClass.content.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatMethodDescriptorSupplier("chat"))
                  .build();
          }
        }
     }
     return getChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatStub newStub(io.grpc.Channel channel) {
    return new ChatStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatFutureStub(channel);
  }

  /**
   */
  public static abstract class ChatImplBase implements io.grpc.BindableService {

    /**
     */
    public void registration(grpc.stub.ChatOuterClass.registrationM request,
        io.grpc.stub.StreamObserver<grpc.stub.ChatOuterClass.ServerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegistrationMethod(), responseObserver);
    }

    /**
     */
    public void showUsers(grpc.stub.ChatOuterClass.Empty request,
        io.grpc.stub.StreamObserver<grpc.stub.ChatOuterClass.connectedUser> responseObserver) {
      asyncUnimplementedUnaryCall(getShowUsersMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.stub.ChatOuterClass.content> chat(
        io.grpc.stub.StreamObserver<grpc.stub.ChatOuterClass.content> responseObserver) {
      return asyncUnimplementedStreamingCall(getChatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegistrationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.stub.ChatOuterClass.registrationM,
                grpc.stub.ChatOuterClass.ServerResponse>(
                  this, METHODID_REGISTRATION)))
          .addMethod(
            getShowUsersMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.stub.ChatOuterClass.Empty,
                grpc.stub.ChatOuterClass.connectedUser>(
                  this, METHODID_SHOW_USERS)))
          .addMethod(
            getChatMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.stub.ChatOuterClass.content,
                grpc.stub.ChatOuterClass.content>(
                  this, METHODID_CHAT)))
          .build();
    }
  }

  /**
   */
  public static final class ChatStub extends io.grpc.stub.AbstractStub<ChatStub> {
    private ChatStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatStub(channel, callOptions);
    }

    /**
     */
    public void registration(grpc.stub.ChatOuterClass.registrationM request,
        io.grpc.stub.StreamObserver<grpc.stub.ChatOuterClass.ServerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegistrationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void showUsers(grpc.stub.ChatOuterClass.Empty request,
        io.grpc.stub.StreamObserver<grpc.stub.ChatOuterClass.connectedUser> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getShowUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.stub.ChatOuterClass.content> chat(
        io.grpc.stub.StreamObserver<grpc.stub.ChatOuterClass.content> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getChatMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ChatBlockingStub extends io.grpc.stub.AbstractStub<ChatBlockingStub> {
    private ChatBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.stub.ChatOuterClass.ServerResponse registration(grpc.stub.ChatOuterClass.registrationM request) {
      return blockingUnaryCall(
          getChannel(), getRegistrationMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.stub.ChatOuterClass.connectedUser> showUsers(
        grpc.stub.ChatOuterClass.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getShowUsersMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatFutureStub extends io.grpc.stub.AbstractStub<ChatFutureStub> {
    private ChatFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.stub.ChatOuterClass.ServerResponse> registration(
        grpc.stub.ChatOuterClass.registrationM request) {
      return futureUnaryCall(
          getChannel().newCall(getRegistrationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTRATION = 0;
  private static final int METHODID_SHOW_USERS = 1;
  private static final int METHODID_CHAT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTRATION:
          serviceImpl.registration((grpc.stub.ChatOuterClass.registrationM) request,
              (io.grpc.stub.StreamObserver<grpc.stub.ChatOuterClass.ServerResponse>) responseObserver);
          break;
        case METHODID_SHOW_USERS:
          serviceImpl.showUsers((grpc.stub.ChatOuterClass.Empty) request,
              (io.grpc.stub.StreamObserver<grpc.stub.ChatOuterClass.connectedUser>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.chat(
              (io.grpc.stub.StreamObserver<grpc.stub.ChatOuterClass.content>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.stub.ChatOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Chat");
    }
  }

  private static final class ChatFileDescriptorSupplier
      extends ChatBaseDescriptorSupplier {
    ChatFileDescriptorSupplier() {}
  }

  private static final class ChatMethodDescriptorSupplier
      extends ChatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatFileDescriptorSupplier())
              .addMethod(getRegistrationMethod())
              .addMethod(getShowUsersMethod())
              .addMethod(getChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
