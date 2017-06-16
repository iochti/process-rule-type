package iochti.processRuleType.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class ProcessRuleTypeServiceGrpc {

  private ProcessRuleTypeServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.ProcessRuleTypeService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<ProcessRuleTypeByIdRequest,
      ProcessRuleType> METHOD_GET_PROCESS_RULE_TYPE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "proto.ProcessRuleTypeService", "GetProcessRuleType"),
          io.grpc.protobuf.ProtoUtils.marshaller(ProcessRuleTypeByIdRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(ProcessRuleType.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<ProcessRuleType,
      ProcessRuleType> METHOD_CREATE_PROCESS_RULE_TYPE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "proto.ProcessRuleTypeService", "CreateProcessRuleType"),
          io.grpc.protobuf.ProtoUtils.marshaller(ProcessRuleType.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(ProcessRuleType.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<ProcessRuleType,
      ProcessRuleType> METHOD_UPDATE_PROCESS_RULE_TYPE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "proto.ProcessRuleTypeService", "UpdateProcessRuleType"),
          io.grpc.protobuf.ProtoUtils.marshaller(ProcessRuleType.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(ProcessRuleType.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<ProcessRuleTypeByIdRequest,
      com.google.protobuf.Empty> METHOD_DELETE_PROCESS_RULE_TYPE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "proto.ProcessRuleTypeService", "DeleteProcessRuleType"),
          io.grpc.protobuf.ProtoUtils.marshaller(ProcessRuleTypeByIdRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance()));

  public static ProcessRuleTypeServiceStub newStub(io.grpc.Channel channel) {
    return new ProcessRuleTypeServiceStub(channel);
  }

  public static ProcessRuleTypeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProcessRuleTypeServiceBlockingStub(channel);
  }

  public static ProcessRuleTypeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProcessRuleTypeServiceFutureStub(channel);
  }

  public static interface ProcessRuleTypeService {

    public void getProcessRuleType(ProcessRuleTypeByIdRequest request,
        io.grpc.stub.StreamObserver<ProcessRuleType> responseObserver);

    public void createProcessRuleType(ProcessRuleType request,
        io.grpc.stub.StreamObserver<ProcessRuleType> responseObserver);

    public void updateProcessRuleType(ProcessRuleType request,
        io.grpc.stub.StreamObserver<ProcessRuleType> responseObserver);

    public void deleteProcessRuleType(ProcessRuleTypeByIdRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver);
  }

  public static interface ProcessRuleTypeServiceBlockingClient {

    public ProcessRuleType getProcessRuleType(ProcessRuleTypeByIdRequest request);

    public ProcessRuleType createProcessRuleType(ProcessRuleType request);

    public ProcessRuleType updateProcessRuleType(ProcessRuleType request);

    public com.google.protobuf.Empty deleteProcessRuleType(ProcessRuleTypeByIdRequest request);
  }

  public static interface ProcessRuleTypeServiceFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<ProcessRuleType> getProcessRuleType(
        ProcessRuleTypeByIdRequest request);

    public com.google.common.util.concurrent.ListenableFuture<ProcessRuleType> createProcessRuleType(
        ProcessRuleType request);

    public com.google.common.util.concurrent.ListenableFuture<ProcessRuleType> updateProcessRuleType(
        ProcessRuleType request);

    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteProcessRuleType(
        ProcessRuleTypeByIdRequest request);
  }

  public static class ProcessRuleTypeServiceStub extends io.grpc.stub.AbstractStub<ProcessRuleTypeServiceStub>
      implements ProcessRuleTypeService {
    private ProcessRuleTypeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProcessRuleTypeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProcessRuleTypeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProcessRuleTypeServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void getProcessRuleType(ProcessRuleTypeByIdRequest request,
        io.grpc.stub.StreamObserver<ProcessRuleType> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_PROCESS_RULE_TYPE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void createProcessRuleType(ProcessRuleType request,
        io.grpc.stub.StreamObserver<ProcessRuleType> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_PROCESS_RULE_TYPE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void updateProcessRuleType(ProcessRuleType request,
        io.grpc.stub.StreamObserver<ProcessRuleType> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_PROCESS_RULE_TYPE, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void deleteProcessRuleType(ProcessRuleTypeByIdRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_PROCESS_RULE_TYPE, getCallOptions()), request, responseObserver);
    }
  }

  public static class ProcessRuleTypeServiceBlockingStub extends io.grpc.stub.AbstractStub<ProcessRuleTypeServiceBlockingStub>
      implements ProcessRuleTypeServiceBlockingClient {
    private ProcessRuleTypeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProcessRuleTypeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProcessRuleTypeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProcessRuleTypeServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public ProcessRuleType getProcessRuleType(ProcessRuleTypeByIdRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_GET_PROCESS_RULE_TYPE, getCallOptions()), request);
    }

    @java.lang.Override
    public ProcessRuleType createProcessRuleType(ProcessRuleType request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_CREATE_PROCESS_RULE_TYPE, getCallOptions()), request);
    }

    @java.lang.Override
    public ProcessRuleType updateProcessRuleType(ProcessRuleType request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_UPDATE_PROCESS_RULE_TYPE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.protobuf.Empty deleteProcessRuleType(ProcessRuleTypeByIdRequest request) {
      return blockingUnaryCall(
          getChannel().newCall(METHOD_DELETE_PROCESS_RULE_TYPE, getCallOptions()), request);
    }
  }

  public static class ProcessRuleTypeServiceFutureStub extends io.grpc.stub.AbstractStub<ProcessRuleTypeServiceFutureStub>
      implements ProcessRuleTypeServiceFutureClient {
    private ProcessRuleTypeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProcessRuleTypeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProcessRuleTypeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProcessRuleTypeServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<ProcessRuleType> getProcessRuleType(
        ProcessRuleTypeByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_PROCESS_RULE_TYPE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<ProcessRuleType> createProcessRuleType(
        ProcessRuleType request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_PROCESS_RULE_TYPE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<ProcessRuleType> updateProcessRuleType(
        ProcessRuleType request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_PROCESS_RULE_TYPE, getCallOptions()), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteProcessRuleType(
        ProcessRuleTypeByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_PROCESS_RULE_TYPE, getCallOptions()), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final ProcessRuleTypeService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
      .addMethod(
        METHOD_GET_PROCESS_RULE_TYPE,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              ProcessRuleTypeByIdRequest,
              ProcessRuleType>() {
            @java.lang.Override
            public void invoke(
                ProcessRuleTypeByIdRequest request,
                io.grpc.stub.StreamObserver<ProcessRuleType> responseObserver) {
              serviceImpl.getProcessRuleType(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_CREATE_PROCESS_RULE_TYPE,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              ProcessRuleType,
              ProcessRuleType>() {
            @java.lang.Override
            public void invoke(
                ProcessRuleType request,
                io.grpc.stub.StreamObserver<ProcessRuleType> responseObserver) {
              serviceImpl.createProcessRuleType(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_UPDATE_PROCESS_RULE_TYPE,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              ProcessRuleType,
              ProcessRuleType>() {
            @java.lang.Override
            public void invoke(
                ProcessRuleType request,
                io.grpc.stub.StreamObserver<ProcessRuleType> responseObserver) {
              serviceImpl.updateProcessRuleType(request, responseObserver);
            }
          }))
      .addMethod(
        METHOD_DELETE_PROCESS_RULE_TYPE,
        asyncUnaryCall(
          new io.grpc.stub.ServerCalls.UnaryMethod<
              ProcessRuleTypeByIdRequest,
              com.google.protobuf.Empty>() {
            @java.lang.Override
            public void invoke(
                ProcessRuleTypeByIdRequest request,
                io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
              serviceImpl.deleteProcessRuleType(request, responseObserver);
            }
          })).build();
  }
}
