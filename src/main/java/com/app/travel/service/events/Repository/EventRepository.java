package com.app.travel.service.events.Repository;

import com.app.travel.service.events.Model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}
