package org.baeldung.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.baeldung.grpc.HelloRequest;
import org.baeldung.grpc.HelloResponse;
import org.baeldung.grpc.HelloServiceGrpc;
import org.baeldung.grpc.HelloServiceGrpc.HelloServiceBlockingStub;

public class GrpcClient {

  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
        .usePlaintext()
        .build();

    HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

    HelloResponse helloResponse = stub.hello(
        HelloRequest.newBuilder()
            .setFirstName("Baeldung")
            .setLastName("gRPC")
            .build()
    );

    System.out.println(helloResponse);

    channel.shutdown();
  }
}
