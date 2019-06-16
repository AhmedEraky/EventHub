package org.eventhub.service.event.impl;

import java.util.Optional;
import java.util.UUID;

import org.eventhub.common.model.entity.Event;
import org.eventhub.dal.dao.EventRepository;
import org.eventhub.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * service for events
 * @author M. ALI
 */
@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	EventRepository eventRepository;
	
	/**
	 * get event by its id
	 * @param uuid id of the event
	 * @return event
	 * @author M. ALI
	 */
	public Event getById(UUID uuid) {
		Optional<Event> optionalEvent = eventRepository.findById(uuid);
		Event event = null;
		if(optionalEvent.isPresent()) {
			event = optionalEvent.get();
		}
		return event;
	}
}
