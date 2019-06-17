package org.eventhub.service.event;

import java.util.UUID;

import org.eventhub.common.model.entity.Event;


/**
 * service for events
 * @author M. ALI
 */
public interface EventService {
	/**
	 * get event by its id
	 * @param uuid id of the event
	 * @return event
	 * @author M. ALI
	 */
	Event getById(UUID uuid);
}
