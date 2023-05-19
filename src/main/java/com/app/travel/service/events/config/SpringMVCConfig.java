package com.app.travel.service.events.config;

import com.app.travel.service.events.LoggingServiceImpl;
import com.app.travel.service.events.Model.Event;
import com.app.travel.service.events.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;


@Configuration
public class SpringMVCConfig {

    @Autowired
    private  EventRepository eventRepository;







}
