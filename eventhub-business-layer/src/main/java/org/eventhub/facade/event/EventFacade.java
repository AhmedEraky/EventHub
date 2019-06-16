package org.eventhub.facade.event;

import java.util.UUID;

import org.eventhub.common.model.entity.Event;

/**
 * facade for events
 * @author M. ALI
 */
public interface EventFacade {
	/**
	 * get event by its id
	 * @param uuid id of the event
	 * @return event
	 * @author M. ALI
	 */
	Event getById(UUID uuid);
}
