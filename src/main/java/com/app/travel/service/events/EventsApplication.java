package com.app.travel.service.events;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class EventsApplication {
	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder
				.forPort(8080)
				.addService(new LoggingServiceImpl()).build();

		server.start();
		server.awaitTermination();
	}
}