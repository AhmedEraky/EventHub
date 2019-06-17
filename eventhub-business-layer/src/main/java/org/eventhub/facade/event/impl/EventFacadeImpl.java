package org.eventhub.facade.event.impl;

import java.util.UUID;

import org.eventhub.common.model.entity.Event;
import org.eventhub.facade.event.EventFacade;
import org.eventhub.service.event.EventRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * facade for events
 * @author M. ALI
 */
@Component
public class EventFacadeImpl implements EventFacade {
	
	@Autowired
	EventRetrievalService eventService;
	
	/**
	 * get event by its id
	 * @param uuid id of the event
	 * @return event
	 * @author M. ALI
	 */
	public Event getById(UUID uuid) {
		return eventService.getById(uuid);
	}

}
