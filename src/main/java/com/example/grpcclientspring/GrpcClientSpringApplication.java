package com.example.grpcclientspring;

import generated.APIResponse;
import generated.LoginRequest;
import generated.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcClientSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientSpringApplication.class, args);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        // stubs - generate from proto

        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("MATEUS").setPassword("MATEUS").build();
        APIResponse response = userStub.login(loginRequest);

        System.out.println(response.getResponseMessage());
    }

}
