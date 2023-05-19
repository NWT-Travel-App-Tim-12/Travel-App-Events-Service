package com.app.travel.service.events;


import com.app.travel.service.events.Model.Event;
import com.app.travel.service.events.Repository.EventRepository;
import io.grpc.stub.StreamObserver;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;


public class LoggingServiceImpl extends LoggingServiceGrpc.LoggingServiceImplBase {


    private EventRepository eventRepository;

    public LoggingServiceImpl(ApplicationContext applicationContext){
        this.eventRepository=applicationContext.getBean(EventRepository.class);
    }



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

        Event event = new Event(0, request.getTimestamp(), request.getMicroserviceName(), request.getActionType(), request.getResourceName(),request.getStatusCode());


        eventRepository.save(event);

        LoggingResponse response = LoggingResponse.newBuilder()
                .setSuccess(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
