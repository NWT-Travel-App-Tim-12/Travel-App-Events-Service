package com.app.travel.service.events;


import io.grpc.stub.StreamObserver;

public class LoggingServiceImpl extends LoggingServiceGrpc.LoggingServiceImplBase {

    @Override
    public void log(
            LoggingRequest request, StreamObserver<LoggingResponse> responseObserver) {

        System.out.println("entered log method");

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getTimestamp())
                .append(" ")
                .append(request.getMicroserviceName())
                .append(" ")
                .append(request.getActionType())
                .append(" ")
                .append(request.getResourceName())
                .append(" ")
                .append(request.getStatusCode())
                .toString();

        LoggingResponse response = LoggingResponse.newBuilder()
                .setSuccess(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
