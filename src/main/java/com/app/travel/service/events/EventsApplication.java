package com.app.travel.service.events;

import com.app.travel.service.events.Model.Event;
import com.app.travel.service.events.Repository.EventRepository;
import com.app.travel.service.events.config.SpringMVCConfig;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class EventsApplication implements CommandLineRunner, ApplicationContextAware {

	private ApplicationContext applicationContext;
	public static void main(String[] args) throws IOException, InterruptedException {

		SpringApplication.run(EventsApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		Server server = ServerBuilder
				.forPort(8087)
				.addService(new LoggingServiceImpl(applicationContext)).build();

		server.start();
		server.awaitTermination();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
}